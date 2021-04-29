package com.atguigu.cookie.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//获取Cookie对象的Servlet
@WebServlet(name = "GetCookiesServlet",urlPatterns = "/GetCookies")
public class GetCookiesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取Cookie对象
        Cookie[] cookies = request.getCookies();
        //遍历
        if(cookies != null){
            for (Cookie cookie : cookies) {
                //获取Cookie对象的名字
                String name = cookie.getName();
                //获取Cookie对象的值
                String value = cookie.getValue();
                System.out.println("Cookie对象的名字是："+name);
                System.out.println("Cookie对象的值是："+value);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
