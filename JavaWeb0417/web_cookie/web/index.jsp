<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 4/26/2021
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
    <a href="${pageContext.request.contextPath}/createCookieServlet">创建cookie对象</a><br>
    <a href="${pageContext.request.contextPath}/getCookieServlet">获取cookie对象</a><br>

  <h1>登录测试</h1>
  <form action="loginServlet" method="post">
    username: <input type="text" name="username" value=""><br>
    password: <input type="password" name="password" value=""><br>
    <input type="checkbox" >七天免登录<br>
    <input type="submit" name="isChecked" value="登录">
  </form>

  </body>
</html>
