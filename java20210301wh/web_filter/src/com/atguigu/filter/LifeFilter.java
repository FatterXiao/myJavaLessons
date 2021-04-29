package com.atguigu.filter;

import javax.servlet.*;
import java.io.IOException;

public class LifeFilter implements Filter {

    public LifeFilter() {
        System.out.println("LifeFilter对象被创建");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LifeFilter对象被初始化");
        //获取Fiilter的名称
        String filterName = filterConfig.getFilterName();
        System.out.println(filterName);
        //获取Filter的初始化参数
        String user = filterConfig.getInitParameter("user");
        System.out.println(user);
        //获取ServletContext对象
        ServletContext servletContext = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("LifeFilter对象在拦截请求");
    }

    @Override
    public void destroy() {
        System.out.println("LifeFilter对象被销毁");
    }
}
