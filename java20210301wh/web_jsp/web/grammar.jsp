<%--
  Created by IntelliJ IDEA.
  User: 韩总
  Date: 2021/4/21
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP语法</title>
</head>
<body>
    <%--JSP脚本片段--%>
    <%
        for(int i = 0 ; i < 10 ; i++){
           //out.write("今天天气在下雨，适合睡睡睡！");
    %>

    <h1>今天天气在下雨，适合睡睡睡！</h1>

    <%
         }
    %>

    <%--JSP表达式--%>
    <h1><%="我是通过JSP表达式式输出的"%></h1>

    <!-- 我是HTML注释，在浏览器解析HTML页面时会忽略我 -->
    <%--JSP注释，在JSP引擎翻译jsp页面时会忽略我--%>
</body>
</html>
