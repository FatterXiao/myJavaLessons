package com.atguigu.bookstore.servlet;

import com.atguigu.bookstore.beans.Book;
import com.atguigu.bookstore.beans.Cart;
import com.atguigu.bookstore.service.BookService;
import com.atguigu.bookstore.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CartServlet",urlPatterns = "/CartServlet")
public class CartServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    //添加图书到购物车
    protected void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取图书的id
        String bookId = request.getParameter("bookId");
        //调用BookService中根据图书id查询图书的方法
        Book bookById = bookService.getBookById(Integer.parseInt(bookId));
        //获取Session对象
        HttpSession session = request.getSession();
        //从session域中获取购物车
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart == null){
            //证明session域中还没有购物车，创建一个购物车放到session域中
            cart = new Cart();
            session.setAttribute("cart",cart);
        }
        //将图书添加到购物车中
        cart.addBook2Cart(bookById);
        //重定向到首页
//        response.sendRedirect(request.getContextPath()+"/index.jsp");
        //获取请求头中的Referer属性值
        String referer = request.getHeader("Referer");
        //重定向到referer
        response.sendRedirect(referer);
    }

    //清空购物车
    protected void emptyCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取Session对象
        HttpSession session = request.getSession();
        //获取session域中的购物车
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart != null){
            //清空购物车
            cart.clearCart();
        }
        //重定向到购物车页面
        response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
    }

    //删除购物项
    protected void deleteCartItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取要删除的购物项中图书的id
        String bookId = request.getParameter("bookId");
        //获取Session对象
        HttpSession session = request.getSession();
        //获取session域中的购物车
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart != null){
            //删除购物项
            cart.deleteCartItem(bookId);
        }
        //重定向到购物车页面
        response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
    }

    //更新购物项
    protected void updateCartItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取要更新的购物项中图书的id和数量
        String bookId = request.getParameter("bookId");
        String bookCount = request.getParameter("bookCount");
        //获取Session对象
        HttpSession session = request.getSession();
        //获取session域中的购物车
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart != null){
            //更新购物项
            cart.updateCartItem(bookId,bookCount);
        }
        //重定向到购物车页面
        response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
    }

}
