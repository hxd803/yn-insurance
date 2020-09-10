package com.yi.nuo.user.bo;

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
public class UserBo implements Serializable {

    /**
     * id
     */
    private Integer id;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 姓名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 职位
     */
    private String position;

    /**
     * 部门
     */
    private String department;

    /**
     * 所属组织
     */
    private Integer organizationId;

    /**
     * 所属组织名称
     */
    private String organizationName;

    /**
     * 状态（0停用,1启用,2删除）
     */
    private Integer state;

    /**
     * 账号类型（0：超级管理员，1：管理员，2：普通账号）
     */
    private Integer type;

    /**
     * 盐加密
     */
    private String salt;

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

}
