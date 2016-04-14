<%--<!DOCTYPE html>--%>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div id="uploadFile" >
        <div class="content-block login-new credit-report-pages">
            <div class="list-block media-list myaccount more-part2" style="margin:12px 0;">
                <ul class="float_clear margin-t12 upload-tops-content">
                    <li class=" border-bottom border-tops ">
                        <c:choose>
                             <c:when test="${applicationModel.isJxlValid!=1}">
                                <div class="item-link item-content more-main row asynchronous" id="uploadfile-juxinli">
                             </c:when>
                             <c:otherwise>
                                <div class="item-link item-content more-main row">
                             </c:otherwise>
                        </c:choose>
                            <div class="item-media username_icon col-xs-4">
                                <span>手机验证</span>
                                <input class="displaynone" value="${applicationModel.isJxlValid}" id="juxinli">
                            </div>
                            <div class="item-inners col-xs-8 uploadfile-check" style="overflow: hidden">
                                <div class="item-title-row">
                                    <div class="fill-apply-font1 fill-apply-tables-2">
                                        <c:if test="${applicationModel.isJxlValid==1}">
                                                <span class="fill-apply-font3">
                                                    已验证
                                                </span>
                                        </c:if>
                                        <c:if test="${applicationModel.isJxlValid==0}">
                                                 <span class="fill-apply-font4">
                                                    未验证
                                                 </span>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class=" border-bottom " id="creditVerify">
                        <c:choose>
                            <c:when test="${applicationModel.creditReportStatus!=1}">
                                <div class="item-link item-content more-main row asynchronous" id="uploadfile-creditreport">
                            </c:when>
                            <c:otherwise>
                                <div class="item-link item-content more-main row">
                            </c:otherwise>
                        </c:choose>

                            <div class="item-media username_icon col-xs-4">
                                <span>征信授权</span>
                                <input class="displaynone" value="${applicationModel.creditReportStatus}" id="zhengxin"/>
                            </div>
                            <div class="item-inners col-xs-8 uploadfile-check" style="overflow: hidden">
                                <div class="item-title-row">
                                    <div class="fill-apply-font1 fill-apply-tables-2">
                                        <c:if test="${applicationModel.creditReportStatus==1}">
                                                <span class="fill-apply-font3">
                                                    已验证
                                                </span>
                                        </c:if>
                                        <c:if test="${applicationModel.creditReportStatus==0}">
                                                 <span class="fill-apply-font4">
                                                    未验证
                                                 </span>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>

                    <li class=" border-bottom " id="liDiscountCoupon">
                        <c:choose>
                            <c:when test="${applicationModel.isAmountLocked!=1}">
                                <div class="item-link item-content more-main row asynchronous" id="uploadfile-showCoupon">
                            </c:when>
                            <c:otherwise>
                                <div class="item-link item-content more-main row">
                            </c:otherwise>
                        </c:choose>

                            <div class="item-media username_icon col-xs-4">
                                <span>使用优惠券</span>
                                <input class="displaynone" value="${applicationModel.creditReportStatus}" >
                            </div>
                            <div class="item-inners col-xs-8 uploadfile-check" style="overflow: hidden">
                                <div class="item-title-row">
                                    <div class="fill-apply-font1 fill-apply-tables-2">
                                        <span class="fill-apply-font3" id="couponNames">
                                            <c:choose>
                                                <c:when test="${applicationModel.isSubmitApplication =='1' || applicationModel.isAmountLocked==1}">
                                                    <c:forEach items="${applicationModel.coupons}" var="item" varStatus="i">
                                                        ${item.amount}
                                                        <%--追加最后一个逗号--%>
                                                        ${ i.index + 1 == fn:length(applicationModel.coupons) ? '' : ',' }
                                                    </c:forEach>
                                                </c:when>
                                                <c:when test="${fn:length(applicationModel.coupons)==0 && maxCoupon==null}">
                                                    请选择
                                                </c:when>
                                                <c:when test="${fn:length(applicationModel.coupons)==0 && maxCoupon!=null}">
                                                    ${maxCoupon}
                                                </c:when>
                                                <c:otherwise>
                                                    <c:forEach items="${applicationModel.coupons}" var="item" varStatus="i">
                                                        ${item.amount}
                                                        <%--追加最后一个逗号--%>
                                                        ${ i.index + 1 == fn:length(applicationModel.coupons) ? '' : ',' }
                                                    </c:forEach>
                                                </c:otherwise>
                                            </c:choose>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>


            <form id="myform2" method="post">
            <div class="list-block uploadfile-block-new uploadFile-home-part1 uploadfiles-part2" style="margin-top:12px;">
                <ul>
                        <li class="item-content apply-bottom2 fill-apply-font2"
                            style="width: 100%; overflow: hidden;">
                            <div class="item-media">
                                <span>居住地址</span>
                            </div>
                            <div class="item-inners" style="max-width: 62%; overflow: hidden">
                                <div class="item-title fill-apply-font1" id="uploadFile-part1">
                                    <div class="uploadFile-part1"></div>
                                    <input class="login_input fill-apply-font1" type="text"
                                           name="ownerAddress" id="ownerAddress"
                                           value="${newMerchantUserModel.ownerAddress}"
                                           placeholder="例如：北张家浜路88号">
                                </div>
                            </div>
                        </li>

                        <li class="item-content apply-bottom2 fill-apply-font2"
                            style="width: 100%; overflow: hidden;">
                            <div class="item-media">
                                <span>直系亲属类型</span>
                            </div>
                            <select id="directType" name="directType" dir="rtl" style="padding-right:15px; min-width: 80px;"
                                    <c:if test="${applicationModel.isAmountLocked==1 || applicationModel.isSubmitApplication==1}"> disabled="disabled" </c:if> >
                                <option value="">请选择</option>
                                <c:if test="${newMerchantUserModel.directType=='父母'}">
                                    <option value="父母" selected>父母</option>
                                    <option value="子女">子女</option>
                                    <option value="配偶">配偶</option>
                                </c:if>
                                <c:if test="${newMerchantUserModel.directType=='子女'}">
                                    <option value="父母">父母</option>
                                    <option value="子女" selected>子女</option>
                                    <option value="配偶">配偶</option>
                                </c:if>
                                <c:if test="${newMerchantUserModel.directType=='配偶'}">
                                    <option value="父母">父母</option>
                                    <option value="子女">子女</option>
                                    <option value="配偶" selected>配偶</option>
                                </c:if>
                                <c:if test="${newMerchantUserModel.directType==''}">
                                    <option value="父母">父母</option>
                                    <option value="子女">子女</option>
                                    <option value="配偶">配偶</option>
                                </c:if>
                            </select>
                        </li>
                        <li class="item-content apply-bottom2 fill-apply-font2"
                            style="width: 100%; overflow: hidden;">
                            <div class="item-media">
                                <span>直系亲属姓名</span>
                            </div>
                            <div class="item-inners" style="max-width: 62%; overflow: hidden">
                                <div class="item-title fill-apply-font1 uploadFile-part22">
                                    <div class="uploadFile-part2"></div>
                                    <input class="login_input fill-apply-font1" id="directName"
                                           name="directName" type="text"
                                           value="${newMerchantUserModel.directName}"
                                           placeholder="例如：张三">
                                </div>
                            </div>
                        </li>
                        <li class="item-content apply-bottom2 fill-apply-font2"
                            style="width: 100%; overflow: hidden;">
                            <div class="item-media">
                                <span>直系亲属手机</span>
                            </div>
                            <div class="item-inners" style="max-width: 62%; overflow: hidden">
                                <div class="item-title fill-apply-font1 uploadFile-part33">
                                    <div class="uploadFile-part3"></div>
                                    <input class="login_input fill-apply-font1" id="directPhone"
                                           name="directPhone" type="text"
                                           value="${newMerchantUserModel.directPhone}"
                                           placeholder="例如：18237128888">
                                </div>
                            </div>
                        </li>


                        <li class="item-content apply-bottom2 fill-apply-font2"
                            style="width: 100%; overflow: hidden;">
                            <div class="item-media">
                                <span>紧急联络人姓名</span>
                            </div>
                            <div class="item-inners" style="max-width: 62%; overflow: hidden">
                                <div class="item-title fill-apply-font1 uploadFile-part44">
                                    <div class="uploadFile-part4"></div>
                                    <input class="login_input fill-apply-font1" id="emergencyName"
                                           name="emergencyName" type="text"
                                           value="${newMerchantUserModel.emergencyName}"
                                           placeholder="例如：张三">
                                </div>
                            </div>
                        </li>


                        <li class="item-content apply-bottom2 fill-apply-font2"
                            style="width: 100%; overflow: hidden;">
                            <div class="item-media">
                                <span>紧急联络人手机</span>
                            </div>
                            <div class="item-inners" style="max-width: 62%; overflow: hidden">
                                <div class="item-title fill-apply-font1 uploadFile-part55">
                                    <div class="uploadFile-part5"></div>
                                    <input class="login_input fill-apply-font1" id="emergencyPhone"
                                           name="emergencyPhone" type="text"
                                           value="${newMerchantUserModel.emergencyPhone}"
                                           placeholder="例如：18237128888">
                                </div>
                            </div>
                        </li>
                </ul>
            </div>

            <div class="list-block media-list myaccount more-part2" style="margin:12px 0;">
                <ul class="float_clear margin-t12 upload-tops-content">
                    <li class="item-content apply-bottom2 fill-apply-font2"
                        style="width: 100%; overflow: hidden;">
                        <div class="item-media">
                            <span>是否有租赁合同</span>
                        </div>
                        <select id="zuliSelect" name="hasLeaseContract" dir="rtl"
                                style="margin-right:15px; padding-right: 15px;"
                                <c:if test="${applicationModel.isAmountLocked==1 || applicationModel.isSubmitApplication==1}"> disabled="disabled" </c:if>>
                            <c:choose>
                                <c:when test="${newMerchantUserModel.hasLeaseContract =='1'}">
                                    <option value="1" selected>有</option>
                                    <option value="0" >无</option>
                                </c:when>
                                <c:when test="${newMerchantUserModel.hasLeaseContract == '0'}">
                                    <option value="1" >有</option>
                                    <option value="0" selected>无</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="" selected>请选择</option>
                                    <option value="1" >有</option>
                                    <option value="0">无</option>
                                </c:otherwise>
                            </c:choose>
                        </select>
                    </li>

                    <li id="limobile" class="item-content apply-bottom2 fill-apply-font2"
                        style="width: 100%; overflow: hidden;display: none">
                        <div class="item-media" style="max-width: 30%; overflow: hidden;">
                            <span>房东手机号码*</span>
                        </div>
                        <div class="item-inners" style="max-width: 62%; overflow: hidden">
                            <div class="item-title fill-apply-font1 uploadFile-part66">
                                <div class="uploadFile-part6"></div>
                                <input name="landlordPhone" id="landlordPhone"
                                       class="login_input fill-apply-font1" type="text"
                                       value="${newMerchantUserModel.landlordPhone}"
                                       placeholder="请输入房东手机号码！">
                            </div>
                        </div>
                    </li>

                    <li id="liWhyNot" class="item-content apply-bottom2 fill-apply-font2"
                        style="width: 100%; overflow: hidden;display: none">
                        <div class="item-media">
                            <span>为何没有租赁合同</span>
                            <input id="weihe" name="weihe" value="" type="hidden">
                        </div>
                        <select id="whyNot" name="noLeaseContractReason" dir="rtl"
                                style="margin-right:15px; padding-right: 15px; width: 80px;">
                                <c:if test="${applicationModel.isAmountLocked==1 || applicationModel.isSubmitApplication==1}"> disabled="disabled" </c:if>>
                            <c:choose>
                                <c:when test="${newMerchantUserModel.noLeaseContractReason==1 || newMerchantUserModel.noLeaseContractReason=='1'}">
                                    <option value="1" selected>自有房产</option>
                                    <option value="2">无偿使用</option>
                                    <option value="3">合同丢失</option>
                                </c:when>
                                <c:when test="${newMerchantUserModel.noLeaseContractReason==2 || newMerchantUserModel.noLeaseContractReason=='2'}">
                                    <option value="1">自有房产</option>
                                    <option value="2" selected>无偿使用</option>
                                    <option value="3">合同丢失</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="1">自有房产</option>
                                    <option value="2">无偿使用</option>
                                    <option value="3" selected>合同丢失</option>
                                </c:otherwise>
                            </c:choose>

                        </select>
                    </li>

                    <li id="libeginDate" class="item-content apply-bottom2 fill-apply-font2"
                        style="width: 100%; overflow: hidden;display: none">
                        <div class="item-media" style="max-width: 30%; overflow: hidden;">
                            <span>开始日期*</span>
                        </div>
                        <div class="item-inners" style="max-width: 62%; overflow: hidden">
                            <div class="item-title fill-apply-font1">
                                <input type="text" placeholder="年/月/日" name="leaseContractStartTime" value="${newMerchantUserModel.leaseContractStartTime}" class="login_input fill-apply-font1 required" readonly  id="calendar-default">
                            </div>
                        </div>
                    </li>
                    <li id="liendDate" class="item-content apply-bottom2 fill-apply-font2"
                        style="width: 100%; overflow: hidden;display: none">
                        <div class="item-media" style="max-width: 30%; overflow: hidden;">
                            <span>结束日期*</span>
                        </div>
                        <div class="item-inners" style="max-width: 62%; overflow: hidden">
                            <div class="item-title fill-apply-font1">
                                <input type="text" placeholder="年/月/日" name="leaseContractEndTime" value="${newMerchantUserModel.leaseContractEndTime}"   class="login_input fill-apply-font1 required" readonly id="calendar-default2">
                            </div>
                        </div>
                    </li>
                    <li id="limoneyMonth" class="item-content apply-bottom2 fill-apply-font2"
                        style="width: 100%; overflow: hidden;display: none">
                        <div class="item-media" style="max-width: 30%; overflow: hidden;">
                            <span>年租金*</span>
                        </div>
                        <div class="item-inners" style="max-width: 62%; overflow: hidden">
                            <div class="item-title fill-apply-font1 uploadFile-part77">
                                <div class="uploadFile-part7"></div>
                                <input name="leaseYearAmt" id="moneyMonth"
                                       class="login_input fill-apply-font1" type="text"
                                       value="${newMerchantUserModel.leaseYearAmt}">
                            </div>
                        </div>
                    </li>

                    <li id="liownerName" class="item-content apply-bottom2 fill-apply-font2"
                        style="width: 100%; overflow: hidden;display: none">
                        <div class="item-media" style="max-width: 30%; overflow: hidden;">
                            <span>业主姓名*</span>
                        </div>
                        <div class="item-inners" style="max-width: 62%; overflow: hidden">
                            <div class="item-title fill-apply-font1 uploadFile-part88">
                                <div class="uploadFile-part8"></div>
                                <input name="proprietorName" id="proprietorName" class="login_input fill-apply-font1" type="text" value="${newMerchantUserModel.proprietorName }" placeholder="业主姓名">
                            </div>
                        </div>
                    </li>
                    <li id="liowerMobile" class="item-content apply-bottom2 fill-apply-font2"
                        style="width: 100%; overflow: hidden;display: none">
                        <div class="item-media" style="max-width: 30%; overflow: hidden;">
                            <span>联系电话*</span>
                        </div>
                        <div class="item-inners" style="max-width: 62%; overflow: hidden">
                            <div class="item-title fill-apply-font1 uploadFile-part99">
                                <div class="uploadFile-part9"></div>
                                <input name="proprietorPhone" id="proprietorPhone"
                                       class="login_input fill-apply-font1" type="text"
                                       value="${newMerchantUserModel.proprietorPhone }"
                                       placeholder="联系电话">
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            </form>

        </div>
        <div class="float_clear"></div>
        <div class="margin-t15">
            <div class="list-block media-list myaccount upload-file-part4">
                <%--<div class="upload-home-font  zulin">租赁合同</div>
                <ul class="lackFilesItem zulin">
                    <li>
                        <div href="#" class="item-content">
                            <div class="item-inner">
                                <div class="pic-thumbnail uploadFileDetail-border0">
                                    <div class="row">
                                        &lt;%&ndash;添加图片操作按钮&ndash;%&gt;
                                        <div class="thumbnail-inner">
                                            <img class="thumbnailimg-add"
                                                 src="<c:url value="/resources/image/add-pic.png"/>"/>
                                            <input class="upload-btn" accept="image/*"
                                                   capture="camera" name="pictureFile"
                                                   id="pictureFile100" type="file"
                                                   checklistId="39"/>
                                                   &lt;%&ndash;checklistId="${item.checklistId}"/>&ndash;%&gt;
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>--%>

            <c:forEach var="item" items="${uploadFileChild}" varStatus="i">
                <div class="upload-home-font  rightPic"> ${item.title}</div>
                <ul class="lackFilesItem rightPic"  stitle="${item.title}" lackFiles="${item.lackFiles}">
                    <li>
                        <div href="#" class="item-content">
                            <div class="item-inner">
                                <div class="pic-thumbnail uploadFileDetail-border0">
                                    <div class="row">
                                            <%--示例图片--%>
                                        <c:if test="${!empty item.demo &&  item.demo != ''}">
                                            <div class="thumbnail-inner">
                                                <img class="thumbnailimg-eg imgObj" src="${item.demo}"/>

                                                <div class="thumbnailimg-tips"
                                                     style="margin-left:10px;margin-top:5px;">标准示例图片
                                                </div>
                                            </div>
                                        </c:if>
                                        <c:forEach var="picItem" items="${item.files}">
                                            <div class="thumbnail-inner imgDiv">
                                                <img class="thumbnailimg imgObj <c:if test="${picItem.width > picItem.height}">width-large</c:if><c:if test="${picItem.width < picItem.height}">height-large</c:if> "
                                                     src="${picItem.url}"/>
                                                <c:if test="${isView != 1 && applicationModel.isAmountLocked!='1'}">
                                                    <a class="delete-btn" checklistId="${item.checklistId}" sid="${picItem.fileId}">
                                                        <img class="delete-img" src="<c:url value="/resources/image/delete.png"/>"/>
                                                    </a>
                                                </c:if>
                                            </div>
                                        </c:forEach>

                                       <%--添加图片操作按钮--%>
                                       <c:if test="${applicationModel.isAmountLocked!=1}">
                                            <div class="thumbnail-inner">
                                                <img class="thumbnailimg-add"
                                                     src="<c:url value="/resources/image/add-pic.png"/>"/>
                                                <input class="upload-btn" accept="image/*"
                                                       capture="camera" name="pictureFile"
                                                       id="pictureFile101" type="file"
                                                       checklistId="39"/>
                                            </div>
                                       </c:if>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </c:forEach>

                <div class="float_clear"></div>


                <c:forEach var="item" items="${uploadFileChildModels}" varStatus="i">
                    <div class="upload-home-font"> ${item.title}</div>
                    <ul class="lackFilesItem" stitle="${item.title}" lackFiles="${item.lackFiles}">
                        <input type="hidden" id="count${i.index}" value="${item.lackFiles}"/>

                            <%-- <inpu type="hidden" class="countTitle"  value="${item.title}"/>--%>
                        <li>
                            <div href="#" class="item-content">
                                <div class="item-inner">
                                    <div class="pic-thumbnail uploadFileDetail-border0">
                                        <div class="row">
                                                <%--示例图片--%>
                                            <c:if test="${!empty item.demo &&  item.demo != ''}">
                                                <div class="thumbnail-inner">
                                                    <img class="thumbnailimg-eg imgObj" src="${item.demo}"/>

                                                    <div class="thumbnailimg-tips"
                                                         style="margin-left:10px;margin-top:5px;">标准示例图片
                                                    </div>
                                                </div>
                                            </c:if>
                                                <%--循环该分组下所有图片--%>
                                            <c:forEach var="picItem" items="${item.files}">
                                                <div class="thumbnail-inner imgDiv">
                                                    <img class="thumbnailimg imgObj <c:if test="${picItem.width > picItem.height}">width-large</c:if><c:if test="${picItem.width < picItem.height}">height-large</c:if> "
                                                         src="${picItem.url}"/>
                                                    <c:if test="${isView != 1 && applicationModel.isAmountLocked!='1'}">
                                                        <a class="delete-btn" checklistId="${item.checklistId}"  sid="${picItem.fileId}">
                                                            <img  class="delete-img" src="<c:url value="/resources/image/delete.png"/>"/>
                                                        </a>
                                                    </c:if>
                                                </div>
                                            </c:forEach>
                                            <c:if test="${applicationModel.isAmountLocked!=1}">
                                                <%--添加图片操作按钮--%>
                                                <div class="thumbnail-inner">
                                                    <img class="thumbnailimg-add"
                                                         src="<c:url value="/resources/image/add-pic.png"/>"/>
                                                    <input class="upload-btn" accept="image/*"
                                                           capture="camera" name="pictureFile"
                                                           id="pictureFile${i.index + 1}" type="file"
                                                           checklistId="${item.checklistId}"/>
                                                </div>
                                            </c:if>
                                        </div>
                                    </div>
                                    <c:if test="${!empty item.rfe && item.rfe != '' && applicationModel.cashadvanceStatus == '待补件'}">
                                        <div class="uploadFile-note">
                                            <span class="glyphicon  glyphicon-info-sign wechat-icon-uploadFile-info"></span>
                                            <span class="upload-note">${item.rfe}</span>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                        </li>
                    </ul>
                </c:forEach>
                <%--<div class="upload-home-font3">温馨提示：图片上传后系统自动保存</div>--%>
            </div>
        </div>
        <%--<div class="clearfix fill-apply-bottom"></div>--%>

    <div class="bind-number padding-rl15 inside-page-button">
        <c:if test="${applicationModel.isAmountLocked!=1  && applicationModel.status!='申请未通过'}">
                <a class="button button-big fill-apply-button" id="submitBtn2" href="#">提交</a>
        </c:if>
    </div>

    <div class="upload-file-buttom"></div>
    <input id="accessToken" name="accessToken" type="hidden" value="${accessToken}">
