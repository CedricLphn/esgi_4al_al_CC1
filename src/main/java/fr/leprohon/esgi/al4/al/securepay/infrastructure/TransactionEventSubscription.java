package fr.leprohon.esgi.al4.al.securepay.infrastructure;

import fr.leprohon.esgi.al4.al.kernel.event.Subscriber;
import fr.leprohon.esgi.al4.al.securepay.domain.repository.PaymentTransaction;
import fr.leprohon.esgi.al4.al.kernel.event.SubscribeMembershipEvent;

public class TransactionEventSubscription implements Subscriber<SubscribeMembershipEvent> {

    private final PaymentTransaction transaction;

    public TransactionEventSubscription(PaymentTransaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public void accept(SubscribeMembershipEvent subscribeMembershipEvent) {
        transaction.validation(subscribeMembershipEvent);
    }
}
