package securepay.infrastructure;

import event.Subscriber;
import securepay.domain.repository.PaymentTransaction;
import event.SubscribeMembershipEvent;

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
