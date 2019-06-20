package com.qf.j1902.shiro_zhongchou2.service.impl;

import com.qf.j1902.shiro_zhongchou2.mapper.RolePermissionMapper;
import com.qf.j1902.shiro_zhongchou2.mapper.SysPermissionMapper;
import com.qf.j1902.shiro_zhongchou2.pojo.*;
import com.qf.j1902.shiro_zhongchou2.service.ChildrenService;
import com.qf.j1902.shiro_zhongchou2.service.SysPermissionService;
import com.qf.j1902.shiro_zhongchou2.utils.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ：邓一凡
 * @date ：Created in 2019/6/13 17:23
 * @description ： 菜单树业务实现
 */
@Service
public class ChildrenServiceImpl implements ChildrenService {

    @Autowired
    SysPermissionService permissionService;

    @Autowired
    RolePermissionMapper rolePermissionMapper;

    @Autowired
    SysPermissionMapper sysPermissionMapper;

    @Override
    public List<Children> getMenuTree() {

        List<Children> all = permissionService.findAll();
        TreeUtils treeUtils = new TreeUtils(all);
        return treeUtils.builTree();

    }

    @Override
    public List<Children> getUserMenuTree(Integer roleId) {

        List<Children> u1 = permissionService.findAllByRoleId(roleId);
        List<Children> u2 = permissionService.findAll();

        for (Children children : u1) {
            for (int k = 0; k < u2.size(); k++) {
                if (children.getId().equals(u2.get(k).getId()) && children.isChecked()) {
                    u2.set(k, children);
                }
            }
        }

        TreeUtils treeUtils = new TreeUtils(u2);
        return treeUtils.builTree();

    }
}
