package com.atguigu.bookstore.dao;

import com.atguigu.bookstore.beans.Book;
import com.atguigu.bookstore.beans.Page;

import java.util.List;

public interface BookDao {
    //获取所有图书
    List<Book> getBooks();
    //将图书信息插入到数据库中
    void saveBook(Book book);
    //根据图书的id从数据库中删除该图书
    void deleteBookById(Integer id);
    //根据图书的id查询图书信息
    Book getBookById(Integer id);
    //更新图书
    void updateBook(Book book);

    /**
     *  分页的方法
     * @param page 传入的page对象中只有当前页码pageNo属性值
     * @return 返回的page对象中所有的属性值都有
     */
    Page<Book> getPageBooks(Page<Book> page);

    /**
     *  分页的方法
     * @param page 传入的page对象中只有当前页码pageNo属性值
     * @param minPrice 传入的最低价格
     * @param maxPrice 传入的最高价格
     * @return 返回的page对象中所有的属性值都有
     */
    Page<Book> getPageBooksByPrice(Page<Book> page , double minPrice , double maxPrice);
}
