package fr.leprohon.esgi.al4.al.securepay.domain.payload;

import fr.leprohon.esgi.al4.al.kernel.service.Log;
import fr.leprohon.esgi.al4.al.kernel.service.SerializationEngine;
import fr.leprohon.esgi.al4.al.kernel.service.SerializationFactory;
import fr.leprohon.esgi.al4.al.kernel.event.DefaultEventBus;
import fr.leprohon.esgi.al4.al.kernel.event.SubscribeMembershipEvent;
import fr.leprohon.esgi.al4.al.kernel.event.Subscriber;
import fr.leprohon.esgi.al4.al.securepay.domain.repository.HistoryTransactionRepository;
import fr.leprohon.esgi.al4.al.securepay.domain.command.CreateTransaction;
import fr.leprohon.esgi.al4.al.securepay.domain.command.UpdateStatus;
import fr.leprohon.esgi.al4.al.securepay.domain.command.PaymentHandler;
import fr.leprohon.esgi.al4.al.securepay.domain.entity.HistoryTransaction;
import fr.leprohon.esgi.al4.al.securepay.domain.repository.PaymentTransaction;
import fr.leprohon.esgi.al4.al.shopping.domain.payload.ApplyMembership;
import fr.leprohon.esgi.al4.al.shopping.domain.utils.Status;
import fr.leprohon.esgi.al4.al.shopping.domain.service.SubscriptionEventService;
import fr.leprohon.esgi.al4.al.kernel.event.PaymentTransactionEvent;

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
            //paymentHandler.add(new UpdateStatus(this.transaction, Status.ACCEPTED));
            //paymentHandler.add(new CreateTransaction(this.transaction, repository));
            //paymentHandler.handle();

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
