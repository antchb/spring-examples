package com.antchb.examples.spring.basics.sport_event;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.antchb.examples.spring.basics.slogan.ISlogan;

// Empty value will make this id as "hockeyEvent"
@Component("hockeyEventBeanId")
public class HockeyEvent implements ISportEvent {

    private ISlogan slogan;
    
    @Value("${contact.name}")
    private String contactName;

    public HockeyEvent() { }

    @Override
    public String getDescription() {
        return "Ice hockey (or simply hockey) is a winter team sport played on ice skates, usually on an ice skating " +
               "rink with lines and markings specific to the sport. In ice hockey, two opposing teams use ice hockey " +
               "sticks to control, advance and shoot a closed, vulcanized, rubber disc called a 'puck' into the other " +
               "team's goal. Each goal is worth one point. The team which scores the most goals is declared " +
               "the winner. In a formal game, each team has six skaters on the ice at a time, barring any penalties, " +
               "one of whom is the goaltender. Ice hockey is a full contact sport";
    }
    
    @Override
    public String getSlogan() {
        return slogan != null ? slogan.getSlogan() : "";
    }

    public String getContactName() {
        return contactName;
    }
}
