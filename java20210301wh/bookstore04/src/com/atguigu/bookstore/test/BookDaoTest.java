package com.atguigu.bookstore.test;

import com.atguigu.bookstore.beans.Book;
import com.atguigu.bookstore.beans.Page;
import com.atguigu.bookstore.dao.BookDao;
import com.atguigu.bookstore.dao.impl.BookDaoImpl;
import com.atguigu.bookstore.service.BookService;
import com.atguigu.bookstore.service.impl.BookServiceImpl;
import org.junit.Test;

import java.util.List;

public class BookDaoTest {
    BookDao bookDao = new BookDaoImpl();

    /*
       测试查询所有图书的方法
    */
    @Test
    public void testGetBooks(){
        List<Book> books = bookDao.getBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    /*
       测试添加图书的方法
    */
    @Test
    public void testSaveBook(){
        //创建Book
        Book book = new Book(null,"三国演义","罗贯中",8.88,100,100);
        //保存图书
        bookDao.saveBook(book);
    }

    /*
       测试删除图书的方法
    */
    @Test
    public void testDeleteBookById(){
        bookDao.deleteBookById(73);
    }

    /*
       测试根据图书的id查询图书的方法
    */
    @Test
    public void testGetBookById(){
        Book bookById = bookDao.getBookById(42);
        System.out.println(bookById);
    }

    /*
       测试更新图书的方法
    */
    @Test
    public void testUpdateBook(){
        Book book = new Book(71,"教母","安小妮",998.00,1,0);
        bookDao.updateBook(book);
    }

    /*
       测试带分页的方法
    */
    @Test
    public void testGetPageBooks(){
        //创建page对象
        Page<Book> page = new Page<Book>();
        //设置页码
        page.setPageNo(10);
        //调用BookDao中分页的方法
        Page<Book> pageBooks = bookDao.getPageBooks(page);
        System.out.println("当前页是："+pageBooks.getPageNo());
        System.out.println("总记录数是："+pageBooks.getTotalRecord());
        System.out.println("总页数是："+pageBooks.getTotalPageNo());
        System.out.println("当前页中的图书有：");
        List<Book> list = pageBooks.getList();
        for (Book book : list) {
            System.out.println(book);
        }
    }

    /*
       测试BookService中分页的方法
    */
    @Test
    public void testBookService_GetPageBooks(){
        //创建BookService对象
        BookService bookService = new BookServiceImpl();
        Page<Book> pageBooks = bookService.getPageBooks("2");
        System.out.println("当前页是："+pageBooks.getPageNo());
        System.out.println("总记录数是："+pageBooks.getTotalRecord());
        System.out.println("总页数是："+pageBooks.getTotalPageNo());
        System.out.println("当前页中的图书有：");
        List<Book> list = pageBooks.getList();
        for (Book book : list) {
            System.out.println(book);
        }
    }
}
