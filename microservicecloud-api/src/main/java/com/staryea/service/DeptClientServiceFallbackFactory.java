package com.staryea.service;

import com.staryea.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by tangdy on 2019/1/4.
 * 服务降级是在客户端进行
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<IDeptServiceFeign> {

    public IDeptServiceFeign create(Throwable throwable) {
        return new IDeptServiceFeign() {
            public List<Dept> getAll() {
                return null;
            }

            public Dept findById(@PathVariable("id") Integer id) {
                return new Dept(id,"未查询到id为"+id+"的相关信息 服务已经被降级","unknown database");
            }

            public boolean addDept(Dept dept) {
                return false;
            }
        };
    }
}