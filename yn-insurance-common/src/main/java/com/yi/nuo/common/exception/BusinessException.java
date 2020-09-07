package com.yi.nuo.common.exception;

/**
 * @author 黄雪冬
 * @version 0.0.1
 * @date 2020/9/7 9:21
 */
public class BusinessException extends BaseException {

    public BusinessException() {
        super();
    }

    public BusinessException(String errorMsg) {
        super(errorMsg);
    }

    public BusinessException(int errorCode, String errorMsg) {
        super(errorMsg);
    }

    public BusinessException(String errorMsg, Throwable cause) {
        super(errorMsg, cause);
    }

    public BusinessException(int errorCode, String errorMsg, Throwable cause) {
        super(errorMsg, cause);
    }
}
