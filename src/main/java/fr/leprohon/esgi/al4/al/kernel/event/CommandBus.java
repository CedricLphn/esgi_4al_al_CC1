package fr.leprohon.esgi.al4.al.kernel.event;

import fr.leprohon.esgi.al4.al.kernel.infrastructure.Command;

public interface CommandBus {
    <C extends Command, R>R send(C command);
}
