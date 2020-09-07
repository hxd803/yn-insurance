package com.yi.nuo.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yi.nuo.system.entity.User;

/**
 * 用户信息 服务类
 *
 * @author 黄雪冬
 * @since 2020-09-07
 */
public interface IUserService extends IService<User> {

    /**
     * 根据用户名获取
     *
     * @param userName
     * @return
     */
    User getByUserName(String userName);
}
