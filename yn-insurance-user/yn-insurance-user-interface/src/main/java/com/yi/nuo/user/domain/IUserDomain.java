package com.yi.nuo.user.domain;


import com.yi.nuo.user.bo.UserBo;

/**
 * @author 黄雪冬
 * @version 0.0.1
 * @since 2020/9/7 20:52
 */
public interface IUserDomain {


    /**
     * 根据用户名获取
     *
     * @param userName
     * @return
     */
    UserBo getByUserName(String userName);

}
