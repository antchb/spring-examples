package com.antchb.examples.spring.basics.sport_event;

import com.antchb.examples.spring.basics.slogan.ISlogan;

public class BasketballEvent implements ISportEvent {

    private ISlogan slogan;

    public BasketballEvent(ISlogan slogan) {
        this.slogan = slogan;
    }

    @Override
    public String getDescription() {
        return "Basketball is a team sport in which two teams, most commonly " + 
               "of five players each, opposing one another on a rectangular court, " +
               "compete with the primary objective of shooting a basketball  " + 
               "(approximately 9.4 inches (24 cm) in diameter) through the defender's hoop " + 
               "(a basket 18 inches (46 cm) in diameter mounted 10 feet (3.048 m) high to " +
               "a backboard at each end of the court, while preventing the opposing team from " +
               "shooting through their own hoop";
    }

    @Override
    public String getSlogan() {
        return slogan != null ? slogan.getSlogan() : "";
    }

}
