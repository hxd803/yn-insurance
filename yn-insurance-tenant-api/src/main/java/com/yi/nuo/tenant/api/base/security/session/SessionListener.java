package com.yi.nuo.tenant.api.base.security.session;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * @author 黄雪冬
 * @version 0.0.1
 * @since 2020/9/8 21:08
 */
@WebListener
@Slf4j
public class SessionListener implements HttpSessionAttributeListener {

    @Resource
    private GlobalSessionContext globalSessionContext;

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        log.debug("添加session");
        globalSessionContext.add(se.getSession());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        log.debug("删除session");
        globalSessionContext.delete(se.getSession());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        log.debug("session属性变更");
    }
}
