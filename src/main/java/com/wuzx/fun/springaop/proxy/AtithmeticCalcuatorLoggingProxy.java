package com.wuzx.fun.springaop.proxy;

import com.wuzx.fun.springaop.service.AtithmeticCalcuatorService;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

/**
 * @program: spring-aop->AtithmeticCalcuatorLoggingProxy
 * @description:
 * @author: wuzx
 * @create: 2019-09-04 11:40
 * @version: 1.0
 **/


public class AtithmeticCalcuatorLoggingProxy {
    //目标对象
    private AtithmeticCalcuatorService target;

    public AtithmeticCalcuatorLoggingProxy(AtithmeticCalcuatorService target) {
        this.target = target;
    }

    public AtithmeticCalcuatorService getAtithmeticCalcuatorService() {
        AtithmeticCalcuatorService proxy = null;

        //代理对象由哪一个类加载器负责加载
        ClassLoader loader = target.getClass().getClassLoader();
        //代理对象的类型，即其中有哪些方法
        Class[] interfaces = new Class[]{AtithmeticCalcuatorService.class};

        //当调用的代理对象其中的方法时，该代码被执行
        InvocationHandler h = new InvocationHandler() {

            /**
             *
             * @param poxy 正在返回的代理对象，一般情况下都不使用该对象
             * @param method 正在被调用的方法
             * @param objects 方法传入的参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object poxy, Method method, Object[] objects) throws Throwable {
                System.out.println("invoke");

                return method.invoke(target, objects);
            }
        };
        proxy =(AtithmeticCalcuatorService) Proxy.newProxyInstance(loader, interfaces, h);
        return proxy;
    }
}
