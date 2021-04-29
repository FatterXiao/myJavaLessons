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
 * @create 2021-04-23 7:22 PM
 */
@WebServlet(name = "BookManageServlet", urlPatterns = "/bookManageServlet")
public class BookManageServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();

    protected void getBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取所有图书
        List<Book> books = bookService.getBooks();
        // 2. 把得到的图书信息转发到request域中
        request.setAttribute("books",books);
        // 3. 转发到图书管理界面中
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }


    protected void deleteBookById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("bookId");

        bookService.deletBookById(Integer.parseInt(id));

        getBooks(request,response);
    }

    /*
        - 根据 id获取 图书的信息；
        - 把图书的信息存到reques域中；
        - 转发到修改的界面中[book_input.jsp]
     */
    protected void toUpdateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("bookId");
        //
        Book book = bookService.getBookById(Integer.parseInt(id));

        request.setAttribute("book",book);
        request.getRequestDispatcher("pages/manager/book_input.jsp").forward(request,response);
    }



    // 添加或修改图书
    protected void addOrUpdateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("bookId");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String price = request.getParameter("price");
        String sales = request.getParameter("sales");
        String stock = request.getParameter("stock");

        Book book = null;
        // 添加图书
        if ("".equals(id)) {
            book = new Book(null, title, author, Double.parseDouble(price), Integer.parseInt(sales), Integer.parseInt(stock));
            bookService.addBook(book);
            getBooks(request, response);
            return;
        }

        // 修改图书
        book = new Book(Integer.parseInt(id), title, author, Double.parseDouble(price), Integer.parseInt(sales), Integer.parseInt(stock));
        bookService.updateBook(book);
        getBooks(request,response);

    }

    /*
        - 实现分页
     */
    protected void getPageBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNo = request.getParameter("pageNo");
        Page<Book> pageBooks = bookService.getPageBooks(pageNo);
        request.setAttribute("pageBooks",pageBooks);
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }
}
