package javeriana.ms.divms;

import jakarta.ws.rs.Produces;
import javeriana.ms.divms.model.DivInfo;
import javeriana.ms.divms.repository.DivInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class DivController {
    @Autowired
    Environment environment;
    @Autowired
    DivInfoRepository divInfoRepository;

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
        String response = "Microservicio división corriendo en el puerto " + port + "<br> -> Resultado: " + result + "<br> -> Fecha: " + new java.util.Date() + "<br> -> Usuario: " + user;
        divInfoRepository.save(new DivInfo(a, b, result, user, String.valueOf(new java.util.Date())));
        response += "<br>¡Resultado almacenado en la base de datos!";
        return response;
    }

    @GetMapping("/division/history")
    @Produces("application/json")
    public ArrayList<DivInfo> getHistory(){
        ArrayList<DivInfo> divInfoArrayList = new ArrayList<>();
        divInfoRepository.findAll().forEach(divInfoArrayList::add);
        return divInfoArrayList;
    }
}