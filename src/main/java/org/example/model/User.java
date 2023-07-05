package org.example.model;

import java.util.Date;

public class User {
    private int user_id;
    private String lastName;
    private String firstName;
    private Date birthDate;
    private Boolean gender;
    private Integer totalLoad;
    private Double monotony;
    private Double strain;
    private Double fitness;
    private double acwr;


    public User(String lastName, String firstName, Date birthDate, Boolean gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Boolean getGender() {
        return gender;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }
}
