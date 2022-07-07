package com.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/to")
public class RouterController {

    //后台
    @RequestMapping("/admin")
    public String toAdmin(){
        return "admin/xAdmin";
    }
    //进入登录页面
    @RequestMapping("/login")
    public String toLogin(){
        return "admin/login";
    }

    //进入注册页面
    @RequestMapping("/register")
    public String toRegister(){
        return "admin/register";
    }

    @RequestMapping("/userInfo")
    public String toUserInfo() {return "admin/userInfo";}

}
