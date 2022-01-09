package fr.leprohon.esgi.al4.al.shopping.domain.command;

import fr.leprohon.esgi.al4.al.kernel.event.Query;
import fr.leprohon.esgi.al4.al.kernel.infrastructure.Command;
import fr.leprohon.esgi.al4.al.shopping.domain.entity.Contract;
import fr.leprohon.esgi.al4.al.shopping.infrastructure.utils.PaymentInformation;

import java.util.List;

public class CallPayload implements Query {
    public final PaymentInformation paymentInformation;

    public CallPayload(PaymentInformation paymentInformation) {
        this.paymentInformation = paymentInformation;
    }
}
