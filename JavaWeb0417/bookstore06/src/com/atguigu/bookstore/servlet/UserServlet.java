package com.atguigu.bookstore.servlet;

import com.atguigu.bookstore.beans.User;
import com.atguigu.bookstore.service.UserService;
import com.atguigu.bookstore.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Mr.Helianthus
 * @create 2021-04-21 7:02 PM
 */
@WebServlet(name = "UserServlet", urlPatterns = "/userServlet")
public class UserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
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

    /**
     * 用户登录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
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
        // 把用户信息保存到session域中
        HttpSession session = request.getSession();
        session.setAttribute("user",login);
        response.sendRedirect(request.getContextPath() + "/pages/user/login_success.jsp");
    }


    /**
     * 用户注销
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 使session失效
        request.getSession().invalidate();
        // 2. 重定向到首页
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    /**
     * 用户注册
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            - 校验验证码是否正确
                - 获取request 报文中传来的校验码[用户输入的验证码]code1
                - 获取session中的验证码[KaptchaServlet中生成并传入到session中的验证码]code2
                - 校验两个验证码是否相同
         */
        String inputCode = request.getParameter("code");// 用户填写的验证码

        /*
            KaptchaServlet传入session的验证码;
            web.xml中设置了验证码传入session中的k-v键值对中的k为"code"
         */
        String kaptchaCode = (String) request.getSession().getAttribute("code");
        // 如果用户为输入验证码，而前端又未加限制，直接返回
        if(inputCode == null){
            // TODO: 记录错误日志信息
            return;
        }

        // 如果传入的验证码不正确，则回传错误信息“验证码不正确”；并转发到注册页面
        if(!inputCode.equals(kaptchaCode)){
            request.setAttribute("registErrorMsg","输入的验证码不正确");
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
            return;
        }

        // - 验证码校验正确，继续其他信息的验证：
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
            // 注册失败时，利用request域给页面发送失败信息
            request.setAttribute("registErrorMsg", "该用户名已经存在不可以注册。");
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            return;
        }
        // - 2.2 注册成功 : 写入数据库存储，并跳转到成功页面
        userService.addUser(user);
        response.sendRedirect(request.getContextPath() + "/pages/user/regist_success.jsp");
    }

    /**
     * 检测用户名是否可以注册
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void checkoutUserName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名请求参数
        String username = request.getParameter("username");
        //封装User对象
        User user = new User(null, username, null, null);
        //调用UserService中注册的方法
        UserService userService = new UserServiceImpl();
        boolean regist = userService.regist(user);
        response.setContentType("text/html;charset=utf-8");
        if(regist){
            response.getWriter().write("用户名已存在！");
        }else{
            response.getWriter().write("<font color='green'>用户名可用！</font>");
        }
    }
}
