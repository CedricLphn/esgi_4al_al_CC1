package securepay.domain.entity;

import common.annotations.Entity;
import securepay.infrastructure.ValidationCreditCardEngine;

import java.time.ZonedDateTime;

@Entity
public class CreditCard {
    private String number;
    private ZonedDateTime expiration;
    private int CVV;

    private CreditCard(String number, ZonedDateTime expiration, int CVV) {
        this.number = number;
        this.expiration = expiration;
        this.CVV = CVV;
    }

    public CreditCard() {
    }

    public static CreditCard of(String number, ZonedDateTime expiration, int CVV) {
        CreditCard creditCard = new CreditCard(number, expiration, CVV);
        if(!ValidationCreditCardEngine.getInstance().test(creditCard) ) {
            throw new IllegalArgumentException("Invalid credit card");
        }

        return creditCard;
    }

    public String getNumber() {
        return number;
    }

    public ZonedDateTime getExpiration() {
        return expiration;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setExpiration(ZonedDateTime expiration) {
        this.expiration = expiration;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
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
