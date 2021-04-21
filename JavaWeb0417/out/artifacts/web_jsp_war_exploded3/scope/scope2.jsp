<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 4/21/2021
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>



<h1>Page_scope2.jsp : get fields</h1>
<%=pageContext.getAttribute("pageKey")%><br>
<%=request.getAttribute("rquestKey")%><br>
<%=session.getAttribute("sessionKey")%><br>
<%=application.getAttribute("appKey")%><br>
</body>
</html>
