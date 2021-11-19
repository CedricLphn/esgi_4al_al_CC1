package securepay.domain;

import securepay.infrastructure.ValidationCreditCardEngine;

public class Bank {
    private int id;
    private CreditCard card;
    private float amount;

    public Bank(int id, CreditCard card, float amount) {
        this.id = id;

        if(!ValidationCreditCardEngine.getInstance().test(card)) {
            throw new IllegalArgumentException("Invalid credit card");
        }

        this.card = card;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public CreditCard getCard() {
        return card;
    }

    public float getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", card=" + card +
                ", amount=" + amount +
                '}';
    }
}
