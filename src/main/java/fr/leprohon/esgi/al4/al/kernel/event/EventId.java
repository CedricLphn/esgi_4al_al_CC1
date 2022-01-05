package fr.leprohon.esgi.al4.al.kernel.event;

import java.util.UUID;

public class EventId {

    public final UUID uuid;

    private EventId(UUID value) {
        this.uuid = value;
    }

    public static EventId create() {
        return new EventId(UUID.randomUUID());
    }

}
