package com.yi.nuo.manage.api.base.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yi.nuo.common.result.BaseApiResult;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录用户无权访问
 *
 * @author 黄雪冬
 * @version 0.0.1
 * @date 2020/9/8 14:22
 */
public class MyAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(new BaseApiResult<String>().unauthorized("没有访问权限!"));

        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("text/javascript;charset=utf-8");
        httpServletResponse.getWriter().print(s);
    }
}
