package com.atguigu.servlet;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.imp.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mr.Helianthus
 * @create 2021-04-20 9:08 PM
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取登录的用户 和 密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("[接收到用户信息]: 用户名:" + username + "; 密码: " + password);
        // 2. 校验用户名和密码是否正确
        UserService userService = new UserServiceImp();
        User loginUser = userService.login(new User(null, username, password, null));
        // - 2.1 错误时 转发回登录界面;并在request域中传回登录失败的信息
        if(loginUser == null){
            request.setAttribute("loginMsg","登录失败。用户名或者密码不正确");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
            return;
        }
        // - 2.2 正确时 重定向到成功页面
        response.sendRedirect("/mybook/pages/user/login_success.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
