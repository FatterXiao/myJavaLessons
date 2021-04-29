package com.atguigu.bookstore.test;

import com.atguigu.bookstore.beans.Book;
import com.atguigu.bookstore.beans.Cart;
import org.junit.Test;

public class CartTest {
    /*
       测试购物车中的方法
    */
    @Test
    public void testCart(){
        //创建两个图书对象
        Book book = new Book(1, "活着", "余华", 0.09, 100, 100);
        Book book1 = new Book(2, "死了", "余小华", 0.01, 100, 100);

        //创建购物车
        Cart cart = new Cart();
        //买book
//        cart.addBook2Cart(book);
        cart.addBook2Cart(book);
        cart.addBook2Cart(book1);

        //更新book的数量为5
//        cart.updateCartItem("1","5");
        //删除book
//        cart.deleteCartItem("1");
        //清空购物车
//        cart.clearCart();
        //获取购物车的信息
        System.out.println("购物车中图书的总数量是："+cart.getTotalCount());
        System.out.println("购物车中图书的总金额是："+cart.getTotalAmount());

    }
}
