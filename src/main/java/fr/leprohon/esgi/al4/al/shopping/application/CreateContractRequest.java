package fr.leprohon.esgi.al4.al.shopping.application;

import fr.leprohon.esgi.al4.al.shopping.domain.utils.ContractType;

import javax.validation.constraints.NotNull;

public class CreateContractRequest {

    @NotNull
    public ContractType type;

    @NotNull
    public UserRequest user;

    @NotNull
    public CreditCardRequest creditcard;

    @NotNull
    public int amount;

    public boolean noSubscription;

}
