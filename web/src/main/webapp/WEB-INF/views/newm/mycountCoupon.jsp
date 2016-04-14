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
<div class="views" >
  <!-- Your main view, should have "view-main" class-->
  <div class="view view-main login-background">
    <div class="home-page-backs displaynone">
      <div></div>
    </div>
    <!-- Top Navbar-->
    <div class="navbar login-title">
      <div class="navbar-inner">
        <div class="left"><a href="<c:url value="/new/m/account"/>" class="close-img"><img src="<c:url value="/resources/image/left-arror.png"/>"></a></div>
        <div class="center sliding login-title-word hong-bao-top-center">我的红包</div>
        <div class="right"><a href="<c:url value="/new/m/more/regular2?isApp=1"/>" class="help"><img src="<c:url value="/resources/image/help.png"/>"></a></div>
      </div>

      <div class="navbar-part2">
        <div class="float_l hongbao-numbers">
          <div class="icons hongbao-button-content" id="icons">
            <div class="float_l hongbao-button-font1 hongbao-button-font2">
              <span>优惠券</span>
            </div>
            <div class="float_l hongbao-button-font1">
              <span>现金券</span>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
    <div class="pages navbar-through toolbar-through" id="pages-contents">

      <div class="hongbao-message-box-content displaynone" id="textContent">
        <input type="hidden" id="couponId" value="">
        <div class="hongbao-message-part1">卡得万利商业保理</div>
        <div class="hongbao-message-font1">请输入您的真实姓名和银行卡号！</div>
        <div class="hongbao-message-font2">注：系统默认带出您已填写的信息，如果发生变更您可以进行修改。</div>
        <div class="hongbao-message-part2"><input id="ownerName" value="${login_new_merchant.ownerName}" class="hongbao-message-font3" placeholder="请输入姓名"></div>
        <div class="hongbao-message-part2"><input id="cardNo" class="hongbao-message-font3" placeholder="请输入银行卡号"></div>
        <div class="hongbao-message-part3"><button class="btn hongbao-message-btn1" id="exchangeBtn">确定</button><button id="cancelBtn" class="btn hongbao-message-btn1">取消</button></div>
      </div>

      <div class="back-ttps displaynone" id="back-ttps"></div>

      <!-- Page, data-page contains page name-->
      <div class="m-slider m-slider-hongbao">
        <ul class="cnt" id="slider-hongbao">
          <li class="cnt-li" style="background-color: #f1f1f1;" id="homePageScroll1">
            <div class="slider-page1-content">
              <%--<div class="bride bride-hongbao">
                <div class="hongbao-include"><span class="glyphicon glyphicon-ok-sign hongbao-include-font1"></span></div>
                <div class="hongbao-font1"><span class="bride-font2">￥</span><span class="bride-font3">10.00</span></div>
                <div class="bride-font5"><span class="bride-font6">新手注册得10元红包</span><span class="hongbao-font4">未使用</span></div>
              </div>--%>
              <c:forEach var="item" items="${coupons0}">
                <div class="bride">
                  <input type="hidden" name="couponId" value="${item.id}">
                  <input type="hidden" name="couponType" value="${item.type}">
                    <%--<div class="hongbao-include"><span class="glyphicon glyphicon-ok-sign hongbao-include-font2"></span></div>--%>
                  <div class="hongbao-include"><span class="glyphicon hongbao-include-font2"></span></div>
                  <div class="hongbao-font1"><span class="bride-font2">￥</span><span class="bride-font3">${item.amount}</span></div>
                  <div class="bride-font5"><span class="bride-font6">${item.memo}</span><span class="hongbao-font4">未使用</span></div>
                </div>
              </c:forEach>
              <%--<div class="bride bride-hongbao-youhuiquan-used">
                <div class="hongbao-include"><span class="glyphicon glyphicon-ok-sign hongbao-include-used"></span></div>
                <div class="hongbao-font1 hongbao-used"><span class="bride-font2">￥</span><span class="bride-font3">10.00</span></div>
                <div class="bride-font5"><span class="bride-font6">新手注册得10元红包</span><span class="hongbao-font4 hongbao-used">已使用</span></div>
              </div>--%>
            </div>
          </li>


          <li class="cnt-li" style="background-color: #f1f1f1;" id="homePageScroll2">
            <div class="slider-page1-content">
             <%-- <div class="bride bride-hongbao-cash-using">
                <div class="hongbao-include"><span class="glyphicon glyphicon-ok-sign hongbao-include-font1"></span></div>
                <div class="hongbao-font1"><span class="bride-font2">￥</span><span class="bride-font3">10.00</span></div>
                <div class="bride-font5"><span class="bride-font6">新手注册得10元红包</span><span class="hongbao-font4">未使用</span></div>
              </div>--%>
               <c:forEach var="item" items="${coupons1}">
                   <div class="bride bride-hongbao-cash ">
                     <input type="hidden" name="couponId" value="${item.id}">
                     <input type="hidden" name="couponType" value="${item.type}">
                       <%--<div class="hongbao-include"><span class="glyphicon glyphicon-ok-sign hongbao-include-font2"></span></div>--%>
                     <div class="hongbao-include"><span class="glyphicon hongbao-include-font2"></span></div>
                     <div class="hongbao-font1"><span class="bride-font2">￥</span><span class="bride-font3">${item.amount}</span></div>
                     <div class="bride-font5"><span class="bride-font6">${item.memo}</span><span class="hongbao-font4">未使用</span></div>
                   </div>
               </c:forEach>
             <%-- <div class="bride bride-hongbao-cash-used">
                <div class="hongbao-include"><span class="glyphicon glyphicon-ok-sign hongbao-include-used"></span></div>
                <div class="hongbao-font1 hongbao-used"><span class="bride-font2">￥</span><span class="bride-font3">10.00</span></div>
                <div class="bride-font5"><span class="bride-font6">新手注册得10元红包</span><span class="hongbao-font4 hongbao-used">已使用</span></div>
              </div>--%>
            </div>
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

  $("#liDiscountCoupon").click(function(){
    $("#uploca")
  });


  $('#icons .hongbao-button-font1').click(function(){
    $(this).addClass('hongbao-button-font2').siblings().removeClass('hongbao-button-font2');
  });

  var scrollCurrent = 0;
  var contentHeight = $('.slider-page1-content').height();

  var screenWidth = $(window).width();
  var clickNumber = 0;
  var ccds;
  var i =0;
  var $btn = $('.hongbao-button-font1');
  var menuLeft = document.getElementById( 'cbp-spmenu-s1' ), showLeft = document.getElementById( 'showLeft'), pagesidden = document.getElementById( 'pages-contents');
  var $back = document.getElementById('back-ttps');
  var $sliderLi = document.getElementById('slider-hongbao');
  var closeImgClickNum = 0;

  $btn.each(function(index) {
    $(this).click(function(){
      document.getElementById('slider-hongbao').style.left = -screenWidth*index + 'px';
      $(this).addClass('hongbao-button-font2').siblings().removeClass('hongbao-button-font2');
      clickNumber = index;
    });
  });

  $(function() {
    $("#slider-hongbao li").swipe( {
      swipeStatus:function(event, phase, direction, distance, duration,fingerCount) {
        var totalLi = $('#slider-hongbao').children().length;
        var currentLi = $(this).index() +1;
        var screenNumbers = $(this).index();
        if(phase == 'move' && direction == 'left' && currentLi < totalLi){
          $('#slider-hongbao').css('left',- screenNumbers*screenWidth - distance + 'px')
        }
        else if(phase == 'move' && direction == 'right' && currentLi > 1){
          $('#slider-hongbao').css('left',- screenNumbers*screenWidth + distance + 'px')
        }
//                向左滑动
        else if(phase == 'end' && direction == 'left' && currentLi < totalLi && distance > 100){
          $('#slider-hongbao').css('left',- currentLi*screenWidth + 'px')
          $('#icons .hongbao-button-font1').eq(currentLi).addClass('hongbao-button-font2').siblings().removeClass('hongbao-button-font2');
        }
//                向右滑动
        else if(phase == 'end' && direction == 'right' && currentLi > 1 && distance > 100){
          $('#slider-hongbao').css('left',- (screenNumbers-1)*screenWidth + 'px')
          $('#icons .hongbao-button-font1').eq(screenNumbers-1).addClass('hongbao-button-font2').siblings().removeClass('hongbao-button-font2');
        }
        else if(distance <= 100){
          $('#slider-hongbao').css('left',- screenNumbers*screenWidth + 'px')
        };
      }
    });

    var cntLength = $('.cnt').children('li').length;
    var cntWidth = cntLength * 100;
    var cntLiWidth = 100 / cntLength;
    var cntScrollWidth = cntLength * 100 / 3.5;
    $('.m-slider-hongbao .cnt').css('width', cntWidth + '%');
    $('.m-slider-hongbao .cnt li.cnt-li').css('width', cntLiWidth + '%');
    $('.home-page-button-content2').css('width', cntScrollWidth + '%');
  });



  $(function(){


    $(".bride").click(function(){
      $(this).addClass("Current");
      var couponId = $(this).find("input[name=couponId]").val();
      var couponType = $(this).find("input[name=couponType]").val();

      if(couponType == '0' || couponType == 0){
        myApp.alert("优惠券只能在提交融资申请时使用！","提示信息");
        return false;
      }else if(couponType == '1' || couponType == 1){
        $("#textContent").removeClass("displaynone");
        $("#couponId").val(couponId);
      }

    });

    $("#cancelBtn").click(function(){
      $("#textContent").addClass("displaynone");
    })

    $("#exchangeBtn").click(function(){
      var ownerName = $("#ownerName").val();
      var cardNo = $("#cardNo").val();
      if(ownerName==''){
        myApp.alert("请输入姓名！","提示");
        return;
      }
      if(cardNo==''){
        myApp.alert("请输入银行卡号！","提示");
        return;
      }
      $.ajax({
        type:'POST',
        async:true,
        url:"<c:url value="/coupon/exchangeCoupons"/>",
        data:{ownerName:ownerName,cardNo:cardNo,couponId:$("#couponId").val()},
        success:function(data){
          myApp.alert(data.message,"提示");
          $("#textContent").addClass("displaynone");
          $(".Current").hide();
          $('#slider-hongbao').css('left',- screenWidth + 'px')
          $('#icons .hongbao-button-font1').eq(1).addClass('hongbao-button-font2').siblings().removeClass('hongbao-button-font2');
        }
      });
    })

  });



</script>

</body>
</html>