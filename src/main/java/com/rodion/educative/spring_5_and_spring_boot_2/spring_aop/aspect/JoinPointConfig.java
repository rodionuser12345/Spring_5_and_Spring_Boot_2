package com.rodion.educative.spring_5_and_spring_boot_2.spring_aop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class JoinPointConfig {

    @Pointcut("execution(* com.rodion.educative.spring_5_and_spring_boot_2.spring_aop.data.*.*(..))")
    public void dataLayerPointcut() {
    }

    @Pointcut("execution(* com.rodion.educative.spring_5_and_spring_boot_2.spring_aop.business.*.*(..))")
    public void businessLayerPointcut() {
    }

    @Pointcut("com.rodion.educative.spring_5_and_spring_boot_2.spring_aop.aspect.JoinPointConfig.dataLayerPointcut() " +
            "|| com.rodion.educative.spring_5_and_spring_boot_2.spring_aop.aspect.JoinPointConfig.businessLayerPointcut()")
    public void allLayerPointcut() {
    }

    @Pointcut("bean(movie*)")
    public void movieBeanPointcut() {
    }

    @Pointcut("@annotation(com.rodion.educative.spring_5_and_spring_boot_2.spring_aop.aspect.MeasureTime)")
    public void measureTimeAnnotation() {
    }
}
