package securepay.domain.payload;

import common.service.Log;
import common.service.SerializationEngine;
import common.service.SerializationFactory;
import event.DefaultEventBus;
import event.SubscribeMembershipEvent;
import event.Subscriber;
import securepay.domain.repository.HistoryTransactionRepository;
import securepay.domain.command.CreateTransaction;
import securepay.domain.command.UpdateStatus;
import securepay.domain.command.PaymentHandler;
import securepay.domain.entity.HistoryTransaction;
import securepay.domain.repository.PaymentTransaction;
import shopping.domain.payload.ApplyMembership;
import shopping.domain.utils.Status;
import shopping.domain.service.SubscriptionEventService;
import event.PaymentTransactionEvent;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static java.lang.Thread.sleep;

public class DummyPaymentTransaction extends PaymentTransaction {

    private final HistoryTransactionRepository repository;
    private HistoryTransaction transaction;

    public DummyPaymentTransaction(Log logger, HistoryTransactionRepository repository) {
        super(logger);
        this.repository = repository;
    }



    @Override
    public HistoryTransaction validation(SubscribeMembershipEvent subscribeMembershipEvent) {

        logger.log("Dummy payment Transaction init");
        try {
            sleep(1500); // Simulation !!
            logger.log("Payment accepted");

            HistoryTransaction transaction = SerializationFactory.fromJSON(subscribeMembershipEvent.getJsonContract(),
                    HistoryTransaction.class, new HistoryTransactionTypeAdapter());

            this.transaction = transaction;

            PaymentHandler paymentHandler = new PaymentHandler(this.transaction);
            paymentHandler.add(new UpdateStatus(this.transaction, Status.ACCEPTED));
            paymentHandler.add(new CreateTransaction(this.transaction, repository));
            paymentHandler.handle();

            send();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return transaction;
    }

    @Override
    protected void send() {

        Map<Class<SubscribeMembershipEvent>, List<Subscriber>> payload =
                Collections.singletonMap(SubscribeMembershipEvent.class,
                        List.of(
                                new PaymentTransactionEvent(new ApplyMembership(logger, null)
                                )));

        DefaultEventBus bus = new DefaultEventBus(payload);
        SubscriptionEventService shoppingRegisterService = new SubscriptionEventService(bus, logger);

        SerializationEngine<HistoryTransaction> jsonFactory = SerializationFactory.toJSON(HistoryTransaction.class, new HistoryTransactionTypeAdapter());
        String sendingInformation = jsonFactory.apply(this.transaction);

        //shoppingRegisterService.register(sendingInformation);
    }
}
