<%--
  Created by IntelliJ IDEA.
  User: guojia.chen
  Date: 2015/12/29
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="apple-mobile-web-app-status-bar-style" content="black">
  <title><decorator:title default="卡得万利" /></title>
  <%--jquery library--%>
  <script type="text/javascript" src="<c:url value='/resources/js/jquery.js'/>"></script>
  <!-- bootstrap-->
  <link rel="stylesheet" href="<c:url value="/resources/script/lib/bootstrap/css/bootstrap.min.css"/>">
  <!--framework7 css & js-->
  <link rel="stylesheet" href="<c:url value="/resources/script/lib/framework7/css/framework7.css"/>">
  <script type="text/javascript" src="<c:url value="/resources/script/lib/framework7/js/framework7.js"/>"></script>





<%--压缩图片--%>
  <script type="text/javascript" src="<c:url value="/resources/script/lib/localResizeIMG3/lrz.mobile.min.js"/>"></script>

  <%--基于bootstrap datetime picker--%>
  <%--<script type="text/javascript" src="<c:url value="/resources/script/datetimepicker/css/bootstrap-datetimepicker.min.css"/>"></script>--%>
  <%--<script type="text/javascript" src="<c:url value="/resources/script/datetimepicker/js/bootstrap-datetimepicker.js"/>"></script>--%>
  <%--<script type="text/javascript" src="<c:url value="/resources/script/datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"/>"></script>--%>
  <%--系统一些js--%>
  <script type="text/javascript" src="<c:url value="/resources/js/jquery.validate.min.js"/>"></script>

  <%--main css & js--%>
  <link rel="stylesheet" href="<c:url value='/resources/css/wechat.css'/>">
  <script type="text/javascript" src="<c:url value='/resources/js/wechat.js'/>"></script>
  <%--ajax提交form--%>
  <script type="text/javascript" src="<c:url value="/resources/js/ajaxfileupload.js"/>"></script>

  <script type="text/javascript" src="<c:url value="/resources/js/jquery.easing.1.3.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/stepBar.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/accountNumber.js"/>"></script>

  <script type="text/javascript">
    <%--var contextPath = '<c:url value="/"/>';--%>
    //var contextPath = '/webak/';
    var contextPath='<c:url value="/"/>';
  </script>

  <decorator:head />
</head>
<body>
<decorator:body />

<!-- 全局js-->
<script type="text/javascript" src="<c:url value="/resources/script/wechat.js"/>"></script>

</body>
</html>
