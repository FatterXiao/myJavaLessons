package com.atguigu.ajax.servlet;

import com.atguigu.ajax.bean.Student;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//响应JSON格式的Servlet
@WebServlet(name = "JSONServlet",urlPatterns = "/JSONServlet")
public class JSONServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //假设从数据库中查询到一个Student对象
        Student student = new Student(1, "苍老师", "cls@sls.com");
        //创建Gson对象
        Gson gson = new Gson();
        //将Student对象转换为JSON格式的字符串
        String json = gson.toJson(student);
        System.out.println(json);
        response.setContentType("text/html;charset=utf-8");
        //将JSON字符串响应到浏览器
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
