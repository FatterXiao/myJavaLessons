<%--
  Created by IntelliJ IDEA.
  User: 韩总
  Date: 2021/4/26
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
  <%
    //方式一：在JSP表达式中获取保存用户名和密码的Cookie对象
    String username=null;
    String password=null;
    //获取Cookie对象
    Cookie[] cookies = request.getCookies();
    //遍历
    for(Cookie cookie:cookies){
      //获取Cookie对象的名字
      String name = cookie.getName();
      //判断是否是保存用户名和密码的Cookie对象
      if("username".equals(name)){
        //当前Cookie对象是保存用户名的Cookie对象，获取Cookie对象的value值
        username = cookie.getValue();
      }
      if("password".equals(name)){
        //当前Cookie对象是保存密码的Cookie对象，获取Cookie对象的value值
        password = cookie.getValue();
      }
    }
  %>
  <h1>免登录</h1>
  <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
    用户名：<input type="text" name="username" value="<%=username%>"><br>
    密码：<input type="password" name="password" value="<%=password%>"><br>
    <input type="checkbox" name="checkMe" value="noLogin">7天内免登录<br>
    <input type="submit">
  </form>
  </body>
</html>
