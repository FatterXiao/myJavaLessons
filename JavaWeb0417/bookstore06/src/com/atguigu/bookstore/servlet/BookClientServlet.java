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

/**
 * @author Mr.Helianthus
 * @create 2021-04-24 2:38 PM
 */
@WebServlet(name = "BookClientServlet", urlPatterns = "/bookClientServlet")
public class BookClientServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();


    protected void getBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取所有图书
        List<Book> books = bookService.getBooks();
        // 2. 把得到的图书信息转发到request域中
        request.setAttribute("books", books);
        // 3. 转发到图书管理界面中
//        request.getRequestDispatcher("/pages/client/book_index.jsp").forward(request, response);
        request.getRequestDispatcher("/pages/client/books_index.jsp").forward(request, response);
    }

    /*
        - 首页实现分页
     */
    protected void getIndexPageBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNo = request.getParameter("pageNo");
        Page<Book> pageBooks = bookService.getPageBooks(pageNo);
        request.setAttribute("pageBooks",pageBooks);
        request.getRequestDispatcher("/pages/client/books_index.jsp").forward(request,response);
    }

    /*
        - 首页中根据价格查询
     */
    protected void getIndexPageBooksByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lowPrice = request.getParameter("lowPrice");
        String highPrice = request.getParameter("highPrice");
        String pageNo = request.getParameter("pageNo");
        Page<Book> pageBooksByPrice = bookService.getPageBooksByPrice(pageNo, lowPrice, highPrice);
        // 按照价格查询到的数据列表回传回去
        request.setAttribute("pageBooks",pageBooksByPrice);
        // 把需要查询的价格回传回去
        request.setAttribute("lowPrice",lowPrice);
        request.setAttribute("highPrice",highPrice);

        request.getRequestDispatcher("/pages/client/books_index.jsp").forward(request,response);
    }
}
