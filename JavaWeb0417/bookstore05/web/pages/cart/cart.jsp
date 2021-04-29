<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>我的购物车</title>
    <%@ include file="/WEB-INF/include/base.jsp" %>
    <link rel="stylesheet" href="static/css/minireset.css"/>
    <link rel="stylesheet" href="static/css/common.css"/>
    <link rel="stylesheet" href="static/css/cart.css"/>
    <script src="static/script/jquery-1.7.2.js"></script>
    <script>
        $(function () {
            // 绑定“清空购物车”的单击事件
            $("#clearCart").click(function () {
                return  confirm("亲，你确定要清空购物车吗？")
            });

            // 绑定“删除”的单击事件
            $(".removeItem").click(function () {
                return confirm("亲，你确定要删除吗？")
            });

            // 绑定“修改商品数量”的事件
            $(".count-num").change(function () {
                //获取购物项中图书的默认数量
                var defaultV = this.defaultValue;
                //获取输入的图书的数量
                var bookCount = $(this).val();
                //获取购物项中图书的id
                var bookId = $(this).attr("id");
                //声明验证输入的数量是否合法的正则表达式
                var countReg = /^\+?[1-9][0-9]*$/;
                if(!countReg.test(bookCount)){
                    alert("请输入正整数！");
                    //将图书的数量设置为默认值
                    this.value = defaultV;
                    return false;
                }
                //获取图书的库存
                //方式一：获取隐藏域中保存的图书的库存
                // var bookStock = $(this).next().val();
                //方式二：获取name属性中的图书的库存
                var bookStock = $(this).attr("name");
                var stock = new Number(bookStock);
                //判断输入的图书的数量是否大于库存
                if(bookCount > stock){
                    alert("图书的库存只有"+bookStock+"本，图书的数量将设置为最大库存！");
                    //将图书的数量设置为最大库存
                    bookCount = stock;
                }
                //发送请求
                location = "cartServlet?action=updateCartItem&bookId="+bookId+"&bookCount="+bookCount;
            });

            // 减少1本图书
            $("#subtractBook").click(function () {
                // 获取购物项中图书的默认数量
                var defaultV = this.defaultValue;
                // 获取输入的图书的数量
                var bookCount = $(this).next(".cart-num").val();
                // 获取库存
                var bookStock = $(this).attr("bookStock");
                var stock = new Number(bookStock);
                // 比较“-1”之后的结果是否小于0


            });


        })
    </script>
</head>
<body>
<div class="header">
    <div class="w">
        <div class="header-left">
            <a href="index.jsp">
                <img src="static/img/logo.gif" alt=""
                /></a>
            <h1>我的购物车</h1>
        </div>
        <div class="header-right">
            <h3>欢迎<span>${sessionScope.user.username}</span>光临尚硅谷书城</h3>
            <div class="order"><a href="pages/order/order.jsp">我的订单</a></div>&nbsp;&nbsp;
            <c:if test="${not empty sessionScope.user}">
                <div class="destory"><a href="userServlet?action=logout">注销</a></div>
                &nbsp;&nbsp;
            </c:if>
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
                <th>图片</th>
                <th>商品名称</th>

                <th>数量</th>
                <th>单价</th>
                <th>金额</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <%--  购物车不为空时--%>
            <c:if test="${sessionScope.cart.goodsCount > 0}">
                <c:forEach items="${sessionScope.cart.cartItems}" var="item">
                    <tr>
                        <td>
                            <img src="${item.book.imgPath}" alt=""/>
                        </td>
                        <td>${item.book.title}</td>
                        <td>
                            <span class="count" id="subtractBook" bookId="${item.book.id} bookStock="${item.book.stock}">-</span>
                            <input class="count-num" type="text" value="${item.count}" id="${item.book.id}"/>
                            <span class="count" id="addBook">+</span>
                        </td>
                        <td>${item.book.price}</td>
                        <td>${item.amount}</td>
                        <td><a name="${item.book.stock}" class="removeItem" href="cartServlet?action=removeCartItem&bookId=${item.book.id}">删除</a></td>
                    </tr>
                </c:forEach>
            </c:if>

            <%--            购物车为空时--%>
            <c:if test="${empty sessionScope.cart.cartItems}">
                <tr >
                    <th colspan="6" align="center">亲,您的购物车空空如也。快去选购吧。</th>
                </tr>
            </c:if>
            </tbody>
        </table>
        <div class="footer">
            <div class="footer-left">
                <a href="cartServlet?action=clearCart" class="clear-cart" id="clearCart">清空购物车</a>
                <a href="index.jsp">继续购物</a>
            </div>
            <div class="footer-right">
                <div>共<span>${sessionScope.cart.goodsCount}</span>件商品</div>
                <div class="total-price">总金额<span>${sessionScope.cart.totalPrice}</span>元</div>
                <a class="pay" href="checkout.jsp">去结账</a>
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
