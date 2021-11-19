package shopping.infrastructure;

import common.infrastructure.InMemoryRepositoryAbstract;
import shopping.domain.User;
import shopping.domain.UserRepository;

public final class InMemoryUserRepository extends InMemoryRepositoryAbstract<User> implements UserRepository {


}
