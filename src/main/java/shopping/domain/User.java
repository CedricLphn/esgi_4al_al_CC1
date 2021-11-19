package shopping.domain;

import common.annotations.Entity;

@Entity
public final class User {
    public int id;
    private final String firstname;
    private final String lastname;
    private final int age;
    private final String cardNumber; // Todo : Card Builder ??

    public User(String firstname, String lastname, int age, String cardNumber) {
        this.firstname = firstname;
        this.lastname = lastname;

        if(age < 13) {
            throw new IllegalStateException("You must provide a valid age and > 13 years old");
        }

        this.age = age;
        this.cardNumber = cardNumber;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }
}
