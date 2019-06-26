<%@ page import="com.cyw.model.News" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.cyw.model.Topic" %><%--
  Created by IntelliJ IDEA.
  User: cyw
  Date: 2019/5/13
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="newsDaoImpl" class="com.cyw.dao.impl.NewsDaoImpl" scope="page"></jsp:useBean>
<jsp:useBean id="topicDaoImpl" class="com.cyw.dao.impl.TopicDaoImpl" scope="page"></jsp:useBean>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <base href="${pageContext.request.contextPath }/">
    <title>新闻后台管理</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
    <LINK rel=stylesheet href="css/index.css">
    <script type="text/javascript" src="admin/ueditor/third-party/SyntaxHighlighter/shCore.js"></script>
    <link rel="stylesheet" href="admin/ueditor/third-party/SyntaxHighlighter/shCoreDefault.css">
    <script type="text/javascript">
        SyntaxHighlighter.all();
    </script>
	<style>
		.content{
			height: auto;
			border: 1px solid crimson;
			overflow-x: scroll;
			overflow-y: scroll;
		}
	</style>
</head>
<body>
<div class="container">
    <diV class="col-md-12 col-center-block">
        <!-- 页眉 -->
        <div class="row top">
            <%@include file="top.jsp"%>
        </div>
        <div class="row">
            <div class="row path">
                <ol class="breadcrumb ">
                    <li><a href="admin/home.jsp">主页</a></li>
                    <li class="disabled">发帖管理</li>
                    <li class="active">发帖预览</li>
                </ol>
            </div>
            <!-- 内容主体 -->
            <div class="row">
                <%
                    request.setCharacterEncoding("utf-8");
                    String news_id = request.getParameter("id");
                    System.out.println(news_id);
                    int news_id0 = Integer.valueOf(news_id).intValue();
                    News news = null;
                    if (news_id0==0) {
                        news = newsDaoImpl.newsSelectEnd();
                        news = newsDaoImpl.newsSelect(news.getNews_id());
                    }else {
                        news = newsDaoImpl.newsSelect(news_id0);
                    }
                    String topic_id = request.getParameter("topic_id");
                    int topic_id0 = Integer.valueOf(topic_id).intValue();
                    System.out.println(topic_id);
                    Topic topic = topicDaoImpl.select(topic_id0);
                %>
                    <div class="input-group input-group-lg text">
                        <span class="input-group-addon">标题: <%=news.getNews_title()%></span>
                    </div>
                    <div class="input-group input-group-lg text">
                        <span class="input-group-addon text-right">类别: <%=topic.getTopic_name()%></span>
                    </div>
                <div class="content"><%=news.getNews_content()%></div>
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

