package com.atguigu.java1.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author shkstart
 * @create 11:27
 */
public class JDBCUtils {
    private static DataSource source = null;
    static{
        try {
            Properties pros = new Properties();
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
            pros.load(is);

            source = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取数据库的连接（使用Druid数据库连接池）
     * @return
     */
    public static Connection getConnection() throws Exception {
        //获取连接
        Connection connection = source.getConnection();
        return connection;
    }

    /**
     * 关闭连接的操作
     * @param connection
     */
    public static void closeResouce(Connection connection){
        try {
            if(connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
