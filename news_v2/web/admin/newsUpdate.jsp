<%@ page import="com.xqx.model.News" %>
<%@ page import="com.xqx.model.Topic" %>
<%@ page import="java.util.ArrayList" %><%--
  User: xqx
  Date: 2019/6/7
  Time: 20:54
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="newsDaoImpl" class="com.xqx.dao.impl.NewsDaoImpl" scope="page"></jsp:useBean>
<jsp:useBean id="topicDaoImpl" class="com.xqx.dao.impl.TopicDaoImpl" scope="page"></jsp:useBean>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta http-equiv ="pragma" content="no-cache">
    <meta http-equiv ="cache-control" content="no-cache">
    <meta http-equiv ="expires" content="0">
    <base href="${pageContext.request.contextPath }/">
    <title>论坛后台管理</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>

    <LINK rel=stylesheet href="admin/css/home.css">

    <script type="text/javascript" src="admin/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="admin/ueditor/ueditor.all.js"></script>
    <LINK rel=stylesheet href="admin/ueditor/themes/default/css/ueditor.css">
    <style type="text/css">
        .text{
            letter-spacing: 10px;
            font-family: "Adobe 宋体 Std L";
            font-size: 24px;
        }
        .margintop{
            margin-top: 10px;
        }
    </style>
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
                        <li class="disabled">帖子管理</li>
                        <li><a href="admin/newsList.jsp">帖子列表</a></li>
                        <li class="active"><a href="admin/newsUpdate.jsp">帖子修改</a></li>
                    </ol>
                </div>
                <div class="row">
                    <%
                        request.setCharacterEncoding("utf-8");
                        String news_id = request.getParameter("id");
                        int news_id0 = Integer.valueOf(news_id).intValue();
                        String topic_id = request.getParameter("topic_id");
                        int topic_id0 = Integer.valueOf(topic_id).intValue();
                        News news = newsDaoImpl.newsSelect(news_id0);
                    %>
                    <form action ="admin/NewsUpdateServlet.servlet"method="post">
                        <div class="input-group input-group-lg text">
                            <span class="input-group-addon">标题</span>
                            <input type="text" class="form-control" name="title" value="<%=news.getNews_title()%>" aria-describedby="sizing-addon1">
                        </div>
                        <div class="input-group input-group-lg text">
                            <span class="input-group-addon">类别</span>
<%--                            <input type="text" class="form-control" name="category" value="" aria-describedby="sizing-addon1">--%>
<%--                            <%=news.getNews_TopicId()%>--%>
                            <select name="category">
                                <%
                                    ArrayList<Topic> topicArrayList = topicDaoImpl.selectAll();
                                    if (topicArrayList.size()>0){
                                        for (Topic topic:topicArrayList) {
                                            if(topic_id0 == news.getNews_TopicId()){
                                %>
                                <option value="<%=topic.getTopic_id()%>" selected="selected"><%=topic.getTopic_name()%></option>
                                <%
                                }else{
                                %>
                                <option value="<%=topic.getTopic_id()%>"><%=topic.getTopic_name()%></option>
                                <%
                                            }
                                        }
                                    }
                                %>
                            </select>
                        </div>

                        <textarea name="content" id="myEditor" style="height: 65%">
                            <%=news.getNews_content()%>
                        </textarea>
                        <%--    <script id="myEditor" name="textContent" type="text/plain"></script>--%>
                        <script type="text/javascript">
                            // var editor =new UE.ui.Editor();
                            // editor.render("myEditor");
                            //1.2.4以后可以使用一下代码实例化编辑器
                            UE.getEditor('myEditor');
                        </script>
                        <div class="col-md-2 pull-right">
                            <input class="hidden" type="text" name="news_id" value="<%=news.getNews_id()%>" />
                            <input class="hidden" type="text" name="news_access" value="<%=news.getNews_access()%>" />
                            <input class="hidden" type="text" name="news_username" value="${sessionScope.user.getUsername()}" />
                            <input class="hidden" type="text" name="news_user_id" value="${sessionScope.user.getUser_id()}" />
                            <input class="btn-default btn-lg " type="reset" value="重置"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input class="btn-primary btn-lg " type="submit" value="提交"/>
                        </div>
                    </form>
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
