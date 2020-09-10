package com.yi.nuo.user.domain;

import com.yi.nuo.user.bo.MenuBo;

import java.util.List;

/**
 * @author 黄雪冬
 * @version 0.0.1
 * @date 2020/9/8 10:43
 */
public interface IMenuDomain {

    /**
     * 根据用户ID获取
     *
     * @param userId
     * @return
     */
    List<MenuBo> findByUserId(Integer userId);
}
