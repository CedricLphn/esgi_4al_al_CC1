package fr.leprohon.esgi.al4.al.shopping.domain.utils;

import fr.leprohon.esgi.al4.al.shopping.domain.entity.Contract;

import java.time.ZonedDateTime;

public class CreditCardBuilder extends ContractBuilder {
    public CreditCardBuilder(Contract contract) {
        this.contract = contract;
    }

    public CreditCardBuilder cardNumber(String cn) {
        this.contract.getUser().getCreditCard().setNumber(cn);
        return this;
    }

    public CreditCardBuilder CVV(int cvv) {
        this.contract.getUser().getCreditCard().setCVV(cvv);
        return this;
    }

    public CreditCardBuilder expirationDate(ZonedDateTime expiration) {
        this.contract.getUser().getCreditCard().setExpiration(expiration);
        return this;
    }

}
