package com.wuzx.fun.springaop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: spring-aop->LoginAction
 * @description:
 * @author: wuzx
 * @create: 2019-09-04 17:41
 * @version: 1.0
 **/
@RestController
public class LoginAction {

    @RequestMapping(value = "/hello")
    public Object hello() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "wuzhixuan");
        map.put("age", "20");
        return map;
    }

    @RequestMapping(value = "/connet")
    public Object connet() {
       //手动连接Jdbc数据库
//        Connection connection = DriverManager.getConnection()
        return null;
    }

}
