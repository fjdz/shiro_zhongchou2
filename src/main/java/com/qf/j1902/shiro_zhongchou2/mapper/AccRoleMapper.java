package com.qf.j1902.shiro_zhongchou2.mapper;
import org.apache.ibatis.annotations.Param;

import com.qf.j1902.shiro_zhongchou2.pojo.AccRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccRoleMapper {
    int deleteByPrimaryKey(Integer urId);

    int insert(AccRole record);

    int insertSelective(AccRole record);

    AccRole selectByPrimaryKey(Integer urId);

    int updateByPrimaryKeySelective(AccRole record);

    int deleteByRoleId(@Param("roleId")Integer roleId);

    int deleteByRoleIdAndUserid(@Param("roleId")Integer roleId,@Param("userid")Integer userid);




}