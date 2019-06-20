package com.qf.j1902.shiro_zhongchou2.service;
import java.util.List;

import com.qf.j1902.shiro_zhongchou2.pojo.AccRole;
public interface AccRoleService{


    int deleteByPrimaryKey(Integer urId);

    int insert(AccRole record);

    int insertSelective(AccRole record);

    AccRole selectByPrimaryKey(Integer urId);

    int updateByPrimaryKeySelective(AccRole record);



	int deleteByRoleId(Integer roleId);



	int deleteByRoleIdAndUserid(Integer roleId,Integer userid);



}
