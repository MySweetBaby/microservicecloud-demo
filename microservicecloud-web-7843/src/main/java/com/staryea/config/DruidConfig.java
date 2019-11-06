package com.staryea.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tangdy on 2019/1/24.
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties("spring.datasource") //此注解可以将配置文件中的属性与实体类进行绑定（即绑定DruidDataSource的属性）
    @Bean
    public DataSource dataSource(){
        return  new DruidDataSource();
    }

    /**
     * 配置druid监控
     * 1、配置一个管理后台的servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String,String> map =new HashMap<String, String>();
        map.put("loginUsername","admin");
        map.put("loginPassword","admin");
        servletRegistrationBean.setInitParameters(map);
        return  servletRegistrationBean;
    }

    /**
     * 配置web监控的filter
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        Map<String,String> map =new HashMap<String, String>();
        map.put("exclusions","*.js,*.css,/druid/*");
        filterRegistrationBean.setInitParameters(map);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        return filterRegistrationBean;
    }
}