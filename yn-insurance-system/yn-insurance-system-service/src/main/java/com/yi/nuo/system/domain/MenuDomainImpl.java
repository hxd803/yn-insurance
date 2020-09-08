package com.yi.nuo.system.domain;

import com.yi.nuo.common.util.BeanUtil;
import com.yi.nuo.system.bo.MenuBo;
import com.yi.nuo.system.service.IMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 黄雪冬
 * @version 0.0.1
 * @date 2020/9/8 16:03
 */
@Service
public class MenuDomainImpl implements IMenuDomain {

    @Resource
    private IMenuService menuService;

    @Override
    public List<MenuBo> findByUserId(Integer userId) {
        return BeanUtil.convertList(menuService.findByUserId(userId), MenuBo.class);
    }
}
