package com.yi.nuo.manage.api.base.docs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * spring doc 基础属性配置
 *
 * @author 黄雪冬
 * @version 0.0.1
 * @date 2020/9/7 10:47
 */
@Data
@Component
@ConfigurationProperties("springdoc.description")
public class SwaggerProperties implements Serializable {

    /**
     * 项目应用名
     */
    private String applicationName;

    /**
     * 项目版本信息
     */
    private String applicationVersion;

    /**
     * 项目描述信息
     */
    private String applicationDescription;

    /**
     * 接口调试地址
     */
    private String tryHost;
}
