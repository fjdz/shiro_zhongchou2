package com.qf.j1902.shiro_zhongchou2.config;

import com.qf.j1902.shiro_zhongchou2.shiro.MyRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：邓一凡 yi
 * @date ：Created in 2019/6/11 16:43
 * @description ： Shiro配置类
 */
@Configuration
public class ShiroConfig {

    //设置凭证匹配器
    @Bean(name = "hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        hashedCredentialsMatcher.setHashIterations(1024);
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        return hashedCredentialsMatcher;
    }

    //创建自定义realm对象
    @Bean(name = "myRealm")
    public MyRealm getRealm(HashedCredentialsMatcher matcher) {
        MyRealm myRealm = new MyRealm();
        myRealm.setCredentialsMatcher(matcher);
        return myRealm;
    }

    //默认Web安全管理器
    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("myRealm") MyRealm myRealm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(myRealm);
        return defaultWebSecurityManager;
    }

    //Shiro过滤器工厂
    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager manager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(manager);
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setUnauthorizedUrl("denied");
        Map<String, String> map = new HashMap<>();

        map.put("/main", "authc");
        map.put("/member", "authc");
        map.put("/ajax/menuTree", "anon");
        map.put("/admin/user", "perms[用户维护]");
        map.put("/admin/permission", "perms[许可维护]");
        map.put("/admin/auth_cert", "perms[实名认证审核]");
        map.put("/admin/auth_adv", "perms[广告审核]");
        map.put("/admin/auth_project", "perms[项目审核]");
        map.put("/admin/cert", "perms[资质维护]");
        map.put("/admin/type", "perms[分类管理]");
        map.put("/admin/process", "perms[流程管理]");
        map.put("/admin/advertisement", "perms[广告管理]");
        map.put("/admin/message", "perms[消息模板]");
        map.put("/admin/project_type", "perms[项目分类]");
        map.put("/admin/tag", "perms[项目标签]");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    //开启注解验证模式
    //默认Advisor自动代理创建器
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        return new DefaultAdvisorAutoProxyCreator();
    }

    //授权属性源顾问
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager manager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(manager);
        return authorizationAttributeSourceAdvisor;
    }
}
