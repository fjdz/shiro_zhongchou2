package com.qf.j1902.shiro_zhongchou2.exeception;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.exceptions.TemplateInputException;

/**
 * @author ：邓一凡
 * @date ：Created in 2019/6/11 16:44
 * @description ： 控制层异常拦截器
 */
@ControllerAdvice//标识为控制层拦截器
public class ExceptionController {

    //未经授权的异常
    @ExceptionHandler(value = UnauthorizedException.class)
    public String defaultErrorHandler(){
        return "denied";
    }

    //授权异常
    @ExceptionHandler(value = AuthorizationException.class)
    public String AuthorizationException(){
        return "unauthorized";
    }

    //未登录异常
    @ExceptionHandler(value = NullPointerException.class)
    public String NullPointerException(){
        return "/login";
    }

    //临时访问异常
    @ExceptionHandler(value = TemplateInputException.class)
    public String TemplateInputException(){
        return "error";
    }


}
