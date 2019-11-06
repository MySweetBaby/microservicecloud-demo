package com.staryea.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

/**
 * Created by tangdy on 2019/1/12.
 */
@Controller
public class Test {

    private Logger log = LoggerFactory.getLogger(Test.class);

//    @Autowired
//    private IDeptServiceFeign iDeptServiceFeign;

//    @Autowired
//    private CassandraTemplate cassandraTemplate;

//    @RequestMapping("/success")
//    public String test(Map<String,Object> map){
//        map.put("hello","你好");
//        log.debug("调用微服务查询到数据："+iDeptServiceFeign.getAll());
//        map.put("dept",iDeptServiceFeign.getAll());
//        return "success";
//    }
//
//    @RequestMapping("/test")
//    @ResponseBody
//    public String testList(){
//        return iDeptServiceFeign.getAll().toString();
//    }

//    public Boolean createTable(){
//        boolean flag=true;
//        Dept dept =new Dept();
//        dept.setDeptno(1);
//        dept.setDname("数据部");
//        dept.setDb_source("test_database");
//        Session session=cassandraTemplate.getSession();
//
//        cassandraTemplate.insert(dept);
//        cassandraTemplate.select("", Dept.class);
//        return flag;
//    }


}