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

/**
 * @author Mr.Helianthus
 * @create 2021-04-20 3:19 PM
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取参数: 用户名 和 密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User(null,username,password,null);
        UserService userService = new UserServiceImpl();
        User login = userService.login(user);
        // 2. 验证登录
        // - 2.1登录失败
        if(login == null){
//            System.out.println("登录失败：" + user.toString());
            // 利用request域传入登录失败的信息
            request.setAttribute("loginError","登录失败。用户名或密码不正确。");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
            return;
        }
        // - 2.2 登录成功,并把用户的登录信息放入session域中
        request.getSession().setAttribute("user",login);
        response.sendRedirect(request.getContextPath() + "/pages/user/login_success.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
