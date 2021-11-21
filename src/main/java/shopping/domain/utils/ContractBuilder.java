package shopping.domain.utils;

import securepay.domain.entity.CreditCard;
import shopping.domain.entity.Contract;
import shopping.domain.entity.User;

public class ContractBuilder {
    protected Contract contract = new Contract();

    public ContractBuilder() {
        this.contract.setUser(new User());
        this.contract.getUser().setCreditCard(new CreditCard());
    }

    public UserInformationBuilder User() {
        return new UserInformationBuilder(contract);
    }

    public CreditCardBuilder Payment() {
        return new CreditCardBuilder(contract);
    }

    public SubscriptionBuilder Subscription() {
        return new SubscriptionBuilder(contract);
    }

    public Contract build() {
        return contract;
    }

}
