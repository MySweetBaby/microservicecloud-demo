package com.staryea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy //可以通过设置网关（在hosts中设置IP域名映射，然后通过微服务名称加上请求地址来访问微服务 ef:http://zuul/com:8080/微服务名称/请求地址）
public class MicroservicecloudZuulGateway9527Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicecloudZuulGateway9527Application.class, args);
	}

}

