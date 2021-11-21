package shopping.domain.command;

import common.infrastructure.CommandHandler;
import shopping.domain.entity.Contract;

public class SubscriptionHandler extends CommandHandler<SubscriptionHandler, Contract> {

    protected Contract contract;

    public SubscriptionHandler(Contract contract) {
        this.contract = contract;
    }
}
