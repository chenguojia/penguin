<%--
  Created by IntelliJ IDEA.
  User: guojia.chen
  Date: 2016/1/22
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="apple-mobile-web-app-status-bar-style" content="black">
  <title>卡得万利商业保理</title>
  <style type="text/css">
    .modal-overlay, .preloader-indicator-overlay, .popup-overlay{background: none;}
  </style>
</head>
<body>
<!-- Views-->
<div class="views">
  <!-- Your main view, should have "view-main" class-->
  <div class="view view-main">
    <!-- Top Navbar-->
    <c:if test="${isApp==1 || isApp =='1'}">
      <div class="navbar login-title">
        <div class="navbar-inner">
          <div class="left"><a href="<c:url value="/new/m/home?step=2"/>" class="close-img"><img src="<c:url value="/resources/image/left-arror.png"/>"></a></div>
          <div class="center sliding login-title-word"><div>卡得万利服务协议</div>
          </div>
        </div>
      </div>
    </c:if>



    <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
    <div class="pages navbar-through toolbar-through">
      <!-- Page, data-page contains page name-->
      <div data-page="index" class="page">
        <!-- Scrollable page content-->
        <!--有标题时-->
        <c:if test="${isApp==1 || isApp =='1'}">
          <div class="page-content">
        </c:if>

        <!--无标题时-->
          <c:if test="${isApp==0 || isApp =='0'}">
            <div class="page-content without-title">
          </c:if>

          <div class="content-block login-new credit-report-pages">

            <div class="list-block media-list myaccount more-part2">
              <ul class="float_clear margin-t12">
                <li class=" border-bottom border-tops">
                  <a href="#" class="open-popup item-link item-content more-main" data-popup=".popup-agreement2">
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
                  <a href="#" class="open-popup item-link item-content more-main" data-popup=".popup-agreement5">
                    <div class="item-inners">
                      <div class="item-title-row">
                        <div>
                          银行卡绑定授权协议
                        </div>
                      </div>
                    </div>
                  </a>
                </li>
              </ul>
            </div>
          </div>

          <!--APP应收账款让登记协议-->
          <!--有标题时-->
            <c:if test="${isApp==1 || isApp =='1'}">
               <div class="popup popup-agreement2 own-title">
            </c:if>

          <!--无标题时-->
            <c:if test="${isApp==0 || isApp =='0'}">
                <div class="popup popup-agreement2">
            </c:if>
            <div class="agreement-back"><a class="close-popup glyphicon glyphicon-chevron-left"></a></div>
            <div class="agreements">
              <div class="content-block caseShare_story honorTit agreement-font2">
                <span class="agreement-font3">卡得万利商业保理（上海）有限公司</span>
              </div>
              <div class="content-block caseShare_story honorTit">
                <span class="agreement-font3">应收账款转让登记协议</span>
              </div>
              <div class="content-block caseShare_story agreement-font1">
                <span>本服务协议双方为卡得万利商业保理（上海）有限公司（以下简称"甲方"）与甲方用户所担任法定代表人的法人或其他组织机构（以下简称"乙方"），本服务协议具有合同效力。</span>
                <p>乙方自愿将其自有的应收账款转让给甲方，根据有关法律、法规的规定，现甲方和乙方协商一致，特订立本协议，并愿遵守协议所有条款。</p>
                <p>第一条  甲方和乙方确认签订《商业保理协议书》和《商业保理确认书》，并将乙方相关的应收账款转让给甲方。</p>
                <p>第二条  为确保应收账款转让的有效性，甲方和乙方同意由甲方负责办理应收账款转让登记手续，乙方应给予配合。</p>
                <p>第三条  乙方（乙方为单位时）已经告知甲方自转让登记起过去六个月之内所有有效的乙方名称，或乙方（乙方为个人时）已经告知甲方所有有效及曾经有效的身份证件号码。</p>
                <p>第四条  办理转让登记手续时，甲方可自行确定登记期限。登记期限届满前，《商业保理协议书》和《商业保理确认书》项下债务未履行完毕的，甲方有权自行向中国人民银行征信中心申请展期，不需另行征得乙方的同意或授权。</p>
                <p>第五条  乙方法定注册名称（乙方为单位时）或有效身份证件号码（乙方为个人时）变更的，应在变更后5个工作日内书面通知甲方，并由甲方办理变更登记手续。因乙方未履行或未及时履行通知义务导致甲方未能在规定时间内办理变更登记手续的，构成商业保理主体合同项下的违约，甲方有权采取《商业保理协议书》和《商业保理确认书》中约定的违约救济措施，乙方应对由此给甲方造成的一切损失承担赔偿责任。</p>
                <p>第六条  乙方保证未经甲方书面同意，不得将上述应收账款再转让或质押给他人，否则，乙方应对由此给甲方造成的一切损失承担赔偿责任。</p>
                <p>第七条　办理应收账款登记所需的费用由乙方承担。</p>
                <p>第八条  本协议未尽事宜以《商业保理协议书》和《商业保理确认书》的约定为准。</p>
              </div>
            </div>
          </div>


          <!--银行卡绑定授权协议-->
          <!--有标题时-->
            <c:if test="${isApp==1 || isApp =='1'}">
              <div class="popup popup-agreement5 own-title">
            </c:if>
          <!--无标题时-->
            <c:if test="${isApp==0 || isApp =='0'}">
              <div class="popup popup-agreement5">
            </c:if>

            <div class="agreement-back"><a class="close-popup glyphicon glyphicon-chevron-left"></a></div>
            <div class="agreements">
              <div class="content-block caseShare_story honorTit agreement-font2">
                <span class="agreement-font3">卡得万利商业保理（上海）有限公司</span>
              </div>
              <div class="content-block caseShare_story honorTit agreement-font2">
                <span class="agreement-font3">卡得万利银行卡用户服务协议</span>
              </div>
              <div class="content-block caseShare_story agreement-font1">
                <span>卡得万利银行卡用户服务协议双方为卡得万利商业保理（上海）有限公司（以下简称"甲方"）与甲方用户所担任法定代表人的法人或其他组织机构（以下简称"乙方"）。卡得万利银行卡用户服务，是指由甲方基于甲方客户端向乙方提供的银行卡认证、提现、代收和代付服务。如乙方点击选择同意此协议将视为同意甲方通过乙方所授权的银行卡为乙方提供认证、提现、代付和代收服务，并将视为己阅读并理解本协议的全部内容。本协议会对与乙方的权益具有或可能具有重大关系的条款，以及对甲方具有或可能具有免责或限制责任的条款均用粗体字标注，请乙方注意。如果乙方不同意本协议的任意内容，或者无法准确理解甲方对条款的解释，请不要进行后续操作。</span>
                <p>一、声明与承诺</p>
                <p>（一）卡得万利银行卡用户服务是由甲方基于卡得万利客户端向乙方提供的银行卡认证、提现、代收和代付服务，为了保障乙方的权益，<span class="agreement-font3">乙方应保证自己在注册使用卡得万利时为具有完全民事行为能力的自然人。</span>乙方在使用本卡得万利银行卡用户服务前，必须仔细阅读本服务协议所有条款。一经注册使用卡得万利即视为乙方对本协议服务条款的接受和确认。</p>
                <p>（二）乙方同意，甲方可对本协议内容进行单方变更或修改，并以公告的方式予以公布，不另作个别通知，乙方可以通过卡得万利客户端／公司网站等途径查阅；若乙方在本协议内容公告变更后继续使用本服务的，表示乙方已充分阅读、理解并接受修改后的协议内容，也将遵循修改后的协议内容使用本服务；若乙方不同意修改后的协议内容，乙方应停止使用本服务。</p>
                <p>（三）乙方保证，在乙方同意接受本协议时，乙方所提供的银行卡账户为乙方本人名下账户。不具备前述条件的，乙方应及时修改所提交的银行卡信息或停止使用本服务。</p>
                <p>（四）乙方同意，乙方在使用卡得万利银行卡过程中的所有行为，乙方不可撤销的授权由甲方按照《卡得万利银行卡用户服务协议》进行处理；同时甲方有权为提供前述服务的需要获取乙方的相关信息（包括但不限于个人信息、行为信息、账户相关信息等）。甲方按照乙方的操作指令或《卡得万利银行卡用户服务协议》的相关约定进行资金的冻结、扣划完全来自于乙方的授权，因此造成的任何损失甲方不承担任何责任。但乙方确认，乙方使用卡得万利服务时，乙方仍应完全遵守本《卡得万利银行卡用户服务协议》及甲方制定的各项规则及页面提示等。</p>
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
                <p>3、如乙方满足上述相应要求，则甲方将通过乙方所绑定或授权的银行卡为乙方提供卡得万利银行卡服务，其包括但不限于银行卡认证、提现、代付与代收服务等，具体详情以甲方当时提供的服务内容为准。</p>
                <p>(1) 银行卡认证服务：银行卡认证服务是指甲方为乙方提供的通过查询、核实、获取乙方的个人公开信息和乙方所授权的银行卡等的账户信息及交易信息来绑定乙方的银行卡账户，授予乙方信用额度的服务。</p>
                <p>(2) 提现／代付服务：在符合甲方规定或产品规则的情况下，乙方可以请求甲方在乙方卡得万利账户中的信用额度范围内提供投资人撮合服务，并提取到乙方名下绑定的有效中国大陆银行账户内或支付到甲方合作商家的银行账户内，以满足乙方的资金需求。</p>
                <p>(3) 代收服务：如乙方在卡得万利上使用了提现／代付服务，依据《借款与还款协议》及《卡得万利服务与隐私协议》，甲方将在账单到期后通过乙方所绑定的银行账户为乙方提供代收还款服务。</p>
                <p>（二）授权条款</p>
                <p>1、乙方理解并同意，在乙方提交或绑定银行卡信息或账户后，甲方在为乙方提供卡得万利服务时有权查询并核对乙方所提交的银行卡账户信息。</p>
                <p>2、乙方理解并同意，在乙方使用卡得万利银行卡认证服务后，即不可撤销地授权甲方向第三方查询乙方的银行卡交易数据报告，用于评估信用状况，查询期限为申请贷款之日至所有贷款及相关款项全部结清之日或至申请贷款拒绝之日。</p>
                <p>3、乙方理解并同意，在乙方授权或绑定银行卡账户后对乙方所授权或绑定的银行卡账户进行打款或扣款。</p>
                <p>三、保密条款</p>
                <p>甲方重视对用户隐私的保护。因收集乙方的信息是出于遵守国家法律法规的规定以及向乙方提供服务及提升服务质量的目的，甲方对乙方的信息承担保密义务，不会为满足第三方的营销目的而向其出售或出租乙方的任何信息，甲方会在下列青况下才将乙方的信息与第三方共享：</p>
                <p>1、获得乙方的同意或授权。</p>
                <p>2、为了向乙方提供或推荐服务、产品，或为了向乙方提供更完善的服务，或者为了让乙方拥有更广泛的社交体验，甲方会与包括卡得万利关联公司、旗下公司及合作商户在内的第三方共享乙方的相关信息。</p>
                <p>3、某些情况下，只有共享乙方的信息，才能提供乙方需要的服务和（或）产品，或处理乙方与他人的交易纠纷或争议。</p>
                <p>4、为了判断乙方的卡得万利账户或交易是否安全。</p>
                <p>5、某些服务和（或）产品由甲方的合作伙伴提供或由甲方与合作伙伴、供应商共同提供，甲方会与其共享提供服务和（或）产品需要的信息。</p>
                <p>6、甲方与第三方进行联合推广活动，甲方可能与其共享活动过程中产生的、为完成活动所必要的个人信息。</p>
                <p>7、为维护甲方及甲方关联公司、旗下公司和其他甲方用户的合法权益。</p>
                <p>8、根据法律规定及合理商业习惯，在甲方计划与其他公司合并或被其收购或进行其他资本市场活动（包括但不限于IPO，债券发行）时，以及其他情形下甲方需要接受来自其他主体的尽职调查时，甲方会把乙方的信息提供给必要的主体，但甲方会通过和这些主体签署保密协议等方式要求其对乙方的个人信息采取合理的保密措施。</p>
                <p>9、为了便于乙方与乙方的好友进行更加灵活、安全的资金往来，避免因手动输入卡得万利登录名错误而产生损失，当乙方的卡得万利账户所关联的手机号码被保存在他人手机通讯录中时，乙方的卡得万利登录名、姓名等可以被通讯录存有该手机号码的好友查询到。本协议中所称的“卡得万利账户关联的手机号码”，是指作为卡得万利登录名的手机号码或卡得万利账户绑定的手机号码。</p>
                <p>10、同本部分第9项之目的，他人可以通过乙方的卡得万利账户关联手机号码查询到对应的卡得万利登录名、相应的姓名。</p>
                <p>11、乙方与他人通过卡得万利服务发生资金往来的，交易相对方可在付款过程中，或付款成功后可查看到乙方使用的卡得万利账户的部分信息（包括卡得万利登录名、卡得万利账户对应的姓名或昵称、卡得万利账户头像等，具体以实际可查看信息为准）。</p>
                <p>12、如乙方授权第三方向甲方查询、采集乙方卡得万利账户相关信息，甲方有权在法律法规和乙方的授权许可范围内向第三方分享乙方卡得万利账户的部分信息</p>
                <p>13、为了维护和改善甲方的服务。</p>
                <p>14、根据法律法规的规定或有权机关的要求。</p>
                <p>四、用户义务及免责声明</p>
                <p>（一）乙方保证，乙方所授权的银行卡账户为乙方本人的真实账户，不可为他人的银行卡账户。</p>
                <p>（二）如乙方所授权的银行卡账户为他人或虚假账户，甲方将有权暂停或终止与乙方的全部或部分服务协议，此行为所产生的全部法律责任将由乙方承担，甲方将不对此承担法律责任。</p>
              </div>
            </div>
          </div>

        </div> <!--page-content-->
      </div>
    </div><!--page-->

  </div>
</div>
<script type="text/javascript">
  $('.popup').click(function(){
    $('.popup').fadeOut();
  })
</script>

</body>
</html>