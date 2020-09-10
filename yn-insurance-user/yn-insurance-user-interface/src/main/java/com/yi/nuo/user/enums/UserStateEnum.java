package com.yi.nuo.user.enums;

import com.yi.nuo.common.enums.ContentEnum;

/**
 * 用户状态
 *
 * @author 黄雪冬
 * @version 0.0.1
 * @since 2020/9/10 21:26
 */
public enum UserStateEnum implements ContentEnum {
    /**
     * 停用
     */
    DISABLE("停用", 0),
    /**
     * 启用
     */
    ENABLE("启用", 1),
    /**
     * 删除
     */
    DELETED("删除", -1);

    private final String content;

    private final Integer value;

    UserStateEnum(String content, Integer value) {
        this.content = content;
        this.value = value;
    }

    public static UserStateEnum getByValue(Integer value) {
        UserStateEnum[] types = UserStateEnum.values();
        for (UserStateEnum type : types) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        return null;
    }

    @Override
    public String getContent() {
        return this.content;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }
}
