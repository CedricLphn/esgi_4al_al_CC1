package fr.leprohon.esgi.al4.al.shopping.domain.repository;

import fr.leprohon.esgi.al4.al.kernel.annotations.Repository;
import fr.leprohon.esgi.al4.al.shopping.domain.entity.Contract;
import fr.leprohon.esgi.al4.al.shopping.domain.utils.Status;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository(value = "User")
public interface ContractRepository extends fr.leprohon.esgi.al4.al.kernel.infrastructure.Repository<Integer, Contract> {

    Contract findByContractId(UUID contractId);
    int findInternalId(UUID contractId);
    List<Contract> findByStatus(Status status);
    List<Contract> findAllExpiredContract(Date currentDate);

}
