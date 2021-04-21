package com.atguigu.bookstore.servlet;

import com.atguigu.bookstore.beans.User;
import com.atguigu.bookstore.service.UserService;
import com.atguigu.bookstore.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet",urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //优化一：
        //获取请求参数method
        String method = request.getParameter("method");
        if("login".equals(method)){
            //证明在登录，调用当前类中的login方法
            login(request,response);
        }else if("regist".equals(method)){
            //证明在注册，调用当前类中的regist方法
            regist(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    //登录的方法
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            response.sendRedirect(request.getContextPath()+"/pages/user/login_success.jsp");
        }else{
            //用户名或密码不正确，设置一个提示信息放到request域中
            request.setAttribute("msg","用户名或密码不正确！");
            //获取转发器
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/user/login.jsp");
            //转发
            requestDispatcher.forward(request,response);
        }
    }

    //注册的方法
    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            //用户名已存在，设置一个提示信息放到request域中
            request.setAttribute("msg","用户名已存在！");
            //转发到注册页面
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
        }else{
            //用户名可用，将用户信息保存到数据库中
            userService.addUser(user);
            //重定向到注册成功页面
            response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.jsp");
        }
    }
}
