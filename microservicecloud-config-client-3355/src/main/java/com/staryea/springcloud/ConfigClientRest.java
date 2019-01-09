package com.staryea.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tangdy on 2019/1/8.
 */
@RestController
@RequestMapping("/config")
public class ConfigClientRest {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private String port;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServices;

    @RequestMapping("/client")
    public String getConfig(){
        System.out.println("applicationName is: "+applicationName+"  prot is :"+port+"   eurekaServices is: "+eurekaServices);

        return "applicationName is: "+applicationName+"  prot is :"+port+"   eurekaServices is: "+eurekaServices;

    }

}