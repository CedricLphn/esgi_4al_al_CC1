package fr.leprohon.esgi.al4.al.securepay.domain.entity;

import fr.leprohon.esgi.al4.al.kernel.annotations.Entity;
import fr.leprohon.esgi.al4.al.shopping.domain.utils.Status;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
public final class HistoryTransaction {

    private CreditCard contractId;
    private ZonedDateTime date;
    private float amount;
    private Status status;

    public HistoryTransaction(CreditCard contractId, ZonedDateTime date, float amount, Status status) {
        this.contractId = contractId;
        this.date = date;
        this.amount = amount;
        this.status = status;
    }

    public HistoryTransaction() {
        this.date = ZonedDateTime.now();
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public ZonedDateTime getDate() {
        return date;
    }


    public float getAmount() {
        return amount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "HistoryTransaction{" +
                "contractId=" + contractId +
                ", date=" + date +
                ", amount=" + amount +
                ", status=" + status +
                '}';
    }
}
