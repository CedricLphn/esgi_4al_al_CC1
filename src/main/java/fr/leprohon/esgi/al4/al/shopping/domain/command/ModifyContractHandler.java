package fr.leprohon.esgi.al4.al.shopping.domain.command;

import fr.leprohon.esgi.al4.al.kernel.event.Event;
import fr.leprohon.esgi.al4.al.kernel.event.EventDispatcher;
import fr.leprohon.esgi.al4.al.kernel.infrastructure.CommandHandler;
import fr.leprohon.esgi.al4.al.kernel.service.Log;
import fr.leprohon.esgi.al4.al.shopping.domain.event.ModifyContractEvent;
import fr.leprohon.esgi.al4.al.shopping.domain.repository.ContractRepository;

public class ModifyContractHandler implements CommandHandler<ModifyContract, Boolean> {

    private final Log logger;
    private final ContractRepository contractRepository;
    private final EventDispatcher<Event> dispatcher;

    public ModifyContractHandler(Log logger, ContractRepository contractRepository, EventDispatcher<Event> dispatcher) {
        this.logger = logger;
        this.contractRepository = contractRepository;
        this.dispatcher = dispatcher;
    }

    @Override
    public Boolean handle(ModifyContract command) {
        contractRepository.update(contractRepository.findInternalId(command.contract.getId()), command.contract);
        dispatcher.dispatch(new ModifyContractEvent(command.contract.getId()));
        return true;
    }
}
