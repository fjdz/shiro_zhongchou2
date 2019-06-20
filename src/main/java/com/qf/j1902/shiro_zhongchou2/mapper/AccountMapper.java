package com.qf.j1902.shiro_zhongchou2.mapper;
import java.util.Collection;

import java.util.List;

import com.qf.j1902.shiro_zhongchou2.pojo.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountMapper {

    int insertSelective(@Param("account") Account account);

    int insert(Account record);

    Account selectByPrimaryKey(@Param("userid") Integer userid, @Param("account") String account);

    Account findOneByAccount(@Param("account") String account);

    int updateByPrimaryKeySelective(Account record);

    int updateByAccount(@Param("updated") Account updated, @Param("account") String account);

    List<Account> findAllManagement();

    List<String> findDistinctAccount();

    List<String> findDistinctEmail();

    int insertList(@Param("list")List<Account> list);

    int deleteByUseridList(@Param("list")List<Integer> list);

    int deleteByUserid(@Param("userid")Integer userid);

    int updateByUserid(@Param("updated")Account updated,@Param("userid")Integer userid);

    List<Account> findByAllLink(String data);







}