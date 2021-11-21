package securepay.domain.command;

import common.infrastructure.CommandHandler;
import securepay.domain.entity.HistoryTransaction;
import shopping.domain.utils.Status;

public class UpdateStatus extends CommandHandler<PaymentHandler, HistoryTransaction> {
    private HistoryTransaction transaction;
    private Status status;

    public UpdateStatus(HistoryTransaction transaction, Status status) {
        super();
        this.transaction = transaction;
        this.status = status;
    }

    @Override
    public void handle() {
        transaction.setStatus(status);
        super.handle();
    }
}
