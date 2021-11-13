package shopping.domain;

import shopping.kernel.annotations.Entity;

@Entity
public class User {
    private String firstname;
    private String lastname;
    private String cardNumber; // Todo : Card Builder ??
}
