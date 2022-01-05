package fr.leprohon.esgi.al4.al.kernel.event;

import java.util.List;

public interface EventBus<E extends Event> {
    void send(E event);
    void subscribe(Class<E> E, List<Subscriber<E>> subscribers);
}
