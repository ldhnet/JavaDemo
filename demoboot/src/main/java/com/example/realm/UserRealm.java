package com.example.realm;

import com.example.mapper.SysUserMapper;
import com.example.web.models.SysUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private SysUserMapper userMapper;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String realUserName = ((UsernamePasswordToken) authenticationToken).getUsername();
        SysUser userByName = userMapper.getUserByName(realUserName);
        if(userByName==null){
            return null;
        }
        String password=userByName.getPassword();
        //ByteSource bs=new SimpleByteSource("test".getBytes());
        SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(authenticationToken.getPrincipal(),password,getName());
        return authenticationInfo;
    }

    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher passwordMatcher=new HashedCredentialsMatcher("MD5");
        super.setCredentialsMatcher(passwordMatcher);
    }
}