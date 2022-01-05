package fr.leprohon.esgi.al4.al.securepay.domain.command;

import fr.leprohon.esgi.al4.al.securepay.domain.entity.HistoryTransaction;
import fr.leprohon.esgi.al4.al.securepay.domain.repository.HistoryTransactionRepository;

public class CreateTransaction {

    private HistoryTransactionRepository repository;

    public CreateTransaction(HistoryTransaction historyTransaction, HistoryTransactionRepository repository) {
        //super(historyTransaction);
        this.repository = repository;
    }

    public void handle() {
        //repository.add(transaction);
        //super.handle();
    }
}
