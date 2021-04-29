<%@ page import="java.util.Date" %>
<%@ page import="com.atguigu.el.beans.Employee" %>
<%@ page import="com.atguigu.el.beans.Department" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 韩总
  Date: 2021/4/23
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
    <%
      Date date = new Date();
      pageContext.setAttribute("time",date+"-");
      request.setAttribute("time",date+"--");
      session.setAttribute("hello-kitty",date+"---");
      application.setAttribute("time",date+"----");
    %>
    通过JSP表达式获取域对象中的属性值：<%=pageContext.getAttribute("time")%><br>
    通过EL表达式获取域对象中的属性值：${time}<br>
    通过EL表达式精确获取request域中的属性值：${requestScope.time}<br>
    通过EL表达式获取session域中的属性值（key比较特殊的情况）：${sessionScope['hello-kitty']}<br>

    <hr>
    <%
      //创建Employee对象
      Employee employee = new Employee(1,"张三","zhangsan@lisi.com",new Department(101,"小卖部"));
      //将employee放到page域中
      pageContext.setAttribute("emp",employee);
    %>
    通过EL表达式获取Employee对象的lastName属性值：${emp.lastName}<br>
    通过EL表达式获取Employee类中getAge方法的返回值：${emp.age}<br>
    通过EL表达式获取Employee类中isMarried方法的返回值：${emp.married}<br>
    通过EL表达式获取Employee对象中的部门对象的name属性值：${emp.dept.name}<br>
  </body>

  <hr>
  <%
    Employee employee1 = new Employee();
    //将员工放到page域中
    pageContext.setAttribute("emp1",employee1);
    //创建一个List
    List<Employee> emps = new ArrayList();
    //向list中添加员工
    emps.add(employee1);
    //将List放到page域中
    pageContext.setAttribute("list",emps);
  %>
  通过EL表达式判断Employee对象的id是否为空：${empty emp1.id}<br>
  通过EL表达式判断List是否为空：${empty list}<br>
  通过EL表达式判断List是否为非空：${not empty list}<br>
  通过EL表达式判断List是否为非空：${!empty list}<br>
</html>
