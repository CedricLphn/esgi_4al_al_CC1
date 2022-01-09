package fr.leprohon.esgi.al4.al.securepay.domain.command;

import fr.leprohon.esgi.al4.al.kernel.event.Event;
import fr.leprohon.esgi.al4.al.kernel.event.EventDispatcher;
import fr.leprohon.esgi.al4.al.kernel.infrastructure.CommandHandler;
import fr.leprohon.esgi.al4.al.kernel.service.Log;
import fr.leprohon.esgi.al4.al.securepay.domain.entity.HistoryTransaction;
import fr.leprohon.esgi.al4.al.securepay.domain.payload.DummyPaymentTransaction;
import fr.leprohon.esgi.al4.al.securepay.domain.repository.HistoryTransactionRepository;
import fr.leprohon.esgi.al4.al.securepay.infrastructure.exceptions.BankException;
import fr.leprohon.esgi.al4.al.shopping.domain.utils.Status;

import java.time.ZonedDateTime;

public class CreateTransactionHandler implements CommandHandler<CreateTransaction, Boolean> {

    private final HistoryTransactionRepository repository;
    private final EventDispatcher<Event> eventEventDispatcher;
    private final Log logger;

    public CreateTransactionHandler(HistoryTransactionRepository repository, EventDispatcher<Event> eventEventDispatcher, Log logger) {
        this.repository = repository;
        this.eventEventDispatcher = eventEventDispatcher;
        this.logger = logger;
    }

    @Override
    public Boolean handle(CreateTransaction command) {

        try {
            HistoryTransaction historyTransaction = new HistoryTransaction(command.creditCard, ZonedDateTime.now(),
                    command.amount, Status.NEW);
            Boolean status = DummyPaymentTransaction.of(historyTransaction);
            historyTransaction.setStatus(status ? Status.ACCEPTED:Status.REFUSED);
            repository.add(historyTransaction);
            eventEventDispatcher.dispatch(new PaymentTransactionEvent());
            if(historyTransaction.getStatus() == Status.REFUSED) {
                throw new BankException("Your bank has refused this transaction");
            }
            return status;
        } catch (Exception e) {
            logger.log(e.getMessage());
        }

        return false;
    }
}
