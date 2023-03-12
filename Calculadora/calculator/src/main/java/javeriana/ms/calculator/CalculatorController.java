package javeriana.ms.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CalculatorController {
    @Autowired
    RestTemplate restTemplate;

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
        String response = restTemplate.getForObject("http://addition-service/addition1?a={a}&b={b}&user={user}", String.class, a, b, user);
        return response;
    }

    @GetMapping("/calculator/subtraction")
    public String calculatorSub(@RequestParam int a, @RequestParam int b){
        String response = restTemplate.getForObject("http://subtraction-service/subtraction?a={a}&b={b}", String.class, a, b);
        return response;
    }

    @GetMapping("/calculator/subtraction1")
    public String calculatorSub1(@RequestParam int a, @RequestParam int b, @RequestParam String user){
        String response = restTemplate.getForObject("http://subtraction-service/subtraction1?a={a}&b={b}&user={user}", String.class, a, b, user);
        return response;
    }

    @GetMapping("/calculator/multiplication")
    public String calculatorMult(@RequestParam int a, @RequestParam int b){
        String response = restTemplate.getForObject("http://multiplication-service/multiplication?a={a}&b={b}", String.class, a, b);
        return response;
    }

    @GetMapping("/calculator/multiplication1")
    public String calculatorMult1(@RequestParam int a, @RequestParam int b, @RequestParam String user){
        String response = restTemplate.getForObject("http://multiplication-service/multiplication1?a={a}&b={b}&user={user}", String.class, a, b, user);
        return response;
    }

    @GetMapping("/calculator/division")
    public String calculatorDiv(@RequestParam int a, @RequestParam int b){
        String response = restTemplate.getForObject("http://division-service/division?a={a}&b={b}", String.class, a, b);
        return response;
    }

    @GetMapping("/calculator/division1")
    public String calculatorDiv1(@RequestParam int a, @RequestParam int b, @RequestParam String user){
        String response = restTemplate.getForObject("http://division-service/division1?a={a}&b={b}&user={user}", String.class, a, b, user);
        return response;
    }
}