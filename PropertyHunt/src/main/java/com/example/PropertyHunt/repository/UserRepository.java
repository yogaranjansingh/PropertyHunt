package com.example.PropertyHunt.repository;

import com.example.PropertyHunt.model.*;

public interface UserRepository {

    public User getUserById(int userId);
    public void addUser(User user);

}
