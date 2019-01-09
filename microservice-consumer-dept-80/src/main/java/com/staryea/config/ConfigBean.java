package com.staryea.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by tangdy on 2018/12/28.
 */
@Configuration //加上此注解表示当前类为spring的配置类，等同于spring 中的applicationContext.xml 文件中的配置
public class ConfigBean {

    @Bean
    @LoadBalanced //负载均衡ribbon
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }

//    @Bean
//    public IRule myRule(){//可以通过自定义加载规则来使ribbon使用自定义的负载规则
//        return  new RandomRule();
//    }
}