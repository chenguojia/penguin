<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>

    <script type="text/javascript">
        (function() {
            var id = '<%=session.getId() %>';
            <% session.setAttribute("blackBox",session.getId());%>
            _fmOpt = {
                partner: 'cardvalue',
                appName: 'cardvalue_online',
                token:'wechat'+ '<%=session.getId() %>',
                fpHost: 'https://fptest.fraudmetrix.cn',
                staticHost: 'statictest.fraudmetrix.cn',
                tcpHost: 'fptest.fraudmetrix.cn',
                wsHost: 'fptest.fraudmetrix.cn:9090'
            };

            var cimg = new Image(1,1);
            cimg.onload = function() {
                _fmOpt.imgLoaded = true;
            };
            cimg.src = "https://fptest.fraudmetrix.cn/fp/clear.png?partnerCode=cardvalue&appName=cardvalue_online&tokenId=" + _fmOpt.token;
            var fm = document.createElement('script'); fm.type = 'text/javascript'; fm.async = true;
            fm.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'statictest.fraudmetrix.cn/fm.js?ver=0.1&t=' + (new Date().getTime()/3600000).toFixed(0);
            var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(fm, s);

            console.log(id);
        })();
    </script>

</head>
<body>
<!-- Views-->
<div class="views" id="login">
    <!-- Your main view, should have "view-main" class-->
    <div class="view view-main login-background">
        <!-- Top Navbar-->
        <div class="navbar login-title">
            <div class="navbar-inner">
                <div class="center sliding login-title-word">登录</div>
                <div class="right">
                    <%--<a href="#" class="close-img"><img src="<c:url value="/resources/newm/images/icon/close.png"/>"> </a>--%>
                </div>
            </div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
            <!-- Page, data-page contains page name-->
            <div data-page="login" class="page">
                <!-- Scrollable page content-->
                <div class="page-content">
                    <div class="content-block login-new">
                        <div class="list-block">
                            <ul>
                                <li class="item-content apply-bottom">
                                    <div class="item-media">
                                        <span class="icon username_icon"><img src="<c:url value="/resources/image/user.png"/>"></span>
                                    </div>
                                    <div class="item-inners">
                                        <div class="item-title">
                                            <input onblur="checkMobile()" class="login_input" type="number" id="mobile" maxlength="11" placeholder="请输入您的手机号">
                                        </div>
                                    </div>
                                </li>
                                <li class="item-content apply-bottom2">
                                    <div class="item-media">
                                        <span class="icon username_icon"><img src="<c:url value="/resources/image/pinCode.png"/>"></span>
                                    </div>
                                    <div class="item-inners">
                                        <div class="item-title">
                                            <input class="login_input" type="password" id="password" maxlength="16"  placeholder="请输入6-16位密码">
                                        </div>
                                    </div>
                                </li>

                            </ul>
                        </div>
                        <div style="margin-left: 18px;display: none" id="checkMobile">
                            <div class="margin-b15 register-font1">
                                <input id="agree-terms" type="checkbox" checked/>
                            </div>
                            <div id="agree-terms-font">
                                <label for="agree-terms">同意<a class="open-popup" data-popup=".popup-service"
                                                              id="agree-terms-new" href="#">卡得万利服务协议</a></label>
                            </div>
                        </div>
                    </div>
                    <div class="padding-rl15">
                        <div class="bind-number">
                            <a class="button button-big button-fill apply-button" href="#" id="submitBtn">登录</a>
                        </div>
                        <div class="row margin-t20">
                            <a class="col-50 forget-pass" href="<c:url value='/new/m/forgetPassword/show'/>">忘记密码？</a>
                            <div class="col-10">|</div>
                            <a class="col-40 register_hint-new" href="<c:url value='/new/m/bind/show'/>">用户注册</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<%--=============协议 begin===============--%>
