<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <script type="text/javascript" src="<c:url value='/resources/js/jquery.easing.1.3.js'/>"></script>
    <%--<script type="text/javascript" src="<c:url value='/resources/newm/js/jquery-1.8.2.js'/>"></script>--%>
</head>
<body>
<!-- Views-->
<div class="views">
    <!-- Your main view, should have "view-main" class-->
    <div class="view view-main">
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages">
            <!-- Page, data-page contains page name-->
            <div data-page="home" class="page">
                <!-- Scrollable page content-->
                <div class="page-content page-content-13">
                    <div class="home">
                        <div class="header header-new-page">
                            <div class="mylimit mylimit-new-page">
                                <div class="finance"><span>融资</span></div>
                            </div>
                            <div>
                                <div class="circle-new circle-new-page">
                                    <!--手机画圆-->
                                    <div id="radius-paint"></div>

                                    <div class="limit-txt">
                                        <div class="limit-title-new limit-title-13">我的额度</div>
                                        <div class="limit-num-new limit-num-new-13">
                                            <%--<span class="icon-rmb-new">¥</span><span class="timer count-title" id="count-number" data-to="80000" data-speed="1500"></span>--%>
                                            <span class="icon-rmb-new">¥</span><c:if test="${!empty applicationModel.amountRequested}"><span class="timer count-title" id="count-number" data-to="<fmt:parseNumber integerOnly="true" value="${applicationModel.amountRequested}" />" data-speed="1500"></span></c:if> <c:if test="${empty applicationModel.amountRequested}">0</c:if>
                                        </div>
                                    </div>
                                </div>
                                <div class="add-more add-more-13">
                                    <!--当只有一个按钮-->
                                    <!--<a class="button button-round up-limit-new up-limit-13" href="upgrade-limit.html">立即申请</a>-->
                                    <!--当有两个按钮-->
                                    <div class="add-more-two-button-13">
                                        <c:if test="${empty applicationModel.creditId || empty applicationModel.amountRequested ||  applicationModel.amountRequested < 1}">
                                            <%--1. 表示全新商户第一次进入，则显示1个按钮 “核算额度”--%>
                                            <a class="button button-round up-limit-new" href="<c:url value='/new/m/myLimit'/>">核算额度</a>
                                        </c:if>
                                        <c:if test="${!(empty applicationModel.creditId || empty applicationModel.amountRequested ||  applicationModel.amountRequested <1 ) }">

                                            <c:choose>
                                                <c:when test="${applicationModel.isDocumentLocked != '1'}">
                                                    <%--2. 表示有了额度《基础或POS》但还未提交申请《还未创建申请和创建申请了还未提交》，则显示2个按钮 左：“提升额度”  右：“立即申请”--%>
                                                    <%--<a class="button up-limit-two-button" href="<c:url value='/new/m/myLimit'/>">提升额度</a>--%>
                                                    <a class="button up-limit-two-button" href="<c:url value='/new/m/basicLimit/show'/>">提升额度</a>
                                                    <a class="button up-limit-two-button2" href="<c:url value='/new/m/uploadFile/show'/>">立即申请</a>
                                                </c:when>

                                                <c:when test="${applicationModel.cashadvanceStatus == '还款清算'}">
                                                    <a class="button button-round up-limit-new" href="<c:url value='/new/m/refundDetail?baoliId=${applicationModel.cashadvanceId}&sourceType=2'/>">查看账单</a>
                                                </c:when>

                                                <c:when test="${applicationModel.cashadvanceStatus == '批准'}">
                                                    <a class="button button-round up-limit-new" href="<c:url value='/new/m/affirmLoans/show'/>">提现确认</a>
                                                </c:when>

                                                <c:when test="${applicationModel.cashadvanceStatus == '待补件'}">
                                                    <a class="button button-round up-limit-new" href="<c:url value='/new/m/addFile/show?sourceType=2'/>">补全资料</a>
                                                </c:when>

                                                <c:when test="${applicationModel.verifyVideoStatus == '2'}">
                                                    <a class="button button-round up-limit-new" href="#" id="videoBtn">重新视频认证</a>
                                                </c:when>

                                                <c:when test="${applicationModel.cashadvanceStatus == '关闭'}">
                                                    <a class="button button-round up-limit-new" href="#" id="continueBtn">我要续贷</a>
                                                </c:when>
                                                <c:otherwise>
                                                    <a class="button button-round up-limit-new" href="<c:url value='/new/m/uploadFile/show?isView=1'/>">查看申请</a>
                                                </c:otherwise>
                                            </c:choose>

                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="current-steps">
                            <span>当前进度</span>
                        </div>

                        <div id="stepBar" class="ui-stepBar-wrap ui-stepBar-wrap-13">
                            <div class="ui-stepBar">
                                <div class="ui-stepProcess"></div>
                            </div>
                            <div class="ui-stepInfo-wrap">
                                <table class="ui-stepLayout" border="0" cellpadding="0" cellspacing="0">
                                    <tr>
                                        <td class="ui-stepInfo">
                                            <a class="ui-stepSequence"></a>
                                            <a class="ui-stepSequence-point"></a>
                                        </td>
                                        <td class="ui-stepInfo">
                                            <a class="ui-stepSequence"></a>
                                            <a class="ui-stepSequence-point" style=""></a>
                                        </td>
                                        <td class="ui-stepInfo">
                                            <a class="ui-stepSequence"></a>
                                            <a class="ui-stepSequence-point" style=""></a>
                                        </td>
                                        <td class="ui-stepInfo">
                                            <a class="ui-stepSequence"></a>
                                            <a class="ui-stepSequence-point" style=""></a>
                                        </td>
                                        <td class="ui-stepInfo">
                                            <a class="ui-stepSequence"></a>
                                            <a class="ui-stepSequence-point" style=""></a>
                                        </td>
                                    </tr>
                                </table>
                                <div class="ui-stepInfo-words" style="position: absolute; width: 100%;">
                                    <c:forEach var="item" items="${process}">
                                        <p class="ui-stepName ui-stepNameColor">${item.proTitle}</p>
                                    </c:forEach>
                                    <%-- <p class="ui-stepName ui-stepNameColor">提升额度</p>
                                     <p class="ui-stepName ui-stepNameColor">提交申请</p>
                                     <p class="ui-stepName ui-stepNameColor" style="width: 17%;">审核中</p>
                                     <p class="ui-stepName ui-stepNameColor">提现确认</p>
                                     <p class="ui-stepName ui-stepNameColor">已完成</p>--%>
                                </div>
                            </div>
                        </div>

                        <div class="clearfix height20"></div>

                    </div>
                </div>
            </div>
        </div>
        <div class="toolbar tabbar tabbar-labels">
            <div class="toolbar-inner">
                <a href="<c:url value='/new/m/home'/>" class="tab-link active">
                    <%--<i class="icon money-icon"><span class="badge bg-red">1</span></i>--%>
                    <i class="icon money-icon"><span class="badge bg-red"></span></i>
                    <span class="tabbar-label">融资</span>
                </a>
                <a href="<c:url value='/new/m/account'/>" class="tab-link">
                    <i class="icon account-icon"></i>
                    <span class="tabbar-label">账户</span>
                </a>
                <a href="<c:url value='/new/m/more'/>" class="tab-link">
                    <i class="icon more-icon"></i>
                    <span class="tabbar-label">更多</span>
                </a>
            </div>
        </div>
    </div>
