package fr.leprohon.esgi.al4.al.shopping.domain.event;

import fr.leprohon.esgi.al4.al.kernel.event.ApplicationEvent;

public class CreateContractEvent implements ApplicationEvent {
    public final Integer contractId;

    public CreateContractEvent(Integer contractId) {
        this.contractId = contractId;
    }
}
