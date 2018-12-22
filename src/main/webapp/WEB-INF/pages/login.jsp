<%--
  Created by IntelliJ IDEA.
  User: 22321
  Date: 2018/12/21
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/Path.jsp"%>
<!DOCTYPE html>
<!-- saved from url=(0050)http://www.jq22.com/demo/jquery-Sharelink20151012/ -->
<html lang="zh-CN">
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>登陆</title>
    <link rel="stylesheet" href="${path}/login_files/style.css">
</head>
<body>
    <div class="login-container">
        <h1>登陆</h1>
        <div class="connect">
            <p style="left: 0%;">开启新的旅程</p>
        </div>
        <form id="loginForm" novalidate="novalidate">
            <div>
                <input type="text" name="username" class="username" placeholder="用户名" value="${username}" autocomplete="off">
            </div>
            <div>
                <input type="password" name="password" class="password" placeholder="密码" oncontextmenu="return false" onpaste="return false">
            </div>
            <button id="submit" type="button">登 陆</button>
        </form>
        <a href="register">
            <button type="button" class="register-tis">还有没有账号？</button>
        </a>
    </div>

    <script src="${path}/js/jquery.min.js"></script>
    <script src="${path}/js/jquery.min(1).js"></script>
    <script src="${path}/js/common.js"></script>

    <script src="${path}/js/supersized.3.2.7.min.js"></script>
    <script src="${path}/js/supersized-init.js"></script>

    <script src="${path}/js/jquery.validate.min.js"></script>


    <script>
        $(function () {
            $("#submit").click(function () {
                var loginInfo = $("#loginForm").serialize();
                $.ajax({
                    url:"${path}/login",
                    type:"post",
                    data:loginInfo,
                    success:function (e) {
                        if (e == "homepage1" || e == "homepage2" || e == "homepage3"){
                            // alert(sessionStorage.getItem(url))
                            window.location.href="${path}/" + e;
                        }
                        if (e == "2"){
                            alert("密码错误！");
                        }
                        if (e == "3"){
                            alert("没有该用户，请前往注册！");
                        }
                        if (e == "4"){
                            alert("用户名或密码输入为空！");
                        }
                    }
                });
            });
        });
    </script>




    <ul id="supersized" class="quality" style="visibility: visible;">
        <li class="slide-0 activeslide" style="visibility: visible; opacity: 1;">
            <a target="_blank">
                <img src="${path}/login_files/1.jpg" style="width: 1368px; left: 0px; top: -70px; height: 861.84px;">
            </a>
        </li>
        <li class="slide-1" style="visibility: visible; opacity: 1;">
            <a target="_blank">
                <img src="${path}/login_files/2.jpg" style="width: 1368px; left: 0px; top: -118px; height: 957.6px;">
            </a>
        </li>
        <li class="slide-2 prevslide" style="visibility: visible; opacity: 1;">
            <a target="_blank">
                <img src="${path}/login_files/3.jpg" style="width: 1368px; height: 861.84px; left: 0px; top: -70px;">
            </a>
        </li>
    </ul>
</body>
</html>
