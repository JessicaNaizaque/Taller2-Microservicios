package javeriana.ms.addms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AddMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddMsApplication.class, args);
	}

}
