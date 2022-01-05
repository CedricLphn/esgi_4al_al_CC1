package fr.leprohon.esgi.al4.al.kernel.event;

public interface EventDispatcher<E extends Event> {
    void dispatch(E event);
}
