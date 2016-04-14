package com.cardvalue.penguin.web.message.function;


import com.cardvalue.penguin.model.Merchant;
import com.cardvalue.penguin.model.WeUser;
import com.cardvalue.penguin.repository.MerchantRepository;
import com.cardvalue.penguin.service.MerchantService;
import com.cardvalue.penguin.service.UserService;
import com.cardvalue.penguin.util.Constants;
import com.cardvalue.penguin.util.Utility;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Component("MerchanttFunction")
public class MerchantFunction {

	@Resource
	private UserService userService;
	
	@Resource
	private MerchantService merchantService;
	
	@Resource
	private MerchantRepository merchantRepo;
	
	public String getBankStatement(String openId, String content){
		WeUser user = userService.findByOpenId(openId);
		String infoStr = null;
		/*if(user != null){
			if(user.getType() == Constants.USER_TYPE_MERCHANT){
				if(user.isEnabled()){
					Merchant merchant = merchantRepo.findByUser(user);
					List<BaoliIdModel> baoliIds = merchantService.queryBaolisIdByMid(merchant.getMid());
					int size = baoliIds.size();
					if(size > 0){
						BaoliIdModel model = baoliIds.get(size);
						String caseAdvId = model.getCashadv_id();
						Date today = new Date();
						Date oneMonthAgo = DateUtils.addMonths(today, -1);
						String endDate = Utility.formatShortDate(today);
						String beginDate = Utility.formatShortDate(oneMonthAgo);
						ExchangerResultModel bankStatement = merchantService.bankStatementList(beginDate, endDate, caseAdvId, 1, 10);
						List<ExchangeFooterModel> footers = bankStatement.getFooter();
						if(footers.size() > 0){
							ExchangeFooterModel footer = footers.get(0);
							infoStr = String.format("亲爱的商户，您最近的融资保理账单情况是: 编号:$1%s, 融资金额:$2%s, 还款余额:$3%s, 月最低还款额:$4%s, 如有任何问题请致电4008-803-803",
									caseAdvId, footer.getTotalPayback(), footer.getTotalRemaining(), footer.getMinMonthPay());
						}else{
							infoStr = "亲爱的商户，目前您没有进行中的融资保理";
						}
					}
					
				}else{
					infoStr = "对不起，您的账号还没有激活";
				}
			}else{
				infoStr = "对不起，您不是商户用户";
			}
		}else{
			infoStr = "对不起，您还不是注册用户或你的账户未绑定";
		}*/
		return infoStr;
	}
	
}
