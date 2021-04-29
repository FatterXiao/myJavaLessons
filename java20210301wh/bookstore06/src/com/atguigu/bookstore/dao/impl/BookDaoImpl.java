package com.atguigu.bookstore.dao.impl;

import com.atguigu.bookstore.beans.Book;
import com.atguigu.bookstore.beans.Page;
import com.atguigu.bookstore.dao.BaseDao;
import com.atguigu.bookstore.dao.BookDao;

import java.util.List;

public class BookDaoImpl extends BaseDao<Book> implements BookDao {
    @Override
    public List<Book> getBooks() {
        //写sql语句
        String sql = "select id,title,author,price,sales,stock,img_path imgPath from books";
        //调用BaseDao中获取一个List的方法
        List<Book> beanList = getBeanList(sql);
        return beanList;
    }

    @Override
    public void saveBook(Book book) {
        //写sql语句
        String sql = "insert into books(title,author,price,sales,stock,img_path) values(?,?,?,?,?,?)";
        //调用BaseDao中通用的增删改的方法
        update(sql,book.getTitle(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
    }

    @Override
    public void deleteBookById(Integer id) {
        //写sql语句
        String sql = "delete from books where id = ?";
        //调用BaseDao中通用的增删改的方法
        update(sql,id);
    }

    @Override
    public Book getBookById(Integer id) {
        //写sql语句
        String sql = "select id,title,author,price,sales,stock,img_path imgPath from books where id = ?";
        //调用BaseDao中获取一个对象的方法
        Book bean = getBean(sql, id);
        return bean;
    }

    @Override
    public void updateBook(Book book) {
        //写sql语句
        String sql = "update books set title = ? , author = ? , price = ? , sales = ? , stock = ? where id = ?";
        //调用BaseDao中通用的增删改的方法
        update(sql,book.getTitle(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getId());
    }

    @Override
    public Page<Book> getPageBooks(Page<Book> page) {
        //写sql语句查询总记录数
        String sql = "select count(*) from books";
        //调用BaseDao中获取一个单一值的方法
        long singleValue = (long)getSingleValue(sql);
        //将总记录数设置到page对象中
        page.setTotalRecord((int)singleValue);
        //写sql语句，查询当前页中的所有图书
        String sql1 = "select id,title,author,price,sales,stock,img_path imgPath from books limit ?,?";
        //调用BaseDao中获取一个List的方法
        List<Book> beanList = getBeanList(sql1, (page.getPageNo() - 1) * Page.getPageSize(), Page.getPageSize());
        //将查询的list设置到page对象中
        page.setList(beanList);
        return page;
    }

    @Override
    public Page<Book> getPageBooksByPrice(Page<Book> page, double minPrice, double maxPrice) {
        //写sql语句查询总记录数
        String sql = "select count(*) from books where price between ? and ?";
        //调用BaseDao中获取一个单一值的方法
        long singleValue = (long)getSingleValue(sql,minPrice,maxPrice);
        //将总记录数设置到page对象中
        page.setTotalRecord((int)singleValue);
        //写sql语句，查询当前页中的所有图书
        String sql1 = "select id,title,author,price,sales,stock,img_path imgPath from books where price between ? and ? limit ?,?";
        //调用BaseDao中获取一个List的方法
        List<Book> beanList = getBeanList(sql1, minPrice,maxPrice,(page.getPageNo() - 1) * Page.getPageSize(), Page.getPageSize());
        //将查询的list设置到page对象中
        page.setList(beanList);
        return page;
    }
}
