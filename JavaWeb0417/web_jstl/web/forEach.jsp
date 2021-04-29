<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 4/23/2021
  Time: 3:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>打印员工信息</h1>
<c:if test="${empty requestScope.emps}">
    <h2>没有员工</h2>
</c:if>

<c:if test="${not empty requestScope.emps}">
    <table>
        <tr>
            <th>ID</th>
            <th>LastName</th>
            <th>Email</th>
            <th>Department</th>
            <th colspan="2">Operate</th>
        </tr>
        <c:forEach items="${requestScope.emps}" var="emp">
            <tr>
                <td></td>
            </tr>

        </c:forEach>
    </table>
</c:if>
</body>
</html>
