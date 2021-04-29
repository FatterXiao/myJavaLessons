package com.atguigu.jdbc.DAO;

import com.atguigu.jdbc.javabean.Customer;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Mr.Helianthus
 * @create 2021-04-11 10:56 PM
 */
public interface CustomerDAO {

    /**
     * 向表中添加用户
     * @param conn
     * @param customer
     * @return
     */
    int addCustomer(Connection conn, Customer customer) throws SQLException;

    int deleteById(Connection conn,int customerId);
}
