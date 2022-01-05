package fr.leprohon.esgi.al4.al.shopping.infrastructure.repository;

import fr.leprohon.esgi.al4.al.kernel.annotations.Repository;
import fr.leprohon.esgi.al4.al.kernel.exception.NoSuchEntityException;
import fr.leprohon.esgi.al4.al.kernel.infrastructure.InMemoryRepositoryAbstract;
import fr.leprohon.esgi.al4.al.shopping.domain.entity.Contract;
import fr.leprohon.esgi.al4.al.shopping.domain.repository.ContractRepository;

import java.util.Map;
import java.util.UUID;

@Repository(value = "Contract")
public final class InMemoryContractRepository extends InMemoryRepositoryAbstract<Contract> implements ContractRepository {

    @Override
    public Contract findByContractId(UUID contractId) {
        for(Map.Entry<Integer, Contract> contract : list.entrySet()) {
            if(contract.getValue().getId().equals(contractId)) {
                return contract.getValue();
            }
        }

        throw new NoSuchEntityException(contractId.toString());
    }

    @Override
    public int findInternalId(UUID contractId) {
        for(Map.Entry<Integer, Contract> contract : list.entrySet()) {
            if(contract.getValue().getId().equals(contractId)) {
                return contract.getKey();
            }
        }

        throw new NoSuchEntityException(contractId.toString());
    }
}
