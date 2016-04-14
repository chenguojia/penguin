package com.cardvalue.penguin.service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by guojia.chen on 2016-01-22 13:08.
 *
 * @Description:
 */
public interface CouponService {

    public Map exchangeCoupons(HttpSession session,String ownerName,String cardNo,String couponId);
}
