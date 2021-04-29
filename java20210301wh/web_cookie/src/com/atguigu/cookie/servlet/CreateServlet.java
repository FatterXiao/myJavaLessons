package com.atguigu.cookie.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//创建Cookie对象的Servlet
@WebServlet(name = "CreateServlet",urlPatterns = "/CreateCookie")
public class CreateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建Cookie对象
        //注意：创建Cookie对象时，名字不能使用汉字，值可以使用汉字，但是需要指定字符集进行编码，获取时还需要指定字符集进行解码，所以不建议使用汉字
        Cookie cookie = new Cookie("user", "zhangsan");
        Cookie cookie1 = new Cookie("user1", "lisi");
        //将Cookie对象发送给浏览器
        response.addCookie(cookie);
        response.addCookie(cookie1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