</div>
<!-- Path to Framework7 Library JS-->
<script type="text/javascript" src="lib/framework7/js/framework7.min.js"></script>

<script language="javascript" type="text/javascript">
    var myApp = new Framework7({
        modalTitle: '卡得万利商业保理',
        ajaxLinks: 'a.ajax'
    });

    //进度条
    $(function(){
        stepBar.init("stepBar", {
            step : ${currentStep},//截止到第几步
            change : true,
            animation : true
        });
    });
    var screenHeight = $(document.body).height();
    var screenWidth = $(document.body).width();
    if(screenHeight>500 && screenWidth<767){
        $('.text-line-height').removeClass('text-line-height');
    };

    //判断屏幕宽度，确定画的圈的大小
    if (screenWidth < 767){
        $('#radius-paint').html('<canvas id="myCanvas" width="320" height="335"></canvas>');
    }
    else{
        $('#radius-paint').html('<canvas id="myCanvas" width="308" height="308"></canvas>');
    };

    //画圆
    var canvas = document.getElementById('myCanvas'),width = canvas.width,height = canvas.height,ctx = canvas.getContext('2d');
    var step,startAngle,endAngle,add=Math.PI*2/100;
    ctx.shadowOffsetX = 0; // 设置水平位移
    ctx.shadowOffsetY = 0; // 设置垂直位移
    ctx.shadowBlur = 10; // 设置模糊度
    ctx.lineWidth = 1.0; //线条宽度
    counterClockwise = false;
    var x;
    var y;
    var radius;
    var animation_interval = 15,n = 100;//速度和步数
    var varName;

    function actiondo(){
        step=1;
        startAngle=90;//画圆开始角度
        ctx.strokeStyle = "#2485d6";//线条颜色
        //圆心位置
        x = width/2;
        y = height/2;
        radius = width/2-30;//半径
        varName= setInterval(animation, animation_interval);
    }
    var animation = function () {
        if (step <= n) {
            endAngle = startAngle + add ;
            drawArc(startAngle-0.01, endAngle);
            startAngle = endAngle;
            step++;
        } else {
            clearInterval(varName);
        }

    };
    function drawArc(s, e) {
        ctx.beginPath();
        ctx.arc(x, y, radius, s, e, counterClockwise);
        ctx.lineWidth = 5.0;//线条宽度
        ctx.stroke();
    }
    window.onload=actiondo();

    // start all the timers
    $('.timer').each(count);//滚动数字


    $("#continueBtn").click(function(){
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
                        location.href = "<c:url value='/new/m/uploadFile/show'/>";
                    }
                }
            });
        } else {
            //直接跳转申请编辑界面
            location.href = "<c:url value='/new/m/uploadFile/show'/>";
        }

    });

    $("#videoBtn").click(function(){
        myApp.alert("当前微信版本小企额暂不支持视频认证，请下载“小企额”客户端进行视频认证！",'提示',function(){
            location.href = contextPath + "public/downloadApp";
        });
    });
</script>
</body>
</html>