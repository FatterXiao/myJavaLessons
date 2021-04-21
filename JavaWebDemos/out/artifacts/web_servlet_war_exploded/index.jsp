<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 4/19/2021
  Time: 9:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <a href="myServlet">myServlet</a> <br>
    <h3>表单</h3>
  <form action="AutoServlet" method="post">
    username：<input type="text" name="username"><br>
    password：<input type="password" name="password"><br>
    <input type="submit" value="提交表单">
  </form>
  </body>
</html>
