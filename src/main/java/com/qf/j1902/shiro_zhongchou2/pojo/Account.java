package com.qf.j1902.shiro_zhongchou2.pojo;

import lombok.Data;

@Data
public class Account {
    /**
    * 用户id
    */
    private Integer userid;

    /**
    * 账号
    */
    private String account;

    /**
    * 密码
    */
    private String password;

    /**
    * 用户名
    */
    private String username;

    /**
    * 邮箱
    */
    private String email;

    /**
    * 用户身份
    */
    private String useridentity;

    /**
    * 实名认证ID
    */
    private String realnameid;
}