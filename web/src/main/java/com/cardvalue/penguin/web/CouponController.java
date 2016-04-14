package com.cardvalue.penguin.web;

import com.cardvalue.penguin.model.ApplicationModel;
import com.cardvalue.penguin.model.NewMerchantUserModel;
import com.cardvalue.penguin.service.CouponService;
import com.cardvalue.penguin.service.NewMerchantService;
import com.cardvalue.penguin.util.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by guojia.chen on 2016-01-15 14:07.
 *
 * @Description:
 */
@Controller
@RequestMapping(value = "/coupon")
public class CouponController {

    @Resource
    private NewMerchantService newMerchantService;

    @Resource
    private CouponService couponService;
    /**
     * 查询优惠券
     * @param session
     * @return
     * type： 1 现金券  0 优惠券
     * status：1 已经使用  0 未使用
     * 兑换红包
     * 目前只能兑换现金券
     * 优惠券只能在申请中使用
     */
    @RequestMapping(value = "/discountCoupon")
    public ModelAndView getDiscountCoupon(HttpSession session){

        ModelAndView mv = new ModelAndView();
        mv.setViewName("/newm/mycountCoupon");
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        List list0 = null;
        List list1 = null;
        if(newMerchantUserModel!=null){
            list0 = newMerchantService.queryCoupons(newMerchantUserModel.getObjectId(), "0", "0");
            list1 = newMerchantService.queryCoupons(newMerchantUserModel.getObjectId(), "1", "0");
            mv.addObject("coupons0", list0);//查询未使用的现金券
            mv.addObject("coupons1", list1);//查询未使用的优惠券
            int total = list0.size()+list1.size();
            mv.addObject("total",total);
        }
        return mv;
    }

    @RequestMapping(value = "/exchangeCoupons",method = RequestMethod.POST)
    @ResponseBody
    public Map exchangeCoupons(HttpSession session,String ownerName,String cardNo,String couponId){
        Map map = couponService.exchangeCoupons(session,ownerName,cardNo,couponId);
        return map;
    }


    @RequestMapping(value = "/choseCoupons")
    @ResponseBody
    public String choseCoupons(HttpSession session,String couponIds,String selectedName){
        if(couponIds.equals("")){
            session.setAttribute("couponIds","nonuse");
            session.setAttribute("selectedName","");
        }else{
            session.setAttribute("couponIds",couponIds);
            session.setAttribute("selectedName",selectedName);
        }
        return "OK";
    }
    @RequestMapping(value = "/showCoupon")
    public ModelAndView showCoupon(HttpSession session,String couponIds){
        ModelAndView mv = new ModelAndView("/newm/discountCoupon");
        /**
         * 只显示优惠券，现金券不显示
         * 现金券可以提现使用
         * type： 1 现金券  0 优惠券
         * status：1 已经使用  0 未使用
         */
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);

        if (newMerchantUserModel != null) {
            ApplicationModel applicationModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
            String loanAmount = "";
            Double amount2 = 0.0;//期望融资金额
            Double requestAmount = 0.0;//授信金额
            if(newMerchantUserModel.getLoanAmount()!=null && !newMerchantUserModel.getLoanAmount().equals("")){
                loanAmount = newMerchantUserModel.getLoanAmount();
                amount2 = Double.parseDouble(loanAmount);
            }
            if(applicationModel!=null && applicationModel.getAmountRequested()!=null){
                requestAmount = applicationModel.getAmountRequested();
            }

            /**
             *
             * 优惠券使用规则：
             * 1、如果期望融资额度大于授信额度，优惠券使用以授信额度为准
             * 2、如果期望融资金额小于授信额度，并且期望融资金额大于5000元，优惠券使用以期望融资额度为准
             */
            if(amount2>=requestAmount){
                mv.addObject("resultAmount",requestAmount);
            }else if(amount2<requestAmount && amount2>5000){
                mv.addObject("resultAmount",amount2);
            }

            List list = newMerchantService.queryCoupons(newMerchantUserModel.getObjectId(), "0", "0");
            mv.addObject("coupons", list);//查询未使用的优惠券
            mv.addObject("newMerchantUserModel",newMerchantUserModel);
            if(applicationModel!=null &&  (applicationModel.getCoupons()== null || applicationModel.getCoupons().size()==0) && list.size()>0){
                //取第一个值
                Map map1 = (Map) list.get(0);
                String num = map1.get("amount")+"";
                num = num.substring(0,num.lastIndexOf("."));
                Integer max = (Integer.parseInt(num)) ;

                String maxId = map1.get("id")+"";
                Map map = null;
                for(int i = 0;i<list.size();i++){
                    map = (Map) list.get(i);
                    String tempNum = map.get("amount")+"";
                    String tempId = map.get("id")+"";
                    tempNum = tempNum.substring(0,tempNum.lastIndexOf("."));
                    Integer amount = (Integer.parseInt(tempNum)) ;
                    if(i>=1){
                        if(amount>max){
                            max = amount;
                            maxId = tempId;
                        }
                    }
                }
                //取最大值
                mv.addObject("maxCoupon",max);
                mv.addObject("maxCouponId",maxId);
                session.setAttribute("couponIds", maxId);
            }

        }
        return mv;
    }


}
