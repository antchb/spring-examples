package com.antchb.examples.spring.mvc.model;

import java.util.Arrays;

public class User {

    private String firstName;
    private String lastName;
    private String sex;
    private String country;
    private String type;
    private String[] operatingSystems;

    public User() { }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(String[] operatingSystems) {
        this.operatingSystems = operatingSystems;
    }

    @Override
    public String toString() {
        return "User [country=" + country + ", firstName=" + firstName + ", lastName=" + lastName
                + ", operatingSystems=" + Arrays.toString(operatingSystems) + ", sex=" + sex + ", type=" + type + "]";
    }

}
