package com.atguigu.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //获取LoginServlet中配置的初始化参数：用户名和密码
        //获取ServletConfig对象
        ServletConfig servletConfig = getServletConfig();
        //获取初始化参数
        String user = servletConfig.getInitParameter("username");
        String pwd = servletConfig.getInitParameter("password");
        //判断用户输入的用户名和密码是否正确
        if(user.equals(username) && pwd.equals(password)){
            //用户名和密码正确
            //重定向到登录成功的页面
            response.sendRedirect("pages/login_success.html");
        }else{
            //用户名或密码不正确
            //转发到登录页面
            //获取转发器
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/login.html");
            //进行请求的转发
            requestDispatcher.forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
