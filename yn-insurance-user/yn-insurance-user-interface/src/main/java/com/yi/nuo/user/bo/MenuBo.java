package com.yi.nuo.user.bo;

import com.yi.nuo.common.util.BeanUtil;
import com.yi.nuo.user.enums.MenuTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 菜单
 * </p>
 *
 * @author 黄雪冬
 * @since 2020-09-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MenuBo implements Serializable, BeanUtil.ConversionCustomize {


    private Integer id;

    /**
     * 上级ID
     */
    private Integer parentId;

    /**
     * 编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 菜单类型（0：菜单，1：按钮，2：数据）
     */
    private MenuTypeEnum type;

    /**
     * 权限url
     */
    private String permissionUrl;

    /**
     * 是否删除
     */
    private Boolean isDelete;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;


    @Override
    public void convertOthers(Object o) {
        Object object = BeanUtil.getPropValue(o, "type");
        if (object instanceof Integer) {
            this.type = MenuTypeEnum.getByValue((Integer) object);
        }
    }
}
