package com.antchb.examples.spring.basics.sport_event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.antchb.examples.spring.basics.slogan.ISlogan;

@Component
@Scope("prototype")
public class BoxingEvent implements ISportEvent {

    @Autowired
    @Qualifier("fileRandomSlogan")
    private ISlogan slogan;

    public BoxingEvent() { }

    @Override
    public String getDescription() {
        return "Boxing (also known as 'Western boxing' or 'pugilism') is a combat sport in which two people, usually " +
               "wearing protective gloves and other protective equipment such as hand wraps and mouthguards, throw " +
               "punches at each other for a predetermined amount of time in a boxing ring";
    }
    
    @Override
    public String getSlogan() {
        return slogan != null ? slogan.getSlogan() : "";
    }

}
