package com.antchb.examples.spring.basics.slogan;

import java.util.List;
import java.util.Random;

public class RandomSlogan implements ISlogan {
    
    private List<ISlogan> slogans;

    public RandomSlogan(List<ISlogan> slogans) {
        this.slogans = slogans;
    }

    @Override
    public String getSlogan() {
        String slogan;

        if (slogans != null && !slogans.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(slogans.size());
            slogan = slogans.get(randomIndex).getSlogan();
        } else {
            slogan = "No Words. Just do it!";
        }

        return slogan;
    }

}
