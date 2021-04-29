package com.atguigu.bookstore.servlet;

import com.atguigu.bookstore.beans.Book;
import com.atguigu.bookstore.beans.Page;
import com.atguigu.bookstore.service.BookService;
import com.atguigu.bookstore.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookClientServlet",urlPatterns = "/BookClientServlet")
public class BookClientServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    //获取带价格范围查询及分页的图书信息
    protected void getPageBooksByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户传入的页码
        String pageNo = request.getParameter("pageNo");
        //获取价格范围
        String minPrice = request.getParameter("minPrice");
        String maxPrice = request.getParameter("maxPrice");
        //调用BookService中带价格范围和分页的方法
        Page<Book> pageBooksByPrice = bookService.getPageBooksByPrice(pageNo, minPrice, maxPrice);
        //将pageBooks对象放到request域中
        request.setAttribute("page",pageBooksByPrice);
        //将价格范围放到request域中
        request.setAttribute("minPrice",minPrice);
        request.setAttribute("maxPrice",maxPrice);
        //转发到显示所有图书的页面
        request.getRequestDispatcher("/pages/client/books.jsp").forward(request,response);
    }

    //分页显示图书
    protected void getPageBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户传入的页码
        String pageNo = request.getParameter("pageNo");
        //调用BookService中分页的方法
        Page<Book> pageBooks = bookService.getPageBooks(pageNo);
        //将pageBooks对象放到request域中
        request.setAttribute("page",pageBooks);
        //转发到显示所有图书的页面
        request.getRequestDispatcher("/pages/client/books.jsp").forward(request,response);
    }

    //获取所有图书
    protected void getBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用BookService中获取所有图书的方法
        List<Book> books = bookService.getBooks();
        //将books放到request域中
        request.setAttribute("books",books);
        //转发到显示前端显示所有图书的页面
        request.getRequestDispatcher("/pages/client/books.jsp").forward(request,response);
    }

}
