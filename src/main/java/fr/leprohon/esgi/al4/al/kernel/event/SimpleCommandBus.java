package fr.leprohon.esgi.al4.al.kernel.event;

import fr.leprohon.esgi.al4.al.kernel.infrastructure.Command;
import fr.leprohon.esgi.al4.al.kernel.infrastructure.CommandHandler;

import java.util.Map;

public class SimpleCommandBus implements CommandBus {

    private final Map<Class<? extends Command>, CommandHandler> commandHandlerMap;

    public SimpleCommandBus(Map<Class<? extends Command>, CommandHandler> commandHandlerMap) {
        this.commandHandlerMap = commandHandlerMap;
    }

    @Override
    public <C extends Command, R> R send(C command) {
        return dispatch(command);
    }

    private <C extends Command, R> R dispatch(C command) {
        final CommandHandler commandHandler = commandHandlerMap.get(command.getClass());
        if (commandHandler == null) {
            throw new RuntimeException("No such command handler for " + command.getClass().getName());
        }

        return (R) commandHandler.handle(command);
    }

}
