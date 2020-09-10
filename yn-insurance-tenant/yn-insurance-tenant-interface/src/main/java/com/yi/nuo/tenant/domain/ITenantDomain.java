package com.yi.nuo.tenant.domain;

import com.yi.nuo.tenant.bo.TenantBo;

/**
 * @author 黄雪冬
 * @version 0.0.1
 * @since 2020/9/10 20:57
 */
public interface ITenantDomain {


    /**
     * 根据ID获取
     *
     * @param id
     * @return
     */
    TenantBo getById(Integer id);
}
