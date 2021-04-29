package com.atguigu.java3.dao;

import com.atguigu.java2.javabean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * @author shkstart
 * @create 16:15
 */
public class CustomerDAOImpl extends BaseDAO implements CustomerDAO {

    @Override
    public int addCustomer(Connection connection, Customer customer) throws SQLException {
        String sql = "insert into customers(name,email,birth)values(?,?,?)";
        return update(connection,sql,customer.getName(),customer.getEmail(),customer.getBirth());
    }

    @Override
    public int deleteById(Connection connection, int id) throws SQLException {
        String sql = "delete from customers where id = ?";
        return update(connection,sql,id);
    }

    @Override
    public int updateCustomer(Connection connection, Customer customer) throws SQLException {
        String sql = "update customers set name = ?,email = ?,birth = ? where id = ?";
        return update(connection,sql,customer.getName(),customer.getEmail(),customer.getBirth(),customer.getId());
    }

    @Override
    public Customer getById(Connection connection, int id) throws SQLException {
        String sql = "select id,name,email,birth from customers where id = ?";
        return getInstance(connection,sql,Customer.class,id);
    }

    @Override
    public List<Customer> getAll(Connection connection) throws SQLException {
        String sql = "select id,name,email,birth from customers";
        return getList(connection,sql,Customer.class);
    }

    @Override
    public long getCount(Connection connection) throws SQLException {
        String sql = "select count(*) from customers";
        return getValue(connection,sql);
    }

    @Override
    public Date getMaxBirth(Connection connection) throws SQLException {
        String sql = "select max(birth) from customers";
        return getValue(connection,sql);
    }
}
