<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head></head>
<body>
<div class="views">
    <div class="view view-main">
        <div class="navbar login-title">
            <div class="navbar-inner">
                <div class="left"><a href="<c:url value='/new/m/home'/>" class="close-img"><img
                        src="<c:url value='/resources/image/left-arror.png'/>"></a></div>
                <div class="center sliding login-title-word">POS问题验证</div>
            </div>
        </div>
        <div class="pages navbar-through toolbar-through">
            <div data-page="index" class="page">
                <div class="page-content verify-page-content">

                    <c:forEach var="question" items="${questions}">
                        <div class="list-block" id="questionDiv${question.id}">
                            <ul>
                                <li class="item-content verify-title">
                                    <div class="item-inner">
                                        <div>${question.id}.${question.questionTitle}</div>
                                    </div>
                                </li>
                            </ul>
                            <ul class="verify-answer">
                                <c:forEach var="answer" items="${question.questionAnswers}">
                                    <!-- 回答错误时，<li>添加 class="disabled" -->
                                    <li class="answerLi border-bottom">
                                        <label class="label-radio item-content">
                                            <input type="radio" name="question${question.id}"
                                                   questionId="${question.id}" value="${answer}">

                                            <div class="item-inner">
                                                <div class="item-title">
                                                    <label>${answer}</label>

                                                   <%--<fmt:formatNumber value="${answer}"
                                                                                          type="currency"
                                                                                          pattern="#####.##"/>--%>
                                                </div>
                                            </div>
                                        </label>
                                    </li>
                                </c:forEach>
                            </ul>
                            <div class="padding-rl15 verify-error" style="display: none;"
                                 id="verifyError${question.id}"><span
                                    class="glyphicon glyphicon-exclamation-sign margin-r05"></span><span
                                    id="questionTip${question.id}"></span></div>
                        </div>
                    </c:forEach>
                    <div class="padding-rl15">
                        <p>温馨提示：请在验证信息前准备好小票材料，连续验证3次错误，将无法通过审核。</p>
                    </div>
                </div>

                <%--浮动操作按钮--%>
                <div class="toolbar">
                    <div class="toolbar-inner verify-btn">
                        <a class="button button-big account-button" id="submitBtn">立即验证</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    var myApp = new Framework7({
        modalTitle: '卡得万利商业保理',
        ajaxLinks: 'a.ajax'
    });

    if ("${fn:length(questions) < 1}" == "true") {
        myApp.alert('系统暂时无法生成验证问题，请稍后再试！', '提示', function () {
            myApp.showPreloader('加载中...')
            location.href = '<c:url value="/new/m/posLimit/show"/>';
        });
    }

    var questionCount = "${fn:length(questions)}";//问题总数
    $("#submitBtn").click(function () {
        //很遗憾，您回答的问题错误
        var flag = true;
        for (var i = 1; i <= parseInt(questionCount); i++) {
            var rname = "question" + i;
            if (!$("input:radio[name='" + rname + "']").is(":checked")) {
                myApp.alert('问题' + i + "还未选择答案!", '提示');
                flag = false;
                break;
            }
        }

        var selectedAmt = $('input:radio[name="question1"]:checked').val();


        var count = 3;//3秒
        if (flag == true) {

            var questionIds = ""
            var questionAnswers = "";
            //遍历所有选择的答案
            $('input:radio:checked').each(function () {
                questionIds += $(this).attr("questionId") + ",";//回答的问题
                questionAnswers += $(this).val() + ",";//选择答案
            });

            //禁用按钮
            $("#submitBtn").addClass("disabled");
            $(".answerLi").addClass("disabled");

            //提交
            $.ajax({
                type: "POST",
                url: contextPath + "new/m/verify",
                <%--data: {"questionIds": questionIds, "questionAnswers": questionAnswers, "mid": "${mid}",midVerification:${questions.verifyId}},--%>
                data: {"mid": "${mid}", midVerification:${questions[0].verifyId}, selectedAmt: selectedAmt},
                success: function (data) {
//                        resultCode 0:验证失败；1：验证成功，2:三次验证都失败
                    if (data.resultCode == "-1") {
                        //表示有错误提示
                        myApp.alert(data.resultMsg, '提示');
                    } else if (data.resultCode == "0" || data.resultCode == "0") {
                        //问题回答错误,显示错误详情
                        /* for (var i = 0; i < data.resultData.length; i++) {
                         var errorQuestionId = data.resultData[i];
                         $("#verifyError" + errorQuestionId).show();
                         $("#questionTip" + errorQuestionId).html("很遗憾，您回答的问题错误!");
                         }*/

                        myApp.alert("本次验证失败,3秒钟之后重新生成POS问题验证！", '提示');
                        //延迟三秒自动进入第二次回答问题界面
                        var countdown = setInterval(countDown, 1000);//定时器
                        function countDown() {
                            $("#submitBtn").html(count + "秒后自动进行重新验证");
                            if (count == 0) {
                                //清除计时器
                                clearInterval(countdown);
                                count = 10;
                                //刷新，重新校验
                                location.href = location.href;
                            }
                            count--;
                        }

                        //新增取消自动重新验证按钮
                        $("#submitBtn").parent().addClass("verify-toolbar-inner");
                        $("#submitBtn").parent().parent().addClass("verify-toolbar");//Toolbar高度自适应
                        $("#submitBtn").after(' <a class="button button-big margin-t10 verify-cancel"  href="<c:url value='/new/m/posLimit/show'/>">取消自动重新验证</a>');

                    } else if (data.resultCode == "2") {
                        //3次验证失败,跳转POS显示界面
                        myApp.alert(data.resultMsg, '提示', function () {
                            location.href = "<c:url value='/new/m/posLimit/show'/>"
                        });
                    } else {
                        myApp.showPreloader('POS问题验证成功，正在重新核算额度，请耐心等待...');
                        var time12;
                        var time1 = 60;
                        time12 = setInterval(function () {
                            if (time1 > 0) {
                                time1 = time1 - 3;
                                $.ajax({
                                    type: "POST",
                                    url: contextPath + "info/getCredit",
                                    data: {},
                                    success: function (result) {
                                        if(result.creditsTaskModel.creditStatus=='E' || result.creditsTaskModel.creditStatus=='N'){
                                            myApp.hidePreloader();
                                            //成功,跳转主控界面转圈授信
                                            location.href = "<c:url value='/new/m/home?step=0'/>"
                                            clearInterval(time12);
                                        }
                                    }
                                })

                            }else{
                                //60秒仍然没有返回授信结果，则
                                location.href = "<c:url value='/new/m/home?step=0'/>"
                            }
                        }, 3000);
                        time12;

                    }
                }
            });
        }
    });
</script>

</body>
</html>
