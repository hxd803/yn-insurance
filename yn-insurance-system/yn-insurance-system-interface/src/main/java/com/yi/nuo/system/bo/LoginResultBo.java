package com.yi.nuo.system.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author 黄雪冬
 * @version 0.0.1
 * @date 2019/8/23 9:49
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LoginResultBo implements Serializable {

    /**
     * 用户
     */
    public UserBo user;

    /**
     * token
     */
    public String token;

}
