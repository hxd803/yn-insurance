package com.yi.nuo.common.util;


import com.yi.nuo.common.exception.BaseException;
import com.yi.nuo.common.page.BasePage;
import org.springframework.util.CollectionUtils;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * bean util
 *
 * @author 黄雪冬
 * @date 2019-02-25
 */
public class BeanUtil {

    public static <T extends Serializable> BasePage<T> convertPage(BasePage<?> sourcePage, Class<T> clazz) {
        if (sourcePage == null) {
            return null;
        }
        List<T> targetList = convertList(sourcePage.getList(), clazz);
        return new BasePage<>(sourcePage.getPageNum(), sourcePage.getPageSize(), targetList, sourcePage.getTotal());
    }

    /**
     * 转换一个List
     */
    public static <T> List<T> convertList(List<?> list, Class<T> targetClass) {
        if (CollectionUtils.isEmpty(list)) {
            return new ArrayList<>();
        }
        List<T> listDest = new ArrayList<>();
        for (Object source : list) {
            T target = convert(source, targetClass);
            listDest.add(target);
        }
        return listDest;
    }

    /**
     * 转换一个
     */
    public static <T> T convert(Object source, Class<T> targetClass) {
        if (source == null) {
            return null;
        }
        try {
            T result = targetClass.newInstance();
            copyProperties(source, result);
            return result;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BaseException(e);
        }
    }

    /**
     * 复制属性
     */
    public static void copyProperties(Object source, Object target) {
        org.springframework.beans.BeanUtils.copyProperties(source, target);
        if (target instanceof ConversionCustomize) {
            ((ConversionCustomize) target).convertOthers(source);
        }
    }

    /**
     * 获取一个私有属性的值，注意：不考虑私有方法和私有类
     */
    public static Object getPropValue(Object obj, String prop) {
        if (obj == null || prop == null) {
            return null;
        }
        PropertyDescriptor propertyDescriptor = org.springframework.beans.BeanUtils.getPropertyDescriptor(obj.getClass(), prop);
        try {
            Method readMethod = propertyDescriptor.getReadMethod();
            return readMethod.invoke(obj);
        } catch (Exception e) {
            return null;
        }
    }


    public interface ConversionCustomize {
        /**
         * 其它无法通过copyProperties获取的属性通过继承实现这个方法手工处理
         *
         * @param srcObj
         */
        void convertOthers(Object srcObj);
    }
}
