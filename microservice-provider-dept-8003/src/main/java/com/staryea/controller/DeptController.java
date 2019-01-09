package com.staryea.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.staryea.entities.Dept;
import com.staryea.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tangdy on 2018/12/28.
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    IDeptService deptService;

    @Autowired
    private DiscoveryClient client;//服务发现

    @RequestMapping("/getById/{id}")
//    @HystrixCommand(fallbackMethod ="getResult") //服务熔断 在服务端定义
    public Dept getById(@PathVariable("id") Integer id){
        Dept dept = deptService.findById(id);
        if(null==dept) throw new RuntimeException("未查询到数据");
        return  dept;
    }

    @RequestMapping("/list")
    public List<Dept> list(){
        return  deptService.getAll();
    }

    @RequestMapping("/add")
    public boolean add(Dept dept){
        return  deptService.addDept(dept);
    }

    @RequestMapping("/discovery")
    public Object discovery(){
        List<String> list = client.getServices();
        System.out.println("list is "+list);
        List<ServiceInstance> serviceInstanceList = client.getInstances("microservice-provider-dept");
        for (ServiceInstance serviceInstance : serviceInstanceList) {
            System.out.println("host is "+serviceInstance.getHost()+"/t port is "+serviceInstance.getPort()+
            "/t uri is "+serviceInstance.getUri()+"/t serviceId is "+serviceInstance.getServiceId());
        }
        return  this.client;
    }

    public Dept getResult(@PathVariable("id") Integer id){
        return new Dept(id,"未查询到id为"+id+"的相关信息 null @hystrixComment","unknown database");
    }
}