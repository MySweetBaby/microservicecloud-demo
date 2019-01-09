package com.staryea.service;

import com.staryea.entities.Dept;

import java.util.List;

/**
 * Created by tangdy on 2018/12/26.
 */
public interface IDeptService {
    List<Dept> getAll();

    Dept findById(Integer id);

    boolean addDept(Dept dept);
}
