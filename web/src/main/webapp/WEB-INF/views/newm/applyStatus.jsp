<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head></head>
<body>
<!-- Views-->
<div class="views">
    <!-- Your main view, should have "view-main" class-->
    <div class="view view-main">
        <!-- Top Navbar-->
        <div class="navbar login-title">
            <div class="navbar-inner">
                <div class="left"><a href="<c:url value='/new/m/home'/>" class="close-img"><img src="<c:url value='/resources/newm/images/icon/left-arror.png'/>"></a></div>
                <div class="center sliding login-title-word">我的申请</div>

            </div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page">
                <!-- Scrollable page content-->
                <div class="page-content">
                    <div class="list-block media-list apply-list ${fn:length(applications) < 1 ? 'displaynone' : '' }" >
                        <ul>

                            <c:forEach var="item" items="${applications}">
                                <li class="border-bottom my-apply-min-height">

                                    <c:choose>
                                        <%--判断是锁定编辑资料1是锁定0没锁定 状态是否为"额度已核算"--%>
                                        <c:when test="${item.isDocumentLocked != '1'}">
                                            <div class="item-link item-content padding0 my-apply-content-new" id="applyStatus-uploafile">
                                        </c:when>

                                        <c:otherwise>
                                             <div class="item-link item-content padding0 my-apply-content-new" id="applyStatus-uploadFile-isView1">
                                        </c:otherwise>
                                    </c:choose>

                                        <div class="item-inners">
                                            <div class="item-title-row none-background account-font6 padding-l4">
                                                <div class="item-title my-account-font1">
                                                    <div>
                                                        <fmt:parseDate value="${item.createdAt}" pattern="yyyy-MM-dd" var="createdAt"/>
                                                        <fmt:formatDate value="${createdAt}" type="both" dateStyle="long" pattern="yyyy-MM-dd" var="fmtCreatedAt"/>
                                                        ${fmtCreatedAt}申请
                                                    </div>
                                                    <div class="my-account-font2">最新状态：<span class="my-account-font3">${item.status}</span></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item-titles my-apply-buttons">
                                            <c:choose>
                                            <%--判断是锁定编辑资料1是锁定0没锁定 状态是否为"额度已核算"--%>
                                            <c:when test="${item.isDocumentLocked != '1'}">
                                            <a href="<c:url value='/new/m/uploadFile/show'/>" class="button account-button my-account-button-new">填写申请
                                            </c:when>

                                            <%--判断状态是否为"待补件"--%>
                                            <%--<c:when test="${item.appStatus == 'pending'}">--%>
                                            <c:when test="${item.cashadvanceStatus == '待补件'}">
                                            <a href="<c:url value='/new/m/addFile/show?sourceType=2'/>" class="button account-button my-account-button-new">补全资料
                                            </c:when>

                                            <%--判断状态是否为"已发确认书"--%>
                                            <%--<c:when test="${item.appStatus == 'approved'}">--%>
                                            <c:when test="${item.cashadvanceStatus == '批准'}">
                                            <a href="<c:url value='/new/m/affirmLoans/show'/>" class="button account-button my-account-button-new">确认
                                            </c:when>

                                            <%--判断状态是否为"还款清算"--%>
                                            <c:when test="${item.cashadvanceStatus == '还款清算'}">
                                            <a href="<c:url value='/new/m/refundDetail?baoliId=${item.cashadvanceId}&sourceType=2'/>" class="button account-button my-account-button-new">查看账单
                                            </c:when>

                                            <c:otherwise>
                                                <a href="<c:url value='/new/m/uploadFile/show?isView=1'/>" class="button account-button my-account-button-new">查看申请
                                            </c:otherwise>
                                            </c:choose>
                                            </a>
                                    </div>
                                </li>
                            </c:forEach>

                            <%----%>
                            <%--<c:forEach var="item" items="${applications}">--%>
                                <%--<li>--%>
                                    <%--<c:choose>--%>
                                        <%--&lt;%&ndash;判断是锁定编辑资料1是锁定0没锁定 状态是否为"额度已核算"&ndash;%&gt;--%>
                                        <%--<c:when test="${item.isDocumentLocked != '1'}">--%>
                                            <%--<a href="<c:url value='/new/m/uploadFile/show'/>" class="item-link item-content">--%>
                                        <%--</c:when>--%>

                                        <%--&lt;%&ndash;判断状态是否为"待补件"&ndash;%&gt;--%>
                                        <%--<c:when test="${item.appStatus == 'pending'}">--%>
                                            <%--<a href="<c:url value='/new/m/addFile/show?sourceType=2'/>" class="item-link item-content">--%>
                                        <%--</c:when>--%>

                                        <%--&lt;%&ndash;判断状态是否为"已发确认书"&ndash;%&gt;--%>
                                        <%--<c:when test="${item.appStatus == 'approved'}">--%>
                                            <%--<a href="<c:url value='/new/m/affirmLoans/show'/>" class="item-link item-content">--%>
                                        <%--</c:when>--%>

                                        <%--&lt;%&ndash;判断状态是否为"还款清算"&ndash;%&gt;--%>
                                        <%--<c:when test="${item.cashadvanceStatus == '还款清算'}">--%>
                                            <%--<a href="<c:url value='/new/m/refundDetail?baoliId=${item.cashadvanceId}&sourceType=2'/>" class="item-link item-content">--%>
                                        <%--</c:when>--%>

                                        <%--<c:otherwise>--%>
                                            <%--<a href="#" class="item-content" style="color: #666;">--%>
                                        <%--</c:otherwise>--%>
                                    <%--</c:choose>--%>

                                        <%--<div class="item-inner  apply-item-inner" applicationId="${item.objectId}">--%>
                                            <%--<div class="item-title-row">--%>
                                                <%--<div class="item-title">--%>
                                                    <%--<fmt:parseDate value="${item.createdAt}" pattern="yyyy-MM-dd" var="createdAt"/>--%>
                                                    <%--<fmt:formatDate value="${createdAt}" type="both" dateStyle="long" pattern="yyyy-MM-dd" var="fmtCreatedAt"/>--%>
                                                    <%--申请：${fmtCreatedAt}--%>
                                                <%--</div>--%>
                                                <%--&lt;%&ndash;状态信息&ndash;%&gt;--%>
                                                <%--<div class="item-after apply-status" style="${(item.leadStatus != '12' &&  item.appStatus != 'pending' && item.appStatus != 'approved' && item.cashadvanceStatus != '还款清算') == true ?  'color: #666;' : ''}">--%>
                                                    <%--${item.status}--%>
                                                <%--</div>--%>
                                            <%--</div>--%>
                                            <%--&lt;%&ndash;拒绝理由&ndash;%&gt;--%>
                                            <%--<c:if test="${item.status == '审核中'}">--%>
                                                <%--<div class="item-text shop-subtitle">--%>
                                                    <%--<span>我们正在为您审核，通过后会短信通知您，请保持手机畅通!</span>--%>
                                                <%--</div>--%>
                                            <%--</c:if>--%>
                                            <%--&lt;%&ndash;拒绝理由&ndash;%&gt;--%>
                                            <%--<c:if test="${!empty item.statusDetail && item.statusDetail != ''}">--%>
                                            <%--<div class="item-text shop-subtitle">--%>
                                                <%--<span>拒绝原因：${item.statusDetail}</span>--%>
                                            <%--</div>--%>
                                            <%--</c:if>--%>
                                        <%--</div>--%>
                                    <%--</a>--%>

                                <%--</li>--%>
                            <%--</c:forEach>--%>

                        </ul>
                    </div>

                    <%--未提出申请--%>
                    <c:if test="${fn:length(applications) < 1}">
                        <div class="list-block">
                            <div class="blank-tips">
                                <img class="tips-img" src="<c:url value='/resources/newm/images/none.png'/>" />
                                <p>您还没有提出申请！</p>
                            </div>
                        </div>
                    </c:if>

                    <div class="agree-apply">
                        <div class="font12">
                            <input id="agree-terms" type="checkbox" checked />
                            <label for="agree-terms">同意<a class="open-popup" data-popup=".popup-apply" href="#" onClick="popClose()">卡得万利商业保理协议书</a></label>
                        </div>
                        <div class="font12">
                            <input id="agree-terms1" type="checkbox" checked />
                            <label for="agree-terms1">同意作为保证人承担连带保证责任</label>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <div class="toolbar tabbar tabbar-labels">
            <div class="toolbar-inner">
                <button class="button button-big account-button" href="#" id="createApplyBtn">创建新申请</button>
            </div>
        </div>
    </div>
