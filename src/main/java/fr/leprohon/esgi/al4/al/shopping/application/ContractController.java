package fr.leprohon.esgi.al4.al.shopping.application;

import fr.leprohon.esgi.al4.al.kernel.event.CommandBus;
import fr.leprohon.esgi.al4.al.kernel.event.QueryBus;
import fr.leprohon.esgi.al4.al.kernel.exception.NoSuchEntityException;
import fr.leprohon.esgi.al4.al.kernel.service.Log;
import fr.leprohon.esgi.al4.al.shopping.domain.command.CreateContract;
import fr.leprohon.esgi.al4.al.shopping.domain.command.ModifyStatusContract;
import fr.leprohon.esgi.al4.al.shopping.domain.entity.Contract;
import fr.leprohon.esgi.al4.al.shopping.domain.query.RetrieveContract;
import fr.leprohon.esgi.al4.al.shopping.domain.utils.Status;
import fr.leprohon.esgi.al4.al.shopping.domain.utils.SubscriptionMilliseconds;
import fr.leprohon.esgi.al4.al.shopping.infrastructure.utils.PaymentInformation;
import fr.leprohon.esgi.al4.al.shopping.infrastructure.utils.RestService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.time.ZonedDateTime;
import java.util.Date;

@RestController
@RequestMapping("/api/v1/contract")
public class ContractController {
    private final CommandBus commandBus;
    private final QueryBus queryBus;
    private final Log logger;

    public ContractController(CommandBus commandBus, QueryBus queryBus, Log logger) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
        this.logger = logger;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createContract(@RequestBody @Valid CreateContractRequest contract) {
        try {
            Date subscriptionExpiration = null;
            if(!contract.noSubscription) {
                subscriptionExpiration = new Date(System.currentTimeMillis() + SubscriptionMilliseconds.MONTHS.getLong()); // +1 month
            }

            CreateContract createContract = new CreateContract(
                    contract.type,
                    contract.user.firstname,
                    contract.user.lastname,
                    contract.user.age,
                    contract.creditcard.number,
                    ZonedDateTime.parse(contract.creditcard.expiration),
                    contract.creditcard.cvv,
                    contract.amount,
                    subscriptionExpiration
            );

            Integer contractId = commandBus.send(createContract);

            RestService restService = new RestService(new RestTemplateBuilder());
            if(restService.createPost(new PaymentInformation(contract.creditcard, contract.amount))) {
                commandBus.send(new ModifyStatusContract(contractId, Status.ACCEPTED));
            }else {
                commandBus.send(new ModifyStatusContract(contractId, Status.REFUSED));
            }
            return ResponseEntity.created(URI.create("/" + contractId.toString())).build();

        }catch (Exception e) {
            logger.log(e.getMessage());
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contract> getContract(@PathVariable("id") int id) {

        try {
            RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
            RestService restService = new RestService(restTemplateBuilder);

            final Contract contract = queryBus.send(new RetrieveContract(id));
            if(contract != null) {
                logger.log("Get contract no " + contract.getId());
            }else {
                throw new NoSuchEntityException("No contract with id " + contract.getId());
            }
            return ResponseEntity.ok(contract);
        }catch (Exception e) {
            logger.log(e.getMessage());
        }

        return ResponseEntity.badRequest().build();

    }

}
