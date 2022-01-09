package fr.leprohon.esgi.al4.al.shopping.domain.query;

import fr.leprohon.esgi.al4.al.kernel.event.QueryHandler;
import fr.leprohon.esgi.al4.al.shopping.domain.entity.Contract;
import fr.leprohon.esgi.al4.al.shopping.domain.repository.ContractRepository;

import java.util.List;

public class RetrieveContractsByExpirationDateHandler implements QueryHandler<RetrieveContractsByExpirationDate, List<Contract>> {

    private final ContractRepository repository;

    public RetrieveContractsByExpirationDateHandler(ContractRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Contract> handle(RetrieveContractsByExpirationDate query) {
        return repository.findAllExpiredContract(query.date);
    }
}
