package com.qf.j1902.shiro_zhongchou2.mapper;

import com.qf.j1902.shiro_zhongchou2.pojo.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Configuration("com.qf.j1902.shiro_zhongchou2.mapper")
public class AccountMapperTest {

    @Autowired
    AccountMapper mapper;

    @Test
    public void deleteByUseridList() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(113);
//        integers.add(115);
        int i = mapper.deleteByUseridList(integers);
    }

    @Test
    public void findByAllLink() {
        List<Account> aa = mapper.findByAllLink(null);
        System.err.println("aa = " + aa);
    }
}