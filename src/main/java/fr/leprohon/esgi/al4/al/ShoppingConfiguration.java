package fr.leprohon.esgi.al4.al;

import fr.leprohon.esgi.al4.al.kernel.event.*;
import fr.leprohon.esgi.al4.al.kernel.infrastructure.Command;
import fr.leprohon.esgi.al4.al.kernel.infrastructure.CommandHandler;
import fr.leprohon.esgi.al4.al.shopping.domain.repository.ContractRepository;
import fr.leprohon.esgi.al4.al.shopping.infrastructure.repository.InMemoryContractRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ShoppingConfiguration {
    @Bean
    public ContractRepository contractRepository() {
        return new InMemoryContractRepository();
    }

    @Bean
    public EventDispatcher<Event> eventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listMap = new HashMap<>();
        // TODO : Put event here
        return new DefaultEventDispatcher(listMap);
    }

    @Bean
    public QueryBus queryBus() {
        final Map<Class<? extends Query>, QueryHandler> queryHandlerMap = new HashMap<>();

        return new SimpleQueryBus(queryHandlerMap);
    }

    @Bean
    public CommandBus commandBus() {
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap = new HashMap<>();
        return new SimpleCommandBus(commandHandlerMap);
    }

}