<div class="views" style="display: none;" id="agreements_new">
    <!-- Your main view, should have "view-main" class-->
    <div class="view view-main">
        <!-- Top Navbar-->
        <div class="navbar login-title">
            <div class="navbar-inner">
                <div class="left"><a href="#" class="close-img" id="close-img"><img
                        src="<c:url value="/resources/image/left-arror.png"/>"></a></div>
                <div class="login-title-word agreement-titles">
                    <div>卡得万利服务协议</div>
                </div>
            </div>
        </div>


        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page">
                <!-- Scrollable page content-->
                <!--有标题时-->
                <div class="page-content">
                    <!--无标题时-->
                    <!--<div class="page-content without-title">-->
                    <div class="content-block login-new credit-report-pages">

                        <div class="list-block media-list myaccount more-part2">
                            <ul class="float_clear margin-t12">
                                <li class=" border-bottom border-tops">
                                    <a href="#" class="item-link item-content more-main aggree1">
                                        <div class="item-inners">
                                            <div class="item-title-row">
                                                <div>
                                                    APP商业保理协议书
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <li class=" border-bottom">
                                    <a href="#" class="item-link item-content more-main aggree2">
                                        <div class="item-inners">
                                            <div class="item-title-row">
                                                <div>
                                                    APP应收账款让登记协议
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <li class=" border-bottom">
                                    <a href="#" class="item-link item-content more-main aggree3">
                                        <div class="item-inners">
                                            <div class="item-title-row">
                                                <div>
                                                    APP征信报告授权协议
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <li class=" border-bottom">
                                    <a href="#" class="item-link item-content more-main aggree4">
                                        <div class="item-inners">
                                            <div class="item-title-row">
                                                <div>
                                                    APP注册协议
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <li class=" border-bottom">
                                    <a href="#" class="item-link item-content more-main aggree5">
                                        <div class="item-inners">
                                            <div class="item-title-row">
                                                <div>
                                                    银行卡绑定授权协议
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <li class=" border-bottom">
                                    <a href="#" class="item-link item-content more-main aggree6">
                                        <div class="item-inners">
                                            <div class="item-title-row">
                                                <div>
                                                    隐私说明
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>

                    <!--APP商业保理协议书-->
                    <!--有标题时-->
                    <div class="popups popup-agreement1 own-title">
                        <!--无标题时-->
                        <!--<div class="popups popup-agreement1">-->
                        <div class="agreement-back"><a class="close-popup glyphicon glyphicon-chevron-left"></a></div>
                        <div class="agreements">
                            <div class="content-block caseShare_story honorTit agreement-font2">
                                <span class="agreement-font3">卡得万利商业保理有限公司</span>
                            </div>
                            <div class="content-block caseShare_story honorTit">
                                <span class="agreement-font3">商业保理协议书</span>
                            </div>
                            <div class="content-block caseShare_story agreement-font1">
                                <span>本服务协议双方为卡得万利商业保理有限公司（以下简称"甲方"）与甲方用户所担任法定代表人的法人或其他组织机构（以下简称"乙方"），本服务协议具有合同效力。</span>

                                <p>
                                    鉴于甲方系政府中小企业服务机构和国家商业保理试点企业，提供以商业保理为内容的中小企业融资公共服务。乙方将一定经营期间内通过指定收单机构的POS机产生的所有应收刷卡交易额，向甲方申请办理商业保理业务，获得生产经营资金。甲方和乙方在自愿、公平和诚实信用的基础上协商一致，同意并遵守下列条款：</p>

                                <p>1.<span class="agreement-font3"> 定义 </span>除本协议另有规定外，本协议中下列有关用语的定义是：</p>

                                <p>1.1.
                                    应收账款是指乙方在营业执照记载的经营范围内因提供一定的货物、服务或设施而获得的要求义务人付款的权利以及依法享有的其他从属权利，包括现有的和未来的金钱债权及其产生的收益。</p>

                                <p>1.2.
                                    消费账款是指乙方账款中，扣除被国内外卡组织和各收单机构认定的违规移机、虚假交易、虚假申请、套现、分单、洗单、侧录、伪卡、实际交易与核定经营范围不符、转账、取现等非法或非真实消费交易，以及在出售商品的质量、数量，或提供的服务上存在任何争议、投诉或其他纠纷的应收账款部分。</p>

                                <p>1.3.
                                    保理预付款是指甲方按受让消费账款的一定比例计算的保理融资金额。根据保理融资金额大小和业态特征，甲方有权选择“关联POS机账户还款”或“直接扣款”的方式收回保理预付款。</p>

                                <p>1.4. 管理服务费：指甲方按本协议的约定，对乙方商业保理相关的账户管理收取的费用。</p>

                                <p>1.5. 保理手续费：指甲方按本协议的约定，向乙方提供保理融资或其他服务，而有权向乙方收取的费用。</p>

                                <p>1.6. 逾期违约金：指乙方未按期偿还本协议项下保理预付款和相关费用的，甲方有权按全额保理预付款的一定比例计收的违约金。</p>

                                <p>1.7.
                                    代垫费用：指甲方代乙方垫付的，由乙方同意承担的在本协议履行过程中被其它有关部门收取的各项费用。包括但不限于中国人民银行征信中心动产权属统一登记公示费用和信息提供机构的查询费用等。</p>

                                <p>1.8. 保理余款：指甲方或其关联方实际收到的应收账款扣除乙方应偿还的保理预付款及相关费用后的剩余金额。</p>

                                <p>1.9.
                                    关联POS机账户还款：指将指定POS机具的结算账户变更为甲方的保理资金监管账户，POS机产生的刷卡交易额扣除收单机构手续费后剩余金额转入甲方保理资金监管账户，用于偿还保理预付款和支付相关费用后，保理余款支付给乙方的回款方式。</p>

                                <p>1.10. 直接扣款：指通过第三方机构代扣乙方提供的银行卡账户内的资金，用于偿还保理预付款和支付相关费用的回款方式。</p>

                                <p>1.11. 法定代表人：在本协议中，若乙方的经营性质为个体工商户，经营者称为法定代表人；若乙方的经营性质为个人独资企业，投资人称为法定代表人。</p>

                                <p><span class="agreement-font3">2. 乙方的陈述和保证</span></p>

                                <p>1.12. 乙方系依法成立的，具有法人资格的企业单位或个体工商户或个人独资企业，现持有有效营业执照，并依法拥有其资产、合法经营其业务。</p>

                                <p>1.13. 乙方具有履行本协议项下权利和义务的能力。</p>

                                <p>1.14. 本协议的签署和执行不会与乙方必须遵守的法律和行政法规相违背或抵触；执行本协议不会引起乙方违反其所应遵守的其他协议以及批准成立的文件和公司章程。</p>

                                <p>1.15.
                                    乙方转让给甲方的应收账款是真实的、排他的、无争议的、无瑕疵的且预期未来产生的真实、合法债权。乙方未将其转让给任何第三人，也未在其上为任何第三人设定任何质权和其他优先受偿权。</p>

                                <p>1.16. 乙方提供所有资料都是真实、准确、完整而没有任何隐瞒，不存在任何未向甲方披露的足以影响保理融资还款的重大债务或或有债务。</p>

                                <p>1.17. 在本协议生效时，没有针对乙方提出的或悬而未决的，可能会对其构成任何形式的实质性不利影响的诉讼，仲裁或其他潜在的重大纠纷。</p>

                                <p>1.18.
                                    乙方提供给甲方的最新财务报表是根据中国适用法律和条例以及会计准则编制的，完整、真实、公正地反映了乙方在有关财务时期结束时的财务状况及业绩。从该财务报表日期后，乙方的业务或财务状况并无不利的实质性变化。</p>

                                <p><span class="agreement-font3">3. 服务内容</span></p>

                                <p>1.19. 受让账款及权利：甲方在协议期限内批量受让乙方的账款及权利，但对已设定抵押权、质权、其他担保物权、任何第三方权利、其他优先受偿权以及权属不清的账款除外。</p>

                                <p>1.20. 支付对价：甲方向乙方一次性支付保理预付款，保理余款在甲方收到受让账款后支付。</p>

                                <p><span class="agreement-font3">4. 账款及权利管理</span></p>

                                <p>1.21. 甲方受让的应收账款，可由甲方提交至中国人民银行征信中心等登记平台办理转让登记，该等质押登记不改变乙方向甲方转让账款的性质。</p>

                                <p>1.22.
                                    在“关联POS机账户还款”和“直接扣款”方式下，乙方均必须使用甲方指定的收单机构的POS机作为银行卡唯一收款机具。特殊情况下，甲方有权将非甲方指定的收单机构的POS机统一保管。</p>

                                <p>1.23. 在“关联POS机账户还款”和“直接扣款”方式下，本协议项下应收账款均由乙方使用本协议约定收单机构的POS机具进行收款，甲方有权随时进行现场检查。</p>

                                <p><span class="agreement-font3">5. 账款结算</span></p>

                                <p>1.24. 在“关联POS机账户还款”方式下，乙方必须使用甲方的保理资金监管账户作为POS机具唯一结算账户。</p>

                                <p>1.1.1.
                                    甲方在本协议生效后，甲方保理资金监管账户收到第一笔乙方POS机刷卡交易额之日起24小时内，向乙方一次性支付保理预付款。实际支付金额以《商业保理确认书》为准。</p>

                                <p>1.1.2. 甲方在收到乙方收单机构支付账款的3个工作日内，按《商业保理确认书》的约定扣除相应的保理预付款及相关费用后，将保理余款支付到乙方结算账户。</p>

                                <p>1.1.3. 由于银行系统故障和节假日等结算时间差异造成的长短款，甲方和乙方在发生之日起的5个工作日内对账结清。</p>

                                <p>1.1.4. 由于本协议1.2原因，乙方到期账款被国内外卡组织和各收单机构暂延付款时，甲方自动暂延对乙方的付款。</p>

                                <p>1.1.5. 由于本协议1.2原因，造成到期账款不能回收时，甲方有权向乙方反转让受让的账款，追索保理预付款及相关费用，由此造成的损失由乙方承担。</p>

                                <p>1.25. 在“直接扣款”方式下，乙方应向甲方提供银行账户，该银行账户必须经甲方确认。乙方必须使用经甲方确认的银行账户作为还款结算账户。</p>

                                <p>1.1.6. 甲方在本协议生效后，并从乙方银行账户中成功扣收代垫费用后24小时内，向乙方一次性支付保理预付款。实际支付金额具体见《商业保理确认书》。</p>

                                <p>1.1.7. 甲方按《商业保理确认书》的约定从乙方银行账户中扣除有关费用。</p>

                                <p>1.26. 本协议所述全部款项和费用的具体比例和金额，具体见《商业保理确认书》。</p>

                                <p><span class="agreement-font3">6. 提前或按期还款</span></p>

                                <p>1.27.
                                    乙方申请提前清偿全部保理预付款时，应提前15日以上向甲方提出申请并清偿完毕全部保理预付款及其他相关费用。甲方应在乙方清偿完毕之日起5个工作日内，按乙方提前偿还日数，返还相应的保理手续费，但无需返还已收取的管理服务费。</p>

                                <p><span class="agreement-font3">7. 展期和续保</span></p>

                                <p>1.28.
                                    乙方如有特殊原因需要延长保理期限，如果保理期限在90日以上的，乙方应当在到期日前30日向甲方提出书面申请，经甲方同意后，由甲方向乙方出具《展期通知书》,展期费用和展期期限以《展期通知书》为准。</p>

                                <p>1.29. 当乙方按约定方式结清保理预付款时，可向甲方申请续做新的保理业务。</p>

                                <p><span class="agreement-font3">8. 关停并转</span></p>

                                <p>1.30.
                                    在本协议有效期内，乙方未经甲方书面同意，不得发生关闭、停业、合并、转业或转让等情形。甲方对乙方关停并转等获取的收入享有优先偿还保理预付款的权利，并可将该权利无条件转让于第三方。</p>

                                <p><span class="agreement-font3">9. 保证</span></p>

                                <p>1.31. 保证人愿意向甲方就本协议提供不可撤销的连带责任保证。</p>

                                <p>1.32. 保证担保范围为主协议项下乙方的全部债务，包括但不限于保理预付款、管理服务费、保理手续费、代垫费用、逾期违约金、赔偿金以及甲方实现债权和担保权利的费用</p>

                                <p>1.33.
                                    保证期间自本协议生效之日起至本协议项下乙方债务履行期限届满之日后两年止。保理期限展期的，经保证人同意，保证期间至《展期通知书》重新约定的债务履行期限届满之日后两年止。如果本协议项下的债务分期履行，则对每期债务而言，保证期间均至最后一期债务履行期限届满之日后两年止。</p>

                                <p>1.34.
                                    当乙方发生违约事件时，甲方有权从保证人的任何个人银行账户中，扣收乙方逾期未清偿的保理预付款、管理服务费、保理手续费、代垫费用、逾期违约金、赔偿金以及实现债权和担保权利的费用，有权采取本协议的任一种处置措施，并要求乙方和保证人承担违约责任。</p>

                                <p><span class="agreement-font3">10. 授权委托：</span></p>

                                <p><span class="agreement-font3">1.35. 本协议中的委托在协议有效期内未经受托人书面同意不可单方撤销</span></p>

                                <p>1.36. 授权甲方向相关信息服务机构查询乙方、乙方法定代表人的相关信息。</p>

                                <p>1.37. 授权甲方向中国银联（含下属机构）和收单机构查询和验证乙方POS机交易数据，并获取POS装机之日起至协议到期日止的全部交易明细数据和商户静态信息。</p>

                                <p>1.38. 授权甲方向中国人民银行征信中心《应收账款质押登记系统》进行转让登记、修改和撤销登记。</p>

                                <p>1.39. 授权甲方在“关联POS机账户还款”方式下，通知收单机构将POS机结算账户改为甲方保理资金监管账户。</p>

                                <p>1.40. 授权甲方在“直接扣款”方式下，通过第三方机构代扣乙方提供的银行账户，用于偿还保理预付款和支付相关费用及逾期违约金。</p>

                                <p><span class="agreement-font3">11. 甲方的权利和义务</span></p>

                                <p>1.41. 甲方有权制定服务准入标准，并根据市场需求和风险程度，调整服务项目、服务内容和收费标准。</p>

                                <p>1.42. 甲方有义务对乙方提供尽责、勤勉的服务，对获取的乙方资料不得泄露给无关第三方（法律法规规定除外）。</p>

                                <p>1.43. 甲方有权了解、检查、监督乙方的生产经营、管理、财务收支等情况。</p>

                                <p>1.44. 甲方可以将本合同项下权利全部或部分转让给第三人，并向其提供与本合同有关的资料和信息。</p>

                                <p><span class="agreement-font3">12. 乙方的权利和义务</span></p>

                                <p>1.45. 乙方有权要求甲方按本协议的约定提供保理融资。</p>

                                <p>1.46. 乙方应按本协议的约定，保证用于还款的银行账户有足够余额用于偿还保理预付款、保理手续费及其他费用。</p>

                                <p>1.47. 乙方应积极配合甲方对其有关生产经营和财务情况的调查，了解，并按甲方要求及时提供有关材料。</p>

                                <p>1.48. 乙方应在下列事件发生5日内通知甲方，并向甲方提供事件的有关资料：</p>

                                <p>1.1.1. 发生任何违约事件。</p>

                                <p>1.1.2. 预期中的违约事件或可能发生的将对甲方在本协议项下的权益造成侵害的任何事件。</p>

                                <p>1.1.3. 涉及被任何债权人索偿总额超过保理预付款30%或等值的其他货币的诉讼、仲裁或任何形式的索赔。</p>

                                <p>1.1.4.
                                    变更单位名称、住所、注册资本、经营范围、公司类型，修改公司章程，股份制改造、承包、租赁、合并、分立、联营、与外商合资或合作，在财务方面发生重大变化或股权变动及其他重大事项。</p>

                                <p>1.49. 未经甲方的事先书面同意，乙方不得将本协议项下任何权利和义务转让给第三人，亦不得泄露给无关第三方（法律法规规定除外）。</p>

                                <p>1.50. 本协议生效后，乙方不得签署任何足以损害本协议项下甲方利益的协议或文件，或从事任何足以损害甲方利益的事项。</p>

                                <p><span class="agreement-font3">13. 违约及违约责任</span></p>

                                <p><span class="agreement-font3">1.51. 甲方和乙方中任何一方违反本协议的约定，视为该方违约，违约方应当依法或依本协议的约定承担相应的违约责任。</span>
                                </p>

                                <p><span class="agreement-font3">1.52. 下述任一事项构成违约事件：</span></p>

                                <p>1.1.5. 乙方未履行本协议项下义务或违背在本协议项下所做的陈述、保证或承诺。</p>

                                <p>1.1.6. 乙方未使用甲方指定的收单机构的POS机具作为唯一刷卡机具时。 </p>

                                <p>1.1.7. 乙方在“关联POS机账户还款”方式下，未使用甲方的保理资金监管账户作为POS机唯一回款账户；或未归还每月最低还款额时。</p>

                                <p>1.1.8. 乙方在“直接扣款”方式下，银行卡账户未有足够的余额，归还应归还的保理预付款及保理手续费时。</p>

                                <p>1.1.9. 乙方在融资到期日，未能按期足额归还甲方的保理预付款及保理手续费时。</p>

                                <p>1.1.10. 乙方任何其他债务在约定到期日未能支付。</p>

                                <p>1.1.11. 任何其他债权人取得乙方的全部或任何部分业务或资产的所有权，或针对乙方任何资产被强制执行，从而实质地影响乙方履行本协议项下义务的能力。</p>

                                <p>1.1.12. 乙方的生产经营、财务状况发生任何重大不利变化，或其在本合同项下履约能力发生重大不利变化。</p>

                                <p>1.1.13. 乙方因违反食品安全、安全生产、环境保护等相关法律法规、监管规定或行业标准造成责任事故，从而对其履行本协议项下义务的能力产生重大不利影响的。</p>

                                <p>1.1.14. 乙方涉及或可能涉及重大经济纠纷，或资产被查封、扣押或被强制执行，从而对其履行本合同项下义务的能力产生重大不利影响的。</p>

                                <p>1.1.15. 乙方或其主要投资者、关键管理人员，乙方关联方或保证人发生下列情形之一，影响或可能影响其在本合同项下义务的履行或对甲方权益产生严重影响：</p>

                                <p>1.1.1.1. 被司法机关或税务、工商等行政执法机关和行政管理机关依法立案查处或依法采取处罚措施。</p>

                                <p>1.1.1.2. 乙方与其关联方之间的控制或被控制关系发生变化。</p>

                                <p>1.1.1.3. 乙方的关联方涉及或可能涉及重大经济纠纷、诉讼、仲裁。</p>

                                <p>1.1.1.4. 人员异常变动或涉嫌违法犯罪行为而被司法机关依法调查或限制人身自由。</p>

                                <p>1.1.1.5. 可能对乙方产生不利影响的其他事项。</p>

                                <p>1.1.16. 乙方通过关联交易，套取甲方资金或授信的，有意逃废甲方债权的。</p>

                                <p>1.1.17. 影响或可能影响乙方履行本合同项下义务的任何其他情形。</p>

                                <p><span class="agreement-font3">1.53. 发生上述任一违约事件，甲方有权采取下列一项或多项措施：</span></p>

                                <p>1.1.18. 要求乙方在五个工作日内，采取补救措施并纠正。</p>

                                <p>1.1.19. 按保理预付款的一定比例，每日向乙方收取逾期违约金。</p>

                                <p>1.1.20. 暂缓撤销在中国人民银行征信中心的乙方账款转让登记。</p>

                                <p>1.1.21. 宣布本协议项下的保理融资业务立即到期，要求乙方立即偿还的未清偿的保理预付款及相关费用，并赔偿损失。</p>

                                <p>1.1.22. 委托第三方机构进行逾期催收。</p>

                                <p>1.1.23. 向有管辖权的人民法院提起诉讼、保全或执行。</p>

                                <p>1.1.24. 要求乙方承担甲方因实现债权而发生的各项合理费用(包括但不限于诉讼费用、律师费等)。</p>

                                <p>1.1.25. 将乙方及其法定代表人、保证人逾期还款信息在相关机构登记。</p>

                                <p>1.1.26. 保留向乙方亲友圈或媒体披露的权利。</p>

                                <p>1.54. 因不可抗力导致一方不能履行本协议的，该方无须就此承担赔偿责任，但应及时采取措施防止扩大损失，否则对方有权就此提出损失赔偿。</p>

                                <p>1.55.
                                    鉴于乙方向甲方转让的是其对甲方指定的收单机构的账款，乙方已承诺上述转让账款是将来必定产生的真实、合法债权，而乙方使用甲方指定的收单机构的POS机作为唯一刷卡机具，是乙方对甲方指定的收单机构产生真实账款的唯一渠道，因此若乙方使用非甲方指定的其他POS机具作为刷卡机具的，转让账款根本不可能产生，此时应视为乙方以虚构的账款签订协议以骗取甲方保理预付款；若经甲方两次催收后，乙方仍拒不改正的，应视为乙方故意隐匿保理预付款、拒不返还。</p>

                                <p>1.56.
                                    乙方郑重声明，未经甲方事先书面同意，将且仅将甲方指定的POS机具作为唯一刷卡机具，不因任何原因使用非甲方指定的其他POS机具作为刷卡机具；否则，即应视为乙方具有以非法占有为目的、骗取甲方财物的主观恶意，由此侵犯了国家对协议的管理秩序和甲方的财产权益，乙方对此声明的法律意义和严重后果完全知晓并同意：届时甲方将有权依法提请公安机关刑事立案并追究乙方（也包括直接负责的主管人员和其他直接责任人员）的刑事责任。</p>

                                <p><span class="agreement-font3">14. 争议解决的方法</span></p>

                                <p><span class="agreement-font3">本协议履行期间，凡由本协议引起的或与本协议有关的一切争议、纠纷，当事人应协商解决，协商不成的，可在原告住所地或被告住所地法院通过诉讼方式解决。</span>
                                </p>

                                <p><span class="agreement-font3">15. 协议的期限、变更、解除和终止</span></p>

                                <p>15.1 各方当事人因本合同的履行事宜而需要通知或催告对方的，甲方、乙方及保证人确认以下地址为函件送达地址，函件邮寄至该地址即视为有效送达。</p>

                                <p>15.2
                                    因本合同的履行所产生的纠纷诉诸法院的，甲方、乙方及保证人确认以下地址为各方当事人的法律文书送达地址，该地址适用于各个诉讼和执行阶段，法院将法律文书邮寄至该地址即视为有效送达。</p>

                                <p>15.3
                                    在本合同生效后，各方当事人的以下送达地址发生变更的，应及时书面告知对方当事人和受诉法院变更后的送达地址；如因当事人不及时告知对方当事人和受诉法院变更后的地址、或提供的送达地址不确切、或拒绝签收，导致函件或法院法律文书未能被实际接收的，函件及法律文书退回之日视为送达之日，当事人将自行承担由此而产生的法律后果。</p>

                                <p><span class="agreement-font3">16. 附则</span></p>

                                <p>1.57. 本协议由《商业保理申请书》、《商业保理协议书》、《商业保理确认书》和附件组成，不可分割，具有同等法律效力。</p>

                                <p>1.58.
                                    乙方应在本协议的信息栏中如实填写住所地址、电话等联系方式。关于本协议履行及相关事宜的通知，甲方有权选择按照《商业保理申请书》信息栏载明的申请人住所地址、乙方法定代表人住所地址发出。如果甲方派专人交付的，自送至前述任一地址时为送达之日。如果以快递或者挂号信形式寄送的，自发出之日起第四日视为送达之日。</p>

                                <p>1.59. 任何一方的联系方式发生变更的，应当及时书面通知对方，否则因此产生的一切不利后果自行承担。</p>
                            </div>
                        </div>
                    </div>

                    <!--APP应收账款让登记协议-->
                    <!--有标题时-->
                    <div class="popups popup-agreement2 own-title">
                        <!--无标题时-->
                        <!--<div class="popups popup-agreement2">-->
                        <div class="agreement-back"><a class="close-popup glyphicon glyphicon-chevron-left"></a></div>
                        <div class="agreements">
                            <div class="content-block caseShare_story honorTit agreement-font2">
                                <span class="agreement-font3">卡得万利商业保理有限公司</span>
                            </div>
                            <div class="content-block caseShare_story honorTit">
                                <span class="agreement-font3">应收账款转让登记协议</span>
                            </div>
                            <div class="content-block caseShare_story agreement-font1">
                                <span>本服务协议双方为卡得万利商业保理有限公司（以下简称"甲方"）与甲方用户所担任法定代表人的法人或其他组织机构（以下简称"乙方"），本服务协议具有合同效力。</span>

                                <p>乙方自愿将其自有的应收账款转让给甲方，根据有关法律、法规的规定，现甲方和乙方协商一致，特订立本协议，并愿遵守协议所有条款。</p>

                                <p>第一条 甲方和乙方确认签订《商业保理协议书》和《商业保理确认书》，并将乙方相关的应收账款转让给甲方。</p>

                                <p>第二条 为确保应收账款转让的有效性，甲方和乙方同意由甲方负责办理应收账款转让登记手续，乙方应给予配合。</p>

                                <p>第三条 乙方（乙方为单位时）已经告知甲方自转让登记起过去六个月之内所有有效的乙方名称，或乙方（乙方为个人时）已经告知甲方所有有效及曾经有效的身份证件号码。</p>

                                <p>第四条
                                    办理转让登记手续时，甲方可自行确定登记期限。登记期限届满前，《商业保理协议书》和《商业保理确认书》项下债务未履行完毕的，甲方有权自行向中国人民银行征信中心申请展期，不需另行征得乙方的同意或授权。</p>

                                <p>第五条
                                    乙方法定注册名称（乙方为单位时）或有效身份证件号码（乙方为个人时）变更的，应在变更后5个工作日内书面通知甲方，并由甲方办理变更登记手续。因乙方未履行或未及时履行通知义务导致甲方未能在规定时间内办理变更登记手续的，构成商业保理主体合同项下的违约，甲方有权采取《商业保理协议书》和《商业保理确认书》中约定的违约救济措施，乙方应对由此给甲方造成的一切损失承担赔偿责任。</p>

                                <p>第六条 乙方保证未经甲方书面同意，不得将上述应收账款再转让或质押给他人，否则，乙方应对由此给甲方造成的一切损失承担赔偿责任。</p>

                                <p>第七条　办理应收账款登记所需的费用由乙方承担。</p>

                                <p>第八条 本协议未尽事宜以《商业保理协议书》和《商业保理确认书》的约定为准。</p>
                            </div>
                        </div>
                    </div>

                    <!--APP征信报告授权协议-->
                    <!--有标题时-->
                    <div class="popups popup-agreement3 own-title">
                        <!--无标题时-->
                        <!--<div class="popups popup-agreement3">-->
                        <div class="agreement-back"><a class="close-popup glyphicon glyphicon-chevron-left"></a></div>
                        <div class="agreements">
                            <div class="content-block caseShare_story honorTit agreement-font2">
                                <span class="agreement-font3">卡得万利商业保理有限公司</span>
                            </div>
                            <div class="content-block caseShare_story honorTit">
                                <span class="agreement-font3">征信报告授权协议</span>
                            </div>
                            <div class="content-block caseShare_story agreement-font1">
                                <span>本征信报告授权协议双方为卡得万利商业保理有限公司（以下简称"甲方"）与甲方用户所担任法定代表人的法人或其他组织机构（以下简称"乙方"）。如乙方点击选择同意此协议将视为乙方是自行在“中国人民银行征信中心”（以下简称“征信中心”）的“个人信用信息服务平台”网站上查询并获得自己的报告后提交给甲方，如需帮助，甲方可帮助乙方完成这个过程（即甲方依据乙方提供的“身份验证码”获取乙方授权的征信报告，同时提交给甲方进行信用评估）。乙方将授权甲方查看乙方的征信报告信息包括但不限于央行征信报告中的所有信息，含个人信息、其所持银行卡基本信息、所持银行卡使用情况信息（交易、消费、借贷、还款、逾期等），以及乙方在银行的借贷信息等信息在内的各类信息，并将视为已阅读并理解本协议的全部内容。本协议会对与乙方的权益具有或可能具有重大关系的条款，以及对甲方具有或可能具有免责或限制责任的条款均用粗体字标注，请乙方注意。如果乙方不同意本协议的任意内容，或者无法准确理解甲方对条款的解释，请不要进行后续操作。</span>

                                <p><span class="agreement-font3">一、授权条款</span></p>

                                <p><span class="agreement-font3">（一）乙方确认，在乙方授权甲方验证并获取乙方的征信报告信息前，乙方已充分阅读、理解并接受本协议的全部内容，一旦乙方使用本服务，即表示乙方同意遵循本协议之所有约定。</span>
                                </p>

                                <p><span class="agreement-font3">（二）乙方同意，乙方是自行在“中国人民银行征信中心”（以下简称“征信中心”）的“个人信用信息服务平台”网站上查询并获得自己的报告后提交给甲方，如需帮助，甲方可帮助乙方完成这个过程（即甲方依据乙方提供的“身份验证码”获取乙方授权的征信报告提交给卡得万利进行信用评估）。乙方将授权甲方查看乙方的征信报告信息包括但不限于央行征信报告中的所有信息，含个人信息、其所持银行卡基本信息、所持银行卡使用情况信息（交易、消费、借贷、还款、逾期等）。</span>
                                </p>

                                <p><span class="agreement-font3">（三）乙方承诺，乙方已认真阅读并理解了央行征信中心网站上公告的内容，包括但不限于互联网个人信用信息服务平台介绍、征信中心温馨提示、征信中心系统公告等，具体内容详见附件。</span>
                                </p>

                                <p><span class="agreement-font3">二、保密条款</span></p>

                                <p><span class="agreement-font3">本公司重视对用户隐私的保护。因收集乙方的信息是出于遵守国家法律法规的规定以及向乙方提供服务及提升服务质量的目的，甲方对乙方的信用卡账单信息承担保密义务，不会为满足第三方的营销目的而向其出售或出租乙方的任何信息，甲方会在下列情况下才将乙方的征信报告信息与第三方共享：</span>
                                </p>

                                <p><span class="agreement-font3">1、获得乙方的同意或授权。</span></p>

                                <p><span class="agreement-font3">2、为了向乙方提供或推荐服务、产品，或为了向乙方提供更完善的服务，或者为了让乙方拥有更广泛的社交体验，甲方会与包括甲方关联公司、旗下公司及合作商户在内的第三方共享乙方的相关信息。</span>
                                </p>

                                <p><span
                                        class="agreement-font3">3、某些情况下，只有共享乙方的信息，才能提供乙方需要的服务和（或）产品，或处理乙方与他人的交易纠纷或争议。</span>
                                </p>

                                <p><span class="agreement-font3">4、为了判断乙方的卡得万利账户或交易是否安全。</span></p>

                                <p><span class="agreement-font3">5、某些服务和（或）产品由甲方的合作伙伴提供或由甲方与合作伙伴、供应商共同提供，甲方会与其共享提供服务和（或）产品需要的信息。</span>
                                </p>

                                <p><span class="agreement-font3">6、甲方与第三方进行联合推广活动，甲方可能与其共享活动过程中产生的、为完成活动所必要的个人信息。</span>
                                </p>

                                <p><span class="agreement-font3">7、为维护甲方及甲方关联公司、旗下公司和其他甲方用户的合法权益。</span></p>

                                <p><span class="agreement-font3">8、根据法律规定及合理商业习惯，在甲方计划与其他公司合并或被其收购或进行其他资本市场活动（包括但不限于IPO，债券发行）时，以及其他情形下甲方需要接受来自其他主体的尽职调查时，甲方会把乙方的信息提供给必要的主体，但甲方会通过和这些主体签署保密协议等方式要求其对乙方的个人信息采取合理的保密措施。</span>
                                </p>

                                <p><span class="agreement-font3">9、为了便于乙方与乙方的好友进行更加灵活、安全的资金往来，避免因手动输入卡得万利登录名错误而产生损失，当乙方的卡得万利账户所关联的手机号码被保存在他人手机通讯录中时，乙方的卡得万利登录名、姓名等可以被通讯录存有该手机号码的好友查询到。本协议中所称的“卡得万利账户关联的手机号码”，是指作为卡得万利登录名的手机号码或卡得万利账户绑定的手机号码。</span>
                                </p>

                                <p><span
                                        class="agreement-font3">10、同本部分第9项之目的，他人可以通过乙方的卡得万利账户关联手机号码查询到对应的卡得万利登录名，对应姓名。</span>
                                </p>

                                <p><span class="agreement-font3">11、乙方与他人通过卡得万利服务发生资金往来的，交易相对方可在付款过程中，或付款成功后可查看到乙方使用的卡得万利账户的部分信息（包括卡得万利登录名、卡得万利账户对应的姓名或昵称、卡得万利账户头像等，具体以实际可查看信息为准）。</span>
                                </p>

                                <p><span class="agreement-font3">12、如乙方授权第三方向甲方查询、采集乙方卡得万利账户相关信息，甲方有权在法律法规和乙方的授权许可范围内向第三方分享乙方卡得万利账户的部分信息。</span>
                                </p>

                                <p><span class="agreement-font3">13、为了维护和改善甲方的服务。</span></p>

                                <p><span class="agreement-font3">14、根据法律法规的规定或有权机关的要求。</span></p>

                                <p><span class="agreement-font3">15、乙方理解并同意，甲方可以储存乙方授权的原始信息；在乙方和甲方的合作存续期间，甲方随时可以从新采集和更新数据，对于经过加工和脱敏处理的数据，甲方可以永久保存在服务器上。</span>
                                </p>

                                <p>三、用户义务及免责声明</p>

                                <p>（一）乙方保证，征信报告信息的授权为乙方本人操作并为本人身份信息，不可用他人的身份信息。</p>

                                <p>（二）如乙方借他人之名授权，甲方将有权暂停或终止与乙方的全部或部分服务协议，并将由乙方承担由此行为所产生的全部法律责任，甲方将不对此承担法律责任。</p>
                            </div>
                        </div>
                    </div>

                    <!--APP注册协议-->
                    <!--有标题时-->
                    <div class="popups popup-agreement4 own-title">
                        <!--无标题时-->
                        <!--<div class="popups popup-agreement4">-->
                        <div class="agreement-back"><a class="close-popup glyphicon glyphicon-chevron-left"></a></div>
                        <div class="agreements">
                            <div class="content-block caseShare_story honorTit agreement-font2">
                                <span class="agreement-font3">卡得万利商业保理有限公司</span>
                            </div>
                            <div class="content-block caseShare_story honorTit agreement-font2">
                                <span class="agreement-font3">卡得万利平台会员服务协议</span>
                            </div>
                            <div class="content-block caseShare_story agreement-font1">
                                <span>本客户端是由卡得万利商业保理有限公司（以下简称“甲方”）提供综合金融服务的网络平台（以下简称“平台”）。因甲方的服务仅向甲方会员提供，若您一经注册成为甲方会员或使用甲方提供的服务，则表示您完全接受本协议全部条款的约束，并视为对本协议全部条款已充分理解、完全接受，否则将无权使用甲方提供的服务，应立即停止注册和使用甲方的服务。</span>

                                <p>甲方根据本协议约定为甲方会员（以下简称“乙方”）提供服务, <span class="agreement-font3">甲方已将本协议中免除、限制甲方责任、或加重乙方责任、或限制乙方主要权利的条款用粗体格式给予标注，用于提醒乙方特别注意，保证乙方在仔细阅读、并完全理解本协议的情况下，选择接受或不接受本协议。</span>
                                </p>

                                <p><span class="agreement-font4">一、 签署</span></p>

                                <p>0. 乙方确认按照中华人民共和国的法律法规，乙方有独立签署本协议并使用甲方提供的服务的权利。若乙方不符合此条件，请立即停止注册。</p>

                                <p>1.
                                    乙方在注册时填写真实、有效的信息，如姓名、身份证号码、手机号码、邮箱等，及时更新在甲方平台填写的信息并按照甲方的规定完成身份认证等，否则由乙方独自承担由此产生的所有损失。</p>

                                <p>2. 本协议内容及已经发布的或将来发布在甲方平台的各类规则为本协议不可分割的一部分，与协议正文具有同等法律效力。</p>

                                <p><span class="agreement-font3">为了提供更好的服务，甲方有权根据需要变更本协议或已发布在甲方平台的各项规则，发生如上变更时甲方将在平台上公布最新的协议内容和规则，并将本协议内容替换为变更后的协议文本，乙方在使用甲方提供的服务时关注修改后的协议、规则。如果本协议修改或变更后，乙方仍继续使用甲方提供的服务的，即代表乙方已阅读、了解并同意接受变更后的协议、规则内容；乙方如果不同意变更后的协议、规则内容，乙方应立即停止使用甲方提供的服务。</span>
                                </p>

                                <p>3. 甲方以电子形式发出的通知在发出当日视为送达，并在乙方和甲方之间产生法律效力。</p>

                                <p><span class="agreement-font4">二、 服务说明</span></p>

                                <p>0. 提供平台信息服务</p>

                                <p>乙方可以通过甲方平台查询交易信息、签订合同文本等， 具体内容以甲方平台当时提供的服务内容为准。</p>

                                <p>1. 甲方的客服电话为：<span class="agreement-font3">400-608-1310</span>,若甲方发布新的客服电话或更改平台均会在平台上提前公布。<span
                                        class="agreement-font3">请不要通过其他方式登录甲方平台或者拨打其他电话联系甲方，否则由此导致的损失由乙方自行承担。</span></p>

                                <p><span class="agreement-font3">2. 一经乙方使用甲方提供的服务，即表示乙方不可撤销地授权甲方进行相关操作，且该等操作是不可逆转的，乙方不能以任何理由拒绝支付或要求取消交易。就前述服务，可能与第三方发生费用，乙方与第三方之间就费用支付事项产生的争议或纠纷，与甲方无关。</span>
                                </p>

                                <p><span class="agreement-font3">乙方在甲方平台上按甲方服务流程所确认的交易状态将成为甲方为乙方进行相关交易或操作（包括但不限于冻结资金、支付或收取款项、订立合同等）的明确指令。乙方同意甲方有权按相关指令依据本协议和/或相关规则进行处理。</span>
                                </p>

                                <p><span class="agreement-font3">3. 乙方保证并承诺乙方通过甲方平台进行交易的资金用途合法。乙方同意，甲方有权按照包括但不限于公安机关、检察机关、法院等司法机关、行政机关、军事机关的要求协助对乙方的账户及资金等进行查询、冻结或扣划等操作。</span>
                                </p>

                                <p>4.
                                    乙方同意，甲方有权进行关于与乙方交易有关的保理预付款的违约提醒及催收工作，包括但不限于：电话通知、上门催收提醒、发律师函、提起诉讼等。并授权甲方可以将此工作委托给本协议外的其他方进行。</p>

                                <p><span class="agreement-font4">三、 合同签订、管理</span></p>

                                <p>
                                    乙方理解并同意在甲方平台交易所订立的合同采用电子合同方式，即乙方使用在甲方平台注册的账户通过点击确认或类似方式签署的电子合同即视为乙方本人真实意思表示并具有法律效力。因此甲方在此特别提醒乙方，乙方应妥善保管乙方的账户信息和密码，乙方不得以其账户密码等账户信息被盗用或其他理由否认通过前述方式订立的电子合同对各方具有的法律约束力或不按照该等合同履行义务。</p>

                                <p>在乙方以前述方式签署电子合同后不得擅自修改合同。<span class="agreement-font3">如乙方对电子合同的内容有任何疑问，乙方可以在甲方平台账户里登录乙方账户查阅相关合同，若对此有任何争议的，应以甲方记录的合同为准。</span>
                                </p>

                                <p><span class="agreement-font4">四、乙方的义务与承诺</span></p>

                                <p>0.
                                    乙方同意，甲方有权以各种方式投放各种商业性广告或其他任何类型的商业信息（包括不限于在甲方平台的任何页面上投放广告），并且，乙方同意接受甲方通过电子邮件、短信或其他方式向乙方发送产品信息或其他相关商业信息。</p>

                                <p><span class="agreement-font3">1. 授权甲方在相关信息服务机构查询乙方及乙方担任法定代表人的法人、其他组织机构（以下简称“乙方机构”）的相关信息。</span>
                                </p>

                                <p><span class="agreement-font3">2. 授权甲方向第三方查询乙方机构POS交易数据报告，用于评估信用状况，查询期限为申请保理之日至所有预支对价款及相关款项全部结清之日或至申请保理拒绝之日。</span>
                                </p>

                                <p><span class="agreement-font3">3. 授权甲方从收单机构获取POS装机之日起至协议到期日止的交易明细数据和商户静态信息。</span></p>

                                <p><span class="agreement-font3">4. 授权甲方有权保管甲方指定POS机具之外的其他无关POS机具。</span></p>

                                <p><span class="agreement-font3">5. 授权甲方通知乙方收单机构将POS机结算账户改为甲方保理账户。</span></p>

                                <p><span class="agreement-font3">6. 授权甲方在放款前从乙方提供的还款银联卡（包括但不限于借记卡、信用卡等）银行账号试扣除约定金额。如乙方最终签署保理协议，甲方将从乙方应付保理手续费中扣除返还。如乙方未签署保理协议，甲方将直接返还约定金额至乙方被扣银行账户。</span>
                                </p>

                                <p><span
                                        class="agreement-font3">7. 授权甲方每周或每月从乙方提供的还款银联卡（包括但不限于借记卡、信用卡等）扣除当周或当月应还预支金额。</span>
                                </p>

                                <p><span class="agreement-font3">8. 授权甲方在中国人民银行征信中心《应收账款质押和转让登记公示系统》中登记公示本协议。</span></p>

                                <p><span class="agreement-font3">9. 无论因甲方、第三方支付或银行系统故障或其他原因导致金额错误，乙方和乙方机构都有义务退回多计算的保理预付款。</span>
                                </p>

                                <p><span class="agreement-font3">10. 在任何情况下，对于乙方使用甲方服务过程中涉及由第三方提供相关服务的责任由该第三方承担，甲方不承担该等责任。因乙方自身的原因导致甲方服务无法提供或提供时发生任何错误而产生的任何损失或责任，由乙方自行负责，甲方不承担责任。</span>
                                </p>

                                <p><span class="agreement-font3">11. 甲方有权对平台进行升级或基于平台运行和交易安全的考虑，甲方可以暂时停止提供服务、也可以改变所提供服务的内容，增加或减少平台功能，只要乙方继续使用甲方的服务，则视为乙方接受以上内容对乙方的约束。</span>
                                </p>

                                <p>12. 账户及密码安全</p>

                                <p>乙方了解并同意，确保密码及账号的机密安全是乙方的责任。乙方应避免设置过于明显或简单的密码，如乙方的姓名、昵称或者乙方的生日。</p>

                                <p>乙方将对利用该密码及账号所进行的一切行为负完全的责任，同时，乙方应保证乙方不对其他任何人泄露乙方的账户或密码，亦不可使用其他任何人的账户或密码。</p>

                                <p><span class="agreement-font3">因黑客、病毒或乙方的保管疏忽等原因导致账号遭他人非法使用的，甲方不承担任何责任。</span></p>

                                <p><span class="agreement-font3">甲方通过乙方的会员账户及密码来识别乙方的指令，乙方确认，使用乙方的会员账户和密码登陆后在甲方的一切行为均代表乙方和乙方机构。会员账户操作所产生的电子信息记录均为乙方行为的有效凭据，并由乙方和乙方机构承担由此产生的全部责任。</span>
                                </p>

                                <p><span class="agreement-font3">冒用他人账户及密码的，甲方及其合法授权主体保留追究实际使用人连带责任的权利。</span></p>

                                <p><span class="agreement-font3">13. 在任何情况下，甲方及其股东、创建人、高级职员、董事、代理人、关联公司、母公司、子公司和雇员等和甲方有关联方均不以任何明示或默示的方式对乙方使用甲方服务而产生的任何形式的直接或间接损失承担法律责任，包括但不限于资金损失、利润损失。</span>
                                </p>

                                <p>14.
                                    乙方承诺合法使用甲方提供的服务及平台内容。乙方不得利用本服务从事侵害他人合法权益之行为，不得在甲方平台从事任何可能违反中国的法律、法规、规章和政府规范性文件的行为或者任何未经授权的行为，如擅自进入甲方的未公开的系统、不正当的使用账号密码和平台的任何内容等。</p>

                                <p>15.
                                    甲方没有义务监测平台内容，但是乙方确认并同意甲方有权根据法律、法规、政府要求透露、修改或者删除必要的信息，以便更好地运营甲方并保护自身及甲方的其他合法用户。</p>

                                <p>16.
                                    甲方中全部内容的版权均属于甲方所有，该等内容包括但不限于文本、数据、文章、设计、源代码、软件、图片、照片及其他全部信息（以下简称“平台内容”）。平台内容受中华人民共和国著作权法及各国际版权公约的保护。<span
                                            class="agreement-font3">乙方承诺，未经甲方事先书面同意，乙方承诺乙方不以任何方式、不以任何形式复制、模仿、传播、出版、公布、展示平台内容，包括但不限于电子的、机械的、复印的、录音录像的方式和形式等。</span>乙方承认平台内容是属于甲方的财产。未经甲方书面同意，乙方亦不得将甲方包含的资料等任何内容镜像到任何其他平台或者服务器。任何未经授权对平台内容的使用均属于违法行为，甲方将追究乙方的法律责任。
                                </p>

                                <p>17.
                                    由于乙方违反本协议或任何法律、法规或侵害第三方的权利，而引起第三方对甲方提出的任何形式的索赔、要求、诉讼，甲方有权向乙方追偿相关损失，包括但不限于甲方的法律费用、名誉损失及向第三方支付的补偿金等。</p>

                                <p><span class="agreement-font4">五、服务费用</span></p>

                                <p><span
                                        class="agreement-font3">0.各项服务费用请详见乙方使用甲方服务时在平台上所列的收费说明。甲方有权单方面订立和调整服务费用。</span>
                                </p>

                                <p>1. 乙方在使用甲方服务过程中可能需要向第三方（如银行或第三方支付公司等）支付一定的费用，具体收费标准详见第三方平台相关页面。</p>

                                <p><span class="agreement-font4">六、风险提示</span></p>

                                <p>0. 政策风险：有关法律、法规及相关政策、规则发生变化，影响甲方或其他与甲方平台相关的第三方提供服务或影响已提供的服务，乙方有可能遭受损失。</p>

                                <p>1. 不可抗力因素导致的风险。</p>

                                <p><span class="agreement-font3">2. 因乙方的过错导致的任何损失由乙方自行承担，该过错包括但不限于：决策失误、操作不当、遗忘或泄露密码、密码被他人破解、乙方使用的计算机系统被第三方侵入、乙方委托他人代理交易时他人恶意或不当操作而造成的损失。</span>
                                </p>

                                <p><span class="agreement-font3">3. 会员信息是由会员自行发布和提供，甲方不承担任何形式的证明、鉴定服务，即使甲方进行审核，也不代表甲方因此承担相应责任，</span>乙方根据自己的判断进行交易，乙方应对乙方的判断承担全部责任。
                                </p>

                                <p>4.
                                    以上并未涵盖在甲方平台交易的全部风险。乙方在做出交易决策前，应仔细、全面了解所进行的交易的风险特征，并根据本人的交易目标、交易期限、风险承受能力和资产状况等谨慎决策，并自行承担全部风险。</p>

                                <p><span class="agreement-font4">七、不可抗力、责任限制</span></p>

                                <p>1. 系统服务中断或故障</p>

                                <p><span class="agreement-font3">基于互联网的特殊性，甲方不保证服务不会中断，也不保证服务的及时性和安全性。系统因相关状况无法正常运作，使会员无法使用任何甲方服务或使用任何甲方服务时受到任何影响时，甲方对乙方、乙方机构、第三方不负任何责任，前述状况包括但不限于：</span>
                                </p>

                                <p><span class="agreement-font3">1.1 甲方系统或第三方支付停机维护期间。</span></p>

                                <p><span class="agreement-font3">1.2 电信设备出现故障不能进行数据传输的。</span></p>

                                <p><span
                                        class="agreement-font3">1.3 由于黑客攻击、网络供应商技术调整或故障、平台升级、银行方面的问题等原因而造成的甲方服务中断或延迟。</span>
                                </p>

                                <p><span
                                        class="agreement-font3">1.4 因台风、地震、海啸、洪水、停电、战争、恐怖袭击等不可抗力之因素，造成甲方系统障碍不能提供服务的。</span>
                                </p>

                                <p>2. 责任限制</p>

                                <p><span class="agreement-font3">2.1 甲方仅对本协议中所列明的甲方应承担相关义务承担责任。</span></p>

                                <p><span class="agreement-font3">2.2 乙方确认因交易而产生的任何风险应由交易双方承担。</span></p>

                                <p><span
                                        class="agreement-font3">2.3 会员信息是由会员自行发布，甲方无法保证会员信息的真实、及时和完整，乙方应对乙方的判断承担全部责任。</span>
                                </p>

                                <p><span class="agreement-font3">2.4 甲方未对交易种类、交易结果等交易事项及甲方服务提供任何形式的保证，包括但不限于以下事项：</span>
                                </p>

                                <p><span class="agreement-font3">2.4.1 甲方服务将符合乙方的需求。</span></p>

                                <p><span class="agreement-font3">2.4.2 甲方服务将不受干扰、及时提供或免于出错。</span></p>

                                <p><span class="agreement-font3">2.4.2 甲方服务将不受干扰、及时提供或免于出错。</span></p>

                                <p><span
                                        class="agreement-font3">3. 与甲方服务相关的第三方或者与甲方合作单位，所提供的服务品质及内容由该第三方或合作单位自行负责。</span>
                                </p>

                                <p><span class="agreement-font3">4. 甲方的平台内容可能涉及由第三方所有、控制或者运营的其他平台（以下简称“第三方平台”）。甲方不能保证也没有义务保证第三方平台上任何信息的真实性和有效性。 乙方确认按照第三方平台的服务协议使用第三方平台，而不是按照本协议。第三方平台不是甲方推荐或者介绍的，第三方平台的内容、产品、广告和其他任何信息均由乙方自行判断并承担风险，与甲方无关。乙方经由甲方服务的使用下载或取得任何资料，应由乙方自负风险，因资料的下载而导致乙方电脑系统的任何损坏或资料流失，乙方应自行承担全部风险和责任。</span>
                                </p>

                                <p><span class="agreement-font3">5. 乙方自甲方及甲方相关工作人员或经由甲方服务取得的建议或资讯，无论其为书面或口头，均不构成甲方对甲方服务的任何保证。</span>
                                </p>

                                <p><span class="agreement-font3">6. 甲方不保证为向乙方提供便利而设置的外部链接的准确性、有效性、安全性和完整性，同时，对于该等外部链接指向的不由甲方实际控制的任何网页上的内容，甲方不承担任何责任。</span>
                                </p>

                                <p><span class="agreement-font3">7. 在法律允许的情况下，甲方对于与本协议有关或由本协议引起的，或者，由于使用甲方平台、或由于其所包含的或以其它方式通过甲方平台提供给乙方的全部信息、内容、产品（包括软件）和服务、或购买和使用产品引起的任何间接的、惩罚性的、特殊的、派生的损失（包括但不限于使用数据或其他经济利益的损失），不论是如何产生的，也不论是由对本协议的违约（包括违反保证）还是由侵权造成的，均不负有任何责任，即使其事先已被告知此等损失的可能性。另外即使本协议规定的排他性救济没有达到其基本目的，甲方也不承担上述损失的责任。</span>
                                </p>

                                <p><span class="agreement-font3">8. 除本协议另有规定外，在任何情况下，甲方对本协议所承担的违约赔偿责任总额不超过向乙方收取的当次服务费用总额。</span>
                                </p>

                                <p><span class="agreement-font4">八、 协议终止及账户的暂停、注销或终止</span></p>

                                <p>0. 除非甲方终止本协议或者乙方申请终止本协议且经甲方同意，否则本协议始终有效。<span class="agreement-font3">在乙方违反了本协议、相关规则，或在相关法律法规、政府部门的要求下，甲方有权通过站内信、电子邮件通知等方式终止本协议、关闭乙方的账户或者限制乙方使用甲方平台。</span>但甲方的终止行为不能免除乙方根据本协议或在甲方生成的其他协议项下的还未履行完毕的义务。
                                </p>

                                <p><span class="agreement-font3">1. 乙方若发现有第三人冒用或盗用乙方的用户账户及密码，或其他任何未经合法授权的情形，应立即以有效方式通知甲方，要求甲方暂停相关服务，否则由此产生的一切责任由乙方本人承担。</span>同时，乙方理解甲方对乙方的请求采取行动需要合理期限，在此之前，甲方对第三人使用该服务所导致的损失不承担任何责任。
                                </p>

                                <p><span class="agreement-font3">2. 乙方决定不再使用用户账户时，应首先清偿所有应付款项（包括但不限于保理预付款本金、利息、罚息、违约金、服务费、管理费等），并向甲方申请注销该用户账户，经甲方审核同意后可正式注销用户账户。</span>会员死亡或被宣告死亡的，其在本协议项下的各项权利义务由其继承人承担。若会员丧失全部或部分民事权利能力或民事行为能力，甲方有权根据有效法律文书（包括但不限于生效的法院判决等）或其法定监护人的指示处置与用户账户相关的款项。
                                </p>

                                <p><span class="agreement-font3">3. 甲方有权基于单方独立判断，在认为可能发生危害交易安全等情形时，不经通知而先行暂停、中断或终止向乙方提供本协议项下的全部或部分会员服务，并将注册资料移除或删除，且无需对乙方或任何第三方承担任何责任。</span>前述情形包括但不限于：
                                </p>

                                <p>4.1 甲方认为乙方提供的资料不具有真实性、有效性或完整性；</p>

                                <p>4.2 甲方发现异常交易或有疑义或有违法之虞时；</p>

                                <p>4.3 甲方认为乙方的账户涉嫌洗钱、套现、传销、被冒用或其他甲方认为有风险之情形；</p>

                                <p>4.4 甲方认为乙方已经违反本协议中规定的各类规则；</p>

                                <p>4.5 甲方基于交易安全等原因，根据其单独判断需先行暂停、中断或终止向乙方提供本协议项下的全部或部分会员服务，并将注册资料移除或删除的其他情形。</p>

                                <p>4.6 乙方同意在必要时，甲方无需进行事先通知即有权终止提供用户账户服务，并可能立即暂停、关闭或删除乙方的用户账户及该用户账户中的所有相关资料及档案。</p>

                                <p>5 乙方同意，用户账户的暂停、中断或终止不代表乙方责任的终止，乙方仍应对乙方使用甲方服务期间的行为承担可能的违约或损害赔偿责任，同时甲方仍可保留乙方的相关信息。</p>

                                <p>6
                                    甲方在此特别提醒乙方注意，由于乙方违反以上约定或由于乙方的原因导致乙方的甲方账号或银行账户被停止使用或限制使用的，导致乙方已经发生的交易在到期时无法还款进乙方的相应账户的损失，由乙方承担。</p>

                                <p><span class="agreement-font4">九、 通知</span></p>

                                <p>
                                    本协议项下的通知一经在平台公示即视为已经送达。除此之外，其他向乙方发布的具有专属性的通知将由甲方向乙方在注册时提供的电子邮箱，或甲方在乙方的账户中为乙方设置的站内消息系统栏，或乙方在注册后在甲方绑定的手机发送，一经发送即视为已经送达。乙方密切关注乙方的电子邮箱、站内消息系统栏中的邮件、信息及手机中的短信信息。乙方同意甲方出于向乙方提供服务之目的，可以向乙方的电子邮箱、站内消息系统栏和手机发送有关通知或提醒；若乙方不愿意接收，请在甲方相应系统板块进行设置。但乙方同时同意并确认，若乙方设置了不接收有关通知或提醒，则乙方有可能收不到该等通知信息，乙方不得以乙方未收到或未阅读该等通知信息主张相关通知未送达于乙方。</p>

                                <p><span class="agreement-font4">十、 适用法律和管辖</span></p>

                                <p><span class="agreement-font3">因甲方所提供服务而产生的争议均适用中华人民共和国法律，并由甲方住所地的人民法院管辖。</span></p>

                                <p><span class="agreement-font4">十一、 其他</span></p>

                                <p>
                                    甲方对本协议拥有最终的解释权。本协议及甲方有关页面的相关名词可互相引用参照，如有不同理解，则以本协议条款为准。此外，若本协议的部分条款被认定为无效或者无法实施时，本协议中的其他条款仍然有效。</p>

                                <p><span class="agreement-font4">十二、 声明</span></p>

                                <p>本平台由卡得万利商业保理有限公司（以下简称甲方）设立。本声明包含网络所适用的有关条款。凡浏览本平台及相关网页用户，均表示接受以下条款。</p>

                                <p>
                                    并非所有的客户都可以获得所有的产品和服务，乙方是否符合条件享受特别产品和服务，最终的解释权归甲方。甲方保留对该网页包含的信息和资料及其显示的条款、条件和说明变更的权利。任何在本平台出现的信息包括但不限于评论、预测、图表、指标、理论、直接的或暗示的指示均只作为参考，乙方须对任何自主决定的行为负责。互联网传输可能会受到干扰，中断、延迟或数据错误，甲方对于非本平台能控制的通讯设施故障可能引致的数据及交易之准确性或及时性不负任何责任。凡通过本平台与其他平台的链接，而获得其所提供的网上资料及内容，乙方应该自己进行辨别及判断，本站不承担任何责任。本站某些部分或网页可能包括单独条款和条件，作为对本条款和条件的补充，如果有任何冲突，该等附加条款和条件将对相关部分或网页适用。</p>

                                <p>1. 版权声明</p>

                                <p>本平台提供的任何内容（包括但不限于数据、文字、图表、图象、声音或录像等）的版权均属于甲方或相关权利人。未经甲方或相关权利人事先的书面许可，
                                    乙方不得以任何方式擅自复制、再造、传播、出版、转帖、改编或陈列本平台的内容。
                                    同时，未经甲方书面许可，对于本平台上的任何内容，任何人不得在非甲方所属的服务器上做镜像。任何未经授权使用本平台的行为都将违反《中华人民共和国著作权法》和其他法律法规以及有关国际公约的规定。</p>

                                <p>2. 域名与商标声明</p>

                                <p>
                                    未经甲方书面授权，任何单位或个人不得使用本平台的任何内容。甲方平台使用的所有图案及文字商标均为甲方在中国和其他国家的注册商标，未经甲方书面授权，任何单位或个人不得以任何方式使用上述商标的全部或部分。</p>
                            </div>
                        </div>
                    </div>

                    <!--银行卡绑定授权协议-->
                    <!--有标题时-->
                    <div class="popups popup-agreement5 own-title">
                        <!--无标题时-->
                        <!--<div class="popups popup-agreement5">-->
                        <div class="agreement-back"><a class="close-popup glyphicon glyphicon-chevron-left"></a></div>
                        <div class="agreements">
                            <div class="content-block caseShare_story honorTit agreement-font2">
                                <span class="agreement-font3">卡得万利商业保理有限公司</span>
                            </div>
                            <div class="content-block caseShare_story honorTit agreement-font2">
                                <span class="agreement-font3">卡得万利银行卡用户服务协议</span>
                            </div>
                            <div class="content-block caseShare_story agreement-font1">
                                <span>卡得万利银行卡用户服务协议双方为卡得万利商业保理有限公司（以下简称"甲方"）与甲方用户所担任法定代表人的法人或其他组织机构（以下简称"乙方"）。卡得万利银行卡用户服务，是指由甲方基于甲方客户端向乙方提供的银行卡认证、提现、代收和代付服务。如乙方点击选择同意此协议将视为同意甲方通过乙方所授权的银行卡为乙方提供认证、提现、代付和代收服务，并将视为己阅读并理解本协议的全部内容。本协议会对与乙方的权益具有或可能具有重大关系的条款，以及对甲方具有或可能具有免责或限制责任的条款均用粗体字标注，请乙方注意。如果乙方不同意本协议的任意内容，或者无法准确理解甲方对条款的解释，请不要进行后续操作。</span>

                                <p>一、声明与承诺</p>

                                <p>（一）卡得万利银行卡用户服务是由甲方基于卡得万利客户端向乙方提供的银行卡认证、提现、代收和代付服务，为了保障乙方的权益，<span
                                        class="agreement-font3">乙方应保证自己在注册使用卡得万利时为具有完全民事行为能力的自然人。</span>乙方在使用本卡得万利银行卡用户服务前，必须仔细阅读本服务协议所有条款。一经注册使用卡得万利即视为乙方对本协议服务条款的接受和确认。
                                </p>

                                <p>
                                    （二）乙方同意，甲方可对本协议内容进行单方变更或修改，并以公告的方式予以公布，不另作个别通知，乙方可以通过卡得万利客户端／公司网站等途径查阅；若乙方在本协议内容公告变更后继续使用本服务的，表示乙方已充分阅读、理解并接受修改后的协议内容，也将遵循修改后的协议内容使用本服务；若乙方不同意修改后的协议内容，乙方应停止使用本服务。</p>

                                <p>（三）乙方保证，在乙方同意接受本协议时，乙方所提供的银行卡账户为乙方本人名下账户。不具备前述条件的，乙方应及时修改所提交的银行卡信息或停止使用本服务。</p>

                                <p>
                                    （四）乙方同意，乙方在使用卡得万利银行卡过程中的所有行为，乙方不可撤销的授权由甲方按照《卡得万利银行卡用户服务协议》进行处理；同时甲方有权为提供前述服务的需要获取乙方的相关信息（包括但不限于个人信息、行为信息、账户相关信息等）。甲方按照乙方的操作指令或《卡得万利银行卡用户服务协议》的相关约定进行资金的冻结、扣划完全来自于乙方的授权，因此造成的任何损失甲方不承担任何责任。但乙方确认，乙方使用卡得万利服务时，乙方仍应完全遵守本《卡得万利银行卡用户服务协议》及甲方制定的各项规则及页面提示等。</p>

                                <p>二、服务条款</p>

                                <p>（一）银行卡认证、提现、代付与代收条款</p>

                                <p>1、在使用提现、代付或代收服务前，乙方需符合下列要求</p>

                                <p>(1) 乙方使用卡得万利提现、代付或代收服务符合当地的法律法规，并能独立承担法律责任。</p>

                                <p>(2) 乙方己开设了有效的银行卡账户，并将其与卡得万利银行卡服务绑定。</p>

                                <p>(3) 乙方需提供真实、有效、完整和最新的注册信息，且通过了信用评估或相关信息认证。</p>

                                <p>2、在使用银行卡认证服务前，乙方需符合下列要求</p>

                                <p>(1) 乙方使用卡得万利银行卡认证服务符合当地的法律法规，并能独立承担法律责任。</p>

                                <p>(2) 乙方己开设了有效的银行卡账户，并将其与卡得万利银行卡服务绑定。</p>

                                <p>(3) 乙方需提供真实、有效、完整和最新的注册信息，且通过了信用评估或相关信息认证。</p>

                                <p>(4) 乙方需授权甲方向第三方支付／征信／金融机构查询或获取乙方账户相关信息。</p>

                                <p>
                                    3、如乙方满足上述相应要求，则甲方将通过乙方所绑定或授权的银行卡为乙方提供卡得万利银行卡服务，其包括但不限于银行卡认证、提现、代付与代收服务等，具体详情以甲方当时提供的服务内容为准。</p>

                                <p>(1)
                                    银行卡认证服务：银行卡认证服务是指甲方为乙方提供的通过查询、核实、获取乙方的个人公开信息和乙方所授权的银行卡等的账户信息及交易信息来绑定乙方的银行卡账户，授予乙方信用额度的服务。</p>

                                <p>(2)
                                    提现／代付服务：在符合甲方规定或产品规则的情况下，乙方可以请求甲方在乙方卡得万利账户中的信用额度范围内提供投资人撮合服务，并提取到乙方名下绑定的有效中国大陆银行账户内或支付到甲方合作商家的银行账户内，以满足乙方的资金需求。</p>

                                <p>(3)
                                    代收服务：如乙方在卡得万利上使用了提现／代付服务，依据《借款与还款协议》及《卡得万利服务与隐私协议》，甲方将在账单到期后通过乙方所绑定的银行账户为乙方提供代收还款服务。</p>

                                <p>（二）授权条款</p>

                                <p>1、乙方理解并同意，在乙方提交或绑定银行卡信息或账户后，甲方在为乙方提供卡得万利服务时有权查询并核对乙方所提交的银行卡账户信息。</p>

                                <p>
                                    2、乙方理解并同意，在乙方使用卡得万利银行卡认证服务后，即不可撤销地授权甲方向第三方查询乙方的银行卡交易数据报告，用于评估信用状况，查询期限为申请贷款之日至所有贷款及相关款项全部结清之日或至申请贷款拒绝之日。</p>

                                <p>3、乙方理解并同意，在乙方授权或绑定银行卡账户后对乙方所授权或绑定的银行卡账户进行打款或扣款。</p>

                                <p>三、保密条款</p>

                                <p>
                                    甲方重视对用户隐私的保护。因收集乙方的信息是出于遵守国家法律法规的规定以及向乙方提供服务及提升服务质量的目的，甲方对乙方的信息承担保密义务，不会为满足第三方的营销目的而向其出售或出租乙方的任何信息，甲方会在下列青况下才将乙方的信息与第三方共享：</p>

                                <p>1、获得乙方的同意或授权。</p>

                                <p>
                                    2、为了向乙方提供或推荐服务、产品，或为了向乙方提供更完善的服务，或者为了让乙方拥有更广泛的社交体验，甲方会与包括卡得万利关联公司、旗下公司及合作商户在内的第三方共享乙方的相关信息。</p>

                                <p>3、某些情况下，只有共享乙方的信息，才能提供乙方需要的服务和（或）产品，或处理乙方与他人的交易纠纷或争议。</p>

                                <p>4、为了判断乙方的卡得万利账户或交易是否安全。</p>

                                <p>5、某些服务和（或）产品由甲方的合作伙伴提供或由甲方与合作伙伴、供应商共同提供，甲方会与其共享提供服务和（或）产品需要的信息。</p>

                                <p>6、甲方与第三方进行联合推广活动，甲方可能与其共享活动过程中产生的、为完成活动所必要的个人信息。</p>

                                <p>7、为维护甲方及甲方关联公司、旗下公司和其他甲方用户的合法权益。</p>

                                <p>
                                    8、根据法律规定及合理商业习惯，在甲方计划与其他公司合并或被其收购或进行其他资本市场活动（包括但不限于IPO，债券发行）时，以及其他情形下甲方需要接受来自其他主体的尽职调查时，甲方会把乙方的信息提供给必要的主体，但甲方会通过和这些主体签署保密协议等方式要求其对乙方的个人信息采取合理的保密措施。</p>

                                <p>
                                    9、为了便于乙方与乙方的好友进行更加灵活、安全的资金往来，避免因手动输入卡得万利登录名错误而产生损失，当乙方的卡得万利账户所关联的手机号码被保存在他人手机通讯录中时，乙方的卡得万利登录名、姓名等可以被通讯录存有该手机号码的好友查询到。本协议中所称的“卡得万利账户关联的手机号码”，是指作为卡得万利登录名的手机号码或卡得万利账户绑定的手机号码。</p>

                                <p>10、同本部分第9项之目的，他人可以通过乙方的卡得万利账户关联手机号码查询到对应的卡得万利登录名、相应的姓名。</p>

                                <p>
                                    11、乙方与他人通过卡得万利服务发生资金往来的，交易相对方可在付款过程中，或付款成功后可查看到乙方使用的卡得万利账户的部分信息（包括卡得万利登录名、卡得万利账户对应的姓名或昵称、卡得万利账户头像等，具体以实际可查看信息为准）。</p>

                                <p>12、如乙方授权第三方向甲方查询、采集乙方卡得万利账户相关信息，甲方有权在法律法规和乙方的授权许可范围内向第三方分享乙方卡得万利账户的部分信息</p>

                                <p>13、为了维护和改善甲方的服务。</p>

                                <p>14、根据法律法规的规定或有权机关的要求。</p>

                                <p>四、用户义务及免责声明</p>

                                <p>（一）乙方保证，乙方所授权的银行卡账户为乙方本人的真实账户，不可为他人的银行卡账户。</p>

                                <p>（二）如乙方所授权的银行卡账户为他人或虚假账户，甲方将有权暂停或终止与乙方的全部或部分服务协议，此行为所产生的全部法律责任将由乙方承担，甲方将不对此承担法律责任。</p>
                            </div>
                        </div>
                    </div>

                    <!--隐私说明-->
                    <!--有标题时-->
                    <div class="popups popup-agreement6 own-title">
                        <!--无标题时-->
                        <!--<div class="popups popup-agreement6">-->
                        <div class="agreement-back"><a class="close-popup glyphicon glyphicon-chevron-left"></a></div>
                        <div class="agreements">
                            <div class="content-block caseShare_story honorTit agreement-font2">
                                <span class="agreement-font3">卡得万利商业保理有限公司</span>
                            </div>
                            <div class="content-block caseShare_story honorTit agreement-font2">
                                <span class="agreement-font3">隐私说明</span>
                            </div>
                            <div class="content-block caseShare_story agreement-font1">
                                <span>0. 本平台所收集的信息，仅限于那些卡得万利商业保理有限公司（以下简称“卡得万利”）认为是了解您财务需求和开展业务所必需的或与之相关的个人信息。</span>

                                <p>1. 卡得万利使用您的个人信息，目的在于能为您提供更优质的优质服务和理财产品。</p>

                                <p>2. 卡得万利将对您提供的信息严格保密，除具备下列情形之一外，不会向任何第三方披露您的相关信息：</span>
                                    乙方在使用本卡得万利银行卡用户服务前，必须仔细阅读本服务协议所有条款。一经注册使用卡得万利即视为乙方对本协议服务条款的接受和确认。</p>

                                <p>3.1 经过您事先同意而披露。</p>

                                <p>3.2 只有披露您的相关信息，才能提供您所要求的产品或服务。</p>

                                <p>3.3 应相关的法律法规要求而披露。</p>

                                <p>3.4 应政府部门、司法机构或其他代理机构的要求而披露。</p>

                                <p>3.5 应国家金融监管机构的要求而披露。</p>

                                <p>3.6 其他认为需要公开、编辑或披露相关信息的情况。</p>

                                <p>4 如果您不是具备完全民事权利能力和完全民事行为能力的自然人，您无权使用卡得万利平台服务，由此产生的损失或引起的法律纠纷，卡得万利将不承担任何责任。</p>
                            </div>
                        </div>
                    </div>


                </div>
                <!--page-content-->
            </div>
        </div>
        <!--page-->

    </div>
