package fr.leprohon.esgi.al4.al.shopping.domain.query;

import fr.leprohon.esgi.al4.al.kernel.event.QueryHandler;
import fr.leprohon.esgi.al4.al.shopping.domain.entity.Contract;
import fr.leprohon.esgi.al4.al.shopping.domain.repository.ContractRepository;

import java.util.List;

public class RetrieveContractsByStatusHandler implements QueryHandler<RetrieveContractsByStatus, List<Contract>> {

    private final ContractRepository repository;

    public RetrieveContractsByStatusHandler(ContractRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Contract> handle(RetrieveContractsByStatus query) {
        return repository.findByStatus(query.status);
    }
}