</div>

<script type="text/javascript">

    $('#uploadfile-juxinli').click(function(){
        location.href = '<c:url value="/new/m/juxinliLimit/show"/>';
    });
    $('#uploadfile-creditreport').click(function(){
        location.href = '<c:url value='/new/m/creditReport/show'/>';
    });
    $('#uploadfile-showCoupon').click(function(){
        location.href = '<c:url value='/coupon/showCoupon'/>';
    });

    var calendarDefault = myApp.calendar({
        input: '#calendar-default' ,
        onDayClick: function(dayContainer) {
            dayContainer.close();
        }
    });

    var calendarDefault = myApp.calendar({
        input: '#calendar-default2' ,
        onDayClick: function(dayContainer) {
            dayContainer.close();
        }
    });

    $(".asynchronous").click(function(){
        //默默保存
        $.ajax({
            type: "POST",
            url: contextPath + "new/m/updateUser",
            data: $('#myform2').serialize(),
            success: function (data) {

            }
        });
    });

    //是否有租赁合同
    function tenancy() {
        var zuliSelect = $("#zuliSelect").val();
        if (zuliSelect == '1') {
            $("#limobile").show();
            $(".rightPic").show();
            $("#liWhyNot").hide();
            $("#liownerName").hide();
            $("#liowerMobile").hide();
//            $(".rightPic").hide();
            $("#libeginDate").hide();
            $("#liendDate").hide();
            $("#weihe").val("0");
            $("#limoneyMonth").hide();
        }
        if (zuliSelect == '0') {
            $("#limobile").hide();
            $(".rightPic").hide();
            $("#liWhyNot").show();
        }
    }
