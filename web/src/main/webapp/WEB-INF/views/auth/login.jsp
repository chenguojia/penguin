<%--
  Created by IntelliJ IDEA.
  User: guojia.chen
  Date: 2015/12/30
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8" %>
<html>
<head>
</head>
<body>
<div data-role="page" id="loginDialog" style="background-image: -webkit-radial-gradient(#6facd5,#497bae);
background-image: radial-gradient(#6facd5,#497bae);">

  <div style="text-align:center;margin-top:10%"><img alt="cardvalue" src="<c:url value="/resources/image/cardvalue_logo1.png"/>"/></div>
  <div data-role="content" class="login">
    <c:if test="${not empty loginFailedMessage}">
      <span style="color:red">${loginFailedMessage}</span>
    </c:if>
    <form name='f' action="<c:url value="/j_spring_security_check"/>" method='POST' data-ajax="false">
      <div data-role="none" class="logininput" class="login">
        <div>
          <label class="ui-hidden-accessible" for="j_username">用户名：</label>
          <input type="text" name="j_username" id="j_username" placeholder="用户名"/>
        </div>
        <div>
          <label class="ui-hidden-accessible" for="j_password">密码：</label>
          <input type="password" name="j_password" id="j_password" placeholder="密码"/>
        </div>
      </div>
      <!-- <div data-role="fieldcontain">
          <label for="j_password">密码：</label>
          <input type="password" name="j_password" id="j_password">
      </div>	 -->
      <input name="submit" type="submit" value="登录" data-theme="b"/>
      <c:if test="${!empty message}">
        <h5 style="color:red;">*${message }</h5>
      </c:if>
      <c:if test="${empty message}">
        <h5>*首次登录时需要输入卡得万利提供的用户名和密码, 下次通过同一微信账户登录无需登录</h5>
        <h5>*如果您是商户，请关注微信公众号“小企额”进行申请</h5>
      </c:if>
      <%-- <a href="<c:url value="/m/register/show"/>" data-role="button" data-theme="c">新用户注册</a>--%>
    </form>
  </div>
</div>
</body>
</html>
