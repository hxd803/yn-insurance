package com.yi.nuo.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yi.nuo.system.entity.Menu;

import java.util.List;

/**
 * <p>
 * 菜单 服务类
 * </p>
 *
 * @author 黄雪冬
 * @since 2020-09-08
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 根据用户获取菜单
     *
     * @param userId
     * @return
     */
    List<Menu> findByUserId(Integer userId);
}
