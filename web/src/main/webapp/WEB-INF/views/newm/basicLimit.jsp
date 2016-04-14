<%--<!DOCTYPE HTML>--%>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<html>
<head>
</head>
<body>--%>
<%--地址begin--%>
<div class="views" id="gspPosition" style="display: none; margin-top: -105px;">
    <!-- Your main view, should have "view-main" class-->
    <div class="view view-main">
        <!-- Top Navbar-->
        <div class="navbar login-title">
            <div class="navbar-inner">
                <div class="left" id="address-back"><a href="#" class="close-img" style="padding: 0 10px 0 0;"><img
                        src="<c:url value='/resources/image/left-arror.png'/>"></a></div>
                <div class="center sliding login-title-word" style="width: 60%;">
                    <div class="input-group gps-toper">
                        <div class="input-group-addon gps-searcher">
                            <img src="<c:url value='/resources/image/gpsSearch.png'/>">
                        </div>
                        <input class="form-control" id="exampleInputAmount" placeholder="查找地点" onkeyup="searchPlace();"
                               type="text">
                    </div>
                </div>
                <div class="right">
                    <button class="button gps-search-button">搜索</button>
                </div>
            </div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page">
                <!-- Scrollable page content-->
                <div class="page-content">
                    <div class="address-tips">
                        温馨提示:如您的地址无法搜索到，请输入附近地址即可!
                    </div>
                    <div class="list-block media-list myaccount gps-pages">
                        <ul class="float_clear margin-t12" id="ulli">

                        </ul>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>

<%--地址end--%>

