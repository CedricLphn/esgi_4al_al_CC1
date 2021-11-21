package securepay.domain.repository;

import common.service.Log;
import event.SubscribeMembershipEvent;
import securepay.domain.entity.HistoryTransaction;

public abstract class PaymentTransaction {

    protected final Log logger;

    public PaymentTransaction(Log logger) {
        this.logger = logger;
    }

    public abstract HistoryTransaction validation(SubscribeMembershipEvent subscribeMembershipEvent);

    protected abstract void send();


}
