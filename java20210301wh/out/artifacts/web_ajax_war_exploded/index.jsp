<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 韩总
  Date: 2021/4/29
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
    <script>
      window.onload = function () {
        //获取XMLHttpRequest的通用函数
        function getXMLHttpRequest(){
          var xhr;
          try{
            //大部分浏览器都支持
            xhr = new XMLHttpRequest();
          }catch(e){
            try{
              //如果不支持，在这里捕获异常并且采用IE6支持的方式
              xhr = new ActiveXObject("Msxml2.XMLHTTP");
            }catch(e){
              //如果还不支持，在这里捕获异常并采用IE5支持的方式
              xhr = new ActiveXObject("Microsoft.XMLHTTP");
            }
          }
          return xhr;
        }

        //获取按钮对象
        var btnEle = document.getElementById("btn01");
        //给按钮绑定单击事件
        btnEle.onclick = function () {
          //发送GET请求
          //1.创建XMLHttpRequest对象
          var xhr = getXMLHttpRequest();
          //2.设置请求信息
          /*
            open(method,url,async)
              method：设置发送的请求的请求方式，get或post
              url：设置请求地址
              async：设置是否发送异步请求，默认是true，发送的是异步请求
           */
          xhr.open("get","${pageContext.request.contextPath}/AjaxServlet?username=admin&password=666666");
          //3.发送请求
          /*
            send(body)
              由于get请求没有请求体，所有send方法中不需要传入任何内容
              如果是post请求，需要通过body指定请求体中的内容
           */
          xhr.send();
          //4.接收响应
          xhr.onreadystatechange = function () {
            if(xhr.readyState == 4 && xhr.status == 200){
              //接收响应数据
              var text = xhr.responseText;
              //将响应信息设置到span标签中
              var spanEle = document.getElementById("res");
              spanEle.innerText = text;
            }
          };
        };

        //获取按钮对象
        var btnEle = document.getElementById("btn02");
        //给按钮绑定单击事件
        btnEle.onclick = function () {
          //发送POST请求
          //1.创建XMLHttpRequest对象
          var xhr = getXMLHttpRequest();
          //2.设置请求信息
          /*
            open(method,url,async)
              method：设置发送的请求的请求方式，get或post
              url：设置请求地址
              async：设置是否发送异步请求，默认是true，发送的是异步请求
           */
          xhr.open("post","${pageContext.request.contextPath}/AjaxServlet");
          //在发送POST请求之前需要设置请求头，对请求参数进行URL编码
          xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
          //3.发送请求
          /*
            send(body)
              由于get请求没有请求体，所有send方法中不需要传入任何内容
              如果是post请求，需要通过body指定请求体中的内容
           */
          xhr.send("username=admin&password=666666");
          //4.接收响应
          xhr.onreadystatechange = function () {
            if(xhr.readyState == 4 && xhr.status == 200){
              //接收XML格式的响应数据
              var domObj = xhr.responseXML;
              //获取student标签
              var stuEle = domObj.getElementsByTagName("student")[0];
              //获取name标签
              var nameEle = stuEle.getElementsByTagName("name")[0];
              //获取name标签中的文本值
              var textNode = nameEle.firstChild;
              //获取文本节点的节点值
              var text = textNode.nodeValue;
              //将响应信息设置到span标签中
              var spanEle = document.getElementById("res2");
              spanEle.innerText = text;
            }
          };
        };
      };
    </script>
  </head>
  <body>
    <%=new Date()%><br>
    <button id="btn01">通过JavaScript发送Ajax请求(GET请求)响应字符串类型的数据</button><span id="res" style="color: red"></span><br>
    <button id="btn02">通过JavaScript发送Ajax请求(POST请求)响应XML格式的数据</button><span id="res2" style="color: red"></span>

  </body>
</html>
