<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head></head>
<body>
<!-- Views-->
<div class="views" style="position:absolute; margin:0; padding:0; border:0; top:0;">
    <!-- Your main view, should have "view-main" class-->
    <div class="view view-main">
        <!-- Top Navbar-->
        <div class="navbar login-title" style="display: ${isApp == '0' ? 'block' : 'none'}">
            <div class="navbar-inner">
                <div class="left"><a href="<c:url value='/new/m/more'/>" class="close-img"><img src="<c:url value='/resources/image/left-arror.png'/>"></a></div>
                <div class="center sliding login-title-word">公司简介</div>
            </div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page" style="background-color: #ffffff;">
                <!-- Scrollable page content-->
                <div class="page-content page-content-scroll ${isApp == '0' ? '' : 'none-navbar'}">
                    <%--<div class="caseShare_pic aboutUs_titPic"><a href="#" class="caseShare-popup"><img src="<c:url value="/resources/newm/images/welcome.jpg"/>" width="100%"></a></div>--%>
                    <div class="content-block caseShare_story">
                        <span>卡得万利商业保理有限公司（以下简称“卡得万利”）成立于2012年12月，是国家商业保理试点企业和政府中小企业服务机构。在上海市金融服务办公室、上海市商务委员会和上海市经济和信息化委员会的领导下，提供以商业保理为内容的中小企业融资公共服务。</span>
                        <p><span>卡得万利由伟高达创业投资合伙企业、常春藤基金、硅谷银行、鼎鑫等国际知名投资机构联合投资。</span></p>
                        <p><span>卡得万利致力于激活百万商户的亿万账款资源，直接推动金融创新，最终实现中小商业零售企业融资无门槛。</span></p>
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