package fr.leprohon.esgi.al4.al.shopping.domain.command;

import fr.leprohon.esgi.al4.al.kernel.infrastructure.CommandHandler;
import fr.leprohon.esgi.al4.al.shopping.domain.entity.Contract;

public class SubscriptionHandler { //extends CommandHandler<SubscriptionHandler, Contract> {

    protected Contract contract;

    public SubscriptionHandler(Contract contract) {
        this.contract = contract;
    }
}
