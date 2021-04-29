package com.atguigu.bookstore.test;

import com.atguigu.bookstore.beans.Book;
import com.atguigu.bookstore.beans.Page;
import com.atguigu.bookstore.dao.BookDao;
import com.atguigu.bookstore.dao.impl.BookDaoImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Mr.Helianthus
 * @create 2021-04-23 7:57 PM
 */
public class BookDaoTest {
    BookDao bookDao = new BookDaoImpl();
    @Test
    public void getBooks() {
        List<Book> books = bookDao.getBooks();
        System.out.println(books);
    }

    @Test
    public void getPageBooks(){
        Page<Book> pageboos = new Page<>();
        pageboos.setPageNo(-14);
        Page<Book> pageBooks = bookDao.getPageBooks(pageboos);
        System.out.println("总记录数：" + pageBooks.getTotalRecords());
        System.out.println("总页数：" + pageBooks.getTotalNos());
        System.out.println("当前页数：" +pageBooks.getPageNo());
        pageBooks.getDataList().forEach(System.out::println);
    }
}