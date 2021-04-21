package com.atiguigu.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mr.Helianthus
 * @create 2021-04-19 5:32 PM
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // 1. 获取登录的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        // 2. 判断参数是否正确
        // 2.1 登录失败
        if(!"admin".equals(username) || !"123456".equals(password)){
            response.sendRedirect("login_error.html");
            return;
        }
        // 2.2 登录成功
        response.sendRedirect("login_success.html");
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.html");
//        requestDispatcher.forward(request,response);
//        response.setContentType("text/html;charset=utf-8");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
