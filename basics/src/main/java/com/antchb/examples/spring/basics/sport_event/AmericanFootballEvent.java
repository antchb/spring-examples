package com.antchb.examples.spring.basics.sport_event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.antchb.examples.spring.basics.slogan.ISlogan;

@Component
public class AmericanFootballEvent implements ISportEvent {

    private ISlogan slogan;

    public AmericanFootballEvent() { }

    // Method Injection can be applied for any method!
    @Autowired
    public void setSlogan(ISlogan slogan) {
        System.out.println("Setting a slogan inside a setter method...");
        this.slogan = slogan;
    }

    @Override
    public String getDescription() {
        return "American football, referred to simply as football in the United States and Canada, and also " +
               "known as gridiron, is a team sport played by two teams of eleven players on a rectangular field " +
               "with goalposts at each end. The offense, the team with possession of the oval-shaped football, " +
               "attempts to advance down the field by running with the ball or passing it, while the defense, the " +
               "team without possession of the ball, aims to stop the offense's advance and to take control of the " +
               "ball for themselves. The offense must advance at least ten yards in four downs or plays; if they " +
               "fail, they turn over the football to the defense, but if they succeed, they are given a new set of " +
               "four downs to continue the drive. Points are scored primarily by advancing the ball into the " +
               "opposing team's end zone for a touchdown or kicking the ball through the opponent's goalposts for " +
               "a field goal. The team with the most points at the end of a game wins";
    }
    
    @Override
    public String getSlogan() {
        return slogan != null ? slogan.getSlogan() : "";
    }

}
