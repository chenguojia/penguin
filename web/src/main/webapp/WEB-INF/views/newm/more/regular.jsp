<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/9/28
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
</head>
<body>
<!-- Views-->
<div class="views" style="position:absolute; margin:0; padding:0; border:0; top:0;">
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
        <div class="page-content regular-back2">
          <div class="list-block media-list myaccount regular-pic">
            <div><img src="<c:url value='/resources/image/regular-top2.jpg'/>"></div>
          </div>
          <div class="regular-font1">
            <div class="regular-font2">红包规则：</div>
            <ul class="regular-font3">
              <li>注册成功即得50元新手返现券1张</li>
              <li>邀请五位好友注册成功，额外再得好友返现券共计500元</li>
              <div class="padding-l4">成功邀请第一位，可得50元返现券1张</div>
              <div class="padding-l4">成功邀请第二位，可得50元返现券2张</div>
              <div class="padding-l4">成功邀请第三、四位，各可得100元返现券1张</div>
              <div class="padding-l4">成功邀请第五位，可得100元和50元返现券各1张</div>
              <li>受邀者使用邀请码(邀请码为手机账号)注册成功，即视为邀请成功</li>
              <li>新手返现券在注册成功后即刻发放，好友返现券在受邀者注册成功后发放</li>
              <li>本规则最终解释权归卡得万利商业保理有限公司所有</li>
            </ul>
            <div class="regular-font2 regular-padding-top">优惠券发放规则：</div>
            <ul class="regular-font3">
              <li>用户在提交保理融资申请时可使用返现券，每张返现券只可使用一次</li>
              <li>根据用户融资金额范围，可使用相应张数的返现券</li>
              <li>成功使用返现券后，在用户保理融资放款时，返现金额以现金方式发至用户银行账户中</li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">
  var myApp = new Framework7({
    modalTitle: '卡得万利商业保理',
    ajaxLinks: 'a.ajax'
  });

</script>
</body>
</html>
