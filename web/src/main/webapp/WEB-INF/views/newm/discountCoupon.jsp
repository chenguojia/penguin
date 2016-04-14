<!DOCTYPE html>
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
    <!--main css-->
    <link rel="stylesheet" href="<c:url value='/resources/css/newHomepage.css'/>">


</head>
<body>
<link rel="stylesheet" href="<c:url value='/resources/css/newHomepage.css'/>">
<!-- Views-->
<div class="views">
    <!-- Your main view, should have "view-main" class-->
    <div class="view view-main login-background">
        <div class="home-page-backs displaynone">
            <div></div>
        </div>
        <!-- Top Navbar-->
        <div class="navbar login-title">
            <div class="navbar-inner">
                <div class="left"><a href="<c:url value="/new/m/home?step=1"/>" class="close-img"><img
                        src="<c:url value="/resources/image/left-arror.png"/>"></a></div>
                <div class="center sliding login-title-word hong-bao-top-center">我的优惠券</div>
                <div class="right"><span class="hongbao-top-select">选择(<span id="couponNum">0</span>)</span><a href="#" class="help"><img src="<c:url value="/resources/image/help.png"/>"></a></div>
            </div>

            <div class="navbar-part2">
            </div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through" id="pages-contents">
            <div class="back-ttps displaynone" id="back-ttps"></div>
            <!-- Page, data-page contains page name-->
            <div class="m-slider m-slider-hongbao">
                <input type="hidden" id="judge" value="${resultAmount}">
                <ul class="cnt">
                    <li class="cnt-li" style="background-color: #f1f1f1;padding-top:60px;" id="homePageScroll1">
                        <c:forEach var="item" items="${coupons}" varStatus="i">
                            <%--<div class="bride bride-hongbao">--%>
                            <%--<div class="hongbao-include"><span class="glyphicon glyphicon-ok-sign hongbao-include-font1"></span></div>--%>
                            <div class="bride">
                                <div class="hongbao-include"><span class="glyphicon "></span></div>
                                <div class="hongbao-font1"><span class="bride-font2">￥</span><span
                                        class="bride-font3 couponNames">${item.amount}</span></div>
                                <div class="bride-font5"><span class="bride-font6">${item.memo}</span><span
                                        class="hongbao-font4 ">未使用</span></div>
                                <input type="hidden" name="couponId" class="couponIds" value="${item.id}">
                            </div>

                            <%--<div class="bride">
                              &lt;%&ndash;<div class="hongbao-include"><span class="glyphicon glyphicon-ok-sign hongbao-include-font2"></span></div>&ndash;%&gt;
                              <div class="hongbao-include"><span class="glyphicon"></span></div>
                              <div class="hongbao-font1"><span class="bride-font2">￥</span><span class="bride-font3 couponNames">10.00</span></div>
                              <div class="bride-font5"><span class="bride-font6">新手注册得10元红包</span><span class="hongbao-font4">未使用</span></div>
                            </div>--%>
                        </c:forEach>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="<c:url value="/resources/js/classie.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/modernizr.custom.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.touchSwipe.min.js"/>"></script>
<script type="text/javascript">

    var loanAmount = $("#judge").val();
    var maxNum = 1;//最多使用几张优惠券
    if (loanAmount >= 50000) {
        maxNum = 3;
    } else if (loanAmount >= 20000 && loanAmount < 50000) {
        maxNum = 2;
    } else if (loanAmount >= 5000 && loanAmount < 20000) {
        maxNum = 1;
    } else if (loanAmount >= 0 && loanAmount < 5000) {
        maxNum = 0;
    }

    $(function () {
        if($(".bride").length>0){
            var loanAmount = $("#judge").val();
//            alert(loanAmount);
            if (loanAmount >= 5000) {
                $(".bride").eq(0).find("span").eq(0).addClass('glyphicon-ok-sign');
                $(".bride").eq(0).addClass('bride-hongbao');
                $("#couponNum").html("1");

                var len = $(".bride").length;
                var selectedName = "";
                var couponIds = "";
                for (var i = 0; i < len; i++) {
                    var judges = $(".bride").eq(i).find("span").eq(0).hasClass('glyphicon-ok-sign');
                    if (judges) {
                        selectedName = selectedName + $(".bride").eq(i).find("span").eq(2).html() + ",";
                        couponIds = couponIds + $(".bride").eq(i).find("input").eq(0).val() + ",";
                    }
                }
                selectedName = selectedName.substring(0, selectedName.length - 1);
                couponIds = couponIds.substring(0, couponIds.length - 1);
                //后台将优惠券信息保存到session中，提交申请的时候直接取出即可
                $.ajax({
                    type: "POST",
                    url: contextPath + "coupon/choseCoupons",
                    data: {couponIds: couponIds,selectedName:selectedName},
                    success: function (data) {
                    }
                });

            }
        }
    });

    $(".bride").click(function () {

        //已经选择的优惠券
        var couponNum = $(".glyphicon-ok-sign").length;

        var test = $(this).find("span").eq(0).hasClass('glyphicon-ok-sign');
        if (test) {
            $(this).find("span").eq(0).removeClass("glyphicon-ok-sign");
            $(this).removeClass("bride-hongbao");
            $("#couponNum").html(couponNum - 1);
        } else {
            $(this).find("span").eq(0).addClass("glyphicon-ok-sign");
            $(this).addClass("bride-hongbao");
            $("#couponNum").html(couponNum + 1);
        }

        if (couponNum > maxNum && maxNum == 0) {
            myApp.alert("您的融资金额少于5000元，暂不支持使用优惠券", "提示");
            $(this).find("span").eq(0).removeClass("glyphicon-ok-sign");
            $(this).removeClass("bride-hongbao");
            $("#couponNum").html(couponNum - 1);
        } else if (couponNum > maxNum && maxNum == 1) {
            myApp.alert("本次融资最多使用1张优惠券", "提示");
            $(this).find("span").eq(0).removeClass("glyphicon-ok-sign");
            $(this).removeClass("bride-hongbao");
            $("#couponNum").html(couponNum - 1);
        } else if (couponNum > maxNum && maxNum == 2) {
            myApp.alert("本次融资最多使用2张优惠券", "提示");
            $(this).find("span").eq(0).removeClass("glyphicon-ok-sign");
            $(this).removeClass("bride-hongbao");
            $("#couponNum").html(couponNum - 1);
        } else if (couponNum > maxNum && maxNum == 3) {
            myApp.alert("本次融资最多使用3张优惠券", "提示");
            $(this).find("span").eq(0).removeClass("glyphicon-ok-sign");
            $(this).removeClass("bride-hongbao");
            $("#couponNum").html(couponNum - 1);
        }

        var len = $(".bride").length;
        var selectedName = "";
        var couponIds = "";
        for (var i = 0; i < len; i++) {
            var judges = $(".bride").eq(i).find("span").eq(0).hasClass('glyphicon-ok-sign');
            if (judges) {
                selectedName = selectedName + $(".bride").eq(i).find("span").eq(2).html() + ",";
                couponIds = couponIds + $(".bride").eq(i).find("input").eq(0).val() + ",";
            }
        }
        selectedName = selectedName.substring(0, selectedName.length - 1);
        couponIds = couponIds.substring(0, couponIds.length - 1);
        //后台将优惠券信息保存到session中，提交申请的时候直接取出即可
        $.ajax({
            type: "POST",
            url: contextPath + "coupon/choseCoupons",
            data: {couponIds: couponIds,selectedName:selectedName},
            success: function (data) {
//        alert(data);
            }
        });
    });
</script>
</body>
</html>