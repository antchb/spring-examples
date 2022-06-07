package com.antchb.examples.spring.basics.slogan;

import org.springframework.stereotype.Component;

@Component
public class ManchesterSlogan implements ISlogan {

    @Override
    public String getSlogan() {
        return "Concilio et Labore (Wisdom and Effort)";
    }

}
