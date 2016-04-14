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
                <div class="left"><a href="<c:url value='#'/>" class="close-img"><img src="<c:url value='/resources/image/left-arror.png'/>"></a></div>
                <div class="center sliding login-title-word">新闻中心</div>
            </div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page" style="background-color: #ffffff;">
                <!-- Scrollable page content-->
                <div class="page-content ${isApp == '0' ? '' : 'none-navbar'}">
                    <div class="caseShare_pic aboutUs_titPic"><a href="#" class="caseShare-popup"><img src="<c:url value="/resources/image/welcome.jpg"/>" width="100%"></a></div>
                    <div class="content-block caseShare_story honorTit">
                        <span>用好保理融资循环预支，小微企业不差钱</span>
                    </div>
                    <div class="content-block caseShare_story">
                        <span>小微企业在经营过程中，都会频繁遇到资金紧缺，无论是补充流动资金不足，销售旺季到来前的提前备货，新开店面预付租金或装修，还是店面改造或添置贵重设备，要提高收益要发展壮大，资金缺口问题随时都会“扑面而来”，这就是小微融资的“短、频、急”问题。因此，小微企业融资，宜细水长流，找到“门当户对”的活水源头，让资金供给处于良性循环中。</span>
                        <p><span>卡得万利商业保理有限公司(以下简称卡得万利)，以独创的保理融资的新金融模式，为小微商贸企业提供融资服务，在解决其融资需求“短、频、急”的问题上，有独到之处，小微企业若能用好用活，将立刻脱离融资“难、贵、慢”状态，从此不差钱。</span></p>
                        <p><span>安装有POS机收银的中小微商贸企业，将一段时间或一定数额的POS结算应收账款转让给卡得万利，卡得万利为其预先支付现金，就完成了明日账款提前变现，实现融资。卡得万利保理融资采用纯信用授信，不需要房产等固定资产做抵押，通过现代信息技术和大数据技术的应用，中小微商贸企业只需提供过去连续6个月以上经营店铺POS交易数据，经过演算分析，卡得万利藉此评估其过往的经营状况，预估未来的经营收入和可转让应收账款，进行信用授信。</span></p>
                        <p><span>中小微商贸企业获得的预授信额度可以循环使用，在不超过授信额度范围内用款时，只需填写商业保理申请书，而不用重新提交资料审批，24小时内，续约预支的现金便可到账。可以看出，中小微商贸企业申请卡得万利融资保理成功获得预授信额度后，就如同有了自己的流动“金库”，安全、方便、快捷。</span></p>
                        <p><span>保理融资的循环预支功能，给中小微商贸企业带来了诸多便利：用款快捷，一次审批，有效期内随借随还，最高额度内单笔预支现金，经有权审批人直接审批，快捷方便;因为循环使用，可实现短期预支借款，长期使用，节省了融资费用和资金占用成本，长期借款，则享受一次性保理融资手续费优惠;企业主更好的掌握了融资的主动权和控制权，便于提前规划经营策略，抓住商机，既能保证资金需求，又不会使资金闲置，增加成本。迄今为止，卡得万利已经为上万家小微商户提供了保理融资服务，大约五成的商户使用了循环预支，而反过来，使用循环预支的商户，经营业绩稳步增长，也就是说，循环预支与收益稳增形成了又一个良性循环。</span></p>
                        <p><span>卡得万利融资保理目前提供三种产品供中小微商贸企业选择使用：经营宝，最高预支额度50万，融资周期3~6个月;周周宝，最高预支额度20万，融资周期3~6个月;此外，对于准备安装POS机，或者装机在两个月以内的新开业商户，还有开业宝，额度4万，融资周期3个月，也是卡得万利特别给创业者的一份礼物。 </span></p>
                    </div>
                </div>
            </div>
        </div>
        <div class="toolbar tabbar tabbar-labels">
            <div class="toolbar-inner">
                <a href="myshop.html" class="tab-link">
                    <i class="icon money-icon"><span class="badge bg-red">1</span></i>
                    <span class="tabbar-label">融资</span>
                </a>
                <a href="myaccount.html" class="tab-link">
                    <i class="icon account-icon">
                    </i>
                    <span class="tabbar-label">账户</span>
                </a>
                <a href="more_new.html" class="tab-link active">
                    <i class="icon more-icon"></i>
                    <span class="tabbar-label">更多</span>
                </a>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var myApp = new Framework7({
        modalTitle: '卡得万利商业保理',
        ajaxLinks: 'a.ajax'
    });

</script>
</body>
</html>