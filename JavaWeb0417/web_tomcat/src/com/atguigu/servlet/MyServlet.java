package com.atguigu.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Mr.Helianthus
 * @create 2021-04-18 2:36 PM
 */
public class MyServlet implements Servlet {

    public MyServlet() {
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        PrintWriter writer = servletResponse.getWriter();
        writer.write("adjlksajdl");
        writer.print("ldjskl");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
