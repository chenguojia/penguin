<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head></head>
<body>
<div class="views">
    <!-- Your main view, should have "view-main" class-->
    <div class="view view-main">
        <!-- Top Navbar-->
        <div class="navbar login-title">
            <div class="navbar-inner">
                <div class="left"><a href="<c:url value='/new/m/applyStatus/show'/>" class="close-img"><img src="<c:url value='/resources/image/left-arror.png'/>"></a></div>
                <div class="center sliding login-title-word">融资确认</div>
            </div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page">
                <!-- Scrollable page content-->
                <div class="page-content">
                    <div>
                        <div class="fc-title">卡得万利商业保理有限公司<br/>商业保理确认书</div>
                        <%--动态遍历--%>
                        <c:forEach var="item" items="${confirmlists}">
                            <div class="content-block-title">${item.title}</div>
                            <div class="list-block uploadfile-block">
                                <ul>
                                    <c:forEach var="childItem" items="${item.items}">
                                        <li>
                                            <div class="item-content">
                                                <div class="item-inner">
                                                    <div class="item-title label">${childItem.title}：</div>
                                                    <div class="item-input">
                                                        <span>${childItem.value}</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </c:forEach>

                        <div class="padding-rl15 margin-b10">
                           <%-- <input type="Checkbox" name="rdoA" value="0" checked="checked" id="agree-terms" />
                            <span class="checkbox_check">
                                <label for="agree-terms">同意</label>
                                <a class="open-popup" data-popup=".popup-selectCity" href="#" onClick="popClose()">应收账款转让登记协议</a>
                            </span>--%>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="toolbar tabbar tabbar-labels">
            <div class="toolbar-inner">
                <button class="button button-big account-button" href="#" id="submitBtn">确认</button>
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
<div class="popup popup-selectCity">
    <%--<p class="padding-rl15">--%>
        <%--<a href="#" class="close-popup">返回</a>--%>
    <%--</p>--%>
    <div class="page-content contacts-content register-padding">
        <jsp:include page="/new/m/clause/affirmLoansClause"/>
    </div>
</div>
    <%--协议关闭按钮--%>
    <div class="close-display display-none">
        <div class="close-line-height"></div>
        <a href="#" class="close-popup padding-l10" onClick="$('.close-display').addClass('display-none')">返回</a>
    </div>






    <script>
    var myApp = new Framework7({
        modalTitle: '卡得万利商业保理',
        ajaxLinks: 'a.ajax'
    });

    //同意条款
    $("#agree-terms").change(function () {
        if ($(this).is(":checked")) {
            $(".toolbar-btn").removeClass("disabled");
        } else {
            $(".toolbar-btn").addClass("disabled");
        }
    })

    $('#submitBtn').click(function(){
        $.getJSON(contextPath + "code/getCodeCRM", {mobile: ${newMerchantUserModel.mobilePhone} }, function (result) {
            $("#changeCode").attr("src",result.imgUrl);
            $('.check-code-back').removeClass('displaynone');
        });
    });

//    $('.check-code-back').addClass('displaynone');
//
//    $("#getCheckCodeBtn").addClass("disabled");

    $('#check-code-cancel').click(function(){
        $('.check-code-back').addClass('displaynone');
    });

    $("#changeCode").click(function() {
        var timestamp = (new Date()).valueOf();
       /* var url = contextPath + "code/getCode?timestamp=" + timestamp;
        $(this).attr("src",url);*/
        $.getJSON(contextPath + "code/getCodeCRM?timestamp="+ timestamp, {mobile: ${newMerchantUserModel.mobilePhone}}, function (res) {
            if(res==null || res.imgUrl==null || res.imgUrl == ''){
                myApp.alert('验证码获取失败，请点击图标重新获取!', '提示');
            }
            $("#changeCode").attr("src",res.imgUrl);
        });
    });


    $("#check-code-confirm").click(function(){

        var code = $("#getCode").val();

        if (code == "") {
            myApp.alert('请输入图片上的验证码!', '提示');
            return;
        }

        $('.check-code-back').addClass('displaynone');
        $("#getCode").val("");
        $.getJSON(contextPath + "new/m/getCheckCode", {mobile:${newMerchantUserModel.mobilePhone},code:code}, function (data) {
            if (data == "1") {
                myApp.prompt('提示：如未收到验证码点击取消,重新点击确认即可!','输入手机验证码完成确认', function (value) {
                    if (value == "")  {
                        myApp.alert("手机验证码不能为空!",'提示');
                        return;
                    }
                    myApp.showPreloader('处理中...');
                    $.ajax({
                        type: "POST",
                        url: contextPath + "new/m/affirmLoans",
                        data: {"isOk": "1","reson": "","checkCode":value},
                        success: function (data) {
                            if (data.resultCode == "-1") {
                                myApp.hidePreloader();
                                myApp.alert(data.resultMsg,'提示');
                            } else {
                                //成功,跳转主控界面
                                location.href = contextPath + "new/m/uploadFile/show?isView=1";
                            }
                        }
                    });
                });
            } else if(data=="0"){
                myApp.alert("图片验证码输入有误，请重新输入!", '提示');
            }else if(data == "103"){
                myApp.alert("验证码错误次数已达3次，请重新获取验证码", '提示');
                $("#getCode").val("");
                $("#getCheckCodeBtn").removeClass("disabled");
                $("#getCheckCodeBtn").html("获取验证码");
            }else{
                myApp.alert("验证码生成异常，请重新获取!", '提示');
            }
        });


//        if ($(this).html() == "确认") {




//        } else {
//            myApp.prompt('请输入放弃理由!', function (value) {
//                myApp.showPreloader('处理中...');
//                $.ajax({
//                    type: "POST",
//                    url: contextPath + "new/m/affirmLoans",
//                    data: {"isOk": "0","reson": value},
//                    success: function (data) {
//                        if (data.resultCode == "-1") {
//                            myApp.hidePreloader();
//                            myApp.alert(data.resultMsg,'提示');
//                        } else {
//                            //成功,跳转主控界面
//                            location.href = contextPath + "new/m/applyStatus/show";
//                        }
//                    }
//                });
//            });
//        }
    });

</script>

</body>
</html>
