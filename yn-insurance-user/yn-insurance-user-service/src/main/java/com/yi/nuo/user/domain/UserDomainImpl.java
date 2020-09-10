package com.yi.nuo.user.domain;

import com.yi.nuo.common.util.BeanUtil;
import com.yi.nuo.user.bo.UserBo;
import com.yi.nuo.user.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 黄雪冬
 * @version 0.0.1
 * @since 2020/9/7 20:57
 */
@Service
public class UserDomainImpl implements IUserDomain {

    @Resource
    private IMenuDomain menuDomain;

    @Resource
    private IUserService userService;

    @Override
    public UserBo getByLoginName(String loginName) {
        return BeanUtil.convert(userService.getByLoginName(loginName), UserBo.class);
    }
}
