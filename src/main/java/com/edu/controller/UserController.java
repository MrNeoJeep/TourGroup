package com.edu.controller;

import com.alibaba.druid.util.StringUtils;
import com.edu.pojo.User;
import com.edu.service.user.UserService;
import com.edu.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login.do")
    public String login(String username,String password, HttpSession session){
        String msg = "fail";

        User user = userService.queryUserByName(username);
        String InputPwd = MD5Utils.inputPassToFormPass(password);


        if(InputPwd.equals(user.getPassword())){
            session.setAttribute("loginUser",user);
            session.setAttribute("username",user.getUsername());
            msg = "success";
        }

        return msg;
    }

    @RequestMapping("/register.do")
    public String register(String username,String password){
        String msg = "fail";
        User user = new User(-1,username, MD5Utils.inputPassToFormPass(password));
        int i = userService.addUser(user);
        if(i > 0){
            msg = "success";
        }
        return msg;
    }

}
