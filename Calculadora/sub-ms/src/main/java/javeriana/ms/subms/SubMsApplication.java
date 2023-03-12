package javeriana.ms.subms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SubMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubMsApplication.class, args);
	}

}
