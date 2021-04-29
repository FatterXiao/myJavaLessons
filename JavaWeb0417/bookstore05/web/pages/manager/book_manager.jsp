<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>图书管理</title>
    <%@ include file="/WEB-INF/include/base.jsp" %>
    <link rel="stylesheet" href="static/css/minireset.css"/>
    <link rel="stylesheet" href="static/css/common.css"/>
    <link rel="stylesheet" href="static/css/cart.css"/>
    <link rel="stylesheet" href="static/css/bookManger.css"/>
    <script src="static/script/jquery-1.7.2.js"></script>
    <script>
        $(function () {
            // 确认是否要删除
            $(".del").click(function () {
                var title = $(this).attr("id");
                return confirm("确定要删除《" + title + "》吗？")
            })
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
            <h1>图书管理系统</h1>
        </div>
        <div class="header-right">
            <a href="#" class="order">图书管理</a>
            <a href="pages/manager/order_manager.jsp" class="destory">订单管理</a>
            <a href="index.jsp" class="gohome">返回商城</a>
        </div>
    </div>
</div>
<div class="list">
    <div class="w">
        <div class="add">
            <a href="pages/manager/book_input.jsp">添加图书</a>
        </div>
        <table>
            <thead>
            <tr>
                <th>图片</th>
                <th>商品名称</th>
                <th>价格</th>
                <th>作者</th>
                <th>销量</th>
                <th>库存</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${requestScope.pageBooks.dataList}" var="book">
                <tr>
                    <td>
                        <img src="${book.imgPath}" alt=""/>
                    </td>
                    <td>${book.title}</td>
                    <td>
                            ${book.price}
                    </td>
                    <td>${book.author}</td>
                    <td>${book.sales}</td>
                    <td>${book.stock}</td>
                    <td>
                        <a id="${book.title}" href="bookManageServlet?action=toUpdateBook&bookId=${book.id}">修改</a>
                        <a id="${book.title}" href="bookManageServlet?action=deleteBookById&bookId=${book.id}"
                           class="del">删除</a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
        <div class="footer">
            <div class="footer-right">
                <div><a href="bookManageServlet?action=getPageBooks&pageNo=1">首页</a></div>
                <div>
                    <a href="bookManageServlet?action=getPageBooks&pageNo=${requestScope.pageBooks.pageNo - 1}">上一页</a>
                </div>
                <ul>
                    <c:forEach begin="1" end="${requestScope.pageBooks.totalNos}" var="index">
                        <li class="active"><a
                                href="bookManageServlet?action=getPageBooks&pageNo=${index}">第${index}页</a></li>
                    </c:forEach>
                </ul>
                <div>
                    <a href="bookManageServlet?action=getPageBooks&pageNo=${requestScope.pageBooks.pageNo + 1}">下一页</a>
                </div>
                <div><a href="bookManageServlet?action=getPageBooks&pageNo=${requestScope.pageBooks.totalNos}">末页</a>
                </div>
                <span>共${requestScope.pageBooks.totalNos}页</span>
                <span>${requestScope.pageBooks.totalRecords}条记录</span>
                <form action="bookManageServlet?action=getPageBooks" method="post">
                    <span>到第</span>
                    <input type="text" name="pageNo" value="${requestScope.pageBooks.pageNo}"/>
                    <span>页</span>
                    <input type="submit" value="确定">
                </form>

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
