package org.example.model;

import java.util.Date;

public class User {
    private int user_id;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private Date birthDate;
    private final Boolean gender;


    public User(int user_id, String lastName, String firstName, Date birthDate, Boolean gender, String email, String password) {
        this.user_id = user_id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }

    public int getUser_id() {
        return user_id;
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

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
    	this.password = password;
    }
}
