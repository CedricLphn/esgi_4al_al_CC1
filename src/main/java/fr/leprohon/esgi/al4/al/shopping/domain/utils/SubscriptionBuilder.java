package fr.leprohon.esgi.al4.al.shopping.domain.utils;

import fr.leprohon.esgi.al4.al.shopping.domain.entity.Contract;
import fr.leprohon.esgi.al4.al.shopping.domain.entity.User;

import java.util.Date;

public class SubscriptionBuilder extends ContractBuilder {
    public SubscriptionBuilder(Contract contract) {
        this.contract = contract;
    }

    public SubscriptionBuilder amount(int amount) {
        this.contract.setAmount(amount);
        return this;
    }

    public SubscriptionBuilder type(ContractType type) {
        this.contract.setType(type);
        return this;
    }

    public SubscriptionBuilder status(Status status) {
        this.contract.setPaymentStatus(status);
        return this;
    }

    public SubscriptionBuilder expiration(Date date) {
        this.contract.setExpiration(date);
        return this;
    }

}
