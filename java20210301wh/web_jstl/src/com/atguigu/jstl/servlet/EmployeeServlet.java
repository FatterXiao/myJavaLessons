package com.atguigu.jstl.servlet;

import com.atguigu.jstl.beans.Department;
import com.atguigu.jstl.beans.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmployeeServlet",urlPatterns = "/getEmployees")
public class EmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //正常情况下：EmployeeServlet调用EmployeeService，EmployeeService调用EmployeeDao查询数据库得到所有员工
        //此时我们new一个List
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(1,"小安妮","xiaoanni@xxx.com",new Department(101,"教务部")));
        employees.add(new Employee(2,"小张弛","xiaozc@ccc.com",new Department(102,"行政部")));
        employees.add(new Employee(3,"安妮","anni@aaa.com",new Department(103,"咨询部")));
        employees.add(new Employee(4,"小小安妮","xiaoxiaoanni@gengxiao.com",new Department(104,"财务部")));
        employees.add(new Employee(5,"大安妮","daanni@ddd.com",new Department(105,"人事部")));
        employees.add(new Employee(6,"大小安妮","daxiaoanni@dxby.com",new Department(106,"武装部")));
        //将所有的员工放到request域中
        request.setAttribute("emps",employees);
        //转发到显示所有员工的页面
        request.getRequestDispatcher("/forEach.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
