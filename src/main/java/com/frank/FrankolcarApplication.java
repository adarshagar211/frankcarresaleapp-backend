package com.frank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class FrankolcarApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrankolcarApplication.class, args);
	}
}
