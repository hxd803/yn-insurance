package com.yi.nuo.tenant.api.base;

import com.yi.nuo.common.util.IpUtil;
import com.yi.nuo.tenant.api.base.security.MyUserAuthBo;
import com.yi.nuo.user.bo.UserBo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 黄雪冬
 * @version 0.0.1
 * @date 2020/9/10 9:01
 */
@Slf4j
public class BaseController {


    public HttpServletRequest getRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        return ((ServletRequestAttributes) requestAttributes).getRequest();
    }

    public HttpServletResponse getResponse() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        return ((ServletRequestAttributes) requestAttributes).getResponse();
    }


    protected String getIp() {
        String ip = IpUtil.getIp(this.getRequest());
        return StringUtils.isNotEmpty(ip) ? ip : null;
    }

    protected Integer getCurrentUserId() {
        UserBo currentUserBo = getCurrentUserBo();
        return currentUserBo == null ? null : currentUserBo.getId();
    }

    protected UserBo getCurrentUserBo() {
        MyUserAuthBo myUserAuthBo = (MyUserAuthBo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (myUserAuthBo != null) {
            return myUserAuthBo.getUserBo();
        } else {
            return null;
        }
    }

}
