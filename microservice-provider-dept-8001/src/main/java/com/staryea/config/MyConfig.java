package com.staryea.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by tangdy on 2019/1/24.
 */
@Configuration
public class MyConfig {

    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator(){
        return new KeyGenerator() {
            public Object generate(Object o, Method method, Object... objects) {
                return method.getName()+ Arrays.asList(objects).toString();
            }
        };
    }

}