package com.atguigu.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Mr.Helianthus
 * @create 2021-04-28 9:12 AM
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