</div>
<%--=============协议 end===============--%>
<script>
    var myApp = new Framework7({
        modalTitle: '卡得万利商业保理',
        ajaxLinks: 'a.ajax'
    });

    $("#agree-terms-new").click(function () {
        $("#login").hide();
        $("#agreements_new").show();
    });
    $("#close-img").click(function () {
        $("#agreements_new").hide();
        $("#login").show();
    });

    //同意条款
    $("#agree-terms").change(function () {
        if ($(this).is(":checked")) {
            $("#submitBtn").removeClass("disabled");
        } else {
            $("#submitBtn").addClass("disabled");
        }
    });


    $('.aggree1').click(function () {
        $('.credit-report-pages').css('display', 'none');
        $('.popups.popup-agreement1').fadeIn();
    });

    $('.aggree2').click(function () {
        $('.credit-report-pages').css('display', 'none');
        $('.popups.popup-agreement2').fadeIn();
    });

    $('.aggree3').click(function () {
        $('.credit-report-pages').css('display', 'none');
        $('.popups.popup-agreement3').fadeIn();
    });

    $('.aggree4').click(function () {
        $('.credit-report-pages').css('display', 'none');
        $('.popups.popup-agreement4').fadeIn();
    });

    $('.aggree5').click(function () {
        $('.credit-report-pages').css('display', 'none');
        $('.popups.popup-agreement5').fadeIn();
    });

    $('.aggree6').click(function () {
        $('.credit-report-pages').css('display', 'none');
        $('.popups.popup-agreement6').fadeIn();
    });

    $('.popups').click(function () {
        $('.popups').fadeOut();
        $('.credit-report-pages').fadeIn();
    })

    /**
     * 如果符合手机号码规则，去后台调用接口判断该手机号码是否授权
     * 如果没有授权，
     */
    function checkMobile(){

        var mobile = $("#mobile").val()
        var reg = /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
        if (reg.test($("#mobile").val())) {
            $.ajax({
                type: "POST",
                url: contextPath + "/check/mobile/authorization",
                data: {mobile: $("#mobile").val()},
                success: function (result) {
                    if(result==0){
                        $("#checkMobile").show();
                        var type = document.getElementById("agree-terms").checked;
                        if(type!=true){
                            $("#submitBtn").addClass("disabled");
                        }
                    }else{
                        $("#checkMobile").hide();
                        $("#submitBtn").removeClass("disabled");
                    }
                }
            });
        }else{
            $("#checkMobile").hide();
            $("#submitBtn").removeClass("disabled");
        }
    }

    //提交
    $("#submitBtn").click(function () {


        if ($("#mobile").val() == "") {
            myApp.alert('手机号码不能为空!', '提示');
            return;
        }

        var reg = /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
        if (!reg.test($("#mobile").val())) {
            myApp.alert('手机号码不合法!', '提示');
            return;
        }

        if ($("#password").val() == "") {
            myApp.alert('密码不能为空!', '提示');
            return;
        }

        var type = document.getElementById("agree-terms").checked;
        /*if(type!=true){
            myApp.alert('请同意注册条款!', '提示');
            return;
        }*/

        //验证成功，提交FORM
        myApp.showPreloader('登录中...')
        $.ajax({
            type: "POST",
            url: contextPath + "new/m/login",
            data: {"mobile": $("#mobile").val(), "password": $("#password").val(),"type":type},
            success: function (data) {
                if (data.resultCode == "-1") {
                    myApp.hidePreloader();
                    myApp.alert(data.resultMsg,'提示');
                } else {
                    //成功,跳转主控界面
                    location.href = contextPath + "new/m/home";
                }
            }
        });

    });
</script>

</body>
</body>
</html>
