package com.anil.learn_spring_framework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class GamingAppLauncherApplication {

//    @Bean
//    public GamingConsole game(){
//        return new PacMan();
//    }

//    @Bean
//    public GameRunner gameRunner(GamingConsole game){
//        return new GameRunner(game);
//    }

    public static void main(String[] args) {

        try(var context =
                new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)){
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }
    }
}
