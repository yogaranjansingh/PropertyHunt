package com.example.PropertyHunt.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

//@JsonSubTypes({
//        @JsonSubTypes.Type(value = Owner.class,name = "owner"),
//        @JsonSubTypes.Type(value = Buyer.class,name = "buyer")
//})
@JsonDeserialize(as = Owner.class)
public abstract class User {

    static int counter = 1;

    public User(String name, String email, UserType userType) {
        this.id = counter++;
        this.name = name;
        this.email = email;
        this.userType = userType;
    }

    public User()
    {
        super();
        this.id = counter++;
    }

    private int id;
    private String name;
    private String email;
    private UserType userType;

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", userType=" + userType +
                '}';
    }
}
