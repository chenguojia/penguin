package com.cardvalue.penguin.service.impl;

import com.cardvalue.penguin.model.UserAdmin;
import com.cardvalue.penguin.model.WeUser;
import com.cardvalue.penguin.repository.ActionLogRepository;
import com.cardvalue.penguin.repository.UserAdminRepository;
import com.cardvalue.penguin.service.UserService;
import com.cardvalue.penguin.service.UtilityService;
import com.cardvalue.penguin.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by guojia.chen on 2015-12-30 11:36.
 *
 * @Description:
 */
@Service("authService")
public class AuthServiceImpl implements UserDetailsService {

    private final static Logger log = LoggerFactory.getLogger(AuthServiceImpl.class);

    private UserService userService;

    @Resource
    private UtilityService utilityService;

    @Resource
    private UserAdminRepository userAdminRepository;

    @Resource
    private HttpServletRequest request;

    @Resource
    private ActionLogRepository actionLogRepository;

    @Autowired
    public AuthServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("entering loadUserByUsername...");
        if (username.equals(Constants.SESSION_KEY_NEW_MERCHANT)) {
            //表示新版本的商户登录
            Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_NEW_MERCHANT"));
            UserDetails user = new User(username, Constants.SESSION_KEY_NEW_MERCHANT, authorities);
            return user;
        } else {
            //表示以前的客户经理或者老版商户权限验证
            WeUser weUser = userService.findByUsername(username);
            if (weUser == null) {
                throw new UsernameNotFoundException(username);
            }
            if (weUser.isEnabled() == false) {
                throw new DisabledException("您使用的帐号已锁定，如果需要开启，请联系系统管理员。");
            } else {
                Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

                UserAdmin userAdmin = userAdminRepository.findByUserId(weUser.getId());//判断是否管理员
                if (userAdmin == null) {
                    //不是管理员,给当前用户添加权限
                    if (weUser.getType() == Constants.USER_TYPE_MERCHANT) {
                        authorities.add(new SimpleGrantedAuthority("ROLE_MERCHANT"));
                    } else if (weUser.getType() == Constants.USER_TYPE_INVOKER) {
                        authorities.add(new SimpleGrantedAuthority("ROLE_INVOKER"));
                    } else if (weUser.getType() == Constants.USER_TYPE_STAFF) {
                        authorities.add(new SimpleGrantedAuthority("ROLE_STAFF"));
                    } else {
                        authorities.add(new SimpleGrantedAuthority("ROLE_SALES"));
                    }
                } else {
                    //表示是管理员
                    authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                }

                authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                UserDetails user = new User(username, weUser.getPassword(), authorities);
                return user;
            }
        }

    }

}
