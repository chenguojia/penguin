package com.cardvalue.penguin.model;

import com.cardvalue.penguin.util.Constants;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by guojia.chen on 2015-12-31 13:24.
 *
 * @Description:
 */
public class VerifyQuestionModel {
    private Integer id;//问题id
    private String questionTitle;//问题标题
    private List questionAnswers;//问题答案列表
    private Double questionRightAnswers;//问题正确答案
    private String verifyId;//问题id

    public String getVerifyId() {
        return verifyId;
    }

    public void setVerifyId(String verifyId) {
        this.verifyId = verifyId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public List getQuestionAnswers() {
        return questionAnswers;
    }

    public void setQuestionAnswers(List questionAnswers) {
        this.questionAnswers = questionAnswers;
    }

    public Double getQuestionRightAnswers() {
        return questionRightAnswers;
    }

    public void setQuestionRightAnswers(Double questionRightAnswers) {
        this.questionRightAnswers = questionRightAnswers;
    }

    public VerifyQuestionModel() {
    }

    public VerifyQuestionModel(Integer id, String questionTitle, List questionAnswers, Double questionRightAnswers) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.questionAnswers = questionAnswers;
        this.questionRightAnswers = questionRightAnswers;
    }

    public VerifyQuestionModel(Integer id, String questionTitle, Double questionRightAnswers) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.questionRightAnswers = questionRightAnswers;

        //随机生成答案列表
        List questionAnswers = new ArrayList();
        String temp = new DecimalFormat("#.####").format(questionRightAnswers);
        Double tp  = Double.parseDouble(temp);
        questionAnswers.add(tp);//添加正确答案
        for (int i = 0; i < Constants.VERIFY_QUESTION_ANSWER_COUNT - 1; i++) { //之前已经存在一个标准答案，所以此处-1
            Double answer =questionRightAnswers + Double.valueOf(Math.floor(new Random().nextDouble() * 500));//产生一个[0,499]的double数值
            while (questionAnswers.contains(answer)) {
                //如果存在相同的答案，随机重新再产生
                answer = questionRightAnswers + Double.valueOf(Math.floor(new Random().nextDouble() * 500));
            }
            questionAnswers.add(answer);//添加随机答案
        }
        Collections.shuffle(questionAnswers);//问题随机顺序

        this.questionAnswers = questionAnswers;
    }
}
