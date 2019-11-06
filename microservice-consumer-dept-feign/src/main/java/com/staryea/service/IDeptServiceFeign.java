package com.staryea.service;

import com.staryea.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by tangdy on 2019/9/3.
 */
@FeignClient(value = "microservice-provider-dept",fallback = DeptServiceImpl.class)
public interface IDeptServiceFeign {

    @RequestMapping("/dept/list")
    List<Dept> getAll();

    @RequestMapping("/dept/getById/{id}")
    Dept findById(@PathVariable("id") Integer id);

    @RequestMapping("/dept/add")
    boolean addDept(Dept dept);
}
