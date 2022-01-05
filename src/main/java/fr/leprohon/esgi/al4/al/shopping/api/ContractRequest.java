package fr.leprohon.esgi.al4.al.shopping.api;

import fr.leprohon.esgi.al4.al.shopping.domain.entity.User;
import fr.leprohon.esgi.al4.al.shopping.domain.utils.ContractType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ContractRequest {
    @NotNull
    @NotBlank
    private ContractType type;

    @NotNull
    @NotBlank
    private User user;
}
