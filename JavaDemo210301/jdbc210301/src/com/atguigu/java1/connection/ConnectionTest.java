package com.atguigu.java1.connection;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Properties;

/**
 * 获取MySQL数据库的连接
 *
 *
 *  url的格式：
 *  jdbc:mysql://localhost:3306/test
 *  协议 子协议   ip地址  端口号  数据库名
 *
 *
 *  http://localhost:8080/myMall/cart/abc.txt?username=Tom
 *
 * @author shkstart
 * @create 9:12
 */
public class ConnectionTest {

    /*
    * 连接的方式一：
    * 要想获取数据库的连接：
    * 1. 需要提供Driver的实现类对象、url、user、password
    * 2. mysql的服务需要是开启状态
    * 3. 要访问的数据库需要是存在的。如下例中的test数据库
    * 4. 导入mysql的驱动
    * */
    @Test
    public void test1() throws SQLException {
        //创建一个实现了Driver接口的mysql数据库中的实现类的对象
        Driver driver = new com.mysql.jdbc.Driver();
        //注册驱动
        DriverManager.registerDriver(driver);

        //获取连接
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "abc123";
        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);

    }

    /*

    体会：面向接口编程

    * 连接的方式二：通过反射的方式创建Driver的实例
    * */
    @Test
    public void test2() throws Exception {
        //创建一个实现了Driver接口的mysql数据库中的实现类的对象，通过反射的方式
        String className = "com.mysql.jdbc.Driver";
        Class clazz = Class.forName(className);
        Driver driver = (Driver) clazz.getDeclaredConstructor().newInstance();
        //注册驱动
        DriverManager.registerDriver(driver);

        //获取连接
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "abc123";
        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);

//        Statement statement = connection.createStatement();
//        statement.execute("");

    }

    /*
    * 连接的方式三：省略通过DriverManager实现注册的操作。只需要加载Driver类即可。
    * */
    @Test
    public void test3() throws Exception {
        //创建一个实现了Driver接口的mysql数据库中的实现类的对象，通过反射的方式
//        String className = "com.mysql.jdbc.Driver";
//        Class clazz = Class.forName(className);
//        Driver driver = (Driver) clazz.getDeclaredConstructor().newInstance();
        //注册驱动
//        DriverManager.registerDriver(driver);

        /*
        * 为什么上述过程可以省略？
        *
        * 因为在com.mysql.jdbc.Driver类中声明有如下的静态代码块，在Driver类加载时执行：
        *
        *  static {
                try {
                    java.sql.DriverManager.registerDriver(new Driver());
                } catch (SQLException E) {
                    throw new RuntimeException("Can't register driver!");
                }
            }
        *
        * */

        //加载驱动
        String className = "com.mysql.jdbc.Driver";
        Class.forName(className);


        //获取连接
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "abc123";
        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);

    }
    /*
    连接的方式四：通过读取配置文件的方式，获取连接的基本信息

    使用配置文件的好处：
    1. 实现代码和数据的分离，解耦。后期需要调整配置信息的话，直接调整配置文件即可
    2. 如果修改配置信息的话，使用配置文件的方式，不需要对代码进行重写编译、打包。节省时间、避免重新打包出错。

     */
    @Test
    public void test4() throws Exception {
        //读取配置文件中的配置信息
        Properties pros = new Properties();

        //方式1：
        FileInputStream is = new FileInputStream(new File("src/jdbc.properties"));
        //方式2：
//        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        pros.load(is);
        //获取4个连接的基本信息
        String user = pros.getProperty("user");
        String password = pros.getProperty("pwd");
        String driverClass = pros.getProperty("driverClass");
        String url = pros.getProperty("url");

        //加载驱动
        Class.forName(driverClass);

        //获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
        String sql = "";
        PreparedStatement ps = connection.prepareStatement(sql);
//        ps.setObject();

        ps.execute();
        ResultSetMetaData metaData = ps.getMetaData();

    }


}
