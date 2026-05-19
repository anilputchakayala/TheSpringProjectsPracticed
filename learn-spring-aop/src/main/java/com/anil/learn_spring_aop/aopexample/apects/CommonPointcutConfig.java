package com.anil.learn_spring_aop.aopexample.apects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {

    @Pointcut("execution(* com.anil.learn_spring_aop.aopexample.*.*.*(..))")
    public void businessAndDataPackageConfig(){}

    @Pointcut("bean(*Service*)")
    public void allPackageConfigUsingBean() {}

    @Pointcut("@annotation(com.anil.learn_spring_aop.aopexample.annotations.TrackTime)")
    public void trackTimeAnnotation() {}
}
