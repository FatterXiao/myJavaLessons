package com.atguigu.jdbc.JDBCutils;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Mr.Helianthus
 * @create 2021-04-11 9:02 PM
 */
public class JDBCUtils {
    private static DataSource dataSource = null;
    static{
        try {
            Properties pro = new Properties();
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
//            FileInputStream is = new FileInputStream("druid.properties");
            pro.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            // todo: print error logs "..."
            e.printStackTrace();
        }
    }


    /**
     * 获取连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return  dataSource.getConnection();
    }

    public static void closeConnection(Connection connection){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
