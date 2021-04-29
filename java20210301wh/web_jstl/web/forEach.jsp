<%--
  Created by IntelliJ IDEA.
  User: 韩总
  Date: 2021/4/23
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>循环标签</title>
</head>
<body>
    <%--
        forEach标签：相当于Java中的for循环
            begin属性：设置循环的开始，值必须时大于等于0的数
            end属性：设置循环的结束
            var属性：设置一个变量接收遍历到的值，同时会以变量值为key放到page域中
            step属性：指定步长，默认是1，每次循环下一个值与上一个值默认相差1
    --%>
    <c:forEach begin="1" end="10" var="index" step="1">
        <a href="${pageContext.request.contextPath}/XXX?pageNo=${index}">${index}</a>
    </c:forEach>

    <hr>
    <%--
        items属性：接收一个遍历的集合
        var属性：设置一个变量接收遍历到的值，同时会以变量值为key放到page域中
    --%>
    <c:if test="${empty requestScope.emps}">
        <h1>没人任何员工！</h1>
    </c:if>
    <c:if test="${not empty requestScope.emps}">
        <h1>员工列表</h1>
        <table border="1" cellspacing="0" cellpadding="10">
            <tr>
                <th>ID</th>
                <th>LastName</th>
                <th>Email</th>
                <th>Department</th>
                <th colspan="2">Operate</th>
            </tr>
            <c:forEach items="${requestScope.emps}" var="emp">
                <tr>
                    <td>${emp.id}</td>
                    <td>${emp.lastName}</td>
                    <td>${emp.email}</td>
                    <td>${emp.dept.name}</td>
                    <td><a href="#">Edit</a></td>
                    <td><a href="#">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

</body>
</html>
