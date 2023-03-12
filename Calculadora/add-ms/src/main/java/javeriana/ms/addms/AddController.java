package javeriana.ms.addms;

import jakarta.ws.rs.Produces;
import javeriana.ms.addms.model.AddInfo;
import javeriana.ms.addms.repository.AddInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class AddController {
    @Autowired
    Environment environment;
    @Autowired
    private AddInfoRepository addInfoRepository;

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
        String response = "Microservicio suma corriendo en el puerto " + port + "<br> -> Resultado: " + result + "<br> -> Fecha: " + new java.util.Date() + "<br> -> Usuario: " + user + "<br>";
        addInfoRepository.save(new AddInfo(a, b, result, user, String.valueOf(new java.util.Date())));
        response += "<br>¡Resultado almacenado en la base de datos!";
        return response;
    }

    @GetMapping("/addition/history")
    @Produces("application/json")
    public ArrayList<AddInfo> getHistory(){
        ArrayList<AddInfo> addInfoArrayList = new ArrayList<>();
        addInfoRepository.findAll().forEach(addInfoArrayList::add);
        return addInfoArrayList;
    }
}