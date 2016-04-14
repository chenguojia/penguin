<!DOCTYPE html>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html xmlns="http://www.w3.org/1999/html">
<head></head>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="apple-mobile-web-app-status-bar-style" content="black">
  <title>卡得万利商业保理</title>
  <link rel="stylesheet" href="<c:url value="/resources/script/lib/framework7/css/framework7.css"/>">
  <link rel="stylesheet" href="<c:url value="/resources/script/lib/bootstrap/css/bootstrap.min.css"/>">
  <link rel="stylesheet" href="<c:url value='/resources/css/wechat.css'/>">

</head>
<body>
<!-- Views-->
<div class="views">
  <!-- Your main view, should have "view-main" class-->
  <div class="view view-main">

    <div class="page-content padding0">
      <div class="tabs">
        <div class="padding0 align-middle">
          <div class="nav-body2 screen-height">
            <div class="xiaoqie-up">
              <img src="<c:url value='/resources/image/xiaoqie-top.jpg'/>">
            </div>
            <div class="iphone-up">
              <a class="xiaoqie-iphone margin-l30 iphoneBtn displaynone" ><img src="<c:url value='/resources/image/iphone.png'/>"></a>
              <a class="xiaoqie-anzhuo margin-l30 androidBtn displaynone"><img src="<c:url value='/resources/image/anzhuo.png'/>"></a>
            </div>
            <div class="xiaoqie-bottom">
              <img src="<c:url value='/resources/image/xiaoqie-bottom.jpg'/>">
            </div>
            <div class="iphone-bottom">
              <a class="margin-l30 iphoneBtn displaynone"><img src="<c:url value='/resources/image/iphone.png'/>"></a>
              <a class="margin-l30 androidBtn displaynone"><img src="<c:url value='/resources/image/anzhuo.png'/>"></a>
            </div>
          </div>

          <div class="modal-penguin-width modal fade top0" role="dialog" aria-labelledby="gridSystemModalLabel" id="myModal-penguin">
            <div class="modal-dialog modal-penguin" role="document">
              <img src="<c:url value='/resources/image/shares.png'/>">
            </div><!-- /.modal-dialog -->
          </div>

        </div>
      </div>

      <div class="android-bottom"></div>

    </div>

  </div>
</div>
<!-- Path to Framework7 Library JS-->
<script type="text/javascript" src="<c:url value="/resources/script/lib/framework7/js/framework7.js"/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery.js'/>"></script>
<script type="text/javascript" src="<c:url value="/resources/script/lib/bootstrap/js/bootstrap.js"/>"></script>
<script>
  var screenHeight=$(document.body).height();
  if(screenHeight>=510 && screenHeight<600){
    $('.screen-height').css('height','1150');
  }
  var ua = navigator.userAgent.toLowerCase();
  if (ua.match(/MicroMessenger/i) == "micromessenger" && ua.indexOf('iphone') > 0) {
//    alert("iPhone 微信浏览器");
    $(".iphoneBtn").show();
    $(".androidBtn").hide();
  } else if (ua.match(/MicroMessenger/i) == "micromessenger" && ua.indexOf('android') > 0) {
//    alert("Android 微信浏览器");
    $(".iphoneBtn").hide();
    $(".androidBtn").show();
  } else if (ua.indexOf('iphone') > 0) { //需对所有 iOS 系统 UA 信息进行判断
//    alert("iPhone 浏览器");
    $(".iphoneBtn").show();
    $(".androidBtn").hide();
  } else if (ua.indexOf('android') > 0) { //需对所有 Android 系统 UA 信息进行判断
//    alert("Android 浏览器");
    $(".iphoneBtn").hide();
    $(".androidBtn").show();
  } else {
    //alert("未识别");
    $(".iphoneBtn").show();
    $(".androidBtn").hide();
  }

  $(".androidBtn").click(function () {
  if (ua.match(/MicroMessenger/i) == "micromessenger" && ua.indexOf('android') > 0) {
       $('#myModal-penguin').modal('toggle');
       $('.android-bottom').addClass('modal-bottom');
       $('.nav-body2').css('height','1150');
  } else {
    location.href = "http://www.cvbaoli.com/app/Tpl/red/download/cardvaluetext.apk";
//       location.href = "http://220.248.19.21:9083/CardvalueService/Download";

  }

  });

  $(".iphoneBtn").click(function () {
    if (ua.match(/MicroMessenger/i) == "micromessenger" && ua.indexOf('iphone') > 0) {
       $('#myModal-penguin').modal('toggle');

    } else {
       location.href = "https://itunes.apple.com/cn/app/id1023284328";
  }
  });

  //点击弹出层，弹出层隐藏
  $('#myModal-penguin').click(function(){
    $('#myModal-penguin').modal('toggle');
  });

  //弹出层出现，禁止scroll
  $('#myModal-penguin').on('show.bs.modal', function (e) {
  $('.page-content').addClass("modal-forbidden");
  });
  //弹出层消失，允许scroll
  $('#myModal-penguin').on('hide.bs.modal', function (e) {
  $('.page-content').removeClass("modal-forbidden");
  });
</script>
</body>
</html>