package com.atguigu.jdbc.test;

import com.atguigu.jdbc.JDBCutils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
/**
 * @author Mr.Helianthus
 * @create 2021-04-11 9:31 PM
 */
public class JDBCUtilsTest {
    @Test
    public void test() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        if(connection != null){
            System.out.println("success connecting.");
        }else {
            System.out.println("fail to connect");
        }
    }


    @Test
    public  void test01(){
//        LocalDateTime date= strToDate("2021-04-04 11:50:00","yyyy-MM-dd hh:mm:ss");
//        System.out.println(date);


    }
}
