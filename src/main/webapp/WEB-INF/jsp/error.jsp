<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/11
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>error</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../../lib/bootstrap/css/bootstrap.css">
    <%
        //每秒刷新一次
        response.setHeader("type","error");
    %>
</head>
<body style="background-color: #f2f2f2">

<div class="container">

    <div class="row">
        <div class="col-md-8 col-md-offset-1">
            <img src="../../images/error.jpg" alt="" style="width:928px;height: 500px ">
        </div>
    </div>
    <div class="row">
        <div class="col-lg-4 col-lg-offset-4">
            <p style="font-size: 45px;letter-spacing: 18px;text-align: center">你没有权限</p>
        </div>
    </div>


</body>
<script src="../../lib/jquery/jquery.js"></script>
<script src="../../lib/bootstrap/js/bootstrap.js"></script>
</html>
