package com.atguigu.bookstore.filter;

import com.atguigu.bookstore.utils.JDBCUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Mr.Helianthus
 * @create 2021-04-29 10:08 AM
 */
@WebFilter(filterName = "TransactionFilter",urlPatterns = "/*")
public class TransactionFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        Connection connection = JDBCUtils.getConnection();

        try {
            // 1. 开启事务
            connection.setAutoCommit(false);
            // 2. 执行事务
            chain.doFilter(req, resp);
            // 3. 提交事务
            connection.commit();
        } catch (Exception throwables) {
            // 出现异常时，回滚；并重定向到错误页面
            try {
                System.out.println("已经执行回滚");
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }finally {
            JDBCUtils.releaseConnection();
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
