package com.yi.nuo.tenant.service.impl;

import com.yi.nuo.tenant.entity.Tenant;
import com.yi.nuo.tenant.mapper.TenantMapper;
import com.yi.nuo.tenant.service.ITenantService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 租户管理 服务实现类
 * </p>
 *
 * @author 黄雪冬
 * @since 2020-09-10
 */
@Service
public class TenantServiceImpl extends ServiceImpl<TenantMapper, Tenant> implements ITenantService {

}
