package com.atguigu.cookie.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//设置Cookie对象的有效时间
@WebServlet(name = "PersistCookieServlet",urlPatterns = "/PersistCookieServlet")
public class PersistCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建一个Cookie对象
        Cookie cookie = new Cookie("persistCookie", "persistValue");
        //设置Cookie对象的有效时间
        /*
            setMaxAge(int age)
                age>0：Cookie对象age秒后失效
                age=0：Cookie对象立即失效
                age<0：默认，会话级别的Cookie对象
         */
        cookie.setMaxAge(-1);
        //将Cookie对象响应给浏览器
        response.addCookie(cookie);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
