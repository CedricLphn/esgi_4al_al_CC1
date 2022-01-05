package fr.leprohon.esgi.al4.al.securepay.domain.entity;

import fr.leprohon.esgi.al4.al.kernel.annotations.Entity;
import fr.leprohon.esgi.al4.al.shopping.domain.utils.Status;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
public final class HistoryTransaction {

    private UUID contractId;
    private ZonedDateTime date;
    private String firstName;
    private String lastname;
    private float amount;
    private Status status;


    public HistoryTransaction(UUID contractId, ZonedDateTime date, String firstName, String lastname, float amount, Status status) {
        this.contractId = contractId;
        this.date = date;
        this.firstName = firstName;
        this.lastname = lastname;
        this.amount = amount;
        this.status = status;
    }

    public HistoryTransaction() {
        this.date = ZonedDateTime.now();
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public float getAmount() {
        return amount;
    }

    public UUID getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = UUID.fromString(contractId);
    }

    @Override
    public String toString() {
        return "HistoryTransaction{" +
                "date=" + date +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", amount=" + amount +
                ", status=" + status +
                '}';
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
