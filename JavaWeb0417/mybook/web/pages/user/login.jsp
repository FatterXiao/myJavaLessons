<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>尚硅谷会员登录页面</title>
    <%@include file="/WEB-INF/include/base.jsp" %>
    <link type="text/css" rel="stylesheet" href="static/css/style.css"/>
    <script src="static/script/jquery-1.7.2.js"></script>
    <script>
        // 1. 获取用户名和密码
        $(function () {
          // 绑定登录提交表单事件
          $("#sub_btn").click(function () {
            // - 1.1 用户名不能为空
            if($("#username").val() == ""){
              $("#message").text("用户名不能为空")
              return false;
            }
            // - 1.2 密码不能为空

            if($("#password").val() == ""){
              $("#message").text("密码不能为空")
              return false;
            }
          })

        })

    </script>
</head>
<body>
<div id="login_header">
    <a href="index.jsp">
        <img class="logo_img" alt="" src="static/img/logo.gif"/>
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
                    <span class="errorMsg" id="message">
                      <%=request.getAttribute("loginMsg") == null ?"请输入用户名和密码":request.getAttribute("loginMsg")%>
                    </span>
                </div>
                <div class="form">
                    <form action="LoginServlet" method="post">
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
                        <br/>
                        <br/>
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
                        <br/>
                        <br/>
                        <input type="submit" value="登录" id="sub_btn"/>
                    </form>
                    <div class="tit">
                        <a href="regist.jsp">立即注册</a>
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
