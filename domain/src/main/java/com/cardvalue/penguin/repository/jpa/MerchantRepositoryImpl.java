package com.cardvalue.penguin.repository.jpa;

import cn.cvbaoli.www.*;
import com.cardvalue.penguin.dto.AddKeyMerchantDetailDTO;
import com.cardvalue.penguin.dto.AddKeyMerchantSummaryDTO;
import com.cardvalue.penguin.dto.MerchantRegisterDTO;
import com.cardvalue.penguin.model.Merchant;
import com.cardvalue.penguin.model.Sales;
import com.cardvalue.penguin.model.UserInfo;
import com.cardvalue.penguin.model.WeUser;
import com.cardvalue.penguin.repository.*;
import com.cardvalue.penguin.util.Constants;
import com.cardvalue.penguin.util.LogService;
import org.apache.commons.beanutils.PropertyUtils;
import org.codehaus.jackson.map.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by guojia.chen on 2015-12-30 14:19.
 *
 * @Description:
 */
@Repository
@Transactional(readOnly=true)
public class MerchantRepositoryImpl implements MerchantRepositoryCustom {

    private final static Logger logger = LoggerFactory.getLogger(MerchantRepositoryImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Resource
    private UserRepository userRepo;

    @Resource
    private UserInfoRepository userInfoRepository;

    @Resource
    private UtilRepository utilRepository;

    @Resource
    private LogService logService;

    @Resource
    private AddServiceBindingStub addServiceBindingStub;

//    @Override
    public int create(MerchantRegisterDTO dto, Sales sales) {
        logger.info("Start creating merchant...");
        //查看是否为重点商户
		/*long keyMerchantCount = keyMerchantRepo.countByMid(dto.getMid());
		if(keyMerchantCount == 0){
			//非重点商户
			return 2;
		}*/
        Query findMerchantByMidQuery = em.createNamedQuery("countMerchantByMidOrMobile");
        findMerchantByMidQuery.setParameter("mid", dto.getMid());
        findMerchantByMidQuery.setParameter("mobile", dto.getContactMobile());
        //查看相同的mid和手机号是否已经登记过
        long count = (Long)findMerchantByMidQuery.getSingleResult();
        int salesId = sales == null ? 0 : sales.getUserId();
        if(count == 0){
            WeUser user = userRepo.createUser(Constants.USER_TYPE_MERCHANT, dto.getContactMobile(), null,
                    salesId, Constants.USER_SOURCE_SCAN_QRCODE, dto.getOpenId(), false, Constants.PROCESSOR_ID_NA);

            logger.info("成功创建user对象，id为："+ user.getId());

            /**调用网站接口将新创建的用户同步到网站*/
            try {
                //复制属性
                UserInfo tempUserInfo = new UserInfo();
                PropertyUtils.copyProperties(tempUserInfo, dto);
                //设置省份和城市的中文汉字
                if(tempUserInfo.getProvinceId() != null) tempUserInfo.setProvinceName(utilRepository.getProvincesOrRegionsById(tempUserInfo.getProvinceId()).getName());
                if(tempUserInfo.getRegionId() != null) tempUserInfo.setRegionName(utilRepository.getProvincesOrRegionsById(tempUserInfo.getRegionId()).getName());
                //关联用户user的id
                tempUserInfo.setUserId(user.getId());
                /**创建userInfo对象*/
                UserInfo userInfo = userInfoRepository.save(tempUserInfo);
                logger.info("成功创建userInfo对象，id为："+ userInfo.getId());
                //调用网站接口将新创建的用户同步到网站
                SoapRequestAuths soapRequestAuths = new SoapRequestAuths("", "");
                SoapSyncUserRequestMain soapSyncUserRequestMain = new SoapSyncUserRequestMain(user.getUsername(), user.getPassword(), userInfo.getName(), userInfo.getMobile(), userInfo.getEmail(), userInfo.getProvinceId() == null ? null : userInfo.getProvinceId().toString(),userInfo.getRegionId() == null ? null : userInfo.getRegionId().toString(), "0");
                ArrResponse arrResponse = addServiceBindingStub.syncUser(soapRequestAuths, soapSyncUserRequestMain);
                if(!arrResponse.getStatus().equals("1")){
                    //表示失败，打印日志信息
                    ObjectMapper mapper = new ObjectMapper();
                    logService.insertActionLog(Constants.ACTION_SYN_USER, user.getId(), null, "微信端用户注册成功同步到网站用户失败，错误信息为："+arrResponse.getMsg()+"，失败详情如下：1、网站service第1个参数对象'auths'转json为:"+ mapper.writeValueAsString(soapRequestAuths) + " 2、网站service第2个参数对象转'json'为:"+ mapper.writeValueAsString(soapSyncUserRequestMain));
                }
            } catch (Exception e) {
                logger.error("",e);
            }
            Merchant merchant = new Merchant();
            merchant.setUser(user);
            merchant.setMid(dto.getMid());
            merchant.setName(dto.getMerchantName());
            merchant.setContactName(dto.getContactName());
            merchant.setContactMobile(dto.getContactMobile());
            merchant.setContactPosition(dto.getContactPosition());
            merchant.setCreateDate(new Date());
            merchant.setActiveStatus(1);

            merchant.setActiveStatusLabel("验证中");

            em.persist(merchant);
            logService.insertActionLog(Constants.ACTION_ADD_MERCHANT, salesId, null, "Merchant OpenId:" + dto.getOpenId());
            return 1;
        }else{
            return 0;
        }
    }

    /**
     * 只添加商户不添加用户
     * @param dto
     * @param sales
     * @param user
     * @param session
     * @return
     */
//    @Override
    public int create(MerchantRegisterDTO dto, Sales sales,WeUser user,HttpSession session) {

        /**设置查询条件*/
        Query findMerchantByMidQuery = em.createNamedQuery("countMerchantByMidOrMobile");
        findMerchantByMidQuery.setParameter("mid", dto.getMid());
        findMerchantByMidQuery.setParameter("mobile", dto.getContactMobile());

        /**修改用户的PROCESSOR_ID*/
        user.setProcessorId(dto.getProcessorId());
        em.merge(user);

        /**排重，查看相同的mid和手机号是否已经登记过*/
        long count = (Long)findMerchantByMidQuery.getSingleResult();
        if(count == 0){
            //表示不存在相同的MID
            Merchant merchant = new Merchant();
            merchant.setUser(user);
            //特殊处理，用户可以输入多个商编
            String[] mids = dto.getMid().split(",");
            if(mids.length == 1){
                merchant.setMid(dto.getMid().substring(0,15));
            }else{
                merchant.setMid(mids[0].substring(0,15));
                //拼接其他mid
                String otherMid = "";
                for(int i = 1 ; i <mids.length ; i ++){
                    otherMid += mids[i]+",";
                }
                merchant.setOtherMid(otherMid);
            }
            merchant.setName(dto.getMerchantName());
            merchant.setContactName(dto.getContactName());
            merchant.setContactMobile(dto.getContactMobile());
            merchant.setContactPosition(dto.getContactPosition());
            merchant.setCreateDate(new Date());
            merchant.setAddress(dto.getAddress());
            merchant.setAuthorizationFlag(true);//默认同意条款
            if(user.getType() == Constants.USER_TYPE_MERCHANT && user.getReferrerId() == 0){
                //用户自主注册，直接验证通过
                merchant.setActiveStatus(2);
                merchant.setActiveStatusLabel("验证通过");
            }else{
                merchant.setActiveStatus(1);
                merchant.setActiveStatusLabel("验证中");
            }
            /**持久化商户（认证操作）*/
            em.persist(merchant);

            /**判断网站那边是否通过WEBSERVICE调用此方法*/
            if(session != null){
                //表示是微信端调用此方法
                session.setAttribute(Constants.SESSION_KEY_MERCHANT, merchant);//存入session
                /**调用网站接口，同步商户信息*/
                try {
                    UserInfo userInfo = userInfoRepository.findByUserId(user.getId());
                    SoapRequestAuths soapRequestAuths = new SoapRequestAuths("","");
                    SoapSyncUserMerchantRequestMain soapSyncUserMerchantRequestMain = new SoapSyncUserMerchantRequestMain(user.getUsername(), dto.getContactMobile(), merchant.getMid(),userInfo.getProvinceId() == null ? null : userInfo.getProvinceId().toString(), dto.getMerchantName(), dto.getAddress(), dto.getProcessorId());
                    cn.cvbaoli.www.ArrResponse arrResponse = addServiceBindingStub.syncUserMerchant(soapRequestAuths, soapSyncUserMerchantRequestMain);
                    if(!arrResponse.getStatus().equals("1")){
                        //表示失败，打印日志信息
                        ObjectMapper mapper = new ObjectMapper();
                    }
                    logger.info("微信端认证，同步认证信息到网站，结果为："+ arrResponse.getStatus() +" 日志信息为：",arrResponse.getMsg());
                } catch (Exception e) {
                    logger.error("商户微信端认证，同步到网站接口出错！错误信息如下：",e);
                }
            }

            //记录日志
            logService.insertActionLog(Constants.ACTION_ADD_MERCHANT, sales == null ? 0 : sales.getUserId(), null, "Merchant OpenId:" + dto.getOpenId());

            return 1;
        }else{
            //表示数据已经存在相同的MID
            return 0;
        }
    }

//    @Override
    public void authorize(int merchantId) {
        Merchant merchant = em.find(Merchant.class, merchantId);
        merchant.setAuthorizationFlag(true);
        em.persist(merchant);
    }

    private final static String ADD_KEY_MERCHANT_SUMMARY_QUERY = "SELECT m.id, mb.label as branch,COUNT(m.id) as merchant_count, "
            + "SUM(CASE WHEN m.active_status=2 THEN 1 ELSE 0 END) AS active_suceess_count,"
            + "SUM(CASE WHEN m.active_status=3 THEN 1 ELSE 0 END) AS active_failed_count"
            + " FROM merchant m "
            + " LEFT JOIN USER mu ON m.user_id=mu.id"
            + " LEFT JOIN USER su ON mu.referrer_id=su.id"
            + " LEFT JOIN sales s ON su.id=s.user_id"
            + " LEFT JOIN master_branch mb ON mb.code=s.branch_code"
            + " GROUP BY s.branch_code ";

    private final static String ADD_KEY_MERCHANT_DETAIL_QUERY = "SELECT m.id, m.branch, m.mid, m.name as merchant_name,"
            + " su.username as sales_username, s.name as sales_name, m.update_date,"
            + " m.create_date, m.verifier, m.active_status_label, m.active_status_memo"
            + " FROM merchant m"
            + " LEFT JOIN USER mu ON mu.id=m.user_id"
            + " LEFT JOIN USER su ON mu.referrer_id=su.id"
            + " LEFT JOIN sales s ON su.id=s.user_id"
            + " WHERE m.active_status>1 "
            + " GROUP BY m.mid ORDER BY m.create_date";

//    @Override
    public List<AddKeyMerchantSummaryDTO> listAddKeyMerchantSummary() {
        Query query = em.createNativeQuery(ADD_KEY_MERCHANT_SUMMARY_QUERY, AddKeyMerchantSummaryDTO.class);
        return query.getResultList();
    }

//    @Override
    public List<AddKeyMerchantDetailDTO> listAddKeyMerchantDetail() {
        Query query = em.createNativeQuery(ADD_KEY_MERCHANT_DETAIL_QUERY, AddKeyMerchantDetailDTO.class);
        return query.getResultList();
    }
}