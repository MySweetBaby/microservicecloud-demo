package com.staryea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
@EnableCircuitBreaker //开启熔断器
public class MicroserviceProviderDept8003Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProviderDept8003Application.class, args);
	}

}

