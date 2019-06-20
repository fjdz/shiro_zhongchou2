package com.qf.j1902.shiro_zhongchou2.vo;

import lombok.Data;

/**
 * @author ：邓一凡
 * @date ：Created in 2019/6/11 19:04
 * @description ： 登陆表单实体对象
 */
@Data
public class LoginFormVo {
    private String Account;
    private String PassWord;
    private String userIdentity;
}
