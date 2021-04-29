<%--
  Created by IntelliJ IDEA.
  User: 韩总
  Date: 2021/4/27
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
    <%--
        验证码的作用：
          1.判断是不是人类
          2.防止表单重复提交
          3.减轻服务器的压力
        实现验证码的步骤：
          1.在服务器端随机生成一个字符串最为验证码，将该字符串放到session域中
          2.将验证码转换成一张图片显示到form表单中
          3.用户将图片中的验证码输入到表单中，随着表单的提交提交到服务器
          4.获取用户输入的验证码，再获取session域中的验证码，将两者进行对比
            一致：验证码正确，处理用户请求
            不一致：验证码错误，重新生成验证码重新验证
    --%>
    <h1>session域中的验证码是：${sessionScope.code}</h1>
  </body>
</html>
