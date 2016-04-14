<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
</head>
<body>

<div class="views" id="gspPosition" style="display: none">
    <!-- Your main view, should have "view-main" class-->
    <div class="view view-main">
        <!-- Top Navbar-->
        <div class="navbar login-title">
            <div class="navbar-inner">
                <div class="left" id="leftPlace"><a href="#" class="close-img"><img src="<c:url value='/resources/image/left-arror.png'/>"></a></div>
                <div class="center sliding login-title-word">
                    <div class="input-group gps-toper">
                        <div class="input-group-addon gps-searcher">
                            <img src="<c:url value='/resources/image/gpsSearch.png'/>">
                        </div>
                        <input class="form-control" id="exampleInputAmount" placeholder="查找地点" onkeyup="searchPlace();" type="text">
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
                    <div class="list-block media-list myaccount gps-pages">
                        <ul class="float_clear margin-t12" id="ulli">

                        </ul>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>


<!--基础额度部分-->
    <!-- Views-->
    <div class="views" id="basicLimit">
        <!-- Your main view, should have "view-main" class-->
        <div class="view view-main">
            <!-- Top Navbar-->
            <div class="navbar login-title">
                <div class="navbar-inner">
                    <div class="left"><a href="<c:url value='/new/m/home'/>" class="close-img"><img src="<c:url value='/resources/image/left-arror.png'/>"></a></div>
                    <div class="center sliding login-title-word">基础资料</div>
                </div>
            </div>
            <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
            <div class="pages navbar-through toolbar-through">
                <!-- Page, data-page contains page name-->
                <div data-page="index" class="page">
                    <!-- Scrollable page content-->
                    <div class="page-content">
                        <form  method="post" id="myform">
                            <div class="content-block-title uploadFiles-font2">
                                <span class="uf-title-new">必填信息</span>
                            </div>

                            <div class="list-block uploadfile-block-new uploadFile-home-part1">
                                 <ul>
                                     <li class="item-content apply-bottom2 fill-apply-font2">
                                         <%--<div class="item-content">--%>
                                             <div class="item-media">
                                                 <div class="item-title label">所属行业</div>
                                                 <div class="item-input row wechat-select">
                                                     <div class="col-xs-6">
                                                         <select class="select-inner"id="industryPId" name="industryPId">
                                                             <option value="">请选择</option>
                                                             <c:forEach var="item" items="${industryPIds}">
                                                                 <option value="${item.id}"  ${newMerchantUserModel.industryPId == item.id ? 'selected' : ''} >${item.title}</option>
                                                             </c:forEach>
                                                         </select>
                                                     </div>
                                                     <div class="col-xs-6">
                                                         <select class="select-inner" id="industryCId" name="industryCId">
                                                             <option value="">请选择</option>
                                                             <c:if test="${newMerchantUserModel!=null and newMerchantUserModel.industryCId!=null}">
                                                             <option value="${newMerchantUserModel.industryCId}"  selected >${newMerchantUserModel.industryCName}</option>
                                                             </c:if>
                                                         </select>
                                                     </div>
                                                 </div>
                                             </div>
                                         <%--</div>--%>
                                     </li>
                                     <li class="item-content apply-bottom2 fill-apply-font2" style="width: 100%; overflow: hidden;">
                                         <div class="item-media">
                                             <span>营业执照注册号</span>
                                         </div>
                                         <div class="item-inners" style="max-width: 62%; overflow-x: hidden;">
                                             <div class="item-title fill-apply-font1">
                                                 <input class="login_input fill-apply-font1" id = "bizRegisterNo" value="${newMerchantUserModel.bizRegisterNo}" name="bizRegisterNo" type="text" placeholder="例如：826110056218123">
                                             </div>
                                         </div>
                                     </li>

                                    <li class="media-item" id="address">
                                        <a href="#" class="item-link item-content more-main">
                                            <div class="item-media username_icon" style="max-width: 20%; overflow-x: hidden;">
                                                <span>营业地址</span>
                                            </div>
                                            <div class="item-inners" style="max-width: 62%; overflow-x: hidden;">
                                                <div class="item-title-row">
                                                    <div class="fill-apply-font1 fill-apply-tables-2">
                                                        <c:choose>
                                                            <c:when test="${newMerchantUserModel.businessAddress=='' || newMerchantUserModel.businessAddress==null}">
                                                                <span class="upgrade-font2" id="chosePlace">请选择</span>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <span class="upgrade-font2" id="chosePlace">${newMerchantUserModel.businessAddress}</span>
                                                            </c:otherwise>
                                                        </c:choose>

                                                        <input type="hidden" name="businessAddress" id="businessAddress" value="${newMerchantUserModel.businessAddress}"/>
                                                        <input type="hidden" name="bizAddrLonlat" id="bizAddrLonlat" value="${newMerchantUserModel.bizAddrLonlat}"/>
                                                    </div>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                 </ul>
                                <c:if test="${!empty applicationModel.creditId && !empty applicationModel.amountRequested &&  applicationModel.amountRequested > 0 && applicationModel.isCreditNeedMove != 1 }">
                                    <div class="list-block media-list myaccount more-part2">
                                        <ul class="float_clear margin-t12">
                                            <li class=" border-bottom border-tops">
                                                <a href="<c:url value="/new/m/posLimit/show"/> " class="item-link item-content more-main">
                                                    <div class="item-media username_icon">
                                                        <span>添加POS商编</span>
                                                    </div>
                                                    <div class="item-inners" style="max-width: 62%; overflow-x: hidden;">
                                                        <div class="item-title-row">
                                                            <div class="fill-apply-font1 fill-apply-tables-2">
                                                                <span class="fill-apply-font3">共有${size}个</span>
                                                                <input type="hidden" name="size" class="size" id="size" value="${size}">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </a>
                                            </li>
                                        </ul>
                                    </div>
                                </c:if>


                            </div>

                            <%--兼容安卓选择门店数键盘遮挡问题--%>
                            <div class="bind-number padding-rl15">
                                <a class="button button-big button-fill apply-button" href="#" id="submitBtn">提交</a>
                            </div>
                        </form>
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
        // Calendar picker
        var calendarDateFormat = myApp.calendar({
            input: '#bizStartDate',
            dateFormat: 'yyyy-MM-dd',
            onDayClick:function(){
                calendarDateFormat.close();
            }
        });

        //根据一级行业查询二级行业
        $('#industryPId').change(function(){
            var industryId = $(this).val();
            refreshIndustryCId(industryId);
        });
        //刷新一级行业
        function refreshIndustryCId(industryId){
            $.ajax({
                type: "GET",
                url: contextPath + "new/m/queryIndustryDetails",
                data: {"industryId": industryId},
                success: function (data) {
                    $('#industryCId').html('');
                    $('#industryCId').append("<option value='' selected>请选择</option>");
                    $.each(data.resultData, function(i,e){
                        if ("${newMerchantUserModel.industryCId}" == e.id) {
                            $('#industryCId').append("<option value='"+ e.id +"' restricted='" + e.restricted  +"' title='" +e.title+ "' selected>" + e.title + "</option>");
                        } else {
                            $('#industryCId').append("<option value='"+ e.id +"' restricted='" + e.restricted  +"' title='" +e.title+ "' >" + e.title + "</option>");
                        }
                    });
                }
            });
        }


        //选择地址
       $("#address").click(function(){
           $.ajax({
               type: "GET",
               url: contextPath + "new/m/gpsPosition",
               data: {"address": "张家浜路"},
               success: function (data) {
                   if(data.resultCode==1 || data.resultMsg=='ok'){
                       $("#basicLimit").hide();
                       $("#gspPosition").show();
                       putHtml(data);

                   }
               }
           });
        });

        //搜索地址
        $(".right").click(function(){
            searchPlace();
        });

        function searchPlace(){
            var address = $("#exampleInputAmount").val();
            if( $.trim(address)==''){
                return ;
            }
            $.ajax({
                type: "GET",
                url: contextPath + "new/m/gpsPosition",
                data: {"address": address},
                success: function (data) {
                    if(data.resultCode==1 || data.resultMsg=='ok'){
                        $("#basicLimit").hide();
                        $("#gspPosition").show();
                        putHtml(data);
                    }
                }
            });
        }

        function putHtml(data){
            var placeHtml = "";
            for(var i=0;i<data.resultData.length;i++){
                placeHtml +=  "<li class='border-bottom'>";
                placeHtml += "<a href='#' class='item-link item-content more-main gps-content'>";
                placeHtml += "<div class='item-media username_icon'><img src='<c:url value="/resources/image/gpsPosition.png"/>'></div>";
                placeHtml += "<div class='item-inners'>";
                placeHtml += "<div class='item-title-row-gps'>";
                placeHtml += "<div>"+data.resultData[i].name+"</div>";
                placeHtml += "<div class='gps-font1'>"+data.resultData[i].city+data.resultData[i].district+"</div>";
                placeHtml += "<input type='hidden' class='lngAndlat' value='"+data.resultData[i].lngAndlat+"'>";
                placeHtml += "<input type='hidden' class='name' value='"+data.resultData[i].name+"'>";
                placeHtml += "<input type='hidden' class='city' value='"+data.resultData[i].city+"'>";
                placeHtml += "<input type='hidden' class='district' value='"+data.resultData[i].district+"'>";
                placeHtml += "</div>";
                placeHtml += "</div>";
                placeHtml += "</a>";
                placeHtml += "</li>";
            }
            $("#ulli").html(placeHtml);
        }


        $("body").delegate(".border-bottom a","click",function(){
            var city = $(this).children().find(".city").val();
            var district = $(this).children().find(".district").val();
            var name = $(this).children().find(".name").val();
            var lngAndlat = $(this).children().find(".lngAndlat").val();
//            alert(district);
            $("#basicLimit").show();
            $("#gspPosition").hide();
            $("#chosePlace").html(name);
            $("#bizAddrLonlat").val(lngAndlat);
            $("#businessAddress").val(name);
        });

        $("#leftPlace").click(function(){
            $("#basicLimit").show();
            $("#gspPosition").hide();
        });

        //提交
        $("#submitBtn").click(function(){

            if ( $("#industryPId").val() == "" || $("#industryCId").val() == "") {
                myApp.alert('所属行业不能为空!', '提示');
                return;
            }

            if ($("#bizRegisterNo").val() == "") {
                myApp.alert('营业执照注册号不能为空!', '提示');
                return;
            }

            var place = $("#chosePlace").text();
            if(place=="请选择"){
                myApp.alert('请选择营业地址!', '提示');
                return;
            }

            myApp.showPreloader('提交中...')
            $.ajax({
                type: "POST",
                url: contextPath + "new/m/basicLimit",
                data:$('#myform').serialize(),
                success: function (data) {
                    myApp.hidePreloader();
                    if (data.resultCode == "-1") {
                        myApp.alert(data.resultMsg,'提示');
                    } else {
                        var size = $("#size").val();
                        if(size>0){
                            myApp.confirm('提交成功!','提示',function(){
                                location.href = contextPath + "new/m/home";//取消 到首页
                            });
                        }else{
                            var result = window.confirm('提交成功，您可以通过添加POS商编来继续提升您的额度，是否继续?','提示');
                            if(result ==true){
                                location.href = contextPath + "new/m/posLimit/show";//确认 到pos界面
                            }else{
                                //成功,跳转主控界面
                                location.href = contextPath + "new/m/home";//取消 到首页
                            }
                        }

                    }
                }
            });
        });
        //查看时，隐藏提交按钮
        $(function(){
            if(${IsShow}!=null && ${IsShow}=='1'){
                $(".bind-number").hide();
            }
        });

    </script>
</body>
</html>
