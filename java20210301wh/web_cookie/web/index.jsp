<%--
  Created by IntelliJ IDEA.
  User: 韩总
  Date: 2021/4/26
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
  <a href="${pageContext.request.contextPath}/CreateCookie">创建Cookie对象</a><br>
  <a href="${pageContext.request.contextPath}/GetCookies">获取Cookie对象</a><br>
  <a href="${pageContext.request.contextPath}/ModifyCookies">修改Cookie对象</a><br>
  <a href="${pageContext.request.contextPath}/PersistCookieServlet">持久化Cookie对象</a><br>
  </body>
</html>
