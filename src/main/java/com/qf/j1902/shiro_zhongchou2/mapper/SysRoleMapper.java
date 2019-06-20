package com.qf.j1902.shiro_zhongchou2.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.qf.j1902.shiro_zhongchou2.pojo.SysRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysRoleMapper {
    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(SysRole record);

    List<SysRole> findByAll(SysRole sysRole);

    List<SysRole> findAllByUserId(@Param("userId")Integer userId);

    List<SysRole> findAll();



}