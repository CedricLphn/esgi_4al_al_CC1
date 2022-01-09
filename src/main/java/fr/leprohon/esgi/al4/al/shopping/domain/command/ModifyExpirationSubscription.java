package fr.leprohon.esgi.al4.al.shopping.domain.command;

import fr.leprohon.esgi.al4.al.kernel.infrastructure.Command;

import java.util.Date;
import java.util.UUID;

public class ModifyExpirationSubscription implements Command {
    public final UUID contract;
    public final Date date;

    public ModifyExpirationSubscription(UUID contract, Date date) {
        this.contract = contract;
        this.date = date;
    }
}
