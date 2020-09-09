package com.yi.nuo.tenant.api.base.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 自定义验证码错误
 *
 * @author 黄雪冬
 * @version 0.0.1
 * @since 2020/9/9 23:29
 */
public class ValidCodeErrorException extends AuthenticationException {
    public ValidCodeErrorException(String msg, Throwable t) {
        super(msg, t);
    }

    public ValidCodeErrorException(String msg) {
        super(msg);
    }
}
