package com.yi.nuo.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yi.nuo.user.entity.User;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author 黄雪冬
 * @since 2020-09-10
 */
public interface IUserService extends IService<User> {

    /**
     * 根据用户名称获取
     *
     * @param loginName
     * @return
     */
    User getByLoginName(String loginName);

}
