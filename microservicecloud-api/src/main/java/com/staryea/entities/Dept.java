package com.staryea.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created by tangdy on 2018/12/13.
 */
@AllArgsConstructor //全参构造函数
@NoArgsConstructor //无参构造函数
@Data //自动生成get set 方法
@Accessors(chain = true) //链式访问
public class Dept implements Serializable {

    private long deptno;

    private String dname;

    private String db_source;

}