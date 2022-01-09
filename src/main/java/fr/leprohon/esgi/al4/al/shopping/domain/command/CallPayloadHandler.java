package fr.leprohon.esgi.al4.al.shopping.domain.command;

import fr.leprohon.esgi.al4.al.kernel.event.QueryHandler;
import fr.leprohon.esgi.al4.al.kernel.infrastructure.CommandHandler;
import fr.leprohon.esgi.al4.al.shopping.application.CreateContractRequest;
import fr.leprohon.esgi.al4.al.shopping.domain.entity.Contract;
import fr.leprohon.esgi.al4.al.shopping.infrastructure.exceptions.CallBackException;
import fr.leprohon.esgi.al4.al.shopping.infrastructure.utils.RestService;
import org.springframework.boot.web.client.RestTemplateBuilder;

public class CallPayloadHandler implements QueryHandler<CallPayload, Boolean> {


    @Override
    public Boolean handle(CallPayload command) {
        RestService restService = new RestService(new RestTemplateBuilder());
        try {
            if(restService.createPost(command.paymentInformation)) {
                return true;
            }else {
                throw new CallBackException("Your payment is refused");
            }
        }catch (Exception e) {

            return false;
        }
    }
}
