package com.atguigu.bookstore.servlet;

import com.atguigu.bookstore.beans.User;
import com.atguigu.bookstore.service.UserService;
import com.atguigu.bookstore.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //封装User对象
        User user = new User(null, username, password, null);
        //创建UserService对象
        UserService userService = new UserServiceImpl();
        //调用UserService中登录的方法
        User login = userService.login(user);
        //判断login是否为null
        if(login != null){
            //用户名和密码正确，重定向到登录成功页面
            response.sendRedirect(request.getContextPath()+"/pages/user/login_success.html");
        }else{
            //用户名或密码不正确
            //获取转发器
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/user/login_error.html");
            //转发
            requestDispatcher.forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
