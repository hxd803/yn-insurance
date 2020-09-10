package com.yi.nuo.tenant.api.function.test.controller;

import com.yi.nuo.tenant.api.function.test.vo.LoginResultVo;
import com.yi.nuo.user.bo.UserBo;
import com.yi.nuo.user.domain.IUserDomain;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;

/**
 * @author 黄雪冬
 * @version 0.0.1
 * @since 2020/9/7 21:12
 */
public class LoginService implements UserDetailsService {

    @Resource
    private IUserDomain userDomain;

    @Override
    public UserDetails loadUserByUsername(String s) {
        UserBo userBo = userDomain.getByLoginName(s);
        if (userBo == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return new LoginResultVo().setUser(userBo);
    }
}
