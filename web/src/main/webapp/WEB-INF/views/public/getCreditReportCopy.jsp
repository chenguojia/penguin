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



  <link rel="stylesheet" href="<c:url value="/resources/script/lib/framework7/css/framework7.css"/>">
  <link rel="stylesheet" href="<c:url value='/resources/css/wechat.css'/>">
  <script type="text/javascript" src="<c:url value="/resources/js/jquery.js"/>"></script>
  <script type="text/javascript" src="<c:url value='/resources/js/wechatPub.js'/>"></script>
  <script type="text/javascript" src="<c:url value="/resources/script/lib/framework7/js/framework7.js"/>"></script>
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
          <div class="left"><a href="javascript:history.go(-1)" class="close-img"><img src="<c:url value='/resources/newm/images/icon/left-arror.png'/>"></a></div>
          <div class="center sliding login-title-word" style="left: -112px;">如何获取征信报告</div>
        </div>
      </div>
    </c:if>

    <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
    <div class="pages navbar-through toolbar-through">
      <!-- Page, data-page contains page name-->
      <div data-page="login" class="page login-backs2">
        <!-- Scrollable page content-->
        <%--有标题--%>
        <c:if test="${appId=='2'}">
        <div class="page-content get-credit-report-content">
        </c:if>
        <%--无标题--%>
        <c:if test="${appId=='1'}">
        <div class="page-content get-credit-report-content without-title">
        </c:if>
          <div class="content-block login-new credit-report-pages">
            <div class="get-credit-report">
              <div class="get-credit-part1">
                <span>一、在人民<span class="get-credit-font1">“银行征信中心”</span>页面申请信用信息地址：<a>http://ipcrs.pbccrc.org.cn</a>（建议电脑/手机浏览器打开）</span>
              </div>
              <div class="get-credit-report-part">
                <div>
                  <span class="get-credit-font2">01</span>
                  <span class="get-credit-font3">进入征信中心，完成注册后立即登录</span>
                </div>
                <div class="get-credit-pics">
                  <img src="<c:url value="/resources/image/step1.png"/>">
                </div>
              </div>
              <div class="get-credit-report-part report-part-steps">
                <div>
                  <span class="get-credit-font2">02</span>
                  <span class="get-credit-font3">进入新手导航，点击“下一步”</span>
                </div>
                <div class="get-credit-pics">
                  <img src="<c:url value="/resources/image/step2.png"/>">
                </div>
              </div>
              <div class="get-credit-report-part report-part-steps">
                <div>
                  <span class="get-credit-font2">03</span>
                  <span class="get-credit-font3">选择问题验证后，点击“下一步”</span>
                </div>
                <div class="get-credit-pics">
                  <img src="<c:url value="/resources/image/setp3.png"/>">
                </div>
              </div>
              <div class="get-credit-report-part report-part-steps">
                <div>
                  <span class="get-credit-font2">04</span>
                  <span class="get-credit-font3">进入答题页面，十分钟内完成答题</span>
                </div>
                <div class="get-credit-pics">
                  <img src="<c:url value="/resources/image/setp4.png"/>">
                </div>
              </div>
              <div class="get-credit-report-part report-part-steps">
                <div>
                  <div class="float_l get-credit-font2">05</div>
                  <div class="float_l get-credit-font3">问题验证完成后，下列信用报告信息全部勾选，点击“下一步”</div>
                </div>
                <div class="get-credit-pics">
                  <img src="<c:url value="/resources/image/step5.png"/>">
                </div>
              </div>
              <div class="get-credit-report-part report-part-steps">
                <div>
                  <div class="float_l get-credit-font2">06</div>
                  <div class="float_l get-credit-font3">等待一个工作日身份验证审核，如核实通过将在第二日收到“身份验证码”短信</div>
                </div>
              </div>
              <div class="clearfix get-credit-part1 credit-bottom-part">
                <span>二、获得“身份证验证码”7日内，进入卡得万利的“征信授权”页面进行授权。如超过7日，则需要登录征信中心，重新申请信用信息，获取新的“身份验证码”</span>
              </div>
              <div class="get-credit-pics credit-bottom-part2">
                <span class="credit-font5">特别说明</span>
              </div>
              <div class="get-credit-pics credit-bottom-part3">
                <div class="credit-font6">此次授权中的个人信用报个查询属于您的本人查询（非机构查询），不会对您的央行个人信用或其他贷款申请产生任何不良影响，请您放心。授权成功后我们将发送央行个人信用报告至您的常用邮箱，请注意查收。</div>
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