package fr.leprohon.esgi.al4.al.securepay.domain.repository;

import fr.leprohon.esgi.al4.al.kernel.service.Log;
import fr.leprohon.esgi.al4.al.kernel.event.SubscribeMembershipEvent;
import fr.leprohon.esgi.al4.al.securepay.domain.entity.HistoryTransaction;

public abstract class PaymentTransaction {

    protected final Log logger;

    public PaymentTransaction(Log logger) {
        this.logger = logger;
    }

    public abstract HistoryTransaction validation(SubscribeMembershipEvent subscribeMembershipEvent);

    protected abstract void send();


}
