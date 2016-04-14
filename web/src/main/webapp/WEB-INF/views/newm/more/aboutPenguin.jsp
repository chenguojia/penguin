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
        <div class="navbar login-title">
            <div class="navbar-inner">
                <div class="left"><a href="<c:url value='/new/m/more'/>" class="close-img"><img src="<c:url value="/resources/image/left-arror.png"/>"></a></div>
                <div class="center sliding login-title-word">关于小企额</div>
            </div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page">
                <!-- Scrollable page content-->
                <div class="page-content">
                    <div class="list-block media-list myaccount about-penguin">
                        <div class="about-title">
                            <div><img src="<c:url value="/resources/image/tubiao.png"/>"></div>
                            <div class="about-title-font"><span>小企额2.0.0</span></div>
                        </div>
                        <ul class="float_clear margin-t12">
                            <li class=" border-bottom border-tops">
                                <a href="<c:url value='/new/m/more/comments'/>" class="item-link item-content more-main">
                                    <div class="item-inners">
                                        <div class="item-title-row">
                                            <div class="item-title">意见反馈</div>
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

<script type="text/javascript">
    var myApp = new Framework7({
        modalTitle: '卡得万利商业保理',
        ajaxLinks: 'a.ajax'
    });

</script>

</body>
</html>
