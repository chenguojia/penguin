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
    <!-- Top Navbar-->
    <div class="navbar login-title displaynone">
      <div class="navbar-inner">
        <div class="left"><a href="#" class="close-img"><img src="<c:url value='/resources/image/left-arror.png'/>"></a></div>
        <div class="center sliding login-title-word">活动规则</div>
      </div>
    </div>
    <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
    <div class="pages navbar-through toolbar-through">
      <!-- Page, data-page contains page name-->
      <div data-page="index" class="page">
        <!-- Scrollable page content-->
        <div class="page-content regular-back">
          <div class="invite-friend">
            <div class="invite-friend-inner">
              <div class="invite-top">
                <img class="invite-topimg" src="<c:url value='/resources/image/invite-friend/invite-top-new.jpg'/>" alt="">
                <div class="invite-inner-new">
                  <div class="txt">您的好友<span class="inviter">${trueName}</span>邀请您一起成为土豪</div>
                  <div class="invite-code">
                    <div class="btn-code-label">复制右侧邀请码</div>
                    <div class="btn-code">${username}</div>
                  </div>
                  <div class="button btn-register" id="downloadAppBtn">点我注册，百元红包送惊喜</div>
                </div>
              </div>

            </div>
          </div>
        </div>

        <div class="inviteCode-cover">
          <img src="<c:url value='/resources/image/share-cover.png'/>">
        </div>
      </div>
    </div>
  </div>
</div>
<!-- Path to Framework7 Library JS-->
<script type="text/javascript" src="<c:url value="/resources/script/lib/framework7/js/framework7.js"/>"></script>
<script type="text/javascript" src="<c:url value='/resources/script/wechat.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery.js'/>"></script>

<%--调用微信的JS-SDK--%>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>

<script language="javascript" type="text/javascript">

  var screenHeight = $(window).height();
  $('.inviteCode-cover').css('height',screenHeight+'px');
  $('.inviteCode-cover').click(function(){
    $(this).addClass('displaynone');
  })
   wx.config({
     debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
     appId: '${appId}', // 必填，公众号的唯一标识
     timestamp:${timestamp} , // 必填，生成签名的时间戳
     nonceStr: '${noncestr}', // 必填，生成签名的随机串
     signature: '${signature}',// 必填，签名，见附录1
     jsApiList: ['showAllNonBaseMenuItem','onMenuShareTimeline']
   });

    wx.ready(function(){
        wx.showAllNonBaseMenuItem();

        wx.onMenuShareTimeline({
          title: '卡得万利商业保理', // 分享标题
          link: 'http://www.cvbaoli.com/webak/public/inviteCode2', // 分享链接
          imgUrl: 'http://www.cvbaoli.com/webak/resources/image/invite-friend/invite-top-new.jpg', // 分享图标

          success: function () {
            location.href="<c:url value="/info/inviteRecord"/>";
            myApp.alert("分享成功","提示")
            // 用户确认分享后执行的回调函数
          },

          cancel: function () {
            // 用户取消分享后执行的回调函数
//            alert("取消分享")
          }
        });
    });

  $("#downloadAppBtn").click(function(){
    location.href = "<c:url value='/public/downloadApp'/>";
  });
</script>
</body>
</html>