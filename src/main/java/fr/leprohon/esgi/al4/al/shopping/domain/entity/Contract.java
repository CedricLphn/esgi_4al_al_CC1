package fr.leprohon.esgi.al4.al.shopping.domain.entity;

import fr.leprohon.esgi.al4.al.kernel.annotations.Entity;
import fr.leprohon.esgi.al4.al.shopping.domain.utils.ContractType;
import fr.leprohon.esgi.al4.al.shopping.domain.utils.Status;

import java.util.Date;
import java.util.UUID;

@Entity
public final class Contract {
    private final UUID id;
    private ContractType type;
    private User user;
    private int amount;
    private Date expiration;
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

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", type=" + type +
                ", user=" + user +
                ", amount=" + amount +
                ", expiration=" + expiration +
                ", paymentStatus=" + paymentStatus +
                '}';
    }
}
