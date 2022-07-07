package com.edu.config;

import com.edu.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User loginUser = (User) request.getSession().getAttribute("loginUser");
//        System.out.println("拦截器 = "+username);
        if(loginUser != null){
            return true;
        }else {
            request.getRequestDispatcher("/to/login").forward(request,response);
            return false;
        }
    }
}