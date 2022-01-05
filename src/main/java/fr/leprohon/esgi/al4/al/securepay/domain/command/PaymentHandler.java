package fr.leprohon.esgi.al4.al.securepay.domain.command;

import fr.leprohon.esgi.al4.al.kernel.infrastructure.CommandHandler;
import fr.leprohon.esgi.al4.al.securepay.domain.entity.HistoryTransaction;

public class PaymentHandler { //extends CommandHandler<PaymentHandler, HistoryTransaction> {

    protected HistoryTransaction transaction;

    public PaymentHandler(HistoryTransaction transaction) {
        this.transaction = transaction;
    }
}
