package com.anil.learn_spring_aop.aopexample.apects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceTrackingAspect {

    private static final Logger log = LoggerFactory.getLogger(PerformanceTrackingAspect.class);

    //@Around("com.anil.learn_spring_aop.aopexample.apects.CommonPointcutConfig.businessAndDataPackageConfig()")
    @Around("com.anil.learn_spring_aop.aopexample.apects.CommonPointcutConfig.trackTimeAnnotation()")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // Start Timer
        long startTimeMillis = System.currentTimeMillis();

        // Execute Method
        Object returnValue = proceedingJoinPoint.proceed();

        // Stop Timer
        long stopTimeMillis = System.currentTimeMillis();
        long executionDuration = stopTimeMillis - startTimeMillis;
        log.info("Around Aspect - {} method executed in {} ms", proceedingJoinPoint, executionDuration);

        return returnValue;

    }
}
