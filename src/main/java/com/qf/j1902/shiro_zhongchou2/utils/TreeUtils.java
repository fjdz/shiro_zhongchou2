package com.qf.j1902.shiro_zhongchou2.utils;

import com.qf.j1902.shiro_zhongchou2.pojo.Children;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：邓一凡
 * @date ：Created in 2019/6/16 15:49
 * @description ： 树形菜单工具类
 */

public class TreeUtils {

    private List<Children> menuList;

    public TreeUtils(List<Children> sysPermissionList) {
        this.menuList = sysPermissionList;
    }

    //建立树形结构
    public List<Children> builTree() {
        List<Children> treeMenus = new ArrayList<>();
        for (Children menuNode : getRootNode()) {
            Children permission = buildChilTree(menuNode);
            treeMenus.add(permission);
        }
        return treeMenus;
    }

    //递归，建立子树形结构
    private Children buildChilTree(Children pNode) {
        List<Children> chilMenus =new  ArrayList<>();
        for(Children menuNode : menuList) {
            if(menuNode.getPid().equals(pNode.getId())) {
                chilMenus.add(buildChilTree(menuNode));
            }
        }
        pNode.setChildren(chilMenus);
        return pNode;
    }

    //获取根节点
    private List<Children> getRootNode() {
        List<Children> rootMenuLists = new ArrayList<>();
        for (Children menuNode : menuList) {
            if (menuNode.getPid().equals("0")) {
                rootMenuLists.add(menuNode);
            }
        }
        return rootMenuLists;
    }


}
