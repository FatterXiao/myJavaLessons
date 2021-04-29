package com.atguigu.java1.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 使用数据库连接池获取数据库的连接。
 *
 *
 * 1. 好处：
 * ① 资源可以重复利用
 * ② 提高了程序的执行效率
 * ③ 便于管理
 *
 * 2. 常用的数据库连接池技术：DBCP、C3P0、Druid(推荐)
 *
 * 3. DataSource用来取代DriverManager来获取Connection，获取速度快，
 * 同时可以大幅度提高数据库访问速度。
 *   DataSource就理解为数据库连接池。
 *
 *
 *
 * @author shkstart
 * @create 10:22
 */
public class DruidTest {
    /*
    * 方式1：
    * 使用Druid数据库连接池获取了一个数据库的连接
    *
    * */
    @Test
    public void test() throws SQLException {
        DruidDataSource source = new DruidDataSource();

        //设置获取连接的4个基本信息
        source.setUsername("root");
        source.setPassword("abc123");
        source.setUrl("jdbc:mysql://localhost:3306/test");
        source.setDriverClassName("com.mysql.jdbc.Driver");
        //还可以设置其他的参数
        source.setInitialSize(10);
        source.setMaxActive(100);

        //获取连接
        Connection connection = source.getConnection();
        System.out.println(connection);
    }

    /*
    * 方式二：使用配置文件
    * */
    @Test
    public void test2() throws Exception {

        Properties pros = new Properties();
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
        pros.load(is);

        DataSource source = DruidDataSourceFactory.createDataSource(pros);

        //获取连接
        Connection connection = source.getConnection();
        System.out.println(connection);
    }

}
