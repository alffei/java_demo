package com.gd.shiro;

import lombok.extern.java.Log;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * IniRealm 测试
 */
@Log
public class IniRealmTest {

    @Test
    public void testAuthentication() {
        // 创建Shiro核心管理器：SecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        IniRealm iniRealm = new IniRealm("classpath:realm.ini");
        defaultSecurityManager.setRealm(iniRealm);

        // 创建主体（Subject）
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        // 创建主体Token信息
        UsernamePasswordToken token = new UsernamePasswordToken("andrew", "AAA@111");
        // 主体登录
        subject.login(token);
        log.info(">>>> After login, Subject IsAuthentication: " + subject.isAuthenticated());
        log.info(">>>> Check Roles: " + subject.hasRole("admin"));
        log.info(">>>> Check Permission1: " + subject.isPermitted("dashboard:view"));
        log.info(">>>> Check Permission2: " + subject.isPermitted("dashboard:new"));

        // 主体退出
        subject.logout();
        log.info(">>>> After logout,Subject IsAuthentication: " + subject.isAuthenticated());
    }
}
