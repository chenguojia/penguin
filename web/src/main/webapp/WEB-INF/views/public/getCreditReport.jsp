<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=utf8" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="apple-mobile-web-app-status-bar-style" content="black">
  <title>卡得万利商业保理</title>
 <%-- <script type="text/javascript" src="<c:url value='/resources/newm/lib/framework7/js/framework7.js'/>"></script>
  <script type="text/javascript" src="<c:url value="/resources/newm/js/wechatPub.js"/>"></script>
  <link rel="stylesheet" href="<c:url value="/resources/newm/lib/framework7/css/framework7.css"/>" />
  <link rel="stylesheet" href="<c:url value="/resources/newm/css/wechat.css"/>" />--%>
</head>
<body>
<!-- Views-->
<div class="views">
  <!-- Your main view, should have "view-main" class-->
  <div class="view view-main login-background">
    <!-- Top Navbar-->
    <c:if test="${appId=='2'}">
      <div class="navbar login-title">
        <div class="navbar-inner">
          <div class="left"><a href="javascript:history.go(-1)" class="close-img"><img src="<c:url value='/resources/image/left-arror.png'/>"></a></div>
          <div class="center sliding login-title-word" style="left: -112px;">如何获取征信报告</div>
        </div>
      </div>
    </c:if>
    <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
    <div class="pages navbar-through toolbar-through">
      <!-- Page, data-page contains page name-->
      <div data-page="login" class="page get-credit-report-page">
        <!-- Scrollable page content-->
        <div class="page-content get-credit-report-content">
          <div class="content-block login-new credit-report-pages credit-report-pages2">
            <div class="get-credit-report">
              <div class="get-credit-part1">
                <span>一、在人民<span class="get-credit-font1">“银行征信中心”</span>页面申请信用信息地址： <a>http://ipcrs.pbccrc.org.cn</a> （建议电脑/手机浏览器打开）</span>
              </div>
              <div class="get-credit-report-part">
                <div class="get-credit-pics">
                  <img src="<c:url value='/resources/image/getCreditReport.jpg'/>">
                </div>
              </div>
              <div class="credit-middle"></div>
              <div class="clearfix get-credit-part1 credit-bottom-part">
                <span>二、获得<span class="get-credit-font1">“身份证验证码”7日内</span>，进入卡得万利的<span class="get-credit-font1">“征信授权”</span>页面进行授权。如超过7日，则需要登录征信中心，重新申请信用信息，获取新的<span class="get-credit-font1">“身份验证码”</span></span>
              </div>
              <div class="get-credit-pics credit-bottom-part2 credit-font5">
                <div class="credit-font7">特别说明</div>
                <div class="credit-lines"></div>
                <div class="credit-lines lines-font2"></div>
                <div class="credit-font6">
                  <span>此次授权中的个人信用报个查询属于您的本人查询（非机构查询），不会对您的央行个人信用或其他贷款申请产生任何不良影响，请您放心。授权成功后我们将发送央行个人信用报告至您的常用邮箱，请注意查收。</span>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>