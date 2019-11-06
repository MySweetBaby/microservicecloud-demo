package com.staryea;

import com.staryea.ruler.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
/**
在启动该微服务的时候加载自定义的Ribbon配置类，从而使配置生效  自定义配置类不能放在@componentScan所扫描的包以及子包下
否则自定义的ribbon的配置类会被所有的ribbon客户端所共享，就不能达到特殊化的目的
 */
@RibbonClient(name = "microservice-provider-dept",configuration =MySelfRule.class )
public class MicroserviceConsumerDept80Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConsumerDept80Application.class, args);
	}

}

