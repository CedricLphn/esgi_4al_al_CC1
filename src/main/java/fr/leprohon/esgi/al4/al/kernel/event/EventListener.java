package fr.leprohon.esgi.al4.al.kernel.event;

public interface EventListener<E extends Event> {
    void listenTo(E event);
}
