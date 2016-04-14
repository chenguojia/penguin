<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: guojia.chen
  Date: 2016/2/15
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport"
        content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
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
        <div class="left"><a href="<c:url value="/new/m/account"/>" class="close-img"><img src="<c:url value='/resources/image/left-arror.png'/>"></a></div>
        <div class="center sliding login-title-word">个人信息</div>
        <div class="right"><a href="<c:url value="/new/m/more/regular?isApp=2"/>" class="account-font1">活动规则</a></div>
      </div>
    </div>
    <div class="account-title">
      <div class="account-font2">邀请获取红包 （元）</div>
      <div class="account-font3">${map.amount}<span class="account-font4">元</span></div>
      <div class="account-font5">成功邀请：${map.inviteCount}人</div>
    </div>
    <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
    <div class="pages navbar-through toolbar-through">
      <!-- Page, data-page contains page name-->
      <div data-page="index" class="page account-page">
        <!-- Scrollable page content-->
        <div class="page-content upload-page account-info-scroll">
          <div class="list-block media-list myaccount upload-list-block account-page-contenet">
            <!--当有记录时-->
            <c:if test="${map.inviteCount>0}">
              <ul class="float_clear account-info-ul ">
                <c:forEach items="${map.invitees}" var="item" varStatus="i">
                  <li class=" border-bottom">
                    <div class="item-link item-content more-main padding0">
                      <div class="item-inners">
                        <div class="item-title-row none-background account-font6">
                          <div class="item-title">被邀请人${i.index+1}：</div>
                          <div class="item-title">${item.mobilePhone}</div>
                          <div class="item-title account-font7">${item.registerTime}</div>
                        </div>
                      </div>
                    </div>
                  </li>
                </c:forEach>
              </ul>
            </c:if>
            <!--当无记录时-->
          <c:if test="${map.inviteCount=='0'}">
            <div class="account-none-record"><img src="<c:url value="/resources/image/noneRecord.png"/>"></div>
          </c:if>
          </div>
        </div>
      </div>
    </div>
    <div class="toolbar tabbar tabbar-labels">
      <div class="toolbar-inner" id="invited">
        <button class="button button-big account-button">邀请好友得大奖</button>
      </div>
    </div>
  </div>
</div>

<script>

  $("#invited").click(function(){
    location.href = "<c:url value="/public/inviteCode2?username=${username}&trueName=${trueName}"/>";
  });

</script>
</body>
</html>
