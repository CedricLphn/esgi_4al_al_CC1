package event;

import java.time.ZonedDateTime;

public class SubscribeMembershipEvent implements Event {

    private final EventId eventId;
    private final ZonedDateTime dateTime;
    private final String jsonContract;

    private SubscribeMembershipEvent(EventId eventId, ZonedDateTime dateTime, String contract) {
        this.eventId = eventId;
        this.dateTime = dateTime;
        this.jsonContract = contract;
    }

    public static SubscribeMembershipEvent contract(String contract) {
        return new SubscribeMembershipEvent(EventId.create(), ZonedDateTime.now(), contract);
    }


    @Override
    public EventId getId() {
        return eventId;
    }

    @Override
    public ZonedDateTime getDate() {
        return dateTime;
    }

    public String getJsonContract() {
        return jsonContract;
    }
}
