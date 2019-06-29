<%@ page import="com.xqx.model.Topic" %>
<%@ page import="java.util.ArrayList" %><%--
  User: xqx
  Date: 2019/6/11
  Time: 9:26
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="topicDaoImpl" class="com.xqx.dao.impl.TopicDaoImpl" scope="page"></jsp:useBean>
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
	<style>
		.h {
			height: 28px;
			margin-top: 10px;

		}
	</style>
</head>
<body>
<div class="row">
	<nav class="navbar navbar-inverse h col-md-11 " style="margin-left: 4% ">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<!--            定义汉堡按钮-->
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
				        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="">落雨心星论坛</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">

					<li><a href="#">首页 <span class="sr-only">(current)</span></a></li>
					<li><a href=""></a></li>
				</ul>
				<form action="serach.jsp" method="post" class="navbar-form navbar-left">
					<div class="form-group">
						<input type="text" class="form-control" name="serach" placeholder="请输入搜索内容">
					</div>
					<button type="submit" class="btn btn-default">搜索</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<%
						if (session.getAttribute("user") == null) {
					%>
					<li><a href="login.jsp">登录</a></li>
					<%
					} else {
					%>

							<li><a href="">${sessionScope.user.getUsername()}</a></li>
							<li><a href="admin/home.jsp">个人后台</a></li>
							<li><a href="index.jsp?action=sign_out">登出</a></li>

							<li><a href="admin/home.jsp">后台管理</a></li>
							<li role="separator" class="divider"></li>

					<%
						}
					%>
				</ul>

			</div>
		</div>
	</nav>
</div>
<div class="row">
	<div class="col-md-1 text-center"><h3><span>板块:</span></h3></div>
			<%
				ArrayList<Topic> topicArrayList = topicDaoImpl.selectAll();
				System.out.println(topicArrayList);
				if (topicArrayList.size() > 0) {
					for (Topic topic : topicArrayList) {
			%>
			<div class="col-md-1 text-center"><h3><a href="newsListTopic.jsp?topicId=<%=topic.getTopic_id()%>&&topic=<%=topic.getTopic_name()%>"><%=topic.getTopic_name()%>
			</a></h3></div>
			<%
					}
				}
			%>
</div>
</body>
</html>
