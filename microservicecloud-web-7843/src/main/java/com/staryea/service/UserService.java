package com.staryea.service;

import com.staryea.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tangdy on 2019/1/23.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private JdbcTemplate template;


    public List<User> getList() {
        List<User> users = template.query("select * from user",new BeanPropertyRowMapper(User.class));
//        List<User> users1 = template.queryForList("select * from user", User.class);
        return users;
    }

    public User getById(Integer id) {
        return null;
    }

    public int add(User user) {
        return 0;
    }

    public int update(User user) {
        return 0;
    }
}