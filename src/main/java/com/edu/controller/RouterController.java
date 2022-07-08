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

    //进入创建活动页面
    @RequestMapping("/createAct")
    public String toCreateAct(){
        return "admin/createAct";
    }

    @RequestMapping("/test")
    public String toTest(){
        return "admin/test";
    }

    @RequestMapping("/head")
    public String toHead(){
        return "admin/head";
    }

}
