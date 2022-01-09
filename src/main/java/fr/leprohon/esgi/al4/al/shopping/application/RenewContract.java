package fr.leprohon.esgi.al4.al.shopping.application;

import fr.leprohon.esgi.al4.al.kernel.event.CommandBus;
import fr.leprohon.esgi.al4.al.kernel.event.QueryBus;
import fr.leprohon.esgi.al4.al.kernel.service.Log;
import fr.leprohon.esgi.al4.al.shopping.domain.command.CallPayload;
import fr.leprohon.esgi.al4.al.shopping.domain.command.ModifyContract;
import fr.leprohon.esgi.al4.al.shopping.domain.command.ModifyExpirationSubscription;
import fr.leprohon.esgi.al4.al.shopping.domain.command.ModifyStatusContract;
import fr.leprohon.esgi.al4.al.shopping.domain.entity.Contract;
import fr.leprohon.esgi.al4.al.shopping.domain.query.RetrieveContractsByExpirationDate;
import fr.leprohon.esgi.al4.al.shopping.domain.query.RetrieveContractsByStatus;
import fr.leprohon.esgi.al4.al.shopping.domain.repository.ContractRepository;
import fr.leprohon.esgi.al4.al.shopping.domain.utils.Status;
import fr.leprohon.esgi.al4.al.shopping.domain.utils.SubscriptionMilliseconds;
import fr.leprohon.esgi.al4.al.shopping.infrastructure.utils.PaymentInformation;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@EnableScheduling
@SuppressWarnings("all")
public class RenewContract {

    private final CommandBus commandBus;
    private final QueryBus queryBus;
    private final Log logger;
    private final ContractRepository repository;

    public RenewContract(CommandBus commandBus, QueryBus queryBus, Log logger, ContractRepository repository) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
        this.logger = logger;
        this.repository = repository;
    }

    @Scheduled(fixedDelay = 10000)
    public void apply() {
        logger.log("Checking contract for renewal");
        List<Contract> newContracts = queryBus.send(new RetrieveContractsByStatus(Status.NEW));
        List<Contract> refusedContracts = queryBus.send(new RetrieveContractsByStatus(Status.REFUSED));
        List<Contract> expiredContracts = queryBus.send(new RetrieveContractsByExpirationDate(new Date(System.currentTimeMillis())));

        List<Contract> contracts = new ArrayList<>();
        contracts.addAll(newContracts);
        contracts.addAll(refusedContracts);
        contracts.addAll(expiredContracts);

        for(Contract contract : contracts) {
            CreditCardRequest creditCardRequest = new CreditCardRequest(contract.getUser().getCreditCard().number, contract.getUser().getCreditCard().expiration.toString(), contract.getUser().getCreditCard().CVV);
            PaymentInformation request = new PaymentInformation(creditCardRequest, contract.getAmount());
            if(queryBus.send(new CallPayload(request))) {
                contract.setExpiration(new Date(System.currentTimeMillis() + SubscriptionMilliseconds.MONTHS.getLong()));
                contract.setPaymentStatus(Status.ACCEPTED);
                commandBus.send(new ModifyContract(contract));
            }

        }

        //logger.log(contracts.toString());
    }
}
