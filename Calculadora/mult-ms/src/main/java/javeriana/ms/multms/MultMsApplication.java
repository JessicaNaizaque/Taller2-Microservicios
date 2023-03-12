package javeriana.ms.multms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MultMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultMsApplication.class, args);
    }

}
