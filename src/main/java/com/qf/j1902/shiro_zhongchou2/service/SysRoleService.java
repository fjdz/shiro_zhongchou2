package com.qf.j1902.shiro_zhongchou2.service;
import java.util.List;

import com.qf.j1902.shiro_zhongchou2.pojo.SysRole;
import org.apache.ibatis.annotations.Param;

public interface SysRoleService{


    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(SysRole record);



	List<SysRole> findByAll(SysRole sysRole);



    List<SysRole> findAllByUserId(Integer userId);



	List<SysRole> findAll();




}
