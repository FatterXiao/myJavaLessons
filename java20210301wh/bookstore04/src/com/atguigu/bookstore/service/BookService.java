package com.atguigu.bookstore.service;

import com.atguigu.bookstore.beans.Book;
import com.atguigu.bookstore.beans.Page;

import java.util.List;

public interface BookService {
    //获取所有图书
    List<Book> getBooks();
    //添加图书的方法
    void saveBook(Book book);
    //删除图书
    void deleteBookById(Integer id);
    //获取一本图书
    Book getBookById(Integer id);
    //更新图书
    void updateBook(Book book);
    //分页的方法
    Page<Book> getPageBooks(String pageNo);
    //带价格范围和分页的方法
    Page<Book> getPageBooksByPrice(String pageNo , String minPrice , String maxPrice);
}
