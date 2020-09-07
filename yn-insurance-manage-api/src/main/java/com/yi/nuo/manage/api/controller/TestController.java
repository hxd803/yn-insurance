package com.yi.nuo.manage.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 黄雪冬
 * @version 0.0.1
 * @date 2020/9/7 10:26
 */
@RestController
@RequestMapping("api/test")
public class TestController {


    @GetMapping("get")
    public String test() {
        return "test";
    }

}
