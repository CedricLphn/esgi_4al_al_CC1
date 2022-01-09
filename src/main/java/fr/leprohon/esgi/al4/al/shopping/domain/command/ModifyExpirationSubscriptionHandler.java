package fr.leprohon.esgi.al4.al.shopping.domain.command;

import fr.leprohon.esgi.al4.al.kernel.infrastructure.CommandHandler;
import fr.leprohon.esgi.al4.al.shopping.domain.entity.Contract;
import fr.leprohon.esgi.al4.al.shopping.domain.repository.ContractRepository;

public class ModifyExpirationSubscriptionHandler implements CommandHandler<ModifyExpirationSubscription, Void> {

    private final ContractRepository repository;

    public ModifyExpirationSubscriptionHandler(ContractRepository repository) {
        this.repository = repository;
    }

    @Override
    public Void handle(ModifyExpirationSubscription command) {
        Contract byContractId = repository.findByContractId(command.contract);
        return null;
    }
}
