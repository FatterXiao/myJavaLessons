package com.atguigu.bookstore.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ★通过德鲁伊连接池获取和释放连接的工具类（重点掌握）
 */
public class JDBCUtils {

    private static DataSource dataSource;

    static {
        try {
            //1.创建Properties对象
            Properties pro = new Properties();
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            //2.将类路径下的properties文件读成一个流
            //3.加载properties文件
            pro.load(is);
            //4.创建数据源
            dataSource = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接的方法
    public static Connection getConnection(){
        Connection connection = null;
        try {
            //从数据源中获取连接
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //释放连接的方法
    public static void releaseConnection(Connection connection){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
