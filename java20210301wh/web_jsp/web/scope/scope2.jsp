<%--
  Created by IntelliJ IDEA.
  User: 韩总
  Date: 2021/4/21
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>四个域对象</title>
</head>
<body>

    <h1>在scope2.jsp页面中获取四个域中的属性值</h1>
    page域中的属性值是：<%=pageContext.getAttribute("pageKey")%><br>
    request域中的属性值是：<%=request.getAttribute("reqKey")%><br>
    session域中的属性值是：<%=session.getAttribute("sessKey")%><br>
    application域中的属性值是：<%=application.getAttribute("appKey")%><br>

</body>
</html>
