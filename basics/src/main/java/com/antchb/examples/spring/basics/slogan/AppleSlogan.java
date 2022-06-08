package com.antchb.examples.spring.basics.slogan;

import org.springframework.stereotype.Component;

@Component
public class AppleSlogan implements ISlogan {

    @Override
    public String getSlogan() {
        return "Think different!";
    }

}
