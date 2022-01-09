package fr.leprohon.esgi.al4.al.shopping.domain.command;

import fr.leprohon.esgi.al4.al.kernel.infrastructure.Command;
import fr.leprohon.esgi.al4.al.shopping.domain.utils.Status;

public class ModifyStatusContract implements Command {
    public final Integer id;
    public final Status status;

    public ModifyStatusContract(Integer contractId, Status refused) {
        id = contractId;
        status = refused;
    }
}
