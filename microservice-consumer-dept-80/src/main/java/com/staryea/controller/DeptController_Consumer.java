package com.staryea.controller;

import com.staryea.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by tangdy on 2018/12/28.
 */
@RestController
@RequestMapping("/consumer")
public class DeptController_Consumer {

//    private static final String DEPT_URL="http://127.0.0.1:8001";
    private static final String DEPT_URL="http://microservice-provider-dept";//通过微服务调用

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/dept/getById/{id}")
    public Dept get(@PathVariable("id") Long id){ //读操作用get
        return restTemplate.getForObject(DEPT_URL+"/dept/getById/"+id,Dept.class);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping("/dept/list")
    public List<Dept> getList(){
        return restTemplate.getForObject(DEPT_URL+"/dept/list",List.class);
    }

    @RequestMapping("/dept/add")
    public boolean add(Dept dept){ //写操作用post
        return  restTemplate.postForObject(DEPT_URL+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping("/dept/discovery")
    public Object discovery(Dept dept){ //写操作用post
        return  restTemplate.postForObject(DEPT_URL+"/dept/discovery",dept,Object.class);
    }
}