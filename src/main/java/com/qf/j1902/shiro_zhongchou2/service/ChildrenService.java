package com.qf.j1902.shiro_zhongchou2.service;

import com.qf.j1902.shiro_zhongchou2.pojo.Children;

import java.util.List;

public interface ChildrenService {
    List<Children> getMenuTree();

    List<Children> getUserMenuTree(Integer id);
}
