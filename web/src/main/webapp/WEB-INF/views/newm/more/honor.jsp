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
                <div class="center sliding login-title-word">资质荣誉</div>
            </div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page" style="background-color: #ffffff;">
                <!-- Scrollable page content-->
                <div class="page-content page-content-scroll ${isApp == '0' ? '' : 'none-navbar'}">
                    <div class="content-block caseShare_story honorTit">
                        <span>政府中小企业服务机构</span>
                    </div>
                    <div class="caseShare_pic aboutUs_titPic"><a href="#" class="caseShare-popup"><img src="<c:url value="/resources/image/service-list.png"/>" width="100%"></a></div>
                    <div class="content-block caseShare_story">
                        <span>卡得万利是上海市政府认定的中小企业服务机构，根据《中华人民共和国中小企业促进法》和工信部等五部委的《关于加快推进中小企业服务体系建设的指导意见》，为中小企业提供融资类政府公共服务。</span>
                    </div>
                    <div class="clearHonor"></div>
                    <div class="content-block caseShare_story honorTit">
                        <span>国家商业保理试点企业</span>
                    </div>
                    <div class="caseShare_pic aboutUs_titPic"><a href="#" class="caseShare-popup"><img src="<c:url value="/resources/image/permission-credit.png"/>" width="100%"></a></div>
                    <div class="content-block caseShare_story">
                        <span>卡得万利商业保理有限公司，是根据商务部《关于商业保理试点有关工作的通知》以及《上海市浦东新区设立商业保理企业试行办 法》设立的全国首家国家级商业保理试点企业。</span>
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