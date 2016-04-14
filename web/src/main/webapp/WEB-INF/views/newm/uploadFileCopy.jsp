<!DOCTYPE html>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="apple-mobile-web-app-status-bar-style" content="black">
  <title>卡得万利商业保理</title>
  <style type="text/css">
    .modal-overlay, .preloader-indicator-overlay, .popup-overlay{background: none;}
  </style>
</head>
<body>
<!-- Views-->
<div class="views">
  <!-- Your main view, should have "view-main" class-->
  <div class="view view-main">
    <!-- Top Navbar-->
    <div class="navbar login-title">
      <div class="navbar-inner">
        <div class="left"><a href="<c:url value="/new/m/home"/>" class="close-img"><img src="<c:url value='/resources/newm/images/icon/left-arror.png'/>"></a></div>
        <div class="center sliding login-title-word">
          <%--<div>申请资料</div>--%>
          <div>${applicationModel.status}</div>
          <input type="hidden" name="status" id="status" value="${applicationModel.status}">
        </div>
      </div>
    </div>


    <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
    <div class="pages navbar-through toolbar-through">
      <!-- Page, data-page contains page name-->
      <div data-page="index" class="page">
        <!-- Scrollable page content-->
        <div class="page-content">
          <div class="content-block login-new credit-report-pages">
            <div class="list-block credit-report">
              <ul>
                <form id="myform" method="post">
                  <li class="item-content apply-bottom fill-apply-font2">
                    <div class="item-media" style="max-width: 30%; overflow: hidden;">
                      <span>意向融资金额*</span>
                    </div>
                    <div class="item-inners" style="max-width: 62%; overflow: hidden">
                      <div class="item-title fill-apply-font1">
                        <c:if test="${newMerchantUserModel.loanAmount>applicationModel.amountRequested}">
                          <input  class="login_input fill-apply-font1" type="text" id="loanAmount" name="loanAmount" value="" placeholder="融资范围为5000~<fmt:formatNumber value="${applicationModel.amountRequested}" type="currency" pattern="#####.##"/>">
                        </c:if>
                        <c:if test="${newMerchantUserModel.loanAmount<applicationModel.amountRequested}">
                          <input  class="login_input fill-apply-font1" type="text" id="loanAmount" name="loanAmount" value="${newMerchantUserModel.loanAmount}" placeholder="融资范围为5000~<fmt:formatNumber value="${applicationModel.amountRequested}" type="currency" pattern="#####.##"/>">
                        </c:if>

                      </div>
                    </div>
                  </li>

                  <li class="item-content apply-bottom2 fill-apply-font2">
                    <div class="item-media" style="max-width: 30%; overflow: hidden;">
                      <span>房东手机号码*</span>
                    </div>
                    <div class="item-inners" style="max-width: 62%; overflow: hidden">
                      <div class="item-title fill-apply-font1">
                        <input name="landlordPhone" id="landlordPhone"  class="login_input fill-apply-font1" type="text"  value="${newMerchantUserModel.landlordPhone}"  placeholder="如自有房产、请输入本人手机">
                      </div>
                    </div>
                  </li>
                  <li class="item-content apply-bottom2 fill-apply-font2">
                    <div class="item-media" style="max-width: 30%; overflow: hidden;">
                      <span>放款银行名称*</span>
                    </div>
                    <div class="item-inners" style="max-width: 62%; overflow: hidden">
                      <div class="item-title fill-apply-font1">
                        <input name="secondaryBankName" id="secondaryBankName"  class="login_input fill-apply-font1" type="text"  value="${newMerchantUserModel.secondaryBankName}"  placeholder="请输入银行名称+支行名称">
                      </div>
                    </div>
                  </li>
                  <li class="item-content apply-bottom2 fill-apply-font2">
                    <div class="item-media">
                      <span>放款银行卡号*</span>
                    </div>
                    <div class="item-inners" style="max-width: 62%; overflow: hidden">
                      <div class="item-title fill-apply-font1">
                        <input name="secondaryBankDDA" id="secondaryBankDDA"  class="login_input fill-apply-font1" type="text"  value="${newMerchantUserModel.secondaryBankDDA}"  placeholder="如为公司请填对公账号">
                      </div>
                    </div>
                  </li>
                  <li class="item-content apply-bottom2 fill-apply-font2">
                    <div class="item-media">
                      <span>现在居住地址</span>
                    </div>
                    <div class="item-inners" style="max-width: 62%; overflow: hidden">
                      <div class="item-title fill-apply-font1">
                        <input class="login_input fill-apply-font1" type="text" name="ownerAddress" id="ownerAddress"  value="${newMerchantUserModel.ownerAddress}" placeholder="例如：北张家浜路88号">
                      </div>
                    </div>
                  </li>
                  <li class="item-content apply-bottom2 fill-apply-font2">
                    <div class="item-media">
                      <span>直系亲属类型</span>
                    </div>
                    <select id="directType" name="directType" >
                      <option value="">请选择</option>
                      <c:if test="${newMerchantUserModel.directType=='父母'}">
                        <option value="父母" selected>父母</option>
                        <option value="子女">子女</option>
                      </c:if>
                      <c:if test="${newMerchantUserModel.directType=='子女'}">
                        <option value="父母" >父母</option>
                        <option value="子女" selected>子女</option>
                      </c:if>
                      <c:if test="${newMerchantUserModel.directType==''}">
                        <option value="父母" >父母</option>
                        <option value="子女">子女</option>
                      </c:if>
                    </select>
                  </li>

                  <li class="item-content apply-bottom2 fill-apply-font2">
                    <div class="item-media">
                      <span>直系亲属手机</span>
                    </div>
                    <div class="item-inners" style="max-width: 62%; overflow: hidden">
                      <div class="item-title fill-apply-font1">
                        <input class="login_input fill-apply-font1"  id="directPhone" name="directPhone" type="text" value="${newMerchantUserModel.directPhone}" placeholder="例如：18237128888">
                      </div>
                    </div>
                  </li>

                  <li class="item-content apply-bottom2 fill-apply-font2">
                    <div class="item-media">
                      <span>紧急联络人姓名</span>
                    </div>
                    <div class="item-inners" style="max-width: 62%; overflow: hidden">
                      <div class="item-title fill-apply-font1">
                        <input class="login_input fill-apply-font1" id="emergencyName" name="emergencyName" type="text"  value="${newMerchantUserModel.emergencyName}" placeholder="例如：张三">
                      </div>
                    </div>
                  </li>


                  <li class="item-content apply-bottom2 fill-apply-font2">
                    <div class="item-media">
                      <span>紧急联络人手机</span>
                    </div>
                    <div class="item-inners" style="max-width: 62%; overflow: hidden">
                      <div class="item-title fill-apply-font1">
                        <input class="login_input fill-apply-font1" id="emergencyPhone" name="emergencyPhone" type="text" value="${newMerchantUserModel.emergencyPhone}" placeholder="例如：18237128888">
                      </div>
                    </div>
                  </li>

                </form>
              </ul>
            </div>

            <div class="list-block media-list myaccount more-part2">
              <ul class="float_clear margin-t12">
                <li class=" border-bottom border-tops">
                  <a href="#" class="item-link item-content more-main">
                    <div class="item-media username_icon">
                      <span>手机验证</span>
                    </div>
                    <div class="item-inners" style="max-width: 62%; overflow: hidden">
                      <div class="item-title-row" id="mobileNotVerify">
                        <div class="fill-apply-font1 fill-apply-tables-2">
                          <input type="hidden" value="${applicationModel.isJxlValid}" id="juxinli">
                          <c:if test="${applicationModel.isJxlValid==1}">
                                                        <span class="fill-apply-font3">
                                                            已验证
                                                        </span>
                          </c:if>
                          <c:if test="${applicationModel.isJxlValid==0}">
                                                         <span class="fill-apply-font4" >
                                                            未验证
                                                         </span>
                          </c:if>
                        </div>
                      </div>
                    </div>
                  </a>
                </li>
                <li class=" border-bottom border-tops">
                  <a href="#" class="item-link item-content more-main">
                    <div class="item-media username_icon">
                      <span>征信授权</span>
                    </div>
                    <div class="item-inners" style="max-width: 62%; overflow: hidden">
                      <div class="item-title-row" id="creditVerify">
                        <div class="fill-apply-font1 fill-apply-tables-2">
                          <input type="hidden" value="${applicationModel.creditReportStatus}" id="zhengxin">
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
                  </a>
                </li>
              </ul>
            </div>
          </div>

          <div>
            <div class="list-block media-list myaccount">
              <c:forEach var="item" items="${uploadFileChildModels}" varStatus="i">
                <div class="upload-home-font"> ${item.title}</div>
                <ul class="lackFilesItem" stitle="${item.title}" lackFiles="${item.lackFiles}">
                  <input type="hidden" id="count${i.index+1}"  value="${item.lackFiles}"/>

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
                                <div class="thumbnailimg-tips" style="margin-left:10px;margin-top:5px;">标准示例图片</div>
                              </div>
                            </c:if>
                              <%--循环该分组下所有图片--%>
                            <c:forEach var="picItem" items="${item.files}">
                              <div class="thumbnail-inner imgDiv">
                                <img class="thumbnailimg imgObj <c:if test="${picItem.width > picItem.height}">width-large</c:if><c:if test="${picItem.width < picItem.height}">height-large</c:if> " src="${picItem.url}" />
                                <c:if test="${isView != 1}"><a class="delete-btn" checklistId="${item.checklistId}" sid="${picItem.fileId}" ><img class="delete-img" src="<c:url value="/resources/newm/images/delete.png"/>" /></a></c:if>
                              </div>
                            </c:forEach>
                            <c:if test="${isView != 1}">
                              <%--添加图片操作按钮--%>
                              <div class="thumbnail-inner">
                                <img class="thumbnailimg-add" src="<c:url value="/resources/newm/images/add-pic.png"/>"/>
                                <input class="upload-btn" accept="image/*" capture="camera"  name="pictureFile"  id="pictureFile${i.index + 1}"  type="file" checklistId="${item.checklistId}" />
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
              <div class="upload-home-font3">温馨提示：图片上传后系统自动保存</div>
            </div>
          </div>
          <div class="clearfix fill-apply-bottom"></div>
        </div> <!--page-content-->
      </div>
    </div><!--page-->

    <c:if test="${isView!=1}">
      <div class="toolbar tabbar tabbar-labels">
        <div class="toolbar-inner">
          <a class="button button-big fill-apply-button" id="submitBtn" href="#">保存</a>
        </div>
      </div>
    </c:if>
  </div>