<%--<!--基础额度部分-->--%>

    <form method="post" id="myform">
        <div class="list-block uploadfile-block-new uploadFile-home-part1">
            <ul>
                <input id="applicationModelCreditId2" value="${applicationModel.creditId}" type="hidden">
                <li class="item-content apply-bottom2 fill-apply-font2"
                    style="width: 100%; overflow: hidden;">
                    <div class="item-media">
                        <span>期望融资金额</span>
                    </div>
                    <div class="item-inners" style="max-width: 62%; overflow-x: hidden;">
                        <div class="item-title fill-apply-font1">
                            <div class="basic-limit-part1"></div>
                            <input class="login_input fill-apply-font1 chick-hide-bottom" id="loanAmount"
                                   value="${newMerchantUserModel.loanAmount}" name="loanAmount"
                                   type="text" placeholder="例如：80000" onblur=loseFuces();>
                            <input  id="loanAmountDefault" value="${newMerchantUserModel.loanAmount}" type="hidden">
                        </div>
                    </div>
                </li>

                <li class="item-content apply-bottom2 fill-apply-font2"
                    style="width: 100%; overflow: hidden;">
                    <div class="item-media basic-limit-font1">
                        <div class="item-media">
                            <span>期望融资期限</span>
                        </div>
                        <div class="item-input row wechat-select">
                            <div class="col-xs-11 col-xs-offset-1" style="padding-left: 0;">
                                <input  id="planFundTermDefault" value="${newMerchantUserModel.planFundTerm}" type="hidden">
                                <select id="planFundTerm" name="planFundTerm" dir="rtl"
                                        style="padding-right:15px; text-outline: none;"
                                        <c:if test="${applicationModel.isAmountLocked==1 || applicationModel.isSubmitApplication==1}"> disabled="disabled" </c:if>>
                                    <option value="">请选择</option>
                                    <c:forEach var="item" items="${planFundTerm}">
                                        <option value="${item.id}"  ${newMerchantUserModel.planFundTerm == item.id ? 'selected' : ''} >${item.title}</option>
                                    </c:forEach>
                                </select>


                            </div>
                        </div>
                    </div>
                </li>

                <li class="item-content apply-bottom2 fill-apply-font2"
                    style="width: 100%; overflow: hidden;">
                    <%--<div class="item-content">--%>
                    <div class="item-media basic-limit-font1">
                        <div class="item-title label">所属行业</div>
                        <div class="item-input row wechat-select">
                            <div class="col-xs-4 basic-limit-font2">
                                <input  id="industryGIdsDefault" value="${newMerchantUserModel.industryGId}" type="hidden">
                                <select id="industryGId" class="industryGId" name="industryGId" dir="rtl"
                                        style="padding-right:15px;"
                                        <c:if test="${applicationModel.isAmountLocked==1 || applicationModel.isSubmitApplication==1}"> disabled="disabled" </c:if> >
                                    <option value="">请选择</option>
                                    <c:forEach var="item" items="${industryGIds}">
                                        <option value="${item.id}"  ${newMerchantUserModel.industryGId == item.id ? 'selected' : ''} >${item.title}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-xs-4 basic-limit-font2">
                                <input  id="industryPIdDefault" value="${newMerchantUserModel.industryPId}" type="hidden">
                                <select id="industryPId" name="industryPId" dir="rtl"
                                        style="padding-right:15px;"
                                        <c:if test="${applicationModel.isAmountLocked==1 || applicationModel.isSubmitApplication==1}"> disabled="disabled" </c:if>>
                                    <option value="">请选择</option>
                                    <c:if test="${newMerchantUserModel!=null and newMerchantUserModel.industryPId!=null}">
                                        <option value="${newMerchantUserModel.industryPId}"
                                                selected>${newMerchantUserModel.industryPName}</option>
                                    </c:if>
                                </select>
                            </div>

                            <div class="col-xs-4 basic-limit-font2 basic-limit-font3">
                                <input  id="industryCIdDefault" value="${newMerchantUserModel.industryCId}" type="hidden">
                                <select id="industryCId" name="industryCId" dir="rtl"
                                        style="padding-right:15px;" onchange="checkBizRegisterNo();"
                                        <c:if test="${applicationModel.isAmountLocked==1 || applicationModel.isSubmitApplication==1}"> disabled="disabled" </c:if>>
                                    <option value="">请选择</option>
                                    <c:if test="${newMerchantUserModel!=null and newMerchantUserModel.industryCId!=null}">
                                        <option value="${newMerchantUserModel.industryCId}"
                                                selected>${newMerchantUserModel.industryCName}</option>
                                    </c:if>
                                </select>
                            </div>
                        </div>
                    </div>
                    <%--</div>--%>
                </li>

                <li class="item-content apply-bottom2 fill-apply-font2"
                    style="width: 100%; overflow: hidden;">
                    <div class="item-media">
                        <span>营业执照注册号</span>
                    </div>
                    <div class="item-inners" style="max-width: 62%; overflow-x: hidden;">
                        <div class="item-title fill-apply-font1 basic-limit-part22">
                            <div class="basic-limit-part2"></div>
                            <input  id="bizRegisterNoDefault" value="${newMerchantUserModel.bizRegisterNo}" type="hidden">
                            <input class="login_input fill-apply-font1 chick-hide-bottom" id="bizRegisterNo" ${applicationModel.isSubmitApplication!=1 && applicationModel.isAmountLocked!=1 ? '' : 'disabled'}
                                   value="${newMerchantUserModel.bizRegisterNo}" name="bizRegisterNo"
                                   type="text" placeholder="例如：826110056218123" onblur="checkBizRegisterNo();loseFuces();">
                        </div>
                    </div>
                </li>

                <li class="media-item  apply-bottom2 fill-apply-font2" id="address"
                    style="width: 100%; overflow: hidden;">
                    <div class="item-link item-content more-main" id="shop-address">
                        <div class="item-media username_icon"
                             style="max-width: 20%; overflow-x: hidden;">
                            <span>营业地址</span>
                        </div>
                        <input  id="businessAddressDefault" value="${newMerchantUserModel.businessAddress}" type="hidden">
                        <div class="item-inners" style="max-width: 62%; overflow-x: hidden;">
                            <div class="item-title-row">
                                <div class="fill-apply-font1 fill-apply-tables-2">
                                    <c:choose>
                                        <c:when test="${newMerchantUserModel.businessAddress=='' || newMerchantUserModel.businessAddress==null}">
                                            <span class="upgrade-font2" id="chosePlace">请选择</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="upgrade-font2" id="chosePlace" style="color:black;">${newMerchantUserModel.businessAddress}</span>
                                        </c:otherwise>
                                    </c:choose>

                                    <input type="hidden" name="businessAddress" id="businessAddress"
                                           value="${newMerchantUserModel.businessAddress}"/>
                                    <input type="hidden" name="bizAddrLonlat" id="bizAddrLonlat"
                                           value="${newMerchantUserModel.bizAddrLonlat}"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>

                <li class="item-content apply-bottom2 fill-apply-font2"
                    style="width: 100%; overflow: hidden;">
                    <div class="item-media">
                        <span>门店数</span>
                    </div>
                    <div class="item-inners" style="max-width: 62%; overflow-x: hidden;">
                        <div class="item-title fill-apply-font1 basic-limit-part33">
                            <div class="basic-limit-part3"></div>
                            <input  id="numLocationsDefault" value="${newMerchantUserModel.numLocations}" type="hidden">
                            <input class="login_input fill-apply-font1 chick-hide-bottom" id="numLocations" value="${(newMerchantUserModel.numLocations=="" || newMerchantUserModel.numLocations==null)?1:newMerchantUserModel.numLocations}"
                                   name="numLocations" type="text" placeholder="例如：5" onblur=loseFuces();>
                        </div>
                    </div>
                </li>

                <li class="item-content apply-bottom2 fill-apply-font2"
                    style="width: 100%; overflow: hidden;">
                    <div class="item-media">
                        <span>申请人</span>
                    </div>
                    <div class="item-inners" style="max-width: 62%; overflow-x: hidden;">
                        <div class="item-title fill-apply-font1">
                            <div class="basic-limit-part4"></div>
                            <input class="login_input fill-apply-font1" id="proposerName" value="${newMerchantUserModel.ownerName}" name="ownerName" type="text" readonly>
                        </div>
                    </div>
                </li>

            </ul>

        </div>


        <c:if test="${!empty applicationModel.creditId}">
        <input type="hidden" value="${applicationModel.creditId}" id="threeShows">
        <span class="threeShow displaynone">
            <div class="list-block media-list myaccount more-part2 home-inside-page-more-part2">
                <ul class="float_clear">
                    <li class="border-bottom">
                        <%--<c:choose>
                            <c:when test="${applicationModel.isAmountLocked!=1}">
                                <a href="<c:url value="/new/m/posLimit/show"/> "  class="item-link item-content more-main">
                            </c:when>
                            <c:otherwise>
                                <a href="#"  class="item-link item-content more-main">
                            </c:otherwise>
                        </c:choose>--%>
                        <input type="hidden" id="isAmountLocked2" value="${applicationModel.isAmountLocked}">

                            <div class="item-link item-content more-main" id="isAmountLocked3">
                            <input type="hidden" id="isAmountLocked5" value="${applicationModel.isSubmitApplication}">
                            <div class="item-media username_icon">
                                <span>添加POS商编</span>
                            </div>
                            <div class="item-inners" style="max-width: 62%; overflow-x: hidden;">
                                <div class="item-title-row basci-limit-row">
                                    <div class="fill-apply-font1 fill-apply-tables-2">
                                        一共<span class="fill-apply-font3">${size}</span>个
                                        <input type="hidden" name="size" class="size" id="size"
                                               value="${size}">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
             <div class="basci-limit-font11"  style="padding-top: 10px; padding-bottom: 0;">
                 <div class="padding-b5">恭喜您！看起来您是我们的合格客户！</div>
                 <div>根据您目前提供的信息核算出以下融资方案,仅供参考:</div>
             </div>
            <div class="list-block media-list myaccount more-part2 home-inside-page-more-part2 home-inside-page-more-part22">
                <ul class="float_clear">
                    <li class="border-bottom">
                        <div class="item-link item-content more-main">
                            <div class="item-media username_icon">
                                <span>参考额度</span>
                            </div>
                            <div class="item-inners" style="max-width: 62%; overflow-x: hidden;">
                                <div class="item-title-rows">
                                    <div class="fill-apply-font1 fill-apply-tables-2">
                                        <span class="fill-apply-font3 requestAmount" id="creditId">￥${applicationModel.requestAmount}</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>

                    <li class="border-bottom">
                        <div class="item-link item-content more-main">
                            <div class="item-media username_icon">
                                <span>参考融资期限</span>
                            </div>
                            <div class="item-inners" style="max-width: 62%; overflow-x: hidden;">
                                <div class="item-title-rows">
                                    <div class="fill-apply-font1 fill-apply-tables-2">
                                        <span class="fill-apply-font3 rongziDay" >${loanPeriod}天</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="border-bottom">
                        <div class="item-link item-content more-main">
                            <div class="item-media username_icon">
                                <span>还款方式</span>
                            </div>
                            <div class="item-inners" style="max-width: 62%; overflow-x: hidden;">
                                <div class="item-title-rows repayWay">
                                    <input type="hidden" value="${paymentMethodId}" id="paymentMethodId">
                                    <div class="fill-apply-font1 fill-apply-tables-2">
                                        <span class="fill-apply-font3 paymentMethod" >${paymentMethod}</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>

        </c:if>

        <c:if test="${!empty applicationModel.creditId}">
            <div class="basci-limit-font11">
                <c:if test="${difDay>=0}">
                    <div class="padding-b5">以上参考融资方案有效期<span class="difDay">${difDay}</span> 天，至<span class="invalidDate">${invalidDate}</span>为止。</div>
                </c:if>
                <c:if test="${difDay<0}">
                    <div class="padding-b5">您的额度已过期。</div>
                </c:if>
                <c:if test="${applicationModel.isSubmitApplication!=1 && applicationModel.isAmountLocked!=1}">
                <div>继续下一步操作可获取更精确额度及融资方案!</div>
                </c:if>
            </div>
        </c:if>
    </span>
        <c:if test="${applicationModel.isSubmitApplication!=1 && applicationModel.isAmountLocked!=1 && applicationModel.status!='申请未通过'}">
            <div class="bind-number padding-rl15 inside-page-button">
                <a class="button button-big button-fill apply-button" href="#" id="submitBtn" style="margin-top:${applicationModel.isAmountLocked!=1 && !empty applicationModel.creditId ? '0px' : '15px'}">继续</a>
            </div>
        </c:if>
        <c:if test="${applicationModel.isAmountLocked!=1 && !empty applicationModel.creditId && applicationModel.isSubmitApplication!=1 && applicationModel.isAmountLocked!=1}">
            <div class="bind-number padding-rl15 bind-number2">
                <div class="basic-limit-button1">
                    <a href="#" data-popover=".popover-pos" class="pos-limit-help open-popover"
                       id="notAgree">
                        对额度不满意？点击此处提升额度!
                    </a>
                </div>
            </div>
        </c:if>
    </form>


