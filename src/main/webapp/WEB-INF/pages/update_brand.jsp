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
    <title>修改品牌信息</title>
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
                <dt>修改品牌</dt>
                <dd id="update_brand">修改品牌</dd>
                <dd id="goback"><a href="goback">返回主页</a></dd>
            </dl>
            <dl>
                <dt>关于我们</dt>
                <dd id="user_feedback">用户反馈</dd>
                <dd id="exit">退出</dd>
            </dl>
        </div>

        <div class="right">

            <div class="right_item indent_up" id="update_product_con">
                <div class="right_title">
                    <span>修改品牌</span>

                </div>
                <div class="right_con">
                    <%--修改品牌信息--%>
                    <div class="update_brand">
                        <div class="upb_tit"><p>修改品牌信息</p></div>
                        <form action="doUpdateBrand" method="get" class="update_brand_fm" id="update_brand_fm">
                            <table class="update_brand_tb">
                                <tr>
                                    <td>品牌ID</td>
                                    <td><input type="text" name="id" id="id" value="${brand.id}" readonly="readonly"></td>
                                </tr>
                                <tr>
                                    <td>品牌名称</td>
                                    <td><input type="text" name="brand_name" id="brand_name" placeholder="${brand.brandName}" value="${brand.brandName}"></td>
                                </tr>





                                <%--<tr>--%>
                                    <%--<td>删除对应商品</td>--%>
                                    <%--<td>--%>
                                        <%--<label>&nbsp;&nbsp;&nbsp;&nbsp;是<input type="radio" name="delete_products" style="width: 80px;height: 15px" value="yes"/></label>--%>
                                        <%--<label>&nbsp;&nbsp;&nbsp;&nbsp;否<input type="radio" name="delete_products" style="width: 80px;height: 15px" value="no"/></label>--%>
                                    <%--</td>--%>
                                <%--</tr>--%>

                            </table>
                            <button type="submit" name="submit">提交</button>
                        </form>

                    </div>


                </div>

            </div>


            <div class="right_item indent_down" id="update_brand_con">
                <div class="right_title">
                    <span>修改品牌</span>

                </div>
                <div class="right_con">

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
