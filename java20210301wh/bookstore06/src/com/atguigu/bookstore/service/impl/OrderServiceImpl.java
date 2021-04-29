package com.atguigu.bookstore.service.impl;

import com.atguigu.bookstore.beans.*;
import com.atguigu.bookstore.dao.BookDao;
import com.atguigu.bookstore.dao.OrderDao;
import com.atguigu.bookstore.dao.OrderItemDao;
import com.atguigu.bookstore.dao.impl.BookDaoImpl;
import com.atguigu.bookstore.dao.impl.OrderDaoImpl;
import com.atguigu.bookstore.dao.impl.OrderItemDaoImpl;
import com.atguigu.bookstore.service.OrderService;

import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    OrderDao orderDao = new OrderDaoImpl();
    OrderItemDao orderItemDao = new OrderItemDaoImpl();
    BookDao bookDao = new BookDaoImpl();

    @Override
    public String checkout(Cart cart , User user) {
        //生成订单号：使用时间戳加用户的id生成
        String orderId = System.currentTimeMillis()+""+user.getId();
        //获取购物车中图书的总数量
        int totalCount = cart.getTotalCount();
        //获取购物车中图书的总金额
        double totalAmount = cart.getTotalAmount();
        //创建订单对象
        Order order = new Order(orderId, new Date(), totalCount, totalAmount, 0, user.getId());
        //插入订单
        orderDao.addOrder(order);
        //获取购物车中所有的购物项
        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem cartItem : cartItems) {
            //获取图书对象
            Book book = cartItem.getBook();
            //获取书名
            String title = book.getTitle();
            //获取作者
            String author = book.getAuthor();
            //获取图书的价格
            Double price = book.getPrice();
            //获取图书的封面
            String imgPath = book.getImgPath();
            //获取购物项中图书的数量
            int count = cartItem.getCount();
            //获取购物项中图书的金额小计
            double amount = cartItem.getAmount();
            //创建订单项
            OrderItem orderItem = new OrderItem(null, count, amount, title, author, price, imgPath, orderId);
            //插入订单项
            orderItemDao.addOrderItem(orderItem);
            //更新图书的库存和销量
            //获取购物项中对应的库存和销量
            Integer sales = book.getSales();
            Integer stock = book.getStock();
            //设置现在的销量为sales+count，库存为stock-count
            book.setSales(sales+count);
            book.setStock(stock-count);
            //更新图书
            bookDao.updateBook(book);
        }
        //清空购物车
        cart.clearCart();

        return orderId;
    }
}
