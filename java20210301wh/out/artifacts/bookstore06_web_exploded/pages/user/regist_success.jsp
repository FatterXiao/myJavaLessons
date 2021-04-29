<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
	<%--使用静态包含base包含进来--%>
	<%@ include file="/WEB-INF/include/base.jsp"%>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
</style>
</head>
<body>
		<div id="header">
				<a href="index.jsp">
					<img class="logo_img" alt="" src="static/img/logo.gif" />
				</a>
				<span class="wel_word"></span>
				<div>
					<a href="pages/user/login.jsp">登录</a>
					<a href="pages/user/regist.jsp">注册</a>
					<a href="pages/cart/cart.jsp">购物车</a>
					<a href="pages/manager/manager.jsp">后台管理</a>
				</div>
		</div>
		
		<div id="main">
		
			<h1>注册成功! <a href="index.jsp">转到主页</a></h1>
	
		</div>
		
		<div id="bottom">
			<span>
				尚硅谷书城.Copyright &copy;2015
			</span>
		</div>
</body>
</html>