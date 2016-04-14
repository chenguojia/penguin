<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=utf8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <title>卡得万利商业保理</title>

</head>
<body>
<!-- Status bar overlay for fullscreen mode-->
<div class="statusbar-overlay"></div>
<!-- Views-->
<div class="views" style="background-color: #efeff4;">
    <!-- Your main view, should have "view-main" class-->
    <div class="view view-main" style="background-color: #efeff4;">
        <!-- Top Navbar-->
        <div class="navbar login-title">
            <div class="navbar-inner">
                <div class="left"><a href="<c:url value="/new/m/home?step=1"/>" class="close-img"><img
                        src="<c:url value='/resources/image/left-arror.png'/>"> </a></div>
                <div class="login-title-word" style="margin-left: 17%; position: absolute; margin-top: 13px;">征信报告授权
                </div>
            </div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through" style="background-color: #efeff4;">
            <!-- Page, data-page contains page name-->
            <div data-page="login" class="page">

                <!-- Scrollable page content-->
                <div class="page-content">

                    <div class="bind-button">
                        <div class="float_l bind-button-font1 button-active credit-button1">
                            <button>有征信报告</button>
                        </div>
                        <div class="float_l bind-button-font2 credit-button2">
                            <button>无征信报告</button>
                        </div>
                    </div>

                    <div class="bind-part1 credit-part1">

                        <div class="content-block login-new">
                            <div class="list-block register-home credit-report-part1">
                                <ul>
                                    <li class="item-content apply-bottom">
                                        <div class="item-media">
                                            <span class="icon username_icon"><img
                                                    src="<c:url value='/resources/image/user.png'/>"></span>
                                        </div>
                                        <div class="item-inners">
                                            <div class="item-title">
                                                <input class="login_input" id="userName" name="userName" type="text"
                                                       placeholder="征信中心登录名">
                                            </div>
                                        </div>
                                    </li>
                                    <li class="item-content apply-bottom2">
                                        <div class="item-media">
                                            <span class="icon username_icon"><img
                                                    src="<c:url value='/resources/image/pinCode.png'/>"></span>
                                        </div>
                                        <div class="item-inners">
                                            <div class="item-title">
                                                <input class="login_input" id="passWord" name="passWord" type="password"
                                                       placeholder="征信中心密码">
                                            </div>
                                        </div>
                                    </li>
                                    <li class="item-content apply-bottom2 credit-report-content">
                                        <div class="item-media">
                                            <span class="icon username_icon"><img
                                                    src="<c:url value="/resources/image/key.png"/>"></span>
                                        </div>
                                        <div class="item-inners credit-report-font1">
                                            <div class="item-title">
                                                <input class="login_input" id="verityCode" name="verityCode" type="text"
                                                       placeholder="请输入图片验证码">
                                            </div>
                                        </div>
                                        <div class="item-media credit-report-pics">
                       <span class="icon username_icon" id="imgUrl">
                          <img class="credit-pics" src="${zhengxinMap.imgUrl}">
                          <input name="sessionId" value="${zhengxinMap.sessionId}" id="sessionId" type="hidden">
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
                                                <input class="login_input" id="tradeCode" name="tradeCode" type="text"
                                                       placeholder="身份验证码">
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>


                        <div class="padding-rl15 margin-t-5">

                            <div class="bind-font1 col-xs-8" style="padding-left: 0;">
                                <div class="float_l bank-bind-font1">
                                    <input type="checkbox" name="agree" id="agree-bindBank" checked/>
                                </div>
                                <div class="float_l bank-bind-font2">
                                    同意<span class="bind-font2 zhengxinxieyi">征信报告授权协议</span>
                                </div>
                            </div>

                            <div class="row col-xs-4" style="padding-right: 0; text-align: right; font-size: 13px; padding-top: 7px; margin-left: 5px;">
                                <a href="<c:url value="/info/getCreditReport?appId=2"/>">如何授权？</a>
                            </div>

                            <div class="bind-number-new2">
                                <a class="button button-big button-fill apply-button btn4" id="zhengxinCommitBtn7"
                                   href="#" style="width: 100%;">提交</a>
                            </div>
                        </div>

                    </div>


                    <div class="bind-part2 credit-part2 displaynone">

                        <div class="content-block login-new">


                            <c:forEach var="item" items="${zhengxinFile}" varStatus="i">
                                <ul id="photoGroup" stitle="${item.title}" lackFiles="${item.lackFiles}" style="list-style: none; padding: 3px 15px 15px; background-color: #ffffff;">
                                    <li>
                                        <div href="#" class="item-content">
                                            <div class="item-inner">
                                                <div class="pic-thumbnail-new">
                                                    <div class="row" id="photosDiv">
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
                                                                <a class="delete-btn" checklistId="${item.checklistId}"
                                                                   sid="${picItem.fileId}"><img class="delete-img"
                                                                                                src="<c:url value="/resources/image/delete.png"/>"/></a>
                                                            </div>
                                                        </c:forEach>

                                                            <%--添加图片操作按钮--%>
                                                        <div class="thumbnail-inner">
                                                            <img class="thumbnailimg-add"
                                                                 src="<c:url value="/resources/image/add-pic.png"/>"/>
                                                            <input class="upload-btn" accept="image/*"
                                                                   capture="camera" name="pictureFile"
                                                                   id="pictureFile1042" type="file"
                                                                   checklistId="42"/>
                                                                <%--checklistId="${item.checklistId}"/>--%>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </c:forEach>
                        </div>
                        <div class="padding-rl15 margin-t-5">
                            <div class="bind-font1">
                                您需要去当地人民银行申请个人征信报告，此申请可能需要耗费较长时间
                            </div>
                            <div class="bind-number-new2">
                                <a class="button button-big button-fill apply-button btn4" id="zhengxinCommitBtn6"
                                   href="#">提交</a>
                            </div>
                        </div>

                    </div>

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


    $(function () {

        $(".zhengxinxieyi").click(function () {
            location.href = "<c:url value="/regular/creditRegular?isApp=1"/>";
        });


        $("#zhengxinCommitBtn6").click(function () {

            //获取最少上传数量
            var lackFiles = parseInt($("#photoGroup").attr("lackFiles"));

            console.log("lackFiles = " + lackFiles);

            if (lackFiles > 0) {
                myApp.alert("征信报告至少上传" + lackFiles + "张！", '提示');
                return;
            }

            myApp.showPreloader('提交中...')
            $.ajax({
                type: "POST",
                url: "<c:url value="/new/m/creditReport"/>",
                data: {},
                success: function (data) {
                    if (data.updatedAt != null && data.updatedAt != '') {
                        //验证成功
                        location.href = "<c:url value="/new/m/home?step=1"/> "
                    } else {
                        myApp.alert(data.error);
                    }
                }
            });
        });


        //确认提交,征信用户名，密码和验证码
        $("#zhengxinCommitBtn7").click(function () {

            var buttonName = $(".button-active").find("button").html();

            if ($("#userName").val() == "") {
                myApp.alert("征信中心登录名不能为空", "提示");
                return false;
            }

            if ($("#passWord").val() == "") {
                myApp.alert("征信中心密码不能为空", "提示");
                return false;
            }

            if ($("#verityCode").val() == "" && buttonName == '有征信报告') {
                myApp.alert("请输入验证码", "提示");
                return false;
            }
            if ($("#tradeCode").val() == "") {
                myApp.alert("请输入身份验证码", "提示");
                return false;
            }
            myApp.showPreloader('正在验证...')
            $.ajax({
                cache: false,
                type: "POST",
                url: "<c:url value="/new/m/creditReport"/>",
                data: {
                    userName: $("#userName").val(),
                    passWord: $("#passWord").val(),
                    verityCode: $("#verityCode").val(),
                    tradeCode: $("#tradeCode").val(),
                    sessionId: $("#sessionId").val()
                },
                success: function (data) {
                    myApp.hidePreloader();
                    if (data.createdAt != undefined && data.createdAt != '') {
                        //验证成功
                        location.href = "<c:url value="/new/m/home?step=1"/> "

                    } else if (data.error != undefined && data.error != '' && data.imgUrl != undefined && data.imgUrl != '') {
                        //验证码输入错误
                        myApp.alert(data.error);
                        $(".credit-pics").attr("src", data.imgUrl);

                    } else {
                        //未知原因错误 creditReport.jsp
                        myApp.alert(data.error);
                    }

                }
            });

        });

        $("#imgUrl").click(function () {
            $.ajax({
                cache: false,
                type: "POST",
                url: "<c:url value="/new/m/getvVerifyCode"/>",
                data: {},
                success: function (data) {
                    //更新图片
                    $(".credit-pics").attr("src", data.imgUrl);
                }
            });

        });
    });


    $('.credit-button1').click(function () {
        $('.credit-part2').addClass('displaynone');
        $('.credit-part1').removeClass('displaynone');
        $('.credit-button1').addClass('button-active');
        $('.credit-button2').removeClass('button-active');
    });
    $('.credit-button2').click(function () {
        $('.credit-part1').addClass('displaynone');
        $('.credit-part2').removeClass('displaynone');
        $('.credit-button2').addClass('button-active');
        $('.credit-button1').removeClass('button-active');
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
                var url = "${wsCrmRestfulMerchantUrl}/merchants/${newMerchantUserModel.objectId}/checklists/" + checklistId + "/files/";
                var fileName = results.origin.name
                console.log("url = " + url);
                //将图像post到后台
                $.ajax({
                    cache: false,
                    type: "POST",
                    <%--url: "${wsCrmRestfulMerchantUrl}/merchants/${newMerchantUserModel.objectId}/checklists/" + checklistId + "/files/" + results.origin.name,--%>
                    <%--data: results.base64.substring(results.base64.indexOf(",") + 1),--%>
                    url: "<c:url value="/cross/domain/uploadfile"/>",
                    data: {
                        url: url,
                        fileName: fileName,
                        data: results.base64.substring(results.base64.indexOf(",") + 1)
                    },
                    success: function (res) {
                        var data = JSON.parse(res.resp);
                        myApp.hidePreloader();
                        console.log(data);
                        if (res.code == '-1') {
                            myApp.alert("上传失败，请稍后重试", "提示");
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
                                url: "<c:url value="/new/m/getSmallFiles"/>",
                                data: {},
                                success: function (data) {
                                    $("#photoGroup").attr("lackFiles",data[0].lackFiles);
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
                data: {url: url},
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
                        url: "<c:url value="/new/m/getSmallFiles"/>",
                        data: {},
                        success: function (data) {
                            $("#photoGroup").attr("lackFiles",data[0].lackFiles);
                        }

                    });
                }, headers: {
                    "X-CRM-Application-Id": "wechat",
                    "X-CRM-Merchant-Id": "${newMerchantUserModel.objectId}",
                    "X-CRM-Version": "2.0.0",
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
</script>
</body>
</html>