package com.atguigu.servelt;

import javax.servlet.*;
import java.io.IOException;

public class MyServletConfig implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //1.获取当前Servlet的名称
        String servletName = servletConfig.getServletName();
        System.out.println("当前Servlet的名称是："+servletName);
        //2.获取当前Servlet的初始化参数
        String initValue = servletConfig.getInitParameter("user");
        System.out.println("当前Servlet的初始化参数user对应的值是："+initValue);
        //3.获取ServletContext对象
        ServletContext servletContext = servletConfig.getServletContext();

        //ServletContext的作用
        //1.获取当前Web应用的初始化参数
        String encoding = servletContext.getInitParameter("encoding");
        System.out.println("Web应用的初始化参数encoding的值是："+encoding);
        //2.获取服务器端资源的真实路径
        String realPath = servletContext.getRealPath("/index.jsp");
        System.out.println("项目中的index.jsp在服务器端的真实路径是："+realPath);
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
