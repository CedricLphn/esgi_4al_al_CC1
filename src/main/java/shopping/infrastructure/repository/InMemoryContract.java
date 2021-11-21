package shopping.infrastructure.repository;

import common.annotations.Repository;
import common.exception.NoSuchEntityException;
import common.infrastructure.InMemoryRepositoryAbstract;
import shopping.domain.entity.Contract;
import shopping.domain.repository.ContractRepository;

import java.util.Map;
import java.util.UUID;

@Repository(value = "Contract")
public final class InMemoryContract extends InMemoryRepositoryAbstract<Contract> implements ContractRepository {

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
