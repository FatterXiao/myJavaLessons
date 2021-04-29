<%--
  Created by IntelliJ IDEA.
  User: 韩总
  Date: 2021/4/23
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<%--
    1.set标签：用来向域中添加属性，默认添加到page域中
      var属性：用来设置向域对象中添加属性的属性名（key）
      value属性：用来设置向域对象中添加属性的属性值（value）
      scope属性：用来设置添加到那个域中，可选值有page、request、session、application
--%>
<c:set var="hello" value="JSTL" scope="page"></c:set>
<c:set var="hello" value="JSTL" scope="request"></c:set>
<c:set var="hello" value="JSTL" scope="session"></c:set>
<c:set var="hello" value="JSTL" scope="application"></c:set>
获取page域中的属性值：${pageScope.hello}<br>
获取request域中的属性值：${requestScope.hello}<br>
获取session域中的属性值：${sessionScope.hello}<br>
获取application域中的属性值：${applicationScope.hello}<br>
<hr>
<%--
  2.remove标签：用来移除域中的属性值，默认全域（四个域）移除
    var属性：用来指定要移除的域对象中的属性的属性名（key）
    scope属性：用来设置要移除那个域中的属性值，可选值有page、request、session、application
--%>
<c:remove var="hello" scope="application"></c:remove>
<h1>通过remove标签移除之后再次获取</h1>
获取page域中的属性值：${pageScope.hello}<br>
获取request域中的属性值：${requestScope.hello}<br>
获取session域中的属性值：${sessionScope.hello}<br>
获取application域中的属性值：${applicationScope.hello}<br>
<a href="${pageContext.request.contextPath}/JSTLServlet">获取所有员工</a><br>
<hr>
<a href="${pageContext.request.contextPath}/JSTLServlet">test信息</a>
</body>
</html>
