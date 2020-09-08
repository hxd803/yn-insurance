package com.yi.nuo.manage.api.function.login.controller;

import com.yi.nuo.common.result.BaseApiResult;
import com.yi.nuo.system.domain.IUserDomain;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 黄雪冬
 * @version 0.0.1
 * @since 2020/9/7 21:12
 */
@RestController
@RequestMapping("/api")
public class LoginController {


    @Resource
    private IUserDomain userDomain;


    @PostMapping("login")
    public BaseApiResult<Boolean> login(String userName, String password) {

        return new BaseApiResult<Boolean>().success(true);
    }

}
