package com.yi.nuo.tenant.api.base.security;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

/**
 * 前端用户提交的字段内容
 *
 * @author 黄雪冬
 * @version 0.0.1
 * @date 2020/9/8 13:10
 */
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MyWebAuthenticationDetails extends WebAuthenticationDetails {

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private String validCode;

    @Getter
    @Setter
    private String sessionCodeValue;

    @Getter
    @Setter
    private long sessionCodeTime;

    public MyWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        username = request.getParameter("username");
        password = request.getParameter("password");
        validCode = request.getParameter("validateCode");
    }
}
