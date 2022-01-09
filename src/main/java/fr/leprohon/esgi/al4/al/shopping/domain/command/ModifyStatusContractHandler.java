package fr.leprohon.esgi.al4.al.shopping.domain.command;

import fr.leprohon.esgi.al4.al.kernel.event.EventDispatcher;
import fr.leprohon.esgi.al4.al.kernel.infrastructure.CommandHandler;
import fr.leprohon.esgi.al4.al.shopping.domain.entity.Contract;
import fr.leprohon.esgi.al4.al.shopping.domain.repository.ContractRepository;

public class ModifyStatusContractHandler implements CommandHandler<ModifyStatusContract, Void> {

    private final ContractRepository contractRepository;
    private final EventDispatcher eventDispatcher;

    public ModifyStatusContractHandler(ContractRepository contractRepository, EventDispatcher eventDispatcher) {
        this.contractRepository = contractRepository;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public Void handle(ModifyStatusContract command) {
        Contract contract = contractRepository.findById(command.id);
        contract.setPaymentStatus(command.status);
        contractRepository.add(contract);
        return null;
    }
}
