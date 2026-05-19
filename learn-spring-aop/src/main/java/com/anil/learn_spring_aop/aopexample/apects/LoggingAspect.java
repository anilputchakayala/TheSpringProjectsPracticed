package com.anil.learn_spring_aop.aopexample.apects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("com.anil.learn_spring_aop.aopexample.apects.CommonPointcutConfig.businessAndDataPackageConfig()")
    public void logMethodCallBeforeExecution(JoinPoint joinPoint){
        log.info("Before Aspect - {} is called with args {} ", joinPoint, joinPoint.getArgs());
    }

    @After("com.anil.learn_spring_aop.aopexample.apects.CommonPointcutConfig.allPackageConfigUsingBean()")
    public void logMethodCallAfterExecution(JoinPoint joinPoint){
        log.info("After Aspect - {} has executed ", joinPoint);
    }

    @AfterThrowing(
            pointcut = "com.anil.learn_spring_aop.aopexample.apects.CommonPointcutConfig.businessAndDataPackageConfig()",
            throwing = "exception"
    )
    public void logMethodCallAfterThrowing(JoinPoint joinPoint, Exception exception){
        log.info("After Throwing Aspect - {} has thrown an exception {} ",
                joinPoint, exception.getMessage());
    }

    @AfterReturning(
            pointcut = "com.anil.learn_spring_aop.aopexample.apects.CommonPointcutConfig.businessAndDataPackageConfig()",
            returning = "resultValue"
    )
    public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint, Object resultValue){
        log.info("After Returning Aspect - {} has returned successfully {} ",
                joinPoint, resultValue);
    }
}
