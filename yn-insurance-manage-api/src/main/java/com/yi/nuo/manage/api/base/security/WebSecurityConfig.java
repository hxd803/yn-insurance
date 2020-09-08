package com.yi.nuo.manage.api.base.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * spring security配置
 * <p>
 * https://juejin.im/post/6844903970159198216
 *
 * @author 黄雪冬
 * @version 0.0.1
 * @date 2020/9/7 14:16
 */
@Configuration
@EnableWebSecurity
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> authenticationDetailsSource;

    @Resource
    private MyAuthenticationProvider myAuthenticationProvider;


    /**
     * 开放访问的请求
     */
    private static final String[] PERMIT_ALL_MAPPING = {
            "/api/auth/**",
            "/springdoc/**"
    };

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(myAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //匹配规则，在匹配规则路径下的内容可以不用登录
        http.authorizeRequests()
                .antMatchers(PERMIT_ALL_MAPPING)
                .permitAll();

        //自定义未登录返回内容，自定义权限不足返回内容
        http.exceptionHandling()
                .authenticationEntryPoint(new MyAuthenticationEntryPoint())
                .accessDeniedHandler(new MyAccessDeniedHandler());

        //登录内容配置
        http.formLogin()
                //配置登录接口
                .loginPage("/api/auth/login")
                .successHandler(new MyAuthSuccessHandler())
                .failureHandler(new MyAuthFailedHandler())
                .authenticationDetailsSource(authenticationDetailsSource);

        //登出内容配置
        http.logout()
                .logoutUrl("/api/auth/logout")
                .logoutSuccessHandler(new MyLogoutSuccessHandler());


        //关闭CSRF保护，允许跨域访问
        http.csrf().disable();
    }
}
