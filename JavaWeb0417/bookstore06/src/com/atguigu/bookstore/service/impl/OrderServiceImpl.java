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

/**
 * 订单的service实现
 *
 * @author Mr.Helianthus
 * @create 2021-04-28 4:03 PM
 */
public class OrderServiceImpl implements OrderService {

    OrderDao orderDao = new OrderDaoImpl();
    OrderItemDao orderItemDao = new OrderItemDaoImpl();
    BookDao bookDao = new BookDaoImpl();

    /**
     * 生成订单<br>
     *
     * @param cart 购物车
     * @param user 用户
     * @return
     */
    @Override
    public String checkout(Cart cart, User user) {
        /*
            - 结算：即生成订单，并把信息存储到数据库中的相关的表中：
                - 获取购物车和用户：
                - 订单的整体信息：生成的一条订单添加到order的表中
                - 购物车--> 所有商品添加到order_items表中
                - 修改books表中各种图书的销量和库存
            - 生成完订单：
                - 清空购物车
         */

        // 1. 把订单存入数据库中orders表中
        // 获取订单的参数
        String orderId = System.currentTimeMillis() + "" + user.getId();// 订单ID：由时间戳和用户的ID拼接而成
        Date date = new Date();// 订单日期
        Integer bookCount = cart.getGoodsCount();// 订单中书籍总数
        double totalPrice = cart.getTotalPrice();// 订单中总金额
        int state = 0;// 订单的状态：0 --> 未发货；1 --> 确认收货；2 --> 已发货
        int userId = user.getId();// 用户id
        // 创建订单
        Order order = new Order(orderId, date, bookCount, totalPrice, state, userId);
        // 订单存储到数据库中
        orderDao.addOrder(order);

        // 2. 把订单中的订单项存入数据库的order_items，并修改books表中各种图书的销量和库存
        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem cartItem : cartItems) {
            // 2.1 把订单中的订单项存入数据库的order_items
            Book book = cartItem.getBook();
            int count = cartItem.getCount();// 图书的数量
            double amount = cartItem.getAmount();// 图书的总金额
            String title = book.getTitle();// 图书的名字
            String author = book.getAuthor();// 图书的作者
            Double price = book.getPrice();// 图书的单价
            String imgPath = book.getImgPath();// 图书的封面的存储路径
            // 生成订单中的订单项
            OrderItem orderItem = new OrderItem(null, count, amount, title, author, price, imgPath, orderId);
            // 把订单项添加到order_items表中
            orderItemDao.addOrderItem(orderItem);

            // 2.1 修改books表中各种图书的销量和库存
            // 修改书籍的销量
            Integer sales = book.getSales() + cartItem.getCount();
            book.setSales(sales);
            // 修改书籍的库存
            Integer stock = book.getStock() - cartItem.getCount();
            book.setStock(stock);
            // 更新数据库中表books中该图书的销量和库存信息
            bookDao.updateBook(book);
        }
        // 3. 清空购物车
        cart.clearCart();

        return orderId;
    }

    /**
     * 获取该用户的所有订单
     * @param user
     * @return
     */
    @Override
    public List<Order> getOrders(User user) {
        List<Order> orders = orderDao.getOrdersByuserId(user.getId() + "");
        return orders;
    }
}
