package fr.leprohon.esgi.al4.al.shopping.domain.command;

import fr.leprohon.esgi.al4.al.shopping.domain.entity.Contract;
import fr.leprohon.esgi.al4.al.shopping.domain.utils.Status;

public class UpdateObjectStatusContract extends SubscriptionHandler {
    private Status status;

    public UpdateObjectStatusContract(Contract contract, Status newStatus) {
        super(contract);
        status = newStatus;
    }

    //@Override
    //public void handle() {
        //super.handle();
        //contract.setPaymentStatus(status);
    //}
}
