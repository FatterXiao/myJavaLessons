package com.atguigu.servelt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
    从Servlet3.0开始支持基于注解的方式映射请求地址
        @WebServlet注解中的属性：
            name属性：用来设置Servlet的名称
            urlPatterns属性：用来设置映射的请求地址

 */
//@WebServlet(name = "AutoServlet2",urlPatterns = "/AutoServlet2")
@WebServlet("/AutoServlet2")
public class AutoServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("表单提交成功！");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用doPost方法
        doPost(request,response);
    }
}
