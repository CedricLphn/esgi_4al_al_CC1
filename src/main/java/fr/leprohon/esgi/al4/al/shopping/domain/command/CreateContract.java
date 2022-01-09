package fr.leprohon.esgi.al4.al.shopping.domain.command;

import fr.leprohon.esgi.al4.al.kernel.infrastructure.Command;
import fr.leprohon.esgi.al4.al.shopping.domain.utils.ContractType;

import java.time.ZonedDateTime;
import java.util.Date;

public class CreateContract implements Command {

    public final ContractType type;
    public final String firstname;
    public final String lastName;
    public final int age;
    public final String cardNumber;
    public final ZonedDateTime cardExpiration;
    public final int cvv;
    public final int amount;
    public final Date subscriptionExpiration;

    public CreateContract(ContractType type, String firstname, String lastName, int age, String cardNumber, ZonedDateTime cardExpiration, int CVV, int amount, Date subscriptionExpiration) {
        this.type = type;
        this.firstname = firstname;
        this.lastName = lastName;
        this.age = age;
        this.cardNumber = cardNumber;
        this.cardExpiration = cardExpiration;
        this.cvv = CVV;
        this.amount = amount;
        this.subscriptionExpiration = subscriptionExpiration;
    }
}