//1：自有房产，2：无偿使用，3：合同丢失
    //为什么没有
    function whyNot() {
        var whyNot = $("#whyNot").val();
        if (whyNot == '2') {
            $(".rightPic").show();
            $("#liownerName").show();
            $("#liowerMobile").show();
            $("#libeginDate").hide();
            $("#liendDate").hide();
            $("#weihe").val("0");
            $("#limoneyMonth").hide();
        } else if (whyNot == '3') {
            $("#libeginDate").show();
            $("#liendDate").show();
            $("#weihe").val("1");
            $("#limoneyMonth").show();
            $("#liownerName").show();
            $("#liowerMobile").show();
            $(".rightPic").hide();
        } else if (whyNot == '1') {
            $(".rightPic").show();
//            $(".zulin").hide();
            $("#liownerName").hide();
            $("#liowerMobile").hide();
            $("#libeginDate").hide();
            $("#liendDate").hide();
            $("#weihe").val("0");
            $("#limoneyMonth").hide();
        } else {
            $("#liownerName").hide();
            $("#liowerMobile").hide();
            $("#libeginDate").hide();
            $("#liendDate").hide();
            $("#weihe").val("0");
            $("#limoneyMonth").hide();
        }
    }


    $("#whyNot").change(function () {
        whyNot();
    });
    $("#zuliSelect").change(function () {
        whyNot();
        tenancy();

    });
