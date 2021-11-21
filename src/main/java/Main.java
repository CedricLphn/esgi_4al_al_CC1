import common.infrastructure.ConsoleLogger;
import common.service.Log;
import common.service.SerializationEngine;
import common.service.SerializationFactory;
import event.DefaultEventBus;
import securepay.domain.entity.CreditCard;
import securepay.domain.payload.DummyPaymentTransaction;
import securepay.domain.repository.HistoryTransactionRepository;
import securepay.infrastructure.engine.CardTypeEngine;
import securepay.infrastructure.repository.InMemoryHistoryTransaction;
import securepay.infrastructure.TransactionEventSubscription;
import event.SubscribeMembershipEvent;
import shopping.domain.entity.Contract;
import shopping.domain.entity.User;
import shopping.domain.payload.ApplyMembership;
import shopping.domain.payload.ContractTypeAdapter;
import shopping.domain.service.ContractService;
import shopping.domain.service.SubscriptionEventService;
import shopping.domain.utils.ContractBuilder;
import shopping.domain.utils.ContractType;
import shopping.domain.utils.Status;
import shopping.infrastructure.repository.InMemoryContract;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HistoryTransactionRepository historyRepository = new InMemoryHistoryTransaction();
        ContractService contractService = new ContractService(new InMemoryContract());

        CreditCard cc = CreditCard.of("4485678386265192", ZonedDateTime.now(), 1234);

        Log logger = new ConsoleLogger();
        System.out.println(CardTypeEngine.detect(cc));

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

        contractService.add(contract);
        SerializationEngine<Contract> serializationEngine = SerializationFactory.toJSON(Contract.class, new ContractTypeAdapter());
        String json = serializationEngine.apply(contract);

        Map<Class<SubscribeMembershipEvent>, List<TransactionEventSubscription>> shoppingSubscriptionMap =
            Collections.singletonMap(SubscribeMembershipEvent.class,
                    List.of(new TransactionEventSubscription(new DummyPaymentTransaction(logger, historyRepository)),
                            new TransactionEventSubscription(new ApplyMembership(logger, contractService))
                    ));

        DefaultEventBus shoppingBus = new DefaultEventBus(shoppingSubscriptionMap);
        SubscriptionEventService shoppingRegisterService = new SubscriptionEventService(shoppingBus, logger);

        shoppingRegisterService.register(json);

    }
}
