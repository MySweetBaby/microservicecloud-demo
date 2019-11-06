package com.staryea.service;

import com.staryea.MicroserviceProviderDept8001Application;
import com.staryea.mapper.IDept;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by tangdy on 2018/12/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MicroserviceProviderDept8001Application.class)
public class DeptServeiceTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Resource
    private IDept dept;



    @Test
    public void getAll() throws Exception {
        System.out.println(dept.getAll());

    }

    @Test
    public void findById() throws Exception {
        System.out.println(dept.findById(1));

    }

}