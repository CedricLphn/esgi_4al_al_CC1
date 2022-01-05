package fr.leprohon.esgi.al4.al.shopping.domain.utils;

import fr.leprohon.esgi.al4.al.securepay.domain.entity.CreditCard;
import fr.leprohon.esgi.al4.al.shopping.domain.entity.Contract;
import fr.leprohon.esgi.al4.al.shopping.domain.entity.User;

public class ContractBuilder {
    protected Contract contract = new Contract();

    public ContractBuilder() {
        this.contract.setUser(new User());
        this.contract.getUser().setCreditCard(CreditCard.of());
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
