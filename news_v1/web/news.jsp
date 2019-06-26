<%@ page import="com.xqx.model.News" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.xqx.model.Reply" %>
<%@ page import="com.xqx.model.User" %><%--
  Created by IntelliJ IDEA.
  User: xqx
  Date: 2019/5/13
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="newsDaoImpl" class="com.xqx.dao.impl.NewsDaoImpl" scope="page"></jsp:useBean>
<%--<jsp:useBean id="topicDaoImpl" class="com.xqx.dao.impl.TopicDaoImpl" scope="page"></jsp:useBean>--%>
<jsp:useBean id="replyDaoImpl" class="com.xqx.dao.impl.ReplyDaoImpl" scope="page"></jsp:useBean>
<jsp:useBean id="userDaoImpl" class="com.xqx.dao.impl.UserDaoImpl" scope="page"></jsp:useBean>
<%

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
	<script type="text/javascript" src="admin/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="admin/ueditor/ueditor.all.js"></script>
	<LINK rel=stylesheet href="admin/ueditor/themes/default/css/ueditor.css">
	<script type="text/javascript" src="admin/ueditor/third-party/SyntaxHighlighter/shCore.js"></script>
	<link rel="stylesheet" href="admin/ueditor/third-party/SyntaxHighlighter/shCoreDefault.css">
	<script type="text/javascript">
        SyntaxHighlighter.all();
	</script>
	<style>
		.content {
			height: auto;
			border: 1px solid crimson;
			overflow-x: scroll;
			overflow-y: scroll;
		}
	</style>
