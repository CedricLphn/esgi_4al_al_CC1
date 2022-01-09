package fr.leprohon.esgi.al4.al.securepay.api;

import fr.leprohon.esgi.al4.al.shopping.application.CreditCardRequest;

import java.io.Serializable;
import java.util.UUID;

public class PaymentRequest implements Serializable {
    public CreditCardRequest creditCard;
    public int amount;

    @Override
    public String toString() {
        return "PaymentRequest{" +
                ", creditCard=" + creditCard +
                ", amount=" + amount +
                '}';
    }
}
