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
    <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
    <div class="pages">
      <!-- Page, data-page contains page name-->
      <div data-page="home" class="page">
        <!-- Scrollable page content-->
        <div class="page-content">
          <div class="invite-friend">
            <div class="invite-friend-inner">
              <div class="invite-top">
                <img class="invite-topimg" src="<c:url value='/resources/image/invite-friend/invite-top.jpg'/>" alt="">
                <div class="invite-inner">

                  <div class="txt">您的好友<span class="inviter">${trueName}</span>邀请您一起成为土豪</div>
                  <div class="invite-code">
                    <div class="btn-code-label" onClick="copyUrl2()">点击右侧复制邀请码</div>
                    <div class="btn-code"><input readonly value="${username}" class="btn-code2" type="text" focus="false"></div>
                  </div>
                  <div class="button btn-register" id="downloadAppBtn">点我注册，百元红包送惊喜</div>
                </div>
              </div>
              <%--<c:if test="${!empty login_sales}">--%>
                <%--有按钮--%>
                <div class="invite-flow displaynone">
                  <img src="<c:url value='/resources/image/invite-friend/invite-flow.jpg'/>" alt="">
                  <a class="see-detail" href="<c:url value='/public/inviteCodeRule'/>">&nbsp;</a>
                </div>
                <%--无按钮--%>
                <div class="invite-flow">
                  <img src="<c:url value='/resources/image/invite-friend/invite-flow-none.jpg'/>" alt="">
                </div>
              <%--</c:if>--%>
            </div>
            <div class="invite-mask">&nbsp;</div>
          </div>

        </div>
      </div>
    </div>

  </div>
</div>
<!-- Path to Framework7 Library JS-->
<script type="text/javascript" src="<c:url value="/resources/script/lib/framework7/js/framework7.js"/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery.js'/>"></script>

<%--调用微信的JS-SDK--%>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script>
//  alert(location.href.split('#')[0]);
  wx.config({
    debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
    appId: '${appId}', // 必填，公众号的唯一标识
    timestamp:${timestamp} , // 必填，生成签名的时间戳
    nonceStr: '${noncestr}', // 必填，生成签名的随机串
    signature: '${signature}',// 必填，签名，见附录1
    jsApiList: ['showAllNonBaseMenuItem']
  });
  wx.ready(function(){
    wx.showAllNonBaseMenuItem();//调用微信接口显示分享按钮
  })
</script>

<script language="javascript" type="text/javascript">
  $(".invite-mask").click(function(){
    $(this).addClass('displaynone');
  });
  $("#downloadAppBtn").click(function(){
    location.href = "<c:url value='/public/downloadApp'/>";
  });
</script>

</body>
</html>