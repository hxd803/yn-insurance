package com.yi.nuo.tenant.api.function.user.controller;

import com.yi.nuo.common.result.BaseApiResult;
import com.yi.nuo.tenant.api.base.BaseController;
import com.yi.nuo.user.bo.MenuBo;
import com.yi.nuo.user.domain.IMenuDomain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 黄雪冬
 * @version 0.0.1
 * @date 2020/9/10 14:47
 */
@RestController
@RequestMapping("/api/menu")
public class MenuController extends BaseController {

    @Resource
    private IMenuDomain menuDomain;

    @GetMapping("/list")
    public BaseApiResult<List<MenuBo>> findList() {
        return new BaseApiResult<List<MenuBo>>().success(menuDomain.findAll());
    }

}
