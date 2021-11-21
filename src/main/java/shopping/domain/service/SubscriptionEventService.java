package shopping.domain.service;

import common.service.Log;
import event.Event;
import event.EventBus;
import event.SubscribeMembershipEvent;

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
