<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>尚硅谷会员注册页面</title>
    <%--使用静态包含base包含进来--%>
    <%@ include file="/WEB-INF/include/base.jsp"%>
    <link type="text/css" rel="stylesheet" href="static/css/style.css" />
    <link rel="stylesheet" href="static/css/register.css" />
    <style type="text/css">
      .login_form {
        height: 420px;
        margin-top: 25px;
      }
    </style>
    <script src="static/script/jquery-1.7.2.js"></script>
    <script>
      $(function () {
        //给注册按钮绑定单击事件
        $("#btn").click(function () {
          //获取用户输入的用户名
          var username = $("#username").val();
          //设置验证用户名的正则表达式
          var usernameReg = /^[a-zA-Z0-9_-]{3,16}$/;
          //验证用户名
          var flag = usernameReg.test(username);
          //如果不符合要求弹出提示框
          if(!flag){
            // alert("请输入3到16位的字母、数字、下划线、减号组合的用户名！");
            //将提示信息设置到span标签中
            $("#userMsg").text("请输入3到16位的字母、数字、下划线、减号组合的用户名！");
            //取消默认行为
            return false;
          }
          //获取用户输入的密码
          var password = $("#password").val();
          //设置验证密码的正则表达式
          var passwordReg = /^[a-zA-Z0-9_-]{6,18}$/;
          //验证密码
          if(!passwordReg.test(password)){
            // alert("请输入6到18位的字母、数字、下划线、减号组合的密码！");
            //将提示信息设置到span标签中
            $("#pwdMsg").text("请输入6到18位的字母、数字、下划线、减号组合的密码！");
            //取消默认行为
            return false;
          }
          //获取用户输入的确认密码
          var repwd = $("#repwd").val();
          //判断两次输入的密码是否一致
          if(repwd != password){
            //清空确认密码
            $("#repwd").val("");
            $("#repWdMsg").text("两次输入的密码不一致！")
            //取消默认行为
            return false;
          }
          //获取用户输入的邮箱
          var email = $("#email").val();
          //设置验证邮箱的正则表达式
          var emailReg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
          //验证邮箱
          if(!emailReg.test(email)){
            // alert("邮箱格式不正确！");
            $("#emailMsg").text("邮箱格式不正确！");
            return false;
          }
          //获取用户输入的验证码
          var code = $("#code").val();
          if(code == ""){
            // alert("请输入验证码");
            $("#codeMsg").text("请输入验证码！");
            return false;
          }
        });
          //给验证码图片绑定单击事件
          $("#codeImg").click(function () {
              //当img标签的src属性值发生变化时，浏览器会重新向src的地址发送请求重新寻找图片
              //设置img标签的src的属性值
              $(this).attr("src","code.jpg?t="+Math.random());
          });
      });
    </script>
  </head>
  <body>
    <div id="login_header">
      <a href="index.html">
        <img class="logo_img" alt="" src="static/img/logo.gif" />
      </a>
    </div>

    <div class="login_banner">
      <div class="register_form">
        <h1>注册尚硅谷会员</h1>
        <form action="UserServlet?methodName=regist" method="post">
<%--          <input type="hidden" name="way" value="regist">--%>
          <div class="form-item">
            <div>
              <label>用户名称:</label>
              <input value="${param.username}" type="text" placeholder="请输入用户名" id="username" autocomplete="on" name="username"/>
            </div>
            <span class="errMess" id="userMsg">${msg}</span>
          </div>
          <div class="form-item">
            <div>
              <label>用户密码:</label>
              <input type="password" placeholder="请输入密码" id="password" name="password"/>
            </div>
            <span class="errMess" id="pwdMsg"></span>
          </div>
          <div class="form-item">
            <div>
              <label>确认密码:</label>
              <input type="password" placeholder="请输入确认密码" id="repwd"/>
            </div>
            <span class="errMess" id="repWdMsg"></span>
          </div>
          <div class="form-item">
            <div>
              <label>用户邮箱:</label>
              <input value="${param.email}" type="text" placeholder="请输入邮箱" id="email" name="email"/>
            </div>
            <span class="errMess" id="emailMsg"></span>
          </div>
          <div class="form-item">
            <div>
              <label>验证码:</label>
              <div class="verify">
                <input type="text" placeholder="请输入右边的验证码" id="code" name="code"/>
                <img id="codeImg" src="code.jpg" alt="" style="width: 100px;height: 43px"/>
              </div>
            </div>
            <span class="errMess" id="codeMsg"></span>
          </div>
          <button class="btn" id="btn">注册</button>
        </form>
      </div>
    </div>
    <div id="bottom">
      <span>
        尚硅谷书城.Copyright &copy;2015
      </span>
    </div>
  </body>
</html>
