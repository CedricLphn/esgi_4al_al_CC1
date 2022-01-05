package fr.leprohon.esgi.al4.al.securepay.domain.repository;

import fr.leprohon.esgi.al4.al.kernel.annotations.Repository;
import fr.leprohon.esgi.al4.al.securepay.domain.entity.HistoryTransaction;

@Repository(value = "Bank")
public interface HistoryTransactionRepository extends fr.leprohon.esgi.al4.al.kernel.infrastructure.Repository<Integer, HistoryTransaction> {

}
