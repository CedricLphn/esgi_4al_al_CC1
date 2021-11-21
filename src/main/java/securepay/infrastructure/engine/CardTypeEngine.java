package securepay.infrastructure.engine;

import securepay.domain.entity.CreditCard;
import securepay.domain.utils.CardType;

public class CardTypeEngine {


    public CardTypeEngine() {
        throw new AssertionError();
    }

    public static CardType detect(CreditCard creditCard) {
        String number = creditCard.getNumber();
        String s = String.valueOf(number);
        if(s.startsWith("4")) {
            return CardType.VISA;
        }else if(s.startsWith("5")) {
            return CardType.MASTERCARD;
        }

        return CardType.UNKNOWN;
    }

}
