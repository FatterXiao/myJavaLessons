package com.atguigu.cookie.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//修改Cookie对象的Servlet
@WebServlet(name = "ModifyCookieServlet",urlPatterns = "/ModifyCookies")
public class ModifyCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取所有的Cookie对象
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies) {
                //获取Cookie对象的名字
                String name = cookie.getName();
                //需求：修改名字为user的Cookie对象
                // 判断是否是要修改的Cookie对象
                if("user".equals(name)){
                    //修改该Cookie对象的值
                    cookie.setValue("superAdmin");
                    //注意：将修改之后的Cookie对象发送给浏览器
                    response.addCookie(cookie);
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
