package com.yi.nuo.system.service;

import com.yi.nuo.system.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author 黄雪冬
 * @since 2020-09-08
 */
public interface IUserService extends IService<User> {

    User getByUserName(String userName);
}