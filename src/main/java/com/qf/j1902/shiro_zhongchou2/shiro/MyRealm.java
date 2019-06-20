package com.qf.j1902.shiro_zhongchou2.shiro;

import com.qf.j1902.shiro_zhongchou2.pojo.Account;
import com.qf.j1902.shiro_zhongchou2.pojo.SysPermission;
import com.qf.j1902.shiro_zhongchou2.service.AccountService;
import com.qf.j1902.shiro_zhongchou2.service.SysPermissionService;
import com.qf.j1902.shiro_zhongchou2.utils.MenuType;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.standard.expression.Each;

import java.util.HashSet;
import java.util.List;
import java.util.PropertyPermission;
import java.util.Set;

/**
 * @author ：邓一凡
 * @date ：Created in 2019/6/11 16:46
 * @description ： Shiro授权认证类
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    AccountService accountService;

    @Autowired
    SysPermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String account = (String) principalCollection.getPrimaryPrincipal();
        List<SysPermission> permissions = permissionService.findAllPermissionLevelOneMenuByUserNameAndMenuType(account, MenuType.LEVEL_2_MENU);
        Set<String> permissionsets = new HashSet<>();
        if(permissions != null){
            for(SysPermission permission:permissions){
                permissionsets.add(permission.getPerName());
            }
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissionsets);
        return simpleAuthorizationInfo;
    }

    //认证登陆
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户名
        String account = (String) authenticationToken.getPrincipal();
        //根据用户名查询用户对象
        Account oneByAccount = accountService.findOneByAccount(account);
        AuthenticationInfo authenticationInfo = null;
        //判断对象有没有
        if (oneByAccount != null) {
            //简单身份验证信息 对象
            authenticationInfo = new SimpleAuthenticationInfo(account, oneByAccount.getPassword(), this.getName());
        }
        //身份验证信息 对象
        return authenticationInfo;
    }
}
