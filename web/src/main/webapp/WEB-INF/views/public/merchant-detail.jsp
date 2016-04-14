<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
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
			<h1>商户额度信息</h1>
		</div>
		<div data-role="content">
			<ul data-role="listview" >
				<li>
					<%--<a href="<c:url value='/leads/showSubmitWithMerchant?mid=${merchant.mid}'/>" >--%>
					<h6>编号：${merchant.mid}</h6>
					<p>名称：${merchant.merchantName}</p>
					<p>地址：${merchant.address}</p>
					
					<div class="split-line"></div>		
										
					<p>授信额度(三个月)：${merchant.creditLineLabel}</p>
					
					<c:if test="${merchant.creditLine < 10000 }">
						<p><b>*为了能更好的让您享用融资服务，<br>请提升您店铺POS刷卡活跃度。</b></p>
					</c:if>
					</a>
				</li>
			</ul>
		</div>
	</div>	
</body>
</html>
