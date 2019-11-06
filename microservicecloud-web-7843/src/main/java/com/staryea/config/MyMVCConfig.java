package com.staryea.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by tangdy on 2019/1/21.
 */
@Configuration
public class MyMVCConfig extends WebMvcConfigurerAdapter {

    /**
     * 视图解析器，将页面绑定到指定的请求上
     * @param viewControllerRegistry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry viewControllerRegistry){
        viewControllerRegistry.addViewController("/index.html").setViewName("login");

    }

    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // /** 拦截所有的请求，excludePathPatterns 排除请求，静态资源springboot已经做了映射，所以不用处理
         registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/user/login","/",
                 "/star","/index.html");
    }

    @Bean //所有的WebMvcConfigurerAdapter组件会一起起作用
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }
        };
        return adapter;
    }



//    @Bean
//    public ResourceBundleMessageSource messageSource(){
//        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//        messageSource.setUseCodeAsDefaultMessage(true);
//        messageSource.setFallbackToSystemLocale(false);
//        messageSource.setBasenames("login","common_messages");
//        messageSource.setDefaultEncoding("UTF-8");
//        messageSource.setCacheSeconds(2);
//        return messageSource;
//
//    }

}