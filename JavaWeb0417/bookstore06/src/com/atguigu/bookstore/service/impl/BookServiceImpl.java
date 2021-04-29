package com.atguigu.bookstore.service.impl;

import com.atguigu.bookstore.beans.Book;
import com.atguigu.bookstore.beans.Page;
import com.atguigu.bookstore.dao.BookDao;
import com.atguigu.bookstore.dao.impl.BookDaoImpl;
import com.atguigu.bookstore.service.BookService;

import java.util.List;

/**
 * @author Mr.Helianthus
 * @create 2021-04-23 7:19 PM
 */
public class BookServiceImpl implements BookService {
    BookDao bookDao = new BookDaoImpl();

    @Override
    public List<Book> getBooks() {
        return bookDao.getBooks();
    }

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deletBookById(int id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public Book getBookById(int id) {
        Book book = bookDao.getBookById(id);
        return book;
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Page<Book> getPageBooks(String pageNo) {
        Page<Book> bookPage = new Page<>();
        // 设置一个默认的页码
        int defaultPageNo = 1;
        // 防止传入非法的参数
        try {
            defaultPageNo = Integer.parseInt(pageNo);
        } catch (NumberFormatException e) {
//            e.printStackTrace();
        }catch (Exception e){
//            e.printStackTrace();
        }
        bookPage.setPageNo(defaultPageNo);

        return bookDao.getPageBooks(bookPage);
    }

    @Override
    public Page<Book> getPageBooksByPrice(String pageNo, String lowPrice, String highPrice) {
        Page<Book> bookPage = new Page<>();
        // 设置一个默认的页码
        int defaultPageNo = 1;
        double min = 0.0;
        double max = Double.MAX_VALUE;

        /*
            - 防止传入非法的参数 :
                - 页码pageNo 默认为 1；
                - 最低价格lowPrice 默认为 0.0；
                - 最高价格highPrice 默认为Double的最大值
         */
        try {
            defaultPageNo = Integer.parseInt(pageNo);
        } catch (NumberFormatException e) {
 //           e.printStackTrace();
        }

        try {
            min = Double.parseDouble(lowPrice);
        } catch (NumberFormatException e) {
//            e.printStackTrace();
        }

        try {
            max = Double.parseDouble(highPrice);
        } catch (NumberFormatException e) {
//            e.printStackTrace();
        }
        // 判别lowPrice 是否大于 highPrice
        if(min > max){
            double temp = min;
            min = max;
            max = temp;
        }
        bookPage.setPageNo(defaultPageNo);

        return bookDao.getPageBooksByPrice(bookPage,min,max);
    }


}
