package fr.leprohon.esgi.al4.al.shopping.domain.query;

import fr.leprohon.esgi.al4.al.kernel.event.QueryHandler;
import fr.leprohon.esgi.al4.al.shopping.domain.entity.Contract;
import fr.leprohon.esgi.al4.al.shopping.domain.repository.ContractRepository;

public class RetrieveContractHandler implements QueryHandler<RetrieveContract, Contract> {

    private final ContractRepository contracts;

    public RetrieveContractHandler(ContractRepository contracts) {
        this.contracts = contracts;
    }

    @Override
    public Contract handle(RetrieveContract query) {
        return contracts.findById(query.id);
    }
}
