package com.gd.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author chenpengfei
 */
public class CustomRealm extends AuthorizingRealm {

    Map<String, String> userMap = new HashMap<>(16);
    Set<String> roleSet = new HashSet<>();
    Set<String> permissionSet = new HashSet<>();

    /**
     * 模拟"盐"
     */
    private String salt = "gd";

    // 模拟数据
    {
        userMap.put("andrew", "123456");
        // md5摘要密码
        // userMap.put("andrew", "e10adc3949ba59abbe56e057f20f883e");
        // md5加盐（gd）摘要密码
        // userMap.put("andrew", "a3f559e234d840788027391815302471");
        roleSet.add("admin");
        roleSet.add("test");
        permissionSet.add("dashboard:new");
    }

    /**
     * 授权
     *
     * @param principals
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        // 获取角色
        Set<String> roles = getRolesByUsername(userName);
        authorizationInfo.setRoles(roles);

        // 获取权限
        Set<String> permissions = getPermissionsByUsername(userName);
        authorizationInfo.setStringPermissions(permissions);

        return authorizationInfo;
    }

    private Set<String> getRolesByUsername(String userName) {
        return roleSet;
    }

    private Set<String> getPermissionsByUsername(String userName) {
        return permissionSet;
    }

    /**
     * 认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String) token.getPrincipal();
        String password = getPasswordByUserName(principal);
        if (password == null) {
            return null;
        }

        // @param principal   the 'primary' principal associated with the specified realm.
        // @param credentials the credentials that verify the given principal.
        // @param realmName   the realm from where the principal and credentials were acquired.
        // principal用于标识用户
        // credentials用于验证，比如密码
        // CredentialsMatcher会将 @param credentials 与 Subject.login(AuthenticationToken token)中token的credentials对比
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(principal, password, getName());
        // 加盐
        // SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(principal, password,ByteSource.Util.bytes(salt), getName());
        return simpleAuthenticationInfo;
    }

    private String getPasswordByUserName(String principal) {
        return userMap.get(principal);
    }


}
