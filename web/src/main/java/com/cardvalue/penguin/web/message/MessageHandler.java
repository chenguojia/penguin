package com.cardvalue.penguin.web.message;


import com.cardvalue.penguin.dto.ApplyProcessContext;
import com.cardvalue.penguin.dto.WeChatMessage;
import com.cardvalue.penguin.model.*;
import com.cardvalue.penguin.repository.ApplyProcessRepository;
import com.cardvalue.penguin.repository.MessageContentRepository;
import com.cardvalue.penguin.repository.MessageRuleRepository;
import com.cardvalue.penguin.repository.WeNewActivitiesRepository;
import com.cardvalue.penguin.service.UserService;
import com.cardvalue.penguin.util.Constants;
import com.cardvalue.penguin.util.XMLConverter;
import com.cardvalue.penguin.web.message.function.FinancingFunction;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class MessageHandler {

	private static final Logger logger = LoggerFactory.getLogger(MessageHandler.class);
	
	@Resource
	private MessageRuleRepository messageRuleRepo;

	@Value("${wechat.app.name}")
	private String wechatAppName;

	@Resource
	private MessageContentRepository messageContentRepo;
	
	@Value("${we.text.default.response}")
	private String defaultResponse;
	
	@Value( "${wechat.username}" )
	private String weChatUsername;
	
	@Resource
	private XMLConverter xmlConverter;
	
	@Resource
	private ResponseContentProviderFactory factory;
	
	@Resource
	private ApplyProcessRepository applyProcessRepository;
	
	@Resource
	private UserService userService;

	@Resource
	private WeNewActivitiesRepository weNewActivitiesRepository;
	
	public abstract String handle(WeChatMessage message)  throws Exception;
	
	protected String matchRule(String content, String fromOpenId) throws IOException {
		
		String respXML = null;
		List<MessageRule> rules = messageRuleRepo.listAll();
		for(MessageRule rule : rules){
			if( rule.getKeyword().indexOf("^") != -1 &&  rule.getKeyword().indexOf("$") != -1){
				//正则表达式
				Pattern p = Pattern.compile(rule.getKeyword());
				Matcher m=p.matcher(content);		
				if(m.matches()){
					//表示输入的是合法的mid编号
					String type = rule.getResponseType();
					int messageId = Integer.parseInt(rule.getResponseId());
					respXML = generateReturnMessage(fromOpenId, type, messageId,content);
					break;
				}
			}else{
				//不是正则表达式,采用keyword方式验证

				/**特殊回复处理*/
				if(content.equals("new_activities")) {
					//表示数据库没有配置的，其他
					WeNewActivities otherWeNewActivities = weNewActivitiesRepository.findByUserType(0);
					WeUser weUser = userService.findByOpenId(fromOpenId);
					if(weUser != null) {
						//表示用户点击的是最新新闻，此时根据用户类型推送不同的消息
						WeNewActivities weNewActivities = weNewActivitiesRepository.findByUserType(weUser.getType());
						if (weNewActivities != null) {
							respXML = generateReturnMessage(fromOpenId, weNewActivities.getResponseType(), weNewActivities.getResponseId(),content);
							break;
						}
					}
					//没有绑定或者用户为空，返回默认的
					respXML = generateReturnMessage(fromOpenId, otherWeNewActivities.getResponseType(), otherWeNewActivities.getResponseId(),content);
					break;
				} else {

					//根据ruleType判断是采用模糊还是精确匹配
					if(org.apache.commons.lang3.StringUtils.isNotBlank(rule.getRuleType())) {
						if(rule.getRuleType().equals("1")) {//精确匹配
							//匹配
							if( rule.getKeyword().equals(content)){
								String type = rule.getResponseType();
								int messageId = Integer.parseInt(rule.getResponseId());
								respXML = generateReturnMessage(fromOpenId, type, messageId,content);
								break;
							}

						} else if(rule.getRuleType().equals("2")) { //模糊匹配
							//匹配
							if(StringUtils.contains(content,rule.getKeyword())){
								String type = rule.getResponseType();
								int messageId = Integer.parseInt(rule.getResponseId());
								respXML = generateReturnMessage(fromOpenId, type, messageId,content);
								break;
							}
						}
					} else {
						//没有设置匹配方式，系统默认用模糊匹配.
						if(StringUtils.contains(content,rule.getKeyword())){
							String type = rule.getResponseType();
							int messageId = Integer.parseInt(rule.getResponseId());
							respXML = generateReturnMessage(fromOpenId, type, messageId,content);
							break;
						}
					}
				}

			}
		}
		
		if(StringUtils.isBlank(respXML)) {
			if(FinancingFunction.applyProcessContextMap.get(fromOpenId) != null){
				return this.excuteApplyProcess(fromOpenId, content, Constants.WECHAT_MESSAGE_TYPE_TEXT, null, null);
			}else{
				if (wechatAppName.equals("penguin")) {
					respXML = generateReturnCustomMessage(fromOpenId,"请回复“帮助”关键字获取更多帮助信息！");
				} else {
					respXML = generateReturnCustomMessage(fromOpenId,"你好，若以下途径不能解决你的问题，请留下你的姓名+联系电话，将有专人与你联系。\n\n" +
							"回复01	 如何申请\n" +
							"回复02	 申请条件\n" +
							"回复03  业务介绍\n" +
							"回复04  输入验证码\n" +
							"回复05	 关于我们\n\n" +
							"融资申请点击底部菜单“融资入口”，了解最新活动点击底部菜单“最新活动”");
				}
			}
		}
		return respXML;
		
	}
	
	protected String matchImage(WeChatMessage message) throws IOException {
		
		//将用户发送的图片保存到本地
		/*URL url = new URL(message.getPicUrl());
		File outFile = new File("c:\\"+message.getMediaId()+".jpg");
		OutputStream os = new FileOutputStream(outFile);
		InputStream is = url.openStream();
		byte[] buff = new byte[1024];
		while (true) {
		    int readed = is.read(buff);
		    if (readed == -1) {
		        break;
		    }
		    byte[] temp = new byte[readed];
		    System.arraycopy(buff, 0, temp, 0, readed);
		    os.write(temp);
		}
		is.close();
		os.close();*/
		
		if(FinancingFunction.applyProcessContextMap.get(message.getFromUserName()) != null){
			//表示在申请流程过程中
			return this.excuteApplyProcess(message.getFromUserName(), message.getContent(), Constants.WECHAT_MESSAGE_TYPE_IMAGE, message.getPicUrl(), message.getMediaId());
		}else{
			//构建服务器返回对象
			WeChatMessage respMessage = new WeChatMessage();
			String createTime = Long.toString(Calendar.getInstance().getTimeInMillis()/1000);
			respMessage.setFromUserName(weChatUsername);
			respMessage.setToUserName(message.getFromUserName());
			respMessage.setCreateTime(createTime);
			respMessage.setContent("系统已经接受到您的图片你了!");
			respMessage.setMsgType(Constants.WE_MESSAGE_TYPE_TEXT);
			String respXML = xmlConverter.convertFromObjectToXML(respMessage);
			return respXML;
		}
		
		
	}
	
	protected String generateReturnMessage(String fromOpenId, String type, int messageId,String content) throws IOException{
		MessageContent messageContent = messageContentRepo.findMessageContent(type, messageId);
		logger.debug("rule found:[type:" + type + "][messageId:" + messageId + "][message:" + messageContent + "]");
		String response = null;
		WeChatMessage respMessage = new WeChatMessage();
		String createTime = Long.toString(Calendar.getInstance().getTimeInMillis()/1000);
		respMessage.setFromUserName(weChatUsername);
		respMessage.setToUserName(fromOpenId);
		respMessage.setCreateTime(createTime);
		if(messageContent != null){
			respMessage.setMsgType(type);
			ResponseContentProvider provider = factory.getProvider(type);
			provider.fillContent(respMessage, messageContent,content);
		}else{
			response = StringUtils.isBlank(response) ? defaultResponse : response;
			respMessage.setMsgType(Constants.WE_MESSAGE_TYPE_TEXT);
			respMessage.setContent(response);
		}
		String respXML = xmlConverter.convertFromObjectToXML(respMessage);
		return respXML;
	}
	
	
	/**
	 * 客户端发送提示消息通用方法
	 * @param fromOpenId
	 * @param type
	 * @param messageId
	 * @param content
	 * @return
	 * @throws IOException
	 */
	protected String generateReturnCustomMessage(String fromOpenId,String content) throws IOException{
		WeChatMessage respMessage = new WeChatMessage();
		String createTime = Long.toString(Calendar.getInstance().getTimeInMillis()/1000);
		respMessage.setFromUserName(weChatUsername);
		respMessage.setToUserName(fromOpenId);
		respMessage.setCreateTime(createTime);
		respMessage.setContent(content);
		respMessage.setMsgType(Constants.WE_MESSAGE_TYPE_TEXT);
		String respXML = xmlConverter.convertFromObjectToXML(respMessage);
		return respXML;
	}
	
	/**
	 * 流程申请通用方法
	 * @param fromOpenId
	 * @param content
	 * @param messageType
	 * @param picUrl
	 * @param picMediaId
	 * @return
	 */
	public String excuteApplyProcess(String fromOpenId,String content,String messageType,String picUrl,String picMediaId){
		try {
			
			//从session获取流程 
			ApplyProcess applyProcess = FinancingFunction.applyProcessContextMap.get(fromOpenId).getApplyProcess();
			//获取processContent上下文中的参数
			ApplyProcessInputArgumentModel applyProcessInputArgumentModel = FinancingFunction.applyProcessContextMap.get(fromOpenId).getAplyProcessInputArgumentModel();
			
			//记录用户与服务器交互的时间
			applyProcess.setLastOptStepDate(new Date());
			//设置常量
			FinancingFunction.applyProcessContextMap.put(fromOpenId, new ApplyProcessContext(applyProcess,applyProcessInputArgumentModel));
			
			//标示是否最后一步，true为不是最后一步，false为最后一步
			boolean isLastStep =applyProcess.getLastStep() == null || applyProcess.getLastStep().toString().equals("");
			
			//表示流程不是最后一步
			if(applyProcess.getProcessType() == 1){
				//表示流程类型为速融流程，验证用户输入的消息类型是否符合系统发出的提示消息类型
				String checkMsg = applyProcessMessageCheck(messageType,fromOpenId,content,applyProcess.getCheckRegularExpression(),applyProcess.getCheckFailMessage(),picUrl);
				if(checkMsg == null){
					//开始速融申请业务处理
					return this.beginApplyQuickFinancing(fromOpenId, picUrl, picMediaId, content, isLastStep ? Constants.APPLY_PROCESS_NOT_END : Constants.APPLY_PROCESS_END,messageType);
				}else{
					//表示验证不通过,直接返回提醒给用户
					return generateReturnCustomMessage(fromOpenId,checkMsg);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 申请速融验证方法，验证每一步用户输入的数据是否合法
	 * @param messageType 消息内容
	 * @param fromOpenId 当用户输入的类型不匹配时，需给出提示
	 * @param content 当用户输入的内容
	 * @param checkRegularExpression 当用户输入的正则表达式
	 * @param checkFailMessage 用户验证正则表达式失败时提示信息
	 * @param picUrl 如果是图片消息则为图片url
	 * @return null表示验证通过，不为空则表示验证失败
	 * @throws IOException 
	 */
	public String applyProcessMessageCheck(String messageType,String fromOpenId,String content,String checkRegularExpression,String checkFailMessage,String picUrl) throws IOException{
		
		//获取服务器上一步发送的申请消息对象
		ApplyProcess previousApplyProcess = FinancingFunction.applyProcessContextMap.get(fromOpenId).getApplyProcess();
		
		//判断是否是用户确认的信息，如果为待确认则直接验证通过
		if(previousApplyProcess.getAffirmStatus().equals("1")) return null;
		
		//比对消息的类型是否一致
		if(!previousApplyProcess.getClientInputType().equals(messageType)){
			//输入内容不匹配
			return "你发送的消息类型与该申请条目规定类型不一致，请重新输入!";
		}else{
			//正则表达式为空时，默认验证通过
			if(StringUtils.isBlank(checkRegularExpression)) return null;
			
			//判断用户输入的内容是否符合制定的正则表达式
			Pattern p = Pattern.compile(checkRegularExpression);
			Matcher m=p.matcher(content);		
			if(!m.matches()){
				//表示用户输入的内容和配置的正则表达式不一致
				return checkFailMessage+"请重新输入！";
			}else{
				return null;
			}
		}
	}
	
	/**
	 * 速融业务申请处理方法
	 * @param fromOpenId 用户openid
	 * @param picUrl 如果消息类型为图片则为图片url
	 * @param picMediaId 图片名字
	 * @param textContent 如果消息类型为文字则为文字url
	 * @param isLastStep 是否是流程最后一步1是0否
	 * @param messageType 消息类型text/images
	 * @return
	 * @throws IOException
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 */
	public String beginApplyQuickFinancing(String fromOpenId,String picUrl,String picMediaId,String textContent,String isLastStep,String messageType) throws Exception{
		
		//获取服务器上一步发送的申请消息对象
		ApplyProcess previousApplyProcess = FinancingFunction.applyProcessContextMap.get(fromOpenId).getApplyProcess();
		//获取processContent上下文中的参数
		ApplyProcessInputArgumentModel applyProcessInputArgumentModel = FinancingFunction.applyProcessContextMap.get(fromOpenId).getAplyProcessInputArgumentModel();
		
		if(previousApplyProcess.getAffirmStatus().equals("0")){
			//如果当前流程步骤为0未确认时，则将其改为1待确认
			previousApplyProcess.setAffirmStatus("1");
			
			//通过反射机制动态调用对象的setter方法,将用户第一次输入的值保存进变量中
			Method method = applyProcessInputArgumentModel.getClass().getMethod(previousApplyProcess.getFillFieldMethodName(), String.class);
			method.invoke(applyProcessInputArgumentModel ,messageType.equals(Constants.WECHAT_MESSAGE_TYPE_TEXT) ? textContent : picUrl);  
			//给常量表赋值
			FinancingFunction.applyProcessContextMap.put(fromOpenId, new ApplyProcessContext(previousApplyProcess,applyProcessInputArgumentModel));
			
			//返回确认信息给用户
			return generateReturnCustomMessage(fromOpenId,"请确认以上输入信息，(输入 Y 表示确认，输入 N 表示取消)");
			
		}else if(previousApplyProcess.getAffirmStatus().equals("1")){
			//表示用户此时输入的是确认步骤信息
			if(textContent.toUpperCase().equals("Y")){
				
				//表示同意此步骤 ，则将其确认状态改为2已确认
				previousApplyProcess.setAffirmStatus("2");
				
				if(isLastStep.equals(Constants.APPLY_PROCESS_END)){
					//表示最后一步，提交接口给CRM系统，
					//code....提交接口
					
					//获取参数对象
					ApplyProcessInputArgumentModel tempApplyProcessInputArgumentModel = FinancingFunction.applyProcessContextMap.get(fromOpenId).getAplyProcessInputArgumentModel();
					
					String aa="身份证号:"+tempApplyProcessInputArgumentModel.getCardno()+"，身份证pic："+tempApplyProcessInputArgumentModel.getIdcardpic()+",手机号:"+tempApplyProcessInputArgumentModel.getTelno()+",姓名为:"+tempApplyProcessInputArgumentModel.getName()+",营业执照为:"+tempApplyProcessInputArgumentModel.getOfficepic();
					
					//清空常量
					FinancingFunction.applyProcessContextMap.remove(fromOpenId);
					
					//表示成功前面的业务执行成功，用户返回成功消息提示
					//return generateReturnCustomMessage(fromOpenId,"您好，您的速融流程已经申请完毕!");
					return generateReturnCustomMessage(fromOpenId,"您好，您的速融流程已经申请完毕!您填写的信息为:"+aa);
					
				}else{
					
					//获取下一步系统响应给用户的消息
					ApplyProcess nextApplyProcess = applyProcessRepository.findByProcessTypeAndStepNum(1, previousApplyProcess.getStepNum()+1);
					
					//给常量表赋值
					FinancingFunction.applyProcessContextMap.put(fromOpenId, new ApplyProcessContext(nextApplyProcess,applyProcessInputArgumentModel));
					
					//给用户返回下一步操作步骤提醒
					return generateReturnCustomMessage(fromOpenId,nextApplyProcess.getResponText());
				}
			}else if(textContent.toUpperCase().equals("N")){
				//表示取消上一步键入,将其确认状态置为初始化0未确认
				previousApplyProcess.setAffirmStatus("0");
				
				//给常量表赋值
				FinancingFunction.applyProcessContextMap.put(fromOpenId, new ApplyProcessContext(previousApplyProcess,applyProcessInputArgumentModel));
				
				//给用户返回上一步操作步骤提醒
				return generateReturnCustomMessage(fromOpenId,previousApplyProcess.getResponText());
				
			}else{
				//表示输入的其他不合法数字或类型，给出提示！
				return generateReturnCustomMessage(fromOpenId,"您输入的确认消息有误！请重新确认以上输入信息，(输入 Y 表示确认，输入 N 表示取消)");
			}
		}else{
			//表示确认状态不为0也不为1，则表示系统出错，返回null
			return null;
		}
	}

}
