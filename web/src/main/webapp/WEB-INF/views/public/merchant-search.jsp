<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8" %>  
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>卡得万利</title>  	
	<link rel="stylesheet" href="<c:url value="/resources/css/jquery.mobile-1.3.2.min.css"/>" />
	<link rel="stylesheet" href="<c:url value="/resources/css/wechat.css"/>" />
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.9.1.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery.mobile-1.3.2.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery.validate.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/script/wechat.js"/>"></script>
	<script type="text/javascript">
		var contextPath = "<c:url value="/"/>";
	</script>
</head>
<body>
	<div data-role="page" id="task-detail">
		<div data-role="header" data-position="fixed" data-theme="b">
			<h1>查询商户额度信息</h1>
		</div>
		<div data-role="content">
			<%--<form id="searchForm" action="<c:url value='/public/search'/>" method="post" class="validate">--%>
				<div data-role="fieldcontain">
					<label for="number">商户编号：</label> 
					<input type="text" name="number" id="number" placeholder="例：898420142146762" value="${number}" class="required mid"/>
				</div>
				<input  type="submit" data-theme="b" value="搜索"/>
			</form>
		</div>
	</div>	
</body>
</html>
