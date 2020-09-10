package com.yi.nuo.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yi.nuo.user.entity.Role;
import com.yi.nuo.user.mapper.RoleMapper;
import com.yi.nuo.user.service.IRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author 黄雪冬
 * @since 2020-09-08
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
