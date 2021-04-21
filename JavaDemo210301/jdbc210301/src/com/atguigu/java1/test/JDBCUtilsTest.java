package com.atguigu.java1.test;


import com.atguigu.java1.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author shkstart
 * @create 11:29
 */
public class JDBCUtilsTest {

    @Test
    public void test1(){
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            System.out.println(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
