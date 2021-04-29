package com.atguigu.java2.crud;

import com.atguigu.java1.util.JDBCUtils;
import com.atguigu.java2.javabean.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import javax.xml.ws.handler.Handler;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 下面测试查询的操作
 *
 * @author shkstart
 * @create 14:18
 */
public class QueryTest {

    /*
    BeanHandler :  对应查询表中的一条记录，并返回此一条记录对应的Java类的一个对象。
     */
    @Test
    public void test1(){
        Connection connection = null;

        try {
            //1. 获取数据库的连接
            connection = JDBCUtils.getConnection();
            //2. 创建QueryRunner的实例
            QueryRunner runner = new QueryRunner();

            //3. 调用query()方法
            String sql = "SELECT id,NAME,email,birth FROM customers WHERE id = ?";
            //创建一个ResultSetHandler实现类的对象
            ResultSetHandler<Customer> handler = new BeanHandler<>(Customer.class);
            Customer customer = runner.query(connection, sql, handler, 13);
            System.out.println(customer);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //4. 关闭资源
            JDBCUtils.closeResouce(connection);
        }





    }
    /*
    BeanListHandler :  对应查询表中的多条记录，并返回多条记录对应的Java类的多个对象构成的集合。
     */
    @Test
    public void test2(){
        Connection connection = null;

        try {
            //1. 获取数据库的连接
            connection = JDBCUtils.getConnection();
            //2. 创建QueryRunner的实例
            QueryRunner runner = new QueryRunner();

            //3. 调用query()方法
            String sql = "SELECT id,NAME,email,birth FROM customers WHERE id < ?";
            //创建一个ResultSetHandler实现类的对象
            BeanListHandler<Customer> handler = new BeanListHandler<>(Customer.class);
            List<Customer> list = runner.query(connection, sql, handler, 13);

            list.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //4. 关闭资源
            JDBCUtils.closeResouce(connection);
        }

    }


    /*
    MapHandler :  对应查询表中的一条记录，这条记录的每一个字段及其值就作为map中的key-value
     */
    @Test
    public void test3() {
        Connection connection = null;

        try {
            //1. 获取数据库的连接
            connection = JDBCUtils.getConnection();
            //2. 创建QueryRunner的实例
            QueryRunner runner = new QueryRunner();

            //3. 调用query()方法
            String sql = "SELECT id,NAME,email,birth FROM customers WHERE id = ?";
            //创建一个ResultSetHandler实现类的对象
            ResultSetHandler<Map<String,Object>> handler = new MapHandler();
            Map<String, Object> map = runner.query(connection, sql, handler, 13);

            System.out.println(map);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //4. 关闭资源
            JDBCUtils.closeResouce(connection);
        }
    }


    /*
    MapListHandler :  对应查询表中的多条记录，每条记录的每一个字段及其值就作为map中的key-value，
                      多个map构成一个List
     */
    @Test
    public void test4() {
        Connection connection = null;

        try {
            //1. 获取数据库的连接
            connection = JDBCUtils.getConnection();
            //2. 创建QueryRunner的实例
            QueryRunner runner = new QueryRunner();

            //3. 调用query()方法
            String sql = "SELECT id,NAME,email,birth FROM customers WHERE id < ?";
            //创建一个ResultSetHandler实现类的对象
            ResultSetHandler<List<Map<String,Object>>> handler = new MapListHandler();
            List<Map<String, Object>> list = runner.query(connection, sql, handler, 13);

            list.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //4. 关闭资源
            JDBCUtils.closeResouce(connection);
        }
    }

    //String sql = "select count(*) from customers";
    /*
    * ScalarHandler:用于查询表中的特殊值
    *
    * 如下：查询表中一共有多少条记录
    * */
    @Test
    public void test5() {

        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();

            QueryRunner runner = new QueryRunner();
            String sql = "select count(*) from customers";
            ScalarHandler handler = new ScalarHandler();
            long count = (long) runner.query(connection, sql, handler);

            System.out.println("查询到" + count + "条记录");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResouce(connection);
        }
    }

    /*
     * ScalarHandler:用于查询表中的特殊值
     *
     * 如下：查询表中最大的birth是多少？
     * */
    @Test
    public void test6() {

        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();

            QueryRunner runner = new QueryRunner();
            String sql = "select max(birth) from customers";
            ScalarHandler handler = new ScalarHandler();
            Date maxBirth = (Date) runner.query(connection, sql, handler);

            System.out.println("最大的生日是：" + maxBirth);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResouce(connection);
        }


    }
}
