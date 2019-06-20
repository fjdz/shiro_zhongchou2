package com.qf.j1902.shiro_zhongchou2.controller;

import com.qf.j1902.shiro_zhongchou2.pojo.Account;
import com.qf.j1902.shiro_zhongchou2.service.AccountService;
import com.qf.j1902.shiro_zhongchou2.vo.RegisteredFromVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ：邓一凡
 * @date ：Created in 2019/6/11 19:41
 * @description ： 注册控制器
 */
@Controller
public class RegisteredController {

    @Autowired
    AccountService accountService;

    /**
     * 注册处理
     *
     * @param registeredFromVo form表单对象
     * @return login
     */
    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String registered(RegisteredFromVo registeredFromVo) {
        /* 用户注册输入的密码 MD5加密*/
        String password = new Md5Hash(registeredFromVo.getPassWord(), null, 1024).toString();
        /* 初始密码*/
        String initialPassword = new Md5Hash("000000", null, 1024).toString();
        /* 是否选择的是管理*/
        if ("管理".equals(registeredFromVo.getUserIdentity())) {
            Account oneByAccount = accountService.findOneByAccount(registeredFromVo.getAccount());
            /* 查询是否有此管理账号*/
            if (oneByAccount != null) {
                /* 判断此输入的管理账号是否与数据库里的账号邮箱一致，防止他人恶意修改密码*/
                if (initialPassword.equals(oneByAccount.getPassword()) & (oneByAccount.getEmail().equals(registeredFromVo.getEmail()))) {
                    /* 判断此账号密码是否是初始密码 是则更新当前输入的密码不是则不动作*/
                    if (!initialPassword.equals(password)) {
                        Account account1 = new Account();
                        account1.setPassword(password);
                        accountService.updateByAccount(account1, registeredFromVo.getAccount());
                    }
                }
            }
        } else {
            /*查询是否有此账号 没有则可以注册*/
            Account oneByAccount = accountService.findOneByAccount(registeredFromVo.getAccount());
            if (oneByAccount == null) {
                Account account = new Account();
                account.setAccount(registeredFromVo.getAccount());
                account.setPassword(password);
                account.setEmail(registeredFromVo.getEmail());
                account.setUseridentity(registeredFromVo.getUserIdentity());
                accountService.insert(account);
            }
        }
        return "login";
    }
}
