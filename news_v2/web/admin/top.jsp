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
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row" style="background-color: #d0e2db;">
        <div class="col-md-3">
            <h1>论坛后台管理</h1>
        </div>
        <div class="col-md-4">
            <h2><a href="index.jsp">论坛首页</a></h2>
        </div>
        <div class="col-md-5">
            <h1>个人信息：${sessionScope.user.getUsername()}</h1>
        </div>
    </div>

</div>
</body>
</html>
