package com.yi.nuo.tenant.api.base.security;

import com.yi.nuo.common.util.Md5Util;
import com.yi.nuo.tenant.api.base.security.exception.ValidCodeErrorException;
import com.yi.nuo.user.bo.MenuBo;
import com.yi.nuo.user.bo.UserBo;
import com.yi.nuo.user.domain.IUserDomain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 黄雪冬
 * @version 0.0.1
 * @date 2020/9/8 13:10
 */
@Component
@Slf4j
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Resource
    private IUserDomain userDomain;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.info("now start custom authenticate process!");
        MyWebAuthenticationDetails details = (MyWebAuthenticationDetails) authentication.getDetails();

        if (StringUtils.isEmpty(details.getValidCode())) {
            throw new ValidCodeErrorException("验证码不能为空");
        }
        if (!details.getValidCode().equalsIgnoreCase(details.getSessionCodeValue())) {
            throw new ValidCodeErrorException("验证码错误");
        }

        UserBo userBo = userDomain.getByUserName(details.getUsername());
        if (userBo == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        if (!userBo.getPassword().equals(Md5Util.hash(details.getPassword() + userBo.getSalt()))) {
            log.info("password error");
            throw new BadCredentialsException("密码错误");
        }


        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (MenuBo menuBo : userBo.getMenuBoList()) {
            if (!StringUtils.isEmpty(menuBo.getPermissionUrl())) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(menuBo.getPermissionUrl());
                grantedAuthorities.add(grantedAuthority);
            }
        }
        return new UsernamePasswordAuthenticationToken(userBo, details.getPassword(), grantedAuthorities);

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
