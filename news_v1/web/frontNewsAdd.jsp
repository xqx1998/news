<%--
  User: xqx
  Date: 2019/6/8
  Time: 8:53
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.cyw.model.Topic" %>
<jsp:useBean id="topicDaoImpl" class="com.cyw.dao.impl.TopicDaoImpl" scope="page">

</jsp:useBean>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv ="pragma" content="no-cache">
    <meta http-equiv ="cache-control" content="no-cache">
    <meta http-equiv ="expires" content="0">
    <script type="text/javascript" src="admin/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="admin/ueditor/ueditor.all.js"></script>
    <LINK rel=stylesheet href="admin/ueditor/themes/default/css/ueditor.css">
    <script type="text/javascript" src="admin/ueditor/third-party/SyntaxHighlighter/shCore.js"></script>
    <link rel="stylesheet" href="admin/ueditor/third-party/SyntaxHighlighter/shCoreDefault.css">
    <script type="text/javascript">
        SyntaxHighlighter.all();
    </script>
    <style type="text/css">
        .text{
            letter-spacing: 10px;
            font-family: "Adobe 宋体 Std L";
            font-size: 24px;
        }
    </style>
</head>

<body style="background-color: #d6a2a2;">
<form action ="admin/NewsReleaseServlet"method="post">
    <div class="input-group input-group-lg text">
        <span class="input-group-addon">标题</span>
        <input type="text" class="form-control" name="title" aria-describedby="sizing-addon1">
    </div>
    <div class="input-group input-group-lg text">
        <span class="input-group-addon">类别</span>
<%--        <input type="text" class="form-control" name="category" aria-describedby="sizing-addon1">--%>
        <select name="category">
            <%
                ArrayList<Topic> topicArrayList = topicDaoImpl.selectAll();
                if (topicArrayList.size()>0){
                for (Topic topic:topicArrayList) {
                    System.out.println(topic);
            %>
            <option value="<%=topic.getTopic_id()%>"><%=topic.getTopic_name()%></option>
            <%
                }
                }
            %>
        </select>
    </div>
<textarea name="content" id="myEditor" style="height: 65%"></textarea>
<%--    <script id="myEditor" name="textContent" type="text/plain"></script>--%>
<script type="text/javascript">
// var editor =new UE.ui.Editor();
// editor.render("myEditor");
//1.2.4以后可以使用一下代码实例化编辑器
UE.getEditor('myEditor');
</script>
    <div class="col-md-2 pull-right">
        <input class="hidden" type="text" name="news_username" value="${sessionScope.user.getUsername()}" />
        <input class="hidden" type="text" name="news_user_id" value="${sessionScope.user.getUser_id()}" />
        <input class="btn-default btn-lg " type="reset" value="重置"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input class="btn-primary btn-lg " type="submit" value="提交"/>
    </div>
</form>

</body>
</html>