</head>
<body style="background-color: #d6a2a2;">
<div class="container p"  >
	<diV class="col-md-12 col-center-block">
		<!-- 页眉 -->
		<div class="row top">
			<%@include file="top.jsp" %>
		</div>
		<div class="row">
			<!-- 内容主体 -->
			<div class="row">
				<%
					request.setCharacterEncoding("utf-8");
					String news_id = request.getParameter("id");
					int news_id0 = Integer.valueOf(news_id).intValue();
					String topic = request.getParameter("topic");
					News news = newsDaoImpl.newsSelect(news_id0);
				%>
				<div class="input-group input-group-lg text">
					<span class="input-group-addon">标题: <%=news.getNews_title()%></span>
				</div>
				<div class="input-group input-group-lg text">
					<span class="input-group-addon text-right">类别: <%=topic%></span>
				</div>
				<div class="content"><%=news.getNews_content()%>
				</div>
			</div>
		</div>
		`
		<div class="row">
			<div class="row text-right">
				<span><a href="frontNewsAdd.jsp">我要发贴</a></span>
				<hr/>
			</div>
			<%
				//查询输出一级评论
				String sql1 = "SELECT * FROM bbs_xqx.reply where reply_news_id=" + news.getNews_id() + " and reply_level = 1";
				ArrayList<Reply> replyArrayList = replyDaoImpl.replySelectList(sql1);
				Reply reply = null;
				for (int i = 1; i <= replyArrayList.size(); i++) {
					reply = replyArrayList.get(i - 1);
					User user1 = userDaoImpl.userSelect(reply.getReply_user_id());
			%>

			<div class="row" style="background-color: #ffacb3">
				<div class="col-md-3">
					<img src="images/user/man2.jpg" width="100" height="200"/>
					<h2><%=i%>楼 <%=user1.getUsername()%>
					</h2>
				</div>
				<div class="col-md-9">
					<div class="row">
					<div class="col-md-1"><%=reply.getReply_id()%>
					</div>
					<div class="col-md-1"><%=reply.getReply_news_id()%>
					</div>
					<div class="col-md-1"><%=reply.getReply_user_id()%>
					</div>
					<div class="col-md-2"><%=reply.getReply_level()%>
					</div>
					<div class="col-md-2"><%=reply.getReply_reply_id()%>
					</div>
					<div class="col-md-4"><%=reply.getReply_time()%>
					</div>
					</div>
					<div class="row">
						<%=reply.getReply_content()%>
					</div>
					<%
						// 查询输出二级评论
						String sql2 = "SELECT * FROM bbs_xqx.reply where reply_news_id=" + news.getNews_id() + " and reply_level = 2 and reply_reply_id=" + reply.getReply_id();
						ArrayList<Reply> replyArrayList2 = replyDaoImpl.replySelectList(sql2);
						Reply reply2 = null;
						for (int i2 = 1; i2 <= replyArrayList2.size(); i2++) {
							reply2 = replyArrayList2.get(i2 - 1);
							User user2 = userDaoImpl.userSelect(reply2.getReply_user_id());

					%>
					<div class="row">
						<%--                <div class="col-md-3"><h3><%=i%>-<%=i2%>楼回复<%=i%>楼</h3></div>--%>
						<div class="col-md-3"><h3><%=user2.getUsername()%>回复<%=user1.getUsername()%>
						</h3></div>
						<div class="col-md-1"><%=reply2.getReply_id()%>
						</div>
						<div class="col-md-1"><%=reply2.getReply_news_id()%>
						</div>
						<div class="col-md-1"><%=reply2.getReply_user_id()%>
						</div>
						<div class="col-md-2"><%=reply2.getReply_level()%>
						</div>
						<div class="col-md-2"><%=reply2.getReply_reply_id()%>
						</div>
						<div class="col-md-2"><%=reply2.getReply_time()%>
						</div>
							<div class="row"></div>
						<div class="row">
							<div class="col-md-7 text-right"><%=reply2.getReply_content()%></div>
						</div>
					</div>
					<div class="row text-right">
						<a href="news.jsp?id=<%=news_id%>&&topic=<%=topic%>&&replyId=<%=reply2.getReply_id()%>">回复</a>
					</div>
					<hr/>
					<%
						if ((reply2.getReply_id() + "").equals(request.getParameter("replyId"))) {
					%>
					<div id="reply_reply" class="row">
						<form action="ReplyAddServlet" method="post">
							<textarea name="reply_content" id="myEditor2" style="height: 30%"></textarea>
							<%--    <script id="myEditor" name="textContent" type="text/plain"></script>--%>
							<script type="text/javascript">
                                // var editor =new UE.ui.Editor();
                                // editor.render("myEditor");
                                //1.2.4以后可以使用一下代码实例化编辑器
                                UE.getEditor('myEditor2');
							</script>
							<div class="col-md-8 pull-right">
								<input class="hidden" type="text" name="reply_news_id" value="<%=news.getNews_id()%>"/>
								<input class="hidden" type="text" name="reply_user_id"
								       value="${sessionScope.user.getUser_id()}"/>
								<input class="hidden" type="text" name="topic" value="<%=topic%>"/>
								<input class="hidden" type="text" name="reply_level" value="2"/>
								<input class="hidden" type="text" name="reply_reply_id"
								       value="<%=reply.getReply_id()%>"/>
								<input class="btn-default btn-lg " type="reset" value="重置"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input class="btn-primary btn-lg " type="submit" value="提交"/>
							</div>
						</form>
					</div>
					<%
							}
						}
					%>
				</div>
			</div>



			<div class="row text-right">
				<a href="news.jsp?id=<%=news_id%>&&topic=<%=topic%>&&replyId=<%=reply.getReply_id()%>">评论</a>
			</div>
			<hr/>
			<%
				if ((reply.getReply_id() + "").equals(request.getParameter("replyId"))) {
			%>
			<div id="reply_reply" class="row">
				<form action="ReplyAddServlet" method="post">
					<textarea name="reply_content" id="myEditor2" style="height: 30%"></textarea>
					<%--    <script id="myEditor" name="textContent" type="text/plain"></script>--%>
					<script type="text/javascript">
                        // var editor =new UE.ui.Editor();
                        // editor.render("myEditor");
                        //1.2.4以后可以使用一下代码实例化编辑器
                        UE.getEditor('myEditor2');
					</script>
					<div class="col-md-8 pull-right">
						<input class="hidden" type="text" name="reply_news_id" value="<%=news.getNews_id()%>"/>
						<input class="hidden" type="text" name="reply_user_id"
						       value="${sessionScope.user.getUser_id()}"/>
						<input class="hidden" type="text" name="topic" value="<%=topic%>"/>
						<input class="hidden" type="text" name="reply_level" value="2"/>
						<input class="hidden" type="text" name="reply_reply_id" value="<%=reply.getReply_id()%>"/>
						<input class="btn-default btn-lg " type="reset" value="重置"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="btn-primary btn-lg " type="submit" value="提交"/>
					</div>
				</form>
			</div>
			<%
					}
				}
			%>
			<div class="col-md-2">
				<span>发表评论</span>
			</div>
			<div class="col-md-10">
				<form action="ReplyAddServlet" method="post">
					<textarea name="reply_content" id="myEditor" style="height: 30%"></textarea>
					<%--    <script id="myEditor" name="textContent" type="text/plain"></script>--%>
					<script type="text/javascript">
                        // var editor =new UE.ui.Editor();
                        // editor.render("myEditor");
                        //1.2.4以后可以使用一下代码实例化编辑器
                        UE.getEditor('myEditor');
					</script>
					<div class="col-md-5 pull-right">
						<input class="hidden" type="text" name="reply_news_id" value="<%=news.getNews_id()%>"/>
						<input class="hidden" type="text" name="reply_user_id"
						       value="${sessionScope.user.getUser_id()}"/>
						<input class="hidden" type="text" name="topic" value="<%=topic%>"/>
						<input class="hidden" type="text" name="reply_level" value="1"/>
						<input class="btn-default btn-lg " type="reset" value="重置"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="btn-primary btn-lg " type="submit" value="提交"/>
					</div>
				</form>
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

