package com.qf.j1902.shiro_zhongchou2.service.impl;
import java.util.List;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.qf.j1902.shiro_zhongchou2.mapper.AccRoleMapper;
import com.qf.j1902.shiro_zhongchou2.pojo.AccRole;
import com.qf.j1902.shiro_zhongchou2.service.AccRoleService;
@Service
public class AccRoleServiceImpl implements AccRoleService{

    @Resource
    private AccRoleMapper accRoleMapper;

    @Override
    public int deleteByPrimaryKey(Integer urId) {
        return accRoleMapper.deleteByPrimaryKey(urId);
    }

    @Override
    public int insert(AccRole record) {
        return accRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(AccRole record) {
        return accRoleMapper.insertSelective(record);
    }

    @Override
    public AccRole selectByPrimaryKey(Integer urId) {
        return accRoleMapper.selectByPrimaryKey(urId);
    }

    @Override
    public int updateByPrimaryKeySelective(AccRole record) {
        return accRoleMapper.updateByPrimaryKeySelective(record);
    }

	@Override
	public int deleteByRoleId(Integer roleId){
		 return accRoleMapper.deleteByRoleId(roleId);
	}

	@Override
	public int deleteByRoleIdAndUserid(Integer roleId,Integer userid){
		 return accRoleMapper.deleteByRoleIdAndUserid(roleId,userid);
	}







}
