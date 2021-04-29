package com.atguigu.bookstore.servlet;

import com.atguigu.bookstore.beans.User;
import com.atguigu.bookstore.service.UserService;
import com.atguigu.bookstore.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Mr.Helianthus
 * @create 2021-04-21 7:02 PM
 */
@WebServlet(name = "UserServlet", urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if("login".equals(action)){
            login(request,response);
            return;
        }
        if("regist".equals(action)){
            regist(request, response);
            return;
        }

        try {
            // 优化代码：
            // 1. 获取方法名字
            // 2. 调用方法
            Method declaredMethod = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            // - 2.2 设置权限
            declaredMethod.setAccessible(true);
            // - 2.3 调用方法
            declaredMethod.invoke(this,request,response);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }


    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取参数: 用户名 和 密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User(null, username, password, null);
        UserService userService = new UserServiceImpl();
        User login = userService.login(user);
        // 2. 验证登录
        // - 2.1登录失败
        if (login == null) {
//            System.out.println("登录失败：" + user.toString());
            // 利用request域传入登录失败的信息
            request.setAttribute("loginError", "登录失败。用户名或密码不正确。");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
            return;
        }
        // - 2.2 登录成功
        response.sendRedirect(request.getContextPath() + "/pages/user/login_success.jsp");
    }

    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 从表单中获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        // 2. 校验传入的参数是否正确，是否可以进行注册
        UserService userService = new UserServiceImpl();
        User user = new User(null, username, password, email);
        boolean isRegist = userService.regist(user);
        // - 2.1 注册失败
        if (isRegist) {
            System.out.println("注册失败");
            // 注册失败时，利用request域给页面发送失败信息
            request.setAttribute("registErrorMsg", "该用户名已经存在不可以注册。");
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            return;
        }
        // - 2.2 注册成功 : 写入数据库存储，并跳转到成功页面
        userService.addUser(user);
        response.sendRedirect(request.getContextPath() + "/pages/user/regist_success.jsp");
    }
}
