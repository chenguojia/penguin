<%--
  Created by IntelliJ IDEA.
  User: guojia.chen
  Date: 2016/1/8
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--银行begin--%>
<div class="check-code-back2 displaynone">
    <div class="check-code-content">
        <div class="float_l check-codes1">
            <%--<img id="changeCode" src="<c:url value="/code/getCode"/>">--%>
            <img id="changeCode" src="<c:url value="#"/>">
        </div>
        <div class="float_l check-codes1 bankBind-part11">
            <div class="bankBind-part1"></div>
            <input class="check-code-input" id="getCode" placeholder="请输入图片验证码">
        </div>
        <div class="check-code-but">
            <button class="check-code-but1" id="check-code-cancel">取消</button>
            <button class="check-code-but1 check-code-but2" id="check-code-confirm">确定</button>
        </div>
    </div>
</div>

<div class="views" id="bindBankShow" style="display: none; margin-top: -105px;">
    <!-- Your main view, should have "view-main" class-->
    <div class="view view-main">
        <!-- Top Navbar-->
        <div class="navbar login-title">
            <div class="navbar-inner">
                <div class="left" id="address-back"><a href="#" class="close-img"><img
                        src="<c:url value='/resources/image/left-arror.png'/>"></a></div>
                <div class="center sliding login-title-word">
                    <div class="input-group gps-toper bankBind-part22">
                        <div class="bankBind-part2"></div>
                        <div class="input-group-addon gps-searcher">
                            <img src="<c:url value='/resources/image/gpsSearch.png'/>">
                        </div>
                        <input name="bankType" type="hidden" id="bankType" value="${applicationModel.type}">
                        <input class="form-control" name="kaihuBank" id="kaihuBank" placeholder="请输入开户银行"  onkeyup="queryBanks();" type="text">
                    </div>
                </div>
                <div class="right">
                    <button class="button gps-search-button">搜索</button>
                </div>
            </div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page">
                <!-- Scrollable page content-->
                <div class="page-content">
                    <div class="list-block media-list myaccount gps-pages">
                        <ul class="float_clear margin-t12 " id="ulliBank">

                        </ul>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<%--银行end--%>

            <div class="page-content bank-bind" id="bindBank" style="margin-top: 105px;">
                <div class="bind-part2 part2-notop">
                    <form method="post" id="bankBindForm">
                        <div class="content-block login-new">
                        <div class="list-block register-home">
                            <input type="hidden" value="${applicationModel.secondaryBankAccountType}" id="secondaryBankAccountType1">
                            <c:if test="${applicationModel.secondaryBankAccountType=='对公'}">
                                <div class="padding-b5" style="font-size: 13px; padding-left:15px;">放款账户信息(对公)</div>
                                <input name="isWithdrawConfirm" type="hidden" value="${applicationModel.isWithdrawConfirm}">
                                <ul>
                                <li class="item-content border-bottom border-tops">
                                    <div class="item-media">
                                        <span class="icon username_icon pinCode3"><img
                                                src="<c:url value="/resources/image/cards.png"/>"></span>
                                    </div>
                                    <div class="item-inners">
                                        <div class="item-title">
                                            <div class="basic-limit-part4"></div>
                                            <input class="login_input" name="secondaryBankAcctName" type="text"  placeholder="账户名" value="${newMerchantUserModel.ownerName}">
                                        </div>
                                    </div>
                                </li>

                                <li>
                                    <div class="item-link item-content border-bottom open-account">
                                        <div class="item-media">
                                            <span class="icon username_icon pinCode3"><img
                                                    src="<c:url value="/resources/image/cards.png"/>"></span>
                                        </div>
                                        <div class="item-inners">
                                            <div class="item-title item-title-row bank-bind2 bankBind-part33">
                                                <%--放款账户名称--%>
                                                <div class="bankBind-part3"></div>
                                                <input class="login_input bankName" id="bankName1" name="secondaryBankName" value="${(applicationModel.secondaryBankName==''||applicationModel.secondaryBankName==null) ? sessionScope.sessionApplication.secondaryBankName : applicationModel.secondaryBankName}" type="text" placeholder="开户银行">
                                                    <input type="hidden" name="secondaryBankABA" id="directDebitBankCode1" value="${(applicationModel.secondaryBankABA==''|| applicationModel.secondaryBankABA == null) ? sessionScope.sessionApplication.secondaryBankABA : applicationModel.secondaryBankABA}">
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="item-content border-bottom">
                                    <div class="item-media">
                                        <span class="icon username_icon"><img
                                                src="<c:url value="/resources/image/user.png"/>"></span>
                                    </div>
                                    <div class="item-inners">
                                        <div class="item-title bankBind-part44">
                                            <%--放款银行卡号--%>
                                            <div class="bankBind-part4"></div>
                                            <input class="login_input" name="secondaryBankDDA" type="text" value="${(applicationModel.secondaryBankDDA==''|| applicationModel.secondaryBankDDA == null) ? sessionScope.sessionApplication.secondaryBankDDA : applicationModel.secondaryBankDDA}" placeholder="放款银行卡号" id="applicationBank-account">
                                        </div>
                                    </div>
                                </li>
                            </ul>
                            </c:if>
                            <div style="font-size: 13px; padding: 10px 15px;">放款账户和还款账户必须保持一致</div>
                            <%--<ul class="register-home-part2">--%>
                            <ul class="#">
                                <li class="item-content border-bottom border-tops">
                                    <div class="item-media">
                                        <span class="icon username_icon"><img
                                                src="<c:url value="/resources/image/user.png"/>"></span>
                                    </div>
                                    <div class="item-inners">
                                        <div class="item-title">
                                            <div class="basic-limit-part4"></div>
                                            <input class="login_input" type="text" placeholder="账户名" name="directDebitAcctName"  value="${newMerchantUserModel.ownerName}">
                                        </div>
                                    </div>
                                </li>

                                <li class="item-content border-bottom">
                                    <div class="item-media">
                                        <span class="icon username_icon"><img
                                                src="<c:url value="/resources/image/user.png"/>"></span>
                                    </div>
                                    <div class="item-inners">
                                        <div class="item-title">
                                            <div class="basic-limit-part4"></div>
                                            <%--还款账户身份证--%>
                                            <input class="login_input" type="text" placeholder="身份证" name="directDebitAcctId" value="${applicationModel.directDebitAcctId}">
                                        </div>
                                    </div>
                                </li>

                                <li>
                                    <div class="item-link item-content border-bottom open-account">
                                        <div class="item-media">
                                            <span class="icon username_icon"><img src="<c:url value="/resources/image/card.png"/>"></span>
                                        </div>
                                        <div class="item-inners">
                                            <div class="item-title item-title-row bank-bind2">
                                                <%--还款账户名称--%>
                                                <%--<div class="bankBind-part5"></div>--%>
                                                <input class="login_input bankName" id="bankName2" name="directDebitBankName" value="${(applicationModel.directDebitBankName==''|| applicationModel.directDebitBankName == null) ? sessionScope.sessionApplication.directDebitBankName : applicationModel.directDebitBankName}" type="text" placeholder="开户银行">

                                                <%--还款银行行号--%>
                                                <input type="hidden" name="directDebitBankCode" id="directDebitBankCode2" value="${(applicationModel.directDebitBankCode==''|| applicationModel.directDebitBankCode == null) ? sessionScope.sessionApplication.directDebitBankCode : applicationModel.directDebitBankCode}">
                                            </div>
                                        </div>
                                    </div>
                                </li>

                                <li class="item-content border-bottom">
                                    <div class="item-media">
                                        <span class="icon username_icon"><img
                                                src="<c:url value="/resources/image/card.png"/>"></span>
                                    </div>
                                    <div class="item-inners">
                                        <div class="item-title bankBind-part66">
                                            <%--还款银行卡号--%>
                                            <div class="bankBind-part6"></div>
                                            <input class="login_input" type="text"  name="directDebitAcctNo" value="${(applicationModel.directDebitAcctNo==''|| applicationModel.directDebitAcctNo == null) ? sessionScope.sessionApplication.directDebitAcctNo : applicationModel.directDebitAcctNo}" placeholder="银行账号" id="directDebitAcctNo">
                                        </div>
                                    </div>
                                </li>
                                <li class="item-content border-bottom">
                                    <div class="item-media">
                                        <span class="icon username_icon pinCode2"><img
                                                src="<c:url value="/resources/image/phoneCode.png"/>"></span>
                                    </div>
                                    <div class="item-inners">
                                        <div class="item-title login_input2 bankBind-part77">
                                            <div class="bankBind-part7" style="z-index: 99;"></div>
                                            <input class="login_input" type="text" id="directDebitAcctPhone" name="directDebitAcctPhone" value="${(applicationModel.directDebitAcctPhone==''|| applicationModel.directDebitAcctPhone == null) ? sessionScope.sessionApplication.directDebitAcctPhone : applicationModel.directDebitAcctPhone}" placeholder="银行预留手机号">
                                            <button class="get_verti-new button button-round"   type="button" id="getCheckCodeBtn" style="z-index: 999;">获取验证码
                                            </button>
                                        </div>
                                    </div>
                                </li>
                                <li class="item-content border-bottom">
                                    <div class="item-media">
                                        <span class="icon username_icon"><img
                                                src="<c:url value="/resources/image/pinCode.png"/> "></span>
                                    </div>
                                    <div class="item-inners">
                                        <div class="item-title bankBind-part88">
                                            <div class="bankBind-part8"></div>
                                            <input class="login_input" id="mobilePhoneVerifyCode" name="mobilePhoneVerifyCode" type="text" placeholder="输入验证码">
                                        </div>
                                    </div>
                                </li>

                            </ul>
                        </div>
                    </div>
                    </form>
                    <div class="padding-rl15 margin-t-5">
                        <div class="bind-font1">
                           <div class="float_l bank-bind-font1">
                               <input type="checkbox" name="agree" id="agree-bindBank" checked/>
                           </div>
                            <div class="float_l bank-bind-font2">
                                同意<span class="bind-font2 rongzixieyi">融资协议</span>
                            </div>
                        </div>
                        <div class="float_clear bind-number-new2">
                            <a class="button button-big button-fill apply-button" href="#" id="bindBandClick">绑定</a>
                        </div>
                    </div>
                    <div class="float_clear height20 margin-t20"></div>
                </div>
                <input id="bankClickId" value="1" type="hidden">
            </div>

        <%--</div>--%>
    <%--</div>--%>

