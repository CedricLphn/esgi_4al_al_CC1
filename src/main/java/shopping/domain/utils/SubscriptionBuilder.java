package shopping.domain.utils;

import shopping.domain.entity.Contract;

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

}
