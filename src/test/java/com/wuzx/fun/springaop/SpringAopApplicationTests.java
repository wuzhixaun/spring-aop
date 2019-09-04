package com.wuzx.fun.springaop;

import com.wuzx.fun.springaop.proxy.AtithmeticCalcuatorLoggingProxy;
import com.wuzx.fun.springaop.service.AtithmeticCalcuatorService;
import com.wuzx.fun.springaop.service.impl.AtithmeticCalcuatorServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAopApplicationTests {

    @Test
    public void contextLoads() {
        AtithmeticCalcuatorService target = new AtithmeticCalcuatorServiceImpl();

        AtithmeticCalcuatorService proxy = new AtithmeticCalcuatorLoggingProxy(target).getAtithmeticCalcuatorService();

        proxy.add(1, 2);
        proxy.sub(1, 2);
        proxy.mul(1, 2);
        proxy.div(1, 2);
    }

}
