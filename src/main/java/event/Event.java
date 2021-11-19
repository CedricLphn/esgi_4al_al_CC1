package event;

import java.time.ZonedDateTime;

public interface Event {

    EventId getId();
    ZonedDateTime getDate();

}