<%--</div>--%>
<%--</div>--%>

<script type="text/javascript">


    $('#getCheckCodeBtn').click(function () {

        if ($("#directDebitAcctPhone").val() == "") {
            myApp.alert('手机号码不能为空!', '提示');
            return;
        } else {

            $.getJSON(contextPath + "code/getCodeCRM", {mobile: $("#directDebitAcctPhone").val()}, function (result) {
//                alert($("#directDebitAcctPhone").val());
                $("#changeCode").attr("src", result.imgUrl);
                $('.check-code-back2').removeClass('displaynone');
            });
        }

    });

    $('#check-code-confirm').click(function () {
        var code = $("#getCode").val();
        if (code == "") {
            myApp.alert('请输入图片上的验证码!', '提示');
            return;
        }
        $('.check-code-back2').addClass('displaynone');

        //获取验证码
        var count = 60;
        if ($("#directDebitAcctPhone").val() != "") {
            //验证手机号是否合法
            var reg = /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
            if (reg.test($("#directDebitAcctPhone").val())) {
                //成功，发送验证码
                //获取验证码
                $("#getCheckCodeBtn").addClass("disabled");
                $.getJSON(contextPath + "new/m/getCheckCode", {
                    mobile: $("#directDebitAcctPhone").val(),
                    code: code
                }, function (data) {
                    if (data == "1") {
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
                    } else if (data == "-100") {
                        myApp.alert("请勿频繁获取验证码，请在24之后重试！", '提示');
                    } else if (data == "0") {
                        myApp.alert("验证码错误，请重新输入！", '提示');
                        $("#getCode").val("");
                        $("#getCheckCodeBtn").removeClass("disabled");
                        $("#getCheckCodeBtn").html("获取验证码");
                    } else if (data == "103") {
                        myApp.alert("验证码错误次数已达3次，请重新获取验证码", '提示');
                        $("#getCode").val("");
                        $("#getCheckCodeBtn").removeClass("disabled");
                        $("#getCheckCodeBtn").html("获取验证码");
                    } else {
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
    $('#check-code-cancel').click(function () {
        $('.check-code-back2').addClass('displaynone');
    });

    $("#changeCode").click(function () {
        var timestamp = (new Date()).valueOf();
        $.getJSON(contextPath + "code/getCodeCRM?timestamp=" + timestamp, {mobile: $("#directDebitAcctPhone").val()}, function (res) {
            if (res == null || res.imgUrl == null || res.imgUrl == '') {
                myApp.alert('验证码获取失败，请点击图标重新获取!', '提示');
            }
            $("#changeCode").attr("src", res.imgUrl);
        });
    });



    $(".rongzixieyi").click(function(){
        //当查看融资协议时，异步保存页面数据
        $.ajax({
            type: "POST",
            url: contextPath + "regular/bindBankCard/session",
            data: $('#bankBindForm').serialize(),
            success: function (data) {

            }
        });

       location.href="<c:url value="/regular/bindBankCard?isApp=1"/>";
    });

    //同意条款
    $("#agree-bindBank").change(function () {
        if ($(this).is(":checked")) {
            $("#bindBandClick").removeClass("disabled");
        } else {
            $("#bindBandClick").addClass("disabled");
        }
    });


    $("#bindBandClick").click(function(){


        var BankAccountType = $("#secondaryBankAccountType1").val();
        if(BankAccountType=='对公'){
            var secondaryBankName = $("input[name=secondaryBankName]").val();
            if(secondaryBankName==''){
                myApp.alert("请输入开户银行","提示");
                return false;
            }
            if( $("input[name=secondaryBankDDA]").val()==''){
                myApp.alert("请输入放款银行卡号","提示");
                return false;
            }
        }

        var bankName2 = $("#bankName2").val();
        if(bankName2==''){
            myApp.alert("请输入开户银行","提示");
            return false;
        }

        var directDebitAcctNo = $("input[name=directDebitAcctNo]").val();
        if(directDebitAcctNo==''){
            myApp.alert("还款银行账号","提示");
            return false;
        }

        var directDebitAcctPhone = $("#directDebitAcctPhone").val();
        if(directDebitAcctNo==''){
            myApp.alert("银行预留手机号码不能为空","提示");
            return false;
        }
        var mobilePhoneVerifyCode = $("#mobilePhoneVerifyCode").val();
        if(mobilePhoneVerifyCode==''){
            myApp.alert("请输入手机验证码","提示");
            return false;
        }

        myApp.showPreloader('提交中...')
        $.ajax({
            type: "POST",
            url: contextPath + "info/bankBinding",
            data: $('#bankBindForm').serialize(),
            success: function (data) {
                myApp.hidePreloader();
                myApp.alert(data.message,"提示",function(){
                    if (data.code == 1) location.href='<c:url value="/new/m/home"/>';
                });
            },
            error:function(){
                myApp.alert("银行卡绑定失败!","提示");
            }
        });
    });


    $(function(){
        var bankAccountType = $("#secondaryBankAccountType1").val();

        $("#bankName1").click(function(){
            $("#bankClickId").val("1");
        });
        $("#bankName2").click(function(){
            $("#bankClickId").val("2");
        });

        if(bankAccountType=='对公'){
            $("#bankName1").click(function(){
                $("#bankType").val("1");
            });
            $("#bankName2").click(function(){
                $("#bankType").val("2");
            });
        }else{
            $("#bankName2").click(function(){
                $("#bankType").val("3");
            });
        }

    });

    $(".bankName").click(function(){
        $("#bindBankShow").show();
        $("#bindBank").hide();

        if ($(this).val() != "" && $(this).val().length > 0) {
            //赋值给输入框
            $("#kaihuBank").val($(this).val());
            queryBanks()
        }
    });

    $(".left").click(function(){
        $("#bindBank").show();
        $("#bindBankShow").hide();
    });

    //    查询地址，去头部
    $('.open-account').click(function () {
        $('#address-displaynone').hide();
        $('.slider-page1-content').css('margin-top', '0')
    });
    //    返回页面，加头部
    $('.close-img').click(function () {
        $('#address-displaynone').show();
        $('.slider-page1-content').css('margin-top', '105px')
    });


    $('.bind-button-font1').click(function () {
        $('.bind-part2').addClass('displaynone');
        $('.bind-part1').removeClass('displaynone');
        $('.bind-button-font1').addClass('button-active');
        $('.bind-button-font2').removeClass('button-active');
    });
    $('.bind-button-font2').click(function () {
        $('.bind-part1').addClass('displaynone');
        $('.bind-part2').removeClass('displaynone');
        $('.bind-button-font2').addClass('button-active');
        $('.bind-button-font1').removeClass('button-active');
    });

    $("body").delegate(".border-bottom a", "click", function () {
//        $("#bankName1").removeAttr("disabled");
        var bankId = $(this).children().find(".bankId").val();
        var bankName =  $(this).children().find(".bank-bind-name").text();

        var num  = $("#bankClickId").val();

        if(num=='1'){
            var csdd = $("#bankName1").val(bankName);
//            alert(bankName);
            $("#directDebitBankCode1").val(bankId);
        }
        if(num == '2'){
            $("#bankName2").val(bankName);
            $("#directDebitBankCode2").val(bankId);
        }
        //返回加页头
        $('#bindBank').show();
        $("#bindBankShow").hide();
        $('.slider-page1-content').css('margin-top', '105px')

    });

    function putHtml(data) {
        var placeHtml = "";
        for (var i = 0; i < data.resultData.length; i++) {

            placeHtml += "<li class='border-bottom'>";
            placeHtml += "<a href='#' class='item-link item-content more-main gps-content'>";
            placeHtml += "<div class='item-media username_icon'><img src='<c:url value="/resources/image/gpsPosition.png"/>'></div>";
            placeHtml += "<div class='item-inners'>";
            placeHtml += "<div class='item-title-row-gps'>";
            placeHtml += "<div class='bank-bind-name'>" + data.resultData[i].title + "</div>";
            placeHtml += "<input type='hidden' class='bankId' value='" + data.resultData[i].id + "'>";
            placeHtml += "</div>";
            placeHtml += "</div>";
            placeHtml += "</a>";
            placeHtml += "</li>";
        }
        $("#ulliBank").html(placeHtml);
    }



    function queryBanks(){
        var bankType = $("#bankType").val();
        if(bankType==""){
            bankType = 2;
        }
        var kaihuBank = $("#kaihuBank").val();

        $.ajax({
            type: "POST",
            url: contextPath + "check/queryBanks",
            data: {type:bankType,bankName:kaihuBank},
            success: function (data) {
//                if(data!=null &&  data.resultData!=null && data.resultData.length>0){
                    putHtml(data);
//                }
            }
        });
    }

    $('.bankBind-part11').click(function(){
        $('.bankBind-part1').addClass('displaynone');
        $('#getCode').focus();
    });
    $('.bankBind-part22').click(function(){
        $('.bankBind-part2').addClass('displaynone');
        $('#kaihuBank').focus();
    });
    $('.bankBind-part33').click(function(){
        $('.bankBind-part3').addClass('displaynone');
        $('#bankName1').focus();
    });
    $('.bankBind-part44').click(function(){
        $('.bankBind-part4').addClass('displaynone');
        $('#applicationBank-account').focus();
    });
//    $('.bankBind-part55').click(function(){
//        $('.bankBind-part5').addClass('displaynone');
//        $('#bankName2').focus();
//    });
    $('.bankBind-part66').click(function(){
        $('.bankBind-part6').addClass('displaynone');
        $('#directDebitAcctNo').focus();
    });
    $('.bankBind-part7').click(function(){
        $(this).addClass('displaynone');
        $('#directDebitAcctPhone').focus();
    });
    $('.bankBind-part88').click(function(){
        $('.bankBind-part8').addClass('displaynone');
        $('#mobilePhoneVerifyCode').focus();
    });

    $('input').blur(function(){
        $('.bankBind-part1').removeClass('displaynone');
        $('.bankBind-part2').removeClass('displaynone');
        $('.bankBind-part3').removeClass('displaynone');
        $('.bankBind-part4').removeClass('displaynone');
//        $('.bankBind-part5').removeClass('displaynone');
        $('.bankBind-part6').removeClass('displaynone');
        $('.bankBind-part7').removeClass('displaynone');
        $('.bankBind-part8').removeClass('displaynone');
    });

</script>
