<%--
  Created by IntelliJ IDEA.
  User: 韩总
  Date: 2021/4/21
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>要转发过来的页面</title>
</head>
<body>
    <h1>我是通过转发过来的</h1>
    <h1>用户名是：<%=request.getParameter("username")%></h1>
    <h1>密码是：<%=request.getParameter("password")%></h1>
</body>
</html>
