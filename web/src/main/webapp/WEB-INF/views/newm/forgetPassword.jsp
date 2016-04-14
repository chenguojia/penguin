<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head></head>
<body>
<!-- Views-->
<div class="views">
    <!-- Your main view, should have "view-main" class-->
    <div class="view view-main">
        <!-- Top Navbar-->
        <div class="navbar login-title">
            <div class="navbar-inner">
                <div class="left"><a href="<c:url value='/new/m/userInfo/show'/>" class="close-img"><img src="<c:url value="/resources/image/left-arror.png"/>"> </a></div>
                <div class="center sliding login-title-word">忘记密码</div>
            </div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
            <!-- Page, data-page contains page name-->
            <div data-page="login" class="page">

                <!-- Scrollable page content-->
                <div class="page-content">
                    <div class="content-block login-new">
                        <div class="list-block register-home">
                            <ul>
                                <li class="item-content border-bottom border-tops">
                                    <div class="item-media">
                                        <span class="icon username_icon"><img src="<c:url value="/resources/image/user.png"/>"></span>
                                    </div>
                                    <div class="item-inners">
                                        <div class="item-title">
                                            <input class="login_input" type="text" id="mobile" placeholder="请输入您的手机号">
                                        </div>
                                    </div>
                                </li>
                                <li class="item-content border-bottom">
                                    <div class="item-media">
                                        <span class="icon username_icon pinCode"><img src="<c:url value='/resources/image/key.png'/>"></span>
                                    </div>
                                    <div class="item-inners">
                                        <div class="item-title">
                                            <input class="login_input" type="text" maxlength="4"  id="checkCode" placeholder="请输入验证码">
                                            <button class="get_verti-new button button-round" type="button" id="getCheckCodeBtn" >获取验证码</button>
                                        </div>
                                    </div>
                                </li>
                                <li class="item-content border-bottom">
                                    <div class="item-media">
                                        <span class="icon username_icon"><img src="<c:url value="/resources/image/pinCode.png"/>"></span>
                                    </div>
                                    <div class="item-inners">
                                        <div class="item-title">
                                            <%--<input class="login_input" type="text" placeholder="初始密码">--%>
                                                <input class="login_input" type="password" id="password" placeholder="请输入6-16位新密码">
                                        </div>
                                    </div>
                                </li>
                            </ul>

                        </div>
                    </div>
                    <div class="padding-rl15 margin-t-5">

                        <div class="bind-number-new">
                            <!--检测到没有勾选同意服务条款时，添加class="disabled"-->
                            <a class="button button-big button-fill apply-button" href="#" id="submitBtn">确认</a>
                        </div>
                    </div>
                </div>

                <div class="check-code-back displaynone">
                    <div class="check-code-content">
                        <div class="float_l check-codes1">
                            <%--<img id="changeCode" src="<c:url value="/code/getCode"/>">--%>
                                <img id="changeCode" src="<c:url value="#"/>">
                        </div>
                        <div class="float_l check-codes1">
                            <input class="check-code-input" id="getCode" placeholder="请输入图片验证码">
                        </div>
                        <div class="check-code-but">
                            <button class="check-code-but1" id="check-code-confirm">确定</button>
                            <button class="check-code-but1 check-code-but2" id="check-code-cancel">取消</button>
                        </div>
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

        $('#getCheckCodeBtn').click(function(){
            if ($("#mobile").val() == "") {
                myApp.alert('手机号码不能为空!', '提示');
                return;
            }else{
                $.getJSON(contextPath + "code/getCodeCRM", {mobile: $("#mobile").val()}, function (result) {
                    $("#changeCode").attr("src",result.imgUrl);
                    $('.check-code-back').removeClass('displaynone');
                });
//                $('.check-code-back').removeClass('displaynone');
            }
        });



        $("#check-code-confirm").click(function () {

            var code = $("#getCode").val();

            if (code == "") {
                myApp.alert('请输入图片上的验证码!', '提示');
                return;
            }
            $('.check-code-back').addClass('displaynone');


            //获取验证码
            var count = 60;
            if ($("#mobile").val() != "") {
                //验证手机号是否合法
                var reg = /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
                if (reg.test($("#mobile").val())) {
                    //成功，发送验证码
                    //获取验证码
                    $("#getCheckCodeBtn").addClass("disabled");
                    $.getJSON(contextPath + "new/m/getCheckCode", {mobile: $("#mobile").val(),code:code}, function (data) {
                        if (data == "1") {
                            //表示生成验证码成功
                            var countdown = setInterval(countDown, 1000);//定时器
                            //倒计时
                            function countDown() {
                                $("#getCheckCodeBtn").addClass("disabled");
                                $("#getCheckCodeBtn").html(count + "s");
                                if (count == 0) {
                                    $("#getCheckCodeBtn").removeClass("disabled");
                                    $("#getCheckCodeBtn").html("重新发送");
                                    clearInterval(countdown);
                                    count = 60;
                                }
                                count--;
                            }
                        } else if(data == "-100"){
                            myApp.alert("请勿频繁获取验证码，请在24之后重试！", '提示');
                        }else if(data == "0"){
                            myApp.alert("验证码错误，请重新输入！", '提示');
                            $("#getCode").val("");
                            $("#getCheckCodeBtn").removeClass("disabled");
                            $("#getCheckCodeBtn").html("获取验证码");
                        }else if(data == "103"){
                            myApp.alert("验证码错误次数已达3次，请重新获取验证码", '提示');
                            $("#getCode").val("");
                            $("#getCheckCodeBtn").removeClass("disabled");
                            $("#getCheckCodeBtn").html("获取验证码");
                        }else{
                            myApp.alert("验证码生成异常，请重新获取!", '提示');
                            $("#getCode").val("");
                            $("#getCheckCodeBtn").removeClass("disabled");
                            $("#getCheckCodeBtn").html("获取验证码");
                        }
                    });
                } else {
                    myApp.alert('手机号码不合法!', '提示');
                }
            } else {
                myApp.alert('手机号码不能为空!', '提示');
            }
        });

        $('#check-code-cancel').click(function(){
            $('.check-code-back').addClass('displaynone');
        });

        $("#changeCode").click(function() {
            var timestamp = (new Date()).valueOf();
           /* var url = contextPath + "code/getCode?timestamp=" + timestamp;
            $(this).attr("src",url);*/
            $.getJSON(contextPath + "code/getCodeCRM?timestamp="+ timestamp, {mobile: $("#mobile").val()}, function (res) {
                /*if(res==null || res.imgUrl==null || res.imgUrl == ''){
                    myApp.alert('验证码获取失败，请点击图标重新获取!', '提示');
                }*/
                $("#changeCode").attr("src",res.imgUrl);
            });
        });



        //提交
        $("#submitBtn").click(function () {

            if ($("#mobile").val() == "") {
                myApp.alert('手机号码不能为空!', '提示');
                return;
            }

            var reg = /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
            if (!reg.test($("#mobile").val())) {
                myApp.alert('手机号码不合法!', '提示');
                return;
            }

            if ($("#checkCode").val() == "") {
                myApp.alert('验证码不能为空!', '提示');
                return;
            }

            if ($("#password").val() == "") {
                myApp.alert('初始密码不能为空!', '提示');
                return;
            }

            //验证成功，提交FORM
            $.ajax({
                type: "POST",
                url: contextPath + "new/m/forgetPassword",
                data: {"mobile": $("#mobile").val(), "password": $("#password").val(), "checkCode": $("#checkCode").val()},
                success: function (data) {
                    if (data.resultCode == "-1") {
                        myApp.alert(data.resultMsg,'提示');
                    } else {
                        myApp.alert("恭喜您，密码修改成功!",'提示',function(){
                            location.href = contextPath + "new/m/login/show";
                        });
                    }
                }
            });

        });

</script>

</body>
</body>
</html>
