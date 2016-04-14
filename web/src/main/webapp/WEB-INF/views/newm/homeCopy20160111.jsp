<!DOCTYPE html>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <title>卡得万利商业保理</title>
    <!--main css-->
    <link rel="stylesheet" href="<c:url value='/resources/css/newHomepage.css'/>">

</head>
<body>
<!-- Views-->
<div class="views">
    <!-- Your main view, should have "view-main" class-->
    <div class="view view-main login-background">

        <div class="home-page-backs displaynone">
            <div class="basic-limit-alert-content">
                <div class="basic-alert-part1">
                    <span>添加POS机能够帮助您获取更高的额度。</span>
                </div>
                <div class="basic-alert-part2">
                    <span class="btn basic-alert-button" id="basic-alert1">有</span>
                    <span class="btn basic-alert-button" id="basic-alert2">无</span>
                </div>
            </div>
        </div>

        <!-- Top Navbar-->
        <div class="navbar login-title" id="address-displaynone">
            <div class="navbar-inner new-navbar">
                <div class="left new-homepage"><a href="#" class="close-img"><img
                        src="<c:url value="/resources/image/image20/left-pannnal.png"/>" id="showLeft"> </a></div>
                <div class="center sliding login-title-word" id="show">基础额度</div>
                <div class="right">
                    <a href="#" class="close-img new-close"><img
                            src="<c:url value="/resources/image/image20/messages.png"/>"> </a>
                </div>
            </div>

            <div class="navbar-part2">
                <div class="float_l home-page-numbers">
                    <div class="icons home-page-button-content" id="icons">
                        <div class="home-page-button-content2">
                            <span id="number1" class="btn home-numbers-button home-button-border">第1步</span>
                            <span id="number2" class="btn home-numbers-button">第2步</span>
                            <span id="number3" class="btn home-numbers-button">第3步</span>
                            <span id="number4" class="btn home-numbers-button">第4步</span>
                            <span id="number5" class="btn home-numbers-button">第5步</span>
                            <span id="number6" class="btn home-numbers-button">第6步</span>
                            <ds class="home-font2 displaynone">切换步骤</ds>
                        </div>
                    </div>
                </div>
                <div class="float_l home-page-closes" id="closeStep">
                    <img class="rotate45" src="<c:url value="/resources/image/icon/close.png"/>">
                </div>
                <div class="home-page-opacity"></div>
                <div class="home-page-click-steps displaynone">
                    <span class="btn home-numbers-button-font1 button-font1-act">第1步</span>
                    <span class="btn home-numbers-button-font1">第2步</span>
                    <span class="btn home-numbers-button-font1">第3步</span>
                    <span class="btn home-numbers-button-font1">第4步</span>
                    <span class="btn home-numbers-button-font1">第5步</span>
                    <span class="btn home-numbers-button-font1">第6步</span>
                </div>
                <div class="home-back-black displaynone" id="home-back-black"></div>
            </div>


        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through" id="pages-contents">

            <div class="home-pannel-left cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
                <div class="left-total">
                    <div class="home-left-part1">
                        <div class="float_l part1-font1">
                            <img src="<c:url value="/resources/image/my-Shops.png"/>">
                        </div>
                        <div class="float_l part1-font2">我爱我家</div>
                    </div>
                    <div class="left-shop-names">
                        <div class="left-pannel-circle">
                            <div class="left-circle-font1">参考额度</div>
                            <div class="left-circle-font2">10000<span class="left-circle-font3">元</span></div>
                        </div>
                        <div class="left-shop-part2">
                            <span>审核中</span>
                        </div>
                    </div>
                    <div class="left-shop-footer">
                        <span class="btn left-shop-names-button" id="addShop"><img
                                src="<c:url value="/resources/image/onlineContact.png"/>"><span
                                class="left-footer-font1">添加商铺</span></span>
                    </div>
                    <div class="left-shop-footer2">
                        <span class="btn left-shop-names-button"><img id="left-online-comments"
                                                                      src="<c:url value="/resources/image/onlineComments.png"/>"><span
                                class="left-footer-font1">在线留言</span></span>
                    </div>
                </div>
            </div>

            <div class="back-ttps displaynone" id="back-ttps"></div>

            <!-- Page, data-page contains page name-->
            <div class="m-slider">
                <ul class="cnt" id="slider">
                    <li class="cnt-li">
                        <div class="slider-page1-content">
                            <%--基础资料--%>
                            <%@ include file="basicLimit.jsp" %>
                        </div>
                    </li>
                    <li class="cnt-li">
                        <div class="slider-page1-content">
                            <%--填写申请--%>
                            <%@ include file="uploadFile.jsp" %>
                        </div>
                    </li>
                    <li class="cnt-li" style="background-color: #fff5ba;">
                        <div class="slider-page1-content">
                            <div>33</div>
                        </div>
                    </li>
                    <li class="cnt-li">
                        <div class="slider-page1-content">
                            <%--绑定银行卡--%>
                            <%@ include file="bankBind.jsp" %>
                        </div>
                    </li>
                    <li class="cnt-li">
                        <div class="slider-page1-content">
                            <%--融资方案--%>
                            <%@ include file="financingConfirm.jsp" %>
                        </div>
                    </li>
                    <li class="cnt-li">
                        <div class="slider-page1-content">
                            <%--申请信息--%>
                            <%@ include file="applyInfomation.jsp" %>
                        </div>
                    </li>
                </ul>

            </div>
        </div>

        <div class="toolbar tabbar tabbar-labels">
            <div class="toolbar-inner">
                <a href="<c:url value='/new/m/home'/>" class="tab-link">
                    <i class="icon money-icon"><span class="badge bg-red">1</span></i>
                    <span class="tabbar-label">融资</span>
                </a>
                <a href="<c:url value='/new/m/account'/>" class="tab-link">
                    <i class="icon account-icon">
                    </i>
                    <span class="tabbar-label">账户</span>
                </a>
                <a href="<c:url value='/new/m/more'/>" class="tab-link active">
                    <i class="icon more-icon"></i>
                    <span class="tabbar-label">更多</span>
                </a>
            </div>
        </div>


    </div>
