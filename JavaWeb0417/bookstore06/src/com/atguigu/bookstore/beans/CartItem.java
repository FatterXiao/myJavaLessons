package com.atguigu.bookstore.beans;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 购物车中的商品类
 * @author Mr.Helianthus
 * @create 2021-04-27 2:04 PM
 */
public class CartItem implements Serializable {
    private Book book; // 购物项中购买的图书
    private int count; // 购物项中购买的图书的数量
    //private double amount; // 购物项中图书的金额小计，通过计算得到

    public CartItem() {
    }

    public CartItem(Book book, int count) {
        this.book = book;
        this.count = count;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    /**
     * 该类商品的总价格
     * @return
     */
    public double getAmount() {
        // 使用String构造器
        BigDecimal price = new BigDecimal(book.getPrice() + "");
        BigDecimal count = new BigDecimal(this.getCount() + "");
        return price.multiply(count).doubleValue();
    }



    @Override
    public String toString() {
        return "CartItem{" +
                "book=" + book +
                ", count=" + this.getCount() +
                ", amount=" + this.getAmount() +
                '}';
    }
}
