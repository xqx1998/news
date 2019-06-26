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

            var change = document.getElementById("change");
            change.onclick = function () {
                // 加时间戳
                var date = new Date().getTime();
                img.src = "CheckCode"+"?"+date;
            }
        }
    </script>
</head>
<body>
<div class="form" style="position:relative">
    <!--注册表单-->
    <div class="form_register">
        <form action="<%=path%>LoginRegister" method="post">
            <h1>注册</h1>
            <div class="form_item">
                <label for="username">用户名：</label>
                <input type="text" name="username" id="username" placeholder="请输入用户名" required >
            </div>
            <div class="form_item">
                <label for="password">密码：</label>
                <input type="password" name="password" id="password" placeholder="请输入密码名" required>
            </div>
            <div class="form_item">
                <label for="email">电子邮箱：</label>
                <input type="email" name="email" id="email" placeholder="请输入电子邮件" required>
            </div>
            <div class="form_item">
                <label for="tel">电话：</label>
                <input type="tel" name="tel" id="tel" placeholder="请输入手机号码" required>
            </div>
            <div class="form_item">
                <label for="password">验证码：</label>
                <input type="text" name="checkCode"  placeholder="请输入验证码" required>
                <img id="img" src="CheckCode">
                <span id="change" style="cursor: hand">看不清，换一张</span>
            </div>
            <div class="form_item">
                <input type="hidden" name="type" value="register" />
                <input type="submit" value="注册">
            </div>
            <div class="info">已有账号？点击<span><a href="login.jsp"> 登录</a></span></div>
        </form>

    </div>

</div>
</body>
</html>
