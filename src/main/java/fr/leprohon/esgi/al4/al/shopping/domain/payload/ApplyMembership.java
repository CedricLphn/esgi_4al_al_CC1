package fr.leprohon.esgi.al4.al.shopping.domain.payload;

import fr.leprohon.esgi.al4.al.kernel.service.Log;
import fr.leprohon.esgi.al4.al.kernel.service.SerializationFactory;
import fr.leprohon.esgi.al4.al.kernel.event.SubscribeMembershipEvent;
import fr.leprohon.esgi.al4.al.securepay.domain.entity.HistoryTransaction;
import fr.leprohon.esgi.al4.al.securepay.domain.payload.HistoryTransactionTypeAdapter;
import fr.leprohon.esgi.al4.al.securepay.domain.repository.PaymentTransaction;
import fr.leprohon.esgi.al4.al.shopping.domain.service.ContractService;
import fr.leprohon.esgi.al4.al.shopping.domain.utils.Status;
import fr.leprohon.esgi.al4.al.shopping.domain.command.SubscriptionHandler;
import fr.leprohon.esgi.al4.al.shopping.domain.command.UpdateContractRepository;
import fr.leprohon.esgi.al4.al.shopping.domain.command.UpdateObjectStatusContract;
import fr.leprohon.esgi.al4.al.shopping.domain.entity.Contract;

import java.util.UUID;

public class ApplyMembership extends PaymentTransaction {

    ContractService service;

    public ApplyMembership(Log logger, ContractService service) {
        super(logger);
        this.service = service;
    }

    @Override
    public HistoryTransaction validation(SubscribeMembershipEvent subscribeMembershipEvent) {

        logger.log("Apply Membership");
        logger.log(subscribeMembershipEvent.getJsonContract());

        HistoryTransaction transaction = SerializationFactory.fromJSON(subscribeMembershipEvent.getJsonContract(),
                HistoryTransaction.class, new HistoryTransactionTypeAdapter());

        try {
            logger.log("Update Contract");

            UUID id = transaction.getContractId();


            Contract currentContract = service.findByContractId(id);

            transaction.setStatus(Status.ACCEPTED);

            SubscriptionHandler root = new SubscriptionHandler(currentContract);
            //root.add(new UpdateObjectStatusContract(currentContract, transaction.getStatus()));
            //root.add(new UpdateContractRepository(currentContract, service));
            //root.handle();

            send();


        }catch (Exception e) {
            logger.log("Failed to update status : " + e.getMessage());
        }

        return transaction;

    }

    @Override
    protected void send() {
        logger.log("Done.");
    }
}
