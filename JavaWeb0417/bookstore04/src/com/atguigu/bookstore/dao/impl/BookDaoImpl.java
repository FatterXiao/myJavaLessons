package com.atguigu.bookstore.dao.impl;

import com.atguigu.bookstore.beans.Book;
import com.atguigu.bookstore.beans.Page;
import com.atguigu.bookstore.dao.BaseDao;
import com.atguigu.bookstore.dao.BookDao;

import java.util.List;

/**
 * @author Mr.Helianthus
 * @create 2021-04-23 7:13 PM
 */
public class BookDaoImpl extends BaseDao<Book> implements BookDao {
    @Override
    public List<Book> getBooks() {
        String sql = "SELECT id, title, author, price, sales, stock, img_path imgPath FROM books";
        List<Book> beanList = getBeanList(sql);
        return beanList;
    }

    @Override
    public void addBook(Book book) {
        String sql = "INSERT INTO books(title,author,price,sales,stock,img_path) VALUES(?,?,?,?,?,?)";
        update(sql,book.getTitle(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
    }

    @Override
    public void deleteBookById(int id) {
        String sql = "DELETE FROM books WHERE id=?";
        update(sql,id);
    }

    @Override
    public Book getBookById(int id) {
        String sql = "SELECT id, title, author, price, sales, stock, img_path imgPath FROM books WHERE id=?";
        Book bean = getBean(sql, id);
        return bean;
    }

    @Override
    public void updateBook(Book book) {
        String sql = "UPDATE books SET title=?, author=?, price=?, sales=?, stock=? WHERE id=?";
        update(sql,book.getTitle(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getId());
    }

    @Override
    public Page<Book> getPageBooks(Page<Book> pages) {
        String sqlCount = "SELECT COUNT(*) FROM books";
        long records = (long)getSingleValue(sqlCount);
        pages.setTotalRecords(records);

        String sqlDatas = "SELECT id, title, author, price, sales, stock, img_path imgPath FROM books LIMIT ?,? ";
        List<Book> beanList = getBeanList(sqlDatas, (pages.getPageNo() - 1) * Page.PAGE_SIZE, Page.PAGE_SIZE);

        pages.setDataList(beanList);
        return pages;
    }

    @Override
    public Page<Book> getPageBooksByPrice(Page<Book> pages, double lowPrice, double highPrice) {
        // 1. 查询到的记录的总条数
        String sqlCount = "SELECT COUNT(*) FROM books WHERE price BETWEEN ? AND ?";
        long recordCount = (long)getSingleValue(sqlCount, lowPrice, highPrice);
        // - 把 记录总数 封装进pages中
        pages.setTotalRecords(recordCount);

        // 2. 查找所有符合该价格区间的数据
        String sqlDatas = "SELECT id, title, author, price, sales, stock, img_path imgPath FROM books WHERE price BETWEEN ? AND ? LIMIT ?,? ";
        List<Book> beanList = getBeanList(sqlDatas, lowPrice,highPrice,(pages.getPageNo() - 1) * Page.PAGE_SIZE, Page.PAGE_SIZE);
        // - 填装数据
        pages.setDataList(beanList);

        return pages;
    }


}
