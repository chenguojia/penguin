<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head></head>
<body>
<div class="views" style="position:absolute; margin:0; padding:0; border:0; top:0;">
    <!-- Your main view, should have "view-main" class-->
    <div class="view view-main">
        <!-- Top Navbar-->
        <div class="navbar login-title">
            <div class="navbar-inner">
                <div class="left"><a href="<c:url value='/new/m/more'/>" class="close-img"><img src="<c:url value="/resources/image/left-arror.png"/>"></a></div>
                <div class="center sliding login-title-word">意见反馈</div>
            </div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page">
                <!-- Scrollable page content-->
                <div class="page-content">
                    <div>
                        <div class="list-block uploadfile-block margin-t15 margin-b0 comment-textarea">
                            <ul>
                                <li>
                                    <div class="item-content">
                                        <div class="item-inner">
                                            <div class="item-title" style="width: 100%;padding: 0">
                                                <textarea class="commentsTextarea" rows="5" style="height: 116px;" name="content" id="content" onkeyup="checkNull();"></textarea>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <div class="comments-explain">您的声音，我们倾听</div>
                        <div class="list-block uploadfile-block comments-margin">
                            <ul>
                                <li>
                                    <div class="item-content">
                                        <div class="item-inner">
                                            <div class="item-title comments-fonts">
                                                <input class="login_input" type="text" maxlength="100" name="connection" id="connection" onkeyup="checkNull();" placeholder="请留下您的联系方式：手机号/qq/邮箱">
                                            </div>
                                        </div>
                                    </div>
                                </li>

                            </ul>
                        </div>

                        <div class="list-block media-list myaccount comments-pics">
                            <ul>
                                <li>
                                    <div href="#" class="item-content">
                                        <div class="item-inner">
                                            <div class="pic-thumbnail-new">
                                                <div class="row">
                                                    <div class="thumbnail-inner">
                                                        <%--<img id="addImage" src="data:image/png;base64,这里放字符"/>--%>
                                                        <img class="thumbnailimg-add" id="addImage" src="<c:url value="/resources/image/add-pic.png"/>"/>
                                                        <input class="upload-btn" accept="image/*" capture="camera"  name="pictureFile"  id="pictureFile"  type="file"  />
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </li>
                            </ul>
                        </div>




                        <div class="padding-rl15 comments-button">
                            <a class="button  button-big comments-button1 comments-gray" disabled="disabled" href="#" id="submitBtn">提交</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>

    var myApp = new Framework7({
        modalTitle: '卡得万利商业保理',
        ajaxLinks: 'a.ajax'
    });

    var numArr = []; // 定义一个空数组,存放图片
    var type = [];//存放图片名称

    //提交
    $("#submitBtn").click(function () {
        var content = $.trim($("#content").val());
        var connection = $.trim($("#connection").val());
        if(content=="" || content==null){
            myApp.alert('意见反馈内容不能为空！', '提示');
            return;
        }
        if(content.length>200){
            myApp.alert('意见反馈内容长度不能超过200个字节！', '提示');
            return;
        }
        if(content.length<5){
            myApp.alert('意见反馈内容长度不能少于5个字节！', '提示');
            return;
        }
        if(connection=="" || connection==null){
            myApp.alert('联系方式不能为空！', '提示');
            return;
        }
        if(connection.length>100){
            myApp.alert('联系方式长度不能超过100个字节！', '提示');
            return;
        }
        if(connection.length<5){
            myApp.alert('联系方式长度不能少于5个字节！', '提示');
            return;
        }
        var dataList = "";
        var nameList = "";
        for(var i=0;i<numArr.length;i++){
            dataList = dataList + numArr[i] +"@&@";
            nameList = nameList + type[i] +"@&@";
        }

        //验证成功，提交FORM
        myApp.showPreloader('提交中...')
        $.ajax({
            type: "POST",
            url: '<c:url value="/new/m/feedback/content"/>',
            data: {"content": content,"connection": connection,"dataList":dataList,"nameList":nameList},
            success: function (data) {
                myApp.hidePreloader();
                if (data.resultCode == "-1") {
                    myApp.alert(data.resultMsg,'提示');
                } else {
                    myApp.alert(data.resultMsg,'提示',function(){
                        //成功
                        location.href = contextPath + "new/m/more";
                    });
                }
            }
        });
    });


    function checkNull(){
        var content = $.trim($("#content").val());
        var connection = $.trim($("#connection").val());
        if( (content!="" && content!=null) && (connection!="" && connection!=null) ){
            $('.comments-button1').removeClass("comments-gray").addClass("account-button");
            $("#submitBtn").attr('disabled',false);//设置disabled属性为false，按钮可用
        }else{
            $('.comments-button1').removeClass("account-button").addClass("comments-gray");
            $("#submitBtn").attr('disabled',true);//设置disabled属性为true，按钮不可用
        }
    }

    $('.comment-textarea').click(function(){
        $('.comments-explain').css("display","none");
//        $('.comments-button1').removeClass("comments-gray").addClass("account-button");
    });
    $('.comments-explain').click(function(){
        $('.comments-explain').css("display","none");
        $('.commentsTextarea').focus();
//        $('.comments-button1').removeClass("comments-gray").addClass("account-button");
    });
    $('.comments-button').click(function() {
        $('.comments-button1').css("background-color", "#8abbe3")
    });

//    //绑定事件
    $("input[name='pictureFile']").change(function () {
//        myApp.alert(this.files[0].naturalWidth);
        lrz(this.files[0], {width: 900}, function (results) {
//            $("#addImage").attr("src",results.base64);
            //追加HTML
            $("#addImage").parent().before('' +
            '<div class="thumbnail-inner imgDiv">' +
            '<img class="thumbnailimg imgObj '+ "width-large" +'" src="' + results.base64 + '" />' +
            '<a class="delete-btn"><img class="delete-img" src="<c:url value="/resources/image/delete.png"/>" /></a>' +
            '</div>');
            numArr.push(results.base64);
            type.push(results.origin.name);
            console.log(results.origin);
            console.log(results);
        })
    });
    //删除图片
    $("body").delegate(".delete-btn","click",function(){
       $(this).parents(".imgDiv").remove();
    })

    //图片预览
    $("body").delegate(".imgObj","click",function(){
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
    })


</script>


</body>
</html>