package com.yi.nuo.user.domain;

import com.yi.nuo.common.exception.BusinessException;
import com.yi.nuo.common.util.BeanUtil;
import com.yi.nuo.user.bo.LoginResultBo;
import com.yi.nuo.user.bo.UserBo;
import com.yi.nuo.user.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
    public LoginResultBo login(String userName, String password) {
        // 用户名或密码为空 错误
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            throw new BusinessException("用户名或密码为空");
        }

        UserBo userBo = BeanUtil.convert(userService.getById(1), UserBo.class);

        LoginResultBo loginResultBo = new LoginResultBo();
        loginResultBo.setUser(userBo);

        return loginResultBo;
    }

    @Override
    public UserBo getByUserName(String userName) {
        UserBo userBo = BeanUtil.convert(userService.getByUserName(userName), UserBo.class);
        if (userBo != null) {
            userBo.setMenuBoList(menuDomain.findByUserId(userBo.getId()));
        }
        return userBo;
    }
}
