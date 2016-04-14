<!DOCTYPE html>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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

    <script src="//meiqia.com/js/mechat.js?unitid=55f772e44eae357933000003&btn=hide" charset="UTF-8" async="async"></script>
</head>

<body>

<input name="error" id="error" type="hidden" value="${error}">
<!-- Views-->
<div class="views">
    <!-- Your main view, should have "view-main" class-->
    <div class="view view-main login-background">
        <div class="home-page-backs displaynone">
            <div></div>
        </div>
        <div class="float_l home-back displaynone">
            <div class="home-back-img">
                <img src="<c:url value="/resources/image/home-cover1.png"/>">
            </div>
            <div class="home-back-img opacitynone">
                <img src="<c:url value="/resources/image/home-cover2.png"/>">
            </div>
            <div class="home-back-img opacitynone">
                <img src="<c:url value="/resources/image/home-cover3.png"/>">
            </div>
            <div class="home-back-buttom-img opacitynone">
                <img src="<c:url value="/resources/image/home-cover-4.png"/>">
            </div>
            <div class="home-back-buttom-img opacitynone">
                <img src="<c:url value="/resources/image/home-cover5.png"/>">
            </div>
        </div>
        <!-- Top Navbar-->
        <div class="navbar login-title home-navbar-login-title" id="address-displaynone">
            <div class="navbar-inner new-navbar">
                <div class="left new-homepage"><a href="#" class="close-img"><img src="<c:url value="/resources/image/icon/shanghuItem.png"/>" id="showLeft"> </a></div>
                <div class="center sliding login-title-word" id="show">商铺信息</div>
                <div class="right home-rights">
                    <a href="<c:url value="/info/queryInfomation"/>" class="close-img new-close"><img src="<c:url value="/resources/image/image20/messages.png"/>"> </a>
                </div>
            </div>

            <input id="creditId" value="${applicationModel.creditId}" name="creditId" type="hidden">
            <input id="status" value="${applicationModel.status}" name="status" type="hidden">
            <input id="cashadvanceStatus" value="${applicationModel.cashadvanceStatus}" name="cashadvanceStatus" type="hidden">
            <input id="isSubmitApplication" value="${applicationModel.isSubmitApplication}"  type="hidden">
            <input id="isAmountLocked" value="${applicationModel.isAmountLocked}"  type="hidden">

            <div class="navbar-part2">
                <div class="float_l home-page-numbers2">
                    <div class="icons home-page-button-content" id="icons">
                        <div class="home-page-button-content2">
                            <span id="number1" class="btn home-numbers-button home-button-border">额度计算</span>
                            <span id="number2" class="btn home-numbers-button disabled">上传资料</span>
                            <span id="number3" class="btn home-numbers-button disabled">申请进度</span>
                        </div>
                    </div>
                </div>
            </div>


        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through" id="pages-contents">

            <div class="home-pannel-left cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
                <div class="left-total">

                    <c:forEach items="${muliteMerchant}" var="item" varStatus="i">
                        <c:if test="${merchantId == item.merchantId}">
                            <div class="home-left-part1 muliteMerchantIds">
                                <div class="float_l part1-font1">
                                    <img src="<c:url value="/resources/image/my-Shops.png"/>">
                                </div>
                                <div class="float_l part1-font2">${ fn:length(item.corporateName) > 7 ? fn:substring(item.corporateName, 0, 7) : item.corporateName  }</div>
                                <input type="hidden" name="muliteMerchantId" value="${item.merchantId}">
                                <input type="hidden" name="mulitAapplicationId" value="${item.applicationId}">
                            </div>
                        </c:if>
                    </c:forEach>

                    <div class="left-shop-names">
                        <div class="left-pannel-circle">
                            <div class="left-circle-font1">参考额度</div>
                            <%-- <c:if test="${applicationModel.requestAmount== null}">
                                     <div class="left-circle-font2">0<span class="left-circle-font3">元</span></div>
                             </c:if>
                             <c:if test="${applicationModel.requestAmount!= null}">--%>
                            <div class="left-circle-font2 requestAmount">${applicationModel.requestAmount}<span class="left-circle-font3">元</span></div>
                            <%--</c:if>--%>

                        </div>
                        <div class="left-shop-part2">
                            <span>${applicationModel.status}</span>
                        </div>
                    </div>
                    <div class="left-shop-footer" onclick="mechatClick()">
                        <span class="btn left-shop-names-button" id="addShop"><img  src="<c:url value="/resources/image/onlineContact.png"/>"><span class="left-footer-font1" >在线客服</span></span>
                    </div>
                    <div class="left-shop-footer2">
                        <span class="btn left-shop-names-button" id="left-online-comments"><img  src="<c:url value="/resources/image/onlineComments.png"/>"><span class="left-footer-font1">在线留言</span></span>
                    </div>
                </div>

            </div>

            <div class="back-ttps displaynone" id="back-ttps"></div>

            <!-- Page, data-page contains page name-->
            <div class="m-slider">
                <ul class="cnt" id="slider">
                    <li class="cnt-li" id="homePageScroll1">
                        <div class="slider-page1-content" id="page121">
                            <%--1、基础资料、商铺信息--%>
                            <%@ include file="basicLimit.jsp" %>
                        </div>
                        </li>
                        <%--<li class="cnt-li" id="homePageScroll2" style="overflow: hidden;">--%>
                        <li class="cnt-li" id="homePageScroll2" style="overflow-y: scroll;">
                            <%--<div class="slider-page1-content"" id="page1232">--%>
                                <div id="page122">
                                    <div class="home-page-move displaynone" style="width: 100%; background: rgba(255,255,255,0.1); position: absolute; z-index: 498;"></div>

                                    <c:choose>
                                        <c:when  test="${applicationModel.isSubmitApplication=='1' &&  applicationModel.isAmountLocked!=1 }">
                                            <%--申请信息确认提交页面--%>
                                            <%@ include file="applyInfomation.jsp" %>
                                        </c:when>
                                        <c:otherwise>
                                            <%--2、上传资料--%>
                                            <%@ include file="uploadFile.jsp" %>
                                            <%--<%@ include file="addFile.jsp" %>--%>
                                            <%--<%@ include file="bankBind.jsp" %>--%>
                                        </c:otherwise>
                                    </c:choose>
                                </div>

                            <%--</div>--%>

                    </li>
                    <li class="cnt-li" id="homePageScroll3">
                        <div class="slider-page1-content" id="page123">
                            <c:choose>
                                <c:when test="${applicationModel.status == '补充资料'}">
                                    <%--待补件【补全资料】--%>
                                    <%@ include file="addFile.jsp" %>

                                </c:when>
                                <c:when test="${applicationModel.status == '融资确认' && applicationModel.isWithdrawConfirm==0}">
                                    <%--融资方案【提现确认】,确认之后跳转到银行卡绑定界面--%>
                                    <%@ include file="financingConfirm.jsp" %>
                                </c:when>
                                <c:when  test="${applicationModel.status == '融资确认' && applicationModel.isWithdrawConfirm==1}">
                                    <%@ include file="bankBind.jsp" %>
                                    <%--绑定银行卡界面--%>
                                    <%--<c:if test="${applicationModel.type == 1}">
                                        &lt;%&ndash;绑定银行卡 对公&ndash;%&gt;
                                        <%@ include file="bankBind.jsp" %>
                                    </c:if>
                                    <c:if test="${applicationModel.type == 0}">
                                        &lt;%&ndash;绑定银行卡 对私&ndash;%&gt;
                                        <%@ include file="bankBind2.jsp" %>
                                    </c:if>--%>
                                </c:when>
                                <c:when test="${applicationModel.status == '提现中' || applicationModel.status == '审核未通过' || applicationModel.status == '已完成' || applicationModel.status == '申请未通过'}">
                                    <%--待放款、审核未通过、关闭【apply-status.jsp中根据状态进行判断】--%>
                                    <%@ include file="apply-status.jsp" %>
                                </c:when>

                                <c:when test="${applicationModel.cashadvanceStatus == '还款清算'}">
                                    <%--还款清算【融资保理通知书(包含对账单)】--%>
                                    <%@ include file="notification.jsp" %>
                                </c:when>

                                <c:otherwise>
                                    <%--申请状态--%>
                                    <%@ include file="apply-status.jsp" %>
                                    <%--<%@ include file="bankBind.jsp" %>--%>
                                    <%--<%@ include file="bankBind2.jsp" %>--%>
                                    <%--<%@ include file="affirmLoans.jsp" %>--%>
                                    <%--<%@ include file="notification.jsp" %>--%>

                                </c:otherwise>
                            </c:choose>
                        </div>
                    </li>
                </ul>

            </div>
        </div>

        <div class="toolbar tabbar tabbar-labels">
            <div class="toolbar-inner">
                <a href="<c:url value='/new/m/home'/>" class="tab-link active">
                    <%--<i class="icon money-icon"><span class="badge bg-red ">1</span></i>--%>
                    <i class="icon money-icon"></i>
                    <span class="tabbar-label">融资</span>
                </a>
                <a href="<c:url value='/new/m/account'/>" class="tab-link ">
                    <i class="icon account-icon"></i>
                    <span class="tabbar-label">账户</span>
                </a>
                <a href="<c:url value='/new/m/more'/>" class="tab-link ">
                    <i class="icon more-icon"></i>
                    <span class="tabbar-label">更多</span>
                </a>
            </div>
        </div>

    </div>
