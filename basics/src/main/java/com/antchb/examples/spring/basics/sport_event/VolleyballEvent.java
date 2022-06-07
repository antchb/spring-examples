package com.antchb.examples.spring.basics.sport_event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.antchb.examples.spring.basics.slogan.ISlogan;

@Component
public class VolleyballEvent implements ISportEvent {

    @Autowired
    private ISlogan slogan;

    public VolleyballEvent() { }

    @Override
    public String getDescription() {
        return "Volleyball is a team sport in which two teams of six players are separated by a net. Each team " +
               "tries to score points by grounding a ball on the other team's court under organized rules. " +
               "It has been a part of the official program of the Summer Olympic Games since Tokyo 1964. " +
               "Beach volleyball was introduced to the programme at the Atlanta 1996";
    }
    
    @Override
    public String getSlogan() {
        return slogan != null ? slogan.getSlogan() : "";
    }

}
