package com.fedor.futbolin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.fedor.futbolin.repository")
public class FutbolinApplication {

	public static void main(String[] args) {
		SpringApplication.run(FutbolinApplication.class, args);
	}

}
