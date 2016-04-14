<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="text/javascript" src="<c:url value="/resources/script/jqModal.js"/>"></script>
<style type="text/css">
body{
margin:0;
}
.message{
text-align:center;
min-height:420px;
position:absolute;
width:100%;
height:100%;
}
.errorpage img{
width:100px;
}
.errorpage{
padding-top:10%;
}
</style>
</head>
<body>
	<div data-role="page" id="home" class="message" style="background-image: -webkit-radial-gradient(#6facd5,#497bae);
background-image: radial-gradient(#6facd5,#497bae);">
		<!-- <div data-role="header" data-position="fixed" data-theme="b">
			<h1>温馨提示</h1>
		</div> -->
		<div class="errorpage"><img src="<c:url value="/resources/image/smile.png"/>"/></div>
		<div data-role="content" id="error">
			<p>对不起，您没有权限访问该页面</p>
		</div>
	</div>
</body>
</html>