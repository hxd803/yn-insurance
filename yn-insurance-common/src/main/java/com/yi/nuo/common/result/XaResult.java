package com.yi.nuo.common.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.yi.nuo.common.page.BasePage;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hchen
 * @version V1.0
 * @Title: XaResult.java
 * @Package com.xa3ti.hhrz.base.entity
 * @Description: Service返回结果统一对象
 * @date 2014年8月13日 下午7:46:23
 */
public class XaResult<T> implements java.io.Serializable {

    private static final long serialVersionUID = -6162800414401807226L;

    private int code = XaConstant.Code.success;

    private String message = XaConstant.Message.success;

    @JsonInclude(Include.NON_NULL)
    private T object = null;

    private Map<String, Object> map = new HashMap<String, Object>();

    @JsonInclude(Include.NON_NULL)
    private BasePage page = null;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public XaResult(String errorMsg) {
        this.message = errorMsg;
        this.code = XaConstant.Code.error;
        this.object = null;
        this.map = new HashMap<String, Object>();
    }

    public XaResult(int code, String message, T object, Map<String, Object> map) {
        this.code = code;
        this.message = message;
        this.object = object;
        this.map = map;
    }


    public XaResult() {
        this.object = null;
        this.map = new HashMap<String, Object>();
    }

    public static <R> XaResult<R> success(R object) {
        XaResult<R> xaResult = new XaResult<R>();
        xaResult.setSuccess(object);
        return xaResult;
    }

    public static <R> XaResult<R> success(R object, Map<String, Object> map) {
        XaResult<R> xaResult = new XaResult<R>();
        xaResult.setSuccess(object);
        xaResult.setMap(map);
        return xaResult;
    }


    public static <R> XaResult<R> success() {
        XaResult<R> xaResult = new XaResult<R>();
        xaResult.setSuccess();
        return xaResult;
    }

    public static <R> XaResult<R> error(String message) {
        XaResult<R> xaResult = new XaResult<R>();
        xaResult.setError(message == null ? "网络不给力" : message);
//        setHeaderCode();
        return xaResult;
    }

    public static <R> XaResult<R> error(String message, R object) {
        XaResult<R> xaResult = new XaResult<R>();
        xaResult.setError(message == null ? "网络不给力" : message);
        xaResult.setObject(object);
//        setHeaderCode();
        return xaResult;
    }

    public static <R> XaResult<R> unlogin() {
        XaResult<R> xaResult = new XaResult<R>();
        xaResult.setCode(XaConstant.Code.unlogin);
        xaResult.setMessage(XaConstant.Message.unlogin);
        return xaResult;
    }

    /**
     * author:gfl
     * email:gfl@cheok.com
     * app需要区分accesstoken 为 null 或 "" 时的未登录
     * 用户无 accesstoken 未登录
     *
     * @param <R>
     * @return
     */
    public static <R> XaResult<R> unloginForNoAccessToken() {
        XaResult<R> xaResult = new XaResult<R>();
        xaResult.setCode(XaConstant.Code.unloginForNoAccessToken);
        xaResult.setMessage(XaConstant.Message.unlogin);
        return xaResult;
    }

    public static <R> XaResult<R> noAuthority() {
        XaResult<R> xaResult = new XaResult<R>();
        xaResult.setCode(XaConstant.Code.error);
        xaResult.setMessage(XaConstant.Message.NOAUTHORITY);
        return xaResult;
    }

    public static <R> XaResult<R> repeat() {
        XaResult<R> xaResult = new XaResult<R>();
        xaResult.setCode(XaConstant.Code.repeat);
        xaResult.setMessage(XaConstant.Message.REPEAT);
        return xaResult;
    }

    public static <R> XaResult<R> unSend() {
        XaResult<R> xaResult = new XaResult<R>();
        xaResult.setCode(XaConstant.Code.error);
        xaResult.setMessage(XaConstant.Message.LIMITSENDVERIFYCODE);
        return xaResult;
    }

    public static <R> XaResult<R> unCheck() {
        XaResult<R> xaResult = new XaResult<R>();
        xaResult.setCode(XaConstant.Code.error);
        xaResult.setMessage(XaConstant.Message.LIMITCHECKVERIFYCODE);
        return xaResult;
    }

    public void setSuccess() {
        this.code = XaConstant.Code.success;
        this.message = XaConstant.Message.success;
    }

    public void setSuccess(T object) {
        this.code = XaConstant.Code.success;
        this.message = XaConstant.Message.success;
        this.object = object;
        this.map = new HashMap<String, Object>();
    }

    public void setError() {
        this.code = XaConstant.Code.error;
        this.message = XaConstant.Message.error;
        this.object = null;
        this.map = new HashMap<String, Object>();
    }

    public void setError(String message) {
        this.code = XaConstant.Code.error;
        this.message = message;
        this.object = null;
        this.map = new HashMap<String, Object>();
    }

    public void setError(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.object = null;
        this.map = new HashMap<String, Object>();
    }


//    /**
//     * 设置头信息
//     *
//     * @return
//     */
//    public static void setHeaderCode() {
//        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
//        response.setHeader("reCode", "0");
//    }

    public BasePage getPage() {
        return page;
    }

    public void setPage(BasePage page) {
        this.page = page;
    }

}
