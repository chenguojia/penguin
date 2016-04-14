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
<!-- Views-->
<div class="views">
  <!-- Your main view, should have "view-main" class-->
  <div class="view view-main login-background">
    <div class="home-page-backs displaynone">
      <div></div>
    </div>
    <!-- Top Navbar-->
    <div class="navbar login-title" id="address-displaynone">
      <div class="navbar-inner new-navbar">
        <div class="left new-homepage"><a href="#" class="close-img"><img src="<c:url value="/resources/image/image20/left-pannnal.png"/>" id="showLeft"> </a></div>
        <div class="center sliding login-title-word" id="show">商铺信息</div>
        <div class="right">
          <a href="#" class="close-img new-close"><img src="<c:url value="/resources/image/image20/messages.png"/>"> </a>
        </div>
      </div>

      <input id="step" value="${step}" name="step" type="hidden">
      <div class="navbar-part2">
        <div class="float_l home-page-numbers">
          <div class="icons home-page-button-content" id="icons">
            <div class="home-page-button-content2">
              <%--1. 表示全新商户第一次进入，则显示1个按钮 “填写基础资料”--%>
              <c:if test="${(empty applicationModel.creditId || empty applicationModel.amountRequested ||  applicationModel.amountRequested < 1)}">

              </c:if>
              <span id="number1" class="btn home-numbers-button home-button-border disabled">第1步</span>
              <span id="number2" class="btn home-numbers-button disabled">第2步</span>
              <span id="number3" class="btn home-numbers-button disabled">第3步</span>
              <c:if test="${!(empty applicationModel.creditId || empty applicationModel.amountRequested ||  applicationModel.amountRequested < 1)}">
                <span id="number2" class="btn home-numbers-button">第2步</span>
              </c:if>

              <c:if test="${applicationModel.cashadvanceStatus == '批准'}">
                <span id="number3" class="btn home-numbers-button">第3步</span>
              </c:if>

              <c:if test="${applicationModel.cashadvanceStatus == '待补件'}">
                <span id="number4" class="btn home-numbers-button">第4步</span>
              </c:if>
              <c:if test="${applicationModel.cashadvanceStatus == '关闭'}">
                <span id="number5" class="btn home-numbers-button">第5步</span>
              </c:if>


              <%--

                <span id="number6" class="btn home-numbers-button">第6步</span>--%>
              <ds class="home-font2 displaynone">切换步骤</ds>

            </div>
          </div>
        </div>
        <div class="float_l home-page-closes" id="closeStep">
          <img class="rotate45" src="<c:url value="/resources/image/icon/close.png"/>">
        </div>
        <div class="home-page-opacity"></div>
        <div class="home-page-click-steps displaynone">

          <%--1. 表示全新商户第一次进入，则显示1个按钮 “填写基础资料”--%>
          <span class="btn home-numbers-button-font1 button-font1-act">第1步</span>
          <span class="btn home-numbers-button-font1 disabled">第2步</span>
          <span class="btn home-numbers-button-font1 disabled">第3步</span>
          <c:if test="${!(empty applicationModel.creditId || empty applicationModel.amountRequested ||  applicationModel.amountRequested < 1)}">
            <span class="btn home-numbers-button-font1">第2步</span>
          </c:if>
          <c:if test="${applicationModel.cashadvanceStatus == '批准'}">
            <span class="btn home-numbers-button-font1">第3步</span>
          </c:if>
          <c:if test="${applicationModel.cashadvanceStatus == '待补件'}">
            <span class="btn home-numbers-button-font1">第4步</span>
          </c:if>

          <c:if test="${applicationModel.cashadvanceStatus == '关闭'}">
            <span class="btn home-numbers-button-font1">第5步</span>
          </c:if>
          <%--
           <span class="btn home-numbers-button-font1">第6步</span>--%>

        </div>
        <div class="home-back-black displaynone"></div>
      </div>


    </div>
    <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
    <div class="pages navbar-through toolbar-through" id="pages-contents">

      <div class="home-pannel-left cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
        <div class="left-total">
          <div class="home-left-part1">
            <div class="float_l part1-font1">
              <img src="<c:url value="/resources/image/my-Shops.png"/>">
            </div>
            <div class="float_l part1-font2">我爱我家</div>
          </div>
          <div class="left-shop-names">
            <div class="left-pannel-circle">
              <div class="left-circle-font1">参考额度</div>
              <div class="left-circle-font2">10000<span class="left-circle-font3">元</span></div>
            </div>
            <div class="left-shop-part2">
              <span>审核中</span>
            </div>
          </div>
          <div class="left-shop-footer">
            <span class="btn left-shop-names-button" id="addShop"><img  src="<c:url value="/resources/image/onlineContact.png"/>"><span class="left-footer-font1">添加商铺</span></span>
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
            <div class="slider-page1-content">
              <%--1、基础资料、商铺信息--%>
              <%@ include file="basicLimit.jsp" %>
            </div>
          </li>
          <li class="cnt-li" id="homePageScroll2">
            <%--2、填写申请--%>
            <%@ include file="uploadFile.jsp" %>
            <%--<%@ include file="addFile.jsp" %>--%>
          </li>
          <li class="cnt-li" id="homePageScroll3">
            <div class="slider-page1-content">
              <%--融资方案【提现确认】,确认之后跳转到银行卡绑定界面--%>
              <c:if test="${applicationModel.cashadvanceStatus == '批准'}">
                <%@ include file="financingConfirm.jsp" %>
              </c:if>
              <%--待补件【补全资料】--%>
              <c:if test="${applicationModel.cashadvanceStatus == '待补件'}">
                <%@ include file="addFile.jsp" %>
              </c:if>
              <%--还款清算【融资保理通知书】--%>
              <c:if  test="${applicationModel.cashadvanceStatus == '还款清算'}">
                <%@ include file="notification.jsp" %>
              </c:if>
              <%--关闭--%>
              <c:if test="${applicationModel.cashadvanceStatus == '关闭'}">
                <%--查看申请状态--%>
                <%@ include file="apply-status.jsp" %>
              </c:if>
            </div>
          </li>
          <%-- <li class="cnt-li" id="homePageScroll4">
               <div class="slider-page1-content">
                   &lt;%&ndash;4、绑定银行卡 对公&ndash;%&gt;
                   <%@ include file="bankBind.jsp" %>
                   &lt;%&ndash;绑定银行卡 对私&ndash;%&gt;
                   &lt;%&ndash;<%@ include file="bankBind2.jsp" %>&ndash;%&gt;
               </div>

           </li>
           <li class="cnt-li" id="homePageScroll5">
               <div class="slider-page1-content">
                   &lt;%&ndash;4、融资保理通知书&ndash;%&gt;
                   <%@ include file="notification.jsp" %>
               </div>
           </li>
           <li class="cnt-li" id="homePageScroll6">
               <div class="slider-page1-content">
                   &lt;%&ndash;6、申请信息&ndash;%&gt;
                   <%@ include file="applyInfomation.jsp" %>
               </div>
           </li>--%>
        </ul>

      </div>
    </div>

    <div class="toolbar tabbar tabbar-labels">
      <div class="toolbar-inner">
        <a href="<c:url value='/new/m/home'/>" class="tab-link">
          <i class="icon money-icon"><span class="badge bg-red">1</span></i>
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


