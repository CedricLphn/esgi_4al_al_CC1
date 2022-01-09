package fr.leprohon.esgi.al4.al.shopping.application;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class CreditCardRequest implements Serializable {

    @NotNull
    public String number;

    @NotNull
    public String expiration;

    @NotNull
    public int cvv;

    public CreditCardRequest() {
    }

    public CreditCardRequest(String number, String expiration, int cvv) {
        this.number = number;
        this.expiration = expiration;
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "CreditCardRequest{" +
                "number='" + number + '\'' +
                ", expiration='" + expiration + '\'' +
                ", cvv=" + cvv +
                '}';
    }
}
