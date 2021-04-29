package com.atguigu.ajax.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//处理通过jQuery发送的Ajax请求的Servlet
@WebServlet(name = "JQueryServlet",urlPatterns = "/JQueryServlet")
public class JQueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("发送的是POST请求");
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        response.setContentType("text/html;charset=utf-8");
        //给浏览器响应一个字符串
        response.getWriter().write("响应成功！");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("发送的是GET请求");
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        response.setContentType("text/html;charset=utf-8");
        //给浏览器响应一个字符串
        response.getWriter().write("响应成功！");
    }
}
