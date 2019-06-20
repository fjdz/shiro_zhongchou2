package com.qf.j1902.shiro_zhongchou2.service;
import java.util.List;
import com.qf.j1902.shiro_zhongchou2.pojo.Account;
public interface AccountService{


    int insert(Account record);

    Account selectByPrimaryKey(Integer userid, String account);

    int updateByPrimaryKeySelective(Account record);

	Account findOneByAccount(String account);



	int updateByAccount(Account updated,String account);



	List<Account> findAllManagement();



	int insertSelective(Account account);



	List<String> findDistinctAccount();



	List<String> findDistinctEmail();



	int deleteByUseridList(List<Integer> list);



	int deleteByUserid(Integer userid);



	int updateByUserid(Account updated,Integer userid);



	List<Account> findByAllLink(String string);











}
