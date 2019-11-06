package com.staryea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableEurekaClient
//@EnableFeignClients
public class MicroservicecloudWeb7843Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicecloudWeb7843Application.class, args);


		//通过此方式可以启动指定的类，并且可以加载配置文件
//		ConfigurableApplicationContext context = SpringApplication.run(MicroservicecloudWeb7843Application.class,args);
//		Cassandra cassandra=context.getBean(Cassandra.class);
//		Thread thread =new Thread(cassandra);
//		Thread thread1 =new Thread(cassandra);
//		Thread thread2 =new Thread(cassandra);
//		Thread thread3 =new Thread(cassandra);
//		Thread thread4 =new Thread(cassandra);
//		thread.start();
//		thread1.start();
//		thread2.start();
//		thread3.start();
//		thread4.start();
	}

}

