package com.qf.j1902.shiro_zhongchou2.service;

import com.qf.j1902.shiro_zhongchou2.mapper.SysPermissionMapper;
import com.qf.j1902.shiro_zhongchou2.pojo.Children;
import com.qf.j1902.shiro_zhongchou2.pojo.SysPermission;
import com.qf.j1902.shiro_zhongchou2.utils.MenuType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Configuration("com.qf.j1902.shiro_zhongchou2.mapper")
public class SysPermissionServiceTest {

    @Autowired
    SysPermissionService sysPermissionService;

    @Test
    public void findAllPermissionLevelOneMenuByUserNameAndMenuType() {
        List<SysPermission> admin = sysPermissionService.findAllPermissionLevelOneMenuByUserNameAndMenuType("1234", MenuType.LEVEL_1_MENU);
    }

    @Test
    public void findPermissionIdByMenuCodeList() {
        ArrayList<Integer> integers = new ArrayList<>();

        integers.add(202);
        integers.add(201);
        integers.add(1);

        List<Integer> permissionIdByMenuCodeList = sysPermissionService.findPermissionIdByMenuCodeList(integers);
        System.err.println("permissionIdByMenuCodeList = " + permissionIdByMenuCodeList);
    }

    @Autowired
    SysPermissionMapper mapper;

    @Test
    public void ss() {
        List<Children> u1 = sysPermissionService.findAllByRoleId(1);
        List<Children> u2 = sysPermissionService.findAll();
        Set<Children> children1 = new HashSet<>();
        children1.addAll(u1);
        children1.addAll(u2);


        for (Children children : children1) {
            System.out.println("children = " + children);

        }

        System.err.println("u1 = " + u1);

    }

    @Test
    public void sss() {
        List<Children> u1 = sysPermissionService.findAllByRoleId(2);

        List<Children> u2 = sysPermissionService.findAll();
        System.err.println("-----------------------------------");
        for (Children children:u2){
            System.out.println("children = " + children.getName()+children.isChecked());
        }
        System.out.println("******************************");

        for (Children children : u1) {
            System.err.println("children = " + children.getName()+children.isChecked());
            for (int k = 0; k < u2.size(); k++) {
                if (children.getId().equals(u2.get(k).getId()) && children.isChecked()) {
                    u2.set(k, children);
                }
            }
        }
        System.out.println("******************************");
        for (Children children:u2){
            System.err.println("children = " + children.getName()+children.isChecked());
        }
        System.out.println("******************************");

    }
}