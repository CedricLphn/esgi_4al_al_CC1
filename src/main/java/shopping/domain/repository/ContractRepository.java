package shopping.domain.repository;

import common.annotations.Repository;
import shopping.domain.entity.Contract;

import java.util.UUID;

@Repository(value = "User")
public interface ContractRepository extends common.infrastructure.Repository<Integer, Contract> {

    Contract findByContractId(UUID contractId);
    int findInternalId(UUID contractId);
}
