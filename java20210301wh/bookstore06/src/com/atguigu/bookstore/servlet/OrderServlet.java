package com.atguigu.bookstore.servlet;

import com.atguigu.bookstore.beans.Cart;
import com.atguigu.bookstore.beans.OrderItem;
import com.atguigu.bookstore.beans.User;
import com.atguigu.bookstore.service.OrderService;
import com.atguigu.bookstore.service.impl.OrderServiceImpl;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//去结账的Servlet
@WebServlet(name = "OrderServlet",urlPatterns = "/OrderServlet")
public class OrderServlet extends BaseServlet {

    private OrderService orderService = new OrderServiceImpl();

    //去结账
    protected void checkout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取Session对象
        HttpSession session = request.getSession();
        //获取session域中的购物车和用户对象
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");
        //调用OrderService中去结账的方法
        String orderId = orderService.checkout(cart, user);
//        request.setAttribute("orderId",oderId);
        //如果使用转发，转发到显示订单号的页面时，如果刷新浏览器会导致再次插入订单
//        request.getRequestDispatcher("/pages/cart/checkout.jsp").forward(request,response);
        session.setAttribute("orderId", orderId);
        //重定向到显示订单号的页面
        response.sendRedirect(request.getContextPath()+"/pages/cart/checkout.jsp");
    }
}
