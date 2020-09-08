package com.yi.nuo.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yi.nuo.system.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 菜单 Mapper 接口
 * </p>
 *
 * @author 黄雪冬
 * @since 2020-09-08
 */
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 根据用户ID获取菜单
     *
     * @param userId
     * @return
     */
    List<Menu> findByUserId(@Param("userId") Integer userId);

}
