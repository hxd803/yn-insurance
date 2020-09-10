package com.yi.nuo.tenant.api.function.auth.controller;

import com.wf.captcha.SpecCaptcha;
import com.yi.nuo.common.result.BaseApiResult;
import com.yi.nuo.tenant.api.base.constant.SessionConstant;
import com.yi.nuo.user.domain.IUserDomain;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 黄雪冬
 * @version 0.0.1
 * @date 2020/9/8 11:55
 */
@RestController
@RequestMapping("/api/auth")
@Tag(name = "AuthController", description = "登录鉴权")
public class AuthController {


    @Resource
    private IUserDomain userDomain;


    @PostMapping("/login")
    @Operation(summary = "登录")
    public BaseApiResult<Boolean> login(@Parameter(description = "姓名", required = true) @RequestParam String username,
                                        @Parameter(description = "密码", required = true) @RequestParam String password,
                                        @Parameter(description = "验证码", required = true) @RequestParam String validateCode) {

        return new BaseApiResult<Boolean>().success(true);
    }

    @PostMapping("/logout")
    @Operation(summary = "登出")
    public BaseApiResult<Boolean> login() {
        return new BaseApiResult<Boolean>().success(true);
    }

    @GetMapping("/captcha/img")
    @Operation(summary = "获取验证码")
    public void captchaImg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 4);
        String verCode = specCaptcha.text().toLowerCase();
        HttpSession session = request.getSession();
        session.setAttribute(SessionConstant.CAPTURE_SESSION_KEY, verCode);
        response.setContentType("image/png");

        ServletOutputStream outputStream = response.getOutputStream();
        specCaptcha.out(outputStream);
        outputStream.flush();
        outputStream.close();
    }

}
