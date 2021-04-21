<%--
  Created by IntelliJ IDEA.
  User: 韩总
  Date: 2021/4/21
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>动作标签</title>
</head>
<body>
    <%--1.forward标签：用来进行请求的转发
        page属性：设置要转发的路径
    --%>
    <%--不携带请求参数的转发：此时标签体中不能包含任何内容--%>
<%--    <jsp:forward page="/forward.jsp"></jsp:forward>--%>

    <%--带请求参数的转发--%>
    <jsp:forward page="/forward.jsp">
        <jsp:param name="username" value="admin"/>
        <jsp:param name="password" value="666666"/>
    </jsp:forward>

    <h1>停车坐爱枫林晚</h1>
    <%--2.include标签：用来设置将其他页面中的内容包含到当前页面中
        page属性：用来设置被包含的页面的路径
        通过include动作标签实现的包含，会翻译、编译当前页面，也会翻译、编译被包含的页面，这种包含我们称为动态包含
        什么时候用静态包含，什么时候用动态包含
            如果被包含的页面是静态页面就用静态包含
            如果被包含的页面是动态页面就用动态包含
    --%>
    <jsp:include page="/WEB-INF/include/include2.jsp"></jsp:include>
</body>
</html>
