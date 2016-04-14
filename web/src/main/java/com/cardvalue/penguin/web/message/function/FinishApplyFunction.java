package com.cardvalue.penguin.web.message.function;

import org.springframework.stereotype.Component;

@Component("FinishApplyFunction")
public class FinishApplyFunction {
	
	public String finishApply(String openId, String content){
		try {
			//清空申请常量
			FinancingFunction.applyProcessContextMap.remove(openId);
			return "你已退出当前申请流程！";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "系统繁忙退出申请流程失败，请稍后操作！";
	}
}
