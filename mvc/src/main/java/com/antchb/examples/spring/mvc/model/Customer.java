package com.antchb.examples.spring.mvc.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Customer {

    @NotNull(message = "Required and cannot have only white spaces")
    @Size(min = 1, message = "Required field!")
    private String firstName;

    @NotNull(message = "Required and cannot have only white spaces")
    @Size(min = 1, message = "Required field!")
    private String lastName;

    @Min(value=18, message="You must be 18 or older")
    @Max(value=200, message="Please, enter correct age")
    private Integer age;

    @Pattern(regexp="^[a-zA-Z0-9]{5}", message="Must have only 5 characters/digits")
    private String postalCode;
    
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Customer [age=" + age + ", firstName=" + firstName + ", lastName=" + lastName + ", postalCode="
                + postalCode + "]";
    }

}