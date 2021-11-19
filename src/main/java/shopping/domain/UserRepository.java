package shopping.domain;

import common.annotations.Repository;

@Repository(value = "User")
public interface UserRepository extends common.Repository<Integer, User> {
}
