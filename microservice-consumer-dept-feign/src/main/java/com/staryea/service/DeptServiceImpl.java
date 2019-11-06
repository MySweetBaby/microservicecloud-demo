package com.staryea.service;

import com.staryea.entities.Dept;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by tangdy on 2019/11/4.
 */
@Component
public class DeptServiceImpl implements IDeptServiceFeign {
    public List<Dept> getAll() {
        return null;
    }

    public Dept findById(@PathVariable("id") Integer id) {
        return null;
    }

    public boolean addDept(Dept dept) {
        return false;
    }
}