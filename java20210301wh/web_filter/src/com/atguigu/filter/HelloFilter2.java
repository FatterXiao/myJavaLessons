package com.atguigu.filter;

import javax.servlet.*;
import java.io.IOException;

public class HelloFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    //拦截用户请求的方法
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("②此山是我开，此树是我栽，要想从此过，留下衣服来！");
        //放行请求
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("④又买新衣服了……");
    }

    @Override
    public void destroy() {

    }
}
