package fr.leprohon.esgi.al4.al.securepay.api;

import fr.leprohon.esgi.al4.al.kernel.event.CommandBus;
import fr.leprohon.esgi.al4.al.kernel.event.QueryBus;
import fr.leprohon.esgi.al4.al.kernel.service.Log;
import fr.leprohon.esgi.al4.al.securepay.domain.command.CreateTransaction;
import fr.leprohon.esgi.al4.al.securepay.domain.entity.CreditCard;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;

@RestController
@RequestMapping("/api/v1/securepay/payment")
public class PaymentController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;
    private final Log logger;

    public PaymentController(CommandBus commandBus, QueryBus queryBus, Log logger) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
        this.logger = logger;
    }

    @PostMapping("/payload")
    public ResponseEntity payload(@RequestBody PaymentRequest paymentRequest) {
        CreditCard creditCard = CreditCard.of(paymentRequest.creditCard.number, ZonedDateTime.parse(paymentRequest.creditCard.expiration), paymentRequest.creditCard.cvv);
        CreateTransaction transaction = new CreateTransaction(
                creditCard,
                paymentRequest.amount);

        commandBus.send(transaction);
        return ResponseEntity.accepted().build();
    }

}
