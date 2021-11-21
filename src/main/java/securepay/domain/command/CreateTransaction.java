package securepay.domain.command;

import securepay.domain.entity.HistoryTransaction;
import securepay.domain.repository.HistoryTransactionRepository;

public class CreateTransaction extends PaymentHandler {

    private HistoryTransactionRepository repository;

    public CreateTransaction(HistoryTransaction historyTransaction, HistoryTransactionRepository repository) {
        super(historyTransaction);
        this.repository = repository;
    }


    @Override
    public void handle() {
        repository.add(transaction);
        super.handle();
    }
}
