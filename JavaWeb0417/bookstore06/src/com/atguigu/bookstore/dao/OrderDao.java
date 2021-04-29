package com.atguigu.bookstore.dao;

import com.atguigu.bookstore.beans.Order;
import com.atguigu.bookstore.beans.User;

import java.util.List;

/**
 *
 * @author Mr.Helianthus
 * @create 2021-04-28 3:06 PM
 */
public interface OrderDao {
    /**
     * 添加订单
     * @param order
     */
    void addOrder(Order order);

    /**
     * 根据用户id查询该用户的订单
     * @param user 用户
     * @return
     */
    List<Order> getOrdersByuserId(String userId);
}
