package com.qf.j1902.shiro_zhongchou2.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.qf.j1902.shiro_zhongchou2.mapper.SysRoleMapper;
import com.qf.j1902.shiro_zhongchou2.pojo.SysRole;
import com.qf.j1902.shiro_zhongchou2.service.SysRoleService;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public int insert(SysRole record) {
        return sysRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(SysRole record) {
        return sysRoleMapper.insertSelective(record);
    }

    @Override
    public SysRole selectByPrimaryKey(Integer roleId) {
        return sysRoleMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public int updateByPrimaryKeySelective(SysRole record) {
        return sysRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<SysRole> findByAll(SysRole sysRole) {
        return sysRoleMapper.findByAll(sysRole);
    }

    @Override
    public List<SysRole> findAllByUserId(Integer userId) {
        return sysRoleMapper.findAllByUserId(userId);
    }

	@Override
	public List<SysRole> findAll(){
		 return sysRoleMapper.findAll();
	}





}
