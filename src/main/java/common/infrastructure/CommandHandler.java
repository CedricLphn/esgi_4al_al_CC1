package common.infrastructure;

public abstract class CommandHandler<C, E> implements Command {


    protected CommandHandler<C, E> next;

    public void add(CommandHandler<C, E> command) {
        if(next != null) {
            next.add(command);
        }else {
            next = command;
        }
    }

    public void handle() {
        if(next != null) {
            next.handle();
        }
    }
}
