$(function(){
    /**
     * 左侧下拉菜单
     */
    $("dl dt").click(function(){
        $(this).siblings().toggle().parent().siblings().children("dd").hide();
    });

    /**
     * 退出
     */
    $("#exit").click(function () {
        $.ajax({
            url:"exit",
            type:"get",
            success:function (e) {
                if (e == "exit"){
                    window.location.href = "login";
                }
            }
        });
    });


    /**
     * 左右关联菜单
     */

    //商品列表
    $("#products").click(function () {
        $("#products_con").addClass("indent_up").removeClass("indent_down").siblings("div").addClass("indent_down").removeClass("indent_up");
    });

    //个人中心
    $("#personal").click(function () {
        $("#personal_con").addClass("indent_up").removeClass("indent_down").siblings("div").addClass("indent_down").removeClass("indent_up");
    });

    //商品管理
    $("#product_manager").click(function () {
        $("#product_manager_con").addClass("indent_up").removeClass("indent_down").siblings("div").addClass("indent_down").removeClass("indent_up");
    });

    //修改商品信息
    $("#update_product").click(function () {
        $("#update_product_con").addClass("indent_up").removeClass("indent_down").siblings("div").addClass("indent_down").removeClass("indent_up");
    });

    //品牌管理
    $("#brand_manager").click(function () {
        $("#brand_manager_con").addClass("indent_up").removeClass("indent_down").siblings("div").addClass("indent_down").removeClass("indent_up");
    });


    //授权管理
    $("#power").click(function () {
        $("#power_con").addClass("indent_up").removeClass("indent_down").siblings("div").addClass("indent_down").removeClass("indent_up");
    });

    //用户反馈
    $("#user_feedback").click(function () {
        $("#user_feedback_con").addClass("indent_up").removeClass("indent_down").siblings("div").addClass("indent_down").removeClass("indent_up");
    });

    /**
     * 释放input控件
     */
    $("#update").click(function () {
        $("#check_password").removeClass("check_password_hidden");
        $("#check_password_input").removeClass("check_password_hidden");
        $("#update_true").removeAttr("disabled");
        $("#username").removeAttr("readonly");
        $("#password").removeAttr("readonly");
        $("#tele").removeAttr("readonly");
    });

    /**
     * 修改个人信息
     */
    $("#update_true").click(function () {
        var user_info_fm = $(".user_info_fm").serialize();
        $.ajax({
           url:"update_personal_info",
           type:"post",
           data:user_info_fm,
           success:function (e) {
               if (e == "homepage1" || e == "homepage2" || e == "homepage3"){
                   alert("修改成功");
                   window.location.href = e;
               }
               if (e == "2"){
                   alert("修改失败");
               }
               if (e == "3"){
                   alert("密码验证错误");
               }
               if (e == "4"){
                   alert("用户名已存在")
               }
               if (e == "5"){
                   alert("用户名或密码输入为空")
               }
           }
        });
    });

    /**
     * 商品管理
     */
    // $(".upt_pro_btn").click(function () {
    //     var id = $(".product_id").val();
    //     alert(id)
    //     $.ajax({
    //         url:"update",
    //         type:"get",
    //         data:id,
    //         success:function (e) {
    //             $(".update_product").show();
    //         }
    //
    //     });
    //
    //
    // });



});