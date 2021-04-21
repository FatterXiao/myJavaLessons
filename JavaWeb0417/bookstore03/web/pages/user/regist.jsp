<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>尚硅谷会员注册页面</title>
    <%@ include file="/WEB-INF/include/base.jsp" %>
    <link type="text/css" rel="stylesheet" href="static/css/style.css"/>
    <link rel="stylesheet" href="static/css/register.css"/>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }
    </style>
    <script src="static/script/jquery-1.7.2.js"></script>
    <script>
        $(function () {
            // 1. 绑定注册的单击按钮
            $("#sub_btn").click(function () {
                // 2. get username  and  check it
                var username = $("#username").val();
                // - 2.1 username can't  be empty.
                if (username == "") {
                    $("#usernameMsg").text("用户名不能为空");
                    return false;
                }
                // - 2.2 match to the username's regular expression.
                var usernameReg = /^[a-zA-Z0-9_-]{3,16}$/;
                if (!usernameReg.test(username)) {
                    $("#usernameMsg").text("用户名应为6~16位数组和字母组成");
                    return false;
                }
                // 3. get password
                var password = $("#password").val();
                // - 3.1 password can't be  empty.
                if(password == ""){
                  return false;
                }
                // 4. 获取确认密码
                // 5. get email message
                // 6. get identified code

            });
        });
    </script>
</head>
<body>
<div id="login_header">
    <a href="index.jsp">
        <img class="logo_img" alt="" src="static/img/logo.gif"/>
    </a>
</div>

<div class="login_banner">
    <div class="register_form">
        <h1>注册尚硅谷会员</h1>
        <form action="RegistServlet" method="post">
            <div class="form-item">
                <div>
                    <label>用户名称:</label>
                    <input type="text" placeholder="请输入用户名" name="username" id="username"/>
                </div>
                <span  class="errMess" id="usernameMsg"><%=request.getAttribute("registErrorMsg")==null?"":request.getAttribute("registErrorMsg")%></span>
            </div>
            <div class="form-item">
                <div>
                    <label>用户密码:</label>
                    <input type="password" placeholder="请输入密码" name="password" id="password"/>
                </div>
                <span class="errMess" id="passwordMsg">密码的长度至少为8位</span>
            </div>
            <div class="form-item">
                <div>
                    <label>确认密码:</label>
                    <input type="password" placeholder="请输入确认密码" name="confirmpassword"/>
                </div>
                <span class="errMess" id="confirmpwd">密码两次输入不一致</span>
            </div>
            <div class="form-item">
                <div>
                    <label>用户邮箱:</label>
                    <input type="text" placeholder="请输入邮箱" name="email"/>
                </div>
                <span class="errMess" id="email">请输入正确的邮箱格式</span>
            </div>
            <div class="form-item">
                <div>
                    <label>验证码:</label>
                    <div class="verify">
                        <input type="text" placeholder="" name="code"/>
                        <img src="static/img/code.bmp" alt=""/>
                    </div>
                </div>
                <span class="errMess">请输入正确的验证码</span>
            </div>
            <button class="btn">注册</button>
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
