package com.staryea.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * Created by tangdy on 2019/1/23.
 */

@AllArgsConstructor //全参构造函数
@NoArgsConstructor //无参构造函数
@Data //自动生成get set 方法
@Accessors(chain = true) //链式访问
public class User {

    private Integer id;

    private String name;

    private Integer sex;

    private String address;

    private Date birth;

    private String phone;
}