package com.anil.learn_spring_framework.examples.f1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Component
class SomeClass {
    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency){
        super();
        this.someDependency = someDependency;
        System.out.println("All Dependencies are ready");
    }

    @PostConstruct
    public void initialize(){
        someDependency.getReady();
    }

    @PreDestroy
    public void cleanUp(){
        System.out.println("Cleaning things up");
    }
}

@Component
class SomeDependency {

    public void getReady() {
        System.out.println("Some logic using dependency");
    }
}

@Configuration
@ComponentScan
public class PrePostContextLauncherApplication {

    public static void main(String[] args) {

        try(var context =
                new AnnotationConfigApplicationContext(PrePostContextLauncherApplication.class)){
            System.out.println("Spring context started");
//            Arrays.stream(context.getBeanDefinitionNames())
//                    .forEach(System.out::println);
        }
    }
}
