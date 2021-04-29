package com.atguigu.bookstore.servlet;

import com.atguigu.bookstore.beans.Cart;
import com.atguigu.bookstore.beans.Order;
import com.atguigu.bookstore.beans.User;
import com.atguigu.bookstore.service.OrderService;
import com.atguigu.bookstore.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author Mr.Helianthus
 * @create 2021-04-28 11:43 AM
 */
@WebServlet(name = "OrderServlet",urlPatterns = "/orderServlet")
public class OrderServlet extends BaseServlet {
    OrderService orderService = new OrderServiceImpl();

    /**
     * 结算
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void checkOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从session中获取购物车cart 和用户 user
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");

        String orderId = orderService.checkout(cart, user);
        /*
            - 注意不要使用转发，使用转发时，如果刷新页面，会重新提交表单
         */
        // 把订单号放到session中，并重定向到订单号页面中
        session.setAttribute("orderId",orderId);
        response.sendRedirect(request.getContextPath() + "/pages/cart/checkout.jsp");
    }


    /**
     * 根据登录的用户，获取此用户所有的订单
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void getOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取session中的用户user
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        // 设置过滤器filter，过滤后才可以发送请求过来
        // 根据用户id，查询该用户的所有订单
        List<Order> orders = orderService.getOrders(user);
        // 该用户的订单发送到session域中
        session.setAttribute("orders",orders);
        // 转发到“我的订单”
        response.sendRedirect(request.getContextPath() + "/pages/order/order.jsp");

    }

}
