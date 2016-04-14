<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%--<html>--%>
<%--<head></head>--%>
<%--<body>--%>
<!-- Views-->
<%--<div class="views addFile">--%>
    <!-- Your main view, should have "view-main" class-->
    <div class="view view-main addFile">
        <!-- Top Navbar-->
        <%--<div class="navbar login-title">
            <div class="navbar-inner">
                &lt;%&ndash;<div class="left"><a href="<c:url value='${sourceType == "1" ? "/new/m/home" :"/new/m/applyStatus/show"}  '/>" class="close-img"><img src="<c:url value='/resources/newm/images/icon/select-arrow.png'/>"></a></div>&ndash;%&gt;
                    <div class="left"><a href="<c:url value='/new/m/home'/>" class="close-img"><img src="<c:url value='/resources/image/left-arror.png'/>"></a></div>
                    <div class="center sliding login-title-word">补全资料</div>
            </div>
        </div>--%>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <%--<div class="pages navbar-through toolbar-through">--%>
            <!-- Page, data-page contains page name-->
            <%--<div data-page="index" class="page">--%>
                <!-- Scrollable page content-->
                <%--<div class="page-content margin-t05">--%>
                    <div>
                        <%--正式分组数据--%>
                        <c:forEach var="item" items="${uploadFileMainModels}">
                            <div class="content-block-title addFiles-font1-new">
                                <span class="uf-title-new">${item.title}</span>
                            </div>
                            <div class="list-block uploadFile-home-part1">
                                <ul>
                                    <c:forEach var="childItem" items="${item.items}">
                                        <li class="border-bottom">
                                            <a href="<c:url value='/new/m/uploadFileDetail/show?groupName=${childItem.title}&sourceType=2'/>" class="item-link item-content">
                                                <div class="item-inners margin-l0 addFile-arror">
                                                    <div class="item-title-row">
                                                        <div class="item-title">${childItem.title}</div>
                                                        <c:if test="${!empty childItem.lackCount && childItem.lackCount != '0'}">
                                                            <div class="item-after"><span class="badge bg-red" stitle="${childItem.title}">${childItem.lackCount}</span></div>
                                                        </c:if>
                                                    </div>
                                                </div>
                                            </a>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </c:forEach>

                            <c:if test="${applicationModel.isAmountLocked!=1}">
                                <div class="content-block-title addFiles-font1-new">
                                    <span class="uf-title-new">手机验证</span>
                                </div>
                                <div class="list-block uploadFile-home-part1">
                                    <ul>
                                        <%--<c:if test="${applicationModel.isJxlValid == 2 || applicationModel.isJxlValid == '2'}">--%>
                                        <li class="border-bottom juxinliFailed" >
                                            <div class="item-link item-content" id="addFile-juxinliLimit">
                                                <div class="item-inner margin-l0 addFile-arror">
                                                    <div class="item-title">手机验证</div>
                                                    <div class="item-title-row">
                                                        <%--<div class="item-after"><span class="badge bg-red" >验证失败</span></div>--%>
                                                        <div class="item-after"><span class="fill-apply-font3" >验证失败</span></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <%--</c:if>--%>
                                    </ul>
                                </div>
                            </c:if>
                        <div class="bind-number padding-rl15 margin-t12">
                            <a class="button button-big button-fill apply-button" id="submitBtn" >提交</a>
                        </div>
                    </div>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    </div>
<%--</div>--%>


<%--引入手机验证--%>
<%--<div class="juxinliLimit" style="display:none; background-color: #efeff4; height: 100%;">
    <%@include file="juxinliLimit.jsp" %>
</div>--%>

<script>
   /* var myApp = new Framework7({
        modalTitle: '卡得万利商业保理',
        ajaxLinks: 'a.ajax'
    });*/

 /*   $(".juxinliFailed").click(function(){
        $(".juxinliLimit").show();
        $(".addFile").hide();
    });*/

   $('#addFile-juxinliLimit').click(function(){
       location.href = '<c:url value="/new/m/juxinliLimit/show"/>';
   });

    $("#submitBtn").click(function(){
        //判断需要补件的文件是否都上传了....
        var flag = true;
        $(".badge").each(function(){
            if (parseInt($(this).html()) > 0) {
                myApp.alert($(this).attr("stitle") + "还剩" + $(this).html()  + "张未上传!", "提示");
                flag = false;
                return false;
            }
        });

        if (flag) {
            myApp.confirm('您确定提交吗？','提示',function() {
                myApp.showPreloader('提交中...')
                $.ajax({
                    type: "POST",
                    url: contextPath + "new/m/addFile",
                    data: {},
                    success: function (data) {
                        if (data.resultCode == "-1") {
                            myApp.hidePreloader();
                            myApp.alert(data.resultMsg,'提示');
                        } else {
                            location.href = contextPath + "new/m/home";
                        }
                    }
                });
            });
        }

    });

</script>

<%--</body>--%>
<%--</html>--%>
