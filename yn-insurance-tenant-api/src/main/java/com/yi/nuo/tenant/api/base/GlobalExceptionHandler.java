package com.yi.nuo.tenant.api.base;

import com.yi.nuo.common.exception.BusinessException;
import com.yi.nuo.common.result.BaseApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ValidationException;

/**
 * @author 黄雪冬
 * @version 0.0.1
 * @since 2020/9/10 22:37
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

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


    @ExceptionHandler(value = ValidationException.class)
    @ResponseBody
    public BaseApiResult<String> handleMethodArgumentNotValidException(ValidationException exception) {
        return new BaseApiResult<String>().error(exception.getMessage());
    }
}
