package com.staryea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class MicroservicecloudHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicecloudHystrixDashboardApplication.class, args);
	}

}

