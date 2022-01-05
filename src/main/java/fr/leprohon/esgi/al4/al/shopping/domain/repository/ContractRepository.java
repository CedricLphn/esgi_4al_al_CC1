package fr.leprohon.esgi.al4.al.shopping.domain.repository;

import fr.leprohon.esgi.al4.al.kernel.annotations.Repository;
import fr.leprohon.esgi.al4.al.shopping.domain.entity.Contract;

import java.util.UUID;

@Repository(value = "User")
public interface ContractRepository extends fr.leprohon.esgi.al4.al.kernel.infrastructure.Repository<Integer, Contract> {

    Contract findByContractId(UUID contractId);
    int findInternalId(UUID contractId);
}
