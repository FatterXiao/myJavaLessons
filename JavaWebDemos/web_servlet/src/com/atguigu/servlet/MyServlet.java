package com.atguigu.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Mr.Helianthus
 * @create 2021-04-19 9:38 AM
 */
public class MyServlet implements Servlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
//        ServletConfig servletConfig = getServletConfig();
        String servletName = config.getServletName();
        String initUser = config.getInitParameter("user");

        System.out.println("servletName : " + servletName);
        System.out.println("获取servlet初始化参数user的值: " + initUser);
        ServletContext servletContext = config.getServletContext();
        String encoding = servletContext.getInitParameter("encoding");
        String realPath = servletContext.getRealPath("/.index.jsp");
        System.out.println("servletContext中初始化的参数：" + encoding);
        System.out.println("realPath : " + realPath);

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        PrintWriter writer = res.getWriter();
        writer.write("[MyServlet]: response successfully!");
        System.out.println("getCharacterEncoding: " + res.getCharacterEncoding());
        System.out.println("getContentType: " + res.getContentType());
        System.out.println("getLocale: " + res.getLocale());
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