<script type="text/javascript">
    var myApp = new Framework7({
        modalTitle: '卡得万利商业保理',
        ajaxLinks: 'a.ajax'
    });

    // Calendar picker
    var calendarDateFormat = myApp.calendar({
        input: '#bizStartDate',
        dateFormat: 'yyyy-MM-dd',
        onDayClick: function () {
            calendarDateFormat.close();
        }
    });

    var time11;
    var time12;
    function checkBizRegisterNo(){

        var industryCId = $("#industryCId").val();
        var bizRegisterNo =  $("#bizRegisterNo").val();
        var regType = "^[a-zA-Z0-9]{10,20}$";
        var reg = new RegExp(regType);
        if(!bizRegisterNo.match(reg)){
            return false;
        }
        if(bizRegisterNo=='' || bizRegisterNo==null ){
            return false;
        }
        if(industryCId=='' || industryCId==null){
//            myApp.alert("请选择行业","提示");
            return false;
        }
        $.ajax({
            type: "GET",
            url: contextPath + "check/checkbizRegisterNo",
            data: {"bizResigterNo":bizRegisterNo,industryCId:industryCId},
            success: function (data) {
                if(data.resultCode=='-1' || data.resultCode==-1){
                    myApp.alert(data.resultMsg,"提示")
                }else{
                    $("#proposerName").val(data.resultMsg);
                }
            }
        });

    }

    $(".repayWay").click(function(){

        if($("#paymentMethodId").val()==1){
            myApp.alert1("将以上商编的一个或多个pos结算账户变更为保理资金监管账户，并指定其中一个账户用于偿还保理融资款和费用，余款退回","帮助");
        }
    });
    //根据一级行业查询二级行业
    $('.industryGId').change(function () {

        var industryId = $(this).val();
        refreshIndustryPId(industryId);
    });
    //根据二级行业查询三级行业
    $('#industryPId').change(function () {
        var industryPId = $(this).val();
        refreshIndustryCId(industryPId);
    });

    //刷新一级行业
    function refreshIndustryPId(industryId) {
        $.ajax({
            type: "GET",
            url: contextPath + "new/m/queryIndustryDetails",
            data: {"industryId": industryId},
            success: function (data) {
                $('#industryPId').html('');
                $('#industryPId').append("<option value='' selected>请选择</option>");
                $.each(data.resultData, function (i, e) {
                    if ("${newMerchantUserModel.industryCId}" == e.id) {
                        $('#industryPId').append("<option value='" + e.id + "' restricted='" + e.restricted + "' title='" + e.title + "' selected>" + e.title + "</option>");
                    } else {
                        $('#industryPId').append("<option value='" + e.id + "' restricted='" + e.restricted + "' title='" + e.title + "' >" + e.title + "</option>");
                    }
                });
            }
        });
    }

    //刷新二级行业
    function refreshIndustryCId(industryId) {
        $.ajax({
            type: "GET",
            url: contextPath + "new/m/queryIndustryPIdDetails",
            data: {"industryId": industryId},
            success: function (data) {
                $('#industryCId').html('');
                $('#industryCId').append("<option value='' selected>请选择</option>");
                $.each(data.resultData, function (i, e) {
                    if ("${newMerchantUserModel.industryGId}" == e.id) {
                        $('#industryCId').append("<option value='" + e.id + "' restricted='" + e.restricted + "' title='" + e.title + "' selected>" + e.title + "</option>");
                    } else {
                        $('#industryCId').append("<option value='" + e.id + "' restricted='" + e.restricted + "' title='" + e.title + "' >" + e.title + "</option>");
                    }
                });
            }
        });
    }

    //选择地址
    $("#address").click(function () {
        <%--if ("${applicationModel.isAmountLocked != 1}" == "true") { }--%>
        var addressText = $(this).find("span[id='chosePlace']").text();
        $.ajax({
            type: "GET",
            url: contextPath + "new/m/gpsPosition",
            data: {"address": "张家浜路"},
            success: function (data) {
//                if (data.resultCode == 1 || data.resultMsg == 'ok') {
                    $("#myform").hide();
                    $("#gspPosition").show();
                    putHtmladress(data);

                    //赋值当前值到搜索框中
                    $("#exampleInputAmount").val(addressText);
                    //自动调用下拉框
                    searchPlace();

//                }
            }
        });
    });

    //搜索地址
    $(".right").click(function () {
        searchPlace();
    });

    function searchPlace() {
        var address = $("#exampleInputAmount").val();
        if ($.trim(address) == '') {
            return;
        }
        $.ajax({
            type: "GET",
            url: contextPath + "new/m/gpsPosition",
            data: {"address": address},
            success: function (data) {
//                if (data.resultCode == 1 || data.resultMsg == 'ok') {
                    $("#myform").hide();
                    $("#gspPosition").show();
                    putHtmladress(data);
//                }
            }
        });
    }

    function putHtmladress(data) {
        var placeHtml = "";
        for (var i = 0; i < data.resultData.length; i++) {
            placeHtml += "<li class='border-bottom'>";
            placeHtml += "<a href='#' class='item-link item-content more-main gps-content'>";
            placeHtml += "<div class='item-media username_icon'><img src='<c:url value="/resources/image/gpsPosition.png"/>'></div>";
            placeHtml += "<div class='item-inners'>";
            placeHtml += "<div class='item-title-row-gps'>";
            placeHtml += "<div>" + data.resultData[i].name + "</div>";
            placeHtml += "<div class='gps-font1'>" + data.resultData[i].city + data.resultData[i].district + "</div>";
            placeHtml += "<input type='hidden' class='lngAndlat' value='" + data.resultData[i].lngAndlat + "'>";
            placeHtml += "<input type='hidden' class='name' value='" + data.resultData[i].name + "'>";
            placeHtml += "<input type='hidden' class='city' value='" + data.resultData[i].city + "'>";
            placeHtml += "<input type='hidden' class='district' value='" + data.resultData[i].district + "'>";
            placeHtml += "</div>";
            placeHtml += "</div>";
            placeHtml += "</a>";
            placeHtml += "</li>";
        }
        $("#ulli").html(placeHtml);
    }


    $("body").delegate(".border-bottom a", "click", function () {
        var city = $(this).children().find(".city").val();
        var district = $(this).children().find(".district").val();
        var name = $(this).children().find(".name").val();
        var lngAndlat = $(this).children().find(".lngAndlat").val();

        $("#myform").show();
        $("#gspPosition").hide();
        $("#chosePlace").html(name);
        $("#chosePlace").css("color","black");
        $("#businessAddress").val(name);
        $("#bizAddrLonlat").val(lngAndlat);
        //返回加页头
        $('#address-displaynone').show();
        $('.slider-page1-content').css('margin-top', '90px')

    });


    $(".left").click(function () {
        $("#myform").show();
        $("#gspPosition").hide();
    });

