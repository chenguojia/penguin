<%--
  Created by IntelliJ IDEA.
  User: guojia.chen
  Date: 2016/1/25
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="apple-mobile-web-app-status-bar-style" content="black">
  <title>卡得万利商业保理</title>

</head>
<body>
<!-- Views-->
<div class="views">
  <!-- Your main view, should have "view-main" class-->
  <div class="view view-main">
    <!-- Top Navbar-->
    <div class="navbar login-title">
      <div class="navbar-inner">
        <div class="left"><a href="<c:url value="/new/m/account"/>" class="close-img"><img src="<c:url value="/resources/image/left-arror.png"/>"></a></div>
        <div class="center sliding login-title-word">二维码</div>
      </div>
    </div>
    <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
    <div class="pages navbar-through toolbar-through">
      <!-- Page, data-page contains page name-->
      <div data-page="index" class="page">
        <!-- Scrollable page content-->
        <div class="page-content">
          <div class="dimension-code-content">
            <div class="dimension-code-part1">
              <div class="dimension-code-font1">小企额，融资神器</div>
              <div class="dimension-code-font2">扫描下面二维码邀请商户注册</div>
              <div class="dimension-code-font3"><img src="<c:url value="/resources/image/codes.png"/>"></div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

</body>
</html>
