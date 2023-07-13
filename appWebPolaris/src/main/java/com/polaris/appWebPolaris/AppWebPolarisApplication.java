package com.polaris.appWebPolaris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AppWebPolarisApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppWebPolarisApplication.class, args);
	}

}
