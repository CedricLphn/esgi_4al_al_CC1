package fr.leprohon.esgi.al4.al.shopping.domain.entity;

import fr.leprohon.esgi.al4.al.kernel.annotations.Entity;
import fr.leprohon.esgi.al4.al.securepay.domain.entity.CreditCard;

@Entity
public final class User {
    private String firstname;
    private String lastname;
    private int age;
    private CreditCard creditCard;

    public User(String firstname, String lastname, int age, CreditCard creditCard) {
        this.firstname = firstname;
        this.lastname = lastname;

        if(age < 13) {
            throw new IllegalStateException("You must provide a valid age and > 13 years old");
        }

        this.age = age;
        this.creditCard = creditCard;
    }

    public User() {
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

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }


    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", creditCard=" + creditCard +
                '}';
    }
}
