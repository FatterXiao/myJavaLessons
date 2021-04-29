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
                } else {
                    $("#usernameMsg").text("");
                }
                // - 2.2 match to the username's regular expression.
                var usernameReg = /^[a-zA-Z0-9_-]{3,16}$/;
                if (!usernameReg.test(username)) {
                    $("#usernameMsg").text("用户名应为6~16位数组和字母组成");
                    return false;
                } else {
                    $("#usernameMsg").text("");
                }
                // 3. get password
                var password = $("#password").val();
                // - 3.1 password can't be  empty.
                if (password == "") {
                    $("#passwordMsg").text("密码不能为空");
                    return false;
                }else {
                    $("#passwordMsg").text("");
                }

                var passwordReg = /^[a-zA-Z0-9_-]{6,18}$/;
                if(!passwordReg.test(password)){
                    $("#passwordMsg").text("请输入6到18位的字母、数字、下划线、减号组合的密码！");
                    return false;
                }else {
                    $("#passwordMsg").text("");
                }
                // 4. confirm password correctly
                var confirmPwd = $("#confirmPwd").val();
                if(confirmPwd != password){
                    $("#confirmMsg").text("两次密码不一致")
                    return false;
                }else {
                    $("#confirmMsg").text("")
                }
                // 5. get email message
                var email = $("#email").val();
                if(email == ""){
                    $("#emailMsg").text("邮箱不能为空");
                    return false;
                }else {
                    $("#emailMsg").text("");
                }
                var emailReg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
                if(!emailReg.test(email)){
                    $("#emailMsg").text("邮箱格式不正确");
                    return false;
                }else {
                    $("#emailMsg").text("");
                }
                // 6. get identified code
                var code = $("#code").val();
                if(code == ""){
                    $("katpchaMsg").text("验证码不能为空")
                    return false;
                }
            });

            // 绑定用户名变动事件
            $("#username").change(function () {
                // 把用户名发送到UserServlet
                var username = $("#username").val();
                var url = "${pageContext.request.contextPath}/userServlet?action=checkoutUserName";
                var params = {"username":username};
                $.post(url,params,function (res) {
                    $("#usernameMsg").html(res);
                },"text")
            })
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
        <form action="userServlet?action=regist" method="post">
            <div class="form-item">
                <div>
                    <label>用户名称:</label>
                    <input type="text" placeholder="请输入用户名" name="username" id="username" value="${param.username}"/>
                </div>
                <span class="errMess"
                      id="usernameMsg"><%=request.getAttribute("registErrorMsg") == null ? "" : request.getAttribute("registErrorMsg")%></span>
            </div>
            <div class="form-item">
                <div>
                    <label>用户密码:</label>
                    <input type="password" placeholder="请输入密码" name="password" id="password"/>
                </div>

                <%--                <span class="errMess" id="passwordMsg">密码的长度至少为8位</span>--%>
            </div>
            <div class="form-item">
                <div>
                    <label>确认密码:</label>
                    <input type="password" placeholder="请输入确认密码" name="confirmpassword" id="confirmPwd"/>
                </div>
                                <span class="errMess" id="confirmMsg"></span>
            </div>
            <div class="form-item">
                <div>
                    <label>用户邮箱:</label>
                    <input type="text" placeholder="请输入邮箱" name="email" value="${param.email}"/>
                </div>
                <%--                <span class="errMess" id="email">请输入正确的邮箱格式</span>--%>
            </div>
            <div class="form-item">
                <div>
                    <label>验证码:</label>
                    <div class="verify">
                        <input type="text" placeholder="" name="code" id="code"/>
                        <img id="codeImg" src="kaptchaCode" alt="" style="width: 100px;height: 43px"/>
                    </div>
                </div>
                <%--                <span class="errMess">请输入正确的验证码</span>--%>
            </div>
            <button id="sub_btn" >注册</button>
<%--            <input id="sub_btn" type="submit" value="注册">--%>
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
