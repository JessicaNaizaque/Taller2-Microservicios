package javeriana.ms.subms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubController {
    @Autowired
    Environment environment;

    @GetMapping("/subtraction")
    public String sub(@RequestParam int a, @RequestParam int b){
        String port = environment.getProperty("local.server.port");
        int result = a - b;
        String response = "Resultado: " + result + " -> Microservicio resta corriendo en el puerto " + port;
        return response;
    }

    @GetMapping("/subtraction1")
    public String sub1(@RequestParam int a, @RequestParam int b, @RequestParam String user){
        String port = environment.getProperty("local.server.port");
        int result = a - b;
        String response = port + ":" + result;
        return response;        
    }

}