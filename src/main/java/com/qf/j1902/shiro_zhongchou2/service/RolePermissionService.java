package com.qf.j1902.shiro_zhongchou2.service;
import java.util.List;

import com.qf.j1902.shiro_zhongchou2.pojo.RolePermission;
public interface RolePermissionService{


    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Integer rpId);

    int updateByPrimaryKeySelective(RolePermission record);


    int insertList(List<Integer> list, Integer roleId);



	int deleteByRoleId(Integer roleId);



	List<RolePermission> selectAllByRoleId(Integer roleId);


}
