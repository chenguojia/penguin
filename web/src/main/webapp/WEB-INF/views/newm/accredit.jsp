<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head></head>
<body>
    <!-- Status bar overlay for fullscreen mode-->
    <div class="statusbar-overlay"></div>
    <!-- Panels overlay-->
    <div class="panel-overlay"></div>
    <!-- Right panel with cover effect-->
    <div class="panel panel-right panel-reveal">
        <div class="content-block">
            <p>Right panel content goes here</p>
        </div>
    </div>
    <!-- Views-->
    <div class="views">
        <!-- Your main view, should have "view-main" class-->
        <div class="view view-main">
            <!-- Top Navbar-->
            <div class="navbar login-title">
                <div class="navbar-inner">
                    <div class="center sliding login-title-word">授权书</div>
                </div>
            </div>
            <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
            <div class="pages navbar-through toolbar-through register-padding">
                <!-- Page, data-page contains page name-->
                <div data-page="login" class="page">
                    <!-- Scrollable page content-->
                    <div class="page-content">
                        <div>
                            <div class="list-block">
                                <jsp:include page="/new/m/clause/registerFinish"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="toolbar tabbar tabbar-labels">
                <div class="toolbar-inner">
                    <div class="button button-big account-button" type="button" id="agreeBtn">同意</div>
                </div>
            </div>
        </div>
    </div>

    <script>

        //授权
        $("#agreeBtn").click(function(){
            //验证成功，提交FORM
            $.ajax({
                type: "POST",
                url: contextPath + "new/m/accredit",
                data: {},
                success: function (data) {
                    if (data.resultCode == "-1") {
                        myApp.alert(data.resultMsg,'提示');
                    } else {
                        //成功,跳转主控界面
                        location.href = contextPath + "new/m/home";
                    }
                }
            });
        });

</script>

</body>
</html>
