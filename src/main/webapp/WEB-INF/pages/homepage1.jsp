<%--
  Created by IntelliJ IDEA.
  User: 22321
  Date: 2018/12/21
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/Path.jsp"%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>普通用户信息管理主页</title>--%>
<%--</head>--%>
<%--<body>--%>
    <%--<h1>普通用户信息管理主页</h1>--%>
<%--</body>--%>
<%--</html>--%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>个人中心</title>
    <link rel="stylesheet" type="text/css" href="${path}/homepage_css/index.css"/>
</head>
<body>
<div class="con">
    <div class="head">
        <h1>很高兴见到你<span>${username}</span></h1>
    </div>

    <div class="main">
        <div class="left">
            <dl>
                <dt>用户中心</dt>
                <dd id="products">商品列表</dd>
                <dd id="personal">个人中心</dd>
            </dl>
            <dl>
                <dt>关于我们</dt>
                <dd id="user_feedback">用户反馈</dd>
                <dd id="exit">退出</dd>
            </dl>
        </div>

        <div class="right">

            <div class="right_item indent_up" id="products_con">
                <div class="right_title">
                    <span>商品列表</span>

                </div>
                <div class="right_con">
                    <table id="products_tb">
                        <thead>
                            <tr>
                                <th>商品名</th>
                                <th>单价</th>
                                <th>图片</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>1</td>
                                <td>1</td>
                                <td>1</td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>2</td>
                                <td>2</td>
                                <td>2</td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>2</td>
                                <td>2</td>
                                <td>3</td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>2</td>
                                <td>2</td>
                                <td>4</td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>2</td>
                                <td>2</td>
                                <td>5</td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>2</td>
                                <td>2</td>
                                <td>6</td>
                            </tr>
                        </tbody>
                    </table>

                    <div class="fen_ye">

                    </div>

                    <div class="search">

                    </div>


                </div>

            </div>

            <div class="right_item indent_down" id="personal_con">
                <div class="right_title">
                    <span>个人中心</span>
                </div>
                <div class="right_con">
                    <form class="user_info_fm">
                        <input type="hidden" value="${user.id}" name="user_id" id="user_id">
                        <table id="user_table">
                            <tr>
                                <td>用户名:</td>
                                <td><input type="text" value="${user.username}" name="username" id="username" readonly="readonly"></td>
                            </tr>
                            <tr>
                                <td>密码:</td>
                                <td><input type="password" value="${user.password}" name="password" id="password" readonly="readonly"></td>
                                <td class="check_password check_password_hidden" id="check_password">验证密码：</td>
                                <td class="check_password check_password_hidden" id="check_password_input"><input type="password" value="${user.password}" name="passwords" id="passwords"></td>
                            </tr>
                            <tr>
                                <td>tele:</td>
                                <td><input type="text" value="${user.tele}" name="tele" id="tele" placeholder="未添加" readonly="readonly"></td>
                            </tr>
                        </table>
                        <div class="opt">
                            <button type="button" id="update">修改资料</button>
                            <button type="button" id="update_true" disabled="disabled">保存资料</button>
                        </div>

                    </form>
                </div>

            </div>


            <div class="right_item indent_down" id="user_feedback_con">
                <div class="right_title">
                    <span>用户反馈</span>
                </div>
                <div class="right_con">

                </div>
            </div>

        </div>
    </div>

    <div class="foot">
        <span>2018年12月23日--</span>
        <span>尤同斌</span>
    </div>


</div>

<script src="${path}/js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${path}/js/homepage.js"></script>

</body>
</html>
