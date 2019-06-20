package com.qf.j1902.shiro_zhongchou2.service.impl;
import java.util.List;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.qf.j1902.shiro_zhongchou2.pojo.RolePermission;
import com.qf.j1902.shiro_zhongchou2.mapper.RolePermissionMapper;
import com.qf.j1902.shiro_zhongchou2.service.RolePermissionService;
@Service
public class RolePermissionServiceImpl implements RolePermissionService{

    @Resource
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public int insert(RolePermission record) {
        return rolePermissionMapper.insert(record);
    }

    @Override
    public int insertSelective(RolePermission record) {
        return rolePermissionMapper.insertSelective(record);
    }

    @Override
    public RolePermission selectByPrimaryKey(Integer rpId) {
        return rolePermissionMapper.selectByPrimaryKey(rpId);
    }

    @Override
    public int updateByPrimaryKeySelective(RolePermission record) {
        return rolePermissionMapper.updateByPrimaryKeySelective(record);
    }


    @Override
	public int insertList(List<Integer> list, Integer roleId){
		 return rolePermissionMapper.insertList(list,roleId);
	}

	@Override
	public int deleteByRoleId(Integer roleId){
		 return rolePermissionMapper.deleteByRoleId(roleId);
	}

	@Override
	public List<RolePermission> selectAllByRoleId(Integer roleId){
		 return rolePermissionMapper.selectAllByRoleId(roleId);
	}










}
