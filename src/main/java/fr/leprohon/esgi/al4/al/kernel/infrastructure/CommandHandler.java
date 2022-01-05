package fr.leprohon.esgi.al4.al.kernel.infrastructure;

public interface CommandHandler<C extends Command, E> {
    E handle(Command c);
}
