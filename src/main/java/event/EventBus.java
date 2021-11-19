package event;

import java.util.List;

public interface EventBus<E extends Event> {
    void send(E event);
    void subscribe(Class<E> E, List<Subscriber<E>> subscribers);
}
