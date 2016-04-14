<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head></head>
<body>
<!-- Views-->
<div class="views" style="position:absolute; margin:0; padding:0; border:0; top:0;">
    <!-- Your main view, should have "view-main" class-->
    <div class="view view-main">
        <!-- Top Navbar-->
        <div class="navbar login-title"  style="display: ${isApp == '0' ? 'block' : 'none'}">
            <div class="navbar-inner">
                <div class="left"><a href="<c:url value='/new/m/more'/>" class="close-img"><img src="<c:url value='/resources/newm/images/icon/left-arror.png'/>"></a></div>
                <div class="center sliding login-title-word">新闻中心</div>
            </div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page">
                <!-- Scrollable page content-->
                <div class="page-content ${isApp == '0' ? '' : 'none-navbar'}">
                    <div class="list-block media-list myaccount">
                        <ul>
                            <li>
                                <a href="<c:url value='/new/m/more/newsDetails'/>" class="item-link item-content">
                                    <div class="item-inner questionCon">
                                        <div class="item-title-row" style="display: block;">
                                            <div class="item-title">用好保理融资循环预支，小微企业不差钱</div>
                                            <div class="newsTit">小微企业在经营过程中，都会频繁遇到资金紧缺，无论是补充流动资金不足</div>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="<c:url value='/new/m/newsDetails'/>" class="item-link item-content">
                                    <div class="item-inner questionCon">
                                        <div class="item-title-row" style="display: block;">
                                            <div class="item-title">中小微商贸企业眼中的保理融资</div>
                                            <div class="newsTit">2014年，国务院发布社会信用体系建设规划纲要(2014-2020年)</div>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="<c:url value='/new/m/newsDetails'/>" class="item-link item-content">
                                    <div class="item-inner questionCon">
                                        <div class="item-title-row" style="display: block;">
                                            <div class="item-title">最简单的保理融资，最适合小微商户</div>
                                            <div class="newsTit">自商务部2012年率先在上海浦东推动商业保理试点以来，保理融资作为商业保理的重要内容</div>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="<c:url value='/new/m/newsDetails'/>" class="item-link item-content">
                                    <div class="item-inner questionCon">
                                        <div class="item-title-row" style="display: block;">
                                            <div class="item-title">找到卡得万利，小微融资并不难</div>
                                            <div class="newsTit">小微企业融资难的话题近几年讨论颇多，但大都聚焦在政府宏观政策支持</div>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="<c:url value='/new/m/newsDetails'/>" class="item-link item-content">
                                    <div class="item-inner questionCon">
                                        <div class="item-title-row" style="display: block;">
                                            <div class="item-title">第一次融资，小微企业为何选择保理</div>
                                            <div class="newsTit">在我们的人生中，会遇到许多第一次，第一次是开拓性的，有挑战性的。</div>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="<c:url value='/new/m/newsDetails'/>" class="item-link item-content">
                                    <div class="item-inner questionCon">
                                        <div class="item-title-row" style="display: block;">
                                            <div class="item-title">关于2015年“五一”国际劳动节期间，清算事宜的通告</div>
                                            <div class="newsTit">根据《国务院办公厅关于2015年部分节假日安排的通知》精神</div>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="<c:url value='/new/m/newsDetails'/>" class="item-link item-content">
                                    <div class="item-inner questionCon">
                                        <div class="item-title-row" style="display: block;">
                                            <div class="item-title">融资那么难，发展期小微企业怎么办</div>
                                            <div class="newsTit">凡做企业的，没有不想做大的，小微企业更是如此。在渡过创业初期的生死关后</div>
                                        </div>
                                    </div>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>