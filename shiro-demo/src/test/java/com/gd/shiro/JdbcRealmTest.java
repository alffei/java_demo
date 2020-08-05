package com.gd.shiro;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.java.Log;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * JdbcRealm 测试
 */
@Log
public class JdbcRealmTest {

    protected static final String CUSTOMER_AUTHENTICATION_QUERY = "select password from my_users where name = ?";
    DruidDataSource dataSource = new DruidDataSource();

    {
        dataSource.setUrl("jdbc:mysql://xxx:3306/jdbc_realm_test?useSSL=true");
        dataSource.setUsername("xxx");
        dataSource.setPassword("xxx");
    }

    @Test
    public void testAuthentication() {
        // 创建Shiro核心管理器：SecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setDataSource(dataSource);
        // 查询权限数据（默认为false）
        jdbcRealm.setPermissionsLookupEnabled(true);
        // 自定义表查询
        // jdbcRealm.setAuthenticationQuery(CUSTOMER_AUTHENTICATION_QUERY);
        defaultSecurityManager.setRealm(jdbcRealm);

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
