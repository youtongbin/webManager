<%--
  Created by IntelliJ IDEA.
  User: 22321
  Date: 2018/12/21
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/Path.jsp"%>
<!DOCTYPE html>
<!-- saved from url=(0063)http://www.jq22.com/demo/jquery-Sharelink20151012/register.html -->
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>注册</title>
    <link rel="stylesheet" href="${path}/register_files/style.css">
</head><body>
    <div class="register-container">
        <h1>注册</h1>
        <div class="connect">
            <p style="left: 0%;">快来加入我们吧</p>
        </div>
        <form id="registerForm" novalidate="novalidate">
            <div>
                <input type="text" name="username" id="username" class="username" placeholder="您的用户名" autocomplete="off">
            </div>
            <div>
                <input type="password" name="password" id="password" class="password" placeholder="输入密码" oncontextmenu="return false" onpaste="return false">
            </div>
            <div>
                <input type="password" name="confirm_password" id="confirm_password" class="confirm_password" placeholder="再次输入密码" oncontextmenu="return false" onpaste="return false">
            </div>
            <div>
                <input type="text" name="phone_number" id="number" class="phone_number" placeholder="输入手机号码" autocomplete="off" id="number">
            </div>
            <%--<div>--%>
                <%--<input type="email" name="email" class="email" placeholder="输入邮箱地址" oncontextmenu="return false" onpaste="return false">--%>
            <%--</div>--%>
            <button id="submit" type="button">注 册</button>
        </form>
        <a href="login">
            <button type="button" class="register-tis">已经有账号？</button>
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
                var registerInfo = $("#registerForm").serialize();
                $.ajax({
                    url:"${path}/register",
                    type:"post",
                    data:registerInfo,
                    success:function (e) {
                        if (e == "1"){
                            alert("注册成功！");
                            window.location.href="${path}/login"
                        }
                        if (e == "2"){
                            alert("注册失败！");
                        }
                        if (e == "3"){
                            alert("两次密码输入不一致！");
                        }
                        if (e == "4"){
                            alert("用户已存在！");
                        }
                        if (e == "5"){
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
                <img src="${path}/register_files/1.jpg" style="width: 1368px; left: 0px; top: -70px; height: 861.84px;">
            </a>
        </li>
        <li class="slide-1" style="visibility: visible; opacity: 1;">
            <a target="_blank">
                <img src="${path}/register_files/2.jpg" style="width: 1368px; left: 0px; top: -118px; height: 957.6px;">
            </a>
        </li>
        <li class="slide-2 prevslide" style="visibility: visible; opacity: 1;">
            <a target="_blank">
                <img src="${path}/register_files/3.jpg" style="width: 1368px; height: 861.84px; left: 0px; top: -70px;">
            </a>
        </li>
    </ul>
</body>
</html>
