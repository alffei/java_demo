package com.gd.shiro;

import lombok.extern.java.Log;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

/**
 * 认证、授权流程Demo
 * <p>
 * Doc:
 * Authentication: https://shiro.apache.org/authentication.html#Authentication-sequence
 * Authorization: https://shiro.apache.org/authorization.html#Authorization-sequence
 */
@Log
public class SimpleAccountRealmTest {

    /**
     * Using a set of configured user accounts and roles to support authentication and authorization
     * Each account entry specifies the username, password, and roles for a user. account { username, password, roles }
     * Roles can also be mapped to permissions and associated with users. role { permissions }
     */
    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();


    @Before
    public void addAccount() {
        simpleAccountRealm.addAccount("andrew", "AAA@111", "admin");
    }

    @Test
    public void testAuthentication() {
        // 创建Shiro核心管理器：SecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        // 创建主体（Subject）
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        // 创建主体Token信息
        UsernamePasswordToken token = new UsernamePasswordToken("andrew", "AAA@111");
        // 主体登录
        subject.login(token);
        log.info(">>>> After login, Subject IsAuthentication: " + subject.isAuthenticated());
        log.info(">>>> Check Roles: " + subject.hasRole("admin"));

        // 主体退出
        subject.logout();
        log.info(">>>> After logout,Subject IsAuthentication: " + subject.isAuthenticated());
    }

}
