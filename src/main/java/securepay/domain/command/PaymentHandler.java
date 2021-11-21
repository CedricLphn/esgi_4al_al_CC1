package securepay.domain.command;

import common.infrastructure.CommandHandler;
import securepay.domain.entity.HistoryTransaction;

public class PaymentHandler extends CommandHandler<PaymentHandler, HistoryTransaction> {

    protected HistoryTransaction transaction;

    public PaymentHandler(HistoryTransaction transaction) {
        this.transaction = transaction;
    }
}
