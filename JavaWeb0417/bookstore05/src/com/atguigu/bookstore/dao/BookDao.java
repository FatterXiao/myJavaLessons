package com.atguigu.bookstore.dao;

import com.atguigu.bookstore.beans.Book;
import com.atguigu.bookstore.beans.Page;

import java.util.List;

/**
 * @author Mr.Helianthus
 * @create 2021-04-23 6:49 PM
 */
public interface BookDao {

    /**
     * 获取books表中所有图书信息
     * @return 图书列表
     */
    List<Book> getBooks();

    /**
     * 添加图书
     */
    void addBook(Book book);

    /**
     * 根据id删除图书
     * @param id 图书id
     */
    void deleteBookById(int id);

    /**
     * 根据图书id获取图书
     * @param id
     * @return
     */
    Book getBookById(int id);

    /**
     * 更新图书信息
     * @param book
     */
    void updateBook(Book book);

    /**
     * 分页的方法
     * @param pages 传入的pages参数中，只有需要查询的当前页码和已经设定好的了每页显示的条数PAGE_SIZE参数；
     * @return 返回的Page类型的变量会携带所有的信息
     */
    Page<Book> getPageBooks(Page<Book> pages);

    /**
     * 根据价格区间查询
     * @param pages
     * @param lowPrice
     * @param highPrice
     * @return
     */
    Page<Book> getPageBooksByPrice(Page<Book> pages,double lowPrice,double highPrice);
}
