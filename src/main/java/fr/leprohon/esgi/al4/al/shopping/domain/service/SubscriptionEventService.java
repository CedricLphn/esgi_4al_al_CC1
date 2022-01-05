package fr.leprohon.esgi.al4.al.shopping.domain.service;

import fr.leprohon.esgi.al4.al.kernel.service.Log;
import fr.leprohon.esgi.al4.al.kernel.event.Event;
import fr.leprohon.esgi.al4.al.kernel.event.EventBus;
import fr.leprohon.esgi.al4.al.kernel.event.SubscribeMembershipEvent;

public class SubscriptionEventService {

    private final EventBus<Event> eventBus;
    private final Log logger;

    public SubscriptionEventService(EventBus<Event> eventBus, Log logger) {
        this.eventBus = eventBus;
        this.logger = logger;
    }

    public void register(String paymentInformation) {
        eventBus.send(SubscribeMembershipEvent.contract(paymentInformation));
    }

}
