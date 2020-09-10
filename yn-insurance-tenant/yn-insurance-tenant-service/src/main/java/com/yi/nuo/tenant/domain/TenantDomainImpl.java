package com.yi.nuo.tenant.domain;

import com.yi.nuo.common.util.BeanUtil;
import com.yi.nuo.tenant.bo.TenantBo;
import com.yi.nuo.tenant.service.ITenantService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 黄雪冬
 * @version 0.0.1
 * @since 2020/9/10 20:58
 */
@Service
public class TenantDomainImpl implements ITenantDomain {


    @Resource
    private ITenantService tenantService;


    @Override
    public TenantBo getById(Integer id) {
        return BeanUtil.convert(tenantService.getById(id), TenantBo.class);
    }
}
