package com.yi.nuo.common.result;

/**
 * @author hchen
 * @version V1.0
 * @Title: XaConstant.java
 * @Package com.xa3ti.shengmilu.base.constant
 * @Description: 常量类
 * @date 2014年8月2日 上午10:07:48
 */
public class XaConstant {

    /**
     * @author hchen
     * @ClassName: UserStatus
     * @Description: 后台用户状态常量
     * @date 2014年8月2日 上午10:10:09
     */
    public static class UserStatus {
        /**
         * @Fields status_normal : 正常
         */
        public static final int status_normal = 1;
        /**
         * @Fields status_lock : 锁定或禁用
         */
        public static final int status_lock = 0;
        /**
         * @Fields status_delete : 已删除
         */
        public static final int status_delete = 9;

    }

    /**
     * @author hchen
     * @ClassName: RoleStatus
     * @Description: 角色的状态
     * @date 2014年8月2日 上午10:53:08
     */
    public static class RoleStatus {
        /**
         * @Fields status_normal : 正常
         */
        public static final int status_normal = 1;
        /**
         * @Fields status_delete : 已删除
         */
        public static final int status_delete = 0;
    }

    /**
     * @author hchen
     * @ClassName: ResourcesStatus
     * @Description: 资源的状态
     * @date 2014年8月2日 上午11:14:46
     */
    public static class ResourcesStatus {
        /**
         * @Fields status_normal : 正常
         */
        public static final int status_normal = 1;
        /**
         * @Fields status_delete : 已删除
         */
        public static final int status_delete = 0;
    }

    /**
     * @author hchen
     * @ClassName: ResourceShowType
     * @Description: 资源级别
     * @date 2014年8月8日 下午2:23:32
     */
    public static class ResourceShowType {
        /**
         * @Fields page_level : 页面级资源
         */
        public static final int page_level = 0;
        /**
         * @Fields menu_level : 菜单级资源
         */
        public static final int menu_level = 2;
        /**
         * @Fields button_level : 按钮级资源
         */
        public static final int button_level = 1;
    }

    public static class SessionKey {

        /**
         * @Fields currentUser : session中存放和获取当前用户信息的key
         */
        public static final String currentUser = "currentUser";

        /**
         * @Fields currentMenuData : session中存放和获取当前用户菜单的key
         */
        public static final String currentMenuData = "currentMenuData";

        /**
         * @Fields currentMessageList : 发消息的队列
         */
        public static final String currentMessageList = "messageUserList";
    }

    /**
     * @author hchen
     * @ClassName: Status
     * @Description: 常用状态类型
     * @date 2014年8月13日 下午2:45:25
     */
    public static class Status {
        /**
         * @Fields locked : 锁定状态
         */
        public static final int locked = -1;

        /**
         * @Fields invalid : 无效状态
         */
        public static final int invalid = 0;

        /**
         * @Fields valid : 有效/正常状态
         */
        public static final int valid = 1;

        /**
         * @Fields publish : 发布
         */
        public static final int publish = 2;

        /**
         * @Fields delete : 删除
         */
        public static final int delete = 3;

        /**
         * @Fields publish : 预发布
         */
        public static final int prePublish = 4;
    }

    /**
     * @author hchen
     * @ClassName: Code
     * @Description: xaResult的code
     * @date 2014年8月15日 下午5:34:20
     */
    public static final class Code {
        /**
         * @Fields ok : 成功
         */
        public static final int success = 1;
        /**
         * @Fields error : 失败
         */
        public static final int error = 0;
        /**
         * @Fields unlogin : 未登陆
         */
        public static final int unlogin = 401;

        /**
         * 用户无accessToken 未登录
         */
        public static final int unloginForNoAccessToken = 402;

        /**
         * APP 重复提交
         */
        public static final int repeat = 3;
        /**
         * token失效
         */
        public static final int code_failure_token = 101;
        /**
         * fresh_token失效
         */
        public static final int code_failure_fresh_token = 102;

        public static final int code_system_failure = 10001;

        public static final int code_business_failure = 20001;

        public static final int code_validation_failure = 30001;

        public static final int code_database_failure = 40001;

        public static final int code_json_failure = 50001;
    }

    /**
     * @author hchen
     * @ClassName: Message
     * @Description: xaResult的message
     * @date 2014年8月15日 下午5:34:20
     */
    public static final class Message {
        /**
         * @Fields ok : 成功
         */
        public static final String success = "成功!";
        /**
         * @Fields error : 失败
         */
        public static final String error = "系统错误!";
        /**
         * @Fields unlogin : 未登陆
         */
        public static final String unlogin = "请登录后再尝试！";
        public static final String object_not_find = "找不到要操作的记录!";
        public static final String NOAUTHORITY = "您无权操作该功能！";
        public static final String REPEAT = "请勿重复提交";
        public static final String LIMITSENDVERIFYCODE = "您使用验证码次数已达上限，请稍后再试";
        public static final String LIMITCHECKVERIFYCODE = "您使用验证码次数已达上限，请稍后再试";
    }


    /**
     * 登录请求
     *
     * @author zj
     */
    public static class Login {
        /**
         * web登录请求
         */
        public static final int REQUEST_TYPE_WEB = 0;
        /**
         * 手机终端登录请求,可根据需要更改为其他如wap登录请求等
         */
        public static final int REQUEST_TYPE_MOBILE = 1;
        /**
         * login.html登录请求时请求方式的参数,和j_username,j_password一样不可指定其他名称
         */
        public static final String SPRING_REQUEST_KEY = "SPRING_REQUEST_KEY";
    }

    public static class applyStatus {
        /**
         * 暂存
         */
        public static final int zancun = 0;
        /**
         * 保存
         */
        public static final int baocun = 1;
        /**
         * 提交
         */
        public static final int tijiao = 2;
        /**
         * 审核中
         */
        public static final int shenhezhong = 3;
        /**
         * 审核完成
         */
        public static final int shenhewancheng = 4;
    }

    public static class amountReturnPhotoType {

        public static final int pingzheng = 0;
    }


    public static final String key = "123456789";

    public static final class Account {
        //还款
        public final static Integer REPAYMENT = 0;
        //P2P入账
        public final static Integer P2P = 1;
        //保证金/充值
        public final static Integer RECHANGE = 2;
    }

}
