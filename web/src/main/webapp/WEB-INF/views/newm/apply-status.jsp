<%--
  Created by IntelliJ IDEA.
  User: guojia.chen
  Date: 2016/1/14
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- Status bar overlay for fullscreen mode-->
<div class="statusbar-overlay"></div>
<!-- Views-->
<div class="views">
  <!-- Your main view, should have "view-main" class-->
  <div class="view view-main">
    <!-- Top Navbar-->
    <%--<div class="navbar login-title">
      <div class="navbar-inner">
        <div class="left"><a href="#" class="close-img"><img src="<c:url value="/resources/image/left-arror.png"/>"> </a></div>
        <div class="center sliding login-title-word">银行卡绑定</div>
      </div>
    </div>--%>
    <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
    <div class="pages navbar-through toolbar-through">
      <!-- Page, data-page contains page name-->
      <div data-page="login" class="page">

        <!-- Scrollable page content-->
        <div class="page-content" style="padding-top: 0px;">
          <!--申请成功-->
          <div class="apply-success displaynone">
            <div class="apply-success-part1">
              <img src="<c:url value="/resources/image/apply-success.png"/> ">
            </div>
            <div class="apply-success-part2">
              <span>申请完成</span>
            </div>
            <div class="apply-success-part3">
              <button class="btn apply-success-button " id="continusLoan">我要续贷</button>
            </div>
          </div>
          <!--申请中-->
          <div class="apply-applying displaynone">
            <div class="apply-applying-part1">
              <img src="<c:url value="/resources/image/apply-status.png"/> ">
            </div>
            <div class="apply-applying-part2">
              <div class="applying-font1">处理中</div>
              <div class="applying-font2">我们正在处理您提交的的申请信息，请耐心等待!</div>
            </div>
          </div>
          <!--申请失败-->
          <div class="apply-failed displaynone">
            <div class="apply-failed-part1">
              <img src="<c:url value="/resources/image/apply-failed.png"/>">
            </div>
            <div class="apply-failed-part2">
              <div class="failed-font1">申请失败</div>
              <c:if test="${applicationModel.statusDetail!='' && applicationModel.statusDetail!=null}">
                <%--失败原因--%>
                <div class="failed-font4">${applicationModel.statusDetail}</div>
              </c:if>
              <div class="failed-font2">我们非常抱歉的通知您，经过我们认真审核，您的融资申请目前暂时无法受理。对于由此造成的不便，我们深表歉意。</div>
              <div class="failed-font3">如果您有任何疑问，请拨打我们的客服热线：</div>
              <div class="failed-font4"><img src="<c:url value="/resources/image/callUs.png"/> ">4008-803-803</div>
            </div>
          </div>

        </div>
      </div>
    </div>
  <input id="currentStatus" value="${applicationModel.status}" type="hidden">
  </div>
</div>


<script type="text/javascript">
   $(function(){
     var currentStatus = $("#currentStatus").val();
     if(currentStatus=='提现中'){
       if(!$(".apply-success").eq(0).hasClass('displaynone')){
         $(".apply-success").eq(0).addClass('displaynone');
       }
       if($(".apply-applying").eq(0).hasClass('displaynone')){
         $(".apply-applying").eq(0).removeClass('displaynone');
       }
       if(!$(".apply-failed").eq(0).hasClass('displaynone')){
         $(".apply-failed").eq(0).addClass('displaynone');
       }

     }else if(currentStatus=='审核未通过'){
         if(!$(".apply-success").eq(0).hasClass('displaynone')){
           $(".apply-success").eq(0).addClass('displaynone');
         }
         if(!$(".apply-applying").eq(0).hasClass('displaynone')){
           $(".apply-applying").eq(0).addClass('displaynone');
         }
         if($(".apply-failed").eq(0).hasClass('displaynone')){
           $(".apply-failed").eq(0).removeClass('displaynone');
         }
     }else if(currentStatus=='申请未通过'){
       if(!$(".apply-success").eq(0).hasClass('displaynone')){
         $(".apply-success").eq(0).addClass('displaynone');
       }
       if(!$(".apply-applying").eq(0).hasClass('displaynone')){
         $(".apply-applying").eq(0).addClass('displaynone');
       }
       if($(".apply-failed").eq(0).hasClass('displaynone')){
         $(".apply-failed").eq(0).removeClass('displaynone');
       }
     }else if(currentStatus=='已完成'){
         if($(".apply-success").eq(0).hasClass('displaynone')){
           $(".apply-success").eq(0).removeClass('displaynone');
         }
         if(!$(".apply-applying").eq(0).hasClass('displaynone')){
           $(".apply-applying").eq(0).addClass('displaynone');
         }
         if(!$(".apply-failed").eq(0).hasClass('displaynone')){
           $(".apply-failed").eq(0).addClass('displaynone');
         }
     }else{
         if(!$(".apply-success").eq(0).hasClass('displaynone')){
           $(".apply-success").eq(0).addClass('displaynone');
         }
         if($(".apply-applying").eq(0).hasClass('displaynone')){
           $(".apply-applying").eq(0).removeClass('displaynone');
         }
         if(!$(".apply-failed").eq(0).hasClass('displaynone')){
           $(".apply-failed").eq(0).addClass('displaynone');
         }
     }


    //续贷
     $("#continusLoan").click(function(){
       <%--alert("${applicationModel.isEnabled}" == "0" || "${applicationModel.cashadvanceStatus}" == "关闭");--%>
       if ("${applicationModel.isEnabled}" == "0" || "${applicationModel.cashadvanceStatus}" == "关闭") {
         //先创建一条申请，再跳转到申请编辑界面
         myApp.showPreloader('加载中...')
         $.ajax({
           type: "POST",
           url: contextPath + "new/m/applyStatus",
           data: {},
           success: function (data) {
             if (data.resultCode == "-1") {
               myApp.hidePreloader();
               myApp.alert(data.resultMsg,'提示');
             } else {
               location.href = "<c:url value='/new/m/home?step=0'/>";
             }
           }
         });
       } else {
         //直接跳转申请编辑界面
         location.href = "<c:url value='/new/m/home?step=0'/>";
       }

     });

   })

</script>

