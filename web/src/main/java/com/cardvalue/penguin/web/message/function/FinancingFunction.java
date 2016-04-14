package com.cardvalue.penguin.web.message.function;


import com.cardvalue.penguin.dto.ApplyProcessContext;
import com.cardvalue.penguin.model.ApplyProcess;
import com.cardvalue.penguin.model.ApplyProcessInputArgumentModel;
import com.cardvalue.penguin.model.WeUser;
import com.cardvalue.penguin.repository.ApplyProcessRepository;
import com.cardvalue.penguin.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component("FinancingFunction")
public class FinancingFunction {

	@Resource
	UserService userService;
	
	@Resource
	ApplyProcessRepository applyProcessRepository;
	
	//用户申请流程唯一标示上下文map
	public static Map<String, ApplyProcessContext> applyProcessContextMap = new HashMap<String, ApplyProcessContext>();
	
	public String quickFinancing(String openId, String content){
		WeUser user = userService.findByOpenId(openId);
		String infoStr = null;
		if(user != null){
			ApplyProcess applyProcess = applyProcessRepository.findByProcessTypeAndStepNum(1, 1);
			if(applyProcess != null) {
				//设置用户与服务器交互时间
				applyProcess.setLastOptStepDate(new Date());
				//表示申请速融流程开始，给常量赋值
				this.applyProcessContextMap.put(openId, new ApplyProcessContext(applyProcess,new ApplyProcessInputArgumentModel()));
				//服务器返回提示信息给用户手机端
				return applyProcess.getResponText();
			}
		}else{
			infoStr = "对不起，您还不是注册用户或你的账户未绑定";
		}
		return infoStr;
	}
}
