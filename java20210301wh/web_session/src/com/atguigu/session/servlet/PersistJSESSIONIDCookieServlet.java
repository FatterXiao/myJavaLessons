package com.atguigu.session.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//持久化名字为JSESSIONID的Cookie对象的Servlet
@WebServlet(name = "PersistJSESSIONIDCookieServlet",urlPatterns = "/PersistJSESSIONIDCookieServlet")
public class PersistJSESSIONIDCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取Cookie对象
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies) {
                //获取Cookie对象的名字
                String name = cookie.getName();
                if("JSESSIONID".equals(name)){
                    //设置该Cookie对象的有效时间
                    cookie.setMaxAge(120);
                    //将该Cookie对象发送给浏览器
                    response.addCookie(cookie);
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
