package com.anil.learn_spring_framework.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PacMan implements GamingConsole {

    private static final Logger log = LoggerFactory.getLogger(PacMan.class);

    @Override
    public void up() {
        log.info("Pacman will eat all dots");
    }

    @Override
    public void down() {
        log.info("Pacman will die");
    }

    @Override
    public void left() {
        log.info("Pacman will eat all ghosts");
    }

    @Override
    public void right() {
        log.info("Pacman will go to next level");
    }
}
