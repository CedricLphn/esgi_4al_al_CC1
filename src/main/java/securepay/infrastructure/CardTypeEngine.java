package securepay.infrastructure;

import securepay.domain.CreditCard;

import java.util.regex.Pattern;

public class CardTypeEngine {


    public CardTypeEngine() {
        throw new AssertionError();
    }

    public static CardType detect(CreditCard creditCard) {
        long number = creditCard.getNumber(); // TODO : mettre directement en string ?
        String s = String.valueOf(number);
        if(s.startsWith("4")) {
            return CardType.VISA;
        }else if(s.startsWith("5")) {
            return CardType.MASTERCARD;
        }

        return CardType.UNKNOWN;
    }

}
