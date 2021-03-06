package com.antchb.examples.spring.basics.sport_event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.antchb.examples.spring.basics.slogan.ISlogan;

// Empty value will make this id as "footballEvent"
// If the first two characters are uppercase, then the name is NOT converted
@Component
public class FootballEvent implements ISportEvent {

    private ISlogan slogan;

    // As of Spring Framework 4.3, an @Autowired annotation on such a constructor is no longer necessary 
    // if the target bean only defines one constructor to begin with. However, if several constructors are available, 
    // at least one must be annotated to teach the container which one to use.
    @Autowired
    public FootballEvent(@Qualifier("manchesterSlogan") ISlogan slogan) {
        this.slogan = slogan;
    }

    @Override
    public String getDescription() {
        return "Association football, more commonly known as soccer or just football, is a team sport " +
               "that is played between two teams of 11 players using a spherical ball. It is played by " +
               "approximately 250 million players in over 200 countries and dependencies, making it the world's " +
               "most popular sport to date. The game is played on a rectangular field called a pitch " +
               "with a goal at each end. The objective of the game is to score more goals than the opposition " +
               "by moving the ball beyond the goal line into the opposing goal within a time frame of 90 minutes or more";
    }

    @Override
    public String getSlogan() {
        return slogan != null ? slogan.getSlogan() : "";
    }

}
