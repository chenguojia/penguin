<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
                <div class="left">
                    <a href="<c:url value='/new/m/home'/>" class="close-img">
                        <img src="<c:url value='/resources/image/left-arror.png'/>">
                    </a>

                </div>
                <div class="center sliding login-title-word">对账明细</div>
            </div>
            <div class="refund-title">
                <div class="refund-title-font1">应还日期</div>
                <div class="refund-title-font1">应还金额(元)</div>
                <div class="refund-title-font1">实还日期</div>
                <div class="refund-title-font1">实还金额(元)</div>
            </div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page">
                <!-- Scrollable page content-->
                <div class="page-content">
                    <!--如有还款记录-->
                    <div class="list-block uploadfile-block-new uploadFile-home-part1 margin-35">
                        <ul>
                            <c:forEach items="${lists}" var="list">
                                <li>
                                    <div class="item-content padding0">
                                        <div class="item-inner padding0">
                                            <div class="refund-title-font2">${list.shouldReturnDate}</div>
                                            <div class="refund-title-font2">${list.shouldReturnMoney}</div>
                                            <div class="refund-title-font2">${list.receiveDate}</div>
                                            <div class="refund-title-font2">${list.receiveMoney}</div>
                                        </div>
                                    </div>
                                </li>

                            </c:forEach>
                        </ul>
                    </div>
                    <!--如无还款记录-->
                    <div class="refund-no-record displaynone">
                        <img src="<c:url value='/resources/image/blank-tips.png'/>">

                        <div class="refund-font3">
                            <span>您还没有还款记录！</span>
                        </div>
                    </div>

                </div>
            </div>
        </div>

    </div>
</div>


<script>
    var myApp = new Framework7({
        modalTitle: '卡得万利商业保理',
        ajaxLinks: 'a.ajax'
    });
    var $$ = Dom7;

    //滑动加载更多数据
    var baoliId = "${baoliId}";//总页数
    var pageCount = "${pageCount}";//总页数
    var pageNumber = "${pageNumber}";//当前页码
    $$('.infinite-scroll-preloader').remove();
    $$('.infinite-scroll').on('infinite', function () {

        alert("ddddd");
        //判断是否最后一页
        if (pageNumber >= pageCount) {
            myApp.detachInfiniteScroll($$('.infinite-scroll'));
            $$('.infinite-scroll-preloader').remove();
            return;
        }

        //表示不是最后一页继续请求
        $.ajax({
            type: "GET",
            url: contextPath + "new/m/loadRefundDetail",
            data: {"baoliId": baoliId, "pageNumber": parseInt(pageNumber) + 1},
            success: function (data) {
                if (data.resultCode == "-1") {
                    myApp.alert(data.resultMsg, '提示');
                } else {
                    //解析服务器返回内容
                    pageNumber = data.resultData["pageNumber"];
                    var exchangerResultModel = data.resultData["exchangerResultModel"]
                    //构建追加变量
                    var html = '';
                    for (var i = 0; i < exchangerResultModel.rows.length; i++) {
                        //获取当前循环对象
                        var obj = exchangerResultModel.rows[i];
                        //追加HTML
                        html += '<div class="item-content">'
                        html += '<div class="item-inner shop-inner">'
                        html += '<div class="item-title-row">'
                        html += '<div class="item-title refund-title">'
                        html += '<span class="glyphicon glyphicon-calendar glyphicon-date" aria-hidden="true"></span>'
                        html += '<span class="">清算日期：' + obj.qingsuandate + '</span>'
                        html += '</div>'
                        html += '</div>'
                        html += '<div class="item-text shop-subtitle">'
                        html += '<div class="refund-subtext">'
                        html += '<label class="refund-subtext-label">清算金额：</label>'
                        html += '<span class="refund-fee">' + obj.inJine + '</span>'
                        html += '</div>'
                        html += '<div class="refund-subtext">'
                        html += '<label class="refund-subtext-label">账户管理费：</label>'
                        html += '<span class="refund-fee">' + obj.cvFee + '</span>'
                        html += '</div>'
                        html += '<div class="refund-subtext">'
                        html += '<label class="refund-subtext-label">实还日期：</label>'
                        html += '<span class="refund-fee">' + obj.posRepaymentDate + '</span>'
                        html += '</div>'
                        html += '<div class="refund-subtext">'
                        html += '<label class="refund-subtext-label">实还金额：</label>'
                        html += '<span class="refund-fee">' + obj.huankuan + '</span>'
                        html += '</div>'
                        html += '<div class="refund-subtext">'
                        html += '<label class="refund-subtext-label">卡得万利付款：</label>'
                        html += '<span class="refund-fee">' + obj.paymentAmt + '</span>'
                        html += '</div>'
                        html += '</div>'
                        html += '</div>'
                        html += '</div>'
                    }
                    // Append new items
                    $$('.list-block ul').append(html);

                }
            }
        });

    });
</script>

</body>
</html>
