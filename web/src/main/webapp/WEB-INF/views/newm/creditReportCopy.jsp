<%--
  Created by IntelliJ IDEA.
  User: guojia.chen
  Date: 2015/11/23
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=utf8" %>
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
  <div class="view view-main login-background">
    <!-- Top Navbar-->
    <div class="navbar login-title">
      <div class="navbar-inner">
        <div class="left"><a href="<c:url value="/new/m/home"/> " class="close-img"><img src="<c:url value='/resources/image/left-arror.png'/>"></a></div>
        <div class="center sliding login-title-word">征信报告授权</div>
      </div>
    </div>
    <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
    <div class="pages navbar-through toolbar-through">
      <!-- Page, data-page contains page name-->
      <div data-page="login" class="page">
        <!-- Scrollable page content-->

        <form id="formName" method="post" action="<c:url value="/new/m/creditReport"/>">
        <div class="page-content">
          <div class="content-block login-new credit-report-pages">
            <div class="list-block credit-report">
              <ul>
                <li class="item-content apply-bottom">
                  <div class="item-media">
                    <span class="icon username_icon"><img src="<c:url value="/resources/image/user.png" />"></span>
                  </div>
                  <div class="item-inners">
                    <div class="item-title">
                      <input class="login_input" id="userName" name="userName" type="text" placeholder="征信中心登录名">
                    </div>
                  </div>
                </li>
                <li class="item-content apply-bottom2">
                  <div class="item-media">
                    <span class="icon username_icon"><img src="<c:url value="/resources/image/pinCode.png"/>"></span>
                  </div>
                  <div class="item-inners">
                    <div class="item-title">
                      <input class="login_input" id="passWord" name="passWord" type="password" placeholder="征信中心密码">
                    </div>
                  </div>
                </li>
                <li class="item-content apply-bottom2 credit-report-content">
                  <div class="item-media">
                    <span class="icon username_icon"><img src="<c:url value="/resources/image/key.png"/>"></span>
                  </div>
                  <div class="item-inners credit-report-font1">
                    <div class="item-title">
                      <input class="login_input" id="verityCode" name="verityCode" type="text" placeholder="请输入图片验证码">
                    </div>
                  </div>
                  <div class="item-media credit-report-pics">
                    <span class="icon username_icon" id="imgUrl">
                      <img  class="credit-pics" src="${map.imgUrl}">
                      <input name="sessionId" value="${map.sessionId}" id="sessionId" type="hidden">
                    </span>
                  </div>
                </li>
              </ul>
            </div>

            <div class="list-block identify-block">
              <ul>
                <li class="item-content apply-bottom">
                  <div class="item-mediav identify-card">
                    <span class="icon username_icon"></span>
                  </div>
                  <div class="item-inners">
                    <div class="item-title">
                      <input class="login_input" id="tradeCode" name="tradeCode" type="text" placeholder="身份验证码">
                    </div>
                  </div>
                </li>
              </ul>
            </div>

            <div class="row">
              <div class="credit-checkbox"><input id="checkboxOneInput" type="checkbox" ></div>
              <div class="float_l"><label class="credit-font2" for="checkboxOneInput">同意</label><a class="credit-font3">《征信报告授权协议》</a></div>
              <div class="float_r"><a href="http://www.cvbaoli.com/webak/public/getCreditReport?appId=2" class="credit-font4">如何授权?</a></div>
            </div>
          </div>
          <div class="padding-rl15">
            <div class="bind-number credit-but">
              <a class="button button-big button-fill apply-button" href="#">确认提交</a>
            </div>
          </div>
        </div>
        </form>
      </div>
    </div>

    <script>

      var myApp = new Framework7({
        modalTitle: '卡得万利商业保理',
        ajaxLinks: 'a.ajax'
      });

      $(function(){

        //确认提交
        $(".apply-button").click(function(){

            if($("#userName").val()==""){
              myApp.alert("征信中心登录名不能为空","提示");
              return false;
            }

            if($("#passWord").val()==""){
              myApp.alert("征信中心密码不能为空","提示");
              return false;
            }

            if($("#verityCode").val()==""){
              myApp.alert("请输入验证码","提示");
              return false;
            }
            if($("#tradeCode").val()==""){
              myApp.alert("请输入身份验证码","提示");
              return false;
            }
          myApp.showPreloader('正在验证...')
          $.ajax({
            cache: false,
            type: "POST",
            url: "<c:url value="/new/m/creditReport"/>",
            data: {userName:$("#userName").val(),passWord:$("#passWord").val(),verityCode:$("#verityCode").val(),tradeCode:$("#tradeCode").val(),sessionId:$("#sessionId").val()},
            success: function (data) {
              myApp.hidePreloader();
              if(data.createdAt!=undefined && data.createdAt!=''){
                //验证成功
                location.href = "<c:url value="/new/m/uploadFile/show"/> "

              }else if(data.error!=undefined && data.error!='' && data.imgUrl!=undefined && data.imgUrl!=''){
              //验证码输入错误
                myApp.alert(data.error);
                $(".credit-pics").attr("src",data.imgUrl);

              }else{
                //未知原因错误
                myApp.alert(data.error);
              }

            }
          });

        });

        $("#imgUrl").click(function(){
          $.ajax({
            cache: false,
            type: "POST",
            url: "<c:url value="/new/m/getvVerifyCode"/>",
            data: {},
            success: function (data) {
              //更新图片
              $(".credit-pics").attr("src",data.imgUrl);
            }
          });

        });
      });

    </script>
  </div>
</div>
</body>
</html>
