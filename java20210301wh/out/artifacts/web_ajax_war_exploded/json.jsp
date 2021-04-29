<%--
  Created by IntelliJ IDEA.
  User: 韩总
  Date: 2021/4/29
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSON格式</title>
    <script src="${pageContext.request.contextPath}/script/jquery-1.7.2.js"></script>
    <script>
        //JSON对象
        var jsonObj = {"name":"小妮妮","age":28};
        //获取name属性值
        // alert(jsonObj.name)
        var jsonArry = ["康师傅",35,false,null,jsonObj];
        //获取JSON数组中jsonObj的age属性值
        // alert(jsonArry[4].age);
        //在JavaScript中JSON对象与JSON字符串之间的转换
        var objToStr = JSON.stringify(jsonObj);
        // alert(objToStr);
        //JSON格式的字符串
        var jsonStr = '{"name":"小宋宋","email":"ssx@atguigu.com"}';
       // alert(jsonStr);
        //将JSON字符串转换为JSON对象
        var strToObj = JSON.parse(jsonStr);
      //  alert(strToObj.name);

       var fzJsonObj = {
                        "name":"唐僧",
                        "age":18,
                        "sons":[{"name":"孙悟空","age":520},
                            {"name":"猪八戒","age":1250,"wives":[
                                                                {"name":"嫦娥","age":9999},
                                                                {"name":"高翠兰","age":18},
                                                                {"name":"某某菩萨"}
                                                                ]},
                            {"name":"沙悟净","age":10000},
                            {"name":"白龙马","age":100000}
                        ]};
       //获取猪八戒的第二任夫人的名字
       //alert(fzJsonObj.sons[1].wives[1].name);
        $(function () {
            //给按钮绑定单击事件
            $("#btn").click(function () {
                //设置请求地址
                var url = "${pageContext.request.contextPath}/JSONServlet";
                //发送Ajax请求
                $.post(url,function (res) {
                    //将响应数据设置到span标签中
                    $("#msg").text(res.name);
                },"json");
            });
        });
    </script>
</head>
<body>
    <button id="btn">发送Ajax请求接受JSON格式的响应数据</button><span id="msg" style="color: red"></span>
</body>
</html>
