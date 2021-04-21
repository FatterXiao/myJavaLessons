package com.atguigu.servelt;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

//创建一个类实现Servlet接口
public class HelloServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //处理用户请求的方法
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("您的请求我已经收到");
        //获取一个打印流
        PrintWriter writer = servletResponse.getWriter();
        //给浏览器响应一个字符串（注意：如果响应中文会乱码）
//        writer.write("响应成功！");
//        writer.write("Response Success!");
        writer.print("Response Success!");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
