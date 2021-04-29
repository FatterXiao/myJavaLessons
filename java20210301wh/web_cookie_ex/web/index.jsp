<%--
  Created by IntelliJ IDEA.
  User: 韩总
  Date: 2021/4/26
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
  <h1>免登录</h1>
  <%--
    方式二：直接使用EL中的隐含对象获取保存用户名和密码的Cookie对象
  --%>
  <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
    用户名：<input type="text" name="username" value=" ${cookie.username.value}"><br>
    密码：<input type="password" name="password" value="${cookie.password.value}"><br>
    <input type="checkbox" name="checkMe" value="noLogin">7天内免登录<br>
    <input type="submit">
  </form>
  </body>
</html>
