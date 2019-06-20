package com.qf.j1902.shiro_zhongchou2.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.qf.j1902.shiro_zhongchou2.pojo.RolePermission;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RolePermissionMapper {
    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Integer rpId);

    int updateByPrimaryKeySelective(RolePermission record);

    int insertList(@Param("list") List<Integer> list, @Param("roleId") Integer roleId);

    int deleteByRoleId(@Param("roleId") Integer roleId);

    List<RolePermission> selectAllByRoleId(@Param("roleId")Integer roleId);


}