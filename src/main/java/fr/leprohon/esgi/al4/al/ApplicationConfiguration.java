package fr.leprohon.esgi.al4.al;

import fr.leprohon.esgi.al4.al.kernel.event.*;
import fr.leprohon.esgi.al4.al.kernel.infrastructure.*;
import fr.leprohon.esgi.al4.al.kernel.service.Log;
import fr.leprohon.esgi.al4.al.securepay.domain.command.CreateTransaction;
import fr.leprohon.esgi.al4.al.securepay.domain.command.CreateTransactionHandler;
import fr.leprohon.esgi.al4.al.securepay.domain.repository.HistoryTransactionRepository;
import fr.leprohon.esgi.al4.al.securepay.infrastructure.repository.InMemoryHistoryTransaction;
import fr.leprohon.esgi.al4.al.shopping.domain.command.*;
import fr.leprohon.esgi.al4.al.shopping.domain.event.CreateContractEvent;
import fr.leprohon.esgi.al4.al.shopping.domain.query.*;
import fr.leprohon.esgi.al4.al.shopping.domain.repository.ContractRepository;
import fr.leprohon.esgi.al4.al.shopping.infrastructure.repository.InMemoryContractRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@EnableScheduling
public class ApplicationConfiguration {
    @Bean
    public ContractRepository contractRepository() {
        return new InMemoryContractRepository();
    }

    @Bean
    public EventDispatcher<Event> eventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listMap = new HashMap<>();
        listMap.put(CreateContractEvent.class, List.of(new CreateContractEventListener(logger())));
        return new DefaultEventDispatcher(listMap);
    }

    @Bean
    public Log logger() {
        final ArrayList<Log> loggers = new ArrayList<>();
        loggers.add(new ConsoleLogger());
        loggers.add(new FileLogger(Path.of("log.txt")));
        return new Loggers(loggers);
    }

    @Bean
    public QueryBus queryBus() {
        final Map<Class<? extends Query>, QueryHandler> queryHandlerMap = new HashMap<>();
        queryHandlerMap.put(RetrieveContract.class, new RetrieveContractHandler(contractRepository()));
        queryHandlerMap.put(RetrieveContractsByStatus.class, new RetrieveContractsByStatusHandler(contractRepository()));
        queryHandlerMap.put(RetrieveContractsByExpirationDate.class, new RetrieveContractsByExpirationDateHandler(contractRepository()));
        queryHandlerMap.put(CallPayload.class, new CallPayloadHandler());
        return new SimpleQueryBus(queryHandlerMap);
    }

    @Bean
    public CommandBus commandBus() {
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap = new HashMap<>();
        commandHandlerMap.put(CreateContract.class, new CreateContractHandler(contractRepository(), eventDispatcher()));
        commandHandlerMap.put(CreateTransaction.class, new CreateTransactionHandler(historyTransactionRepository(), eventDispatcher(), logger()));
        commandHandlerMap.put(ModifyStatusContract.class, new ModifyStatusContractHandler(contractRepository(), eventDispatcher()));
        commandHandlerMap.put(ModifyContract.class, new ModifyContractHandler(logger(), contractRepository(), eventDispatcher()));

        return new SimpleCommandBus(commandHandlerMap);
    }

    @Bean
    public HistoryTransactionRepository historyTransactionRepository() {
        return new InMemoryHistoryTransaction();
    }

    @Bean
    public CreateContractHandler createContractHandler() {
        return new CreateContractHandler(contractRepository(), eventDispatcher());
    }

}
