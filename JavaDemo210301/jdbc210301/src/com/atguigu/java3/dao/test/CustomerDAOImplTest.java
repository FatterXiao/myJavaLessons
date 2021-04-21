package com.atguigu.java3.dao.test;

import com.atguigu.java1.util.JDBCUtils;
import com.atguigu.java2.javabean.Customer;
import com.atguigu.java3.dao.CustomerDAOImpl;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @author shkstart
 * @create 16:47
 */
public class CustomerDAOImplTest {

    @Test
    public void test1(){
        Connection connection = null;
        try {
            CustomerDAOImpl impl = new CustomerDAOImpl();
            connection = JDBCUtils.getConnection();
            Customer cust = new Customer(10,"邓丽君","deng@126.com",new Date(23423324324L));
            int count = impl.addCustomer(connection, cust);
            System.out.println("添加了" + count + "条记录");

            //...
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResouce(connection);
        }

    }

    @Test
    public void test2(){
        Connection connection = null;
        try {
            CustomerDAOImpl impl = new CustomerDAOImpl();
            connection = JDBCUtils.getConnection();
            List<Customer> list = impl.getAll(connection);

            for (Customer customer : list) {
                System.out.println(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResouce(connection);
        }

    }

    @Test
    public void test3(){
        Connection connection = null;
        try {
            CustomerDAOImpl impl = new CustomerDAOImpl();
            connection = JDBCUtils.getConnection();
            long count = impl.getCount(connection);
            System.out.println("一共有" + count + "条记录");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResouce(connection);
        }

    }

}
