package com.qf.j1902.shiro_zhongchou2.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.j1902.shiro_zhongchou2.pojo.Account;
import com.qf.j1902.shiro_zhongchou2.pojo.SysPermission;
import com.qf.j1902.shiro_zhongchou2.pojo.SysRole;
import com.qf.j1902.shiro_zhongchou2.service.AccountService;
import com.qf.j1902.shiro_zhongchou2.service.SysPermissionService;
import com.qf.j1902.shiro_zhongchou2.service.SysRoleService;
import com.qf.j1902.shiro_zhongchou2.utils.MenuType;
import com.qf.j1902.shiro_zhongchou2.utils.SessionKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author ：邓一凡
 * @date ：Created in 2019/6/12 21:56
 * @description ： 后台管理控制器
 */
@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    SysPermissionService sysPermissionService;

    @Autowired
    SysRoleService roleService;

    @Autowired
    AccountService accountService;

    /**
     * 一级菜单模板
     *
     * @param session session
     * @return 模板
     */
    @ModelAttribute(value = "permissionsOneMenu")
    public List<SysPermission> pub(HttpSession session) {
        Account attribute = (Account) session.getAttribute(SessionKey.USER_INFO);
        //获取一级菜单
        return sysPermissionService.findAllPermissionLevelOneMenuByUserNameAndMenuType(attribute.getAccount(), MenuType.LEVEL_1_MENU);
    }

    /**
     * 二级菜单模板
     *
     * @param session session
     * @return 模板
     */
    @ModelAttribute(value = "permissionsTwoMenu")
    public List<SysPermission> pub2(HttpSession session) {
        Account attribute = (Account) session.getAttribute(SessionKey.USER_INFO);
        //获取二级菜单
        return sysPermissionService.findAllPermissionLevelOneMenuByUserNameAndMenuType(attribute.getAccount(), MenuType.LEVEL_2_MENU);
    }

    /**
     * 角色维护页面
     *
     * @return role
     */
    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public String role(Model model, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysRole> sysRoleList = roleService.findByAll(new SysRole());
        PageInfo<SysRole> sysRolePageInfo = new PageInfo<>(sysRoleList);
        model.addAttribute("PageInfo", sysRolePageInfo);
        //获得一页显示的条数
        model.addAttribute("pageSize", sysRolePageInfo.getPageSize());
        //是否是第一页
        model.addAttribute("isFirstPage", sysRolePageInfo.isIsFirstPage());
        //获得当前页
        model.addAttribute("pageNum", sysRolePageInfo.getPageNum());
        //获得总页数
        model.addAttribute("totalPages", sysRolePageInfo.getPages());
        //是否是最后一页
        model.addAttribute("isLastPage", sysRolePageInfo.isIsLastPage());
        return "role";
    }

    /**
     * 权限分配列表
     *
     * @param id 角色id
     * @return assignPermission
     */
    @RequestMapping(value = "/assignPermission/{id}", method = RequestMethod.GET)
    public ModelAndView assignPermission(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView("assignPermission");
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    /**
     * 用户维护
     * <p>
     * 加分页
     *
     * @return user
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(Model model, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Account> allManagement = accountService.findAllManagement();
        PageInfo<Account> accountPageInfo = new PageInfo<>(allManagement);
        model.addAttribute("PageInfo", accountPageInfo);
        //获得当前页
        model.addAttribute("pageNum", accountPageInfo.getPageNum());
        //获得一页显示的条数
        model.addAttribute("pageSize", accountPageInfo.getPageSize());
        //是否是第一页
        model.addAttribute("isFirstPage", accountPageInfo.isIsFirstPage());
        //获得总页数
        model.addAttribute("totalPages", accountPageInfo.getPages());
        //是否是最后一页
        model.addAttribute("isLastPage", accountPageInfo.isIsLastPage());
        return "user";
    }


    /**
     * 分配角色
     *
     * @param id 用户ID
     * @return assignRole
     */
    @RequestMapping(value = "/assignRole/{id}", method = RequestMethod.GET)
    public ModelAndView assignRole(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("assignRole");
        List<SysRole> userSysRole = roleService.findAllByUserId(id);
        List<SysRole> unassignedRole = roleService.findAll();
        unassignedRole.removeAll(userSysRole);
        modelAndView.addObject("userSysRoles", userSysRole);//用户已分配的角色
        modelAndView.addObject("unassignedRoles", unassignedRole);//用户未分配的角色
        modelAndView.addObject("userid", id);//用户id
        return modelAndView;
    }

    /**
     * 用户维护 修改信息页面
     *
     * @param id 用户id
     * @return edit
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    /**
     * 所有页面导航
     *
     * @param htmlname 页面视图名
     * @return 虚拟视图
     */
    @RequestMapping(value = "/{htmlname}", method = RequestMethod.GET)
    public String role(@PathVariable String htmlname) {
        return htmlname;
    }

}
