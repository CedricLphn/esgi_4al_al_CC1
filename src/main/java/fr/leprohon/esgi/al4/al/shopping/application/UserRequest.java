package fr.leprohon.esgi.al4.al.shopping.application;

import javax.validation.constraints.NotNull;

public class UserRequest {

    @NotNull
    public String firstname;

    @NotNull
    public String lastname;

    @NotNull
    public int age;
}