</div>

<script type="text/javascript">

  $("input[name='pictureFile']").change(function () {
    var height=$("#change-pic1").height();
    var width=$("#change-pic1").width();
    var classValue = "";
    if (width > height) classValue = "width-large";
    else classValue = "height-large";
    //追加HTML
    $("#change-pic1").addClass(classValue);
  });

  var myApp = new Framework7({
    modalTitle: '卡得万利商业保理',
    ajaxLinks: 'a.ajax'
  });

  $("#mobileNotVerify").click(function(){
    if($("#juxinli").val()!='1'){
      myApp.confirm('您还未进行手机验证！是否马上进行验证？','提示',function() {
        location.href = "<c:url value='/new/m/juxinliLimit/show'/>";
      });
    }
  });

  $("#creditVerify").click(function(){
    if($("#zhengxin").val()!='1'){
      myApp.confirm('您还未进行征信授权！是否马上进行征信授权？','提示',function() {
        location.href = "<c:url value='/new/m/creditReport/show'/>";
      });
    }
  });

  //保存
  $("#submitBtn").click(function(){
    if($("#loanAmount").val()==""){
      myApp.alert("请填写意向融资金额!");
      return;
    }

    var reg = /^([1-9][\d]{0,7}|0)(\.[\d]{1,2})?$/;
    if ($("#loanAmount").val() != "" && !reg.test($("#loanAmount").val())) {
      myApp.alert('意向融资金额不合法!', '提示');
      return;
    }

    if (parseFloat($("#loanAmount").val()) < parseFloat("5000")) {
      myApp.confirm('融资金额至少为<font color="red">5000</font>元!如您的授信额度不足5000元，您可以添加更多的POS商编来提高的您当前额度!是否马上进行添加新商编？', '提示',function() {
        location.href = "<c:url value='/new/m/posLimit/show'/>";
      });
      return;
    }

    if (parseFloat($("#loanAmount").val()) > parseFloat("${applicationModel.amountRequested}")) {
      myApp.alert('您的融资金额最大为<font color="red">' + parseInt(${applicationModel.amountRequested}) + '</font>元!请修改您的额度!!', '提示');
      return;
    }


    if($("#landlordPhone").val()==""){
      myApp.alert("请填房东手机号码!");
      return;
    }

    var reg = /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
    if ($("#landlordPhone").val() != "" && !reg.test($("#landlordPhone").val())) {
      myApp.alert('房东手机号码不合法!', '提示');
      return;
    }
    if($("#secondaryBankName").val()==""){
      myApp.alert("请填写放款银行名称!");
      return;
    }

    if($("#secondaryBankDDA").val()==""){
      myApp.alert("请填写放款银行卡号!");
      return;
    }

    if ($("#directPhone").val() != "" && !reg.test($("#directPhone").val())) {
      myApp.alert('直系亲属手机号码不合法!', '提示');
      return;
    }
    if ($("#emergencyPhone").val() != "" && !reg.test($("#emergencyPhone").val())) {
      myApp.alert('紧急联络人手机号码不合法!', '提示');
      return;
    }

    //默默保存
    $.ajax({
      type: "POST",
      url: contextPath + "new/m/updateUser",
      data:$('#myform').serialize(),
      success: function (data) {

      }
    });

    if($("#juxinli").val()!="1"){
      myApp.confirm('您还未进行手机验证！是否马上进行验证？','提示',function() {
        location.href = "<c:url value='/new/m/juxinliLimit/show'/>";
      });
    }else if($("#zhengxin").val()!="1"){
      myApp.confirm('您还未进行征信授权！是否马上进行征信授权？','提示',function() {
        location.href = "<c:url value='/new/m/creditReport/show'/>";
      });
    }else{

      //校验图片
      //门牌照
      if($("#count1").val()>0){
        myApp.alert("门牌照还剩" + $("#count1").val()  + "张未上传!", "提示");
        return false;
      }
      //门牌照
      if($("#count2").val()>0){
        myApp.alert("店内照还剩" + $("#count2").val()  + "张未上传!", "提示");
        return false;
      }

      myApp.alert("当前微信版本小企额暂不支持提交申请，请下载'小企额'APP完成提交！",'提示',function(){
        location.href = contextPath + "public/downloadApp";
      });
    }

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
        console.log(results);
        //将图像post到后台
        $.ajax({
          cache: false,
          type: "POST",
          url: "${wsCrmRestfulMerchantUrl}/merchants/${newMerchantUserModel.objectId}/checklists/"+ checklistId +"/files/" + results.origin.name,
          data: results.base64.substring(results.base64.indexOf(",") + 1),
          success: function (data) {
            myApp.hidePreloader();
            console.log(data);
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
              '<img class="thumbnailimg imgObj '+ classValue +'" src="' + data.url + '" />' +
              '<a class="delete-btn" sid="'+ data.objectId +'" ><img class="delete-img" src="<c:url value="/resources/newm/images/delete.png"/>" /></a>' +
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
                  $("#count1").val(data[0].lackFiles);
                  $("#count2").val(data[1].lackFiles);
                }

              });

            }

          } ,

          error: function (data) {
            myApp.hidePreloader();
            myApp.alert("上传失败！");
          },
          headers: {
            "X-CRM-Application-Id":"wechat",
            "X-CRM-Access-Token":"${accessToken}",
            "Content-Type":"text/base64"
          }
        });
      });
    });
  }

  //绑定删除图片事件
  function bindImageDeleteEvent() {
    //删除图片
    $(".delete-btn").click(function () {
      var obj =  $(this);
      var checklistId =obj.attr("checklistId");
      //调用服务器删除
      var fileId =obj.attr("sid");
      $.ajax({
        cache: false,
        type: "DELETE",
        url: "${wsCrmRestfulMerchantUrl}/merchants/${newMerchantUserModel.objectId}/files/" + fileId,
        data: {},
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
              $("#count1").val(data[0].lackFiles);
              $("#count2").val(data[1].lackFiles);
            }

          });
        },headers: {
          "X-CRM-Application-Id":"wechat",
          "X-CRM-Access-Token":"${accessToken}"
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

</script>
</body>
</html>
