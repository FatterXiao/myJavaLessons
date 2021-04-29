<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>我的订单</title>
    <%@ include file="/WEB-INF/include/base.jsp" %>
    <link rel="stylesheet" href="static/css/minireset.css"/>
    <link rel="stylesheet" href="static/css/common.css"/>
    <link rel="stylesheet" href="static/css/cart.css"/>
    <link rel="stylesheet" href="static/css/bookManger.css"/>
    <link rel="stylesheet" href="static/css/orderManger.css"/>
</head>
<body>
<div class="header">
    <div class="w">
        <div class="header-left">
            <a href="index.jsp">
                <img src="static/img/logo.gif" alt=""/>
            </a>
            <h1>我的订单</h1>
        </div>
        <div class="header-right">
            <h3>欢迎<span>${sessionScope.user.username}</span>光临尚硅谷书城</h3>
            <%--          <div class="order"><a href="pages/order/order.jsp">我的订单</a></div>--%>
            <div class="destory"><a href="userServlet?action=logout">注销</a></div>
            <div class="gohome">
                <a href="index.jsp">返回</a>
            </div>
        </div>
    </div>
</div>
<div class="list">
    <div class="w">
        <table>
            <thead>
            <tr>
                <th>订单号</th>
                <th>订单日期</th>
                <th>订单金额</th>
                <th>订单数量</th>
                <th>订单状态</th>
                <th>订单详情</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${sessionScope.orders}" var="order">
                <tr>
                    <td>${order.id}</td>
                    <td>
                        ${order.orderTime}
                    </td>
                    <td>${order.totalAmount}</td>
                    <td>${order.totalCount}</td>
                    <td><a href="" class="send">
                        <c:if test="${order.state == 0}">
                            等待发货
                        </c:if>
                        <c:if test="${order.state == 1}">
                            确认发货
                        </c:if>
                    </a></td>
                    <td><a href="">查看详情</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="footer">
            <div class="footer-right">
                <div>首页</div>
                <div>上一页</div>
                <ul>
                    <li class="active">1</li>
                    <li>2</li>
                    <li>3</li>
                </ul>
                <div>下一页</div>
                <div>末页</div>
                <span>共10页</span>
                <span>30条记录</span>
                <span>到第</span>
                <input type="text"/>
                <span>页</span>
                <button>确定</button>
            </div>
        </div>
    </div>
</div>
<div class="bottom">
    <div class="w">
        <div class="top">
            <ul>
                <li>
                    <a href="">
                        <img src="static/img/bottom1.png" alt=""/>
                        <span>大咖级讲师亲自授课</span>
                    </a>
                </li>
                <li>
                    <a href="">
                        <img src="static/img/bottom.png" alt=""/>
                        <span>课程为学员成长持续赋能</span>
                    </a>
                </li>
                <li>
                    <a href="">
                        <img src="static/img/bottom2.png" alt=""/>
                        <span>学员真是情况大公开</span>
                    </a>
                </li>
            </ul>
        </div>
        <div class="content">
            <dl>
                <dt>关于尚硅谷</dt>
                <dd>教育理念</dd>
                <!-- <dd>名师团队</dd>
                <dd>学员心声</dd> -->
            </dl>
            <dl>
                <dt>资源下载</dt>
                <dd>视频下载</dd>
                <!-- <dd>资料下载</dd>
                <dd>工具下载</dd> -->
            </dl>
            <dl>
                <dt>加入我们</dt>
                <dd>招聘岗位</dd>
                <!-- <dd>岗位介绍</dd>
                <dd>招贤纳师</dd> -->
            </dl>
            <dl>
                <dt>联系我们</dt>
                <dd>http://www.atguigu.com</dd>
                <dd></dd>
            </dl>
        </div>
    </div>
    <div class="down">
        尚硅谷书城.Copyright ©2015
    </div>
</div>
</body>
</html>
