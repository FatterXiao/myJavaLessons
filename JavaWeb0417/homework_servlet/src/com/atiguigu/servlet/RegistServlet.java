package com.atiguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mr.Helianthus
 * @create 2021-04-19 6:25 PM
 */
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 设置字符集
        request.setCharacterEncoding("UTF-8");
        // 2. 获取参数
        String username = request.getParameter("username");// 用户名
        String password = request.getParameter("password");// 密码
        String email = request.getParameter("email");// 邮箱

        // 3. 判断是否可以注册
        if("admin".equals(username)){
            // 失败时，转发
            request.getRequestDispatcher("regist_error.html").forward(request,response);
//            response.sendRedirect("regist_error.html");
            return;
        }
        // 成功时，重定向
        response.sendRedirect("regist_success.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
