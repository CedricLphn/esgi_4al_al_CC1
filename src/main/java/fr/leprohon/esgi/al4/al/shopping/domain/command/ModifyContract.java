package fr.leprohon.esgi.al4.al.shopping.domain.command;

import fr.leprohon.esgi.al4.al.kernel.infrastructure.Command;
import fr.leprohon.esgi.al4.al.shopping.domain.entity.Contract;

public class ModifyContract implements Command {

    public final Contract contract;

    public ModifyContract(Contract contract) {
        this.contract = contract;
    }
}
