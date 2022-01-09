package fr.leprohon.esgi.al4.al.shopping.infrastructure.utils;

import fr.leprohon.esgi.al4.al.shopping.application.CreditCardRequest;

import javax.validation.constraints.NotNull;

public class PaymentInformation {
    @NotNull
    public final CreditCardRequest creditCard;
    @NotNull
    public final int amount;

    public PaymentInformation(CreditCardRequest creditCard, int amount) {
        this.creditCard = creditCard;
        this.amount = amount;
    }
}
