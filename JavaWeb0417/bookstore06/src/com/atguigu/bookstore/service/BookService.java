package com.atguigu.bookstore.service;

import com.atguigu.bookstore.beans.Book;
import com.atguigu.bookstore.beans.Page;

import java.util.List;

/**
 * @author Mr.Helianthus
 * @create 2021-04-23 7:17 PM
 */
public interface BookService {

    /**
     * 获取所有图书
     * @return
     */
    List<Book> getBooks();

    /**
     * 添加图书
     * @param book
     */
    void addBook(Book book);


    /**
     * 根据id删除图书
     * @param id
     */
    void deletBookById(int id);

    /**
     * 根据图书id获取图书
     * @param id
     * @return
     */
    Book getBookById(int id);

    /**
     * 更新图书
     * @param book
     */
    void updateBook(Book book);

    /**
     * 分页方法
     * @param pageNo 当前页码
     * @return
     */
    Page<Book>getPageBooks(String pageNo);

    /**
     * 根据价格查询并分页
     * @param pageNo 当前页码
     * @return
     */
    Page<Book>getPageBooksByPrice(String pageNo, String lowPrice, String highPrice);
}
