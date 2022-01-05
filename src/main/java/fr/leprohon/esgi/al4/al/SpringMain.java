package fr.leprohon.esgi.al4.al;

import fr.leprohon.esgi.al4.al.shopping.infrastructure.repository.InMemoryContractRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class SpringMain {
    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringMain.class, args);

        InMemoryContractRepository test = applicationContext.getBean(InMemoryContractRepository.class);

        //test.findAll().forEach(System.out::println);

    }
}
