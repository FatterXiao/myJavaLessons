package com.atguigu.bookstore.service;

import com.atguigu.bookstore.beans.Cart;
import com.atguigu.bookstore.beans.User;

public interface OrderService {

    /**
     * 去结账的方法
     * @param cart 传入的购物车对象
     * @param user 传入的用户对象
     * @return
     */
    String checkout(Cart cart , User user);
}
