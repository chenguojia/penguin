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
    <%--<div class="navbar">--%>
      <%--<!-- Top Navbar-->--%>
      <%--<div class="navbar">--%>
        <%--<div class="navbar-inner">--%>
          <%--<div class="left"><a href="<c:url value='/public/inviteCode'/>" class="back link"> <i class="icon icon-back card-back"></i></a></div>--%>
          <%--<div class="center sliding">邀请活动规则</div>--%>
        <%--</div>--%>
      <%--</div>--%>
    <%--</div>--%>
    <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
    <div class="pages navbar-through toolbar-through">
      <!-- Page, data-page contains page name-->
      <div class="page" style="background-color:#fcb946;">
        <!-- Scrollable page content-->
        <div class="page-content">
          <div class="invite-rules">
            <img src="<c:url value='/resources/image/invite-friend/invite-rule.jpg'/>">
          </div>
        </div>
      </div>
    </div>

  </div>
</div>
<!-- Path to Framework7 Library JS-->
<script type="text/javascript" src="<c:url value="/resources/script/lib/framework7/js/framework7.js"/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery.js'/>"></script>
<script>

</script>
</body>
</html>