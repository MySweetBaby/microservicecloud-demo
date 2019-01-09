package com.staryea.controller;

import com.staryea.entities.Dept;
import com.staryea.service.IDeptServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tangdy on 2019/1/3.
 */
@RestController
@RequestMapping("/feign")
public class DeptFeignController {

    @Autowired
    IDeptServiceFeign deptService;

    @RequestMapping("/getById/{id}")
    public Dept getById(@PathVariable("id") Integer id){
        return  deptService.findById(id);
    }

    @RequestMapping("/list")
    public List<Dept> list(){
        return  deptService.getAll();
    }

    @RequestMapping("/add")
    public boolean add(Dept dept){
        return  deptService.addDept(dept);
    }


}