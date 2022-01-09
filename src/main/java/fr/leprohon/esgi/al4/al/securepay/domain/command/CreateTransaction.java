package fr.leprohon.esgi.al4.al.securepay.domain.command;

import fr.leprohon.esgi.al4.al.kernel.infrastructure.Command;
import fr.leprohon.esgi.al4.al.securepay.domain.entity.CreditCard;

import java.util.UUID;

public class CreateTransaction implements Command {

    public CreditCard creditCard;
    public int amount;

    public CreateTransaction(CreditCard creditCard, int amount) {
        this.creditCard = creditCard;
        this.amount = amount;
    }
}
