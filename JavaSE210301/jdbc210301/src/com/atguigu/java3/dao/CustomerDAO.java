package com.atguigu.java3.dao;

import com.atguigu.java2.javabean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * 针对于Customer的相关操作
 *
 * @author shkstart
 * @create 16:15
 */
public interface CustomerDAO {
    /**
     * 添加Customer的实例到数据表中
     *
     * @param connection
     * @param customer
     * @return
     */
    int addCustomer(Connection connection, Customer customer) throws SQLException;

    /**
     * 通过指定的id，删除表中的记录
     * @param connection
     * @param id
     * @return
     */
    int deleteById(Connection connection,int id) throws SQLException;

    /**
     * 修改表中的一条记录
     *
     * Customer cust = new Customer(10,"邓丽君","deng@126.com",new Date(23423324324L));
     * @param connection
     * @param customer
     * @return
     */
    int updateCustomer(Connection connection,Customer customer) throws SQLException;

    /**
     * 根据指定的id,查询表中的一条记录
     * @param connection
     * @param id
     * @return
     */
    Customer getById(Connection connection,int id) throws SQLException;

    /**
     * 查询表中的所有的记录
     * @param connection
     * @return
     */
    List<Customer> getAll(Connection connection) throws SQLException;

    /**
     * 获取表中的记录数
     * @param connection
     * @return
     */
    long getCount(Connection connection) throws SQLException;

    /**
     * 获取表中的最大的生日值
     * @param connection
     * @return
     */
    Date getMaxBirth(Connection connection) throws SQLException;
}
