package com.atguigu.bookstore.servlet;

import com.atguigu.bookstore.beans.User;
import com.atguigu.bookstore.service.UserService;
import com.atguigu.bookstore.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistServlet",urlPatterns = "/RegistServlet")
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户输入的用户名、密码、邮箱
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        //封装User对象
        User user = new User(null, username, password, email);
        //创建UserService对象
        UserService userService = new UserServiceImpl();
        //调用UserService中注册的方法
        boolean regist = userService.regist(user);
        if(regist){
            //用户名已存在
            //转发到注册页面
            request.getRequestDispatcher("/pages/user/regist.html").forward(request,response);
        }else{
            //用户名可用，将用户信息保存到数据库中
            userService.addUser(user);
            //重定向到注册成功页面
            response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.html");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
