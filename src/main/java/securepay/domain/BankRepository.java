package securepay.domain;

import common.annotations.Repository;

@Repository(value = "Bank")
public interface BankRepository extends common.Repository<Integer, Bank> {

}
