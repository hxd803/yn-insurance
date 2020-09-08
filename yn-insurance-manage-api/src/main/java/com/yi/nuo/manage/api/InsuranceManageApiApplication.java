package com.yi.nuo.manage.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * springboot 启动类
 *
 * @author 黄雪冬
 * @version 0.0.1
 * @since 2020/9/7 21:12
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.yi.nuo.*"})
@MapperScan(basePackages = "com.yi.nuo.**.mapper")
@ServletComponentScan
public class InsuranceManageApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(InsuranceManageApiApplication.class, args);
    }
}
