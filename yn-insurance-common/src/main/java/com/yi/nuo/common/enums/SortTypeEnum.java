package com.yi.nuo.common.enums;

/**
 * 通用的排序枚举
 *
 * @author 黄雪冬
 * @version 0.0.1
 * @date 2020/3/13 10:33
 */
public enum SortTypeEnum implements ContentEnum {
    /**
     * 正序
     */
    ASC("正序", 0),

    /**
     * 倒叙
     */
    DESC("倒叙", 1);

    private final String content;

    private final Integer value;

    SortTypeEnum(String content, Integer value) {
        this.content = content;
        this.value = value;
    }

    public static SortTypeEnum getByValue(Integer value) {
        SortTypeEnum[] types = SortTypeEnum.values();
        for (SortTypeEnum type : types) {
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
