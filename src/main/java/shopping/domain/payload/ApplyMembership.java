package shopping.domain.payload;

import common.service.Log;
import common.service.SerializationFactory;
import event.SubscribeMembershipEvent;
import securepay.domain.entity.HistoryTransaction;
import securepay.domain.payload.HistoryTransactionTypeAdapter;
import securepay.domain.repository.PaymentTransaction;
import shopping.domain.service.ContractService;
import shopping.domain.utils.Status;
import shopping.domain.command.SubscriptionHandler;
import shopping.domain.command.UpdateContractRepository;
import shopping.domain.command.UpdateObjectStatusContract;
import shopping.domain.entity.Contract;

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
            root.add(new UpdateObjectStatusContract(currentContract, transaction.getStatus()));
            root.add(new UpdateContractRepository(currentContract, service));
            root.handle();

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
