package com.atguigu.bookstore.servlet;

import com.atguigu.bookstore.beans.User;
import com.atguigu.bookstore.service.UserService;
import com.atguigu.bookstore.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mr.Helianthus
 * @create 2021-04-20 4:42 PM
 */
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 从表单中获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        // 2. 校验传入的参数是否正确，是否可以进行注册
        UserService userService = new UserServiceImpl();
        User user = new User(null,username,password,email);
        boolean isRegist = userService.regist(user);
        // - 2.1 注册失败
        if(isRegist){
           System.out.println("注册失败");
            // 注册失败时，利用request域给页面发送失败信息
            request.setAttribute("registErrorMsg","该用户名已经存在不可以注册。");
            request.getRequestDispatcher( "/pages/user/regist.jsp").forward(request,response);
            return;
        }
        // - 2.2 注册成功 : 写入数据库存储，并跳转到成功页面
        userService.addUser(user);
        response.sendRedirect(request.getContextPath() + "/pages/user/regist_success.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
