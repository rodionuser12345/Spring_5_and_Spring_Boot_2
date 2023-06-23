package com.rodion.educative.spring_5_and_spring_boot_2.spring_aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @AfterReturning(
//            value = "execution(* com.rodion.educative.spring_5_and_spring_boot_2.spring_aop.business.*.*(..))",
            value = "com.rodion.educative.spring_5_and_spring_boot_2.spring_aop.aspect.JoinPointConfig.businessLayerPointcut()",
            returning = "result")
    public void LogAfterExecution(JoinPoint joinPoint, Object result) {
        logger.info("Method {} returned with: {}", joinPoint, result);
    }

    @AfterThrowing(
            value = "com.rodion.educative.spring_5_and_spring_boot_2.spring_aop.aspect.JoinPointConfig.businessLayerPointcut()",
            throwing = "exception", argNames = "joinPoint,exception")
    public void LogAfterException(JoinPoint joinPoint, Object exception) {
        logger.info("Method {} returned with: {}", joinPoint, exception);
    }

    @After("com.rodion.educative.spring_5_and_spring_boot_2.spring_aop.aspect.JoinPointConfig.businessLayerPointcut()")
    public void LogAfterMethod(JoinPoint joinPoint) {
        logger.info("After method call {}", joinPoint);
    }
}