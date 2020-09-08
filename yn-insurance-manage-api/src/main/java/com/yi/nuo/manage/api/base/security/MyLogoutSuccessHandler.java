package com.yi.nuo.manage.api.base.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yi.nuo.common.result.BaseApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 黄雪冬
 * @version 0.0.1
 * @date 2020/9/8 15:13
 */
@Slf4j
public class MyLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        BaseApiResult<String> success = new BaseApiResult<String>().success();
        success.setMsg("登出成功");
        String s = new ObjectMapper().writeValueAsString(success);

        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write(s);
        out.flush();
        out.close();
    }
}
