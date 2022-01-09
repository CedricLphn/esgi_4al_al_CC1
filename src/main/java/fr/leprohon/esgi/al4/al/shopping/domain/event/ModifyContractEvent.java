package fr.leprohon.esgi.al4.al.shopping.domain.event;

import fr.leprohon.esgi.al4.al.kernel.event.ApplicationEvent;

import java.util.UUID;

public class ModifyContractEvent implements ApplicationEvent {

    public final UUID uuid;

    public ModifyContractEvent(UUID uuid) {
        this.uuid = uuid;
    }
}
