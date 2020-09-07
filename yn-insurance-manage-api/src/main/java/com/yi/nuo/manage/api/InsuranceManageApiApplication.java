package com.yi.nuo.manage.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.yi.nuo.*"})
@MapperScan(basePackages = "com.yi.nuo.**.mapper")
public class InsuranceManageApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(InsuranceManageApiApplication.class, args);
    }
}
