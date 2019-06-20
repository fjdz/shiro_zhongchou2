package com.qf.j1902.shiro_zhongchou2.mapper;

import com.qf.j1902.shiro_zhongchou2.pojo.Children;
import com.qf.j1902.shiro_zhongchou2.pojo.SysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysPermissionMapper {
    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(Integer permissionId);

    int updateByPrimaryKeySelective(SysPermission record);

    List<SysPermission> findAllPermissionLevelOneMenuByUserNameAndMenuType(@Param("account") String account, @Param("menuType") String menuType);

    List<Children> findAll();

    List<Integer> findPermissionIdByMenuCodeList(@Param("menuCode") List<Integer> menuCode);

    List<Children> findAllByRoleId(Integer id);
}