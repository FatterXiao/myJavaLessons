package com.atguigu.bookstore.dao.impl;

import com.atguigu.bookstore.beans.OrderItem;
import com.atguigu.bookstore.dao.BaseDao;
import com.atguigu.bookstore.dao.OrderItemDao;

/**
 * @author Mr.Helianthus
 * @create 2021-04-28 3:13 PM
 */
public class OrderItemDaoImpl extends BaseDao<OrderItem> implements OrderItemDao {
    @Override
    public void addOrderItem(OrderItem orderItem) {
        // 写sql语句
        String sql = "INSERT INTO order_items (count,amount,title,author,price,img_path,order_id) values(?,?,?,?,?,?,?)";
        // 调用BaseDao中通用的增删改的方法
        update(sql,orderItem.getCount(),orderItem.getAmount(),orderItem.getTitle(),orderItem.getAuthor(),orderItem.getPrice(),orderItem.getImgPath(),orderItem.getOrderId());
    }
}
