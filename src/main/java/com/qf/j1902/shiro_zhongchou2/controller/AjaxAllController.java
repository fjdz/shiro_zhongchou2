package com.qf.j1902.shiro_zhongchou2.controller;


import com.qf.j1902.shiro_zhongchou2.pojo.AccRole;
import com.qf.j1902.shiro_zhongchou2.pojo.Account;
import com.qf.j1902.shiro_zhongchou2.pojo.Children;
import com.qf.j1902.shiro_zhongchou2.service.*;
import com.qf.j1902.shiro_zhongchou2.vo.RolePermissionVo;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：邓一凡
 * @date ：Created in 2019/6/13 18:00
 * @description ： 所有AJAX请求控制器
 */
@RestController
@RequestMapping(value = "/ajax")
public class AjaxAllController {

    @Autowired
    ChildrenService childrenService;

    @Autowired
    RolePermissionService rolePermissionService;

    @Autowired
    SysPermissionService sysPermissionService;

    @Autowired
    AccRoleService accRoleService;

    @Autowired
    AccountService accountService;

    /**
     * 请求菜单树
     * 所需权限 用户维护
     *
     * @return Menu list json
     */
    @RequiresPermissions(value = {"许可维护"})
    @RequestMapping(value = "/getMenuTree", method = RequestMethod.POST)
    public List<Children> menuTree() {
        return childrenService.getMenuTree();
    }

    /**
     * 请求菜单树 ,"角色维护"
     * 所需权限 用户维护
     *
     * @return Menu list json
     */
    @RequiresPermissions(value = {"角色维护"})
    @RequestMapping(value = "/getUserMenuTree/{id}", method = RequestMethod.POST)
    public List<Children> userMenuTree(@PathVariable Integer id) {
        return childrenService.getUserMenuTree(id);
    }

    /**
     * 分配角色权限
     * 所需权限 用户维护
     *
     * @param checkInfo 菜单树选择的信息
     * @param id        角色ID
     * @return 状态码 205
     */
    @RequiresPermissions(value = {"角色维护"})
    @RequestMapping(value = "/setMenuTree", method = RequestMethod.POST)
    public ResponseEntity setMenu(@RequestParam(value = "checkInfo[]") List<Integer> checkInfo, @RequestParam(value = "id") Integer id) {
        List<Integer> permissionId = sysPermissionService.findPermissionIdByMenuCodeList(checkInfo);
        rolePermissionService.deleteByRoleId(id);
        rolePermissionService.insertList(permissionId, id);
        return new ResponseEntity(HttpStatus.RESET_CONTENT);
    }

    /**
     * 删除用户所拥有的角色
     * 所需权限 用户维护
     *
     * @param accRole 角色对象 包含 角色id 角色用户id
     * @return CREATED
     */
    @RequiresPermissions(value = {"用户维护"})
    @RequestMapping(value = "/delRole", method = RequestMethod.POST)
    public ResponseEntity delRole(AccRole accRole) {
        accRoleService.deleteByRoleIdAndUserid(accRole.getRoleId(), accRole.getUserid());
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * 给用户添加角色
     * 所需权限 用户维护
     *
     * @param accRole 角色对象 包含 角色id 角色用户id
     * @return RESET_CONTENT
     */
    @RequiresPermissions(value = {"用户维护"})
    @RequestMapping(value = "/addRole", method = RequestMethod.POST)
    public ResponseEntity addRole(AccRole accRole) {
        accRoleService.insertSelective(accRole);
        return new ResponseEntity(HttpStatus.RESET_CONTENT);
    }

    /**
     * 批量删除用户
     * 所需权限 用户维护
     *
     * @param userid 批量删除的用户ID集合
     * @return 删除成功的个数
     */
    @RequiresPermissions(value = {"用户维护"})
    @RequestMapping(value = "/delAccountList", method = RequestMethod.POST)
    public Integer delAccountList(@RequestParam("userid[]") ArrayList<Integer> userid) {
        return accountService.deleteByUseridList(userid);
    }

    /**
     * 删除用户
     * 所需权限 用户维护
     *
     * @param userid 删除的用户ID
     * @return 删除成功 影响个数
     */
    @RequiresPermissions(value = {"用户维护"})
    @RequestMapping(value = "/delAccount", method = RequestMethod.POST)
    public Integer delAccount(@RequestParam("userid") Integer userid) {
        return accountService.deleteByUserid(userid);
    }

    /**
     * 查询账号是否可用接口
     * 所需权限 无
     *
     * @param account regAccount
     * @return boolean 是否可用
     */
    @RequestMapping(value = "/regAccount", method = RequestMethod.GET)
    public boolean regAccount(Account account) {
        List<String> distinctAccount = accountService.findDistinctAccount();
        return distinctAccount.contains(account.getAccount());
    }

    /**
     * 查询邮箱是否可用接口
     * 所需权限 无
     *
     * @param account regemail
     * @return boolean 是否可用
     */
    @RequestMapping(value = "/regemail", method = RequestMethod.GET)
    public boolean regemail(Account account) {
        List<String> distinctEmail = accountService.findDistinctEmail();
        return distinctEmail.contains(account.getEmail());
    }
}
