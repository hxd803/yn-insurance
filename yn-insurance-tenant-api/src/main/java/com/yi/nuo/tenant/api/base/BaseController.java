package com.yi.nuo.tenant.api.base;

import com.yi.nuo.common.exception.BusinessException;
import com.yi.nuo.common.result.BaseApiResult;
import com.yi.nuo.common.util.IpUtil;
import com.yi.nuo.tenant.api.base.security.MyUserAuthBo;
import com.yi.nuo.user.bo.UserBo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 黄雪冬
 * @version 0.0.1
 * @date 2020/9/10 9:01
 */
@Slf4j
public class BaseController {
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public BaseApiResult<String> handleUncaughtException(Exception exception) {
        log.error(exception.getMessage(), exception);
        return new BaseApiResult<String>().error("系统异常,请稍后再试!");
    }

    @ExceptionHandler({BusinessException.class})
    @ResponseBody
    public BaseApiResult<String> handleUncaughtException(BusinessException exception) {
        log.error(exception.getMessage(), exception);
        return new BaseApiResult<String>().error(exception.getMessage());
    }


    @ExceptionHandler({NoHandlerFoundException.class})
    @ResponseBody
    public BaseApiResult<String> noHandlerFoundException(NoHandlerFoundException exception) {
        log.error(exception.getMessage(), exception);
        return new BaseApiResult<String>().error("系统异常,请稍后再试!");
    }

    @ExceptionHandler({AuthenticationException.class})
    @ResponseBody
    public BaseApiResult<String> authenticationException(AuthenticationException exception) {
        log.error(exception.getMessage(), exception);
        return new BaseApiResult<String>().error(exception.getMessage());
    }

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