//1：自有房产，2：无偿使用，3：合同丢失
    $(function () {

        var zuliSelect = $("#zuliSelect").val();
        var whyNot = $("#whyNot").val();
        if (zuliSelect == '1') {
            $("#limobile").show();
//            $(".zulin").show();
            $(".rightPic").show();
            $("#liWhyNot").hide();
            $("#liownerName").hide();
            $("#liowerMobile").hide();

            $("#libeginDate").hide();
            $("#liendDate").hide();
            $("#weihe").val("0");
            $("#limoneyMonth").hide();
        }else{
            $("#liWhyNot").show();
            if (whyNot == '1') {
                $(".rightPic").show();
//                $(".zulin").hide();
                $("#liownerName").hide();
                $("#liowerMobile").hide();
                $("#libeginDate").hide();
                $("#liendDate").hide();
                $("#weihe").val("0");
                $("#limoneyMonth").hide();
            } else if (whyNot == '2') {
                $(".rightPic").show();
                $("#liownerName").show();
                $("#liowerMobile").show();
                $("#libeginDate").hide();
                $("#liendDate").hide();
                $("#weihe").val("0");
                $("#limoneyMonth").hide();
//                $(".zulin").hide();

            } else if (whyNot == '3') {
                $("#libeginDate").show();
                $("#liendDate").show();
                $("#weihe").val("1");
                $("#limoneyMonth").show();
                $("#liownerName").show();
                $("#liowerMobile").show();
                $(".rightPic").hide();
            }
        }
    });


    function getNowFormatDate() {
        var date = new Date();
        var seperator1 = "-";
        var seperator2 = ":";
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        var currentdate = year + seperator1 + month + seperator1 + strDate;
//                + " " + date.getHours() + seperator2 + date.getMinutes()
//                + seperator2 + date.getSeconds();
        return currentdate;
    }

    //保存
    $("#submitBtn2").click(function () {
        var flag = true;
        if($("#ownerAddress").val()==""){
            myApp.alert('居住地址不能为空!', '提示');
            return;
        }
        if($("#directType").val()==""){
            myApp.alert('请选择直系亲属类型!', '提示');
            return;
        }

        if($("#directName").val()==""){
            myApp.alert('直系亲属姓名不能为空!', '提示');
            return;
        }

        if($("#directPhone").val()==""){
            myApp.alert('直系亲属手机号码不能为空!', '提示');
            return;
        }

        var reg = /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
        if ($("#directPhone").val() != "" && !reg.test($("#directPhone").val())) {
            myApp.alert('直系亲属手机号码不合法!', '提示');
            return;
        }

        if($("#emergencyName").val()==""){
            myApp.alert('紧急联络人姓名不能为空!', '提示');
            return;
        }

        if ($("#emergencyPhone").val() != "" && !reg.test($("#emergencyPhone").val())) {
            myApp.alert('紧急联络人手机号码不合法!', '提示');
            return;
        }

        var startTime = $("#calendar-default").val();//开始日期
        var endTime = $("#calendar-default2").val();//结束日期
        var zulin= $('#weihe').val();
        if(zulin=='1'){
            if(startTime=='' ||  endTime==''){
                myApp.alert("租赁合同开始日期和结束日期都不能为空");
                return ;
            }
            if(startTime > endTime){
                myApp.alert("租赁合同结束日期不可小于开始日期");
                return;
            }
            if(endTime<getNowFormatDate() ){
                myApp.alert("租赁合同结束日期不可小于当前日期");
                return;
            }
            if($("#moneyMonth").val()==''){
                myApp.alert("年租金不能为空","提示");
                return;
            }
            if($("#proprietorName").val()==''){
                myApp.alert("业主姓名不能为空!","提示");
                return;
            }
            if($("#proprietorPhone").val()==''){
                myApp.alert("业主联系电话不能为空!","提示");
                return;
            }

            if ($("#proprietorPhone").val() != "" && !reg.test($("#proprietorPhone").val())) {
                myApp.alert('业主联系手机号码不合法!', '提示');
                return;
            }
        }

        //默默保存
        $.ajax({
            type: "POST",
            url: contextPath + "new/m/updateUser",
            data: $('#myform2').serialize(),
            success: function (data) {

            }
        });

        if ($("#juxinli").val() != "1") {
            myApp.confirm('您还未进行手机验证！是否马上进行验证？', '提示', function () {
                location.href = "<c:url value='/new/m/juxinliLimit/show'/>";
            });
            flag = false;
        } else if ($("#zhengxin").val() != "1") {
            myApp.confirm('您还未进行征信授权！是否马上进行征信授权？', '提示', function () {
                location.href = "<c:url value='/new/m/creditReport/show'/>";
            });
            flag = false;
        } else {


            //判断租赁合同
            if ($(".rightPic").is(":visible")) {
                //判断是否有上传租赁合同
               if ($(".rightPic").find("div[class='thumbnail-inner imgDiv']").length < 1) {
                   $(".rightPic").each(function(i,v){
                      if (i == 0) {
                          myApp.alert($(this).html() + "还剩1张未上传!", "提示");
                          flag = false;
                          return false;
                      }
                   });
               }
            }

            if (flag) {
                //校验图片
                $(".lackFilesItem").each(function () {
                    //当前索引
                    var stitle = $(this).attr("stitle");
                    var lackfiles = $(this).find("input").val();
                    if (lackfiles > 0) {
                        myApp.alert(stitle + "还剩" + lackfiles + "张未上传!", "提示");
                        flag = false;
                        return false;
                    }
                });
            }

            if (flag) {
                /*myApp.alert("当前微信版本小企额暂不支持提交申请，请下载'小企额'APP完成提交！",'提示',function(){
                    location.href = contextPath + "public/downloadApp";
                });*/
//                myApp.confirm('您确定提交申请吗？','提示',function() {
//                });

                myApp.showPreloader('提交中...')
                $.ajax({
                    type: "POST",
                    url: contextPath + "new/m/uploadFile",
                    data: {},
                    success: function (data) {
                        if (data.resultCode == "-1") {
                            myApp.hidePreloader();
                            myApp.alert(data.resultMsg,'提示');
                        } else {
                            location.href = contextPath + "new/m/home?step=1";
                        }
                    }
                });
            }


        }

    });



    $("input[name='pictureFile']").change(function () {
        var height = $("#change-pic1").height();
        var width = $("#change-pic1").width();
        var classValue = "";
        if (width > height) classValue = "width-large";
        else classValue = "height-large";
        //追加HTML
        $("#change-pic1").addClass(classValue);
    });


    bindUploadChangEvent();//触发上传事件
    bindImageClickEvent();//绑定图片预览事件
    bindImageDeleteEvent();//绑定删除图片事件

    //绑定上传事件公用方法
    function bindUploadChangEvent() {

        //移除事件
        $("input[name='pictureFile']").unbind("change");
        //绑定事件
        $("input[name='pictureFile']").change(function () {
            var myObjId = $(this).attr("id");
            var checklistId = $(this).attr("checklistId");
            myApp.showPreloader('提交中...')
            //调用lrz压缩图片
            lrz(this.files[0], {width: 800}, function (results) {
//                alert($("#accessToken").val());
                console.log(results);
                var url =  "${wsCrmRestfulMerchantUrl}/merchants/${newMerchantUserModel.objectId}/checklists/" + checklistId + "/files/" ;
                var fileName = results.origin.name
                console.log("url = "+url);
                //将图像post到后台
                $.ajax({
                    cache: false,
                    type: "POST",
                    <%--url: "${wsCrmRestfulMerchantUrl}/merchants/${newMerchantUserModel.objectId}/checklists/" + checklistId + "/files/" + results.origin.name,--%>
                    <%--data: results.base64.substring(results.base64.indexOf(",") + 1),--%>
                    url:"<c:url value="/cross/domain/uploadfile"/>",
                    data:{url:url,fileName:fileName,data:results.base64.substring(results.base64.indexOf(",") + 1)},
                    success: function (res) {
                        var data =JSON.parse(res.resp);
                        myApp.hidePreloader();
                        console.log(data);
                        if(res.code == '-1'){
                            myApp.alert("上传失败，请稍后重试","提示");
                       }

                        <%--正式代码--%>
                        if (data.error != null && data.error != "") {
                            myApp.alert(data.error, '提示');
                        } else {

                            //成功
                            //设置图片的高宽按照比例缩放样式
                            var classValue = "";
                            if (data.width > data.height) classValue = "width-large";
                            else classValue = "height-large";
                            //追加HTML
                            $("#" + myObjId).parent().before('' +
                            '<div class="thumbnail-inner imgDiv">' +
                            '<img class="thumbnailimg imgObj ' + classValue + '" src="' + data.url + '" />' +
                            '<a class="delete-btn" sid="' + data.objectId + '" ><img class="delete-img" src="<c:url value="/resources/image/delete.png"/>" /></a>' +
                            '</div>');
                            bindImageDeleteEvent();//绑定删除图片事件
                            bindImageClickEvent();//绑定图片预览事件
                            //上传成功之后刷新当前的值
//                            window.location.reload();
                            $.ajax({
                                cache: false,
                                type: "POST",
                                url: "<c:url value="/new/m/getFiles"/>",
                                data: {},
                                success: function (data) {
                                    if (data != null && data.length > 0) {
                                        for (var i = 0 ; i <data.length; i ++) {
                                            $("#count" + i).val(data[i].lackFiles);
                                        }
                                    }
//                                    $("#count1").val(data[0].lackFiles);
//                                    $("#count2").val(data[1].lackFiles);
//                                    $("#count3").val(data[2].lackFiles);
//                                    $("#count4").val(data[3].lackFiles);
                                }

                            });

                        }

                    },

                    error: function (data) {
                        myApp.hidePreloader();
                        myApp.alert("上传失败！");
                    },
                    /*headers: {
                        "X-CRM-Application-Id": "wechat",
                        "X-CRM-Access-Token": $("#accessToken").val(),
                        "X-CRM-Merchant-Id":"${newMerchantUserModel.objectId}",
                        "X-CRM-Version":"2.0.0",
                        "Content-Type": "text/base64"
                    }*/
                });
            });
        });
    }

    //绑定删除图片事件
    function bindImageDeleteEvent() {
        //删除图片
        $(".delete-btn").click(function () {
            var obj = $(this);
            var checklistId = obj.attr("checklistId");
            var fileId = obj.attr("sid");
            var url = "${wsCrmRestfulMerchantUrl}/merchants/${newMerchantUserModel.objectId}/files/" + fileId;
            //调用服务器删除
            /**
             * 请勿删除此处注释：
             1、直接用$.ajax跨域请求
             url: "${wsCrmRestfulMerchantUrl}/merchants/${newMerchantUserModel.objectId}/files/" + fileId,
             data: {},
             type: "DELETE",
             2、走后台，用java解决跨与请求
             url: "<c:url value="/cross/domain/deletePic"/>",
             data: {url:url},
             */
            $.ajax({
                cache: false,
                type: "POST",
                url: "<c:url value="/cross/domain/deletePic"/>",
                data: {url:url},
                success: function (data) {
                    if (data.error != null && data.error != "") {
                        //失败则提示
                        myApp.alert(data.error, '提示');
                    } else {
                        //成功则页面移除
                        obj.parent().remove();
                    }

                    //删除成功之后刷新当前的值
//                            window.location.reload();
                    $.ajax({
                        cache: false,
                        type: "POST",
                        url: "<c:url value="/new/m/getFiles"/>",
                        data: {},
                        success: function (data) {
                            if (data != null && data.length > 0) {
                                for (var i = 0 ; i < data.length; i ++) {
                                    $("#count" + i).val(data[i].lackFiles);
                                }
                            }
//                            $("#count1").val(data[0].lackFiles);
//                            $("#count2").val(data[1].lackFiles);
//                            $("#count3").val(data[2].lackFiles);
//                            $("#count4").val(data[3].lackFiles);
                        }

                    });
                }, headers: {
                    "X-CRM-Application-Id": "wechat",
                    "X-CRM-Merchant-Id":"${newMerchantUserModel.objectId}",
                    "X-CRM-Version":"2.0.0",
                    "X-CRM-Access-Token": "${accessToken}"
                }
            });
        });
    }

    //绑定图片预览事件
    function bindImageClickEvent() {

        //自定义导航栏
        var navbarHtml = '' +
                '<div class="navbar">' +
                '<div class="navbar-inner">' +
                '<div class="left sliding">' +
                '<a href="#" class="back link wechat-back close-popup photo-browser-close-link">' +
                '<i class="icon icon-back card-back"></i>' +
                '<span></span>' +
                '</a>' +
                '</div>' +
                '<div class="center sliding">' +
                '<span class="photo-browser-current"></span> <span class="photo-browser-of">/</span> <span class="photo-browser-total"></span>' +
                '</div>' +
                '<div class="right">' +
                '</div>' +
                '</div>' +
                '</div>';

        //先取消绑定
        $(".imgObj").unbind("click");

        //点击时打开图片浏览器
        $(".imgObj").click(function () {

            //step1.组装显示的图片集合
            var picArray = new Array();//图片集合
            $(this).parent().parent().find("img").each(function (index, element) {
                if ($(this).attr("src").indexOf("add-pic.png") == -1 && $(this).attr("src").indexOf("delete.png") == -1) {
                    picArray.push($(this).attr("src"));//表示不是添加图片，添加进集合
                }
            });

            //step2.组装图片集合map，用于获取用户点击的是哪一张
            var picsMap = {};
            for (var i = 0; i < picArray.length; i++) {
                picsMap[picArray[i]] = "" + i;
            }

            //step3.获取当前显示的是哪一张
            var showIndex = picsMap[$(this).attr("src")];

            //step4.构建图片预览器
            var myPhotoBrowserStandalone = myApp.photoBrowser({
                photos: picArray,
                theme: 'dark',
                ofText: "/",
                backLinkText: "关闭",
                navbarTemplate: navbarHtml
            });

            //step5.显示图片预览器
            myPhotoBrowserStandalone.open(showIndex);
        });
    }


    $('#uploadFile-part1').click(function(){
        $('.uploadFile-part1').addClass('displaynone');
        $('#ownerAddress').focus();
    });
    $('.uploadFile-part22').click(function(){
        $('.uploadFile-part2').addClass('displaynone');
        $('#directName').focus();
    });
    $('.uploadFile-part33').click(function(){
        $('.uploadFile-part3').addClass('displaynone');
        $('#directPhone').focus();
    });
    $('.uploadFile-part44').click(function(){
        $('.uploadFile-part4').addClass('displaynone');
        $('#emergencyName').focus();
    });
    $('.uploadFile-part55').click(function(){
        $('.uploadFile-part5').addClass('displaynone');
        $('#emergencyPhone').focus();
    });
    $('.uploadFile-part66').click(function(){
        $('.uploadFile-part6').addClass('displaynone');
        $('#landlordPhone').focus();
    });
    $('.uploadFile-part77').click(function(){
        $('.uploadFile-part7').addClass('displaynone');
        $('#moneyMonth').focus();
    });
    $('.uploadFile-part88').click(function(){
        $('.uploadFile-part8').addClass('displaynone');
        $('#proprietorName').focus();
    });
    $('.uploadFile-part9').click(function(){
        $('.uploadFile-part9').addClass('displaynone');
        $('#proprietorPhone').focus();
    });
    $('input').blur(function(){
        $('.uploadFile-part1').removeClass('displaynone');
        $('.uploadFile-part2').removeClass('displaynone');
        $('.uploadFile-part3').removeClass('displaynone');
        $('.uploadFile-part4').removeClass('displaynone');
        $('.uploadFile-part5').removeClass('displaynone');
        $('.uploadFile-part6').removeClass('displaynone');
        $('.uploadFile-part7').removeClass('displaynone');
        $('.uploadFile-part8').removeClass('displaynone');
        $('.uploadFile-part9').removeClass('displaynone');
    });

</script>
