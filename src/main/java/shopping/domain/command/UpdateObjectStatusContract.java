package shopping.domain.command;

import shopping.domain.entity.Contract;
import shopping.domain.utils.Status;

public class UpdateObjectStatusContract extends SubscriptionHandler {
    private Status status;

    public UpdateObjectStatusContract(Contract contract, Status newStatus) {
        super(contract);
        status = newStatus;
    }

    @Override
    public void handle() {
        super.handle();
        contract.setPaymentStatus(status);
    }
}
