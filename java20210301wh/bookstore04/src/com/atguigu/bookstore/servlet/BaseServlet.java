package com.atguigu.bookstore.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
//注意：以后再创建Servlet时，继承BaseServlet，并且不要重写BaseServlet中的doGet和doPost方法
public class BaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //优化一：
        //获取请求参数method
//        String method = request.getParameter("methodName");
//        if("login".equals(method)){
//            //证明在登录，调用当前类中的login方法
//            login(request,response);
//        }else if("regist".equals(method)){
//            //证明在注册，调用当前类中的regist方法
//            regist(request,response);
//        }
        //在第一次获取请求参数之前设置字符集
        request.setCharacterEncoding("UTF-8");
        //优化二：
        //1.获取要调用的方法的方法名
        String methodName = request.getParameter("methodName");
        try {
            //2.获取方法对象
            //第一个参数是方法名，第二个参数是调用方法时传入的参数的类型
            Method method = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //3.设置访问权限
            method.setAccessible(true);
            //4.调用方法
            //第一个参数是要调用那个对象的方法；第二个参数是调用方法时要传入的参数
            method.invoke(this,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
