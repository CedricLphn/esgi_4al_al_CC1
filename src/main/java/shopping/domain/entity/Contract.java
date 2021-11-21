package shopping.domain.entity;

import common.annotations.Entity;
import shopping.domain.utils.ContractType;
import shopping.domain.utils.Status;

import java.util.UUID;

@Entity
public class Contract {
    private final UUID id;
    private ContractType type;
    private User user;
    private int amount;
    private Status paymentStatus;

    public ContractType getType() {
        return type;
    }

    public User getUser() {
        return user;
    }

    public void setType(ContractType type) {
        this.type = type;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Contract() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public Status getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Status paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "type=" + type +
                ", user=" + user +
                '}';
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
