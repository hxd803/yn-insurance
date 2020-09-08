package com.yi.nuo.manage.api.function.login.controller;

import com.yi.nuo.common.result.BaseApiResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 黄雪冬
 * @version 0.0.1
 * @date 2020/9/8 17:39
 */

@RestController
public class TestController {

    @GetMapping("/api/manage/role/create")
    public BaseApiResult<Boolean> test1() {
        return new BaseApiResult<Boolean>().success(true);
    }

    @GetMapping("/api/manage/role/delete")
    public BaseApiResult<Boolean> test2() {
        return new BaseApiResult<Boolean>().success(true);
    }

    @GetMapping("/api/manage/role/aaaadelete")
    public BaseApiResult<Boolean> test3() {
        return new BaseApiResult<Boolean>().success(true);
    }

}
