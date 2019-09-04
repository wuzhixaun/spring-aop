package com.wuzx.fun.springaop;

import com.wuzx.fun.springaop.proxy.AtithmeticCalcuatorLoggingProxy;
import com.wuzx.fun.springaop.service.AtithmeticCalcuatorService;
import com.wuzx.fun.springaop.service.impl.AtithmeticCalcuatorServiceImpl;

/**
 * @program: spring-aop->main
 * @description:
 * @author: wuzx
 * @create: 2019-09-04 17:16
 * @version: 1.0
 **/
public class Main {
    public static void main(String[] args) {
        AtithmeticCalcuatorService target = new AtithmeticCalcuatorServiceImpl();

        AtithmeticCalcuatorService proxy = new AtithmeticCalcuatorLoggingProxy(target).getAtithmeticCalcuatorService();

        proxy.add(1, 2);

    }
}
