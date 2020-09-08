package com.yi.nuo.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yi.nuo.system.entity.Menu;
import com.yi.nuo.system.mapper.MenuMapper;
import com.yi.nuo.system.service.IMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单 服务实现类
 * </p>
 *
 * @author 黄雪冬
 * @since 2020-09-08
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Override
    public List<Menu> findByUserId(Integer userId) {
        return baseMapper.findByUserId(userId);
    }
}
