package com.qf.j1902.shiro_zhongchou2.controller;

import com.qf.j1902.shiro_zhongchou2.pojo.Account;
import com.qf.j1902.shiro_zhongchou2.service.AccountService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：邓一凡
 * @date ：Created in 2019/6/18 0:35
 * @description ： admin ajax请求控制器
 */

@RestController
@RequestMapping(value = "/admin/ajax")
public class AjaxAdminController {

    @Autowired
    AccountService accountService;


    /**
     * 添加管理员账户
     * 所需权限 用户维护
     *
     * @param account addAccount
     * @return boolean 是否添加成功
     */
    @RequiresPermissions(value = {"用户维护"})
    @RequestMapping(value = "/addAccount", method = RequestMethod.POST)
    public boolean addAccount(Account account) {
        try {
            account.setUseridentity("管理");
            account.setPassword(new Md5Hash("000000", null, 1024).toString());
            accountService.insertSelective(account);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 修改管理账户信息
     *
     * @param account upacc
     */
    @RequestMapping(value = "/upacc", method = RequestMethod.POST)
    public boolean upacc(Account account) {
        try {
            System.err.println("account = " + account);
            accountService.updateByUserid(account,account.getUserid());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
