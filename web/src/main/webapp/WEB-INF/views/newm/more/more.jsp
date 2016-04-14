<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <script src="//meiqia.com/js/mechat.js?unitid=55f772e44eae357933000003" charset="UTF-8" async="async"></script>
</head>
<body>
<!-- Views-->
<div class="views" style="position:absolute; margin:0; padding:0; border:0; top:0;">
    <!-- Your main view, should have "view-main" class-->
    <div class="view view-main">
        <!-- Top Navbar-->
        <div class="navbar login-title">
            <div class="navbar-inner">
                <%--<div class="left"><a href="#" class="close-img"><img src="<c:url value="/resources/newm/images/icon/select-arrow.png"/>"></a></div>--%>
                <div class="center sliding login-title-word">更多</div>
            </div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page">
                <!-- Scrollable page content-->
                <div class="page-content">
                    <div class="list-block media-list myaccount">
                        <div class="more-title">
                            <div class="more-title-img"><img src="<c:url value="/resources/image/service.png"/>"></div>
                            <div class="more-title-tele">
                                <div><a class="more-title-font1">4008-803-803</a>
                                </div>
                                <div class="more-title-service-time"><span
                                        class="more-title-font2">服务时间：周一至周五9:00~18:00</span></div>
                            </div>
                        </div>
                    </div>

                    <div class="list-block" style="margin: 12px 0;">
                        <ul>
                            <li class="border-bottom border-tops">
                                <a  href="<c:url value='/new/m/more/question?isApp=0'/>" class="item-link ks-generate-page">
                                    <div class="item-content">
                                        <div class="item-media username_icon"><img src="<c:url value="/resources/image/gonglue.png"/>"></div>
                                        <div class="item-inner" style="padding-right: 15px;">
                                            <div class="item-title">融资攻略</div>
                                        </div>
                                    </div>
                                </a>
                            </li>
                        </ul>
                    </div>

                    <div class="list-block" style="margin: 12px 0;">
                        <ul>
                            <li class="border-bottom border-tops">
                                <a  href="<c:url value='/new/m/more/aboutUs'/>" class="item-link ks-generate-page">
                                    <div class="item-content">
                                        <div class="item-media username_icon"><img src="<c:url value="/resources/image/pruoduce.png"/>"></div>
                                        <div class="item-inner" style="padding-right: 15px;">
                                            <div class="item-title">公司简介</div>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="border-bottom">
                                <a  href="<c:url value='/new/m/more/honor'/>" class="item-link ks-generate-page">
                                    <div class="item-content">
                                        <div class="item-media username_icon"><img src="<c:url value="/resources/image/honor.png"/>"></div>
                                        <div class="item-inner" style="padding-right: 15px;">
                                            <div class="item-title">资质荣誉</div>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="border-bottom">
                                <a  href="<c:url value='/new/m/more/contactUs'/>" class="item-link ks-generate-page">
                                    <div class="item-content">
                                        <div class="item-media username_icon"><img src="<c:url value="/resources/image/contact.png"/>"></div>
                                        <div class="item-inner" style="padding-right: 15px;">
                                            <div class="item-title">联系方式</div>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="border-bottom">
                                <a  href="<c:url value='/new/m/more/aboutPenguin'/>" class="item-link ks-generate-page">
                                    <div class="item-content">
                                        <div class="item-media username_icon"><img src="<c:url value="/resources/image/about.png"/>"></div>
                                        <div class="item-inner" style="padding-right: 15px;">
                                            <div class="item-title">关于我们</div>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="border-bottom">
                                <a  href="<c:url value='/new/m/more/comments'/>" class="item-link ks-generate-page">
                                    <div class="item-content">
                                        <div class="item-media username_icon"><img src="<c:url value="/resources/image/opinion.png"/>"></div>
                                        <div class="item-inner" style="padding-right: 15px;">
                                            <div class="item-title">意见反馈</div>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="border-bottom">
                                <div class="item-link ks-generate-page" onclick="mechatClick()">
                                    <div class="item-content">
                                        <div class="item-media username_icon"><img src="<c:url value="/resources/image/service2.png"/>"></div>
                                        <div class="item-inner" style="padding-right: 15px;">
                                            <div class="item-title">在线客服</div>
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>

                </div>
            </div>
        </div>
        <div class="toolbar tabbar tabbar-labels">
            <div class="toolbar-inner">
                <a href="<c:url value='/new/m/home'/>" class="tab-link">
                    <i class="icon money-icon"></i>
                    <span class="tabbar-label">融资</span>
                </a>
                <a href="<c:url value='/new/m/account'/>" class="tab-link">
                    <i class="icon account-icon">
                    </i>
                    <span class="tabbar-label">账户</span>
                </a>
                <a href="<c:url value='/new/m/more'/>" class="tab-link active">
                    <i class="icon more-icon"></i>
                    <span class="tabbar-label">更多</span>
                </a>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    var myApp = new Framework7({
        modalTitle: '卡得万利商业保理',
        ajaxLinks: 'a.ajax'
    });

</script>
</body>
</html>
