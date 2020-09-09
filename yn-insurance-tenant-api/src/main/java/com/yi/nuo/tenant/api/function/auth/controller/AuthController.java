package com.yi.nuo.tenant.api.function.auth.controller;

import com.yi.nuo.common.result.BaseApiResult;
import com.yi.nuo.system.domain.IUserDomain;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 黄雪冬
 * @version 0.0.1
 * @date 2020/9/8 11:55
 */
@RestController
@RequestMapping("/api/auth")
@Tag(name = "AuthController", description = "测试")
public class AuthController {

    @Resource
    private IUserDomain userDomain;


    @PostMapping("/login")
    @Operation(summary = "登录")
    public BaseApiResult<Boolean> login(@Parameter(description = "姓名", required = true) @RequestParam String username,
                                        @Parameter(description = "密码", required = true) @RequestParam String password) {

        return new BaseApiResult<Boolean>().success(true);
    }

    @PostMapping("/logout")
    @Operation(summary = "登出")
    public BaseApiResult<Boolean> login() {
        return new BaseApiResult<Boolean>().success(true);
    }

    @PostMapping("/captcha/img")
    public BaseApiResult<Boolean> captchaImg() {
        return new BaseApiResult<Boolean>().success(true);
    }

}