<script type="text/javascript" src="<c:url value="/resources/js/classie.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/modernizr.custom.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.touchSwipe.min.js"/>"></script>
<script type="text/javascript">
  $(function(){
    var step = $("#step").val();
    if(step==1 || step=="1"){
      $("#number1").removeClass("disabled");
    }
  });
  //添加商铺
  $("#addShop").click(function () {
    location.href = "<c:url value="/new/m/home"/>";
  });

  //意见反馈
  $("#left-online-comments").click(function(){
    location.href = "<c:url value="/new/m/more/comments"/>";
  });

  $("#number1").click(function () {
    $("#show").text("商铺信息");
  });
  $("#number2").click(function () {
    $("#show").text("填写申请");
  });
  $("#number3").click(function () {
    $("#show").text("融资保理通知书");
  });
  $("#number4").click(function () {
    $("#show").text("银行卡绑定");
  });
  $("#number5").click(function () {
    $("#show").text("融资方案");
  });
  $("#number6").click(function () {
    $("#show").text("申请信息");
  });

  $('.home-page-button-content button').click(function(){
    $(this).addClass('home-button-border').siblings().removeClass('home-button-border');
  });
</script>

<script type="text/javascript">
  $(document).ready(function(){
    var cntLength = $('.cnt').children('li').length;
    var cntWidth = cntLength * 100;
    var cntLiWidth = 100 / cntLength;
    var cntScrollWidth = cntLength * 100 / 3.5;
    $('.m-slider .cnt').css('width', cntWidth + '%');
    $('.m-slider .cnt li.cnt-li').css('width', cntLiWidth + '%');
    $('.home-page-button-content2').css('width', cntScrollWidth + '%');
  });

  var scrollCurrent = 0;
  var contentHeight = $('.slider-page1-content').height();
  var screenWidth = $(window).width();
  var clickNumber = 0;
  var ccds;
  var i =0;
  var $btn = $('.home-page-button-content span');
  var $btn2 = $('.home-page-click-steps span');
  var menuLeft = document.getElementById( 'cbp-spmenu-s1' ), showLeft = document.getElementById( 'showLeft'), pagesidden = document.getElementById( 'pages-contents');
  var $back = document.getElementById('back-ttps');
  var $sliderLi = document.getElementById('slider');
  var closeImgClickNum = 0;

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

  $('#closeStep').click(function () {
    closeImgClickNum++;
    var closeDisplay = $('.home-back-black').css('display');
    $('.home-page-click-steps').slideToggle();
    $('.home-back-black').toggle();
    $('#icons span').toggle();
    $('.home-font2').toggle();
    if (closeDisplay === 'none') {
      $('#closeStep img').removeClass('rotate45').addClass('home-page-scroll');
      $('.home-page-button-content').scrollLeft(0);
    }
    else {
      $('#closeStep img').removeClass('home-page-scroll').addClass('rotate45');
      $('.home-page-button-content').scrollLeft(scrollDis);
    }
    ;
  });

  $('.home-back-black').click(function(){
    $('.home-page-click-steps').slideToggle();
    $('.home-back-black').toggle();
    $('#icons span').toggle();
    $('.home-font2').toggle();
    $('#closeStep img').removeClass('home-page-scroll').addClass('rotate45');
  });


  showLeft.onclick = function() {
    classie.toggle( showLeft, 'active' );
    $('#slider').css('left', '240px');
    $('.navbar.login-title').css('left', '240px');
    classie.add( menuLeft, 'cbp-spmenu-open' );
    classie.remove( $back, 'displaynone' );
  };
  $back.onclick = function() {
    classie.remove( showLeft, 'active' );
    $('#slider').css('left', '0px');
    $('.navbar.login-title').css('left', '0px');
    classie.remove( menuLeft, 'cbp-spmenu-open' );
    classie.add( $back, 'displaynone' );
  };
  $sliderLi.onclick = function() {
    classie.remove( showLeft, 'active' );
    $('.navbar.login-title').css('left', '0px');
    classie.remove( menuLeft, 'cbp-spmenu-open' );
    classie.add( $back, 'displaynone' );
  };

  $(document).ready(function(){

    var ddeesdd = $('.navbar-inner').css('display');

    $('#homePageScroll1').scroll(function(){
      if(ddeesdd == 'flex'){
        var scrollLength = $(".m-slider .cnt li.cnt-li").scrollTop();
        var scrollResult = scrollLength / contentHeight;
        var scrollLength2 = $('#ddcsss2').scrollTop();
        if(scrollLength > scrollCurrent && scrollResult < 0.5){
          if(scrollLength> 20){
            $('.navbar-inner.new-navbar').slideUp();
            $('.toolbar.tabbar').slideUp();
            setTimeout(function () {
              $('.navbar-part2').addClass('hide-top');
            }, 250);
          };
        }
        else if(scrollLength < scrollCurrent){
          $('.navbar-inner.new-navbar').slideDown();
          $('.toolbar.tabbar').slideDown();
          $('.navbar-part2').removeClass('hide-top');

        }
      }
      scrollCurrent = scrollLength;
    });

    $('#homePageScroll2').scroll(function(){
      if(ddeesdd == 'flex'){
        var scrollLength = $("#homePageScroll2").scrollTop();
        var scrollResult = scrollLength / contentHeight;
        if(scrollLength > scrollCurrent && scrollResult < 0.5){
          if(scrollLength> 20){
            $('.navbar-inner.new-navbar').slideUp();
            $('.toolbar.tabbar').slideUp();
            setTimeout(function () {
              $('.navbar-part2').addClass('hide-top');
            }, 250);
          };
        }
        else if(scrollLength < scrollCurrent){
          $('.navbar-inner.new-navbar').slideDown();
          $('.toolbar.tabbar').slideDown();
          $('.navbar-part2').removeClass('hide-top');

        }
      }
      scrollCurrent = scrollLength;
    });

    $('#homePageScroll3').scroll(function(){
      if(ddeesdd == 'flex'){
        var scrollLength = $("#homePageScroll3").scrollTop();
        var scrollResult = scrollLength / contentHeight;
        if(scrollLength > scrollCurrent && scrollResult < 0.5){
          if(scrollLength> 20){
            $('.navbar-inner.new-navbar').slideUp();
            $('.toolbar.tabbar').slideUp();
            setTimeout(function () {
              $('.navbar-part2').addClass('hide-top');
            }, 250);
          };
        }
        else if(scrollLength < scrollCurrent){
          $('.navbar-inner.new-navbar').slideDown();
          $('.toolbar.tabbar').slideDown();
          $('.navbar-part2').removeClass('hide-top');

        }
      }
      scrollCurrent = scrollLength;
    });

    $('#homePageScroll4').scroll(function(){
      if(ddeesdd == 'flex'){
        var scrollLength = $("#homePageScroll4").scrollTop();
        var scrollResult = scrollLength / contentHeight;
        if(scrollLength > scrollCurrent && scrollResult < 0.5){
          if(scrollLength> 20){
            $('.navbar-inner.new-navbar').slideUp();
            $('.toolbar.tabbar').slideUp();
            setTimeout(function () {
              $('.navbar-part2').addClass('hide-top');
            }, 250);
          };
        }
        else if(scrollLength < scrollCurrent){
          $('.navbar-inner.new-navbar').slideDown();
          $('.toolbar.tabbar').slideDown();
          $('.navbar-part2').removeClass('hide-top');

        }
      }
      scrollCurrent = scrollLength;
    });
    $('#homePageScroll5').scroll(function(){
      if(ddeesdd == 'flex'){
        var scrollLength = $("#homePageScroll5").scrollTop();
        var scrollResult = scrollLength / contentHeight;
        if(scrollLength > scrollCurrent && scrollResult < 0.5){
          if(scrollLength> 20){
            $('.navbar-inner.new-navbar').slideUp();
            $('.toolbar.tabbar').slideUp();
            setTimeout(function () {
              $('.navbar-part2').addClass('hide-top');
            }, 250);
          };
        }
        else if(scrollLength < scrollCurrent){
          $('.navbar-inner.new-navbar').slideDown();
          $('.toolbar.tabbar').slideDown();
          $('.navbar-part2').removeClass('hide-top');

        }
      }
      scrollCurrent = scrollLength;
    });

    $('#homePageScroll6').scroll(function(){
      if(ddeesdd == 'flex'){
        var scrollLength = $("#homePageScroll6").scrollTop();
        var scrollResult = scrollLength / contentHeight;
        if(scrollLength > scrollCurrent && scrollResult < 0.5){
          if(scrollLength> 20){
            $('.navbar-inner.new-navbar').slideUp();
            $('.toolbar.tabbar').slideUp();
            setTimeout(function () {
              $('.navbar-part2').addClass('hide-top');
            }, 250);
          };
        }
        else if(scrollLength < scrollCurrent){
          $('.navbar-inner.new-navbar').slideDown();
          $('.toolbar.tabbar').slideDown();
          $('.navbar-part2').removeClass('hide-top');

        }
      }
      scrollCurrent = scrollLength;
    });
  });




  $(function() {
    $("#slider li").swipe( {
      swipeStatus:function(event, phase, direction, distance, duration,fingerCount) {
        var totalLi = $('#slider').children().length;
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
          $('#slider').css('left',- currentLi*screenWidth + 'px')
          $('.home-page-button-content span').eq(currentLi).addClass('home-button-border').siblings().removeClass('home-button-border');
          $('.home-page-click-steps span').eq(currentLi).addClass('button-font1-act').siblings().removeClass('button-font1-act');
          if(currentLi > 3){
            var scrollDis = currentLi * 50;
            $('.home-page-button-content').scrollLeft(scrollDis);
          }
        }
//                向右滑动
        else if(phase == 'end' && direction == 'right' && currentLi > 1 && distance > 100){
          $('#slider').css('left',- (screenNumbers-1)*screenWidth + 'px')
          $('.home-page-button-content span').eq(screenNumbers-1).addClass('home-button-border').siblings().removeClass('home-button-border');
          $('.home-page-click-steps span').eq(screenNumbers-1).addClass('button-font1-act').siblings().removeClass('button-font1-act');
          if(currentLi < 4){
            $('.home-page-button-content').scrollLeft(0);
          }
        }
//                滚动
        else if(direction == 'up' ){
          var scrollupDistance = $("li.cnt-li").scrollTop();
          $('li.cnt-li').scrollTop(scrollupDistance + distance);
        }
        else if(direction == 'down'){
          var scrolldownDistance = $("li.cnt-li").scrollTop();
          $('li.cnt-li').scrollTop(scrolldownDistance - distance);
        }
        else if(currentLi === 1 && direction == 'right' && distance > 20){
          $('#slider').css('left', '240px');
          $('.navbar.login-title').css('left', '240px');
          classie.add( menuLeft, 'cbp-spmenu-open');
          classie.remove( $back, 'displaynone' );
        }
        else{
          $('#slider').css('left',- screenNumbers*screenWidth + 'px')
        };
      }
    });


  });
</script>


</body>
</html>
