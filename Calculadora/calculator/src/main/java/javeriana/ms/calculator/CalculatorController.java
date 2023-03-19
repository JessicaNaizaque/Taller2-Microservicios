package javeriana.ms.calculator;

import java.util.ArrayList;

import jakarta.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javeriana.ms.calculator.model.Operations;
import javeriana.ms.calculator.repository.OperationsRepository;

@RestController
public class CalculatorController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private OperationsRepository operationsRepository;

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/calculator/addition")
    public String calculatorAdd(@RequestParam int a, @RequestParam int b){
        String response = restTemplate.getForObject("http://addition-service/addition?a={a}&b={b}", String.class, a, b);
        return response;
    }

    @GetMapping("/calculator/addition1")
    public String calculatorAdd1(@RequestParam int a, @RequestParam int b, @RequestParam String user){
        String responseTemp = restTemplate.getForObject("http://addition-service/addition1?a={a}&b={b}&user={user}", String.class, a, b, user);
        float result = Float.valueOf(responseTemp.split(":")[1]);
        String port = responseTemp.split(":")[0];
        operationsRepository.save(new Operations("addition", a, b, result, user, String.valueOf(new java.util.Date())));
        String response = "Microservicio suma corriendo en el puerto " + port + "<br> -> Resultado: " + result + "<br> -> Fecha: " + new java.util.Date() + "<br> -> Usuario: " + user + "<br>";
        response += "<br>¡Resultado almacenado en la base de datos!";
        return response;
    }

    @GetMapping("/calculator/subtraction")
    public String calculatorSub(@RequestParam int a, @RequestParam int b){
        String response = restTemplate.getForObject("http://subtraction-service/subtraction?a={a}&b={b}", String.class, a, b);
        return response;
    }

    @GetMapping("/calculator/subtraction1")
    public String calculatorSub1(@RequestParam int a, @RequestParam int b, @RequestParam String user){
        String responseTemp = restTemplate.getForObject("http://subtraction-service/subtraction1?a={a}&b={b}&user={user}", String.class, a, b, user);
        float result = Float.valueOf(responseTemp.split(":")[1]);
        String port = responseTemp.split(":")[0];
        operationsRepository.save(new Operations("substraction", a, b, result, user, String.valueOf(new java.util.Date())));
        String response = "Microservicio división corriendo en el puerto " + port + "<br> -> Resultado: " + result + "<br> -> Fecha: " + new java.util.Date() + "<br> -> Usuario: " + user;
        response += "<br>¡Resultado almacenado en la base de datos!";
        return response;
    }

    @GetMapping("/calculator/multiplication")
    public String calculatorMult(@RequestParam int a, @RequestParam int b){
        String response = restTemplate.getForObject("http://multiplication-service/multiplication?a={a}&b={b}", String.class, a, b);
        return response;
    }

    @GetMapping("/calculator/multiplication1")
    public String calculatorMult1(@RequestParam int a, @RequestParam int b, @RequestParam String user){
        String responseTemp = restTemplate.getForObject("http://multiplication-service/multiplication1?a={a}&b={b}&user={user}", String.class, a, b, user);
        float result = Float.valueOf(responseTemp.split(":")[1]);
        String port = responseTemp.split(":")[0];
        operationsRepository.save(new Operations("multiplication", a, b, result, user, String.valueOf(new java.util.Date())));
        String response = "Microservicio multiplicación corriendo en el puerto " + port + "<br> -> Resultado: " + result + "<br> -> Fecha: " + new java.util.Date() + "<br> -> Usuario: " + user;
        response += "<br>¡Resultado almacenado en la base de datos!";
        return response;
    }

    @GetMapping("/calculator/division")
    public String calculatorDiv(@RequestParam int a, @RequestParam int b){
        String response = restTemplate.getForObject("http://division-service/division?a={a}&b={b}", String.class, a, b);
        return response;
    }

    @GetMapping("/calculator/division1")
    public String calculatorDiv1(@RequestParam int a, @RequestParam int b, @RequestParam String user){
        String responseTemp = restTemplate.getForObject("http://division-service/division1?a={a}&b={b}&user={user}", String.class, a, b, user);
        float result = Float.valueOf(responseTemp.split(":")[1]);
        String port = responseTemp.split(":")[0];
        operationsRepository.save(new Operations("division", a, b, result, user, String.valueOf(new java.util.Date())));
        String response = "Microservicio resta corriendo en el puerto " + port + "<br> -> Resultado: " + result + "<br> -> Fecha: " + new java.util.Date() + "<br> -> Usuario: " + user;
        response += "<br>¡Resultado almacenado en la base de datos!";
        return response;
    }

    @GetMapping("/services/history")
    @Produces("application/json")
    public ArrayList<Operations> getHistory(){
        ArrayList<Operations> operationsArrayList = (ArrayList<Operations>) operationsRepository.findAll();
        return operationsArrayList;
    }
    
}