package fr.leprohon.esgi.al4.al.securepay.infrastructure.engine;

import fr.leprohon.esgi.al4.al.securepay.domain.entity.CreditCard;
import fr.leprohon.esgi.al4.al.kernel.utils.CardType;

public class CardTypeEngine {


    public CardTypeEngine() {
        throw new AssertionError();
    }

    public static CardType detect(CreditCard creditCard) {
        String number = creditCard.number;
        String s = String.valueOf(number);
        if(s.startsWith("4")) {
            return CardType.VISA;
        }else if(s.startsWith("5")) {
            return CardType.MASTERCARD;
        }

        return CardType.UNKNOWN;
    }

}
