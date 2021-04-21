<%--
  Created by IntelliJ IDEA.
  User: 韩总
  Date: 2021/4/21
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="/error.jsp" %>
<html>
<head>
    <title>JSP指令</title>
</head>
<body>
    <%--
        page指令：用来告诉服务器如何解析当前页面
        该指令中的属性说明：
            contentType：用来设置当前页面使用的字符集，同时会告诉浏览器使用该字符集进行解码
            language：用来设置使用的编程语言，默认值是java，可选值也是java
            import：用来导入包，通常会单独写一个page指令通过该属性导包
           ★errorPage：用来设置当当前页面出现异常时要转发的页面
           ★isErrorPage：用来设置当前页面是否是一个错误页面，默认值是false，当值改为true时，
                      证明当前页面是一个错误页面，此时可用使用exception对象获取异常信息
            isELIgnored：用来设置是否忽略EL表达式，默认值是false，不忽略，一般我们不修改它
            session：用来设置当前页面中是否可用使用Session对象，默认值是true，可用使用Session对象，一般我们不修改它
    --%>
    <%
        //int i = 10/0;
    %>

    <h1>锄禾日当午</h1>
    <%--include指令：用来将其他页面中的内容包含到当前页面中
        file属性：用来设置被包含页面的路径
        通过include指令实现的包含只翻译、编译当前页面，不翻译、编译被包含的页面，这种包含我们称为静态包含
    --%>
    <%@ include file="/WEB-INF/include/include.jsp"%>
</body>
</html>
