package javeriana.ms.divms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DivMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DivMsApplication.class, args);
    }

}
