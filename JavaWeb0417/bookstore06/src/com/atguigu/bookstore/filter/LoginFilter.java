package com.atguigu.bookstore.filter;

import com.atguigu.bookstore.beans.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mr.Helianthus
 * @create 2021-04-28 11:42 AM
 */
public class LoginFilter implements Filter {
    public void destroy() {
    }

    /**
     * 结账前，需要过滤检测是否已经登录
     *
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        // 获取session域中的用户信息
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            // 已经登录则放行，可以进行结账
            chain.doFilter(request, response);
        }else {
            // 未登录，回传需要登录的提示，转发到登录界面
            request.setAttribute("loginError","您还未登录，请先登录。");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
