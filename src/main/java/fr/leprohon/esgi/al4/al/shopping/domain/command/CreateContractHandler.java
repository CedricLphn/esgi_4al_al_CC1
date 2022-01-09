package fr.leprohon.esgi.al4.al.shopping.domain.command;

import fr.leprohon.esgi.al4.al.kernel.event.Event;
import fr.leprohon.esgi.al4.al.kernel.event.EventDispatcher;
import fr.leprohon.esgi.al4.al.kernel.infrastructure.CommandHandler;
import fr.leprohon.esgi.al4.al.shopping.domain.entity.Contract;
import fr.leprohon.esgi.al4.al.shopping.domain.event.CreateContractEvent;
import fr.leprohon.esgi.al4.al.shopping.domain.repository.ContractRepository;
import fr.leprohon.esgi.al4.al.shopping.domain.utils.ContractBuilder;
import fr.leprohon.esgi.al4.al.shopping.domain.utils.Status;

public class CreateContractHandler implements CommandHandler<CreateContract, Integer> {

    private final ContractRepository contractRepository;
    private final EventDispatcher<Event> eventDispatcher;

    public CreateContractHandler(ContractRepository contractRepository, EventDispatcher<Event> eventDispatcher) {
        this.contractRepository = contractRepository;
        this.eventDispatcher = eventDispatcher;
    }


    @Override
    public Integer handle(CreateContract command) {
        final Integer contractId = contractRepository.nextId();

        final ContractBuilder contractBuilder = new ContractBuilder();
        final Contract contract = contractBuilder
                .User()
                    .firstName(command.firstname)
                    .lastName(command.lastName)
                    .age(command.age)
                .Payment()
                    .cardNumber(command.cardNumber)
                    .CVV(command.cvv)
                    .expirationDate(command.cardExpiration)
                .Subscription()
                    .type(command.type)
                    .amount(command.amount)
                    .expiration(command.subscriptionExpiration)
                    .status(Status.NEW)
                .build();

        contractRepository.add(contract);
        eventDispatcher.dispatch(new CreateContractEvent(contractId));

        return contractId;
    }
}
