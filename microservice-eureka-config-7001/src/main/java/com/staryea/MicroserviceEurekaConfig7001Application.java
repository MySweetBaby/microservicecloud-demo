package com.staryea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroserviceEurekaConfig7001Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceEurekaConfig7001Application.class, args);
	}

}

