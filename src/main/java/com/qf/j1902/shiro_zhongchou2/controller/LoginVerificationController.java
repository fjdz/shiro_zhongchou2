package com.qf.j1902.shiro_zhongchou2.controller;

import com.qf.j1902.shiro_zhongchou2.pojo.Account;
import com.qf.j1902.shiro_zhongchou2.pojo.SysPermission;
import com.qf.j1902.shiro_zhongchou2.service.AccountService;
import com.qf.j1902.shiro_zhongchou2.service.SysPermissionService;
import com.qf.j1902.shiro_zhongchou2.utils.MenuType;
import com.qf.j1902.shiro_zhongchou2.utils.SessionKey;
import com.qf.j1902.shiro_zhongchou2.vo.LoginFormVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

/**
 * @author ：邓一凡
 * @date ：Created in 2019/6/11 17:55
 * @description ： 登陆系统 退出系统 控制器
 */
@Controller
public class LoginVerificationController {

    @Autowired
    AccountService accountService;

    @Autowired
    SysPermissionService sysPermissionService;

    /**
     * 登陆处理
     *
     * @param loginFormVo form表单对象
     * @return member | main | error
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(LoginFormVo loginFormVo, HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken Token = new UsernamePasswordToken(loginFormVo.getAccount(), loginFormVo.getPassWord());
        Account account = accountService.findOneByAccount(loginFormVo.getAccount());
        account.setPassword("");
        session.setAttribute(SessionKey.USER_INFO, account);
        subject.login(Token);
        try {
            if (subject.isAuthenticated()) {
                if ("管理".equals(account.getUseridentity())) {
                    ModelAndView modelAndView = new ModelAndView("main");//管理
                    //获取一级菜单
                    List<SysPermission> permissionsOneMenu = sysPermissionService.findAllPermissionLevelOneMenuByUserNameAndMenuType(loginFormVo.getAccount(), MenuType.LEVEL_1_MENU);
                    //获取二级菜单
                    List<SysPermission> permissionsTwoMenu = sysPermissionService.findAllPermissionLevelOneMenuByUserNameAndMenuType(loginFormVo.getAccount(), MenuType.LEVEL_2_MENU);
                    modelAndView.addObject("permissionsOneMenu", permissionsOneMenu);
                    modelAndView.addObject("permissionsTwoMenu", permissionsTwoMenu);
                    return modelAndView;
                } else {
                    return new ModelAndView("/member");//会员
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView("/login");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/";
    }
}
