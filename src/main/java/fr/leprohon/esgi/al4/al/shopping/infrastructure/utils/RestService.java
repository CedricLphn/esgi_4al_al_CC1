package fr.leprohon.esgi.al4.al.shopping.infrastructure.utils;

import fr.leprohon.esgi.al4.al.shopping.application.CreateContractRequest;
import fr.leprohon.esgi.al4.al.shopping.application.CreditCardRequest;
import fr.leprohon.esgi.al4.al.shopping.infrastructure.exceptions.CallBackException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RestService {

    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public boolean createPost(PaymentInformation request) throws CallBackException {
        String url = "http://localhost:8080/api/v1/securepay/payment/payload";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        Map<String, Object> map = new HashMap<>();
        map.put("creditCard", request.creditCard);
        map.put("amount", request.amount);


        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

        ResponseEntity<Boolean> response = this.restTemplate.postForEntity(url, entity, Boolean.class);
        if(response.getStatusCode() == HttpStatus.ACCEPTED) {
            return true;
        }else {
            throw new CallBackException("Unattended response statut code ("+response.getStatusCode()+")");
        }
    }
}
