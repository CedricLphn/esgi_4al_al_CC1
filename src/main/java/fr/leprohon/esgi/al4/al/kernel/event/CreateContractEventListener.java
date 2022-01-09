package fr.leprohon.esgi.al4.al.kernel.event;

import fr.leprohon.esgi.al4.al.kernel.service.Log;
import fr.leprohon.esgi.al4.al.shopping.domain.event.CreateContractEvent;

public class CreateContractEventListener implements EventListener<CreateContractEvent> {

    private final Log logger;

    public CreateContractEventListener(Log logger) {
        this.logger = logger;
    }

    @Override
    public void listenTo(CreateContractEvent event) {
        logger.log("A contract was created " + event.contractId);
    }
}
