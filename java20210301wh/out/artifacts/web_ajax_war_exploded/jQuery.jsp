<%--
  Created by IntelliJ IDEA.
  User: 韩总
  Date: 2021/4/29
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>通过jQuery发送Ajax请求</title>
    <script src="${pageContext.request.contextPath}/script/jquery-1.7.2.js"></script>
    <script>
        $(function () {
            $("#btn01").click(function () {
                //通过$.ajax()发送Ajax请求
                /*
                    $.ajax(url,[settings])
                    参数说明
                        url：必须的。用来设置请求地址
                        settings：可选的。常用的参数有
                            type：用来设置请求方式，get或post，默认是get
                            data：用来设置请求参数
                            success：用来设置一个回调函数，响应成功之后，系统会自动调用该函数，
                                    响应数据会以参数的形式传入到该函数中
                            dataType：用来设置响应数据的类型，Ajax也可以自动推断\
                            error：用来设置出现异常时执行的函数

                 */
                $.ajax({
                    url:"${pageContext.request.contextPath}/JQueryServlet",
                    type:"post",
                    data:"username=admin&password=666666",
                    success:function(res){
                        //将响应数据设置到span标签中
                        $("#res").text(res);
                    },
                    dataType:"text",
                    error:function () {
                        alert("出现异常了！");
                    }
                });
            });
            $("#btn02").click(function () {
                //通过$.get/post()方法发送Ajax请求
                /*
                    $.get/post(url, [data], [callback], [type])
                        url：必须的。用来设置请求地址
                        data：可选的。用来设置请求参数
                        callback：可选的。用来设置一个回调函数，响应成功之后，系统会自动调用该函数，
                                    响应数据会以参数的形式传入到该函数中
                        type：可选的。用来设置响应数据的类型
                 */
                <%--$.get("${pageContext.request.contextPath}/JQueryServlet","username=admin&password=111111",function (res) {--%>
                <%--    alert(res);--%>
                <%--},"text");--%>

                //设置请求地址
                var url = "${pageContext.request.contextPath}/JQueryServlet";
                //设置请求参数
                var params = "username=admin&password=111111";
                //发送Ajax请求
                $.post(url,params,function (res) {
                    //将响应数据设置到span标签中
                    $("#res2").text(res);
                },"text")
            });
        });
    </script>
</head>
<body>
<button id="btn01">通过调用ajax()方法发送Ajax请求响应字符串类型的数据</button><span id="res" style="color: red"></span><br>
<button id="btn02">通过调用post()方法发送Ajax请求响应字符串格式的数据</button><span id="res2" style="color: red"></span>
</body>
</html>
