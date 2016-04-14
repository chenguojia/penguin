<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head></head>
<body>
<div class="views">
    <!--  Your main view, should have "view-main" class-->
    <div class="view view-main">
        <!-- Top Navbar-->
        <div class="navbar login-title">
            <div class="navbar-inner">
                <div class="left"><a href="<c:url value='/new/m/account'/>" class="close-img"><img
                        src="<c:url value="/resources/image/left-arror.png"/>"></a></div>
                <div class="center sliding login-title-word">个人信息</div>
            </div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page">
                <!-- Scrollable page content-->
                <div class="page-content">
                    <div>
                        <div class="list-block">
                            <ul>
                                <li class="border-bottom border-tops">
                                    <div class="item-link ks-generate-page">
                                        <div class="item-content">
                                            <div class="item-inner" style="background: none; padding-right: 15px;">
                                                <div class="item-title">姓名：</div>
                                                <div class="item-title info-color">${!empty login_new_merchant.ownerName ? login_new_merchant.ownerName : '亲爱的用户'}</div>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="border-bottom">
                                    <div class="item-link ks-generate-page">
                                        <div class="item-content">
                                            <div class="item-inner" style="background: none; padding-right: 15px;">
                                                <div class="item-title">手机号：</div>
                                                <div class="item-title info-color">${!empty login_new_merchant.mobilePhone ? login_new_merchant.mobilePhone : '***********'}</div>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="border-bottom">
                                    <div class="item-link ks-generate-page">
                                        <div class="item-content">
                                            <div class="item-inner" style="background: none; padding-right: 15px;">
                                                <div class="item-title">身份证号：</div>
                                                <div class="item-title info-color">${!empty login_new_merchant.ownerSSN ? login_new_merchant.ownerSSN : '******************'}</div>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="border-bottom">
                                    <a href="<c:url value='/new/m/updatePassword/show'/>" class="item-link ks-generate-page">
                                        <div class="item-content">
                                            <div class="item-inner" style="padding-right: 15px;">
                                                <div class="item-title">修改密码：</div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                            </ul>
                        </div>

                        <div class="my-account-but" id="logoutBtn">
                            <a class="my-account-buts" href="#">退出账号</a>
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

    //退出登录
    $("#logoutBtn").click(function () {

        myApp.modal({
            text: '退出后您将不能查看相关信息，确定要退出当前账号吗？',
            buttons: [
                {
                    text: '取消',
                    onClick: function () {
                    }
                },
                {
                    text: '确定',
                    onClick: function () {
                        $.ajax({
                            type: "POST",
                            url: contextPath + "new/m/logout",
                            data: {},
                            success: function (data) {
                                if (data.resultCode == "-1") {
                                    myApp.hidePreloader();
//                                    myApp.alert(data.resultMsg, '提示');
                                    //登出
                                    location.href = contextPath + "new/m/j_spring_security_logout";
                                    //关闭微信浏览器，重新获取SESSION
                                    WeixinJSBridge.call('closeWindow');
                                } else {
                                    //登出
                                    location.href = contextPath + "new/m/j_spring_security_logout";
                                    //关闭微信浏览器，重新获取SESSION
                                    WeixinJSBridge.call('closeWindow');
                                }
                            }
                        });
                    }
                }
            ]
        })

    });

</script>

</body>
</html>