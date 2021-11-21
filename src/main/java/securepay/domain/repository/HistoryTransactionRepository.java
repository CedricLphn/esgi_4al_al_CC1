package securepay.domain.repository;

import common.annotations.Repository;
import securepay.domain.entity.HistoryTransaction;

@Repository(value = "Bank")
public interface HistoryTransactionRepository extends common.infrastructure.Repository<Integer, HistoryTransaction> {

}
