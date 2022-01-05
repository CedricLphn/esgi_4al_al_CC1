package fr.leprohon.esgi.al4.al.kernel.event;

import java.util.function.Consumer;

public interface Subscriber<E extends Event> extends Consumer<E> {
}
