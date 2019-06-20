package com.qf.j1902.shiro_zhongchou2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ：邓一凡
 * @date ：Created in 2019/6/11 18:46
 * @description ： 公有视图控制器
 */
@Controller
public class PublicViewController {

    /**
     * 根目录访问首页视图
     *
     * @return index
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    /**
     * 登陆视图
     *
     * @return login
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 注册视图
     *
     * @return reg
     */
    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String registered() {
        return "reg";
    }
}
