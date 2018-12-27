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
    <title>授权管理</title>
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
                <dt>权限管理</dt>
                <dd id="power_manager">授权管理</dd>
                <dd id="power_tb">权限列表</dd>
                <dd id="goback"><a href="goback">返回主页</a></dd>
            </dl>
            <dl>
                <dt>关于我们</dt>
                <dd id="user_feedback">用户反馈</dd>
                <dd id="exit">退出</dd>
            </dl>
        </div>

        <div class="right">

            <div class="right_item indent_up" id="power_manager_con">
                <div class="right_title">
                    <span>权限管理</span>

                </div>
                <div class="right_con">

                    <table class="power_manager_tb">
                        <thead>
                        <tr>
                            <th>用户ID</th>
                            <th>用户名称</th>
                            <th>用户权限</th>
                            <th>修改权限</th>
                            <th>删除用户</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${users_roles}" var="ur">
                            <tr>
                                <td>${ur.user.id}</td>
                                <td>${ur.user.username}</td>
                                <td>${ur.roleName}</td>
                                <td><a href="update_power?id=${ur.user.id}"><button>修改</button></a></td>
                                <td><a href="delete_user?id=${ur.user.id}"><button>删除</button></a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>


                </div>

            </div>

            <div class="right_item indent_down" id="power_tb_con">
                <div class="right_title">
                    <span>权限列表</span>
                    <a style="display: inline-block;margin-right: 30px" href="add_role">
                        <button>添加角色权限</button>
                    </a>

                </div>
                <div class="right_con">
                    ${roles}

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
