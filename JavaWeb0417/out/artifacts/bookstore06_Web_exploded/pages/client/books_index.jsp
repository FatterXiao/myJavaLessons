<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>书城首页</title>

    <%@ include file="/WEB-INF/include/base.jsp" %>
    <link rel="stylesheet" href="static/css/minireset.css"/>
    <link rel="stylesheet" href="static/css/common.css"/>
    <link rel="stylesheet" href="static/css/iconfont.css"/>
    <link rel="stylesheet" href="static/css/index.css"/>
    <link rel="stylesheet" href="static/css/swiper.min.css"/>
    <script src="static/script/jquery-1.7.2.js"></script>
    <script>
        $(function () {
            // 绑定添加到购物车的按钮
            $(".addToCart").click(function () {
                var bookId = $(this).attr("id");
                location = "cartServlet?action=addBookToCart&bookId=" + bookId;
            })
        })
    </script>
</head>
<body>
<div id="app">
    <div class="topbar">
        <div class="w">
            <div class="topbar-left">
                <i>送至:</i>
                <i>北京</i>
                <i class="iconfont icon-ai-arrow-down"></i>
            </div>
            <div class="topbar-right">
                <%-- 如果没有用户登录 显示“登录 注册”--%>
                <c:if test="${empty sessionScope.user}">
                    <a href="pages/user/login.jsp" class="login">登录</a>
                    <a href="pages/user/regist.jsp" class="register">注册</a>
                </c:if>

                <%-- 如果有用户登录 --%>
                <c:if test="${not empty sessionScope.user}">
                    <span>欢迎你<b>${sessionScope.user.username}</b></span>
                    <a href="userServlet?action=logout" class="register">注销</a>
                </c:if>

                <a href="pages/cart/cart.jsp" class="cart iconfont icon-gouwuche">
                    购物车
                    <c:if test="${sessionScope.cart.goodsCount > 0}">
                        <div class="cart-num">${sessionScope.cart.goodsCount}</div>
                    </c:if>
                </a>
                <a href="pages/manager/manager.jsp" class="admin">后台管理</a>
            </div>


        </div>
    </div>
    <div class="header w">
        <a href="#" class="header-logo"></a>
        <div class="header-nav">
            <ul>
                <li><a href="#">java</a></li>
                <li><a href="#">前端</a></li>
                <li><a href="#">小说</a></li>
                <li><a href="#">文学</a></li>
                <li><a href="#">青春文学</a></li>
                <li><a href="#">艺术</a></li>
                <li><a href="#">管理</a></li>
            </ul>
        </div>
        <div class="header-search">
            <input type="text" placeholder="十万个为什么"/>
            <button class="iconfont icon-search"></button>
        </div>
    </div>
    <div class="banner w clearfix">
        <div class="banner-left">
            <ul>
                <li>
                    <a href="">
                        <span>文学 鉴赏</span>
                        <i class="iconfont icon-jiantou"></i
                        ></a>
                </li>
                <li>
                    <a href="">
                        <span>社科 研究</span>
                        <i class="iconfont icon-jiantou"></i
                        ></a>
                </li>
                <li>
                    <a href="">
                        <span>少儿 培训</span>
                        <i class="iconfont icon-jiantou"></i
                        ></a>
                </li>
                <li>
                    <a href="">
                        <span>艺术 赏析</span>
                        <i class="iconfont icon-jiantou"></i
                        ></a>
                </li>
                <li>
                    <a href="">
                        <span>生活 周边</span>
                        <i class="iconfont icon-jiantou"></i
                        ></a>
                </li>
                <li>
                    <a href="">
                        <span>文教 科技</span>
                        <i class="iconfont icon-jiantou"></i
                        ></a>
                </li>
                <li>
                    <a href="">
                        <span>热销 畅读</span>
                        <i class="iconfont icon-jiantou"></i
                        ></a>
                </li>
            </ul>
        </div>
        <div class="banner-right">
            <div class="swiper-container">
                <ul class="swiper-wrapper">
                    <li class="swiper-slide">
                        <img src="static/uploads/banner4.jpg" alt="">
                        <!-- <div class="banner-img"></div> -->
                    </li>
                    <li class="swiper-slide">
                        <img src="static/uploads/banner5.jpg" alt="">
                        <!-- <div class="banner-img"></div> -->
                    </li>
                    <li class="swiper-slide">
                        <img src="static/uploads/banner6.jpg" alt="">
                        <!-- <div class="banner-img"></div> -->
                    </li>
                </ul>
                <div class="swiper-button-prev"></div>

                <div class="swiper-button-next"></div>

                <!-- Add Pagination -->
                <div class="swiper-pagination"></div>
            </div>
        </div>
    </div>
    <div class="books-list ">
        <div class="w">
            <div class="list">
                <div class="list-header">
                    <div class="title">图书列表</div>
                    <div class="price-search">
                        <form action="bookClientServlet?action=getIndexPageBooksByPrice&pageNo=${requestScope.pageBooks.pageNo}"
                              method="post">
                            <span>价格:</span>
                            <input type="text" name="lowPrice" value="${requestScope.lowPrice}">
                            <span>-元</span>
                            <input type="text" name="highPrice" value="${requestScope.highPrice}">
                            <span>元</span>
                            <input type="submit" value="查询">
                        </form>
                    </div>
                </div>
                <div class="list-content">
                    <c:forEach items="${requestScope.pageBooks.dataList}" var="book">
                        <div href="" class="list-item">
                            <img src="${book.imgPath}" alt="">
                            <p>书名:${book.title}</p>
                            <p>作者:${book.author}</p>
                            <p>价格:￥${book.price}</p>
                            <p>销量:${book.sales}</p>
                            <p>库存:${book.stock}</p>
                            <button class="addToCart" id="${book.id}">加入购物车</button>
                        </div>
                    </c:forEach>
                </div>
                <div class="list-footer">
                    <div>
                        <a href="bookClientServlet?action=getIndexPageBooksByPrice&pageNo=1&lowPrice=${requestScope.lowPrice}&highPrice=${requestScope.highPrice}">首页</a>
                    </div>
                    <div>
                        <a href="bookClientServlet?action=getIndexPageBooksByPrice&pageNo=${requestScope.pageBooks.pageNo - 1}&lowPrice=${requestScope.lowPrice}&highPrice=${requestScope.highPrice}">上一页</a>
                    </div>
                    <ul>
                        <c:forEach begin="1" end="${requestScope.pageBooks.totalNos}" var="index">
                            <li class="active"><a
                                    href="bookClientServlet?action=getIndexPageBooksByPrice&pageNo=${index}&lowPrice=${requestScope.lowPrice}&highPrice=${requestScope.highPrice}">第${index}页</a>
                            </li>
                        </c:forEach>
                    </ul>
                    <div>
                        <a href="bookClientServlet?action=getIndexPageBooksByPrice&pageNo=${requestScope.pageBooks.pageNo + 1}&lowPrice=${requestScope.lowPrice}&highPrice=${requestScope.highPrice}">下一页</a>
                    </div>
                    <div>
                        <a href="bookClientServlet?action=getIndexPageBooksByPrice&pageNo=${requestScope.pageBooks.totalNos}&lowPrice=${requestScope.lowPrice}&highPrice=${requestScope.highPrice}">末页</a>
                    </div>
                    <span>共${requestScope.pageBooks.totalNos}页</span>
                    <span>${requestScope.pageBooks.totalRecords}条记录</span>
                    <span>到第</span>
                    <input type="text" id="pageNo" value="${requestScope.pageBooks.pageNo}"/>
                    <span>页</span>
                    <button id="confirmBtn">确定</button>
                    <script>
                        // 绑定
                        $("#confirmBtn").click(function () {
                            var pageNo = $("#pageNo").val();
                            window.location.href = "bookClientServlet?action=getIndexPageBooksByPrice&pageNo=" + pageNo + "&lowPrice=${requestScope.lowPrice}&highPrice=${requestScope.highPrice}";
                        })
                    </script>
                </div>
            </div>
        </div>

    </div>
    <div class="cate w">
        <div class="list">
            <a href="" class="list-item">
                <i class="iconfont icon-java"></i>
                <span>java</span>
            </a>
            <a href="" class="list-item"
            ><i class="iconfont icon-h5"></i>h5</a
            >
            <a href="" class="list-item">
                <i class="iconfont icon-python"></i>python
            </a>
            <a href="" class="list-item"
            ><i class="iconfont icon-tianchongxing-"></i>pm</a
            >
            <a href="" class="list-item"
            ><i class="iconfont icon-php_elephant"></i>php</a
            >
            <a href="" class="list-item"
            ><i class="iconfont icon-go"></i>go</a
            >
        </div>
        <a href="" class="img">
            <img src="static/uploads/cate4.jpg" alt=""/>
        </a>
        <a href="" class="img">
            <img src="static/uploads/cate5.jpg" alt=""/>
        </a>
        <a href="" class="img">
            <img src="static/uploads/cate6.jpg" alt=""/>
        </a>
    </div>
    <div class="books">
        <div class="w">
            <div class="seckill">
                <div class="seckill-header">
                    <div class="title">
                        图书秒杀
                    </div>
                    <!-- <i class="iconfont icon-huanyipi"></i> -->
                </div>
                <div class="seckill-content">

                    <a href="" class="tip">
                        <h5>距离结束还有</h5>
                        <i class="iconfont icon-shandian"></i>
                        <div class="downcount">
                            <span class="time">00</span>
                            <span class="token">:</span>
                            <span class="time">00</span>
                            <span class="token">:</span>
                            <span class="time">00</span>
                        </div>
                    </a>


                    <a href="" class="books-sec">
                        <img src="static/uploads/congwanqingdaominguo.jpg" alt="">
                        <p>从晚晴到民国</p>
                        <div>
                            <span class="cur-price">￥28.9</span>
                            <span class="pre-price">￥36.5</span>
                        </div>
                        <button>立即购买</button>
                    </a>
                    <a href="" class="books-sec">
                        <img src="static/uploads/cyuyanrumenjingdian.jpg" alt="">
                        <p>c语言入门经典</p>
                        <div>
                            <span class="cur-price">￥55.9</span>
                            <span class="pre-price">￥68.5</span>
                        </div>
                        <button>立即购买</button>
                    </a>
                    <a href="" class="books-sec">
                        <img src="static/uploads/fusang.jpg" alt="">
                        <p>扶桑</p>
                        <div>
                            <span class="cur-price">￥30.9</span>
                            <span class="pre-price">￥47.5</span>
                        </div>
                        <button>立即购买</button>
                    </a>
                    <a href="" class="books-sec">
                        <img src="static/uploads/geihaizideshi.jpg" alt="">
                        <p>给孩子的诗</p>
                        <div>
                            <span class="cur-price">￥18.9</span>
                            <span class="pre-price">￥25.5</span>
                        </div>
                        <button>立即购买</button>
                    </a>


                    </ul>
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
                            <img src="static/img/bottom1.png" alt="">
                            <span>大咖级讲师亲自授课</span>
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <img src="static/img/bottom.png" alt="">
                            <span>课程为学员成长持续赋能</span>
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <img src="static/img/bottom2.png" alt="">
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
                    <dd>http://www.atguigu.com
                    <dd>
                </dl>
            </div>
        </div>
        <div class="down">
            尚硅谷书城.Copyright ©2015
        </div>
    </div>


</div>
<script src="static/script/swiper.min.js"></script>
<script>
    var swiper = new Swiper('.swiper-container', {
        autoplay: true,
        pagination: {
            el: '.swiper-pagination',
            dynamicBullets: true
        },
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev'
        }
    })
</script>
</body>
</html>
