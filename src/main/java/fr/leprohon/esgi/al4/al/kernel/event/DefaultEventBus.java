package fr.leprohon.esgi.al4.al.kernel.event;

import java.util.List;
import java.util.Map;

public class DefaultEventBus<T extends Event> implements EventBus<T> {

    private final Map<Class<T>, List<Subscriber<T>>> subscribers;

    public DefaultEventBus(Map<Class<T>, List<Subscriber<T>>> subscribers) {
        this.subscribers = subscribers;
    }

    @Override
    public void send(T event) {
        final List<Subscriber<T>> subscribers = this.subscribers.get(event.getClass());
        if(subscribers == null || subscribers.isEmpty()) {
            throw new IllegalStateException("No subscribers for " + event.getClass().getSimpleName());
        }

        subscribers.forEach(subscriber -> subscriber.accept(event));

    }

    @Override
    public void subscribe(Class<T> E, List<Subscriber<T>> subscribers) {
        this.subscribers.putIfAbsent(E, subscribers);
    }

}
