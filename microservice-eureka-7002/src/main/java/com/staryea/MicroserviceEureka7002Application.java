package com.staryea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroserviceEureka7002Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceEureka7002Application.class, args);
	}

}

