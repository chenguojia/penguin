<%--
  Created by IntelliJ IDEA.
  User: guojia.chen
  Date: 2016/1/12
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form method="post" id="myform">
  <div class="list-block uploadfile-block-new uploadFile-home-part1">
    <ul>

      <c:forEach var="item" items="${plan.items}" varStatus="i">
        <li class="item-content apply-bottom2 fill-apply-font2"
            style="width: 100%; overflow: hidden;">
          <div class="item-media" style="max-width: 150px; overflow: hidden;">
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

    </ul>
  </div>



    <div class="upload-home-font3" style="color:#949090;margin-bottom:16px;">
      为确保您的良好还款记录，请在每个还款日前一晚检查还款账户有足够款项，谢谢!
    </div>
    <c:if test="${applicationModel.cashadvanceStatus == '还款清算'}">
      <div class="bind-number padding-rl15 inside-page-button">
        <%--<a class="button button-big fill-apply-button" title="0"href="<c:url value="/new/m/refundDetail?baoliId=${applicationModel.cashadvanceId}"/>" id="submitBtn11" style="margin-top:10px;margin-bottom:15px;background-color:transparent;border:1px solid #2485D6;color:#2485D6;font-size: 13px; line-height: 38px;">查看对账单</a>--%>
          <a class="button button-big fill-apply-button" title="0"href="<c:url value="/new/m/getDetail?applicationId=${newMerchantUserModel.applicationId}"/>" id="submitBtn11" style="margin-top:10px;margin-bottom:15px;background-color:transparent;border:1px solid #2485D6;color:#2485D6;font-size: 13px; line-height: 38px;">查看对账单</a>
      </div>
    </c:if>

</form>

