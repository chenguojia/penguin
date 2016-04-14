<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head></head>
<body>
<div class="views">
    <!-- Your main view, should have "view-main" class-->
    <div class="view view-main">
        <!-- Top Navbar-->
        <div class="navbar login-title">
            <div class="navbar-inner">
                <div class="left"><a href="<c:url value='/new/m/myLimit'/>" class="close-img"><img
                        src="<c:url value='/resources/image/left-arror.png'/>"></a></div>
                <div class="center sliding login-title-word">邮箱验证</div>
            </div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page">
                <!-- Scrollable page content-->
                <div class="page-content">
                    <div>
                        <div class="list-block uploadfile-block comments-margin">
                            <ul>
                                <li class="border-tops">
                                    <div class="item-content">
                                        <div class="item-inners">
                                            <div class="item-title comments-fonts">
                                                <input class="login_input" type="text" name="ownerEmail" id="ownerEmail"
                                                       value="${newMerchantUserModel.ownerEmail}" placeholder="请输入您的邮箱">
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="item-content border-tops border-bottom">
                                    <div class="item-media">
                                    </div>
                                    <div class="item-inners">
                                        <div class="item-title">
                                            <input class="login_input" name="emailVerifyCode" id="emailVerifyCode"
                                                   type="text" placeholder="验证码">
                                            <button class="get_verti-new button button-round" type="button"
                                                    id="getCheckCodeBtn">获取验证码
                                            </button>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <div class="padding-rl15 comments-button">
                            <a class="button  button-big comments-button1 account-button" href="#" id="submitBtn">提交</a>
                        </div>
                        <div class="padding-rl15 margin-t15 email-font1">
                            <span>提示：当您输入完邮箱点击获取验证码以后，请进入您的邮箱将收到验证码输入到当前界面验证码中，点击提交即可完成邮箱验证 ！</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script>

        var myApp = new Framework7({
            modalTitle: '卡得万利商业保理',
            ajaxLinks: 'a.ajax'
        });


        //获取验证码
        var count = 60;
        $("#getCheckCodeBtn").click(function () {
            if ($("#ownerEmail").val() != "") {
                //验证手机号是否合法
                var reg = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
                if (reg.test($("#ownerEmail").val())) {
                    //成功，发送验证码
                    //获取验证码
                    $("#getCheckCodeBtn").addClass("disabled");
                    $.ajax({
                        type: "POST",
                        url: contextPath + "new/m/emailLimit",
                        data: {"ownerEmail": $("#ownerEmail").val()},
                        success: function (data) {
                            if (data.resultCode != "-1") {
                                //表示生成验证码成功
                                var countdown = setInterval(countDown, 1000);//定时器
                                //倒计时
                                function countDown() {
                                    $("#getCheckCodeBtn").html(count + " s");
                                    if (count == 0) {
                                        $("#getCheckCodeBtn").removeClass("disabled");
                                        $("#getCheckCodeBtn").html("重新发送");
                                        clearInterval(countdown);
                                        count = 60;
                                    }
                                    count--;
                                }
                            } else {
                                myApp.alert(data.resultMsg, '提示');
                            }
                        }
                    });
                } else {
                    myApp.alert('邮箱不合法!', '提示');
                }
            } else {
                myApp.alert('邮箱不能为空!', '提示');
            }
        });

        //提交
        $("#submitBtn").click(function () {

            var reg = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
            if ($("#ownerEmail").val() != "" && !reg.test($("#ownerEmail").val())) {
                myApp.alert('邮箱不合法!', '提示');
                return;
            }

            if ($("#emailVerifyCode").val() == "") {
                myApp.alert('验证码不能为空!', '提示');
                return;
            }

            //验证成功，提交FORM
            myApp.showPreloader('提交中...')
            $.ajax({
                type: "POST",
                url: contextPath + "new/m/emailLimit",
                data: {"ownerEmail": $("#ownerEmail").val(), "emailVerifyCode": $("#emailVerifyCode").val()},
                success: function (data) {
                    if (data.resultCode == "-1") {
                        myApp.hidePreloader();
                        myApp.alert(data.resultMsg, '提示');
                    } else {
                        myApp.hidePreloader();
                        myApp.alert("验证成功!", '提示', function () {
                            //成功,跳转主控界面
                            location.href = contextPath + "new/m/myLimit";
                        });
                    }
                }
            });

        });

    </script>

</body>
</html>
