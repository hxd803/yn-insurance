package com.yi.nuo.common.result;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 黄雪冬
 * @version 0.0.1
 * @date 2019/8/21 14:16
 */
@Data
public class BaseApiResult<T extends Serializable> implements Serializable {

    private static final String SUCCESS_MESSAGE = "操作成功";

    public static final Integer SUCCESS_CODE = 200;

    public static final Integer ERROR_CODE = 500;

    public static final Integer UNAUTHORIZED = 401;

    private Integer code;
    private String msg;
    private T data;

    public BaseApiResult() {

    }

    public BaseApiResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseApiResult<T> success() {
        return new BaseApiResult<>(SUCCESS_CODE, SUCCESS_MESSAGE, null);
    }

    public BaseApiResult<T> success(T object) {
        return new BaseApiResult<>(SUCCESS_CODE, SUCCESS_MESSAGE, object);
    }

    public BaseApiResult<T> success(String message) {
        return new BaseApiResult<>(SUCCESS_CODE, message, null);
    }

    public BaseApiResult<T> error(String msg) {
        return new BaseApiResult<>(ERROR_CODE, msg, null);
    }


    public BaseApiResult<T> unauthorized(String msg) {
        return new BaseApiResult<>(UNAUTHORIZED, msg, null);
    }
}
