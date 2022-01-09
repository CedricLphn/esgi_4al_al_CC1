package fr.leprohon.esgi.al4.al.securepay.domain.entity;

import fr.leprohon.esgi.al4.al.kernel.annotations.Entity;
import fr.leprohon.esgi.al4.al.securepay.infrastructure.ValidationCreditCardEngine;

import java.time.ZonedDateTime;

@Entity
public final class CreditCard {
    public final String number;
    public final ZonedDateTime expiration;
    public final int CVV;

    private CreditCard(String number, ZonedDateTime expiration, int CVV) {
        this.number = number;
        this.expiration = expiration;
        this.CVV = CVV;
    }

    public static CreditCard of(String number, ZonedDateTime expiration, int CVV) {
        CreditCard creditCard = new CreditCard(number, expiration, CVV);
        if(!ValidationCreditCardEngine.getInstance().test(creditCard) ) {
            throw new IllegalArgumentException("Invalid credit card");
        }

        return creditCard;
    }

    public static CreditCard of() {
        return new CreditCard(null, null, 0);
    }

    public CreditCard setNumber(String number) {
        return CreditCard.of(number, this.expiration, this.CVV);
    }

    public CreditCard setExpiration(ZonedDateTime time) {
        return CreditCard.of(this.number, time, this.CVV);
    }

    public CreditCard setCVV(int CVV) {
        return CreditCard.of(this.number, this.expiration, CVV);
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
