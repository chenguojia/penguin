<%--
  Created by IntelliJ IDEA.
  User: guojia.chen
  Date: 2016/1/8
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--银行begin--%>
<div class="views" id="bindBankShow" style="display: none">
    <!-- Your main view, should have "view-main" class-->
    <div class="view view-main">
        <!-- Top Navbar-->
        <div class="navbar login-title">
            <div class="navbar-inner">
                <div class="left" id="address-back"><a href="#" class="close-img"><img
                        src="<c:url value='/resources/image/left-arror.png'/>"></a></div>
                <div class="center sliding login-title-word">
                    <div class="input-group gps-toper">
                        <div class="input-group-addon gps-searcher">
                            <img src="<c:url value='/resources/image/gpsSearch.png'/>">
                        </div>
                        <input class="form-control" placeholder="请输入开户银行"  type="text">
                    </div>
                </div>
                <div class="right">
                    <button class="button gps-search-button">搜索</button>
                </div>
            </div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page">
                <!-- Scrollable page content-->
                <div class="page-content">
                    <div class="list-block media-list myaccount gps-pages">
                        <ul class="float_clear margin-t12">

                        </ul>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<%--银行end--%>



            <!-- Scrollable page content-->
            <div class="page-content bank-bind">

                <div class="bind-part2 part2-notop">

                    <div class="content-block login-new">
                        <div class="list-block register-home">
                            <div class="padding-b5" style="font-size: 13px; padding-left:15px;">还款账户和放款账户必须保持一致</div>
                            <%--<ul class="register-home-part2">--%>
                            <ul class="#">
                                <li class="item-content border-bottom border-tops">
                                    <div class="item-media">
                                        <span class="icon username_icon"><img
                                                src="<c:url value="/resources/image/user.png"/>"></span>
                                    </div>
                                    <div class="item-inners">
                                        <div class="item-title">
                                            <input class="login_input" type="text" placeholder="账户名" name="ownerName"  value="${newMerchantUserModel.ownerName}" readonly>
                                        </div>
                                    </div>
                                </li>

                                <li class="item-content border-bottom">
                                    <div class="item-media">
                                        <span class="icon username_icon"><img
                                                src="<c:url value="/resources/image/user.png"/>"></span>
                                    </div>
                                    <div class="item-inners">
                                        <div class="item-title">
                                            <input class="login_input" type="text" placeholder="身份证" name="directDebitAcctId" value="${applicationModel.directDebitAcctId}" readonly>
                                        </div>
                                    </div>
                                </li>

                                <li>
                                    <a href="#" class="item-link item-content border-bottom open-account">
                                        <div class="item-media">
                                            <span class="icon username_icon"><img
                                                    src="<c:url value="/resources/image/user.png"/>"></span>
                                        </div>
                                        <div class="item-inners">
                                            <div class="item-title item-title-row bank-bind2">
                                                <input class="login_input bankName" type="text" name="directDebitBankName" value="${applicationModel.directDebitBankName}" placeholder="开户银行">
                                            </div>
                                        </div>
                                    </a>
                                </li>

                                <li class="item-content border-bottom">
                                    <div class="item-media">
                                        <span class="icon username_icon"><img
                                                src="<c:url value="/resources/image/user.png"/>"></span>
                                    </div>
                                    <div class="item-inners">
                                        <div class="item-title">
                                            <input class="login_input" type="text" name="directDebitAcctNo" value="${applicationModel.directDebitAcctNo}" placeholder="银行账号">
                                        </div>
                                    </div>
                                </li>
                                <li class="item-content border-bottom">
                                    <div class="item-media">
                                        <span class="icon username_icon pinCode2"><img
                                                src="<c:url value="/resources/image/phoneCode.png"/>"></span>
                                    </div>
                                    <div class="item-inners">
                                        <div class="item-title login_input2">
                                            <input class="login_input" type="text" placeholder="银行预留手机号">
                                            <button class="get_verti-new button button-round" type="button"
                                                    id="getCheckCode2"  name="directDebitAcctPhone" value="${applicationModel.directDebitAcctPhone}" >获取验证码
                                            </button>
                                        </div>
                                    </div>
                                </li>
                                <li class="item-content border-bottom">
                                    <div class="item-media">
                                        <span class="icon username_icon"><img
                                                src="<c:url value="/resources/image/pinCode.png"/> "></span>
                                    </div>
                                    <div class="item-inners">
                                        <div class="item-title">
                                            <input class="login_input" type="text" placeholder="输入验证码">
                                        </div>
                                    </div>
                                </li>

                            </ul>
                        </div>
                    </div>
                    <div class="padding-rl15 margin-t-5">
                        <div class="bind-font1">
                           <input type="checkbox" name="agree" id="agree"/> 同意<span class="bind-font2">融资协议</span>
                        </div>
                        <div class="bind-number-new2">
                            <a class="button button-big button-fill apply-button" href="#">绑定</a>
                        </div>
                    </div>
                    <div class="float_clear height20 margin-t20"></div>
                </div>
            </div>


<script type="text/javascript">

    $(".bankName").focus(function(){
        $("#bindBankShow").show();
        $(".bank-bind").hide();
    });

    $(".left").click(function(){
        $(".bank-bind").show();
        $("#bindBankShow").hide();
    });

    //    查询地址，去头部
    $('.open-account').click(function () {
        $('#address-displaynone').hide();
        $('.slider-page1-content').css('margin-top', '0')
    });
    //    返回页面，加头部
    $('.close-img').click(function () {
        $('#address-displaynone').show();
        $('.slider-page1-content').css('margin-top', '105px')
    });


    $('.bind-button-font1').click(function () {
        $('.bind-part2').addClass('displaynone');
        $('.bind-part1').removeClass('displaynone');
        $('.bind-button-font1').addClass('button-active');
        $('.bind-button-font2').removeClass('button-active');
    });
    $('.bind-button-font2').click(function () {
        $('.bind-part1').addClass('displaynone');
        $('.bind-part2').removeClass('displaynone');
        $('.bind-button-font2').addClass('button-active');
        $('.bind-button-font1').removeClass('button-active');
    });
</script>
