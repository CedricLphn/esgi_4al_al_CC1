package securepay.infrastructure.repository;

import common.annotations.Repository;
import common.infrastructure.InMemoryRepositoryAbstract;
import securepay.domain.entity.HistoryTransaction;
import securepay.domain.repository.HistoryTransactionRepository;

@Repository(value = "HistoryTransaction")
public class InMemoryHistoryTransaction extends InMemoryRepositoryAbstract<HistoryTransaction> implements HistoryTransactionRepository {
}
