package com.atguigu.bookstore.test;

import com.atguigu.bookstore.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author Mr.Helianthus
 * @create 2021-04-20 11:36 AM
 */
public class ConnectionTest {
    @Test
    public void test(){
        Connection connection = JDBCUtils.getConnection();
        System.out.println(connection);
    }
}
