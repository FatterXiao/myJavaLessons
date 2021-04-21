package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "RegistServlet",urlPatterns = "/RegistServlet",
        initParams = @WebInitParam(name = "username",value = "admin"
        ))
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String user = getServletConfig().getInitParameter("username");
        //假设用户名是admin，密码是123456
        if(user.equals(username)){
            //用户名已存在
            //转发到注册页面
            request.getRequestDispatcher("pages/regist.html").forward(request,response);
        }else{
            //用户名可用，将用户信息保存到数据库中
            //重定向到注册成功页面
            response.sendRedirect("pages/regist_success.html");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
