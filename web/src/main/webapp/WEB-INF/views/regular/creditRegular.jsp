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
          <div class="left"><a href="<c:url value="/new/m/creditReport/show"/>" class="close-img"><img src="<c:url value="/resources/image/left-arror.png"/>"></a></div>
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
          < class="page-content">
        </c:if>
        <!--无标题时-->
        <c:if test="${isApp==0 || isApp =='0'}">
          <div class="page-content without-title">
        </c:if>


          <!--APP征信报告授权协议-->
          <!--有标题时-->
          <c:if test="${isApp==1 || isApp =='1'}">
              <div class="popup-agreement3 own-title">
          </c:if>
          <!--无标题时-->
          <c:if test="${isApp==0 || isApp =='0'}">
            <div class="popup-agreement3">
          </c:if>

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
                <p><span class="agreement-font3">（一）乙方确认，在乙方授权甲方验证并获取乙方的征信报告信息前，乙方已充分阅读、理解并接受本协议的全部内容，一旦乙方使用本服务，即表示乙方同意遵循本协议之所有约定。</span></p>
                <p><span class="agreement-font3">（二）乙方同意，乙方是自行在“中国人民银行征信中心”（以下简称“征信中心”）的“个人信用信息服务平台”网站上查询并获得自己的报告后提交给甲方，如需帮助，甲方可帮助乙方完成这个过程（即甲方依据乙方提供的“身份验证码”获取乙方授权的征信报告提交给卡得万利进行信用评估）。乙方将授权甲方查看乙方的征信报告信息包括但不限于央行征信报告中的所有信息，含个人信息、其所持银行卡基本信息、所持银行卡使用情况信息（交易、消费、借贷、还款、逾期等）。</span></p>
                <p><span class="agreement-font3">（三）乙方承诺，乙方已认真阅读并理解了央行征信中心网站上公告的内容，包括但不限于互联网个人信用信息服务平台介绍、征信中心温馨提示、征信中心系统公告等，具体内容详见附件。</span></p>
                <p><span class="agreement-font3">二、保密条款</span></p>
                <p><span class="agreement-font3">本公司重视对用户隐私的保护。因收集乙方的信息是出于遵守国家法律法规的规定以及向乙方提供服务及提升服务质量的目的，甲方对乙方的信用卡账单信息承担保密义务，不会为满足第三方的营销目的而向其出售或出租乙方的任何信息，甲方会在下列情况下才将乙方的征信报告信息与第三方共享：</span></p>
                <p><span class="agreement-font3">1、获得乙方的同意或授权。</span></p>
                <p><span class="agreement-font3">2、为了向乙方提供或推荐服务、产品，或为了向乙方提供更完善的服务，或者为了让乙方拥有更广泛的社交体验，甲方会与包括甲方关联公司、旗下公司及合作商户在内的第三方共享乙方的相关信息。</span></p>
                <p><span class="agreement-font3">3、某些情况下，只有共享乙方的信息，才能提供乙方需要的服务和（或）产品，或处理乙方与他人的交易纠纷或争议。</span></p>
                <p><span class="agreement-font3">4、为了判断乙方的卡得万利账户或交易是否安全。</span></p>
                <p><span class="agreement-font3">5、某些服务和（或）产品由甲方的合作伙伴提供或由甲方与合作伙伴、供应商共同提供，甲方会与其共享提供服务和（或）产品需要的信息。</span></p>
                <p><span class="agreement-font3">6、甲方与第三方进行联合推广活动，甲方可能与其共享活动过程中产生的、为完成活动所必要的个人信息。</span></p>
                <p><span class="agreement-font3">7、为维护甲方及甲方关联公司、旗下公司和其他甲方用户的合法权益。</span></p>
                <p><span class="agreement-font3">8、根据法律规定及合理商业习惯，在甲方计划与其他公司合并或被其收购或进行其他资本市场活动（包括但不限于IPO，债券发行）时，以及其他情形下甲方需要接受来自其他主体的尽职调查时，甲方会把乙方的信息提供给必要的主体，但甲方会通过和这些主体签署保密协议等方式要求其对乙方的个人信息采取合理的保密措施。</span></p>
                <p><span class="agreement-font3">9、为了便于乙方与乙方的好友进行更加灵活、安全的资金往来，避免因手动输入卡得万利登录名错误而产生损失，当乙方的卡得万利账户所关联的手机号码被保存在他人手机通讯录中时，乙方的卡得万利登录名、姓名等可以被通讯录存有该手机号码的好友查询到。本协议中所称的“卡得万利账户关联的手机号码”，是指作为卡得万利登录名的手机号码或卡得万利账户绑定的手机号码。</span></p>
                <p><span class="agreement-font3">10、同本部分第9项之目的，他人可以通过乙方的卡得万利账户关联手机号码查询到对应的卡得万利登录名，对应姓名。</span></p>
                <p><span class="agreement-font3">11、乙方与他人通过卡得万利服务发生资金往来的，交易相对方可在付款过程中，或付款成功后可查看到乙方使用的卡得万利账户的部分信息（包括卡得万利登录名、卡得万利账户对应的姓名或昵称、卡得万利账户头像等，具体以实际可查看信息为准）。</span></p>
                <p><span class="agreement-font3">12、如乙方授权第三方向甲方查询、采集乙方卡得万利账户相关信息，甲方有权在法律法规和乙方的授权许可范围内向第三方分享乙方卡得万利账户的部分信息。</span></p>
                <p><span class="agreement-font3">13、为了维护和改善甲方的服务。</span></p>
                <p><span class="agreement-font3">14、根据法律法规的规定或有权机关的要求。</span></p>
                <p><span class="agreement-font3">15、乙方理解并同意，甲方可以储存乙方授权的原始信息；在乙方和甲方的合作存续期间，甲方随时可以从新采集和更新数据，对于经过加工和脱敏处理的数据，甲方可以永久保存在服务器上。</span></p>
                <p>三、用户义务及免责声明</p>
                <p>（一）乙方保证，征信报告信息的授权为乙方本人操作并为本人身份信息，不可用他人的身份信息。</p>
                <p>（二）如乙方借他人之名授权，甲方将有权暂停或终止与乙方的全部或部分服务协议，并将由乙方承担由此行为所产生的全部法律责任，甲方将不对此承担法律责任。</p>
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