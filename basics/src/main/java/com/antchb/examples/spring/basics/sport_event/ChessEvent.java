package com.antchb.examples.spring.basics.sport_event;

import org.springframework.beans.factory.DisposableBean;

import com.antchb.examples.spring.basics.slogan.ISlogan;

public class ChessEvent implements ISportEvent, DisposableBean {

    private ISlogan slogan;
    private String contactName;

    public ChessEvent() { }

    public ChessEvent(ISlogan slogan) {
        this.slogan = slogan;
    }

    @Override
    public String getDescription() {
        return "Chess is a board game played between two players";
    }

    @Override
    public String getSlogan() {
        return slogan != null ? slogan.getSlogan() : "";
    }

    public void setSlogan(ISlogan slogan) {
        System.out.println("Setting a slogan for ChessEvent...");
        this.slogan = slogan;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactName() {
        return contactName;
    }

    public void userInitMethod() {
        System.out.println("Inside user's init. method... The last step of initialization");
    }

    public void userDestroyMethod() {
        System.out.println("Inside user's destroy method...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Inside user's destroy method for a prototype bean! Called by a custom bean processor");
    }
}
