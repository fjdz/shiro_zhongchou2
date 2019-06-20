package com.qf.j1902.shiro_zhongchou2.service.impl;
import java.util.List;
import com.qf.j1902.shiro_zhongchou2.mapper.AccountMapper;
import com.qf.j1902.shiro_zhongchou2.pojo.Account;
import com.qf.j1902.shiro_zhongchou2.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class AccountServiceImpl implements AccountService{

    @Resource
    private AccountMapper accountMapper;

    @Override
    public int insert(Account record) {
        return accountMapper.insert(record);
    }

    @Override
    public Account selectByPrimaryKey(Integer userid,String account) {
        return accountMapper.selectByPrimaryKey(userid,account);
    }

    @Override
    public int updateByPrimaryKeySelective(Account record) {
        return accountMapper.updateByPrimaryKeySelective(record);
    }

	@Override
	public Account findOneByAccount(String account){
		 return accountMapper.findOneByAccount(account);
	}

	@Override
	public int updateByAccount(Account updated,String account){
		 return accountMapper.updateByAccount(updated,account);
	}

	@Override
	public List<Account> findAllManagement(){
		 return accountMapper.findAllManagement();
	}

	@Override
	public int insertSelective(Account account){
		 return accountMapper.insertSelective(account);
	}

	@Override
	public List<String> findDistinctAccount(){
		 return accountMapper.findDistinctAccount();
	}

	@Override
	public List<String> findDistinctEmail(){
		 return accountMapper.findDistinctEmail();
	}

	@Override
	public int deleteByUseridList(List<Integer> list) {
		return accountMapper.deleteByUseridList(list);
	}

	@Override
	public int deleteByUserid(Integer userid){
		 return accountMapper.deleteByUserid(userid);
	}

	@Override
	public int updateByUserid(Account updated,Integer userid){
		 return accountMapper.updateByUserid(updated,userid);
	}

	@Override
	public List<Account> findByAllLink(String string){
		 return accountMapper.findByAllLink(string);
	}









}
