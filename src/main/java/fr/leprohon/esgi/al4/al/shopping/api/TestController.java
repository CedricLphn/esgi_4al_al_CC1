package fr.leprohon.esgi.al4.al.shopping.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping(path = "/ok")
    public ResponseEntity<Void> test() {
        return ResponseEntity.ok(null);
    }

}
