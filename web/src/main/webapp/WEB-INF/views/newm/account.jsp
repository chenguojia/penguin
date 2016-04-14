<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <title>卡得万利商业保理</title>

</head>
<body>
<!-- Views-->
<div class="views" style="width: 100%; overflow-x: hidden">
    <!-- Your main view, should have "view-main" class-->
    <div class="view view-main" style="width: 100%; overflow-x: hidden">
        <!-- Top Navbar-->
        <div class="navbar login-title">
            <div class="navbar-inner">
                <div class="center sliding login-title-word">我的账户</div>
                <div class="right"><a href="<c:url value='/new/m/userInfo/show'/>" class="close-img2"><img
                        src="<c:url value='/resources/image/shangchuan.png'/>"></a></div>
            </div>
        </div>
        <div class="upload-title">
            <div class="upload-title-img"><img src="<c:url value='/resources/image/users.png'/>"><a
                    class="upload-fonts">${newMerchantUserModel.mobilePhone}</a></div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through" style="width: 100%; overflow-x: hidden">
            <!-- Page, data-page contains page name-->
            <div class="page" style="width: 100%; overflow-x: hidden">
                <!-- "hide-bars-on-scroll" class to hide both Navbar and Toolbar -->
                <div class="page-content" style="padding-top: 15px; width: 100%; overflow-x: hidden;">
                    <div class="content-block" style="padding: 0; margin-top: 0; width: 100%; overflow-x: hidden;">
                        <div class="list-block" style="margin-top: 0; width: 100%; overflow-x: hidden;">
                            <ul>
                                <li class=" border-bottom border-tops">
                                    <a href="#" class="item-link ks-generate-page">
                                        <div class="item-content">
                                            <div class="item-media upload-username-icon"><img src="<c:url value='/resources/image/myShopes.png'/>"></div>
                                            <div class="item-inner" style="background: none; margin-left: 0; padding-right: 15px;">
                                                <div class="item-title upload-font2">我的商铺</div>
                                                <div class="item-title upload-file-font1 upload-file-part2" id="addShop"><img src="<c:url value='/resources/image/blueCross.png'/>"><span>添加商户</span></div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <c:forEach items="${muliteMerchant}" var="item" varStatus="i">
                                <li class="border-bottom">
                                    <c:choose>
                                        <c:when test="${objectId == item.merchantId}">
                                            <a href="<c:url value='/new/m/home'/>" class="item-content more-main">
                                                <div class="item-inner upload-inners" style="background: none;">
                                        </c:when>
                                        <c:otherwise>
                                            <a href="#" class="item-link item-content more-main muliteMerchantIds">
                                                <div class="item-inner upload-inners">
                                        </c:otherwise>
                                    </c:choose>
                                                    <div class="item-title-row">
                                                        <div class="item-title"><span class="upload-font555">${item.corporateName}</span></div>
                                                        <input type="hidden" name="muliteMerchantId"
                                                            value="${item.merchantId}">
                                                        <input type="hidden" name="mulitApplicationId"
                                                        value="${item.applicationId}">
                                                    </div>
                                                </div>
                                            </a>
                                </li>
                                    </c:forEach>

                            </ul>
                        </div>


                        <div class="list-block media-list myaccount upload-list-block">
                            <ul class="float_clear margin-t12">
                                <li class=" border-bottom border-tops">
                                    <a href="<c:url value="/info/dimension"/>" class="item-link item-content more-main">
                                        <div class="item-inners upload-inners">
                                            <div class="item-title-row">
                                                <div class="item-title">我的二维码</div>
                                                <div class="item-title"><img
                                                    src="<c:url value='/resources/image/dimension.png'/>"></div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <li class=" border-bottom">
                                    <a href="<c:url value="/coupon/discountCoupon"/>"
                                        class="item-link item-content more-main">
                                        <div class="item-inners upload-inners">
                                            <div class="item-title-row">
                                                <div class="item-title">我的红包</div>
                                                <div class="item-title"><span class="upload-font3">剩余<span
                                                    class="upload-file-font">${total}</span>个</span>
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                            </ul>
                        </div>

                            <%--begin--%>
                        <div class="list-block media-list myaccount more-part2">
                            <ul class="float_clear margin-t12">
                                <li class=" border-bottom border-tops">
                                    <a href="#" class="item-link item-content more-main">
                                        <div class="item-media username_icon upload-username-icon"><img src="<c:url value='/resources/image/commandRed.jpg'/>"></div>
                                        <div class="item-inners upload-inners">
                                            <div>
                                                <div class="item-title upload-font2">推荐专区</div>
                                            </div>
                                        </div>
                                    </a>
                                </li>

                                <li class=" border-bottom">
                                    <a href="<c:url value="/info/inviteRecord"/>" class="item-link item-content more-main">
                                        <div class="item-inners upload-inners">
                                            <div class="item-title-row">
                                                <div class="item-title"><span>邀请好友赢红包</span></div>
                                                    <div class="item-title"><span class="upload-font3">已成功推荐<span class="upload-file-font">${map.inviteCount}</span>人</span></div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                            </ul>
                        </div>
                            <%--end--%>
                    </div>

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
                <a href="<c:url value='/new/m/account'/>" class="tab-link active">
                    <i class="icon account-icon">
                    </i>
                    <span class="tabbar-label">账户</span>
                </a>
                <a href="<c:url value='/new/m/more'/>" class="tab-link">
                    <i class="icon more-icon"></i>
                    <span class="tabbar-label">更多</span>
                </a>
            </div>
        </div>
    </div>
</div>

<%--<script type="text/javascript">--%>
<%--var calendarDefault = myApp.calendar({--%>
<%--input: '#calendar-default',--%>
<%--onDayClick: function(dayContainer){--%>
<%--//            alert('ddddd');--%>
<%--dayContainer.close();--%>
<%--}--%>
<%--});--%>
<%--</script>--%>

<script type="text/javascript" src="<c:url value='/resources/js/jquery.js'/>"></script>
<script type="text/javascript">
    var screenWidth = $(window).width();

    $(function () {
        $(".muliteMerchantIds").click(function () {
            var merchantId = $(this).find("input[name=muliteMerchantId]").val();
            var applicationId = $(this).find("input[name=mulitApplicationId]").val();
            $.ajax({
                type: "POST",
                async: true,
                url: "<c:url value="/new/m/exchangeMerchant"/>",
                data: {merchantId: merchantId, applicationId: applicationId},
                success: function (data) {
                    if (data.code == 1 || data.code == "1") {
                        location.href = "<c:url value="/new/m/home"/>";
                    }
                }
            });
        });

        //添加商铺
        $("#addShop").click(function () {
            $.ajax({
                type: "GET",
                url: "<c:url value="/new/m/addMerchant"/>",
                data: {},
                success: function (data) {
                    myApp.alert(data.message, "提示信息");
                    if (data.code == '1' || data.code == 1) {//code==1表示新增成功
                        location.href = "<c:url value="/new/m/home?step=0"/>";
                    }
                },
                error: function (data) {
                    myApp.alert("服务器发生异常状况，请稍后再试！", "提示");
                }
            });
        });

        $(".upload-title-img").click(function(){
            location.href = "<c:url value='/new/m/userInfo/show'/>";

        });
    })

</script>
</body>
</html>