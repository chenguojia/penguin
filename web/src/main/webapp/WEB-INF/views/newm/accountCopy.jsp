<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <title>卡得万利商业保理</title>
</head>
<body>
<!-- Views-->
<div class="views">
    <!-- Your main view, should have "view-main" class-->
    <div class="view view-main">
        <!-- Top Navbar-->
        <div class="navbar login-title">
            <div class="navbar-inner">
                <div class="center sliding login-title-word">我的账户</div>
                <div class="right"><a href="<c:url value='/new/m/userInfo/show'/>" class="close-img"><img src="<c:url value='/resources/image/shangchuan.png'/>"></a></div>
            </div>
        </div>
        <div class="upload-title">
            <div class="upload-title-img"><img src="<c:url value='/resources/image/users.png'/>"><a class="upload-fonts">${newMerchantUserModel.mobilePhone}</a></div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page">
                <!-- Scrollable page content-->
                <div class="page-content upload-page">

                    <div class="list-block media-list myaccount more-part2">
                        <ul class="float_clear margin-t12">
                            <li class=" border-bottom border-tops">
                                <a href="#" class="item-link item-content more-main">
                                    <div class="item-media username_icon upload-username-icon"><img src="<c:url value='/resources/image/myShopes.png'/>"></div>
                                    <div class="item-inners">
                                        <div class="float_l upload-file-part1">
                                            <div class="item-title upload-font2">我的商铺</div>
                                        </div>
                                        <div class="float_l upload-file-part2">
                                            <div class="upload-file-font1" id="addShop"><img  src="<c:url value='/resources/image/blueCross.png'/>"><span   class="padding-l10">添加商铺</span></div>
                                        </div>
                                    </div>
                                </a>
                            </li>

                            <c:forEach items="${muliteMerchant}" var="item" varStatus="i">
                                <li class="border-bottom">
                                <c:choose>
                                    <c:when test="${objectId == item.merchantId}">
                                        <a href="#" class="item-content more-main">
                                    </c:when>
                                    <c:otherwise>
                                        <a href="#" class="item-link item-content more-main muliteMerchantIds">
                                    </c:otherwise>
                                </c:choose>
                                            <div class="item-inners" >
                                                <div class="item-title-row">
                                                    <div class="item-title"><span class="upload-font3">${item.corporateName}</span></div>
                                                    <input type="hidden" name="muliteMerchantId" value="${item.merchantId}">
                                                    <input type="hidden" name="mulitApplicationId" value="${item.applicationId}">
                                                </div>
                                            </div>
                                        </a>
                                </li>
                            </c:forEach>


                        </ul>
                    </div>

                    <div class="list-block media-list myaccount upload-list-block">

                        <ul class="float_clear margin-t12">
                            <li class=" border-bottom border-tops">
                                <a href="<c:url value="/info/dimension"/>" class="item-link item-content more-main">
                                    <div class="item-inners">
                                        <div class="item-title-row">
                                            <div class="item-title">我的二维码</div>
                                            <div class="item-title"><img src="<c:url value='/resources/image/dimension.png'/>"></div>
                                        </div>
                                    </div>
                                </a>
                            </li>

                            <li class=" border-bottom">
                                <a href="<c:url value="/coupon/discountCoupon"/>" class="item-link item-content more-main">
                                    <div class="item-inners">
                                        <div class="item-title-row">
                                            <div class="item-title">我的优惠券</div>
                                        </div>
                                    </div>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <div class="toolbar tabbar tabbar-labels">
            <div class="toolbar-inner">
                <a href="<c:url value='/new/m/home'/>" class="tab-link">
                    <%--<i class="icon money-icon"><span class="badge bg-red">1</span></i>--%>
                    <i class="icon money-icon"></i>
                    <span class="tabbar-label">融资</span>
                </a>
                <a href="<c:url value='/new/m/account'/>" class="tab-link active">
                    <i class="icon account-icon">
                    </i>
                    <span class="tabbar-label">账户</span>
                </a>
                <a href="<c:url value='/new/m/more'/>" class="tab-link ">
                    <i class="icon more-icon"></i>
                    <span class="tabbar-label">更多</span>
                </a>
            </div>
        </div>

    </div>
</div>


<script type="text/javascript" src="<c:url value='/resources/js/jquery.js'/>"></script>
<script type="text/javascript">
    $(function(){
        $(".muliteMerchantIds").click(function(){
            var merchantId = $(this).find("input[name=muliteMerchantId]").val();
            var applicationId = $(this).find("input[name=mulitApplicationId]").val();
//            alert("merchantId "+merchantId);
            $.ajax({
                type:"POST",
                async:true,
                url:"<c:url value="/new/m/exchangeMerchant"/>",
                data:{merchantId:merchantId,applicationId:applicationId},
                success:function(data){
                    if(data.code==1 || data.code=="1"){
                        location.href = "<c:url value="/new/m/home"/>";
                    }
                }
            });


        });

        //添加商铺
        $("#addShop").click(function () {
            $.ajax({
                type:"GET",
                url:"<c:url value="/new/m/addMerchant"/>",
                data:{},
                success:function(data){
                    myApp.alert(data.message,"提示信息");
//  code=='1'表示新增商户成功
                    if(data.code=='1' || data.code==1){
                        location.href = "<c:url value="/new/m/home?step=0"/>";
                    }
                }
            });

        });
    })

</script>
</body>
</html>