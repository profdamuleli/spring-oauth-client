package com.blastza.spring_oauth_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringOauthClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOauthClientApplication.class, args);
	}

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder
				.routes()
				.route(rs -> rs
						.path("/")
						.filters(fs -> fs.tokenRelay())
						.uri("http://localhost:8081"))
				.build();
	}

}
