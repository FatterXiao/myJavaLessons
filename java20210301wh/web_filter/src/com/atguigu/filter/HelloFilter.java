package com.atguigu.filter;

import javax.servlet.*;
import java.io.IOException;

public class HelloFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    //拦截用户请求的方法
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("①此山是我开，此树是我栽，要想从此过，留下买路财！");
        //放行请求
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("⑤你又回来了……");
    }

    @Override
    public void destroy() {

    }
}
