<%--
  Created by IntelliJ IDEA.
  User: xqx
  Date: 2019/5/14
  Time: 8:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath()+"/";
%>
<html>
<head>
    <base href="<%=path%>">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>首页</title>
    <link rel="stylesheet" href="css/style.css">
    <script>
        /*
        分析：更新验证码，点击超链接或图片
        1.给超链接和图片绑定单击事件
        2.重新设置图片的src属性
         */
        window.onload = function () {
            //1.获取图片对象
            var img = document.getElementById("img");

            //2.绑定单击对象
            img.onclick = function () {
                // 加时间戳
                var date = new Date().getTime();
                //重写验证码请求路径
                img.src = "CheckCode"+"?"+date;
            }

            var change1 = document.getElementById("change");
            change1.onclick = function () {
                // 加时间戳
                var date = new Date().getTime();
                img.src = "CheckCode"+"?"+date;
            }
        }
    </script>
</head>
<body>
<div class="form" style="position:relative">
   <!--登录表单-->
    <div class="form_login">

        <form action="<%=path%>LoginRegister" method="post">
            <h1>管理员登录</h1>
            <div class="form_item">
                <label for="username">用户名：</label>
                <input type="text" name="username" id="username" placeholder="请输入用户名" required autofocus="autofocus">
            </div>
            <div class="form_item">
                <label for="password">密码：</label>
                <input type="password" name="password" id="password" placeholder="请输入密码名" required>
            </div>
            <div class="form_item">
                <label for="password">验证码：</label>
                <input type="text" name="checkCode"  placeholder="请输入验证码" required>
                <img id="img" src="CheckCode">
                <a id="change" style="cursor: hand">看不清，换一张</a>
            </div>
            <div class="form_item">
                <input type="hidden" name="type" value="login" />
                <input type="submit" value="登录">
            </div>
        </form>
        <div class="info">没有账号？点击<span class="switch register_Btn"><a href="register.jsp"> 注册账号</a></span></div>

    </div>

</div>
</body>
</html>
