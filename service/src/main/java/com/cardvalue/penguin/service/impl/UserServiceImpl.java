package com.cardvalue.penguin.service.impl;

import cn.cvbaoli.www.ArrResponse;
import cn.cvbaoli.www.SoapRequestAuths;
import cn.cvbaoli.www.SoapSyncUserRequestMain;
import com.cardvalue.penguin.dto.UserRegisterDTO;
import com.cardvalue.penguin.model.Merchant;
import com.cardvalue.penguin.model.Sales;
import com.cardvalue.penguin.model.UserInfo;
import com.cardvalue.penguin.model.WeUser;
import com.cardvalue.penguin.repository.*;
import com.cardvalue.penguin.service.AdminService;
import com.cardvalue.penguin.service.UserService;
import com.cardvalue.penguin.util.Constants;
import com.cardvalue.penguin.util.LogService;
import com.cardvalue.penguin.util.Result;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * Created by guojia.chen on 2015-12-30 13:40.
 *
 * @Description:
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private LogService logService;

    @Resource
    private UserRepository userRepository;

    @Resource
    private AdminService adminService;

    @Resource
    private UserInfoRepository userInfoRepository;

    @Resource
    private SalesRepository salesRepository;

    @Resource
    private MerchantRepository merchantRepository;

    @Resource
    private UtilRepository utilRepository;

    @Override
    @Transactional(readOnly = true)
    public WeUser findByUsername(String username) throws DataAccessException {
        return userRepository.findByUsername(username);
    }

    public WeUser bind(String username, String openId) throws DataAccessException {
        WeUser user = userRepository.findByUsername(username);
        if (user.getType() != Constants.USER_TYPE_TESTING) {
            if (!StringUtils.equals(user.getOpenId(), openId)) {
                logger.info("bind user to new openid:" + openId);
                user.setOpenId(openId);
                user = userRepository.save(user);
                adminService.weGroupMove(user.getId());
            }
        }
        return user;
    }

    @Transactional
    public void afterLogin(WeUser user, HttpSession session) throws DataAccessException {

        MDC.put("user", user.getUsername());
        //将用户与用户详情存入SESSION
        session.setAttribute(Constants.SESSION_KEY_USER, user);
        session.setAttribute(Constants.SESSION_KEY_USER_INFO, userInfoRepository.findByUserId(user.getId()));

        //根据用户类型判断是商户还是销售经理，分别将不同对象存入SEESION
        if (user.getType() != Constants.USER_TYPE_MERCHANT) {
            Sales sales = salesRepository.findByUserId(user.getId());
            session.setAttribute(Constants.SESSION_KEY_SALES, sales);
        } else {
            //通过当前登录人id查找对应商户
            Merchant merchant = merchantRepository.findByUser(user);
            //如果查询到了则表示用户认证过，存入session
            session.setAttribute(Constants.SESSION_KEY_MERCHANT, merchant);
        }

        user.setLastLogin(new Date());
        user.setToken("");
        userRepository.save(user);
        logService.insertActionLog(Constants.ACTION_LOG_IN, user.getId(), user.getOpenId(), "User Type:" + user.getType());
    }


    @Override
    @Transactional(readOnly = true)
    public WeUser findByOpenId(String openId) throws DataAccessException {
        return userRepository.findByOpenId(openId);
    }

    /**
     * 注册创建用户
     * @param dto
     * @return
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Override
    @Transactional
    public Result<?> createUser(UserRegisterDTO dto,HttpSession session) throws Exception{
        Result<?> result = new Result<Object>();

        //判断用户名是否唯一
        /*if(userRepository.findByUsername(dto.getMobile()) == null){
            *//**创建user对象*//*
            WeUser user = userRepository.createUser(Constants.USER_TYPE_MERCHANT, dto.getMobile(), dto.getPassword(), dto.getReferrerId(), Constants.USER_SOURCE_SUBSCRIBE, dto.getOpenId(), true, Constants.PROCESSOR_ID_NA);
            logger.info("成功创建user对象，id为："+ user.getId());

            try {
                //复制属性
                UserInfo tempUserInfo = new UserInfo();
                PropertyUtils.copyProperties(tempUserInfo, dto);
                //设置省份和城市的中文汉字
                if(tempUserInfo.getProvinceId() != null && tempUserInfo.getProvinceId() > 0){
                    tempUserInfo.setProvinceName(utilRepository.getProvincesOrRegionsById(tempUserInfo.getProvinceId()).getName());
                }
                if(tempUserInfo.getRegionId() != null && tempUserInfo.getRegionId() > 0){
                    tempUserInfo.setRegionName(utilRepository.getProvincesOrRegionsById(tempUserInfo.getRegionId()).getName());
                }
                //关联用户user的id
                tempUserInfo.setUserId(user.getId());
                tempUserInfo.setCreateDate(new Date());
                *//**创建userInfo对象*//*
                UserInfo userInfo = userInfoRepository.save(tempUserInfo);
                logger.info("成功创建userInfo对象，id为："+ userInfo.getId());
                //推送微信消息
                //weService.pushMessage(dto.getOpenId(), "亲，您已经成功完成注册！");

                //调用网站接口将新创建的用户同步到网站
                if(session != null){
                    SoapRequestAuths soapRequestAuths = new SoapRequestAuths("", "");
                    SoapSyncUserRequestMain soapSyncUserRequestMain = new SoapSyncUserRequestMain(userInfo.getMobile(), user.getPassword(), userInfo.getName(), userInfo.getMobile(), userInfo.getEmail(), userInfo.getProvinceId() == null ? null :userInfo.getProvinceId().toString(), userInfo.getRegionId() == null ? null : userInfo.getRegionId().toString(), "1");
                    ArrResponse arrResponse = addServiceBindingStub.syncUser(soapRequestAuths, soapSyncUserRequestMain);
                    if(!arrResponse.getStatus().equals("1")){
                        //表示失败，打印日志信息
                        ObjectMapper mapper = new ObjectMapper();
                        logService.insertActionLog(Constants.ACTION_SYN_USER, user.getId(), null, "微信端用户注册成功同步到网站用户失败，失败详情如下：1、网站service第1个参数对象'auths'转json为:"+ mapper.writeValueAsString(soapRequestAuths) + " 2、网站service第2个参数对象转'json'为:"+ mapper.writeValueAsString(soapSyncUserRequestMain));
                    }
                }
                result.setCode(Constants.RESULT_CODE_SUCCESS);
                result.setMessage("亲，您已经成功完成注册！");
            } catch (Exception e) {
                logger.error("",e);
            }
        }else{
            result.setCode(Constants.RESULT_CODE_FAILED);
            result.setMessage("当前手机号已被注册，请输入其他手机号");
        }*/

        return result;
    }
}
