package com.wuzx.fun.springaop.service.impl;

import com.wuzx.fun.springaop.service.AtithmeticCalcuatorService;
import org.springframework.stereotype.Service;

/**
 * @program: spring-aop->AtithmeticCalcuatorServiceImpl
 * @description:
 * @author: wuzx
 * @create: 2019-09-04 11:29
 * @version: 1.0
 **/
@Service(value = "atithmeticCalcuatorService")
public class AtithmeticCalcuatorServiceImpl implements AtithmeticCalcuatorService {
    @Override
    public int add(int i, int j) {
        return i+j;
    }

    @Override
    public int sub(int i, int j) {
        return i-j;
    }

    @Override
    public int mul(int i, int j) {
        return i*j;
    }

    @Override
    public int div(int i, int j) {
        return i/j;
    }
}
