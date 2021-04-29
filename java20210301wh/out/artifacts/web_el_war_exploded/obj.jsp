<%--
  Created by IntelliJ IDEA.
  User: 韩总
  Date: 2021/4/23
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>11个隐含对象</title>
</head>
<body>
    <%

    %>
    通过JSP表达式获取项目的虚拟路径：<%=request.getContextPath()%><br>
    通过EL表达式中的隐含对象获取项目的虚拟路径：${pageContext.request.contextPath}<br>
    通过EL表达式中的隐含对象获取请求参数：${param.username}<br>
    通过EL表达式中的隐含对象获取请求头中的信息：${header['User-Agent']}<br>
    通过EL表达式中的隐含对象获取Cookie对象的value值：${cookie.JSESSIONID.value}<br>
    通过EL表达式中的隐含对象获取当前Web应用的初始化参数：${initParam.encoding}<br>
</body>
</html>
