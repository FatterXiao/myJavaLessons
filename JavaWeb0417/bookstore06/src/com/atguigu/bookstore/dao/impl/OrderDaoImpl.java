package com.atguigu.bookstore.dao.impl;

import com.atguigu.bookstore.beans.Order;
import com.atguigu.bookstore.beans.User;
import com.atguigu.bookstore.dao.BaseDao;
import com.atguigu.bookstore.dao.OrderDao;

import java.util.List;

/**
 * @author Mr.Helianthus
 * @create 2021-04-28 3:08 PM
 */
public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {
    /**
     * 将订单添加到数据库bookstore中的oder表中
     * @param order 生成的订单
     */
    @Override
    public void addOrder(Order order) {
        String sql = "INSERT INTO orders (id,order_time,total_count,total_amount,state,user_id) VALUES (?,?,?,?,?,?)";
        update(sql,order.getId(),order.getOrderTime(),order.getTotalCount(),order.getTotalAmount(),order.getState(),order.getUserId());
    }

    /**
     * 根据用户id查询该用户的订单
     * @param userId 用户
     * @return
     */
    @Override
    public List<Order> getOrdersByuserId(String userId) {
        String sql = "SELECT id, order_time orderTime, total_count totalCount,total_amount totalAmount,state FROM orders WHERE user_id = ?";
        List<Order> beanList = getBeanList(sql, userId);
        return beanList;
    }
}