</div>

<input id="step" name="step" value="${step}" type="hidden" />
<input id="plan" name="plan" value="${plan.title}" type="hidden" />
<input id="isWithdrawConfirm" name="isWithdrawConfirm" value="${applicationModel.isWithdrawConfirm}" type="hidden" />
<%--是否第一次登陆--%>
<input id="firstTime" name="firstTime" value="${firstTime}" type="hidden" />
<script type="text/javascript" src="<c:url value="/resources/js/classie.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.touchSwipe.min.js"/>"></script>
<script type="text/javascript">

    <%--多商户操作--%>
    $(".muliteMerchantIds").click(function(){
        var muliteMerchantId = $(this).find("input[name=muliteMerchantId]").val();
        var mulitApplicationId = $(this).find("input[name=mulitAapplicationId]").val();

        $.ajax({
            type:"GET",
            url:"<c:url value="/new/m/exchangeMerchant"/>",
            data:{merchantId:muliteMerchantId,applicationId:mulitApplicationId},
            success:function(data){

            }
        });

    });

</script>

<script type="text/javascript">

    var scrollCurrent = 0;
    var contentHeight = $('.slider-page1-content').height();
    var screenWidth = $(window).width();
    var screenheight = $(window).height();
//    var homeBacImg = $('.home-back-buttom-img img').height();
    var clickNumber = 0;
    var ccds;
    var i =0;
    var $btn = $('.home-page-button-content span');
    var $btn2 = $('.home-page-click-steps span');
    var menuLeft = document.getElementById( 'cbp-spmenu-s1' ), showLeft = document.getElementById( 'showLeft'), pagesidden = document.getElementById( 'pages-contents');
    var $back = document.getElementById('back-ttps');
    var $sliderLi = document.getElementById('slider');
    var closeImgClickNum = 0;
    var toolbarDisplay = 'block';
    var toolbarBottom = parseInt($('.toolbar.tabbar-labels').css('bottom'));
