package com.atguigu.session.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//设置Session对象的最大空闲时间
@WebServlet(name = "SetSessionTimeServlet",urlPatterns = "/SetSessionTimeServlet")
public class SetSessionTimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取Session对象
        HttpSession session = request.getSession();
        //设置Session对象的最大空闲时间
        /*
            setMaxInactiveInterval(int age)
                age>0：Session对象空闲age秒后失效
                age<=0：Session对象永不失效
         */
        //设置Session对象空闲30秒后失效
//        session.setMaxInactiveInterval(30);
        //使Session对象立即失效
        session.invalidate();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
