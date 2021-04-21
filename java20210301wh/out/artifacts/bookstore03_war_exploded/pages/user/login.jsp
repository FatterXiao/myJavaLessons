<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>尚硅谷会员登录页面</title>
    <%--使用静态包含base包含进来--%>
    <%@ include file="/WEB-INF/include/base.jsp"%>
    <link type="text/css" rel="stylesheet" href="static/css/style.css"/>
    <script src="static/script/jquery-1.7.2.js"></script>
    <script>
       $(function () {
          //给登录的按钮绑定单击事件
         $("#sub_btn").click(function () {
            //获取用户输入的用户名
           var username = $("#username").val();
           //判断用户名是否为空
           if(username == ""){
             alert("用户名不能为空！");
             return false;
           }
           //获取用户输入的密码
           var pwd = $("#password").val();
           //判断密码是否为空
           if(pwd == ""){
             alert("密码不能为空！");
             return false;
           }
         });
       });
    </script>
  </head>
  <body>
    <div id="login_header">
      <a href="index.jsp">
        <img class="logo_img" alt="" src="static/img/logo.gif" />
      </a>
    </div>

    <div class="login_banner">
      <div id="l_content">
        <span class="login_word">欢迎登录</span>
      </div>

      <div id="content">
        <div class="login_form">
          <div class="login_box">
            <div class="tit">
              <h1>尚硅谷会员</h1>
            </div>
            <div class="msg_cont">
              <b></b>
              <span class="errorMsg"><%=request.getAttribute("msg")==null?"请输入用户名和密码":request.getAttribute("msg")%></span>
            </div>
            <div class="form">
              <form action="UserServlet?method=login" method="post">
<%--                <input type="hidden" name="way" value="login">--%>
                <label>用户名称：</label>
                <input
                  class="itxt"
                  type="text"
                  placeholder="请输入用户名"
                  autocomplete="off"
                  tabindex="1"
                  name="username"
                  id="username"
                />
                <br />
                <br />
                <label>用户密码：</label>
                <input
                  class="itxt"
                  type="password"
                  placeholder="请输入密码"
                  autocomplete="off"
                  tabindex="1"
                  name="password"
                  id="password"
                />
                <br />
                <br />
                <input type="submit" value="登录" id="sub_btn" />
              </form>
              <div class="tit">
                <a href="pages/user/regist.jsp">立即注册</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div id="bottom">
      <span>
        尚硅谷书城.Copyright &copy;2015
      </span>
    </div>
  </body>
</html>
