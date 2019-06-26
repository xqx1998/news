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
    <title>HelloWorld</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
    <style>
        .nav-text{
            letter-spacing:12px;
        }
    </style>

</head>
<body>
<div class="container-fluid">
    <!-- Single button -->
    <div class="btn-group col-md-12">
        <button type="button" class="btn btn-default dropdown-toggle nav-text" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            发帖管理 <span class="caret"></span>
        </button>
        <ul class="dropdown-menu">
            <li><a href="admin/newsAdd.jsp">发帖发布</a></li>
            <li><a href="admin/newsList.jsp">发帖列表</a></li>
            <li><a href="admin/newsListNovel.jsp">最新发帖</a></li>
            <li><a href="admin/newsListHot.jsp">热点发帖</a></li>
    </ul>
    </div>
    <div class="btn-group col-md-12">
        <button type="button" class="btn btn-default dropdown-toggle nav-text" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            主题管理 <span class="caret"></span>
        </button>
        <ul class="dropdown-menu">
            <li><a href="admin/newsAdd.jsp">主题添加</a></li>
            <li><a href="admin/newsList.jsp">主题列表</a></li>
    </ul>
    </div>
    <div class="btn-group col-md-12">
    <button type="button" class="btn btn-default dropdown-toggle nav-text" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            用户管理 <span class="caret"></span>
        </button>
        <ul class="dropdown-menu col-md-12">
            <li><a href="#">用户列表</a></li>
            <li><a href="#">信息修改</a></li>
            <li><a href="#">密码修改</a></li>

        </ul>
    </div>
    <div class="btn-group col-md-12">
    <button type="button" class="btn btn-default dropdown-toggle nav-text" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            评论管理 <span class="caret"></span>
        </button>
        <ul class="dropdown-menu col-md-12">
            <li><a href="#">评论列表</a></li>
            <li><a href="#">评论查询</a></li>

            </a></li>

        </ul>
    </div>
    <div class="btn-group col-md-12">
        <button type="button" class="btn btn-default dropdown-toggle nav-text" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            个人管理 <span class="caret"></span>
        </button>
        <ul class="dropdown-menu">
            <li><a href="#">信息修改</a></li>
            <li><a href="#">密码修改</a></li>
        </ul>
    </div>
    <div class="btn-group col-md-12 nav-text">
        <a href="index.jsp?action=sign_out" class="btn btn-info" role="button">&nbsp;登&nbsp;&nbsp;&nbsp;出&nbsp;</a>
    </div>
</div>
</body>
</html>
