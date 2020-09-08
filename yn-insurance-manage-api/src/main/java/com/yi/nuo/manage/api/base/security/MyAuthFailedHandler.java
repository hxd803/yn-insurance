package com.yi.nuo.manage.api.base.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yi.nuo.common.result.BaseApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 黄雪冬
 * @version 0.0.1
 * @date 2020/9/8 15:01
 */
@Slf4j
public class MyAuthFailedHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String s = new ObjectMapper().writeValueAsString(new BaseApiResult<String>().unauthorized("登录失败，请检查用户名、密码或验证码是否正确"));
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        PrintWriter out = response.getWriter();
        out.write(s);
        out.flush();
        out.close();
    }

}
