package asd;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
public class C {
    @PostMapping("/")
    String a(@RequestBody String b) {
        System.out.println(b);
        return Base64.getEncoder().encodeToString(b.getBytes());
    }
}
