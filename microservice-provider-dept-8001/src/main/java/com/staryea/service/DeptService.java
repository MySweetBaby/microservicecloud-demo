package com.staryea.service;

import com.staryea.mapper.IDept;
import com.staryea.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tangdy on 2018/12/26.
 */
@Service
public class DeptService implements IDeptService {

    @Autowired
    private IDept iDept;

    public List<Dept> getAll() {
        return iDept.getAll();
    }

    public Dept findById(Integer id) {
        return iDept.findById(id);
    }

    public boolean addDept(Dept dept) {
        int result =iDept.addDept(dept);
        return result==1?true:false;
    }

}