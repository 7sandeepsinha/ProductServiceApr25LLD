package dev.sandeep.ProductServiceApr25;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProductServiceApr25Application {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApr25Application.class, args);
	}

}
