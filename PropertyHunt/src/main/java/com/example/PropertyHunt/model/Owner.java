package com.example.PropertyHunt.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Owner extends User{
    List<Property> listedProperties;

    public List<Property> getListedProperties() {
        return listedProperties;
    }

    public void setListedProperties(List<Property> listedProperties) {
        this.listedProperties = listedProperties;
    }

    public Owner(String name, String email, UserType userType, List<Property> listedProperties) {
        super(name, email, userType);
        this.listedProperties = listedProperties;
    }

    public Owner(List<Property> listedProperties) {
        this.listedProperties = listedProperties;
    }

    public Owner() {
    	super();
    	this.listedProperties = new ArrayList<Property>();
    }
}