//    alert(toolbarBottom);

    $(function(){


        var plan = $("#plan").val();//1：申请信息，2：融资方案，3：融资保理通知书
        var isWithdrawConfirm = $("#isWithdrawConfirm").val();
        var step = $("#step").val();
        var  creditId= $("#creditId").val();
        var status = $("#status").val();

        if(step==1 || step == '1'){
            $("#number1").removeClass("home-button-border");
            $("#number2").addClass("home-button-border");

            //向左移动一个页面
            $('#slider').css('left',- 1*screenWidth + 'px')

            var isSubmitApplication = $("#isSubmitApplication").val();
            var isAmountLocked = $("#isAmountLocked").val();
            if(isSubmitApplication=='1' && isAmountLocked!='1') {
                $("#show").text("申请信息确认");
            }else{
                $("#show").text("上传资料");
            }

        }
        if(step==2 || step == '2'){
            $("#number1").removeClass("home-button-border");
            $("#number3").addClass("home-button-border");
            $("#number3").removeClass("disabled");
            //向左移动一个页面
            $('#slider').css('left',- 2*screenWidth + 'px')

            if(status=="签约前审核完成" && isWithdrawConfirm =='0'){
                $("#show").text("融资方案");
            }else if(status=="签约前审核完成" && isWithdrawConfirm =='1'){
                $("#show").text("绑定银行卡");
            }else if(status=="还款清算"){
                $("#show").text("融资保理通知书");
            }else if(status=="补充资料"){
                $("#show").text("补充资料");
            }else if(status=="关闭" || status=="待放款" || status == "审核未通过"){
                $("#show").text("查看申请状态");
            }else if(status=='新申请' || status=='自助新申请' || (status=='融资确认' && isWithdrawConfirm==1)){
                $("#show").text("绑定银行卡");
            }else if(status=='审核中'){
                $("#show").text("审核中");
            }else{
                $("#show").text("查看申请");
            }
        }
        if(creditId!=null && creditId!=""){
            $("#number2").removeClass("disabled");
        }
        if($("#cashadvanceStatus").val()!=''){
            $("#number3").removeClass("disabled");
        }

    });

    $("#number1").click(function () {
        $('.slider-page1-content').css('margin-top', '105px');
        $("#show").text("额度计算");
        $("#step").val("0");
        <% session.setAttribute("step","0");%>
    });
    $("#number2").click(function () {
        $('.slider-page1-content').css('margin-top', '105px');
        var isSubmitApplication = $("#isSubmitApplication").val();
        var isAmountLocked = $("#isAmountLocked").val();
        if(isSubmitApplication=='1' && isAmountLocked!='1'){
            $("#show").text("申请信息确认");
        }else{
            $("#show").text("上传资料");
        }
        $("#step").val("1");
        <% session.setAttribute("step","1");%>
    });
    $("#number3").click(function () {
        $('.slider-page1-content').css('margin-top', '105px');
        $("#step").val("2");
        <% session.setAttribute("step","2");%>
        var status = $("#status").val();
        var plan = $("#plan").val();//1：申请信息，2：融资方案，3：融资保理通知书
        var isWithdrawConfirm = $("#isWithdrawConfirm").val();
        if(status=="签约前审核完成" && isWithdrawConfirm =='0'){
            $("#show").text("融资方案");
        }else if(status=="签约前审核完成" && isWithdrawConfirm =='1'){
            $("#show").text("绑定银行卡");
        }else if(status=="还款清算"){
            $("#show").text("融资保理通知书");
        }else if(status=="补充资料"){
            $("#show").text("补充资料");
        }else if(status=="关闭" || status=="待放款" || status == "审核未通过"){
            $("#show").text("查看申请状态");
        }else if(status=='审核中'){
            $("#show").text("审核中");
        }else if(status=='新申请' || status=='自助新申请' || ((status=='融资确认' && isWithdrawConfirm==1))){
            $("#show").text("绑定银行卡");
        }else{
            $("#show").text("申请信息");
        }
    });

    //意见反馈
    $("#left-online-comments").click(function(){
        location.href = "<c:url value="/new/m/more/comments"/>";
    });

    $('.home-page-button-content button').click(function(){
        $(this).addClass('home-button-border').siblings().removeClass('home-button-border');
    });

    $(document).ready(function(){
        if($("#firstTime").val()=='1'){
            $('.home-back').removeClass('displaynone');
        }

        var cntLength = $('.cnt').children('li').length;
        var cntWidth = cntLength * 100;
        var cntLiWidth = 100 / cntLength;
        var cntScrollWidth = cntLength * 100 / 3.5;
//        var backResult = screenheight - homeBacImg -80;
        $('.m-slider .cnt').css('width', cntWidth + '%');

        $('.m-slider .cnt li.cnt-li').css('width', cntLiWidth + '%');

        $('.home-back').css('height',screenheight+'px');
//        $('.home-back-buttom-img').css('margin-top',backResult+'px');

        var homeBackClick = 0;
        $('.home-back').click(function(){
            homeBackClick++;
            $('.home-back').children().eq(homeBackClick).removeClass('opacitynone').siblings().addClass('opacitynone');
            if(homeBackClick> 4 ){
//                隐藏罩层
                $('.home-back').addClass('displaynone');
            }
        });
    });

    $btn.each(function(index) {
        $(this).click(function(){
            document.getElementById('slider').style.left = -screenWidth*index + 'px';
            if(index > 2){
                var scrollDis = index * 50;
                $('.home-page-button-content').scrollLeft(scrollDis);
            }
            $(this).addClass('home-button-border').siblings().removeClass('home-button-border');
            $btn2.eq(index).addClass('button-font1-act').siblings().removeClass('button-font1-act');
            clickNumber = index;
        })
    });

    $btn2.each(function (index) {
        $(this).click(function () {
            document.getElementById('slider').style.left = -screenWidth * index + 'px';
            if (index > 2) {
                var scrollDis = index * 50;
                $('.home-page-button-content').scrollLeft(scrollDis);
            }
            $(this).addClass('button-font1-act').siblings().removeClass('button-font1-act');
            $btn.eq(index).addClass('home-button-border').siblings().removeClass('home-button-border');
            clickNumber = index;
            $('#icons span').toggle();
            $('.home-font2').toggle();
            $('.home-page-click-steps').slideToggle();
            $('.home-back-black').toggle();
            $('#closeStep img').removeClass('home-page-scroll').addClass('rotate45');
        });
    });

    $('.home-back-black').click(function(){
        $('.home-page-click-steps').slideToggle();
        $('.home-back-black').toggle();
        $('#icons span').toggle();
        $('.home-font2').toggle();
    });

    var currentSliderLeft;;
    showLeft.onclick = function() {
        currentSliderLeft = $('#slider').css('left');
        classie.toggle( showLeft, 'active' );
        $('#slider').css('left', '240px');
        $('.navbar.login-title').css('left', '240px');
        classie.add( menuLeft, 'cbp-spmenu-open' );
        classie.remove( $back, 'displaynone' );
    };
    $back.onclick = function() {
        classie.remove( showLeft, 'active' );
        $('#slider').css('left', currentSliderLeft);
        $('.navbar.login-title').css('left', '0px');
        classie.remove( menuLeft, 'cbp-spmenu-open' );
        classie.add( $back, 'displaynone' );
        var step = $("#step").val();
        $('.home-page-button-content2 span').eq(step).addClass('home-button-border').siblings().removeClass('home-button-border');
        $('.slider-page1-content').css('margin-top', '105px');
    };
    $sliderLi.onclick = function() {
        classie.remove( showLeft, 'active' );
        $('.navbar.login-title').css('left', '0px');
        classie.remove( menuLeft, 'cbp-spmenu-open' );
        classie.add( $back, 'displaynone' );
        var step = $("#step").val();
        $('.home-page-button-content2 span').eq(step).addClass('home-button-border').siblings().removeClass('home-button-border');
        $('.slider-page1-content').css('margin-top', '105px');
    };

    $(document).ready(function(){

        var ddeesdd = $('.navbar-inner').css('display');
        $('#homePageScroll1').scroll(function(){
            if(ddeesdd == 'flex'){
                var scrollLength = $(".m-slider .cnt li.cnt-li").scrollTop();
                var scrollResult = scrollLength / contentHeight;
                if(scrollLength > scrollCurrent && scrollResult < 0.5){
                    if(scrollLength> 0){
                        $('.navbar-inner.new-navbar').slideUp();
//                        $('.navbar-inner.new-navbar').slideUp();
//                        $('.left.new-homepage').slideUp();
//                        $('.center.sliding.login-title-word').slideUp();
//                        $('.right.home-rights').slideUp();
//                        $('.toolbar.tabbar').slideUp();
                        setTimeout(function () {
                            $('.navbar-part2').addClass('hide-top');
                        }, 50);
                        if(toolbarBottom > -50){
                            var setToolbarBottom = setInterval(function(){
                                if(toolbarBottom > -50){
                                    toolbarBottom = toolbarBottom - 1;
                                    $('.toolbar.tabbar').css('bottom', toolbarBottom + 'px');
                                }
                                else{
                                    clearInterval(setToolbarBottom);
                                    $('.toolbar.tabbar').css('bottom','-50px');
                                }
                            },10);
                        };
                    };
                }
                else if(scrollLength < scrollCurrent){
                    $('.navbar-inner.new-navbar').slideDown();
//                    $('.left.new-homepage').slideDown();
//                    $('.center.sliding.login-title-word').slideDown();
//                    $('.right.home-rights').slideDown();
//                    $('.toolbar.tabbar').slideDown();
                    if(toolbarBottom == -50){
                        var setToolbarBottom = setInterval(function(){
                            if(toolbarBottom < 0){
                                toolbarBottom = toolbarBottom + 1;
                                $('.toolbar.tabbar').css('bottom', toolbarBottom + 'px');
                            }
                            else{
                                clearInterval(setToolbarBottom);
                                $('.toolbar.tabbar').css('bottom','0px');
                            }
                        },1);
                    };
                    $('.navbar-part2').removeClass('hide-top');
                }
            }
            scrollCurrent = scrollLength;
            toolbarDisplay = $('.toolbar.tabbar').css('display');
        });

        $('#homePageScroll2').scroll(function(){
            if(ddeesdd == 'flex'){
                var scrollLength = $("#homePageScroll2").scrollTop();
                var scrollResult = scrollLength / contentHeight;
                if(scrollLength > scrollCurrent && scrollResult < 0.5){
                    if(scrollLength> 0){
                        $('.navbar-inner.new-navbar').slideUp();
//                        $('.left.new-homepage').slideUp();
//                        $('.center.sliding.login-title-word').slideUp();
//                        $('.right.home-rights').slideUp();
//                        $('.toolbar.tabbar').slideUp();
                        setTimeout(function () {
                            $('.navbar-part2').addClass('hide-top');
                        }, 50);
                        if(toolbarBottom > -50){
                            var setToolbarBottom = setInterval(function(){
                                if(toolbarBottom > -50){
                                    toolbarBottom = toolbarBottom - 1;
                                    $('.toolbar.tabbar').css('bottom', toolbarBottom + 'px');
                                }
                                else{
                                    clearInterval(setToolbarBottom);
                                    $('.toolbar.tabbar').css('bottom','-50px');
                                }
                            },10);
                        };
                    };
                }
                else if(scrollLength < scrollCurrent){
                    $('.navbar-inner.new-navbar').slideDown();
//                    $('.left.new-homepage').slideDown();
//                    $('.center.sliding.login-title-word').slideDown();
//                    $('.right.home-rights').slideDown();
//                    $('.toolbar.tabbar').slideDown();
                    if(toolbarBottom == -50){
                        var setToolbarBottom = setInterval(function(){
                            if(toolbarBottom < 0){
                                toolbarBottom = toolbarBottom + 1;
                                $('.toolbar.tabbar').css('bottom', toolbarBottom + 'px');
                            }
                            else{
                                clearInterval(setToolbarBottom);
                                $('.toolbar.tabbar').css('bottom','0px');
                            }
                        },1);
                    };
                    $('.navbar-part2').removeClass('hide-top');
                }
            }
            scrollCurrent = scrollLength;
            toolbarDisplay = $('.toolbar.tabbar').css('display');
        });

        $('#homePageScroll3').scroll(function(){
            if(ddeesdd == 'flex'){
                var scrollLength = $("#homePageScroll3").scrollTop();
                var scrollResult = scrollLength / contentHeight;
                if(scrollLength > scrollCurrent && scrollResult < 0.5){
                    if(scrollLength> 20){
                        $('.navbar-inner.new-navbar').slideUp();
//                        $('.left.new-homepage').slideUp();
//                        $('.center.sliding.login-title-word').slideUp();
//                        $('.right.home-rights').slideUp();
//                        $('.toolbar.tabbar').slideUp();
                        setTimeout(function () {
                            $('.navbar-part2').addClass('hide-top');
                        }, 50);
                        if(toolbarBottom > -50){
                            var setToolbarBottom = setInterval(function(){
                                if(toolbarBottom > -50){
                                    toolbarBottom = toolbarBottom - 1;
                                    $('.toolbar.tabbar').css('bottom', toolbarBottom + 'px');
                                }
                                else{
                                    clearInterval(setToolbarBottom);
                                    $('.toolbar.tabbar').css('bottom','-50px');
                                }
                            },10);
                        };
                    };
                }
                else if(scrollLength < scrollCurrent){
                    $('.navbar-inner.new-navbar').slideDown();
//                    $('.left.new-homepage').slideDown();
//                    $('.center.sliding.login-title-word').slideDown();
//                    $('.right.home-rights').slideDown();
//                    $('.toolbar.tabbar').slideDown();
                    if(toolbarBottom == -50){
                        var setToolbarBottom = setInterval(function(){
                            if(toolbarBottom < 0){
                                toolbarBottom = toolbarBottom + 1;
                                $('.toolbar.tabbar').css('bottom', toolbarBottom + 'px');
                            }
                            else{
                                clearInterval(setToolbarBottom);
                                $('.toolbar.tabbar').css('bottom','0px');
                            }
                        },1);
                    };
                    $('.navbar-part2').removeClass('hide-top');

                }
            }
            scrollCurrent = scrollLength;
            toolbarDisplay = $('.toolbar.tabbar').css('display');
        });
    });

    var marginTopsss = parseInt($('#page122').css('margin-top'));
    var totalHeight = $('#page122').height();
    var moveDistances = - totalHeight + screenheight - 100;
    $(function() {

        var error = $("#error").val();
        if(error!=''){
            myApp.alert(error,"提示");
        };
        var judge = $("#number2").hasClass("disabled");
        var totalLi = $('#slider').children().length;
        if(!judge){
            $("#slider li.cnt-li").swipe( {
                swipeStatus:function(event, phase, direction, distance, duration,fingerCount) {
                    var currentLi = $(this).index() +1;
                    var screenNumbers = $(this).index();
                    if(phase == 'move' && direction == 'left' && currentLi < totalLi){
                        $('#slider').css('left',- screenNumbers*screenWidth - distance + 'px')
                    }
                    else if(phase == 'move' && direction == 'right' && currentLi > 1){
                        $('#slider').css('left',- screenNumbers*screenWidth + distance + 'px')
                    }
//                向左滑动
                    else if(phase == 'end' && direction == 'left' && currentLi < totalLi && distance > 100){
                        var sliderSlow = parseInt($('#slider').css('left'));
                        var sliderDistance = - currentLi*screenWidth;
                        if(sliderSlow>sliderDistance){
                            var sliderLefts = setInterval(function(){
                                if(sliderSlow>sliderDistance){
                                    sliderSlow = sliderSlow - 8;
                                    $('#slider').css('left', sliderSlow + 'px');
                                }
                                else{
                                    clearInterval(sliderLefts);
                                    $('#slider').css('left',- currentLi*screenWidth + 'px');
                                }
                            },1);
                        }
                        $('.home-page-button-content span').eq(currentLi).addClass('home-button-border').siblings().removeClass('home-button-border');
                        $('.home-page-click-steps span').eq(currentLi).addClass('button-font1-act').siblings().removeClass('button-font1-act');
                        if(currentLi > 3){
                            var scrollDis = currentLi * 50;
                            $('.home-page-button-content').scrollLeft(scrollDis);
                        }
                    }
                    else if(direction == 'left' && distance <= 100){
                        var sliderSlow = parseInt($('#slider').css('left'));
                        var sliderDistance = - screenNumbers*screenWidth;
                        if(sliderSlow<sliderDistance){
                            var sliderLefts = setInterval(function(){
                                if(sliderSlow<sliderDistance){
                                    sliderSlow = sliderSlow + 8;
                                    $('#slider').css('left', sliderSlow + 'px');
                                }
                                else{
                                    clearInterval(sliderLefts);
                                    $('#slider').css('left',- screenNumbers*screenWidth + 'px');
                                }
                            },1);
                        }
                    }
//                向右滑动
                    else if(phase == 'end' && direction == 'right' && currentLi > 1 && distance > 100){
                        var sliderSlow = parseInt($('#slider').css('left'));
                        var sliderDistance = - (screenNumbers-1)*screenWidth;
                        if(sliderSlow<sliderDistance){
                            var sliderLefts = setInterval(function(){
                                if(sliderSlow<sliderDistance){
                                    sliderSlow = sliderSlow + 8;
                                    $('#slider').css('left', sliderSlow + 'px');
                                }
                                else{
                                    clearInterval(sliderLefts);
                                    $('#slider').css('left',- (screenNumbers-1)*screenWidth + 'px');
                                }
                            },1);
                        }
                        $('.home-page-button-content span').eq(screenNumbers-1).addClass('home-button-border').siblings().removeClass('home-button-border');
                        $('.home-page-click-steps span').eq(screenNumbers-1).addClass('button-font1-act').siblings().removeClass('button-font1-act');
                        if(currentLi < 4){
                            $('.home-page-button-content').scrollLeft(0);
                        }
                    }
                    else if(direction == 'right' && distance <= 100){
                        var sliderSlow = parseInt($('#slider').css('left'));
                        var sliderDistance = - screenNumbers*screenWidth;
                        if(sliderSlow>sliderDistance){
                            var sliderLefts = setInterval(function(){
                                if(sliderSlow>sliderDistance){
                                    sliderSlow = sliderSlow - 8;
                                    $('#slider').css('left', sliderSlow + 'px');
                                }
                                else{
                                    clearInterval(sliderLefts);
                                    $('#slider').css('left',- screenNumbers*screenWidth + 'px');
                                }
                            },1);
                        }
                    }
////                滚动
                    else if(direction == 'up' && phase == 'move'){
                        if(toolbarDisplay == 'block'){
                            $('.navbar.login-title').addClass('home-page-myMove');
//                            $('.left.new-homepage').slideUp();
//                            $('.center.sliding.login-title-word').slideUp();
//                            $('.right.home-rights').slideUp();
                            $('.navbar-inner.new-navbar').slideUp();

//                            $('.navbar-inner.new-navbar').css('display','none');
//                            $('.toolbar.tabbar').css('display','none');
                            setTimeout(function () {
                                $('.navbar-part2').addClass('hide-top');
                            }, 50);
                            if(toolbarBottom > -50){
                                var setToolbarBottom = setInterval(function(){
                                    if(toolbarBottom > -50){
                                        toolbarBottom = toolbarBottom - 1;
                                        $('.toolbar.tabbar').css('bottom', toolbarBottom + 'px');
                                    }
                                    else{
                                        clearInterval(setToolbarBottom);
                                        $('.toolbar.tabbar').css('bottom','-50px');
                                    }
                                },10);
                            };
                        };
                    }
                    else if(direction == 'down' && phase == 'move'){
//                        if(toolbarBottom < 0){
                            $('.navbar-inner.new-navbar').slideDown();
//                            $('.left.new-homepage').slideDown();
//                            $('.center.sliding.login-title-word').slideDown();
//                            $('.right.home-rights').slideDown();
//                            $('.toolbar.tabbar').slideDown();
                            $('.navbar-part2').removeClass('hide-top');
                            if(toolbarBottom == -50){
                                var setToolbarBottom = setInterval(function(){
                                    if(toolbarBottom < 0){
                                        toolbarBottom = toolbarBottom + 1;
                                        $('.toolbar.tabbar').css('bottom', toolbarBottom + 'px');
                                    }
                                    else{
                                        clearInterval(setToolbarBottom);
                                        $('.toolbar.tabbar').css('bottom','0px');
                                    }
                                },1);
                            };
//                        };
                    }
                    else if(currentLi === 1 && direction == 'right' && distance > 20){
                        currentSliderLeft = '0px';
                        $('#slider').css('left', '240px');
                        $('.navbar.login-title').css('left', '240px');
                        classie.add( menuLeft, 'cbp-spmenu-open');
                        classie.remove( $back, 'displaynone' );
                    }
                    else{
                        $('#slider').css('left', - screenNumbers*screenWidth + 'px')
                    };
                },
                allowPageScroll: 'vertical'
            });
        };

        var judge3 = $("#number3").hasClass("disabled");
        if(judge3){
            $('#slider').children().eq(2).addClass('displaynone');
            totalLi = 2;
        };

        var judge2 = $("#number2").hasClass("disabled");
        if(judge2){
            $('#slider').children().eq(1).addClass('displaynone');
            $('#slider').children().eq(2).addClass('displaynone');
            totalLi = 1;
        };

    });
</script>

</body>
</html>