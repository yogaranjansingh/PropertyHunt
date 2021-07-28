package com.example.PropertyHunt.service;

import com.example.PropertyHunt.exception.InvalidUserActionException;
import com.example.PropertyHunt.model.Property;
import com.example.PropertyHunt.model.User;
import com.example.PropertyHunt.model.UserType;

import java.util.List;

public interface UserService {
    void addUser(User user);

    User getUserById(int userId, UserType userType);

    List<Property> getShortListedProperties(int userId);

    List<Property> getSoldProperties(int userId);

    List<Property> getListedProperties(int userId) throws InvalidUserActionException;
}
