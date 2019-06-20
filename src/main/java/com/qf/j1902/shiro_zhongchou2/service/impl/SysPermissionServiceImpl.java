package com.qf.j1902.shiro_zhongchou2.service.impl;
import java.util.List;

import com.qf.j1902.shiro_zhongchou2.pojo.Children;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.qf.j1902.shiro_zhongchou2.mapper.SysPermissionMapper;
import com.qf.j1902.shiro_zhongchou2.pojo.SysPermission;
import com.qf.j1902.shiro_zhongchou2.service.SysPermissionService;

import java.util.*;

@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Resource
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public int insert(SysPermission record) {
        return sysPermissionMapper.insert(record);
    }

    @Override
    public int insertSelective(SysPermission record) {
        return sysPermissionMapper.insertSelective(record);
    }

    @Override
    public SysPermission selectByPrimaryKey(Integer permissionId) {
        return sysPermissionMapper.selectByPrimaryKey(permissionId);
    }

    @Override
    public int updateByPrimaryKeySelective(SysPermission record) {
        return sysPermissionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<SysPermission> findAllPermissionLevelOneMenuByUserNameAndMenuType(String account, String menuType) {
        Set<SysPermission> set = new HashSet<>();
        List<SysPermission> newList = new ArrayList<>();
        List<SysPermission> allPermissionsLevelOneMenuByUserNameAndMenuType = sysPermissionMapper.findAllPermissionLevelOneMenuByUserNameAndMenuType(account, menuType);
        for (Iterator<SysPermission> iter = allPermissionsLevelOneMenuByUserNameAndMenuType.iterator(); iter.hasNext();) {
            SysPermission element = iter.next();
            if (set.add(element))
                newList.add(element);
        }
        return newList;
    }

	@Override
	public List<Children> findAll(){
		 return sysPermissionMapper.findAll();
	}

	@Override
	public List<Integer> findPermissionIdByMenuCodeList(List<Integer> menuCode){
		 return sysPermissionMapper.findPermissionIdByMenuCodeList(menuCode);
	}

    @Override
    public List<Children> findAllByRoleId(Integer roleId) {
        return sysPermissionMapper.findAllByRoleId(roleId);
    }

}
