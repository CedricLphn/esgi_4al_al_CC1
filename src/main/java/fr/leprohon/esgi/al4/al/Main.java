package fr.leprohon.esgi.al4.al;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(Main.class, args);
        /*HistoryTransactionRepository historyRepository = new InMemoryHistoryTransaction();
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

        shoppingRegisterService.register(json);*/

    }
}
