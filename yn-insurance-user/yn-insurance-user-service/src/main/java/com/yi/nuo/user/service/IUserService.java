package com.yi.nuo.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yi.nuo.user.entity.User;

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
