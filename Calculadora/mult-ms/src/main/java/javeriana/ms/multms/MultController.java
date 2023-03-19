package javeriana.ms.multms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultController {
    @Autowired
    Environment environment;

    @GetMapping("/multiplication")
    public String mult(@RequestParam int a, @RequestParam int b) {
        String port = environment.getProperty("local.server.port");
        int result = a * b;
        String response = "Resultado: " + result + " -> Microservicio multiplicación corriendo en el puerto " + port;
        return response;
    }

    @GetMapping("/multiplication1")
    public String mult1(@RequestParam int a, @RequestParam int b, @RequestParam String user){
        String port = environment.getProperty("local.server.port");
        int result = a * b;
        String response = port + ":" + result;
        return response;
    }

}