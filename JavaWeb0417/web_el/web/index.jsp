<%@ page import="com.atguigu.el.Department" %>
<%@ page import="com.atguigu.el.Employee" %><%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 4/23/2021
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>

<%
    // 创建employee的对象
    Employee employee = new Employee(1,"张三","zhangsan@yeah.net",new Department(1001,"技术部"));
    // 把employee放到page域中
    pageContext.setAttribute("emp",employee);
%>
${emp.lastName}<br>
${emp.age}<br>

</body>
</html>
