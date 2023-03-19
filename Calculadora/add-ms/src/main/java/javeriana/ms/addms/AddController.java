package javeriana.ms.addms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AddController {
    @Autowired
    Environment environment;

    @GetMapping("/addition")
    public String add(@RequestParam int a, @RequestParam int b){
        String port = environment.getProperty("local.server.port");
        int result = a + b;
        String response = "Resultado: " + result + " -> Microservicio suma corriendo en el puerto " + port;
        return response;
    }

    @GetMapping("/addition1")
    public String add1(@RequestParam int a, @RequestParam int b, @RequestParam String user){
        String port = environment.getProperty("local.server.port");
        int result = a + b;
        String response = port + ":" + result;
        return response;
    }
}