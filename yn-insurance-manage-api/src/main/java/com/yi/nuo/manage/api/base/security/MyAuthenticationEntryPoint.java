package com.yi.nuo.manage.api.base.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yi.nuo.common.result.BaseApiResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 匿名用户无权访问
 *
 * @author 黄雪冬
 * @version 0.0.1
 * @date 2020/9/8 14:18
 */
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(new BaseApiResult<String>().unauthorized("登录超时，请重新登录!"));

        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("text/javascript;charset=utf-8");
        httpServletResponse.getWriter().print(s);
    }
}
