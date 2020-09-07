package com.yi.nuo.common.enums;


/**
 * @author hxd
 */
public interface ContentEnum {

    /**
     * 获取枚举内容
     *
     * @return
     */
    String getContent();

    /**
     * 获取枚举值
     *
     * @return
     */
    Integer getValue();

    /**
     * 判断是否相等
     *
     * @param value
     * @return
     */
    default boolean equalsValue(Integer value) {
        return value != null && value.equals(this.getValue());
    }


}
