<%--
  Created by IntelliJ IDEA.
  User: guojia.chen
  Date: 2016/1/20
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
    <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
    <div class="pages">
      <!-- Page, data-page contains page name-->
      <div data-page="upload" class="page navbar-fixed">
        <!-- Top Navbar-->
        <div class="navbar login-title">
          <div class="navbar-inner">
            <div class="left"><a href="<c:url value="/new/m/home"/>" class="close-img"><img src="<c:url value='/resources/image/left-arror.png'/>"></a></div>
            <div class="center sliding login-title-word">消息中心</div>
          </div>
            <div class="content-block padding0 message-system" style="margin-top: 50px;">
                <!-- tabs控制面板 -->
                <div class="buttons-row system-message">
                    <!-- 关联到第一个tab, 默认激活 -->
                    <div id="query-tab1" class="tab-link message-tab1 active">用户消息</div>
                    <!-- 关联到第二个tab -->

                    <div id="query-tab2" class="tab-link message-tab1">系统消息</div>

                </div>
            </div>
        </div>
        <!-- Scrollable page content-->
        <div class="page-content" style="padding-top: 95px;">
          <%--<div class="content-block padding0 message-system">--%>
            <%--<!-- tabs控制面板 -->--%>
            <%--<div class="buttons-row system-message">--%>
              <%--<!-- 关联到第一个tab, 默认激活 -->--%>
              <%--<a href="#tab1" class="tab-link message-tab1 ${type != 1 ? 'active' : '' } ">用户消息</a>--%>
              <%--<!-- 关联到第二个tab -->--%>
              <%--<a href="#tab2" class="tab-link message-tab1 ${type == 1 ? 'active' : '' }">系统消息</a>--%>
            <%--</div>--%>
          <%--</div>--%>
          <!-- Tabs, 标签内容区容器 -->
          <div class="tabs message-tab">
            <!-- Tab 1, 默认激活 -->
            <%--<div id="tab1" class="tab ${type != 1 ? 'active' : '' } ">--%>
            <div id="tab1" class="tab active">
              <div class="list-block media-list uploadfile-block margin-b0">
                <input type="hidden" name="type" class="type" value="0">
                <c:forEach items="${infoMap.infoUser}" var="item" varStatus="i">
                  <%--<a href="<c:url value="/info/queryInfoDetail?infoId=${item.id}&type=0"/>">--%>
                    <div class="message-block" style="overflow: hidden;">
                        <input name="infoId" type="hidden" value="${item.id}" class="infoId">
                      <div class="message-contents">
                        <div class="float_l message-block-part1">
                            <img style="margin-left: 15px; margin-right: 15px;" class="thumbnailimg" src="<c:url value="/resources/image/laba.png"/>"/>
                            <c:if test="${item.readTime == 'null' || item.readTime == null}">
                                 <div class="query-info-point"></div>
                            </c:if>
                        </div>
                        <div class="float_l message-block-part2" sid="${item.id}" stype="0">
                          <div class="float_l message-font2" style="width: 42%; height: 22px; overflow: hidden;"><input style="width: 100%; text-overflow: ellipsis; border: none;" value="${item.title}" readonly></div>
                          <div class="float_r message-font3">${item.createTime}</div>
                          <div class="float_clear message-font4">${item.content}</div>
                        </div>
                        <div class="float_l message-block-part3 delete">删除</div>
                      </div>
                    </div>
                  <%--</a>--%>
                </c:forEach>
              </div>
            </div>
            <!-- Tab 2 -->
            <%--<div id="tab2" class="tab ${type == 1 ? 'active' : '' } ">--%>
            <div id="tab2" class="tab">
              <div class="list-block media-list uploadfile-block margin-b0">
                <input type="hidden" name="type" class="type" value="1">
                <c:forEach items="${infoMap.infoSystem}" var="item" varStatus="i">
                  <%--<a href="<c:url value="/info/queryInfoDetail?infoId=${item.id}&type=1"/>">--%>
                      <div class="message-block" style="overflow: hidden;">
                          <input name="infoId" type="hidden" value="${item.id}" class="infoId">
                          <div class="message-contents">
                            <div class="float_l message-block-part1">
                                <img style="margin-left: 15px; margin-right: 15px;" class="thumbnailimg" src="<c:url value="/resources/image/laba.png"/>"/>
                                <c:if test="${item.readTime == 'null' || item.readTime == null}">
                                    <div class="query-info-point"></div>
                                </c:if>
                            </div>
                            <div class="float_l message-block-part2"  sid="${item.id}" stype="1">
                              <div class="float_l message-font2" style="width: 42%; height: 22px; overflow: hidden;">${item.title}</div>
                              <div class="float_r message-font3">${item.createTime}</div>
                              <div class="float_clear message-font4" style="padding-top: 10px;">${item.content}</div>
                            </div>
                            <div class="float_l message-block-part3 delete">删除</div>
                          </div>
                      </div>
                  <%--</a>--%>
                </c:forEach>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>


