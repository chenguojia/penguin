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
<%--<div id="basicLimit" style="height: 100%;">--%>
    <!-- Your main view, should have "view-main" class-->
    <%--<div class="view view-main basic-limit-z">--%>

        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <%--<div class="pages navbar-through toolbar-through">--%>
            <!-- Page, data-page contains page name-->
            <%--<div data-page="index" class="page">--%>
                <!-- Scrollable page content-->
                <%--<div class="page-content home-inside-pages">--%>
                    <form method="post" id="myform">
                        <div class="list-block uploadfile-block-new uploadFile-home-part1">
                            <ul>
                                <c:forEach var="item" items="${plan.items}" varStatus="i">
                                    <li class="item-content apply-bottom2 fill-apply-font2"
                                        style="width: 100%; overflow: hidden;">
                                        <div class="item-media">
                                            <span>${item.title}</span>
                                        </div>
                                        <div class="item-inners" style="max-width: 62%; overflow-x: hidden;">
                                            <div class="item-title fill-apply-font1">
                                                <div class="basic-limit-part4"></div>
                                                <input class="login_input fill-apply-font1" value="${item.value}"
                                                       name="loanAmount" type="text" readonly>
                                            </div>
                                        </div>
                                    </li>
                                </c:forEach>

                                <%--<li class="item-content apply-bottom2 fill-apply-font2"
                                    style="width: 100%; overflow: hidden;">
                                    <div class="item-media">
                                        <span>融资期限</span>
                                    </div>
                                    <div class="item-inners" style="max-width: 62%; overflow-x: hidden;">
                                        <div class="item-title fill-apply-font1">
                                            <input class="login_input fill-apply-font1" id="loanAmount" value=""
                                                   name="loanAmount" type="text" placeholder="周">
                                        </div>
                                    </div>
                                </li>

                                <li class="item-content apply-bottom2 fill-apply-font2"
                                    style="width: 100%; overflow: hidden;">
                                    <div class="item-media">
                                        <span>还款方式</span>
                                    </div>
                                    <div class="item-inners" style="max-width: 62%; overflow-x: hidden;">
                                        <div class="item-title fill-apply-font1">
                                            <input class="login_input fill-apply-font1" id="loanAmount" value=""
                                                   name="loanAmount" type="text" placeholder="从还款账户扣除\关联pos机账户还款">
                                        </div>
                                    </div>
                                </li>
                                <li class="item-content apply-bottom2 fill-apply-font2"
                                    style="width: 100%; overflow: hidden;">
                                    <div class="item-media">
                                        <span>还款频率</span>
                                    </div>
                                    <div class="item-inners" style="max-width: 62%; overflow-x: hidden;">
                                        <div class="item-title fill-apply-font1">
                                            <input class="login_input fill-apply-font1" id="loanAmount" value=""
                                                   name="loanAmount" type="text" placeholder="每周还款/每日还款">
                                        </div>
                                    </div>
                                </li>

                                <li class="item-content apply-bottom2 fill-apply-font2"
                                    style="width: 100%; overflow: hidden;">
                                    <div class="item-media">
                                        <span>管理服务费率</span>
                                    </div>
                                    <div class="item-inners" style="max-width: 62%; overflow-x: hidden;">
                                        <div class="item-title fill-apply-font1">
                                            <input class="login_input fill-apply-font1" id="loanAmount" value=""
                                                   name="loanAmount" type="text" placeholder="%">
                                        </div>
                                    </div>
                                </li>
                                <li class="item-content apply-bottom2 fill-apply-font2"
                                    style="width: 100%; overflow: hidden;">
                                    <div class="item-media">
                                        <span>保理手续费率</span>
                                    </div>
                                    <div class="item-inners" style="max-width: 62%; overflow-x: hidden;">
                                        <div class="item-title fill-apply-font1">
                                            <input class="login_input fill-apply-font1" id="loanAmount" value=""
                                                   name="loanAmount" type="text" placeholder="%">
                                        </div>
                                    </div>
                                </li>--%>

                            </ul>
                        </div>

                        <%--兼容安卓选择门店数键盘遮挡问题--%>
                        <div class="bind-number padding-rl15 inside-page-button" style="margin-top:15px;">
                            <a class="button button-big button-fill apply-button" href="#" id="submitBtn10">提现确认</a>
                        </div>
                    </form>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>

<script>
    $(function(){
        $("#submitBtn10").click(function(){
            myApp.showPreloader('提交中...')
            $.ajax({
                type:"POST",
                url:'<c:url value="/check/getMoneyConfrim"/>',
                data:{},
                success:function(res){
                    if(res.resultCode==-1){
                        myApp.alert(res.resultMsg,"提现")
                    }else{
                        location.href="<c:url value="/new/m/home?step=2"/>";
                    }
                }
            });
        });
    });
</script>