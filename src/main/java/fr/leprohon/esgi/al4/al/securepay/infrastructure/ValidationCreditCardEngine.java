package fr.leprohon.esgi.al4.al.securepay.infrastructure;

import fr.leprohon.esgi.al4.al.securepay.domain.entity.CreditCard;
import fr.leprohon.esgi.al4.al.kernel.utils.CardType;
import fr.leprohon.esgi.al4.al.securepay.infrastructure.engine.CardTypeEngine;

import java.util.function.Predicate;

public class ValidationCreditCardEngine implements Predicate<CreditCard> {

    private static final ValidationCreditCardEngine INSTANCE = new ValidationCreditCardEngine();

    private ValidationCreditCardEngine() {
    }

    public static ValidationCreditCardEngine getInstance() {
        return INSTANCE;
    }

    public static CardType detect(CreditCard card) {
        return CardTypeEngine.detect(card);
    }

    @Override
    public boolean test(CreditCard card) {
        if(detect(card) == CardType.UNKNOWN) {
            return false;
        }

        int sum = 0;
        boolean alternate = false;
        for(int i = String.valueOf(card.getNumber()).length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(String.valueOf(card.getNumber()).substring(i, i+1));
            if(alternate) {
                n *= 2;
                if(n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }

        return sum % 10 == 0;
    }
}
