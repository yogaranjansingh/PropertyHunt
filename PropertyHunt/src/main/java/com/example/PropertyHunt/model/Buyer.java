package com.example.PropertyHunt.model;

import lombok.Data;

import java.util.List;

@Data
public class Buyer extends User {

    List<Property> shortlistedProperties;

    public List<Property> getShortlistedProperties() {
        return shortlistedProperties;
    }

    public void setShortlistedProperties(List<Property> shortlistedProperties) {
        this.shortlistedProperties = shortlistedProperties;
    }

    public Buyer(String name, String email, UserType userType, List<Property> shortlistedProperties) {
        super(name, email, userType);
        this.shortlistedProperties = shortlistedProperties;
    }

    public Buyer(List<Property> shortlistedProperties) {
        this.shortlistedProperties = shortlistedProperties;
    }

    public Buyer() {super();}
}
