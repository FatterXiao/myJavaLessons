package com.atguigu.cookie.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //假设用户名和密码正确
        //获取复选框的值
        String checkMe = request.getParameter("checkMe");
        //判断是否要7天内免登录
        if(checkMe != null){
            //创建两个Cookie对象保存用户名和密码
            Cookie usernameCookie = new Cookie("username", username);
            Cookie passwordCookie = new Cookie("password", password);
            //设置两个Cookie对象的有效时间为7天
            usernameCookie.setMaxAge(7*24*60*60);
            passwordCookie.setMaxAge(7*24*60*60);
            //将两个Cookie对象发送给浏览器
            response.addCookie(usernameCookie);
            response.addCookie(passwordCookie);
        }
        //重定向到登录成功页码
        response.sendRedirect(request.getContextPath()+"/success.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
