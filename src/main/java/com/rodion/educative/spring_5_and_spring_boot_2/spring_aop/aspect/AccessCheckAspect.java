package com.rodion.educative.spring_5_and_spring_boot_2.spring_aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AccessCheckAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("com.rodion.educative.spring_5_and_spring_boot_2.spring_aop.aspect.JoinPointConfig.businessLayerPointcut()")
//    @Before("execution(* com.rodion.educative.spring_5_and_spring_boot_2.spring_aop.business.*.*(..))")
    //@Before("execution(String com.rodion.educative.spring_5_and_spring_boot_2.spring_aop..*.*(String))")
    //@Before("execution(* com.rodion.educative.spring_5_and_spring_boot_2.spring_aop..*.*Filtering(..))")
    //@Before("execution(String com.rodion.educative.spring_5_and_spring_boot_2.spring_aop..*.*(..))")
    //@Before("execution(* com.rodion.educative.spring_5_and_spring_boot_2.spring_aop.business.*.*(..))")
    public void before(JoinPoint joinPoint) {
        logger.info("Intercepted call from AccessCheckAspect before execution of: {}", joinPoint);

        //access check logic
    }
}
