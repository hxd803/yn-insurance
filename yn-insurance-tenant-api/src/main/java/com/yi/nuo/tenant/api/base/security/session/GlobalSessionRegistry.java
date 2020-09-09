package com.yi.nuo.tenant.api.base.security.session;

import com.yi.nuo.system.bo.UserBo;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 黄雪冬
 * @version 0.0.1
 * @since 2020/9/8 20:53
 */
@Component
public class GlobalSessionRegistry extends SessionRegistryImpl {


    /**
     * 获得用户Session信息
     *
     * @param userBo 用户信息
     */
    private List<SessionInformation> getSessionInformationList(UserBo userBo) {
        // 获取父类会话注册器Session主体
        List<Object> users = this.getAllPrincipals();
        for (Object principal : users) {
            if (principal instanceof UserBo) {

                final UserBo loggedUser = (UserBo) principal;
                if (userBo.getId().equals(loggedUser.getId())) {
                    // 返回该用户全部Session信息
                    return this.getAllSessions(principal, false);
                }
            }
        }
        return null;
    }

}
