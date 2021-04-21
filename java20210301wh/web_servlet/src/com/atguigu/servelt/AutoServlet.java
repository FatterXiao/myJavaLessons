package com.atguigu.servelt;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AutoServlet extends HttpServlet {

    //用来处理Post请求
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost方法被调用");
        //request的作用
        //解决POST请求请求中文乱码问题
        request.setCharacterEncoding("UTF-8");
        //1.获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        //2.获取项目的虚拟路径
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        //3.转发
        //获取转发器
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/success.html");
        //转发
        requestDispatcher.forward(request,response);

    }

    //用来处理Get请求
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet方法被调用");
        String username = request.getParameter("username");
        System.out.println(username);
        //response的作用
        //1.给浏览器响应一个字符串或一个页面
        //方式一：在获取流之前设置响应的字符集为GBK
//        response.setCharacterEncoding("GBK");
        //设置响应头告诉浏览器使用什么字符集进行解码，同时编码也使用同样的字符集
        //方式一：直接设置响应内容的类型
        response.setContentType("text/html;charset=utf-8");
        //方式二：设置响应头
//        response.setHeader("Content-Type","text/html;charset=utf-8");

        PrintWriter writer = response.getWriter();
        writer.write("响应成功！");
        //2.重定向
//        response.sendRedirect("WEB-INF/success.html");
        //转发和重定向：能用重定向就不用转发
    }
}
