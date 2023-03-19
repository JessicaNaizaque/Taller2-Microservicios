package javeriana.ms.divms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DivController {
    @Autowired
    Environment environment;

    @GetMapping("/division")
    public String div(@RequestParam int a, @RequestParam int b){
        String port = environment.getProperty("local.server.port");
        float result = (float) a / b;
        String response = "Resultado: " + result + " -> Microservicio división corriendo en el puerto " + port;
        return response;
    }

    @GetMapping("/division1")
    public String div1(@RequestParam int a, @RequestParam int b, @RequestParam String user){
        String port = environment.getProperty("local.server.port");
        float result = (float) a / b;
        String response = port + ":" + result;
        return response;
    }

}