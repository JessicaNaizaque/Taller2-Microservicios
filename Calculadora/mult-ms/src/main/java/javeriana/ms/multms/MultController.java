package javeriana.ms.multms;

import jakarta.ws.rs.Produces;
import javeriana.ms.multms.model.MultInfo;
import javeriana.ms.multms.repository.MultInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class MultController {
    @Autowired
    Environment environment;
    @Autowired
    MultInfoRepository multInfoRepository;

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
        String response = "Microservicio multiplicación corriendo en el puerto " + port + "<br> -> Resultado: " + result + "<br> -> Fecha: " + new java.util.Date() + "<br> -> Usuario: " + user;
        multInfoRepository.save(new MultInfo(a, b, result, user, String.valueOf(new java.util.Date())));
        response += "<br>¡Resultado almacenado en la base de datos!";
        return response;
    }

    @GetMapping("/multiplication/history")
    @Produces("application/json")
    public ArrayList<MultInfo> getHistory(){
        ArrayList<MultInfo> multInfoArrayList = new ArrayList<>();
        multInfoRepository.findAll().forEach(multInfoArrayList::add);
        return multInfoArrayList;
    }
}