//    点击添加商编，默默的提交

    $("#isAmountLocked3").click(function(){
        var isAmountLocked = $("#isAmountLocked2").val();
        var isSubmitApplication = $("#isAmountLocked5").val();
        if(isAmountLocked=='1' || isSubmitApplication=='1'){
            return false;
        }
        if($("#loanAmount").val()==$("#loanAmountDefault").val() && $("#planFundTerm").val()==$("#planFundTermDefault").val()
                && $("#industryGId").val()==$("#industryGIdsDefault").val() && $("#industryPId").val()==$("#industryPIdDefault").val()
                && $("#industryCId").val()==$("#industryCIdDefault").val() && $("#bizRegisterNo").val()==$("#bizRegisterNoDefault").val()
                && $("#businessAddress").val()==$("#businessAddressDefault").val() && $("#numLocations").val()==$("#numLocationsDefault").val()){

            //不进行保存数据，直接进入到pos添加页面
            location.href = contextPath + "new/m/posLimit/show";//确认 到pos界面
            return false;
        }

        //保存数据的同时，进入pos添加页面，防止客户填写的页面数据丢失
        if(isAmountLocked!='1'){
            $.ajax({
                type: "POST",
                url: contextPath + "new/m/basicLimit",
                data: $('#myform').serialize(),
                success: function (data) {

                }
            });
        }
        //保存数据的同时，进入pos添加页面
        location.href = contextPath + "new/m/posLimit/show";//确认 到pos界面
    });


    //提交
    $("#submitBtn").click(function () {

        if ($("#loanAmount").val() == '') {
            myApp.alert('请输入期望融资金额!', '提示');
            return;
        }

        var reg = /^([1-9][\d]{0,7}|0)(\.[\d]{1,2})?$/;
        if ($("#loanAmount").val() != "" && !reg.test($("#loanAmount").val())) {
            myApp.alert('意向融资金额不合法!', '提示');
            return;
        }

        if ($("#loanAmount").val() <1000) {
            myApp.alert('期望融资金额不少于1000元', '提示');
            return;
        }

        var planFundTerm = $("#planFundTerm").val();
        if (planFundTerm == "") {
            myApp.alert('期望融资期限不能为空!', '提示');
            return;
        }

        if ($("#industryPId").val() == "" || $("#industryCId").val() == "") {
            myApp.alert('所属行业不能为空!', '提示');
            return;
        }

        var bizRegisterNo =  $("#bizRegisterNo").val();
        var regType = "^[a-zA-Z0-9|-]{10,20}$";
        var reg2 = new RegExp(regType);
        if(!bizRegisterNo.match(reg2)){
            myApp.alert("营业执照注册号不合法!","提示");
            return false;
        }

        if ($("#bizRegisterNo").val() == "") {
            myApp.alert('营业执照注册号不能为空!', '提示');
            return;
        }

        if($("#proposerName").val()=="" || $("#proposerName").val()==null || $("#proposerName").val()=='null'){
            myApp.alert('营业执照注册号不合法!', '提示');
            return;
        }

        var place = $("#chosePlace").text();
        if (place == "请选择") {
            myApp.alert('请选择营业地址!', '提示');
            return;
        }

        if ($("#numLocations").val() == '') {
            myApp.alert('请填写门店数量!', '提示');
            return;
        }

        if($("#loanAmount").val()==$("#loanAmountDefault").val() && $("#planFundTerm").val()==$("#planFundTermDefault").val()
                && $("#industryGId").val()==$("#industryGIdsDefault").val() && $("#industryPId").val()==$("#industryPIdDefault").val()
                && $("#industryCId").val()==$("#industryCIdDefault").val() && $("#bizRegisterNo").val()==$("#bizRegisterNoDefault").val()
                && $("#businessAddress").val()==$("#businessAddressDefault").val() &&
                $("#numLocations").val()==$("#numLocationsDefault").val()  && $("#applicationModelCreditId2").val()!=''){
            //如果提交的所有的信息都没有发生变化，则不进行授信操作，直接进入第二个页面
            location.href = contextPath + "new/m/home?step=1";
            return false;
        }

        //120秒倒计时开始
        setTimeAccount();
        var time1 = 120;
        myApp.showPreloader('正在为您核算额度，请耐心等待...');
        $.ajax({
            type: "POST",
            url: contextPath + "new/m/basicLimit",
            data: $('#myform').serialize(),
            success: function (data) {
                myApp.hidePreloader();
                if (data.resultCode == "1") {
                    //定时器轮询调用获取授信结果
                    time12 = setInterval(function () {
                        if (time1 > 0) {
                            time1 = time1 - 5;
                            $.ajax({
                                type: "POST",
                                url: contextPath + "info/getCredit",
                                data: {},
                                success: function (result) {
                                    if(result.creditsTaskModel.creditStatus=='E' || result.creditsTaskModel.creditStatus=='N'){
//                                        myApp.alert("授信成功","提示");
                                        //取消定时器
                                        $('#submitBtn').removeClass('disabled');
                                        $('#submitBtn').text('继续');
                                        clearInterval(time11);
                                        clearInterval(time12);
                                        $("#number2").removeClass("disabled");

                                        var size = $("#size").val();
                                        if ($("#creditId").val() == '' || $("#creditId").val() == null) {
                                            myApp.confirm("额度计算成功！您可以通过添加POS商编\n来继续提升您的额度,是否继续?", "提示", function () {
//                                                myApp.alert("确定事件!","提示");
                                                location.href = contextPath + "new/m/posLimit/show";//确认 到pos界面
                                            }, function () {
//                                                myApp.alert("取消事件!","提示");
                                                 location.href="<c:url value="/new/m/home?step=118"/>";
                                            })
                                        } else {
                                            //第二次及以后基础资料填写完成直接跳转到第二个界面
                                            location.href = contextPath + "new/m/home?step=1";
                                        }

                                    }
                                }
                            })

                        }
                    }, 5000);
                    time12;

                } else {
                    if (data.resultCode == "-100") {
                        //取消定时器
                        $('#submitBtn').removeClass('disabled');
                        $('#submitBtn').text('继续');
                        clearInterval(time11);
                        clearInterval(time12);

                        myApp.alert(data.resultMsg, "提示")
                    }
                }
            }
        });
    });


    $("#basic-alert1").click(function () {
        location.href = contextPath + "new/m/posLimit/show";//有pos机 到pos界面
    });
    $("#basic-alert2").click(function () {
        location.href = contextPath + "new/m/home";//没有pos机 到首页
    });

    $('.basic-alert-button').click(function () {
        $('.basic-limit-alert').addClass('displaynone');
    });

    //    查询地址，去头部
    $('#shop-address').click(function () {

        var isAmountLocked = $("#isAmountLocked2").val();
        var isSubmitApplication = $("#isAmountLocked5").val();
        if(isAmountLocked=='1' || isSubmitApplication=='1'){
            return false;
        }

        $('#address-displaynone').hide();
        $('.slider-page1-content').css('margin-top', '0');
    });
    //    返回页面，加头部
    $('#address-back').click(function () {
        $('#address-displaynone').show();
        $('.slider-page1-content').css('margin-top', '105px')
    });


    $("#notAgree").click(function(){
        myApp.confirm1("添加POS机能够帮您获得更高的额度！","请问您是否有POS机?",function(){
            location.href="<c:url value="/new/m/posLimit/show"/>" ;
        });
    });

