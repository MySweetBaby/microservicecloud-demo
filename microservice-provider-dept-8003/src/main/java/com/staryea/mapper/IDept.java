package com.staryea.mapper;

import com.staryea.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by tangdy on 2018/12/17.
 */

@Mapper
public interface IDept {

    List<Dept> getAll();

    Dept findById(Integer id);

    int addDept(Dept dept);

}
