package com.gd.shiro;

import com.gd.shiro.realm.CustomRealm;
import lombok.extern.java.Log;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * 自定义Realm 测试
 */
@Log
public class CustomerRealmTest {

    @Test
    public void testAuthentication() {
        // 创建Shiro核心管理器：SecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        CustomRealm customRealm = new CustomRealm();
        defaultSecurityManager.setRealm(customRealm);

        // Hash匹配器
        // HashedCredentialsMatcher matcher = new HashedCredentialsMatcher("md5");
        // matcher.setHashIterations(1);
        // customRealm.setCredentialsMatcher(matcher);

        // 创建主体（Subject）
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        // 创建主体Token信息
        UsernamePasswordToken token = new UsernamePasswordToken("andrew", "123456");
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
