package securepay.domain;

import common.annotations.Entity;
import securepay.infrastructure.ValidationCreditCardEngine;

import java.time.Instant;
import java.util.Date;

@Entity
public class CreditCard {
    private final String number;
    private final Date expiration;
    private final int CVV;

    private CreditCard(String number, Date expiration, int CVV) {
        this.number = number;
        this.expiration = expiration;
        this.CVV = CVV;
    }

    public static CreditCard of(String number, Date expiration, int CVV) {
        CreditCard creditCard = new CreditCard(number, expiration, CVV);
        if(!ValidationCreditCardEngine.getInstance().test(creditCard) ) { // TODO : expiration < Date aujd
            throw new IllegalArgumentException("Invalid credit card");
        }

        return creditCard;
    }

    public String getNumber() {
        return number;
    }

    public Date getExpiration() {
        return expiration;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "number=" + number +
                ", expiration=" + expiration +
                ", CVV=" + CVV +
                '}';
    }
}
