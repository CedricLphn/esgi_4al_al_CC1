package fr.leprohon.esgi.al4.al;

import fr.leprohon.esgi.al4.al.shopping.domain.command.CreateContract;
import fr.leprohon.esgi.al4.al.shopping.domain.command.CreateContractHandler;
import fr.leprohon.esgi.al4.al.shopping.domain.utils.ContractType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;


@SpringBootApplication
public class SpringMain {
    public static void main(String[] args) throws ParseException {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringMain.class, args);

        CreateContractHandler createContractHandler = applicationContext.getBean(CreateContractHandler.class);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        CreateContract contract = new CreateContract(
                ContractType.TRADESMAN,
                "Leprohon",
                "Cedric",
                27,
                "4485678386265192",
                ZonedDateTime.now(),
                123,
                19,
                simpleDateFormat.parse("31-01-2022")
        );
        createContractHandler.handle(contract);

    }
}
