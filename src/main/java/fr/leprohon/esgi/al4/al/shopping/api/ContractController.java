package fr.leprohon.esgi.al4.al.shopping.api;

import fr.leprohon.esgi.al4.al.kernel.event.CommandBus;
import fr.leprohon.esgi.al4.al.kernel.event.QueryBus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/contract")
public class ContractController {
    // TODO: Add contract, renew contract, Get Contract information

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public ContractController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createContract(ContractRequest contract) {
        System.out.println("Hello");
        return null;
    }

    @GetMapping("/renew")
    public ResponseEntity<Void> renewContract() {
        System.out.println("Renew");
        return ResponseEntity.ok(null);
    }

}
