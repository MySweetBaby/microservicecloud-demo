package com.staryea.service;

import com.staryea.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by tangdy on 2019/1/3.
 * 将所有的熔断方法写在fallbackFactory属性后的类中，实现熔断与业务的分离
 */
//@FeignClient(value = "microservice-provider-dept")
@FeignClient(value = "microservice-provider-dept",fallbackFactory = DeptClientServiceFallbackFactory.class) //带有熔断机制
public interface IDeptServiceFeign {

    @RequestMapping("/dept/list")
    List<Dept> getAll();

    @RequestMapping("/dept/getById/{id}")
    Dept findById(@PathVariable("id") Integer id);

    @RequestMapping("/dept/add")
    boolean addDept(Dept dept);
}
