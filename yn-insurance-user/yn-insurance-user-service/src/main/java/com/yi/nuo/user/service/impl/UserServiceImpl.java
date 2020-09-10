package com.yi.nuo.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yi.nuo.user.entity.User;
import com.yi.nuo.user.enums.UserStateEnum;
import com.yi.nuo.user.mapper.UserMapper;
import com.yi.nuo.user.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author 黄雪冬
 * @since 2020-09-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User getByLoginName(String loginName) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getLoginName, loginName)
                .ne(User::getState, UserStateEnum.DELETED.getValue());

        List<User> users = baseMapper.selectList(wrapper);
        if (CollectionUtils.isEmpty(users)) {
            return null;
        } else {
            return users.get(0);
        }
    }
}
