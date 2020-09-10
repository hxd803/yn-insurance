package com.yi.nuo.tenant.api.base.security;

import com.yi.nuo.user.bo.MenuBo;
import com.yi.nuo.user.bo.UserBo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author 黄雪冬
 * @version 0.0.1
 * @date 2020/9/10 13:39
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MyUserAuthBo implements Serializable {

    /**
     * 用户信息
     */
    private UserBo userBo;

    /**
     * 所有的菜单信息
     */
    private List<MenuBo> allMenuList;

    /**
     * 用户有权限的菜单信息
     */
    private List<MenuBo> userMenuList;
}
