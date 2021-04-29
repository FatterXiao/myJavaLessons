<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <%@ include file="/WEB-INF/include/base.jsp"%>
    <link rel="stylesheet" href="static/css/minireset.css" />
    <link rel="stylesheet" href="static/css/common.css" />
    <link rel="stylesheet" href="static/css/cart.css" />
    <script src="static/script/jquery-1.7.2.js"></script>
    <script>
      $(function () {
         //给清空购物车的超链接绑定单击事件
        $("#clearCart").click(function () {
            //弹出确认或取消的提示框
           return confirm("亲！确定要清空购物车吗？三思啊！！！");
        });
        //给删除购物项的超链接绑定单击事件
        $(".delCartItem").click(function () {
          //获取购物项中图书的名称
          var title = $(this).parents("tr").children(":eq(1)").text();
          return confirm("确定要删除《"+title+"》这个购物项吗？");
        });
        //给购物项中输入图书数量的文本框绑定change事件
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
            location = "CartServlet?methodName=updateCartItem&bookId="+bookId+"&bookCount="+bookCount;
        });
      });
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
        <c:if test="${not empty sessionScope.user}">
          <div class="header-right">
            <h3>欢迎<span>${sessionScope.user.username}</span>光临尚硅谷书城</h3>
            <div class="order"><a href="pages/order/order.jsp">我的订单</a></div>
            <div class="destory"><a href="UserServlet?methodName=logout">注销</a></div>
            <div class="gohome">
              <a href="index.jsp">返回</a>
            </div>
          </div>
        </c:if>
        <c:if test="${empty sessionScope.user}">
          <div class="header-right">
            <div class="order"><a href="pages/user/login.jsp">登录</a></div>&nbsp;
            <div class="order"><a href="pages/user/regist.jsp">注册</a></div>&nbsp;
            <div class="order"><a href="pages/cart/cart.jsp">购物车</a></div>&nbsp;
            <div class="gohome">
              <a href="index.jsp">返回</a>
            </div>
          </div>
        </c:if>

      </div>
    </div>
    <div class="list">
      <c:if test="${not empty sessionScope.cart.cartItems}">
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

            <c:forEach items="${sessionScope.cart.cartItems}" var="cartItem">
              <tr>
                <td>
                  <img src="${cartItem.book.imgPath}" alt="" />
                </td>
                <td>${cartItem.book.title}</td>
                <td>
                  <span class="count">-</span>
                  <%--方式二：将图书的库存设置到input的name属性中--%>
                  <input name="${cartItem.book.stock}" id="${cartItem.book.id}" class="count-num" type="text" value="${cartItem.count}" />
                  <%--方式一：添加一个隐藏域保存图书的库存--%>
                  <input type="hidden" value="${cartItem.book.stock}">
                  <span class="count">+</span>
                </td>
                <td>${cartItem.book.price}</td>
                <td>${cartItem.amount}</td>
                <td><a class="delCartItem" href="CartServlet?methodName=deleteCartItem&bookId=${cartItem.book.id}">删除</a></td>
              </tr>
            </c:forEach>

            </tbody>
          </table>
          <div class="footer">
            <div class="footer-left">
              <a href="CartServlet?methodName=emptyCart" class="clear-cart" id="clearCart">清空购物车</a>
              <a href="#">继续购物</a>
            </div>
            <div class="footer-right">
              <div>共<span>${sessionScope.cart.totalCount}</span>件商品</div>
              <div class="total-price">总金额<span>${sessionScope.cart.totalAmount}</span>元</div>
              <a class="pay" href="OrderServlet?methodName=checkout">去结账</a>
            </div>
          </div>
        </div>
      </c:if>
      <c:if test="${empty sessionScope.cart.cartItems}">
        <h1 style="color: green" align="center">您的购物车空空如也！！！</h1>
        <h1 align="center"><a href="index.jsp" style="color: red">马上购物</a></h1>
      </c:if>
    </div>
    <div class="bottom">
      <div class="w">
        <div class="top">
          <ul>
            <li>
              <a href="">
                <img src="static/img/bottom1.png" alt="" />
                <span>大咖级讲师亲自授课</span>
              </a>
            </li>
            <li>
              <a href="">
                <img src="static/img/bottom.png" alt="" />
                <span>课程为学员成长持续赋能</span>
              </a>
            </li>
            <li>
              <a href="">
                <img src="static/img/bottom2.png" alt="" />
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
