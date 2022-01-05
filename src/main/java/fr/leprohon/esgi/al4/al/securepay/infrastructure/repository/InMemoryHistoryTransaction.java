package fr.leprohon.esgi.al4.al.securepay.infrastructure.repository;

import fr.leprohon.esgi.al4.al.kernel.annotations.Repository;
import fr.leprohon.esgi.al4.al.kernel.infrastructure.InMemoryRepositoryAbstract;
import fr.leprohon.esgi.al4.al.securepay.domain.entity.HistoryTransaction;
import fr.leprohon.esgi.al4.al.securepay.domain.repository.HistoryTransactionRepository;

@Repository(value = "HistoryTransaction")
public class InMemoryHistoryTransaction extends InMemoryRepositoryAbstract<HistoryTransaction> implements HistoryTransactionRepository {
}
