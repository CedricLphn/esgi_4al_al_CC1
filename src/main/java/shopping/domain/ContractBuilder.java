package shopping.domain;

public class ContractBuilder {
    protected Contract contract = new Contract();

    public ContractBuilder type(ContractType type) {
        this.contract.setType(type);
        return this;
    }

    public ContractBuilder user(User user) {
        this.contract.setUser(user);
        return this;
    }

    public ContractBuilder amount(int amount) {
        contract.setAmount(amount);
        return this;
    }

    public ContractBuilder status(Status status) {
        contract.setPaymentStatus(status);
        return this;
    }

    public Contract build() {
        return contract;
    }

}