//    按钮倒数
    function setTimeAccount(){
        $('#submitBtn').addClass('disabled');
        var time = 120;//计时器
        time11 = setInterval(function(){
            if(time>0){
                time--;
                $('#submitBtn').text('额度计算中...' + time)
                if(time<=0){
                    $('#submitBtn').removeClass('disabled');
                    $('#submitBtn').text('继续');
                }
            };
        },1000);
        time11;
    }

    $('.chick-hide-bottom').click(function(){
        $('.toolbar').slideUp();
    })
    function loseFuces(){
        $('.toolbar').slideDown();
    }


    $(function(){
        if($("#step").val()=='118'){
            //第一次提交成功之后，如果不添加pos商编，显示侧边栏
            classie.toggle(showLeft, 'active');
            $('#slider').css('left', '240px');
            $('.navbar.login-title').css('left', '240px');
            classie.add(menuLeft, 'cbp-spmenu-open');
            classie.remove($back, 'displaynone');
        }

        var threeShows = $("#threeShows").val();
        if(threeShows !='' && threeShows!=null){
            $(".threeShow").removeClass("displaynone");
        }
    });

    $('.basic-limit-part1').click(function(){
        $('#loanAmount').focus();
        $(this).addClass('displaynone');
    });
    $('.basic-limit-part22').click(function(){
        $('#bizRegisterNo').focus();
        $('.basic-limit-part2').addClass('displaynone');
    });
    $('.basic-limit-part33').click(function(){
        $('.basic-limit-part3').addClass('displaynone');
        $('#numLocations').focus();
    });
    $('input').blur(function(){
        $('.basic-limit-part1').removeClass('displaynone');
        $('.basic-limit-part2').removeClass('displaynone');
        $('.basic-limit-part3').removeClass('displaynone');
    });

</script>

<%--</body>--%>
<%--</html>--%>