</div>
<div class="popup popup-apply">
    <div class="content-block register-padding">
        <jsp:include page="/new/m/clause/createApply"/>
    </div>
</div>
    <%--协议关闭按钮--%>
    <div class="close-display display-none">
        <div class="close-line-height"></div>
        <a href="#" class="close-popup padding-l10" onClick="$('.close-display').addClass('display-none')">关闭</a>
    </div>

<script>
    var myApp = new Framework7({
        modalTitle: '卡得万利商业保理',
        ajaxLinks: 'a.ajax'
    });

    //同意条款
    $("#agree-terms").change(function () {
        if ($(this).is(":checked")) {
            $("#createApplyBtn").removeClass("disabled");
        } else {
            $("#createApplyBtn").addClass("disabled");
        }
    });

    //创建新申请
    $("#createApplyBtn").click(function(){
        myApp.showPreloader('加载中...')
        $.ajax({
            type: "POST",
            url: contextPath + "new/m/applyStatus",
            data: {},
            success: function (data) {
                if (data.resultCode == "-1") {
                    myApp.hidePreloader();
                    <%--if (data.resultMsg == "您还有未结束的申请记录，暂不允许创建新申请!") {--%>
                        <%--myApp.confirm('您还有未结束的申请记录，是否继续申请？','提示',function() {--%>
                            <%--location.href = "<c:url value='/new/m/uploadFile/show'/>";--%>
                        <%--});--%>
                    <%--} else {--%>
                        myApp.alert(data.resultMsg,'提示');
//                    }
                } else {
                    if(data.resultData == '1') {
                        myApp.hidePreloader();
                        myApp.alert('您的额度已经过期，请重新授信完成后以后再进行提交续贷申请！','提示',function(){
                            location.href = "<c:url value='/new/m/myLimit'/>";
                        });
                    } else {
                        location.href = "<c:url value='/new/m/uploadFile/show'/>";
                    }
                }
            }
        });
    });

    $('#applyStatus-uploafile').click(function(){
        location.href = '<c:url value='/new/m/uploadFile/show'/>';
    });
    $('#applyStatus-uploadFile-isView1').click(function(){
        location.href = '<c:url value='/new/m/uploadFile/show?isView=1'/>';
    });

</script>

</body>
</html>
