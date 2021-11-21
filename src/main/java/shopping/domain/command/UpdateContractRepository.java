package shopping.domain.command;

import shopping.domain.entity.Contract;
import shopping.domain.service.ContractService;

public class UpdateContractRepository extends SubscriptionHandler {


    private final ContractService service;

    public UpdateContractRepository(Contract contract, ContractService service) {
        super(contract);
        this.service = service;
    }

    @Override
    public void handle() {
        super.handle();
        service.update(service.findInternalContractId(contract.getId()), contract);
    }
}