<script type="text/javascript" src="<c:url value="/resources/js/modernizr.custom.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/classie.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.touchSwipe.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/modernizr.custom.js"/>"></script>
<%--add by guojia.chen--%>
<script type="text/javascript">

  $(function(){

      $(".message-block-part2").click(function(){
          var infoId = $(this).attr("sid");
          var type = $(this).attr("stype");
          console.log("infoId=" + infoId + ",type=" + type);
          var url = 'info/queryInfoDetail?infoId='+infoId+'&type='+type;
          location.href=contextPath +url;

      });

    $(".delete").click(function(){
      var infoId = $(this).prev().find("input[name=infoId]").val();
      var type = $(this).parent().parent().parent().find("input[name=type]").eq(0).val();
      $(this).parent().parent().addClass("deleteCurrent");
      $.ajax({
        type: "GET",
        url: "<c:url value="/info/deleteInfo"/>",
        data: {infoId:infoId,type:type},
        success: function (data) {
            if(data.code==1 || data.code=='1'){
                $(".deleteCurrent").hide();
            }else{
                myApp.alert("删除失败！请稍后重试！","提示");
            }
        }
      });

    });
  });
</script>
<%--add by chenxiaoling--%>
<script type="text/javascript">
  var scrollCurrent = 0;
  var screenWidth = $(window).width();
  var screenHeight = $(window).height();
  var clickNumber = 0;
  var marginTop;
//  删除按钮
  $(function() {

    $(".message-contents").swipe( {
      swipeStatus:function(event, phase, direction, distance, duration,fingerCount) {
        var currentPosition = $(this).css('margin-left');
        if(phase == 'end' && direction == 'left'){
          $(this).css('margin-left', '-70px')
        }
        else if(direction == 'right' && phase =='end'){
          $(this).css('margin-left', '0px')
//            $('.query-info-point').css('margin-left', '66px');
        }
        else if(phase == 'move' && currentPosition !== '-70px;' && direction == 'left' && distance < 50){
          $(this).css('margin-left', -distance + 'px');
//          $('.query-info-point').css('margin-left', 66-distance + 'px');
        }
        else if(phase == 'move' && distance > 50 && direction == 'left'&& currentPosition !== '-70px;'){
          $(this).css('margin-left', '-70px')
        }
        else if(phase == 'move' && currentPosition !== '-70px;' && direction == 'left' && distance > 50){
          $(this).css('margin-left', '0px');
//            $('.query-info-point').css('margin-left', '66px');
        }
        else if(direction == 'up' && phase =='move'){
            var tabTop = parseInt(marginTop);
            var tabResult = $('#tab2').height() - screenHeight - tabTop;
            if(distance <= tabResult){
                $('.tab').css('margin-top', tabTop-distance +'px')
            }
        }
        else if(direction == 'down' && phase =='move'){
            var tabTop2 = parseInt(marginTop);
            if(distance <= tabTop2){
                $('.tab').css('margin-top', distance +'px')
            }
            else{
                $('.tab').css('margin-top', '0px')
            }
        }
        else if(phase =='end'){
            marginTop = $('.tab').css('margin-top');
            var tabTop = parseInt(marginTop);
            var tabResult = $('#tab2').height() - screenHeight + tabTop;
            var results3 = $('#tab2').height() - screenHeight + 90;
            if(tabResult < 0){
                $('.tab').css('margin-top', - results3 +'px')
            }
        };

      }
    });

    var messageDele = screenWidth - 100;
    var messageDelePart = screenWidth + 70;
    $('.message-block-part2').css('width', messageDele + 'px');
    $('.message-contents').css('width', messageDelePart + 'px');

    $('#query-tab1').click(function(){
        $(this).addClass('active').siblings().removeClass('active');
        $('#tab1').addClass('active').siblings().removeClass('active');
    });

      $('#query-tab2').click(function(){
          $(this).addClass('active').siblings().removeClass('active');
          $('#tab2').addClass('active').siblings().removeClass('active');
      });
  });
</script>
</body>
</html>
