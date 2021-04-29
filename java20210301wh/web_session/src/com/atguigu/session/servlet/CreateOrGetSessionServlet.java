package com.atguigu.session.servlet;

import com.atguigu.session.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//创建或获取Session对象的Servlet
@WebServlet(name = "CreateOrGetSessionServlet",urlPatterns = "/CreateOrGetSessionServlet")
public class CreateOrGetSessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建或获取Session对象
        HttpSession session = request.getSession();
        //获取Session对象的id值
        String id = session.getId();
        System.out.println("Session对象的ID值是："+id);
        //创建User对象
        User user = new User(1, "安小妮", "anxiaoni@xxx.com");
        //向Session对象中保存数据
//        session.setAttribute("user","admin");
        session.setAttribute("user",user);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
