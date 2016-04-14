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
                <div class="left"><a href="<c:url value='/new/m/account'/>" class="close-img"><img src="<c:url value='/resources/image/left-arror.png'/>"></a></div>
                <div class="center sliding login-title-word">个人信息</div>
                <div class="right"><a href="#" class="account-font1">活动规则</a></div>
            </div>
        </div>
        <div class="account-title">
            <div class="account-font2">邀请获取红包 （元）</div>
            <div class="account-font3">1000<span class="account-font4">元</span></div>
            <div class="account-font5">成功邀请：7人</div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page account-page">
                <!-- Scrollable page content-->
                <div class="page-content upload-page">
                    <div class="list-block media-list myaccount upload-list-block">
                        <!--当有记录时-->
                        <ul class="float_clear displaynone">
                            <li class=" border-bottom">
                                <div class="item-link item-content more-main padding0">
                                    <div class="item-inners">
                                        <div class="item-title-row none-background account-font6">
                                            <div class="item-title">被邀请人：</div>
                                            <div class="item-title">13801933282</div>
                                            <div class="item-title account-font7">2015-08-25 注册</div>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li class=" border-bottom">
                                <div class="item-link item-content more-main padding0">
                                    <div class="item-inners">
                                        <div class="item-title-row none-background account-font6">
                                            <div class="item-title">被邀请人：</div>
                                            <div class="item-title">13801933282</div>
                                            <div class="item-title account-font7">2015-08-25 注册</div>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li class=" border-bottom">
                                <div class="item-link item-content more-main padding0">
                                    <div class="item-inners">
                                        <div class="item-title-row none-background account-font6">
                                            <div class="item-title">被邀请人：</div>
                                            <div class="item-title">13801933282</div>
                                            <div class="item-title account-font7">2015-08-25 注册</div>
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </ul>
                        <!--当无记录时-->
                        <div class="account-none-record"><img src="<c:url value='/resources/image/noneRecord.png'/>"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="toolbar tabbar tabbar-labels">
            <div class="toolbar-inner">
                <button class="button button-big account-button">邀请好友得大奖</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>