package fr.leprohon.esgi.al4.al;

import org.junit.jupiter.api.Test;
import fr.leprohon.esgi.al4.al.securepay.domain.entity.CreditCard;
import fr.leprohon.esgi.al4.al.securepay.infrastructure.ValidationCreditCardEngine;
import fr.leprohon.esgi.al4.al.shopping.domain.entity.Contract;
import fr.leprohon.esgi.al4.al.shopping.domain.repository.ContractRepository;
import fr.leprohon.esgi.al4.al.shopping.domain.utils.ContractBuilder;
import fr.leprohon.esgi.al4.al.shopping.domain.utils.ContractType;
import fr.leprohon.esgi.al4.al.shopping.domain.utils.Status;
import fr.leprohon.esgi.al4.al.shopping.infrastructure.repository.InMemoryContractRepository;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingTest {

    ContractRepository contractRepository = new InMemoryContractRepository();

    @Test
    void GivenCreateAContractWhenNothingReturnContractInDatabase() {
        contractRepository = new InMemoryContractRepository();

        ContractBuilder contractBuilder = new ContractBuilder();
        Contract contract = contractBuilder
                .User()
                    .firstName("Cedric")
                    .lastName("Leprohon")
                    .age(27)
                .Payment()
                    .cardNumber("4485678386265192")
                    .CVV(1234)
                    .expirationDate(ZonedDateTime.now())
                .Subscription()
                    .type(ContractType.TRADESMAN)
                    .amount(19)
                    .status(Status.NEW)
                .build();
        contractRepository.add(contract);

        assertEquals(contract, contractRepository.findByContractId(contract.getId()));
    }

    @Test
    void GivenAValidCreditCardReturnTrue() {
        CreditCard creditCard = CreditCard.of("4485678386265192", ZonedDateTime.now(), 1234);

        assertEquals(true, ValidationCreditCardEngine.getInstance().test(creditCard));
    }

    @Test
    void GivenAnInvalidCreditCardReturnThrowException() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CreditCard.of("00000000", ZonedDateTime.now(), 1234);
        });

        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains("Invalid credit card"));
    }

}
