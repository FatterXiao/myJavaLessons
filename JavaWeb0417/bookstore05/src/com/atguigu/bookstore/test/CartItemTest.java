package com.atguigu.bookstore.test;

import com.atguigu.bookstore.beans.Book;
import com.atguigu.bookstore.beans.Cart;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Mr.Helianthus
 * @create 2021-04-27 9:47 PM
 */
public class CartItemTest {

    @Test
    public void cartTest() {
        Book book1 = new Book(1, "《瓦尔登湖》", "梭罗", 10.0, 100, 100);
        Book book2 = new Book(2, "《活着》", "余华", 20.0, 100, 100);
        Cart cart = new Cart();
        cart.addGoods(book1);
        cart.addGoods(book1);
        cart.addGoods(book2);

        System.out.println(cart);
    }


}