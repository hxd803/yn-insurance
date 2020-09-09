package com.yi.nuo.tenant.api.base.security.handler;

import com.yi.nuo.tenant.api.base.security.WebSecurityConfig;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;

/**
 * @author 黄雪冬
 * @version 0.0.1
 * @since 2020/9/8 18:59
 */
@Component
public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();


    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        // 获取当前请求url
        String requestUrl = ((FilterInvocation) o).getRequestUrl();

        for (String s : WebSecurityConfig.PERMIT_ALL_MAPPING) {
            if (antPathMatcher.match(s, requestUrl)) {
                return null;
            }
        }

        // 如果数据中没有找到相应url资源则为非法访问，要求用户登录再进行操作
        return SecurityConfig.createList(requestUrl);

    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
