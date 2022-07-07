package com.edu.config;

import com.edu.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        User loginUser = (User) request.getSession().getAttribute("loginUser");
        String username = (String) request.getSession().getAttribute("username");
//        System.out.println("拦截器 = "+loginUser);
//        System.out.println("拦截器2 = "+username);
        if(username != null){
            return true;
        }else {
            request.getRequestDispatcher("/to/login").forward(request,response);
            return false;
        }
    }
}