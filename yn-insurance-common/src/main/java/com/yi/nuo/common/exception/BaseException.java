package com.yi.nuo.common.exception;

/**
 * @author 黄雪冬
 * @version 0.0.1
 * @date 2020/9/7 9:20
 */
public class BaseException extends RuntimeException {
    
    public BaseException() {
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }
}
