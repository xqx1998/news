<%--
  User: xqx
  Date: 2019/6/7
  Time: 20:54
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->

    <base href="${pageContext.request.contextPath }/">
    <title>论坛后台管理</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>

    <LINK rel=stylesheet href="admin/css/home.css">
</head>
<body>
    <div class="container-fluid">
        <diV class="col-md-11 col-center-block">
        <!-- 页眉 -->
        <div class="row top">
            <%@include file="top.jsp"%>
        </div>
        <div class="row">
            <!-- 左侧导航 -->
            <div class="col-md-2 nav">
                <%@include file="nav.jsp"%>
            </div>
            <!-- 内容主体 -->
            <div class="col-md-10 content">
                <div class="row path">
                    <ol class="breadcrumb ">
                        <li><a href="admin/home.jsp">主页</a></li>
                        <li class="disabled">新闻管理</li>
                        <li class="active"><a href="admin/newsAdd.jsp">新闻发布</a></li>
                    </ol>
                </div>
                <div class="row">
                    <%@include file="newsRelease.jsp"%>
                </div>
            </div>
        </div>
        <!-- 页脚 -->
        <div class="row bottom">
            <%@include file="bottom.jsp"%>
        </div>
        </diV>
    </div>
<br>
<br>
<br>
<br>
</body>
</html>
