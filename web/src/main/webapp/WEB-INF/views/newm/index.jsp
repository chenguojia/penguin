<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head></head>
<body>
<!-- Views-->
<div class="views">
    <!-- Your main view, should have "view-main" class-->
    <div class="view view-main">
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages">
            <!-- Page, data-page contains page name-->
            <div data-page="home" class="page">
                <!-- Scrollable page content-->
                <div class="page-content index-background">
                    <div class="guide">
                        <div class="guide-img">
                            <img src="<c:url value="/resources/image/index-hom.jpg"/>">
                        </div>
                        <div class="guide-btn-new">
                            <button class="button register-btn">注册</button>
                            <button class="button login-btn">登录</button>
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

    $(".register-btn").click(function () {
        location.href = "<c:url value='/new/m/bind/show'/>";//同意条款跳转到首页
    });

    $(".login-btn").click(function () {
        location.href = "<c:url value='/new/m/login/show'/>";//同意条款跳转到首页
    });

</script>

</body>
</html>
