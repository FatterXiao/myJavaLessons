package com.atguigu.bookstore.servlet;

import com.atguigu.bookstore.beans.Book;
import com.atguigu.bookstore.beans.Cart;
import com.atguigu.bookstore.service.BookService;
import com.atguigu.bookstore.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mr.Helianthus
 * @create 2021-04-27 3:27 PM
 */
@WebServlet(name = "CartServlet", urlPatterns = "/cartServlet")
public class CartServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    /**
     * 把图书添加到购物车中
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void addBookToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取图书Id
        String bookId = request.getParameter("bookId");
        // 根据图书id查询图书信息
        Book book = bookService.getBookById(Integer.parseInt(bookId));
        // 从session中获取购物车
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            // 把购物车cart设置到session域中
            request.getSession().setAttribute("cart", cart);
        }
        // 把图书添加到购物车中
        cart.addGoods(book);
        // 获取请求头中的Referer属性值,并重定向
        response.sendRedirect(request.getHeader("Referer"));
    }


    /**
     * 清空购物车
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void clearCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从session域中获取购物车
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            cart.clearCart();
        }
        // 重定向到“我的购物车”
        response.sendRedirect(request.getContextPath() + "/pages/cart/cart.jsp");
    }


    /**
     * 移除购物车中的某一类型的图书
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void removeCartItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取图书的Id
        String bookId = request.getParameter("bookId");
        // 获取session域中的购物车cart
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        /*
            - 如果cart不为null，移除购物车
                - 如果页面停留时间超过30min[Tomcat中设置的session默认存活时间为30min]
                - session会被注销掉，cart会为null
         */
        if(cart != null){
            cart.removeGoods(bookId);
        }
        // 重定向回“我的购物车”页面
        response.sendRedirect(request.getContextPath() + "/pages/cart/cart.jsp");

    }

    /**
     * 更新购物车中某类图书的购买的数量
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCartItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取要更新的购物项中图书的id和数量
        String bookId = request.getParameter("bookId");
        String bookCount = request.getParameter("bookCount");
        //获取session域中的购物车
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if(cart != null){
            cart.updateGoodsNums(bookId,bookCount);
        }
        //重定向到购物车页面
        response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
    }

    //
    protected void checkOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("结账");
    }
}
