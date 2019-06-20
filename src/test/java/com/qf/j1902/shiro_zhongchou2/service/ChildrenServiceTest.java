package com.qf.j1902.shiro_zhongchou2.service;

import com.qf.j1902.shiro_zhongchou2.mapper.SysPermissionMapper;
import com.qf.j1902.shiro_zhongchou2.pojo.Children;
import com.qf.j1902.shiro_zhongchou2.pojo.SysPermission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Configuration("com.qf.j1902.shiro_zhongchou2.mapper")
public class ChildrenServiceTest {


    @Autowired
    SysPermissionService service;

    @Test
    public void getMenuTree() {
        service.findAll();
    }
}