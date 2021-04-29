package com.atguigu.jstl.servlet;

import com.atguigu.jstl.beans.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.Helianthus
 * @create 2021-04-23 2:40 PM
 */
@WebServlet(name = "JSTLServlet",urlPatterns = "/JSTLServlet")
public class JSTLServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //正常情况下：EmployeeServlet调用EmployeeService，EmployeeService调用EmployeeDao查询数据库得到所有员工
        //此时我们new一个List
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(1,"小安妮","xiaoanni@xxx.com",null));
        //将所有的员工放到request域中
        request.setAttribute("emps",employees);
        //转发到显示所有员工的页面
        request.getRequestDispatcher("/if.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
