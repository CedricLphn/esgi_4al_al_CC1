package fr.leprohon.esgi.al4.al.shopping.infrastructure.repository;

import fr.leprohon.esgi.al4.al.kernel.annotations.Repository;
import fr.leprohon.esgi.al4.al.kernel.exception.NoSuchEntityException;
import fr.leprohon.esgi.al4.al.kernel.infrastructure.InMemoryRepositoryAbstract;
import fr.leprohon.esgi.al4.al.shopping.domain.entity.Contract;
import fr.leprohon.esgi.al4.al.shopping.domain.repository.ContractRepository;
import fr.leprohon.esgi.al4.al.shopping.domain.utils.Status;

import java.util.*;

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

    @Override
    public List<Contract> findByStatus(Status status) {
        final List<Contract> contracts = new ArrayList<>();
        list.forEach((key, contract) -> {
            if(contract.getPaymentStatus() == status) {
                contracts.add(contract);
            }
        });
        return contracts;
    }

    @Override
    public List<Contract> findAllExpiredContract(Date currentDate) {

        List<Contract> result = new ArrayList<>();

        for(Map.Entry<Integer, Contract> contract : list.entrySet()) {
            if(contract.getValue().getExpiration().compareTo(currentDate) <= 0) {
                result.add(contract.getValue());
            }
        }


        return result;
    }
}
