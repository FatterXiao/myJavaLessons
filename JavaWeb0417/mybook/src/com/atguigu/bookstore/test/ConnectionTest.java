package com.atguigu.bookstore.test;

import com.atguigu.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author Mr.Helianthus
 * @create 2021-04-19 11:20 PM
 */
public class ConnectionTest {

    @Test
    public void test(){
        Connection connection = JDBCUtils.getConnection();
        System.out.println(connection);
    }
}
