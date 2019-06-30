<%@ page import="com.xqx.model.News" %>
<%@ page import="java.util.ArrayList" %><%--
  User: xqx
  Date: 2019/6/7
  Time: 20:54
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="newsDaoImpl" class="com.xqx.dao.impl.NewsDaoImpl" scope="page"></jsp:useBean>

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
        <diV class="col-md-11 col-center-block" style="border: 2px solid #616dff;">
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
                        <li class="disabled">帖子管理</li>
                        <li class="active"><a href="admin/newsListHot.jsp">热点帖子</a></li>
                    </ol>
                </div>
                <div class="row">
                    <%--内容--%>
                    <table class="table table-condensed table-hover text-center">
                        <th class="row">
                        <td class="col-md-1">选择 帖子编号</td>
                        <td class="col-md-4">帖子标题</td>
                        <td class="col-md-1">分类编号 类别</td>
                        <td class="col-md-2">发布时间</td>
                        <td class="col-md-1">发布者编号</td>
                        <td class="col-md-2">发布者名称 访问量</td>
                        <td class="col-md-1">操作</td>
                        </th>
                        <%
                            String sql = "select news_id, news_title, news_topic_id, topic_name, news_time, news_user_id, news_username, news_access from view_news order by news_access desc limit 15";
                            ArrayList<News> newsArrayList = newsDaoImpl.newsSelectList(sql);
                            if(newsArrayList.size()>0){
                                for (News news: newsArrayList) {
                        %>
                        <tr class="row">
                            <td class="col-md-1">
                                <input type="checkbox"name="news_id" value="<%=news.getNews_id()%>" />
                                <%=news.getNews_id()%>
                            </td>
                            <td class="col-md-4"><%=news.getNews_title()%></td>
                            <td class="col-md-1"><%=news.getNews_TopicId()%> <%=news.getNews_topic()%> </td>
                            <td class="col-md-2"><%=news.getNews_time()%></td>
                            <td class="col-md-1"><%=news.getNews_user_id()%></td>
                            <td class="col-md-2"><%=news.getNews_username()%> <%=news.getNews_access()%></td>
                            <td class="col-md-1">
                                <button class="button btn-info"><a href="admin/newsUpdate.jsp?id=<%=news.getNews_id()%>&&topic_id=<%=news.getNews_TopicId()%>">编辑</a></button>
                                <button class="button btn-warning"><a href="admin/NewsDeleteServlet.servlet?id=<%=news.getNews_id()%>">删除</a></button>
                            </td>
                        </tr>
                        <%
                            }
                        }else{
                        %>
                        <tr class="row text-center">
                            <td colspan="6" class="col-md-1">暂无帖子信息</td>
                        </tr>
                        <%
                            }
                        %>

                    </table>

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
