package com.atguigu.jdbc.CustomerImpl;

import com.atguigu.jdbc.DAO.BaseDAO;
import com.atguigu.jdbc.DAO.CustomerDAO;
import com.atguigu.jdbc.javabean.Customer;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Mr.Helianthus
 * @create 2021-04-11 11:25 PM
 */
public class CustomerImpl extends BaseDAO implements CustomerDAO {
    @Override
    public int addCustomer(Connection conn, Customer customer) throws SQLException {
        String sql = "insert into customers (id,name,birthday) values(?,?,?)";
        return update(conn,sql,customer.getId(),customer.getName(),customer.getBirthday());
    }

    @Override
    public int deleteById(Connection conn, int customerId) {
        return 0;
    }
}
