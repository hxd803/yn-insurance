package com.yi.nuo.user.bo;

import com.yi.nuo.common.util.BeanUtil;
import com.yi.nuo.user.enums.UserStateEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 黄雪冬
 * @version 0.0.1
 * @since 2020/9/7 20:20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserBo implements Serializable, BeanUtil.ConversionCustomize {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 租户ID
     */
    private Integer tenantId;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 姓名
     */
    private String username;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐加密
     */
    private String salt;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 部门
     */
    private String department;

    /**
     * 状态（0停用,1启用,2删除）
     */
    private UserStateEnum state;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    @Override
    public void convertOthers(Object o) {
        Object object = BeanUtil.getPropValue(o, "state");
        if (object instanceof Integer) {
            this.state = UserStateEnum.getByValue((Integer) object);
        }
    }
}
