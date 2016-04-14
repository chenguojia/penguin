package com.cardvalue.penguin.web.message.function;


import com.cardvalue.penguin.dto.MerchantCredit;
import com.cardvalue.penguin.model.Merchant;
import com.cardvalue.penguin.model.WeUser;
import com.cardvalue.penguin.repository.MerchantCreditRepository;
import com.cardvalue.penguin.repository.MerchantRepository;
import com.cardvalue.penguin.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("CreditLineFunction")
public class CreditLineFunction {
	@Resource
	private UserService userService;
	
	@Resource
	private MerchantCreditRepository merchantCreditRepository;
	
	@Resource
	private MerchantRepository merchantRepository;
	
	public String queryCreditLineByMid(String openId, String mid){
		WeUser user = userService.findByOpenId(openId);
		String infoStr = null;
		if(user != null){
			//获取商户信用对象
			MerchantCredit merchantCredit = null;
			
			//判断用户类型
			if(user.getType() == 0 || user.getType() == 1 || user.getType() == 2 || user.getType() == 6 || user.getType() == 7){
				//当用户角色为0、1、2、6、7时，可以查询所有商户编号信息
				merchantCredit =  merchantCreditRepository.findByMid(mid, user.getProcessorId());
			}else if (user.getType() == 4){
				//通过用户id查询商户对象
				Merchant merchant = merchantRepository.findByUser(user);
				//判断输入的mid是否为自己的mid
				if(mid.equals(merchant.getMid())){
					//当用户角色为4时(商户角色)，可以查询所有商户编号信息
					merchantCredit =  merchantCreditRepository.findByMid(merchant.getMid(), user.getProcessorId());
				}else{
					return "对不起，系统禁止查询其他商户编号";
				}
			}else{
				return "对不起，你没有查询商户编号权限";
			}
			
			//判断是否查询到商户号
			if(merchantCredit != null)
				infoStr = "授信额度（三个月）：" + merchantCredit.getCreditLineLabel();
			else
				infoStr = "对不起，系统未能查询到您输入的商户号相关信息";
		}else{
			infoStr = "对不起，您还不是注册用户或你的账户未绑定";
		}
		return infoStr;
	}
}
