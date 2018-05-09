package com.codevik.socialmediaapiintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;

@SpringBootApplication
@EnableReactiveMongoRepositories
@EnableWebFluxSecurity
public class SocialMediaApiIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialMediaApiIntegrationApplication.class, args);
	}
}
