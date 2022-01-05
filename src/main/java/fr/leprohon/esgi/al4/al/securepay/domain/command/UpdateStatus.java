package fr.leprohon.esgi.al4.al.securepay.domain.command;

import fr.leprohon.esgi.al4.al.kernel.infrastructure.CommandHandler;
import fr.leprohon.esgi.al4.al.securepay.domain.entity.HistoryTransaction;
import fr.leprohon.esgi.al4.al.shopping.domain.utils.Status;

public class UpdateStatus { //extends CommandHandler<PaymentHandler, HistoryTransaction> {
    private HistoryTransaction transaction;
    private Status status;

    public UpdateStatus(HistoryTransaction transaction, Status status) {
        super();
        this.transaction = transaction;
        this.status = status;
    }

    //@Override
    public void handle() {
        transaction.setStatus(status);
        //super.handle();
    }
}
