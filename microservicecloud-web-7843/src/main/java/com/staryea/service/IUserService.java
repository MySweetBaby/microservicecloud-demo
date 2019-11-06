package com.staryea.service;

import com.staryea.entity.User;

import java.util.List;

/**
 * Created by tangdy on 2019/1/23.
 */
public interface IUserService {

    List<User> getList();

    User getById(Integer id);

    int add(User user);

    int update(User user);

}
