package shopping.domain.utils;

import shopping.domain.entity.Contract;

public class UserInformationBuilder extends ContractBuilder {

    public UserInformationBuilder(Contract contract) {
        this.contract = contract;
    }

    public UserInformationBuilder firstName(String name) {
        this.contract.getUser().setFirstname(name);
        return this;
    }

    public UserInformationBuilder lastName(String name) {
        this.contract.getUser().setLastname(name);
        return this;
    }

    public UserInformationBuilder age(int age) {
        this.contract.getUser().setAge(age);
        return this;
    }

}
