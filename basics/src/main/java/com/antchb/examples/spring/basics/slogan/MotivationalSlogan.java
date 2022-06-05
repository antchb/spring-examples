package com.antchb.examples.spring.basics.slogan;

public class MotivationalSlogan implements ISlogan {

    @Override
    public String getSlogan() {
        return "Don't tell people your dreams, show them";
    }

}
