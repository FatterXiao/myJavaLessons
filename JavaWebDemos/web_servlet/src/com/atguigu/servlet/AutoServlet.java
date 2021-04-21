package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mr.Helianthus
 * @create 2021-04-19 2:33 PM
 */
@WebServlet(name = "AutoServlet",urlPatterns = "/AutoServlet")
public class AutoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("调用doPost方法");
        // 1. 获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username : " + username);
        System.out.println("password : " + password);
        // 2.
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("调用doGet方法");
        doPost(request,response);
    }
}
