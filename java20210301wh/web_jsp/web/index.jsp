<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 韩总
  Date: 2021/4/21
  Time: 9:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Jsp首页</title>
  </head>
  <body>
    <%
      Date date = new Date();
    %>
    <h1>北京时间是：<%=date%></h1>
    <h2>你发送的请求参数的值是：<%=request.getParameter("username")%></h2>
    <!--
        JSP的运行原理：
          当我们访问jsp页面时会经历以下三个步骤：
            1）JSP引擎将jsp页面翻译成java文件
            2）Java虚拟机将java文件编译成class文件
            3）Tomcat(Servlet容器)根据对应的类创建对象处理用户请求
          以访问index.jsp为例：
            第一次访问：
              1）JSP引擎将index.jsp页面翻译成index_jsp.java文件
              2）Java虚拟机将index_jsp.java文件编译成index_jsp.class文件
              3）Tomcat(Servlet容器)根据index_jsp这个类创建对象处理用户请求
            以后再访问（在不改变页面内容的情况下）
              直接用第3）步创建的对象处理用户请求
    -->
  </body>
</html>
