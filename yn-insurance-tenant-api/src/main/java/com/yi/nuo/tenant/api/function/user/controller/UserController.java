package com.yi.nuo.tenant.api.function.user.controller;

import com.yi.nuo.common.result.BaseApiResult;
import com.yi.nuo.tenant.api.base.BaseController;
import com.yi.nuo.user.bo.UserBo;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;

/**
 * @author 黄雪冬
 * @version 0.0.1
 * @date 2020/9/10 9:14
 */
@RestController
@RequestMapping("/api/user")
@Tag(name = "UserController", description = "用户信息管理")
public class UserController extends BaseController {

    @GetMapping("/get/current/user")
    public BaseApiResult<UserBo> getCurrentUser() {
        return new BaseApiResult<UserBo>().success(this.getCurrentUserBo());
    }


    @GetMapping("/get/by/id")
    public BaseApiResult<UserBo> getById(@NotEmpty(message = "请输入ID") Integer id) {
        return new BaseApiResult<UserBo>().success(this.getCurrentUserBo());
    }
}
