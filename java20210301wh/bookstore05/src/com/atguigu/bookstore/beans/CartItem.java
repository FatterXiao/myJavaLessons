package com.atguigu.bookstore.beans;

import java.io.Serializable;
import java.math.BigDecimal;

//购物项类
public class CartItem implements Serializable {
    private Book book; //购物项中购买的图书
    private int count; //购物项中购买的图书的数量
    private double amount; //购物项中图书的金额小计，通过计算得到

    public CartItem() {
    }

    public CartItem(Book book, int count, double amount) {
        this.book = book;
        this.count = count;
        this.amount = amount;
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

    //金额小计由图书的数量和图书的单价计算得到
    public double getAmount() {
        //创建BigDecimal对象
        BigDecimal bookPrice = new BigDecimal(book.getPrice() + "");
        BigDecimal bookCount = new BigDecimal(count + "");
        //相乘
        BigDecimal multiply = bookPrice.multiply(bookCount);
        return multiply.doubleValue();
    }

//    public void setAmount(double amount) {
//        this.amount = amount;
//    }

    @Override
    public String toString() {
        return "CartItem{" +
                "book=" + book +
                ", count=" + count +
                ", amount=" + amount +
                '}';
    }
}
