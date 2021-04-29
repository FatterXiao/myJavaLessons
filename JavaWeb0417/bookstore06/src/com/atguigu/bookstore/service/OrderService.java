package com.atguigu.bookstore.service;

import com.atguigu.bookstore.beans.Cart;
import com.atguigu.bookstore.beans.Order;
import com.atguigu.bookstore.beans.User;

import java.util.List;

/**
 * 订单的service
 *
 * @author Mr.Helianthus
 * @create 2021-04-28 4:01 PM
 */
public interface OrderService {

    /**
     *
     * @param cart 购物车
     * @param user 用户
     * @return 返回订单号
     */
    String checkout(Cart cart, User user);

    /**
     * 获取该用户的所有订单
     * @param user
     * @return
     */
    List<Order> getOrders(User user);
}
