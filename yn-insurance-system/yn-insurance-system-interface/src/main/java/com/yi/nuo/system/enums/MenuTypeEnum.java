package com.yi.nuo.system.enums;

import com.yi.nuo.common.enums.ContentEnum;

/**
 * 菜单类型（0：菜单，1：按钮，2：数据）
 *
 * @author 黄雪冬
 * @version 0.0.1
 * @date 2020/9/8 10:48
 */
public enum MenuTypeEnum implements ContentEnum {
    /**
     * 单选
     */
    MENU("菜单", 0),
    /**
     * 多选
     */
    BUTTON("按钮", 1),
    /**
     * 判断题
     */
    DATA("数据", 2);

    private final String content;

    private final Integer value;

    MenuTypeEnum(String content, Integer value) {
        this.content = content;
        this.value = value;
    }

    public static MenuTypeEnum getByValue(Integer value) {
        MenuTypeEnum[] types = MenuTypeEnum.values();
        for (MenuTypeEnum type : types) {
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
