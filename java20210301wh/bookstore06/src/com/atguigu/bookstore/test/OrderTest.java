package com.atguigu.bookstore.test;

import com.atguigu.bookstore.beans.Order;
import com.atguigu.bookstore.beans.OrderItem;
import com.atguigu.bookstore.dao.OrderDao;
import com.atguigu.bookstore.dao.OrderItemDao;
import com.atguigu.bookstore.dao.impl.OrderDaoImpl;
import com.atguigu.bookstore.dao.impl.OrderItemDaoImpl;
import org.junit.Test;

import java.util.Date;

public class OrderTest {

    /*
       测试插入订单和订单项
    */
    @Test
    public void testOrder(){
        //创建订单对象
        Order order = new Order("13838381438", new Date(), 2, 100.00, 0, 1);
        //创建订单项
        OrderItem orderItem = new OrderItem(null, 1, 60.00, "教子", "韩总", 60.00, "static/img/default.jpg", "13838381438");
        OrderItem orderItem1 = new OrderItem(null, 1, 40.00, "教女", "安小妮", 40.00, "static/img/default.jpg", "13838381438");
        //创建OrderDao对象
        OrderDao orderDao = new OrderDaoImpl();
        //创建OrderItemDao对象
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        //插入订单
        orderDao.addOrder(order);
        //插入订单项
        orderItemDao.addOrderItem(orderItem);
        orderItemDao.addOrderItem(orderItem1);
    }
}
