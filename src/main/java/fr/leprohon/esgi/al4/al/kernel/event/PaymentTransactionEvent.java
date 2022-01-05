package fr.leprohon.esgi.al4.al.kernel.event;

import fr.leprohon.esgi.al4.al.securepay.domain.repository.PaymentTransaction;

public class PaymentTransactionEvent implements Subscriber<SubscribeMembershipEvent> {

    public final PaymentTransaction transaction;

    public PaymentTransactionEvent(PaymentTransaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public void accept(SubscribeMembershipEvent subscribeMembershipEvent) {
        transaction.validation(subscribeMembershipEvent);
    }
}
