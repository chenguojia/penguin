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
        <div class="navbar login-title" style="display: ${isApp == '0' ? 'block' : 'none'}">
            <div class="navbar-inner">
                <div class="left"><a href="<c:url value='/new/m/more'/>" class="close-img"><img src="<c:url value='/resources/image/left-arror.png'/>"></a></div>
                <div class="center sliding login-title-word">案例分享</div>
            </div>
        </div>

        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page" style="background-color: #ffffff;">
                <!-- Scrollable page content-->
                <div class="page-content page-content-scroll ${isApp == '0' ? '' : 'none-navbar'}" id="page-content pull-to-refresh-content">
                    <%--<div class="caseShare_pic"><a href="#" class="caseShare-popup"><img src="<c:url value="/resources/newm/images/caseStory.jpg"/>"></a></div>--%>
                    <div class="content-block caseShare_story">
                        <span>2014年12月7日，正值“大雪”节气，卡得万利商业保理有限公司客户经理王浩接到一份特殊的快递：除一封手写的感谢信外，还有一些腊肉、火腿自制的土特产品。这份快递来自杭州主营红酒生意的黄先生，感谢信内容是这样的：“非常感谢王经理在关键时刻解我燃眉之急，谨寄上自制的家乡的一点土特产以表感谢！”</span>
                        <p><span>据黄先生讲述，红酒生意也有淡旺季区分，而年底正是红酒销售旺季。他想在年前多备点货，好在年底能满足所有客户的需要，更重要的是拿到最优惠的采购价格。可黄先生把之前的盈利和找朋友借的钱加一块，也只有十万块不到，尚有一定的资金缺口。情急之下，黄先生联系多家银行申请贷款，但均因为各种原因而被迫放弃。</span></p>
                        <p><span>正在黄先生一筹莫展的时候，经朋友介绍了解到卡得万利，并进一步得知其公司提供的是一款快速、短期、无抵押纯信用保理融资产品，专业帮助解决目前市场上许多优质的小微企业由于无抵押或抵押值不足导致无法获得银行融资的难题。抱着试一试的态度，他按朋友推荐添加了卡得万利的微信，并在线提交了融资保理申请。申请提交不到1小时，他就接到卡得万利客户经理的电话。在详细了解了黄先生店铺大体的经营情况之后，客户经理王浩当即指导黄先生填写并提交相关融资申请所需要的材料，并快速提交资料进行审核。</span></p>
                        <p><span>鉴于黄先生有稳定的POS机刷卡流水， 递交资料后的2个工作日，黄先生就拿到了30万的“雪中炭”，用黄先生的一句话来形容当时的心情：“卡得万利的融资保理让我感受到了阵阵暖意，仿佛是走进了春天里。”</span></p>
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

</script>
</body>
</html>