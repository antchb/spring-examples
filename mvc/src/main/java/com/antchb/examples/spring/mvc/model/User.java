package com.antchb.examples.spring.mvc.model;

public class User {

    private String firstName;
    private String lastName;
    private String sex;
    private String country;

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

    @Override
    public String toString() {
        return "User [country=" + country + ", firstName=" + firstName + ", lastName=" + lastName + ", sex=" + sex
                + "]";
    }

}
