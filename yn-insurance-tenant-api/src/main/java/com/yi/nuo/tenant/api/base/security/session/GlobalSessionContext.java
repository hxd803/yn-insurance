package com.yi.nuo.tenant.api.base.security.session;

import com.yi.nuo.user.bo.UserBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author 黄雪冬
 * @version 0.0.1
 * @since 2020/9/8 20:53
 */
@Component
@Slf4j
public class GlobalSessionContext {
    // 用户id与与会话之间映射
    private final HashMap<Integer, List<HttpSession>> sessionMap = new HashMap<>();


    // 会话注册器
    @Resource
    private GlobalSessionRegistry globalSessionRegistry;

    synchronized void add(HttpSession session) {
        if (session != null) {
            SessionInformation sessionInformation = globalSessionRegistry.getSessionInformation(session.getId());
            if (sessionInformation != null) {
                UserBo user = (UserBo) sessionInformation.getPrincipal();
                if (user != null) {
                    List<HttpSession> httpSessions = sessionMap.get(user.getId());
                    if (!CollectionUtils.isEmpty(httpSessions)) {
                        httpSessions.add(session);
                    } else {
                        httpSessions = new ArrayList<>();
                        httpSessions.add(session);
                        sessionMap.put(user.getId(), httpSessions);
                    }

                    log.info("添加session成功 " + sessionMap.size() + " ");
                }
            }
        }
    }

    synchronized void delete(HttpSession session) {
        if (session != null) {
            SessionInformation sessionInformation = globalSessionRegistry.getSessionInformation(session.getId());
            if (sessionInformation != null) {
                UserBo user = (UserBo) sessionInformation.getPrincipal();
                if (user != null) {
                    // 恢复标记使真正退出时可以被删除
                    List<HttpSession> httpSessions = sessionMap.get(user.getId());
                    if (!CollectionUtils.isEmpty(httpSessions)) {
                        httpSessions.removeIf(next -> next.getId().equalsIgnoreCase(session.getId()));
                    }
                    if (CollectionUtils.isEmpty(httpSessions)) {
                        sessionMap.remove(user.getId());
                    }
                    log.debug("删除session成功 " + sessionMap.size() + " ");
                }
            }
        }
    }

    public List<HttpSession> getSessionByUserId(Integer id) {
        return sessionMap.get(id);
    }

}