</div>


<script type="text/javascript" src="<c:url value="/resources/js/classie.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/modernizr.custom.js"/>"></script>
<script type="text/javascript">
    $('.home-page-button-content button').click(function () {
        $(this).addClass('home-button-border').siblings().removeClass('home-button-border');
    });
</script>

<script type="text/javascript">

    $("#addShop").click(function () {
        location.href = "<c:url value="/new/m/home"/>";
    });

    $("#number1").click(function () {
        $("#show").text("基础资料");
    });
    $("#number2").click(function () {
        $("#show").text("填写申请");
    });
    $("#number3").click(function () {
        $("#show").text("融资确认");
    });
    $("#number4").click(function () {
        $("#show").text("银行卡绑定");
    });
    $("#number5").click(function () {
        $("#show").text("融资方案");
    });
    $("#number6").click(function () {
        $("#show").text("申请信息");
    });


    var scrollDis = 0;
    var screenWidth = $(window).width();
    var clickNumber = 0;
    var ccds;
    var i = 0;
    var $btn = $('.home-page-button-content span');
    var $btn2 = $('.home-page-click-steps span');
    var $btn3 = $('.home-page-click-steps .home-numbers-button-font1');
    var menuLeft = document.getElementById('cbp-spmenu-s1'), showLeft = document.getElementById('showLeft'), pagesidden = document.getElementById('pages-contents');
    var $back = document.getElementById('back-ttps');
    var $sliderLi = document.getElementById('slider');
    var closeImgClickNum = 0;
    var slider = {
//判断设备是否支持touch事件
        touch: ('ontouchstart' in window) || window.DocumentTouch && document instanceof DocumentTouch,
        slider: document.getElementById('slider'),
//事件
        events: {
            index: 0, //显示元素的索引
            slider: this.slider, //this为slider对象
            icons: document.getElementById('icons1'),
            icon: this.icons.getElementsByTagName('span'),
            handleEvent: function (event) {
                var self = this; //this指events对象
                if (event.type == 'touchstart') {
                    self.start(event);
                } else if (event.type == 'touchmove') {
                    self.move(event);
                } else if (event.type == 'touchend') {
                    self.end(event);
                }
            },
//滑动开始
            start: function (event) {
                var touch = event.targetTouches[0]; //touches数组对象获得屏幕上所有的touch，取第一个touch
                startPos = {x: touch.pageX, y: touch.pageY, time: +new Date}; //取第一个touch的坐标值
                isScrolling = 0; //这个参数判断是垂直滚动还是水平滚动
                this.slider.addEventListener('touchmove', this, false);
                this.slider.addEventListener('touchend', this, false);
            },
//移动
            move: function (event) {
//当屏幕有多个touch或者页面被缩放过，就不执行move操作
                if (event.targetTouches.length > 1 || event.scale && event.scale !== 1) return;
                var touch = event.targetTouches[0];
                endPos = {x: touch.pageX - startPos.x, y: touch.pageY - startPos.y};
                isScrolling = Math.abs(endPos.x) < Math.abs(endPos.y) ? 1 : 0; //isScrolling为1时，表示纵向滑动，0为横向滑动
                if (isScrolling === 0) {
                    event.preventDefault(); //阻止触摸事件的默认行为，即阻止滚屏
                    this.slider.className = 'cnt';
                    if (clickNumber != 0) {
                        this.index = clickNumber;
                        this.slider.style.left = -this.index * screenWidth + endPos.x + 'px';
                    }
                    else {
                        this.slider.style.left = -this.index * screenWidth + endPos.x + 'px';
                    }
                }
            },
//滑动释放
            end: function (event) {
                var duration = +new Date - startPos.time; //滑动的持续时间
                if (isScrolling === 0) { //当为水平滚动时
                    this.icon[this.index].className = 'btn home-numbers-button';
                    if (clickNumber == 0) {
                        if (Number(duration) > 10) {
                            if (endPos.x > 10) {
                                if (this.index == 0) classie.add(menuLeft, 'cbp-spmenu-open');
                                classie.add($back, 'displaynone');
                            } else if (endPos.x < -5) {
                                classie.remove(menuLeft, 'cbp-spmenu-open');
                            }
                        }
                        if (Number(duration) > 50) { //判断是左移还是右移，当偏移量大于30时执行
                            if (endPos.x > 50) {
                                if (this.index !== 0) this.index -= 1;
                            } else if (endPos.x < -50) {
                                classie.remove(menuLeft, 'cbp-spmenu-open');
                                classie.add($back, 'displaynone');
                                if (this.index !== this.icon.length - 1) this.index += 1;
                            }
                        }
                        this.icon[this.index].className = 'btn home-numbers-button home-button-border';
                        this.slider.className = 'cnt f-anim';
                        this.slider.style.left = -this.index * screenWidth + 'px';
                    }
                    else if (clickNumber != 0) {
                        this.index = clickNumber;
                        if (Number(duration) > 50) { //判断是左移还是右移，当偏移量大于30时执行
                            if (endPos.x > 50) {
                                if (this.index !== 0)  this.index -= 1;
                            } else if (endPos.x < -50) {
                                if (this.index !== this.icon.length - 1) this.index += 1;
                            }
                        }
                        this.icon[this.index].className = 'btn home-numbers-button home-button-border';
                        this.icon[clickNumber].className = 'btn home-numbers-button';
                        this.slider.className = 'cnt f-anim';
                        this.slider.style.left = -this.index * screenWidth + 'px';
                        clickNumber = 0;
                    }
                    this.icon[this.index].className = 'btn home-numbers-button home-button-border';
                    this.slider.className = 'cnt f-anim';
                    this.slider.style.left = -this.index * screenWidth + 'px';
                }
//解绑事件
                this.slider.removeEventListener('touchmove', this, false);
                this.slider.removeEventListener('touchend', this, false);
                if (this.index >= 3) {
                    scrollDis = this.index * 50;
                    $('.home-page-button-content').scrollLeft(scrollDis);
                }
                else {
                    $('.home-page-button-content').scrollLeft(0);
                }
            }
        },
//初始化
        init: function () {
            var self = this; //this指slider对象
            if (!!self.touch) self.slider.addEventListener('touchstart', self.events, false); //addEventListener第二个参数可以传一个对象，会调用该对象的handleEvent属性
        }
    };
    slider.init();

    $btn.each(function (index) {
        $(this).click(function () {
            document.getElementById('slider').style.left = -screenWidth * index + 'px';
            if (index > 2) {
                var scrollDis = index * 50;
                $('.home-page-button-content').scrollLeft(scrollDis);
            }
            $(this).addClass('home-button-border').siblings().removeClass('home-button-border');
            $btn2.eq(index).addClass('button-font1-act').siblings().removeClass('button-font1-act');
            clickNumber = index;
        })
    });

    $btn2.each(function (index) {
        $(this).click(function () {
            document.getElementById('slider').style.left = -screenWidth * index + 'px';
            if (index > 2) {
                var scrollDis = index * 50;
                $('.home-page-button-content').scrollLeft(scrollDis);
            }
            $(this).addClass('button-font1-act').siblings().removeClass('button-font1-act');
            $btn.eq(index).addClass('home-button-border').siblings().removeClass('home-button-border');
            clickNumber = index;
        });
    });

    $('#closeStep').click(function () {
        closeImgClickNum++;
        var closeDisplay = $('.home-back-black').css('display');
        $('.home-page-click-steps').slideToggle();
        $('.home-back-black').toggle();
        $('#icons span').toggle();
        $('.home-font2').toggle();
        if (closeDisplay === 'none') {
            $('#closeStep img').removeClass('rotate45').addClass('home-page-scroll');
            $('.home-page-button-content').scrollLeft(0);
        }
        else {
            $('#closeStep img').removeClass('home-page-scroll').addClass('rotate45');
            $('.home-page-button-content').scrollLeft(scrollDis);
        }
        ;
    });


    $('.btn.home-numbers-button-font1').click(function () {
        $('#closeStep img').removeClass('home-page-scroll').addClass('rotate45');
        $('.home-page-click-steps').slideToggle();
        $('.home-back-black').toggle();
        $('#icons span').toggle();
        $('.home-font2').toggle();
        scrollDis = index * 50;
        if (index < 4) {
            $('.home-page-button-content').scrollLeft(0);
            $('#closeStep img').removeClass('home-page-scroll').addClass('rotate45');
        }
        else {
            $('.home-page-button-content').scrollLeft(scrollDis);
            $('#closeStep img').removeClass('home-page-scroll').addClass('rotate45');
        }
        ;
    });

    $('.home-back-black').click(function () {
        $('.home-page-click-steps').slideToggle();
        $('.home-back-black').toggle();
        $('#icons span').toggle();
        $('.home-font2').toggle();
        $('#closeStep img').removeClass('home-page-scroll').addClass('rotate45');
    });


    showLeft.onclick = function () {
        classie.toggle(showLeft, 'active');
        classie.toggle(menuLeft, 'cbp-spmenu-open');
        classie.remove($back, 'displaynone');
    };
    $back.onclick = function () {
        classie.remove(showLeft, 'active');
        classie.remove(menuLeft, 'cbp-spmenu-open');
        classie.add($back, 'displaynone');
    };
    $sliderLi.onclick = function () {
        classie.remove(showLeft, 'active');
        classie.remove(menuLeft, 'cbp-spmenu-open');
        classie.add($back, 'displaynone');
    };

    $(document).ready(function () {

        var scrollCurrent = 0

        $('.m-slider .cnt li').scroll(function () {
            var scrollLength = $(".m-slider .cnt li").scrollTop();
//           alert( scrollLength +" px");
            if (scrollLength > scrollCurrent) {
                if (scrollLength > 70) {
                    $('.navbar-inner').slideUp();
                    $('.navbar-part2').addClass('home-page-myMove').addClass('navbar-transform');
                    $('.toolbar').slideUp();
                }
                ;
            }
            else {
                $('.navbar-inner').slideDown();
                $('.navbar-part2').addClass('home-page-myMove').addClass('navbar-transform');
                $('.navbar-part2').removeClass('home-page-myMove').removeClass('navbar-transform');
                $('.toolbar').slideDown();
            }
            scrollCurrent = scrollLength;
        });


        var cntLength = $('.cnt').children('li').length;
        var cntWidth = cntLength * 100;
        var cntLiWidth = 100 / cntLength;
        var cntScrollWidth = cntLength * 100 / 3.5;
        $('.m-slider .cnt').css('width', cntWidth + '%');
        $('.m-slider .cnt li.cnt-li').css('width', cntLiWidth + '%');
        $('.home-page-button-content2').css('width', cntScrollWidth + '%');
    });

    $("#notAgree").click(function () {
        $('.home-page-backs').removeClass('displaynone');
    });

</script>


</body>
</html>