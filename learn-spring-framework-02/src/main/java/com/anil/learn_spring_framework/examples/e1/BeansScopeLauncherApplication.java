package com.anil.learn_spring_framework.examples.e1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
public class BeansScopeLauncherApplication {

    public static void main(String[] args) {

        try(var context =
                new AnnotationConfigApplicationContext(BeansScopeLauncherApplication.class)){
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
        }
    }
}
