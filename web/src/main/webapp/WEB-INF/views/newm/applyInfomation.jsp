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

    <form method="post" id="myform">
        <div class="list-block uploadfile-block-new uploadFile-home-part1" style="margin-top:108px;">
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
                        <span>申请融资金额</span>
                    </div>
                    <div class="item-inners" style="max-width: 62%; overflow-x: hidden;">
                        <div class="item-title fill-apply-font1">
                            <input class="login_input fill-apply-font1" value="" type="text"
                                   placeholder="#####">
                        </div>
                    </div>
                </li>

                <li class="item-content apply-bottom2 fill-apply-font2"
                    style="width: 100%; overflow: hidden;">
                    <div class="item-media">
                        <span>申请融资期限</span>
                    </div>
                    <div class="item-inners" style="max-width: 62%; overflow-x: hidden;">
                        <div class="item-title fill-apply-font1">
                            <input class="login_input fill-apply-font1" value="" type="text"
                                   placeholder="23周">
                        </div>
                    </div>
                </li>
                <li class="item-content apply-bottom2 fill-apply-font2"
                    style="width: 100%; overflow: hidden;">
                    <div class="item-media">
                        <span>店内照</span>
                    </div>
                    <div class="item-inners" style="max-width: 62%; overflow-x: hidden;">
                        <div class="item-title fill-apply-font1">
                            <input class="login_input fill-apply-font1" value="" type="text"
                                   placeholder="2张">
                        </div>
                    </div>
                </li>

                <li class="item-content apply-bottom2 fill-apply-font2"
                    style="width: 100%; overflow: hidden;">
                    <div class="item-media">
                        <span>门牌照</span>
                    </div>
                    <div class="item-inners" style="max-width: 62%; overflow-x: hidden;">
                        <div class="item-title fill-apply-font1">
                            <input class="login_input fill-apply-font1" value="" type="text"
                                   placeholder="3张">
                        </div>
                    </div>
                </li>
                <li class="item-content apply-bottom2 fill-apply-font2"
                    style="width: 100%; overflow: hidden;">
                    <div class="item-media">
                        <span>身份证</span>
                    </div>
                    <div class="item-inners" style="max-width: 62%; overflow-x: hidden;">
                        <div class="item-title fill-apply-font1">
                            <input class="login_input fill-apply-font1" value="" type="text"
                                   placeholder="2张">
                        </div>
                    </div>
                </li>

                <li class="item-content apply-bottom2 fill-apply-font2"
                    style="width: 100%; overflow: hidden;">
                    <div class="item-media">
                        <span>租赁合同</span>
                    </div>
                    <div class="item-inners" style="max-width: 62%; overflow-x: hidden;">
                        <div class="item-title fill-apply-font1">
                            <input class="login_input fill-apply-font1" value="" type="text"
                                   placeholder="5张">
                        </div>
                    </div>
                </li>--%>

            </ul>
        </div>

        <c:if test="${(applicationModel.isSubmitApplication==1 || applicationModel.isSubmitApplication=='1')&&  applicationModel.isAmountLocked!=1 }">
            <div class="bind-number padding-rl15 inside-page-button" style="margin-top: 15px;margin-bottom:10px;">
                <a class="button button-big fill-apply-button submitBtn7" title="1"  href="#" style="font-size: 13px; line-height: 38px;">确认提交</a>
                <a class="button button-big fill-apply-button submitBtn7" title="0" href="#" style="margin-top:10px;background-color:transparent;border:1px solid #2485D6;color:#2485D6;font-size: 13px; line-height: 38px;">返回修改</a>
            </div>
        </c:if>
    </form>

    <div class="upload-file-buttom"></div>

<script>

    $(".submitBtn7").click(function(){
        var sure = $(this).attr("title");

        $.ajax({
            type:"POST",
            url:"<c:url value="/application/confirm"/>",
            data:{sure:sure},
            success:function(data){
                if(data.code=='-1'){
                    myApp.alert(data.message,"提示");
//                    myApp.alert(data.detail);
                }else{
                    if(sure=='1'){
                        myApp.alert("您的申请已经受理，我们将尽快为您审核，如有任何疑问，请联系400-803-803","提示",function(){
                            location.href = "<c:url value="/new/m/home?step=2"/>";
                        });

                        /*myApp.confirm("您的申请已经受理，我们将尽快为您审核，如有任何疑问，请联系400-803-803","提示",function(){
                            location.href = "<c:url value="/new/m/home?step=2"/>";
                        },function(){
                            location.href = "<c:url value="/new/m/home?step=2"/>";
                        });*/
                    }else{
                        location.href = "<c:url value="/new/m/home?step=1"/>";
                    }
                }
             }
        });
    });
</script>