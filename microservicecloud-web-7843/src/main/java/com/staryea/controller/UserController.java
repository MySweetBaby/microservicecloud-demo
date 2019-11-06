package com.staryea.controller;

import com.staryea.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by tangdy on 2019/1/22.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password, Map<String,Object> map, HttpSession session) {
        if(!StringUtils.isEmpty(username)&&"admin".equals(password)){
//            return "dashboard";
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";//登录成功，重定向到main.html main.html绑定了视图到成功页面，这样可以防止表单重复提交
        }else {
            map.put("msg","用户名或密码错误");
            return "login";
        }

    }

    @GetMapping("/users")
    public String getList(Map<String,Object> map){
        // thymeleaf模板引擎的前缀classpath:/templates/   后缀：.html  thymeleaf会进行自动拼串
        map.put("users",userService.getList());
        return "user/list";
    }

}