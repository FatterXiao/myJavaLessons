<%--
  Created by IntelliJ IDEA.
  User: 韩总
  Date: 2021/4/23
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>条件判断的标签</title>
</head>
<body>
    <%--
        ★if标签：就相当于Java的if条件判断
            test属性：用来接收一个布尔类型的值，通常通过EL表达式获取，
                    当值是true时才执行标签体中的内容
    --%>
    <c:if test="${empty requestScope.emps}">
        <h1>没人任何员工！</h1>
    </c:if>
    <c:if test="${not empty requestScope.emps}">
        <h1>员工列表</h1>
    </c:if>
    <hr>
    <%
        int age = 68;
        //将年龄放到page域中
        pageContext.setAttribute("age",age);
    %>
    <%--
        choose标签：相当于Java中的if...else if... else
            注意：
                1）when标签和otherwise标签必须在choose标签中使用
                2）只要有一个条件满足，其他条件将不在判断，所以书写时注意条件的顺序
    --%>
    <c:choose>
        <c:when test="${age > 60}">
            您老就不要瞎跑了……
        </c:when>
        <c:when test="${age > 35}">
            大龄剩女
        </c:when>
        <c:when test="${age > 18}">
            妙龄少女
        </c:when>
        <c:when test="${age > 14}">
            花季少女
        </c:when>
        <c:when test="${age > 12}">
            豆蔻年华
        </c:when>
        <c:otherwise>
            小屁孩儿
        </c:otherwise>
    </c:choose>
</body>
</html>
