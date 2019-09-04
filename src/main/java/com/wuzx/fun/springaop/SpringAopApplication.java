package com.wuzx.fun.springaop;

import com.wuzx.fun.springaop.service.AtithmeticCalcuatorService;
import com.wuzx.fun.springaop.service.impl.AtithmeticCalcuatorServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class SpringAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAopApplication.class, args);
    }

}
