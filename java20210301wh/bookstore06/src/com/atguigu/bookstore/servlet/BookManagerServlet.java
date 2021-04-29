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

@WebServlet(name = "BookManagerServlet",urlPatterns = "/BookManagerServlet")
public class BookManagerServlet extends BaseServlet {

    BookService bookService = new BookServiceImpl();

    //分页显示图书
    protected void getPageBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户传入的页码
        String pageNo = request.getParameter("pageNo");
        //调用BookService中分页的方法
        Page<Book> pageBooks = bookService.getPageBooks(pageNo);
        //将pageBooks对象放到request域中
        request.setAttribute("page",pageBooks);
        //转发到显示所有图书的页面
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }

    //获取所有图书
    protected void getBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用BookService中获取所有图书的方法
        List<Book> books = bookService.getBooks();
        //将所有的图书放到request域中
        request.setAttribute("books",books);
        //转发到显示所有图书的页面
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }

    //添加图书
//    protected void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //获取图书信息
//        String title = request.getParameter("title");
//        String author = request.getParameter("author");
//        String price = request.getParameter("price");
//        String sales = request.getParameter("sales");
//        String stock = request.getParameter("stock");
//        //封装Book对象
//        Book book = new Book(null,title,author,Double.parseDouble(price),Integer.parseInt(sales),Integer.parseInt(stock));
//        //调用BookService中添加图书的方法
//        bookService.saveBook(book);
//        //重定向到显示所有图书的页面，结果是：查询不到任何图书，因为request域中没有放图书
////        response.sendRedirect(request.getContextPath()+"/pages/manager/book_manager.jsp");
//        //方式一：重定向到查询所有图书的请求
////        response.sendRedirect(request.getContextPath()+"/BookManagerServlet?methodName=getBooks");
//        //方式二：直接调用getBooks方法查询所有图书
//        getBooks(request,response);
//    }

    //删除图书
    protected void deleteBookById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取要删除的图书的id
        String id = request.getParameter("bookId");
        //调用BookService中删除图书的方法
        bookService.deleteBookById(Integer.parseInt(id));
        //调用getBooks再次查询所有的图书
        getBooks(request,response);
    }

    //获取要更新的图书
    protected void getBookById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取要修改的图书的id
        String bookId = request.getParameter("bookId");
        //调用BookService中根据图书id获取图书的方法
        Book bookById = bookService.getBookById(Integer.parseInt(bookId));
        //将图书放到request域中
        request.setAttribute("book",bookById);
        //转发到更新图书的页面
        request.getRequestDispatcher("/pages/manager/book_input.jsp").forward(request,response);
    }

    //添加或更新图书
    protected void addOrUpdateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户修改之后的图书的信息
        String bookId = request.getParameter("bookId");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String price = request.getParameter("price");
        String sales = request.getParameter("sales");
        String stock = request.getParameter("stock");
        //根据图书的id判断是添加还是更新
        if("".equals(bookId)){
            //证明在添加图书
            //封装Book对象
            Book book = new Book(null,title,author,Double.parseDouble(price),Integer.parseInt(sales),Integer.parseInt(stock));
            //调用BookService中添加图书的方法
            bookService.saveBook(book);
        }else{
            //在更新图书
            //封装Book对象
            Book book = new Book(Integer.parseInt(bookId),title,author,Double.parseDouble(price),Integer.parseInt(sales),Integer.parseInt(stock));
            //调用BookService中更新图书的方法
            bookService.updateBook(book);
        }
        //调用查询所有图书的方法
        getBooks(request,response);
    }
}
