package securepay.domain;

import common.annotations.Entity;
import securepay.infrastructure.ValidationCreditCardEngine;

import java.util.Date;

@Entity
public class CreditCard {
    private long number;
    private Date expiration;
    private int CVV;

    private CreditCard(long number, Date expiration, int CVV) {
        this.number = number;
        this.expiration = expiration;
        this.CVV = CVV;
    }

    public static CreditCard of(long number, Date expiration, int CVV) {
        CreditCard creditCard = new CreditCard(number, expiration, CVV);
        if(!ValidationCreditCardEngine.getInstance().test(creditCard)) {
            throw new IllegalArgumentException("Invalid credit card");
        }

        return creditCard;
    }

    public long getNumber() {
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
