<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head></head>
<body>
<!-- Views-->
<div class="views" style="position:absolute; margin:0; padding:0; border:0; top:0;">
    <!-- Your main view, should have "view-main" class-->
    <div class="view view-main">
        <!-- Top Navbar-->
        <div class="navbar login-title"  style="display: ${isApp == '0' ? 'block' : 'none'}">
            <div class="navbar-inner">
                <div class="left"><a href="<c:url value='/new/m/more'/>" class="close-img"><img src="<c:url value='/resources/image/left-arror.png'/>"></a></div>
                <div class="center sliding login-title-word">融资攻略</div>
            </div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page">
                <!-- Scrollable page content-->
                <div class="page-content ${isApp == '0' ? '' : 'none-navbar'}">
                    <div class="list-block media-list myaccount">
                        <ul>
                            <li>
                                <div class="item-link item-content">
                                    <div class="item-media"><span class="glyphicon glyphicon-question-sign wechat-icon-question-sign"></span></div>
                                    <div class="item-inner questionCon">
                                        <span>小企额的申请条件是什么？</span>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="item-link item-content">
                                    <div class="item-media"><span class="glyphicon glyphicon-ok-sign wechat-icon-campaign"></span></div>
                                    <div class="item-inner questionCon">
                                        <span>
                                            <p>申请人要求：企业法人，个体工商户；</p>
                                            <p>年龄要求：20-65周岁；</p>
                                            <p>信用要求：申请人信誉良好，无违法行为或不良信用记录；</p>
                                            <p>企业资质：依法合规经营、有实体经营门店（临街店铺）。</p>
                                        </span>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="list-block media-list myaccount">
                        <ul>
                            <li>
                                <div class="item-link item-content">
                                    <div class="item-media"><span class="glyphicon glyphicon-question-sign wechat-icon-question-sign"></span></div>
                                    <div class="item-inner questionCon">
                                        <span>小企额的借款额度是多少？</span>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="item-link item-content">
                                    <div class="item-media"><span class="glyphicon glyphicon-ok-sign wechat-icon-campaign"></span></div>
                                    <div class="item-inner questionCon">
                                        <span>额度标准是1万-100万，根据不同商户的基础情况，会分别评出不同的额度。另外，如果您使用POS机，您可通过“验证POS”提升额度，刷卡量越大，额度越高。</span>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="list-block media-list myaccount">
                        <ul>
                            <li>
                                <div class="item-link item-content">
                                    <div class="item-media"><span class="glyphicon glyphicon-question-sign wechat-icon-question-sign"></span></div>
                                    <div class="item-inner questionCon">
                                        <span>小企额的借款利息是多少？</span>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="item-link item-content">
                                    <div class="item-media"><span class="glyphicon glyphicon-ok-sign wechat-icon-campaign"></span></div>
                                    <div class="item-inner questionCon">
                                        <span>根据授信评级不同，费率不同，一般在1.5%-2.0%之间。</span>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="list-block media-list myaccount">
                        <ul>
                            <li>
                                <div class="item-link item-content">
                                    <div class="item-media"><span class="glyphicon glyphicon-question-sign wechat-icon-question-sign"></span></div>
                                    <div class="item-inner questionCon">
                                        <span>小企额的借款周期是多久？</span>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="item-link item-content">
                                    <div class="item-media"><span class="glyphicon glyphicon-ok-sign wechat-icon-campaign"></span></div>
                                    <div class="item-inner questionCon">
                                        <span>借款周期是3个月—9个月。</span>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="list-block media-list myaccount">
                        <ul>
                            <li>
                                <div class="item-link item-content">
                                    <div class="item-media"><span class="glyphicon glyphicon-question-sign wechat-icon-question-sign"></span></div>
                                    <div class="item-inner questionCon">
                                        <span>小企额的放款方式是什么？</span>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="item-link item-content">
                                    <div class="item-media"><span class="glyphicon glyphicon-ok-sign wechat-icon-campaign"></span></div>
                                    <div class="item-inner questionCon">
                                        <span>审核通过后，放款金额将汇入您的对公账户或个人账户。</span>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="list-block media-list myaccount">
                        <ul>
                            <li>
                                <div class="item-link item-content">
                                    <div class="item-media"><span class="glyphicon glyphicon-question-sign wechat-icon-question-sign"></span></div>
                                    <div class="item-inner questionCon">
                                        <span>商户如何还款？</span>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="item-link item-content">
                                    <div class="item-media"><span class="glyphicon glyphicon-ok-sign wechat-icon-campaign"></span></div>
                                    <div class="item-inner questionCon">
                                        <span>多种还款方式供您选择，可绑定银行卡扣款，也可关联POS机自动还款。</span>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="list-block media-list myaccount">
                        <ul>
                            <li>
                                <div class="item-link item-content">
                                    <div class="item-media"><span class="glyphicon glyphicon-question-sign wechat-icon-question-sign"></span></div>
                                    <div class="item-inner questionCon">
                                        <span>是否需要抵押物？</span>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="item-link item-content">
                                    <div class="item-media"><span class="glyphicon glyphicon-ok-sign wechat-icon-campaign"></span></div>
                                    <div class="item-inner questionCon">
                                        <span>不需要。</span>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>

                    <div class="list-block media-list myaccount">
                        <ul>
                            <li>
                                <div class="item-link item-content">
                                    <div class="item-media"><span class="glyphicon glyphicon-question-sign wechat-icon-question-sign"></span></div>
                                    <div class="item-inner questionCon">
                                        <span>如何申请？</span>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="item-link item-content">
                                    <div class="item-media"><span class="glyphicon glyphicon-ok-sign wechat-icon-campaign"></span></div>
                                    <div class="item-inner questionCon">
                                        <span>您只需填写个人和企业的基本信息即可立即得到额度，提交申请后工作人员会尽快为您审核。</span>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>

                    <div class="list-block media-list myaccount">
                        <ul>
                            <li>
                                <div class="item-link item-content">
                                    <div class="item-media"><span class="glyphicon glyphicon-question-sign wechat-icon-question-sign"></span></div>
                                    <div class="item-inner questionCon">
                                        <span>如果逾期还款，会有什么后果？</span>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="item-link item-content">
                                    <div class="item-media"><span class="glyphicon glyphicon-ok-sign wechat-icon-campaign"></span></div>
                                    <div class="item-inner questionCon">
                                        <span>如果逾期还款，您需要承担逾期产生的逾期利息和逾期罚金，同时将影响您的个人征信，小企额建议您珍惜个人信用，避免逾期还款。</span>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>