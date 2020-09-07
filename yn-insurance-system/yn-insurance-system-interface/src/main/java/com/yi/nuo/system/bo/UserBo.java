package com.yi.nuo.system.bo;

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

    private Integer id;

    private String userName;

    private String realName;

    private String password;

    private String phone;

    private Integer status;

    private LocalDateTime createTime;

    private LocalDateTime modifyTime;
}
