package securepay.infrastructure;

import common.NoSuchEntityException;
import common.infrastructure.InMemoryRepositoryAbstract;
import securepay.domain.Bank;
import securepay.domain.BankRepository;

public class InMemoryBankRepository extends InMemoryRepositoryAbstract<Bank> implements BankRepository {
}
