package com.qf.j1902.shiro_zhongchou2.service;

import com.qf.j1902.shiro_zhongchou2.pojo.Children;
import com.qf.j1902.shiro_zhongchou2.pojo.SysPermission;

import java.util.List;

public interface SysPermissionService{


    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(Integer permissionId);

    int updateByPrimaryKeySelective(SysPermission record);

    List<SysPermission> findAllPermissionLevelOneMenuByUserNameAndMenuType(String account, String menuType);



	List<Children> findAll();



	List<Integer> findPermissionIdByMenuCodeList(List<Integer> menuCode);


    List<Children> findAllByRoleId(Integer roleId);
}
