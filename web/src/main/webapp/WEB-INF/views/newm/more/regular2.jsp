<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/9/28
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<!-- Views-->
<div class="views" style="position:absolute; margin:0; padding:0; border:0; top:0;">
  <!-- Your main view, should have "view-main" class-->
  <div class="view view-main">
    <!-- Top Navbar-->
    <c:if test="${isApp=='1' || isApp=='2'}">
      <div class="navbar login-title">
        <div class="navbar-inner">
          <div class="left">
            <c:if test="${isApp=='1'}">
              <a href="<c:url value="/coupon/discountCoupon"/>" class="close-img"><img src="<c:url value='/resources/image/left-arror.png'/>"></a>
            </c:if>
            <c:if test="${isApp=='2'}">
              <a href="<c:url value="/info/inviteRecord"/>" class="close-img"><img src="<c:url value='/resources/image/left-arror.png'/>"></a>
            </c:if>
          </div>
          <div class="center sliding login-title-word">活动规则</div>
        </div>
      </div>
    </c:if>

    <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
    <div class="pages navbar-through toolbar-through">
      <!-- Page, data-page contains page name-->
      <div data-page="index" class="page">
        <!-- Scrollable page content-->
        <div class="page-content regular-back">
          <div class="list-block media-list myaccount regular-pic">
            <div><img src="<c:url value='/resources/image/regular-top.jpg'/>"></div>
          </div>
          <div class="regular-font1">
            <div class="regular-font4">优惠券及现金券使用规则:</div>
            <div class="regular-font3">
              <div>1、优惠券可用于抵扣管理手续费或融资手续费，视具体产品而定，不可提现</div>
              <div>2、每张优惠券只能使用一次，使用后无论是否还有余额，该优惠券立刻失效</div>
              <div>3、现金券可提现，且须一次性全额提现</div>
              <div>4、本规则最终解释权归卡得万利商业保理有限公司所有</div>
            </div>
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
