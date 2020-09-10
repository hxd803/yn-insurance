package com.yi.nuo.tenant.api.base.security.handler;

import com.yi.nuo.tenant.api.base.security.MyUserAuthBo;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author 黄雪冬
 * @version 0.0.1
 * @since 2020/9/8 19:00
 */
@Component
public class MyAccessDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) {

        if (authentication.getPrincipal() instanceof MyUserAuthBo) {
            //获取到当前用户的注册信息
            MyUserAuthBo myUserAuthBo = (MyUserAuthBo) authentication.getPrincipal();
            for (ConfigAttribute ca : collection) {
                //如果有配置了菜单，那么对权限做验证，如果没有配置，直接放行
                if (myUserAuthBo.getAllMenuList().stream().anyMatch(item -> item.getPermissionUrl().equalsIgnoreCase(ca.getAttribute()))) {
                    Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
                    for (GrantedAuthority authority : authorities) {
                        // 只要包含其中一个角色即可访问
                        if (authority.getAuthority().equals(ca.getAttribute())) {
                            return;
                        }
                    }
                } else {
                    return;
                }
            }
        }

        throw new AccessDeniedException("权限不足，请联系管理员分配权限");

    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return false;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
