package com.qf.j1902.shiro_zhongchou2.service;

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
public class RolePermissionServiceTest {

    @Autowired
    RolePermissionService rolePermissionService;


    @Test
    public void insertList() {
        List<Integer> integers = new ArrayList<>();
        integers.add(3);
        integers.add(1);
        integers.add(2);
        integers.add(4);
        System.out.println("integers = " + integers);
        int i = rolePermissionService.insertList(integers, 3);
        System.err.println("i = " + i);
    }
}