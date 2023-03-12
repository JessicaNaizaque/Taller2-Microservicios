package javeriana.ms.subms;

import jakarta.ws.rs.Produces;
import javeriana.ms.subms.model.SubInfo;
import javeriana.ms.subms.repository.SubInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class SubController {
    @Autowired
    Environment environment;
    @Autowired
    private SubInfoRepository subInfoRepository;

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
        String response = "Microservicio resta corriendo en el puerto " + port + "<br> -> Resultado: " + result + "<br> -> Fecha: " + new java.util.Date() + "<br> -> Usuario: " + user;
        subInfoRepository.save(new SubInfo(a, b, result, user, String.valueOf(new java.util.Date())));
        response += "<br>¡Resultado almacenado en la base de datos!";
        return response;
    }

    @GetMapping("/subtraction/history")
    @Produces("application/json")
    public ArrayList<SubInfo> subHistory(){
        ArrayList<SubInfo> subInfo = new ArrayList<>();
        subInfoRepository.findAll().forEach(subInfo::add);
        return subInfo;
    }
}