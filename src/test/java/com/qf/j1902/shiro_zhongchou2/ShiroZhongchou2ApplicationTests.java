package com.qf.j1902.shiro_zhongchou2;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiroZhongchou2ApplicationTests {

    @Test
    public void contextLoads() {
        Md5Hash md5Hash = new Md5Hash("000000", null, 1024);

    }

}
