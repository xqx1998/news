<%@ page import="com.xqx.model.News" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: xqx
  Date: 2019/5/13
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="newsDaoImpl" class="com.xqx.dao.impl.NewsDaoImpl" scope="page" />

<%
	//获取动作
	String action = request.getParameter("action");
	if (action != null && "sign_out".equals(action)) {
		session.removeAttribute("user");
	}
	//设置页面显示记录数
	int pagesize = 8;
	String topicName = "未指定";
	topicName = request.getParameter("topic");
	String topicId = request.getParameter("topicId");
	int topicId0 = 0;
	if(topicId != null && topicId.split(" ").length!=0){
	    topicId0 = Integer.valueOf(topicId).intValue();
	}

%>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
	<base href="${pageContext.request.contextPath }/">
	<title>落雨心星论坛</title>

	<!-- Bootstrap -->
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script src="js/jquery-3.2.1.min.js"></script>
	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script src="js/bootstrap.min.js"></script>
	<LINK rel=stylesheet href="css/index.css">
</head>
<body>
<div class="container">
	<diV class="col-md-12 col-center-block p">
		<!-- 页眉 -->
		<div class="row top">
			<%@include file="top.jsp" %>
		</div>
		<div class="row">
		<span class="active" >当前板块：<%=topicName%></span>
		</div>
		<div class="row border-top">

			<!-- 内容主体 -->
			<div class="col-md-12 content">
				<table class="table table-condensed table-hover text-center">
					<%--内容--%>
					<th class="row">
					<td class="col-md-1">选择 发帖编号</td>
					<td class="col-md-4">发帖标题</td>
					<td class="col-md-1">分类编号 类别</td>
					<td class="col-md-2">发布时间</td>
					<td class="col-md-1">发布者编号</td>
					<td class="col-md-2">发布者名称 访问量</td>
					<td class="col-md-1">操作</td>
					</th>
					<%
						String pages = request.getParameter("pages");
						int pages0 = 0;
						String sql = "select news_id, news_title, news_topic_id, topic_name, news_time, news_user_id, news_username, news_access from view_news where news_topic_id = "+ topicId0 +" order by news_id desc limit " + pagesize + ";";
						if (pages != null) {
							pages0 = Integer.valueOf(pages).intValue();
							sql = "select news_id, news_title, news_topic_id, topic_name, news_time, news_user_id, news_username, news_access from view_news where news_topic_id = "+ topicId0 +" order by news_id desc limit " + (pages0 - 1) * pagesize + ", " + pagesize + ";";
						}
						ArrayList<News> newsArrayList = newsDaoImpl.newsSelectList(sql);
						if (newsArrayList.size() > 0) {
							for (News news : newsArrayList) {
					%>
					<tr class="row">
						<td class="col-md-1">
							<input type="checkbox" name="news_id" value="<%=news.getNews_id()%>"/>
							<%=news.getNews_id()%>
						</td>
						<td class="col-md-4"><a
								href="news.jsp?id=<%=news.getNews_id()%>&&topic=<%=news.getNews_topic()%>"><%=news.getNews_title()%>
						</a></td>
						<td class="col-md-1"><%=news.getNews_TopicId()%> <%=news.getNews_topic()%>
						</td>
						<td class="col-md-2"><%=news.getNews_time()%>
						</td>
						<td class="col-md-1"><%=news.getNews_user_id()%>
						</td>
						<td class="col-md-2"><%=news.getNews_username()%> <%=news.getNews_access()%>
						</td>
						<td class="col-md-1">
							<button class="button btn-info"><a
									href="news.jsp?id=<%=news.getNews_id()%>&&topic=<%=news.getNews_topic()%>">查看</a>
							</button>
						</td>
					</tr>
					<%
						}
					} else {
					%>
					<tr class="row text-center">
						<td colspan="6" class="col-md-1">暂无发帖信息</td>
					</tr>
					<%
						}
					%>

				</table>

				<nav aria-label="Page navigation">
					<ul class="pagination">

						<li>
							<%
								if (pages0 > 1) {
							%>
							<a href="newsListTopic.jsp?topicId=<%=topicId0%>&&topic=<%=topicName%>&&pages=<%=pages0-1%>" aria-label="Previous">
								<span aria-hidden="true">&laquo;</span>
							</a>
							<%
								}
							%>
						</li>
						<%
							//获取发帖总数
							int newsCount0 = newsDaoImpl.newsCount();
							int pag_0 = newsCount0 / pagesize;
							int pag_1 = newsCount0 % pagesize;
							if (pag_1 > 0) {
								pag_0 += 1;
							}
							int i = 0;
							for (i = 1; i <= pag_0; i++) {
								if (i != pages0) {
						%>
						<li>
							<a href="newsListTopic.jsp?topicId=<%=topicId0%>&&topic=<%=topicName%>&&pages=<%=i%>"><%=i%>
							</a>
						</li>
						<%
						} else {
						%>
						<li class="active"><a href="newsListTopic.jsp?topicId=<%=topicId0%>&&topic=<%=topicName%>&&pages=<%=i%>"><%=i%>
						</a></li>
						<%

								}
							}
						%>

						<li>
							<%
								if (pages0 < pag_0) {
							%>
							<a href="newsListTopic.jsp?topicId=<%=topicId0%>&&topic=<%=topicName%>&&pages=<%=pages0+1%>" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
							</a>
							<%
								}
							%>
						</li>
					</ul>
				</nav>
			</div>
		</div>
		<!-- 页脚 -->
		<div class="row bottom">
			<%@include file="footer.jsp" %>
		</div>
	</diV>
</div>
<br>
<br>
<br>
<br>
</body>
</html>

