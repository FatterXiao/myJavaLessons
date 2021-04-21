package com.atguigu.servelt;

import javax.servlet.*;
import java.io.IOException;

public class ServletLife implements Servlet {

    public ServletLife() {
        System.out.println("ServletLife对象被创建");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("ServletLife对象被初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("ServletLife对象在处理请求");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("ServletLife对象被销毁");
    }
}
