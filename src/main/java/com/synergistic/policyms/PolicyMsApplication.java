package com.synergistic.policyms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class PolicyMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolicyMsApplication.class, args);
	}

}
