<%@ page import="com.atguigu.listener.User" %><%--
  Created by IntelliJ IDEA.
  User: 韩总
  Date: 2021/4/28
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
    <%
        User user = new User();
        //将User对象放到session域中
       session.setAttribute("user",user);
    %>
   <h1>Session域中的User对象是：${sessionScope.user}</h1>
  </body>
</html>
