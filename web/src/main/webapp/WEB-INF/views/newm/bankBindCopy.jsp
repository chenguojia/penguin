<%--
  Created by IntelliJ IDEA.
  User: guojia.chen
  Date: 2016/1/8
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div id="basicLimit" style="height: 100%;">
  <!-- Your main view, should have "view-main" class-->
  <div class="view view-main  basic-limit-z">

    <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
    <div class="pages navbar-through toolbar-through">
      <!-- Page, data-page contains page name-->
      <div data-page="index" class="page">
        <!-- Scrollable page content-->
        <div class="page-content home-inside-pages">
          <form  method="post" id="myform">
            <div class="list-block uploadfile-block-new uploadFile-home-part1 bank-bind-part1">
              <div class="padding-b5" style="font-size: 13px; padding-left:15px;">放款账户信息(对公)</div>
              <ul class="float_clear">
                <li class="border-bottom">
                  <a href="# " class="item-link item-content more-main">
                    <div class="item-media username_icon">
                      <span>开户名称</span>
                    </div>
                    <div class="item-inners" style="max-width: 62%; overflow-x: hidden;">
                      <div class="item-title-rows">
                        <div class="fill-apply-font1 fill-apply-tables-2">
                          <input type="text" class="login_input fill-apply-font1" value="" placeholder="请输入开户名称"></input>
                        </div>
                      </div>
                    </div>
                  </a>
                </li>

                <li class="border-bottom">
                  <a href="# " class="item-link item-content more-main">
                    <div class="item-media username_icon">
                      <span>开户银行</span>
                    </div>
                    <div class="item-inners" style="max-width: 62%; overflow-x: hidden;">
                      <div class="item-title-rows">
                        <div class="fill-apply-font1 fill-apply-tables-2">
                          <input type="text" class="login_input fill-apply-font1" value="" placeholder="请输入开户银行"></input>
                        </div>
                      </div>
                    </div>
                  </a>
                </li>
                <li class="border-bottom">
                  <a href="# " class="item-link item-content more-main">
                    <div class="item-media username_icon">
                      <span>银行账号</span>
                    </div>
                    <div class="item-inners" style="max-width: 62%; overflow-x: hidden;">
                      <div class="item-title-rows">
                        <div class="fill-apply-font1 fill-apply-tables-2">
                          <input type="text" class="login_input fill-apply-font1" value="" placeholder="请输入银行账号"></input>
                        </div>
                      </div>
                    </div>
                  </a>
                </li>
              </ul>
            </div>

            <div class="list-block media-list myaccount more-part2 home-inside-page-more-part2 bank-min-height">
              <div class="padding-b5" style="padding-left:15px;">还款账户信息(个人)</div>

              <ul>
                <li class="item-content apply-bottom2 fill-apply-font2" style="width: 100%; overflow: hidden;">
                  <div class="item-media">
                    <span>账户名</span>
                  </div>
                  <div class="item-inners" style="max-width: 62%; overflow-x: hidden;">
                    <div class="item-title fill-apply-font1">
                      <input class="login_input fill-apply-font1" id = "loanAmount" value="" name="loanAmount" type="text" placeholder="请输入账户名">
                    </div>
                  </div>
                </li>

                <li class="item-content apply-bottom2 fill-apply-font2" style="width: 100%; overflow: hidden;">
                  <div class="item-media">
                    <span>身份证</span>
                  </div>
                  <div class="item-inners" style="max-width: 62%; overflow-x: hidden;">
                    <div class="item-title fill-apply-font1">
                      <input class="login_input fill-apply-font1" id = "loanAmount" value="" name="loanAmount" type="text" placeholder="请输入身份证号码">
                    </div>
                  </div>
                </li>

                <li class="item-content apply-bottom2 fill-apply-font2" style="width: 100%; overflow: hidden;">
                  <div class="item-media">
                    <span>开户银行</span>
                  </div>
                  <div class="item-inners" style="max-width: 62%; overflow-x: hidden;">
                    <div class="item-title fill-apply-font1">
                      <input class="login_input fill-apply-font1" id = "loanAmount" value="" name="loanAmount" type="text" placeholder="请输入开户银行名称">
                    </div>
                  </div>
                </li>
                <li class="item-content apply-bottom2 fill-apply-font2" style="width: 100%; overflow: hidden;">
                  <div class="item-media">
                    <span>银行账号</span>
                  </div>
                  <div class="item-inners" style="max-width: 62%; overflow-x: hidden;">
                    <div class="item-title fill-apply-font1">
                      <input class="login_input fill-apply-font1" id = "loanAmount" value="" name="loanAmount" type="text" placeholder="请输入银行账号">
                    </div>
                  </div>
                </li>

                <li class="item-content apply-bottom2 fill-apply-font2" style="width: 100%; overflow: hidden;">
                  <div class="item-media">
                    <span>银行预留手机号</span>
                  </div>
                    <div class="item-inners">
                      <div class="item-title">
                        <input class="login_input" type="text" maxlength="4" id="checkCode"
                               placeholder="请输入银行预留手机号">
                        <button class="get_verti-new button button-round" type="button"
                                id="getCheckCodeBtn">获取验证码
                        </button>
                      </div>
                    </div>
                </li>
                <li class="item-content apply-bottom2 fill-apply-font2" style="width: 100%; overflow: hidden;">
                  <div class="item-media">
                    <span>输入验证码</span>
                  </div>
                  <div class="item-inners" style="max-width: 62%; overflow-x: hidden;">
                    <div class="item-title fill-apply-font1">
                      <input class="login_input fill-apply-font1" id = "loanAmount" value="" name="loanAmount" type="text" placeholder="请输入输入验证码">
                    </div>
                  </div>
                </li>

              </ul>

            </div>

            <div class="uploadfiles-part2"></div>
            <%--兼容安卓选择门店数键盘遮挡问题--%>
            <div class="bind-number padding-rl15 inside-page-button">
              <a class="button button-big button-fill apply-button" href="#" id="submitBtn">绑定</a>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
