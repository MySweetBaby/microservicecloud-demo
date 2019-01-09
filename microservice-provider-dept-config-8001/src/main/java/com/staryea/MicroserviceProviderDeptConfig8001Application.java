package com.staryea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker //开启熔断
public class MicroserviceProviderDeptConfig8001Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProviderDeptConfig8001Application.class, args);
	}

}

