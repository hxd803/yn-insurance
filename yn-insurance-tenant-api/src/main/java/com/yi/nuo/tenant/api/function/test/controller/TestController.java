package com.yi.nuo.tenant.api.function.test.controller;

import com.alibaba.druid.util.StringUtils;
import com.yi.nuo.common.result.BaseApiResult;
import com.yi.nuo.tenant.api.base.security.session.GlobalSessionContext;
import com.yi.nuo.user.bo.MenuBo;
import com.yi.nuo.user.bo.UserBo;
import com.yi.nuo.user.domain.IMenuDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author 黄雪冬
 * @version 0.0.1
 * @date 2020/9/8 17:39
 */

@RestController
public class TestController {

    @Autowired
    private SessionRegistry sessionRegistry;//这个类会自动注入 不用我们自己去手动注入

    @Autowired
    private GlobalSessionContext globalSessionContext;

    @Resource
    private IMenuDomain menuDomain;

    @GetMapping("/api/manage/role/create")
    public BaseApiResult<Boolean> test1() {


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        System.out.println(authorities.size());

        List<Object> allPrincipals = sessionRegistry.getAllPrincipals();
        for (Object allPrincipal : allPrincipals) {
            System.out.println(allPrincipal);

            List<SessionInformation> allSessions = sessionRegistry.getAllSessions(allPrincipal, false);
            for (SessionInformation allSession : allSessions) {
                System.out.println(allSession);
            }
        }

//        // 获得Spring Security上下文
//        List<HttpSession> sessionList = globalSessionContext.getSessionByUserId(1);
//        if (!CollectionUtils.isEmpty(sessionList)) {
//            for (HttpSession httpSession : sessionList) {
//                SecurityContextImpl securityContextImpl = (SecurityContextImpl) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
//                Authentication authentication = securityContextImpl.getAuthentication();
//
//                List<MenuBo> byUserId = menuDomain.findByUserId(1);
//                MenuBo newMenuBo = new MenuBo();
//                newMenuBo.setPermissionUrl("/api/manage/role/aaaadelete");
//
//                byUserId.add(newMenuBo);
//
//
//                List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//                for (MenuBo menuBo : byUserId) {
//                    if (!StringUtils.isEmpty(menuBo.getPermissionUrl())) {
//                        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(menuBo.getPermissionUrl());
//                        grantedAuthorities.add(grantedAuthority);
//                    }
//                }
//
//                Collection<? extends GrantedAuthority> collection = authentication.getAuthorities();
//                SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("/api/manage/role/aaaadelete");
//                collection.add(grantedAuthority);
//                System.out.println(authentication);
//            }
//
//        }

        List<HttpSession> sessionList = globalSessionContext.getSessionByUserId(1);
        if (!CollectionUtils.isEmpty(sessionList)) {
            for (HttpSession session : sessionList) {
                // 新的权限
                List<MenuBo> byUserId = menuDomain.findByUserId(1);
                MenuBo newMenuBo = new MenuBo();
                newMenuBo.setPermissionUrl("/api/manage/role/aaaadelete");

                byUserId.add(newMenuBo);
                List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
                for (MenuBo menuBo : byUserId) {
                    if (!StringUtils.isEmpty(menuBo.getPermissionUrl())) {
                        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(menuBo.getPermissionUrl());
                        grantedAuthorities.add(grantedAuthority);
                    }
                }

                SecurityContext securityContext = (SecurityContext) session.getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
                Authentication authentication = securityContext.getAuthentication();
                UserBo principal = (UserBo) authentication.getPrincipal();
                principal.setMenuBoList(byUserId);

                // 重新new一个token，因为Authentication中的权限是不可变的.
                UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(
                        principal, authentication.getCredentials(),
                        grantedAuthorities);
                result.setDetails(authentication.getDetails());
                securityContext.setAuthentication(result);
            }
        }
        return new BaseApiResult<Boolean>().success(true);
    }

    @GetMapping("/api/manage/role/delete")
    public BaseApiResult<Boolean> test2() {
        return new BaseApiResult<Boolean>().success(true);
    }

    @GetMapping("/api/manage/role/aaaadelete")
    public BaseApiResult<Boolean> test3() {
        return new BaseApiResult<Boolean>().success(true);
    }

}
